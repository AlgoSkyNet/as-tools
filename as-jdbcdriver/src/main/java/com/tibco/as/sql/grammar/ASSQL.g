grammar ASSQL;

options {
  language = Java;
}

@header {
package com.tibco.as.sql.grammar;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.HashMap;
import com.tibco.as.sql.*;
import com.tibco.as.space.Tuple;
}

@members {
    // Column information <column_name, table_name, alias>
    private List<Tuple> columnInfo = new ArrayList<Tuple>();
    private void addColumnInfo(String cname, String tname, String calias)
    {
        Tuple columnTuple = Tuple.create();
        columnTuple.put(ASSQLUtils.COLUMN_NAME, cname);
        columnTuple.put(ASSQLUtils.TABLE_NAME, tname);
        columnTuple.put(ASSQLUtils.COLUMN_ALIAS, calias);
        columnInfo.add(columnTuple);
    }
    
    // FieldDef information for creating tables/spaces
    private ArrayList<Tuple> columnDefs = new ArrayList<Tuple>();
    private void addColumnDef(String fieldName, String dataType, String notNull, String pkey, String pkeyType)
    {
        Tuple tuple = Tuple.create();
        tuple.put(ASSQLUtils.COLUMN_NAME, fieldName);
        tuple.put(ASSQLUtils.COLUMN_TYPE, dataType);
        if (notNull != null)
            tuple.put(ASSQLUtils.NULL_CONSTRAINT, notNull);
        if (pkey != null)
        {
            tuple.put(ASSQLUtils.PKEY_CONSTRAINT, pkey);
            if (pkeyType != null)
                tuple.put(ASSQLUtils.PKEY_TYPE, pkeyType);
        }
        columnDefs.add(tuple);
    }
    
    // List of columns which are primary keys for creating tables/spaces
    private String pkeyType = "hash";
    private ArrayList<String> pkeyList = new ArrayList<String>();
    
    private ArrayList<ASSQLIndex> indexList = new ArrayList<ASSQLIndex>();

    // error handling
    private ArrayList<String> recognitionErrors = new ArrayList<String>();

    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        recognitionErrors.add(hdr + " " + msg);
    }
    
    public void throwFirstRecognitionError() throws SQLException
    {
        if (recognitionErrors.size() > 0)
            throw new SQLRecoverableException(recognitionErrors.get(0));
    }
}

@lexer::header {
package com.tibco.as.sql.grammar;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
}

@lexer::members {
    private List<String> recognitionErrors = new ArrayList<String>();

    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        recognitionErrors.add(hdr + " " + msg);
    }
    
    public void throwFirstRecognitionError() throws SQLException
    {
        if (recognitionErrors.size() > 0)
            throw new SQLSyntaxErrorException(recognitionErrors.get(0));
    }
}

query returns [ASSQLStatement stmnt]
    : createStatement  endStmnt {$stmnt = $createStatement.expr; }
    | deleteStatement  endStmnt {$stmnt = $deleteStatement.expr; }
    | insertStatement  endStmnt {$stmnt = $insertStatement.expr; }
    | selectStatement  endStmnt {$stmnt = $selectStatement.expr; }
    | updateStatement  endStmnt {$stmnt = $updateStatement.expr; }
    ;

createStatement returns [CreateStatement expr]
    : {
          // ActiveSpaces properties for defining a table/space
          java.util.Properties sdprops = new java.util.Properties();
      }
      CREATE TABLE target_table
      OParen table_element (Comma table_element)* CParen
      (c=space_property {sdprops.put($c.key, $c.value);} (Comma d=space_property {sdprops.put($d.key, $d.value);})* )*
      {
          return new CreateStatement($target_table.arg, columnDefs, pkeyType, pkeyList, sdprops, indexList);
      }
    ;

deleteStatement returns [DeleteStatement expr]
    : DELETE FROM target_table
      (WHERE where_condition)?
      {
          return new DeleteStatement($target_table.arg, $where_condition.arg);
      }
    ;

insertStatement returns [InsertStatement expr]
    : {
          List<String> columnNames = new ArrayList<String>();
          List<String> columnValues = new ArrayList<String>();
      }
      INSERT INTO table_name
      OParen c=column_name {columnNames.add($c.text);} ( Comma d=column_name {columnNames.add($d.text);} )* CParen
      VALUES OParen e=column_value {columnValues.add($e.text);} ( Comma f=column_value {columnValues.add($f.text);} )* CParen
      {
          return new InsertStatement($table_name.text, columnNames, columnValues);
      }
    ;

selectStatement returns [SelectStatement expr]
    : SELECT (select_quantifier)?
      select_list
      //INTO select_target_list
      FROM table_reference_list
      (WHERE where_condition)?
      (LIMIT limit_clause)?
      //(group_clause)?
      //(set_clause)?
      //(order_clause)?
      //(update_clause)?
      {
          return new SelectStatement($select_quantifier.text, columnInfo, $table_reference_list.tableNames, $where_condition.arg);
      }
    ;

updateStatement returns [UpdateStatement expr]
    : {
          HashMap<String,String> cValues = new HashMap<String,String>();
      }
      UPDATE target_table
      SET a=set_clause { cValues.put($a.cname, $a.cvalue); }
         (Comma b=set_clause { cValues.put($b.cname, $b.cvalue); } )*
      (WHERE where_condition)?
      {
          return new UpdateStatement($target_table.arg, cValues, $where_condition.arg);
      }
    ;

alias
    : Identifier
    ;

column_def
    : {
          String not_null = null;
          String pkey = null;
          String pkey_type = null;
      }
      column_name column_type
      (
        NOT_NULL { not_null = "true"; }
      | PRIMARY_KEY { pkey = "true"; }  (key_type { pkey_type = $key_type.text.toLowerCase(); })?
      )*
      {
          addColumnDef($column_name.text, $column_type.type, not_null, pkey, pkey_type);
      }
    ;

column_name
    : Identifier
    ;

column_type returns [String type]
    : BIT         { $type = "boolean"; }
    | CHAR        { $type = "char"; } 
    | CHAR1       { $type = "char"; }
    | CHAR OParen PositiveNumber CParen { $type = "string"; }
    | VARCHAR     { $type = "string"; }
    | VARCHAR OParen PositiveNumber CParen { $type = "string"; }
    | LONGVARCHAR { $type = "string"; }
    | LONGVARCHAR OParen PositiveNumber CParen { $type = "string"; }
    | SMALLINT    { $type = "short"; }
    | INTEGER     { $type = "integer"; }
    | BIGINT      { $type = "long"; }
    | REAL        { $type = "float"; }
    | DOUBLE      { $type = "double"; }
    | BLOB        { $type = "blob"; }
    | DATETIME    { $type = "datetime"; }
    | DATE        { $type = "datetime"; }
    | TIME        { $type = "datetime"; }
    | TIMESTAMP   { $type = "datetime"; }
    ;

column_value
    :   QuotedString
    |   PositiveNumber
    |   NegativeNumber
    |   Float
    |   NULL
    ;

endStmnt
    : SColon?  EOF
    ;

key_type
    : HASH
    | TREE
    ;

limit_clause
    : PositiveNumber OFFSET PositiveNumber
    | (PositiveNumber Comma) PositiveNumber
    ;

relation returns [String arg]
    : a=rterm type=(Equals | NotEquals | GThan | GTEquals | LThan | LTEquals) b=rterm {$arg = $a.text + $type.text + $b.text;}
    | c=relation_null {$arg = $c.arg;}
    | d=relation_not {$arg = $d.arg;}
    ;

relation_null returns [String arg]
    : Identifier IS_NULL {$arg = $Identifier.text + " IS NULL";}
    | Identifier IS_NOT_NULL {$arg = $Identifier.text + " IS NOT NULL";}
    ;

relation_not returns [String arg]
    : a=Identifier NOT b=column_value {$arg = $a.text + " NOT " + $b.text;} (NOR c=column_value {$arg += " NOR " + $c.text;})?
    ;
            
rterm_list
    : rterm (Comma rterm)*
    ;

rterm
    : Identifier
    | QMark
    | column_value
    ;

schema_name
    : Identifier
    ;
        
select_column returns [String cname, String tname, String calias]
    : (table_name Dot { $tname = $table_name.text; } )? column_name { $cname = $column_name.text; }
      (AS alias { $calias = $alias.text; })?
    ;

select_column_list
    : a=select_column { addColumnInfo($a.cname, $a.tname, $a.calias); }
      (Comma b=select_column { addColumnInfo($b.cname, $b.tname, $b.calias); })*
    ;

select_list
    : Asterisk { addColumnInfo($Asterisk.text,null,null); }
    | a=table_name Dot b=Asterisk { addColumnInfo($b.text, $a.text, null); }
      (Comma c=table_name Dot d=Asterisk { addColumnInfo($d.text, $c.text, null); })*
    | select_column_list
    ;

select_quantifier
    : ALL
    | DISTINCT
    ;

set_clause returns [String cname, String cvalue]
    : c=column_name Equals v=column_value { $cname = $c.text; $cvalue = $v.text; }
    ;

space_property returns [String key, String value]
    : (   space_capacity { $key = $space_capacity.key; $value = $space_capacity.value; }
        | space_distribution_policy { $key = $space_distribution_policy.key; $value = $space_distribution_policy.value; }
        | space_eviction_policy { $key = $space_eviction_policy.key; $value = $space_eviction_policy.value; }
        | space_lock_scope { $key = $space_lock_scope.key; $value = $space_lock_scope.value; }
        | space_lock_ttl { $key = $space_lock_ttl.key; $value = $space_lock_ttl.value; }
        | space_lock_wait { $key = $space_lock_wait.key; $value = $space_lock_wait.value; }
        | space_min_seeders { $key = $space_min_seeders.key; $value = $space_min_seeders.value; }
        | space_persistence_policy { $key = $space_persistence_policy.key; $value = $space_persistence_policy.value; }
        | space_persistence_type { $key = $space_persistence_type.key; $value = $space_persistence_type.value; }
        | space_phase_count { $key = $space_phase_count.key; $value = $space_phase_count.value; }
        | space_phase_interval { $key = $space_phase_interval.key; $value = $space_phase_interval.value; }
        | space_read_timeout { $key = $space_read_timeout.key; $value = $space_read_timeout.value; }
        | space_replication_count { $key = $space_replication_count.key; $value = $space_replication_count.value; }
        | space_replication_policy { $key = $space_replication_policy.key; $value = $space_replication_policy.value; }
        | space_ttl { $key = $space_ttl.key; $value = $space_ttl.value; }
        | space_update_transport { $key = $space_update_transport.key; $value = $space_update_transport.value; }
        | space_wait { $key = $space_wait.key; $value = $space_wait.value; }
        | space_write_timeout { $key = $space_write_timeout.key; $value = $space_write_timeout.value; }
      )
    ;

space_capacity returns [String key, String value]
    @init { $key = CreateStatement.CAPACITY; }
    : CAPACITY ( NegativeNumber { $value = $NegativeNumber.text; } | PositiveNumber { $value = $PositiveNumber.text; } )
    ;
     
space_distribution_policy returns [String key, String value]
    @init { $key = CreateStatement.DISTRIBUTION_POLICY; }
    : DISTRIBUTION_POLICY a=DISTRIBUTED { $value = $a.text.toLowerCase(); }
    | DISTRIBUTION_POLICY b=NON_DISTRIBUTED { $value = $b.text.toLowerCase(); }
    ;
    
space_eviction_policy returns [String key, String value]
    @init { $key = CreateStatement.EVICTION_POLICY; }
    : EVICTION_POLICY NONE { $value = $NONE.text.toLowerCase(); }
    | EVICTION_POLICY LRU { $value = $LRU.text.toLowerCase(); }
    ;

space_lock_scope returns [String key, String value]
    @init { $key = CreateStatement.LOCK_SCOPE; }
    : LOCK_SCOPE THREAD { $value = $THREAD.text.toLowerCase(); }
    | LOCK_SCOPE PROCESS { $value = $PROCESS.text.toLowerCase(); }
    ;

space_lock_ttl returns [String key, String value]
    @init { $key = CreateStatement.LOCK_TTL; }
    : LOCK_TTL ( NegativeNumber { $value = $NegativeNumber.text; } | PositiveNumber { $value = $PositiveNumber.text; } )
    ;

space_lock_wait returns [String key, String value]
    @init { $key = CreateStatement.LOCK_WAIT; }
    : LOCK_WAIT ( NegativeNumber { $value = $NegativeNumber.text; } | PositiveNumber { $value = $PositiveNumber.text; } )
    ;
 
space_min_seeders returns [String key, String value]
    @init { $key = CreateStatement.MIN_SEEDERS; }
    : MIN_SEEDERS PositiveNumber { $value = $PositiveNumber.text; }
    ;
    
space_persistence_policy returns [String key, String value]
    @init { $key = CreateStatement.PERSISTENCE_POLICY; }
    : PERSISTENCE_POLICY SYNC { $value = $SYNC.text.toLowerCase(); }
    | PERSISTENCE_POLICY ASYNC { $value = $ASYNC.text.toLowerCase(); }
    ;
  
space_persistence_type returns [String key, String value]
    @init { $key = CreateStatement.PERSISTENCE_TYPE; }
    : PERSISTENCE a=NONE { $value = $a.text.toLowerCase(); }
    | PERSISTENCE b=(SHARED_ALL) { $value = $b.text.toLowerCase(); }
    | PERSISTENCE c=(SHARED_NOTHING) { $value = $c.text.toLowerCase(); }
    | PERSISTENCE_TYPE d=NONE { $value = $d.text.toLowerCase(); }
    | PERSISTENCE_TYPE e=(SHARED_ALL) { $value = $e.text.toLowerCase(); }
    | PERSISTENCE_TYPE f=(SHARED_NOTHING) { $value = $f.text.toLowerCase(); }

    ;

space_phase_count returns [String key, String value]
    @init { $key = CreateStatement.PHASE_COUNT; }
    : PHASE_COUNT ( NegativeNumber { $value = $NegativeNumber.text; } | PositiveNumber { $value = $PositiveNumber.text; } )
    ;

space_phase_interval returns [String key, String value]
    @init { $key = CreateStatement.PHASE_INTERVAL; }
    : PHASE_INTERVAL PositiveNumber { $value = $PositiveNumber.text; }
    ;

space_read_timeout returns [String key, String value]
    @init { $key = CreateStatement.READ_TIMEOUT; }
    : READ_TIMEOUT PositiveNumber { $value = $PositiveNumber.text; }
    ;

space_replication_count returns [String key, String value]
    @init { $key = CreateStatement.REPLICATION_COUNT; }
    : REPLICATION_COUNT PositiveNumber { $value = $PositiveNumber.text; }
    ;

space_replication_policy returns [String key, String value]
    @init { $key = CreateStatement.REPLICATION_POLICY; }
    : REPLICATION_POLICY SYNC { $value = $SYNC.text.toLowerCase(); }
    | REPLICATION_POLICY ASYNC { $value = $ASYNC.text.toLowerCase(); }
    ;

space_ttl returns [String key, String value]
    @init { $key = CreateStatement.TTL; }
    : TTL ( NegativeNumber { $value = $NegativeNumber.text; } | PositiveNumber { $value = $PositiveNumber.text; } )
    ;

space_update_transport returns [String key, String value]
    @init { $key = CreateStatement.UPDATE_TRANSPORT; }
    : UPDATE_TRANSPORT UNICAST { $value = $UNICAST.text.toLowerCase(); }
    | UPDATE_TRANSPORT MULTICAST { $value = $MULTICAST.text.toLowerCase(); }
    ;

space_wait returns [String key, String value]
    @init { $key = CreateStatement.SPACE_WAIT; }
    : SPACE_WAIT PositiveNumber { $value = $PositiveNumber.text; }
    ;

space_write_timeout returns [String key, String value]
    @init { $key = CreateStatement.WRITE_TIMEOUT; }
    : WRITE_TIMEOUT PositiveNumber { $value = $PositiveNumber.text; }
    ;
    
table_constraint
    : PRIMARY_KEY (key_type {pkeyType = $key_type.text; })? 
      OParen a=column_name { pkeyList.add($a.text); } 
      ( Comma b=column_name { pkeyList.add($b.text); } )* CParen
    ;

table_constraint_def
    : (CONSTRAINT Identifier)? table_constraint
    ;

table_element
    : column_def
    | table_constraint_def
    | table_index { indexList.add($table_index.index); }
    ;

table_index returns [ASSQLIndex index]
    : {
          String type = null;
      }
      INDEX table_index_name (key_type {type = $key_type.text;})? table_index_list
      {
          return new ASSQLIndex($table_index_name.text, type, $table_index_list.indexColumns);
      }
    ;

table_index_list returns [ArrayList<String> indexColumns]
    : {
          $indexColumns = new ArrayList<String>();
      }
      OParen a=column_name { $indexColumns.add($a.text); } (Comma b=column_name { $indexColumns.add($b.text); })* CParen
    ;
 
table_index_name
    : Identifier
    ;

table_name
    : Identifier
    ;

table_reference_list returns [List<String> tableNames]
    : {
          $tableNames = new ArrayList<String>();
      }
      a=table_name {tableNames.add($a.text);}( Comma b=table_name {tableNames.add($b.text);})*
    ;

target_table returns [String arg]
    : table_name { $arg = $table_name.text; }
    | ONLY OParen table_name CParen { $arg = $table_name.text; }
    ;

where_condition returns [String arg]
    : a=where_relation       {$arg = $a.arg;}
    | b=where_relation_group {$arg = $b.arg;}
    | c=where_relation AND d=where_relation_group {$arg = $c.arg + " AND " + $d.arg;}
    | e=where_relation OR f=where_relation_group {$arg = $e.arg + " OR " + $f.arg;}
    | g=where_relation_group OR h=where_relation_group {$arg = $g.arg + " OR " + $h.arg;}
    | i=where_relation_group AND j=where_relation_group {$arg = $i.arg + " AND " + $j.arg;}
    | rterm IN OParen rterm_list CParen { $arg = $rterm.text + " IN (" + $rterm_list.text + ")"; }
    ;

where_relation returns [String arg]
    : a=relation {$arg = $a.arg;}
    | b=relation {$arg = $b.arg;} (AND c=relation {$arg += " AND " + $c.arg;})+
    | d=relation {$arg = $d.arg;} (OR e=relation {$arg += " OR " + $e.arg;})+
    ;
     
where_relation_group returns [String arg]
    : OParen a=where_relation CParen {$arg = "(" + $a.arg + ")";}
    ;


// lexer rules

Asterisk   : '*';
Dot        : Period;
OParen     : '(';
CParen     : ')';
Comma      : ',';
SColon     : ';';
QMark      : '?';
Plus       : '+';
Minus      : '-';
Divide     : '/';
DVertbar   : '||';
Range      : '..';
Equals     : '=';
NotEquals  : '!=';
GThan      : '>';
GTEquals   : '>=';
LThan      : '<';
LTEquals   : '<=';
Underscore : '_';

// case insensitive keywords

// SQL commands
CREATE : C R E A T E;
SELECT : S E L E C T;
INSERT : I N S E R T;
UPDATE : U P D A T E;
DELETE : D E L E T E;

// SQL keywords
ALL          : A L L;
AND          : A N D;
AS           : A S;
BIGINT       : B I G I N T;
BIT          : B I T;
BLOB         : B L O B;
CHAR         : C H A R;
CHAR1        : C H A R OParen '1' CParen;
CONSTRAINT   : C O N S T R A I N T;
DATE         : D A T E;
DATETIME     : D A T E T I M E;
DISTINCT     : D I S T I N C T;
DOUBLE       : D O U B L E;
FROM         : F R O M;
IN           : I N;
INDEX        : I N D E X;
INTEGER      : I N T E G E R;
INTO         : I N T O;
LONGVARCHAR  : L O N G V A R C H A R;
MODULE       : M O D U L E;
NOT          : N O T;
NULL         : N U L L;
NOT_NULL     : NOT ' ' NULL;
ONLY         : O N L Y;
PRIMARY_KEY  : P R I M A R Y ' ' K E Y;
REAL         : R E A L;
SET          : S E T;
SMALLINT     : S M A L L I N T;
TABLE        : T A B L E;
TIME         : T I M E;
TIMESTAMP    : T I M E S T A M P;
VALUES       : V A L U E S;
VARCHAR      : V A R C H A R;
WHERE        : W H E R E;

// ActiveSpaces keywords
ASYNC               : A S Y N C;
CAPACITY            : C A P A C I T Y;
DISTRIBUTED         : D I S T R I B U T E D;
DISTRIBUTION_POLICY : D I S T R I B U T I O N '_' P O L I C Y;
EVICTION_POLICY     : E V I C T I O N '_' P O L I C Y;
HASH                : H A S H;
IS                  : I S;
IS_NULL             : IS ' ' NULL;
IS_NOT_NULL         : IS ' ' NOT ' ' NULL;
LIMIT               : L I M I T;
LOCK_SCOPE          : L O C K '_' S C O P E;
LOCK_TTL            : L O C K '_' T T L;
LOCK_WAIT           : L O C K '_' W A I T;
LRU                 : L R U;
MIN_SEEDERS         : M I N '_' S E E D E R S;
MULTICAST           : M U L T I C A S T;
NON_DISTRIBUTED     : N O N '_' D I S T R I B U T E D;
NONE                : N O N E;
NOR                 : N O R;
OFFSET              : O F F S E T;
OR                  : O R;
PHASE_COUNT         : P H A S E '_' C O U N T;
PHASE_INTERVAL      : P H A S E '_' I N T E R V A L;
PERSISTENCE         : P E R S I S T E N C E;
PERSISTENCE_POLICY  : P E R S I S T E N C E '_' P O L I C Y;
PERSISTENCE_TYPE    : P E R S I S T E N C E '_' T Y P E;
PROCESS             : P R O C E S S;
READ_TIMEOUT        : R E A D '_' T I M E O U T;
REPLICATION_COUNT   : R E P L I C A T I O N '_' C O U N T;
REPLICATION_POLICY  : R E P L I C A T I O N '_' P O L I C Y;
SHARED_ALL          : S H A R E D '_' A L L;
SHARED_NOTHING      : S H A R E D '_' N O T H I N G;
SPACE_WAIT          : S P A C E '_' W A I T;
SYNC                : S Y N C;
THREAD              : T H R E A D;
TREE                : T R E E;
TTL                 : T T L;
UNICAST             : U N I C A S T;
UPDATE_TRANSPORT    : U P D A T E '_' T R A N S P O R T;
WRITE_TIMEOUT       : W R I T E '_' T I M E O U T;

// Case-insensitive alpha characters
fragment A: ('a'|'A');
fragment B: ('b'|'B');
fragment C: ('c'|'C');
fragment D: ('d'|'D');
fragment E: ('e'|'E');
fragment F: ('f'|'F');
fragment G: ('g'|'G');
fragment H: ('h'|'H');
fragment I: ('i'|'I');
fragment J: ('j'|'J');
fragment K: ('k'|'K');
fragment L: ('l'|'L');
fragment M: ('m'|'M');
fragment N: ('n'|'N');
fragment O: ('o'|'O');
fragment P: ('p'|'P');
fragment Q: ('q'|'Q');
fragment R: ('r'|'R');
fragment S: ('s'|'S');
fragment T: ('t'|'T');
fragment U: ('u'|'U');
fragment V: ('v'|'V');
fragment W: ('w'|'W');
fragment X: ('x'|'X');
fragment Y: ('y'|'Y');
fragment Z: ('z'|'Z');

QuotedString
    : '\''
      { StringBuilder b = new StringBuilder(); }
      ( c=~('\'') { b.appendCodePoint(c);}
      | '\'' '\'' { b.appendCodePoint('\'');}
      )*
      '\''
      {
        // always enclose the string in double quotes
        // AS filters always expect the double quotes around strings
        // we remove the double quotes later where they are not needed
        setText("\"" + b.toString() + "\"");
      }
    ;

PositiveNumber
  : Int
  ;

NegativeNumber
  : '-' Int
  ;

Float
  : PositiveNumber '.' Digit (Digit)* ('F' | 'f')?
  | NegativeNumber '.' Digit (Digit)* ('F' | 'f')?
  ;

Identifier
  :  IdentifierStart IdentifierPart*
  | DoubleQuotedIdentifier
  ;

fragment DoubleQuotedIdentifier
  : '"'
    { StringBuilder b = new StringBuilder(); }
    ( c=~('"') { b.appendCodePoint(c); } )*
    '"'
    { setText(b.toString()); }
  ;

Comment
  :  '//' ~('\r' | '\n')* {skip();}
  |  '/*' .* '*/'         {skip();}
  ;

Space
  :  (SingleSpace | ControlSpace) {skip();}
  ;

fragment Period
  : '.'
  ;

fragment ControlSpace
  : '\t' | '\r' | '\n' | '\u000C'
  ;

fragment SingleSpace
  : ' '
  ;

fragment IdentifierStart
  : 'a'..'z' | 'A'..'Z';

fragment IdentifierPart
  : IdentifierStart | '_' | '-' | Digit;

fragment Int
  :  '1'..'9' Digit*
  |  '0'
  ;

fragment Digit
  :  '0'..'9'
  ;




