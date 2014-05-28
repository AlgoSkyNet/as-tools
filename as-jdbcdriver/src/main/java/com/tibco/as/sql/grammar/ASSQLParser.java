// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g 2014-05-22 21:36:32

package com.tibco.as.sql.grammar;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.HashMap;
import com.tibco.as.sql.*;
import com.tibco.as.space.Tuple;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ASSQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CREATE", "TABLE", "OParen", "Comma", "CParen", "DELETE", "FROM", "WHERE", "INSERT", "INTO", "VALUES", "SELECT", "LIMIT", "UPDATE", "SET", "Identifier", "NOT_NULL", "PRIMARY_KEY", "BIT", "CHAR", "CHAR1", "PositiveNumber", "VARCHAR", "LONGVARCHAR", "SMALLINT", "INTEGER", "BIGINT", "REAL", "DOUBLE", "BLOB", "DATETIME", "DATE", "TIME", "TIMESTAMP", "QuotedString", "NegativeNumber", "Float", "NULL", "TRUE", "FALSE", "SColon", "HASH", "TREE", "OFFSET", "Equals", "NotEquals", "GThan", "GTEquals", "LThan", "LTEquals", "IN", "IS_NULL", "IS_NOT_NULL", "NOT", "NOR", "Dot", "QMark", "AS", "COUNT", "Asterisk", "ALL", "DISTINCT", "CAPACITY", "CACHE_POLICY", "READ_WRITE_THROUGH", "READ_THROUGH", "DISTRIBUTION_POLICY", "DISTRIBUTED", "NON_DISTRIBUTED", "EVICTION_POLICY", "NONE", "LRU", "FILE_SYNC_INTERVAL", "FORGET_OLD_VALUE", "HOST_AWARE_REPLICATION", "LOCK_SCOPE", "THREAD", "PROCESS", "LOCK_TTL", "LOCK_WAIT", "MIN_SEEDERS", "PERSISTENCE_POLICY", "SYNC", "ASYNC", "PERSISTENCE", "SHARED_ALL", "SHARED_NOTHING", "PERSISTENCE_TYPE", "PHASE_COUNT", "PHASE_INTERVAL", "QUERY_LIMIT", "QUERY_TIMEOUT", "READ_TIMEOUT", "REPLICATION_COUNT", "REPLICATION_POLICY", "ROUTED", "TTL", "UPDATE_TRANSPORT", "UNICAST", "MULTICAST", "VIRTUAL_NODE_COUNT", "SPACE_WAIT", "WRITE_TIMEOUT", "CONSTRAINT", "INDEX", "ONLY", "AND", "OR", "Period", "Plus", "Minus", "Divide", "DVertbar", "Range", "Underscore", "C", "R", "E", "A", "T", "S", "L", "I", "N", "U", "P", "D", "B", "G", "O", "H", "M", "F", "X", "V", "MODULE", "Y", "K", "W", "IS", "Q", "J", "Z", "Int", "Digit", "IdentifierStart", "IdentifierPart", "DoubleQuotedIdentifier", "Comment", "SingleSpace", "ControlSpace", "Space"
    };
    public static final int UNICAST=102;
    public static final int CAPACITY=66;
    public static final int DVertbar=116;
    public static final int TTL=100;
    public static final int CHAR=23;
    public static final int NOR=58;
    public static final int COUNT=62;
    public static final int NOT=57;
    public static final int EOF=-1;
    public static final int QMark=60;
    public static final int Int=147;
    public static final int Identifier=19;
    public static final int CREATE=4;
    public static final int CParen=8;
    public static final int INSERT=12;
    public static final int IS_NULL=55;
    public static final int Comment=152;
    public static final int PRIMARY_KEY=21;
    public static final int QUERY_TIMEOUT=95;
    public static final int DOUBLE=32;
    public static final int UPDATE_TRANSPORT=101;
    public static final int EVICTION_POLICY=73;
    public static final int PHASE_INTERVAL=93;
    public static final int SELECT=15;
    public static final int INTO=13;
    public static final int READ_WRITE_THROUGH=68;
    public static final int ControlSpace=154;
    public static final int D=130;
    public static final int Period=112;
    public static final int E=121;
    public static final int F=136;
    public static final int G=132;
    public static final int LThan=52;
    public static final int BLOB=33;
    public static final int A=122;
    public static final int Underscore=118;
    public static final int B=131;
    public static final int C=119;
    public static final int L=125;
    public static final int M=135;
    public static final int N=127;
    public static final int DISTRIBUTION_POLICY=70;
    public static final int O=133;
    public static final int H=134;
    public static final int I=126;
    public static final int NULL=41;
    public static final int J=145;
    public static final int K=141;
    public static final int IdentifierStart=149;
    public static final int U=128;
    public static final int T=123;
    public static final int W=142;
    public static final int V=138;
    public static final int Q=144;
    public static final int FILE_SYNC_INTERVAL=76;
    public static final int P=129;
    public static final int CHAR1=24;
    public static final int DELETE=9;
    public static final int S=124;
    public static final int CACHE_POLICY=67;
    public static final int R=120;
    public static final int Y=140;
    public static final int X=137;
    public static final int Z=146;
    public static final int Float=40;
    public static final int REAL=31;
    public static final int Range=117;
    public static final int LOCK_WAIT=83;
    public static final int Minus=114;
    public static final int REPLICATION_POLICY=98;
    public static final int NONE=74;
    public static final int OR=111;
    public static final int PERSISTENCE=88;
    public static final int FROM=10;
    public static final int FALSE=43;
    public static final int CONSTRAINT=107;
    public static final int Equals=48;
    public static final int DISTINCT=65;
    public static final int TIMESTAMP=37;
    public static final int PHASE_COUNT=92;
    public static final int WHERE=11;
    public static final int OParen=6;
    public static final int QUERY_LIMIT=94;
    public static final int SingleSpace=153;
    public static final int LIMIT=16;
    public static final int ONLY=109;
    public static final int ROUTED=99;
    public static final int TABLE=5;
    public static final int UPDATE=17;
    public static final int VARCHAR=26;
    public static final int DISTRIBUTED=71;
    public static final int SHARED_NOTHING=90;
    public static final int AND=110;
    public static final int QuotedString=38;
    public static final int MIN_SEEDERS=84;
    public static final int NOT_NULL=20;
    public static final int Space=155;
    public static final int INDEX=108;
    public static final int TIME=36;
    public static final int AS=61;
    public static final int IN=54;
    public static final int TREE=46;
    public static final int ASYNC=87;
    public static final int IS=143;
    public static final int OFFSET=47;
    public static final int LRU=75;
    public static final int NegativeNumber=39;
    public static final int ALL=64;
    public static final int GTEquals=51;
    public static final int READ_THROUGH=69;
    public static final int IdentifierPart=150;
    public static final int VIRTUAL_NODE_COUNT=104;
    public static final int GThan=50;
    public static final int INTEGER=29;
    public static final int Asterisk=63;
    public static final int THREAD=80;
    public static final int NotEquals=49;
    public static final int SYNC=86;
    public static final int PERSISTENCE_POLICY=85;
    public static final int WRITE_TIMEOUT=106;
    public static final int DATETIME=34;
    public static final int VALUES=14;
    public static final int HASH=45;
    public static final int SET=18;
    public static final int PositiveNumber=25;
    public static final int IS_NOT_NULL=56;
    public static final int Digit=148;
    public static final int MODULE=139;
    public static final int TRUE=42;
    public static final int Divide=115;
    public static final int PERSISTENCE_TYPE=91;
    public static final int SPACE_WAIT=105;
    public static final int SColon=44;
    public static final int SHARED_ALL=89;
    public static final int Plus=113;
    public static final int DoubleQuotedIdentifier=151;
    public static final int LOCK_SCOPE=79;
    public static final int BIGINT=30;
    public static final int LONGVARCHAR=27;
    public static final int LOCK_TTL=82;
    public static final int NON_DISTRIBUTED=72;
    public static final int FORGET_OLD_VALUE=77;
    public static final int MULTICAST=103;
    public static final int Dot=59;
    public static final int BIT=22;
    public static final int DATE=35;
    public static final int PROCESS=81;
    public static final int Comma=7;
    public static final int HOST_AWARE_REPLICATION=78;
    public static final int REPLICATION_COUNT=97;
    public static final int READ_TIMEOUT=96;
    public static final int SMALLINT=28;
    public static final int LTEquals=53;

    // delegates
    // delegators


        public ASSQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ASSQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ASSQLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g"; }


        // Table information <table_name, table_correlationName>
        private List<Tuple> tableInfo = new ArrayList<Tuple>();
        private void addTableInfo(String tname, String correlationName)
        {
            Tuple tableTuple = Tuple.create();
            tableTuple.put(ASSQLUtils.TABLE_NAME, tname);
            tableTuple.put(ASSQLUtils.TABLE_CORRELATION_NAME, correlationName);
            tableInfo.add(tableTuple);
        }
        
        // Column information <column_name, table_name, alias>
        private List<Tuple> columnInfo = new ArrayList<Tuple>();
        private void addColumnInfo(String cname, String tname, String calias, String fname)
        {
            Tuple columnTuple = Tuple.create();
            columnTuple.put(ASSQLUtils.COLUMN_NAME, cname);
            columnTuple.put(ASSQLUtils.TABLE_NAME, tname);
            columnTuple.put(ASSQLUtils.COLUMN_ALIAS, calias);
            columnTuple.put(ASSQLUtils.COLUMN_FUNCTION, fname);
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



    // $ANTLR start "query"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:103:1: query returns [ASSQLStatement stmnt] : ( createStatement endStmnt | deleteStatement endStmnt | insertStatement endStmnt | selectStatement endStmnt | updateStatement endStmnt );
    public final ASSQLStatement query() throws RecognitionException {
        ASSQLStatement stmnt = null;

        CreateStatement createStatement1 = null;

        DeleteStatement deleteStatement2 = null;

        InsertStatement insertStatement3 = null;

        SelectStatement selectStatement4 = null;

        UpdateStatement updateStatement5 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:104:5: ( createStatement endStmnt | deleteStatement endStmnt | insertStatement endStmnt | selectStatement endStmnt | updateStatement endStmnt )
            int alt1=5;
            switch ( input.LA(1) ) {
            case CREATE:
                {
                alt1=1;
                }
                break;
            case DELETE:
                {
                alt1=2;
                }
                break;
            case INSERT:
                {
                alt1=3;
                }
                break;
            case SELECT:
                {
                alt1=4;
                }
                break;
            case UPDATE:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:104:7: createStatement endStmnt
                    {
                    pushFollow(FOLLOW_createStatement_in_query62);
                    createStatement1=createStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query65);
                    endStmnt();

                    state._fsp--;

                    stmnt = createStatement1; 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:105:7: deleteStatement endStmnt
                    {
                    pushFollow(FOLLOW_deleteStatement_in_query75);
                    deleteStatement2=deleteStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query78);
                    endStmnt();

                    state._fsp--;

                    stmnt = deleteStatement2; 

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:106:7: insertStatement endStmnt
                    {
                    pushFollow(FOLLOW_insertStatement_in_query88);
                    insertStatement3=insertStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query91);
                    endStmnt();

                    state._fsp--;

                    stmnt = insertStatement3; 

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:107:7: selectStatement endStmnt
                    {
                    pushFollow(FOLLOW_selectStatement_in_query101);
                    selectStatement4=selectStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query104);
                    endStmnt();

                    state._fsp--;

                    stmnt = selectStatement4; 

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:108:7: updateStatement endStmnt
                    {
                    pushFollow(FOLLOW_updateStatement_in_query114);
                    updateStatement5=updateStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query117);
                    endStmnt();

                    state._fsp--;

                    stmnt = updateStatement5; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmnt;
    }
    // $ANTLR end "query"


    // $ANTLR start "createStatement"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:111:1: createStatement returns [CreateStatement expr] : CREATE TABLE target_table OParen table_element ( Comma table_element )* CParen (c= space_property ( Comma d= space_property )* )* ;
    public final CreateStatement createStatement() throws RecognitionException {
        CreateStatement expr = null;

        ASSQLParser.space_property_return c = null;

        ASSQLParser.space_property_return d = null;

        String target_table6 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:112:5: ( CREATE TABLE target_table OParen table_element ( Comma table_element )* CParen (c= space_property ( Comma d= space_property )* )* )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:112:7: CREATE TABLE target_table OParen table_element ( Comma table_element )* CParen (c= space_property ( Comma d= space_property )* )*
            {

                      // ActiveSpaces properties for defining a table/space
                      java.util.Properties sdprops = new java.util.Properties();
                  
            match(input,CREATE,FOLLOW_CREATE_in_createStatement148); 
            match(input,TABLE,FOLLOW_TABLE_in_createStatement150); 
            pushFollow(FOLLOW_target_table_in_createStatement152);
            target_table6=target_table();

            state._fsp--;

            match(input,OParen,FOLLOW_OParen_in_createStatement160); 
            pushFollow(FOLLOW_table_element_in_createStatement162);
            table_element();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:117:28: ( Comma table_element )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comma) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:117:29: Comma table_element
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_createStatement165); 
            	    pushFollow(FOLLOW_table_element_in_createStatement167);
            	    table_element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_createStatement171); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:118:7: (c= space_property ( Comma d= space_property )* )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CAPACITY && LA4_0<=CACHE_POLICY)||LA4_0==DISTRIBUTION_POLICY||LA4_0==EVICTION_POLICY||(LA4_0>=FILE_SYNC_INTERVAL && LA4_0<=LOCK_SCOPE)||(LA4_0>=LOCK_TTL && LA4_0<=PERSISTENCE_POLICY)||LA4_0==PERSISTENCE||(LA4_0>=PERSISTENCE_TYPE && LA4_0<=UPDATE_TRANSPORT)||(LA4_0>=VIRTUAL_NODE_COUNT && LA4_0<=WRITE_TIMEOUT)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:118:8: c= space_property ( Comma d= space_property )*
            	    {
            	    pushFollow(FOLLOW_space_property_in_createStatement182);
            	    c=space_property();

            	    state._fsp--;

            	    sdprops.put((c!=null?c.key:null), (c!=null?c.value:null));
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:118:58: ( Comma d= space_property )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==Comma) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:118:59: Comma d= space_property
            	    	    {
            	    	    match(input,Comma,FOLLOW_Comma_in_createStatement187); 
            	    	    pushFollow(FOLLOW_space_property_in_createStatement191);
            	    	    d=space_property();

            	    	    state._fsp--;

            	    	    sdprops.put((d!=null?d.key:null), (d!=null?d.value:null));

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


                      return new CreateStatement(target_table6, columnDefs, pkeyType, pkeyList, sdprops, indexList);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createStatement"


    // $ANTLR start "deleteStatement"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:124:1: deleteStatement returns [DeleteStatement expr] : DELETE FROM target_table ( WHERE where_condition )? ;
    public final DeleteStatement deleteStatement() throws RecognitionException {
        DeleteStatement expr = null;

        String target_table7 = null;

        String where_condition8 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:125:5: ( DELETE FROM target_table ( WHERE where_condition )? )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:125:7: DELETE FROM target_table ( WHERE where_condition )?
            {
            match(input,DELETE,FOLLOW_DELETE_in_deleteStatement227); 
            match(input,FROM,FOLLOW_FROM_in_deleteStatement229); 
            pushFollow(FOLLOW_target_table_in_deleteStatement231);
            target_table7=target_table();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:126:7: ( WHERE where_condition )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WHERE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:126:8: WHERE where_condition
                    {
                    match(input,WHERE,FOLLOW_WHERE_in_deleteStatement240); 
                    pushFollow(FOLLOW_where_condition_in_deleteStatement242);
                    where_condition8=where_condition();

                    state._fsp--;


                    }
                    break;

            }


                      return new DeleteStatement(target_table7, where_condition8);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteStatement"


    // $ANTLR start "insertStatement"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:132:1: insertStatement returns [InsertStatement expr] : INSERT INTO table_name OParen c= column_name ( Comma d= column_name )* CParen VALUES OParen e= column_value ( Comma f= column_value )* CParen ;
    public final InsertStatement insertStatement() throws RecognitionException {
        InsertStatement expr = null;

        ASSQLParser.column_name_return c = null;

        ASSQLParser.column_name_return d = null;

        ASSQLParser.column_value_return e = null;

        ASSQLParser.column_value_return f = null;

        ASSQLParser.table_name_return table_name9 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:133:5: ( INSERT INTO table_name OParen c= column_name ( Comma d= column_name )* CParen VALUES OParen e= column_value ( Comma f= column_value )* CParen )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:133:7: INSERT INTO table_name OParen c= column_name ( Comma d= column_name )* CParen VALUES OParen e= column_value ( Comma f= column_value )* CParen
            {

                      List<String> columnNames = new ArrayList<String>();
                      List<String> columnValues = new ArrayList<String>();
                  
            match(input,INSERT,FOLLOW_INSERT_in_insertStatement281); 
            match(input,INTO,FOLLOW_INTO_in_insertStatement283); 
            pushFollow(FOLLOW_table_name_in_insertStatement285);
            table_name9=table_name();

            state._fsp--;

            match(input,OParen,FOLLOW_OParen_in_insertStatement293); 
            pushFollow(FOLLOW_column_name_in_insertStatement297);
            c=column_name();

            state._fsp--;

            columnNames.add((c!=null?input.toString(c.start,c.stop):null));
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:138:56: ( Comma d= column_name )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Comma) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:138:58: Comma d= column_name
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_insertStatement303); 
            	    pushFollow(FOLLOW_column_name_in_insertStatement307);
            	    d=column_name();

            	    state._fsp--;

            	    columnNames.add((d!=null?input.toString(d.start,d.stop):null));

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_insertStatement314); 
            match(input,VALUES,FOLLOW_VALUES_in_insertStatement322); 
            match(input,OParen,FOLLOW_OParen_in_insertStatement324); 
            pushFollow(FOLLOW_column_value_in_insertStatement328);
            e=column_value();

            state._fsp--;

            columnValues.add((e!=null?input.toString(e.start,e.stop):null));
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:139:65: ( Comma f= column_value )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Comma) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:139:67: Comma f= column_value
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_insertStatement334); 
            	    pushFollow(FOLLOW_column_value_in_insertStatement338);
            	    f=column_value();

            	    state._fsp--;

            	    columnValues.add((f!=null?input.toString(f.start,f.stop):null));

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_insertStatement345); 

                      return new InsertStatement((table_name9!=null?input.toString(table_name9.start,table_name9.stop):null), columnNames, columnValues);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "selectStatement"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:145:1: selectStatement returns [SelectStatement expr] : SELECT ( select_quantifier )? select_list FROM table_reference_list ( WHERE where_condition )? ( LIMIT limit_clause )? ;
    public final SelectStatement selectStatement() throws RecognitionException {
        SelectStatement expr = null;

        ASSQLParser.select_quantifier_return select_quantifier10 = null;

        String where_condition11 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:146:5: ( SELECT ( select_quantifier )? select_list FROM table_reference_list ( WHERE where_condition )? ( LIMIT limit_clause )? )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:146:7: SELECT ( select_quantifier )? select_list FROM table_reference_list ( WHERE where_condition )? ( LIMIT limit_clause )?
            {
            match(input,SELECT,FOLLOW_SELECT_in_selectStatement374); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:146:14: ( select_quantifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=ALL && LA8_0<=DISTINCT)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:146:15: select_quantifier
                    {
                    pushFollow(FOLLOW_select_quantifier_in_selectStatement377);
                    select_quantifier10=select_quantifier();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_select_list_in_selectStatement387);
            select_list();

            state._fsp--;

            match(input,FROM,FOLLOW_FROM_in_selectStatement402); 
            pushFollow(FOLLOW_table_reference_list_in_selectStatement404);
            table_reference_list();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:150:7: ( WHERE where_condition )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==WHERE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:150:8: WHERE where_condition
                    {
                    match(input,WHERE,FOLLOW_WHERE_in_selectStatement413); 
                    pushFollow(FOLLOW_where_condition_in_selectStatement415);
                    where_condition11=where_condition();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:151:7: ( LIMIT limit_clause )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LIMIT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:151:8: LIMIT limit_clause
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_selectStatement426); 
                    pushFollow(FOLLOW_limit_clause_in_selectStatement428);
                    limit_clause();

                    state._fsp--;


                    }
                    break;

            }


                      return new SelectStatement((select_quantifier10!=null?input.toString(select_quantifier10.start,select_quantifier10.stop):null), columnInfo, tableInfo, where_condition11);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "updateStatement"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:161:1: updateStatement returns [UpdateStatement expr] : UPDATE target_table SET a= set_clause ( Comma b= set_clause )* ( WHERE where_condition )? ;
    public final UpdateStatement updateStatement() throws RecognitionException {
        UpdateStatement expr = null;

        ASSQLParser.set_clause_return a = null;

        ASSQLParser.set_clause_return b = null;

        String target_table12 = null;

        String where_condition13 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:162:5: ( UPDATE target_table SET a= set_clause ( Comma b= set_clause )* ( WHERE where_condition )? )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:162:7: UPDATE target_table SET a= set_clause ( Comma b= set_clause )* ( WHERE where_condition )?
            {

                      HashMap<String,String> cValues = new HashMap<String,String>();
                  
            match(input,UPDATE,FOLLOW_UPDATE_in_updateStatement495); 
            pushFollow(FOLLOW_target_table_in_updateStatement497);
            target_table12=target_table();

            state._fsp--;

            match(input,SET,FOLLOW_SET_in_updateStatement505); 
            pushFollow(FOLLOW_set_clause_in_updateStatement509);
            a=set_clause();

            state._fsp--;

             cValues.put((a!=null?a.cname:null), (a!=null?a.cvalue:null)); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:167:10: ( Comma b= set_clause )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Comma) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:167:11: Comma b= set_clause
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_updateStatement523); 
            	    pushFollow(FOLLOW_set_clause_in_updateStatement527);
            	    b=set_clause();

            	    state._fsp--;

            	     cValues.put((b!=null?b.cname:null), (b!=null?b.cvalue:null)); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:168:7: ( WHERE where_condition )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WHERE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:168:8: WHERE where_condition
                    {
                    match(input,WHERE,FOLLOW_WHERE_in_updateStatement541); 
                    pushFollow(FOLLOW_where_condition_in_updateStatement543);
                    where_condition13=where_condition();

                    state._fsp--;


                    }
                    break;

            }


                      return new UpdateStatement(target_table12, cValues, where_condition13);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "updateStatement"

    public static class alias_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "alias"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:174:1: alias : Identifier ;
    public final ASSQLParser.alias_return alias() throws RecognitionException {
        ASSQLParser.alias_return retval = new ASSQLParser.alias_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:175:5: ( Identifier )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:175:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_alias570); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "alias"


    // $ANTLR start "column_def"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:178:1: column_def : column_name column_type ( NOT_NULL | PRIMARY_KEY ( key_type )? )* ;
    public final void column_def() throws RecognitionException {
        ASSQLParser.key_type_return key_type14 = null;

        ASSQLParser.column_name_return column_name15 = null;

        String column_type16 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:179:5: ( column_name column_type ( NOT_NULL | PRIMARY_KEY ( key_type )? )* )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:179:7: column_name column_type ( NOT_NULL | PRIMARY_KEY ( key_type )? )*
            {

                      String not_null = null;
                      String pkey = null;
                      String pkey_type = null;
                  
            pushFollow(FOLLOW_column_name_in_column_def595);
            column_name15=column_name();

            state._fsp--;

            pushFollow(FOLLOW_column_type_in_column_def597);
            column_type16=column_type();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:185:7: ( NOT_NULL | PRIMARY_KEY ( key_type )? )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==NOT_NULL) ) {
                    alt14=1;
                }
                else if ( (LA14_0==PRIMARY_KEY) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:186:9: NOT_NULL
            	    {
            	    match(input,NOT_NULL,FOLLOW_NOT_NULL_in_column_def615); 
            	     not_null = "true"; 

            	    }
            	    break;
            	case 2 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:187:9: PRIMARY_KEY ( key_type )?
            	    {
            	    match(input,PRIMARY_KEY,FOLLOW_PRIMARY_KEY_in_column_def627); 
            	     pkey = "true"; 
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:187:41: ( key_type )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( ((LA13_0>=HASH && LA13_0<=TREE)) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:187:42: key_type
            	            {
            	            pushFollow(FOLLOW_key_type_in_column_def633);
            	            key_type14=key_type();

            	            state._fsp--;

            	             pkey_type = (key_type14!=null?input.toString(key_type14.start,key_type14.stop):null).toLowerCase(); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


                      addColumnDef((column_name15!=null?input.toString(column_name15.start,column_name15.stop):null), column_type16, not_null, pkey, pkey_type);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "column_def"

    public static class column_name_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "column_name"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:194:1: column_name : Identifier ;
    public final ASSQLParser.column_name_return column_name() throws RecognitionException {
        ASSQLParser.column_name_return retval = new ASSQLParser.column_name_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:195:5: ( Identifier )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:195:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_column_name671); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "column_name"


    // $ANTLR start "column_type"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:198:1: column_type returns [String type] : ( BIT | CHAR | CHAR1 | CHAR OParen PositiveNumber CParen | VARCHAR | VARCHAR OParen PositiveNumber CParen | LONGVARCHAR | LONGVARCHAR OParen PositiveNumber CParen | SMALLINT | INTEGER | BIGINT | REAL | DOUBLE | BLOB | DATETIME | DATE | TIME | TIMESTAMP );
    public final String column_type() throws RecognitionException {
        String type = null;

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:199:5: ( BIT | CHAR | CHAR1 | CHAR OParen PositiveNumber CParen | VARCHAR | VARCHAR OParen PositiveNumber CParen | LONGVARCHAR | LONGVARCHAR OParen PositiveNumber CParen | SMALLINT | INTEGER | BIGINT | REAL | DOUBLE | BLOB | DATETIME | DATE | TIME | TIMESTAMP )
            int alt15=18;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:199:7: BIT
                    {
                    match(input,BIT,FOLLOW_BIT_in_column_type692); 
                     type = "boolean"; 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:200:7: CHAR
                    {
                    match(input,CHAR,FOLLOW_CHAR_in_column_type710); 
                     type = "char"; 

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:201:7: CHAR1
                    {
                    match(input,CHAR1,FOLLOW_CHAR1_in_column_type728); 
                     type = "char"; 

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:202:7: CHAR OParen PositiveNumber CParen
                    {
                    match(input,CHAR,FOLLOW_CHAR_in_column_type744); 
                    match(input,OParen,FOLLOW_OParen_in_column_type746); 
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_column_type748); 
                    match(input,CParen,FOLLOW_CParen_in_column_type750); 
                     type = "string"; 

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:203:7: VARCHAR
                    {
                    match(input,VARCHAR,FOLLOW_VARCHAR_in_column_type760); 
                     type = "string"; 

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:204:7: VARCHAR OParen PositiveNumber CParen
                    {
                    match(input,VARCHAR,FOLLOW_VARCHAR_in_column_type774); 
                    match(input,OParen,FOLLOW_OParen_in_column_type776); 
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_column_type778); 
                    match(input,CParen,FOLLOW_CParen_in_column_type780); 
                     type = "string"; 

                    }
                    break;
                case 7 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:205:7: LONGVARCHAR
                    {
                    match(input,LONGVARCHAR,FOLLOW_LONGVARCHAR_in_column_type790); 
                     type = "string"; 

                    }
                    break;
                case 8 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:206:7: LONGVARCHAR OParen PositiveNumber CParen
                    {
                    match(input,LONGVARCHAR,FOLLOW_LONGVARCHAR_in_column_type800); 
                    match(input,OParen,FOLLOW_OParen_in_column_type802); 
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_column_type804); 
                    match(input,CParen,FOLLOW_CParen_in_column_type806); 
                     type = "string"; 

                    }
                    break;
                case 9 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:207:7: SMALLINT
                    {
                    match(input,SMALLINT,FOLLOW_SMALLINT_in_column_type816); 
                     type = "short"; 

                    }
                    break;
                case 10 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:208:7: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_column_type829); 
                     type = "integer"; 

                    }
                    break;
                case 11 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:209:7: BIGINT
                    {
                    match(input,BIGINT,FOLLOW_BIGINT_in_column_type843); 
                     type = "long"; 

                    }
                    break;
                case 12 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:210:7: REAL
                    {
                    match(input,REAL,FOLLOW_REAL_in_column_type858); 
                     type = "float"; 

                    }
                    break;
                case 13 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:211:7: DOUBLE
                    {
                    match(input,DOUBLE,FOLLOW_DOUBLE_in_column_type875); 
                     type = "double"; 

                    }
                    break;
                case 14 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:212:7: BLOB
                    {
                    match(input,BLOB,FOLLOW_BLOB_in_column_type890); 
                     type = "blob"; 

                    }
                    break;
                case 15 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:213:7: DATETIME
                    {
                    match(input,DATETIME,FOLLOW_DATETIME_in_column_type907); 
                     type = "datetime"; 

                    }
                    break;
                case 16 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:214:7: DATE
                    {
                    match(input,DATE,FOLLOW_DATE_in_column_type920); 
                     type = "datetime"; 

                    }
                    break;
                case 17 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:215:7: TIME
                    {
                    match(input,TIME,FOLLOW_TIME_in_column_type937); 
                     type = "datetime"; 

                    }
                    break;
                case 18 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:216:7: TIMESTAMP
                    {
                    match(input,TIMESTAMP,FOLLOW_TIMESTAMP_in_column_type954); 
                     type = "datetime"; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "column_type"

    public static class column_value_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "column_value"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:219:1: column_value : ( QuotedString | PositiveNumber | NegativeNumber | Float | NULL | TRUE | FALSE );
    public final ASSQLParser.column_value_return column_value() throws RecognitionException {
        ASSQLParser.column_value_return retval = new ASSQLParser.column_value_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:220:5: ( QuotedString | PositiveNumber | NegativeNumber | Float | NULL | TRUE | FALSE )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:
            {
            if ( input.LA(1)==PositiveNumber||(input.LA(1)>=QuotedString && input.LA(1)<=FALSE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "column_value"


    // $ANTLR start "endStmnt"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:229:1: endStmnt : ( SColon )? EOF ;
    public final void endStmnt() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:230:5: ( ( SColon )? EOF )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:230:7: ( SColon )? EOF
            {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:230:7: ( SColon )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SColon) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:230:7: SColon
                    {
                    match(input,SColon,FOLLOW_SColon_in_endStmnt1054); 

                    }
                    break;

            }

            match(input,EOF,FOLLOW_EOF_in_endStmnt1058); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "endStmnt"

    public static class key_type_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "key_type"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:233:1: key_type : ( HASH | TREE );
    public final ASSQLParser.key_type_return key_type() throws RecognitionException {
        ASSQLParser.key_type_return retval = new ASSQLParser.key_type_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:234:5: ( HASH | TREE )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:
            {
            if ( (input.LA(1)>=HASH && input.LA(1)<=TREE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "key_type"


    // $ANTLR start "limit_clause"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:238:1: limit_clause : ( PositiveNumber OFFSET PositiveNumber | ( PositiveNumber Comma ) PositiveNumber );
    public final void limit_clause() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:239:5: ( PositiveNumber OFFSET PositiveNumber | ( PositiveNumber Comma ) PositiveNumber )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==PositiveNumber) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==OFFSET) ) {
                    alt17=1;
                }
                else if ( (LA17_1==Comma) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:239:7: PositiveNumber OFFSET PositiveNumber
                    {
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1100); 
                    match(input,OFFSET,FOLLOW_OFFSET_in_limit_clause1102); 
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1104); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:240:7: ( PositiveNumber Comma ) PositiveNumber
                    {
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:240:7: ( PositiveNumber Comma )
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:240:8: PositiveNumber Comma
                    {
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1113); 
                    match(input,Comma,FOLLOW_Comma_in_limit_clause1115); 

                    }

                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1118); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "limit_clause"


    // $ANTLR start "relation"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:243:1: relation returns [String arg] : (a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm | c= relation_null | d= relation_not | e= relation_in );
    public final String relation() throws RecognitionException {
        String arg = null;

        Token type=null;
        ASSQLParser.rterm_return a = null;

        ASSQLParser.rterm_return b = null;

        String c = null;

        String d = null;

        String e = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:244:5: (a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm | c= relation_null | d= relation_not | e= relation_in )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:244:7: a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm
                    {
                    pushFollow(FOLLOW_rterm_in_relation1141);
                    a=rterm();

                    state._fsp--;

                    type=(Token)input.LT(1);
                    if ( (input.LA(1)>=Equals && input.LA(1)<=LTEquals) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_rterm_in_relation1171);
                    b=rterm();

                    state._fsp--;

                    arg = (a!=null?input.toString(a.start,a.stop):null) + (type!=null?type.getText():null) + (b!=null?input.toString(b.start,b.stop):null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:245:7: c= relation_null
                    {
                    pushFollow(FOLLOW_relation_null_in_relation1183);
                    c=relation_null();

                    state._fsp--;

                    arg = c;

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:246:7: d= relation_not
                    {
                    pushFollow(FOLLOW_relation_not_in_relation1195);
                    d=relation_not();

                    state._fsp--;

                    arg = d;

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:247:7: e= relation_in
                    {
                    pushFollow(FOLLOW_relation_in_in_relation1207);
                    e=relation_in();

                    state._fsp--;

                    arg = e;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "relation"


    // $ANTLR start "relation_in"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:250:1: relation_in returns [String arg] : rterm IN OParen rterm_list CParen ;
    public final String relation_in() throws RecognitionException {
        String arg = null;

        ASSQLParser.rterm_return rterm17 = null;

        ASSQLParser.rterm_list_return rterm_list18 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:251:5: ( rterm IN OParen rterm_list CParen )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:251:7: rterm IN OParen rterm_list CParen
            {
            pushFollow(FOLLOW_rterm_in_relation_in1230);
            rterm17=rterm();

            state._fsp--;

            match(input,IN,FOLLOW_IN_in_relation_in1232); 
            match(input,OParen,FOLLOW_OParen_in_relation_in1234); 
            pushFollow(FOLLOW_rterm_list_in_relation_in1236);
            rterm_list18=rterm_list();

            state._fsp--;

            match(input,CParen,FOLLOW_CParen_in_relation_in1238); 
             arg = (rterm17!=null?input.toString(rterm17.start,rterm17.stop):null) + " IN (" + (rterm_list18!=null?input.toString(rterm_list18.start,rterm_list18.stop):null) + ")"; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "relation_in"


    // $ANTLR start "relation_null"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:254:1: relation_null returns [String arg] : (a= rterm_identifier IS_NULL | b= rterm_identifier IS_NOT_NULL );
    public final String relation_null() throws RecognitionException {
        String arg = null;

        ASSQLParser.rterm_identifier_return a = null;

        ASSQLParser.rterm_identifier_return b = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:255:5: (a= rterm_identifier IS_NULL | b= rterm_identifier IS_NOT_NULL )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Identifier) ) {
                switch ( input.LA(2) ) {
                case IS_NOT_NULL:
                    {
                    alt19=2;
                    }
                    break;
                case Dot:
                    {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==Identifier) ) {
                        int LA19_5 = input.LA(4);

                        if ( (LA19_5==IS_NOT_NULL) ) {
                            alt19=2;
                        }
                        else if ( (LA19_5==IS_NULL) ) {
                            alt19=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case IS_NULL:
                    {
                    alt19=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:255:7: a= rterm_identifier IS_NULL
                    {
                    pushFollow(FOLLOW_rterm_identifier_in_relation_null1263);
                    a=rterm_identifier();

                    state._fsp--;

                    match(input,IS_NULL,FOLLOW_IS_NULL_in_relation_null1265); 
                    arg = (a!=null?input.toString(a.start,a.stop):null) + " IS NULL";

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:256:7: b= rterm_identifier IS_NOT_NULL
                    {
                    pushFollow(FOLLOW_rterm_identifier_in_relation_null1277);
                    b=rterm_identifier();

                    state._fsp--;

                    match(input,IS_NOT_NULL,FOLLOW_IS_NOT_NULL_in_relation_null1279); 
                    arg = (b!=null?input.toString(b.start,b.stop):null) + " IS NOT NULL";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "relation_null"


    // $ANTLR start "relation_not"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:259:1: relation_not returns [String arg] : a= rterm_identifier NOT b= column_value ( NOR c= column_value )? ;
    public final String relation_not() throws RecognitionException {
        String arg = null;

        ASSQLParser.rterm_identifier_return a = null;

        ASSQLParser.column_value_return b = null;

        ASSQLParser.column_value_return c = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:5: (a= rterm_identifier NOT b= column_value ( NOR c= column_value )? )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:7: a= rterm_identifier NOT b= column_value ( NOR c= column_value )?
            {
            pushFollow(FOLLOW_rterm_identifier_in_relation_not1304);
            a=rterm_identifier();

            state._fsp--;

            match(input,NOT,FOLLOW_NOT_in_relation_not1306); 
            pushFollow(FOLLOW_column_value_in_relation_not1310);
            b=column_value();

            state._fsp--;

            arg = (a!=null?input.toString(a.start,a.stop):null) + " NOT " + (b!=null?input.toString(b.start,b.stop):null);
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:83: ( NOR c= column_value )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NOR) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:84: NOR c= column_value
                    {
                    match(input,NOR,FOLLOW_NOR_in_relation_not1315); 
                    pushFollow(FOLLOW_column_value_in_relation_not1319);
                    c=column_value();

                    state._fsp--;

                    arg += " NOR " + (c!=null?input.toString(c.start,c.stop):null);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "relation_not"

    public static class rterm_list_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "rterm_list"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:263:1: rterm_list : rterm ( Comma rterm )* ;
    public final ASSQLParser.rterm_list_return rterm_list() throws RecognitionException {
        ASSQLParser.rterm_list_return retval = new ASSQLParser.rterm_list_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:264:5: ( rterm ( Comma rterm )* )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:264:7: rterm ( Comma rterm )*
            {
            pushFollow(FOLLOW_rterm_in_rterm_list1352);
            rterm();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:264:13: ( Comma rterm )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Comma) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:264:14: Comma rterm
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_rterm_list1355); 
            	    pushFollow(FOLLOW_rterm_in_rterm_list1357);
            	    rterm();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rterm_list"

    public static class rterm_identifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "rterm_identifier"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:267:1: rterm_identifier : ( table_name Dot )? Identifier ;
    public final ASSQLParser.rterm_identifier_return rterm_identifier() throws RecognitionException {
        ASSQLParser.rterm_identifier_return retval = new ASSQLParser.rterm_identifier_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:268:5: ( ( table_name Dot )? Identifier )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:268:7: ( table_name Dot )? Identifier
            {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:268:7: ( table_name Dot )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Identifier) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==Dot) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:268:8: table_name Dot
                    {
                    pushFollow(FOLLOW_table_name_in_rterm_identifier1377);
                    table_name();

                    state._fsp--;

                    match(input,Dot,FOLLOW_Dot_in_rterm_identifier1379); 

                    }
                    break;

            }

            match(input,Identifier,FOLLOW_Identifier_in_rterm_identifier1383); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rterm_identifier"

    public static class rterm_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "rterm"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:271:1: rterm : ( rterm_identifier | QMark | column_value );
    public final ASSQLParser.rterm_return rterm() throws RecognitionException {
        ASSQLParser.rterm_return retval = new ASSQLParser.rterm_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:272:5: ( rterm_identifier | QMark | column_value )
            int alt23=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt23=1;
                }
                break;
            case QMark:
                {
                alt23=2;
                }
                break;
            case PositiveNumber:
            case QuotedString:
            case NegativeNumber:
            case Float:
            case NULL:
            case TRUE:
            case FALSE:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:272:7: rterm_identifier
                    {
                    pushFollow(FOLLOW_rterm_identifier_in_rterm1400);
                    rterm_identifier();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:273:7: QMark
                    {
                    match(input,QMark,FOLLOW_QMark_in_rterm1408); 

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:274:7: column_value
                    {
                    pushFollow(FOLLOW_column_value_in_rterm1416);
                    column_value();

                    state._fsp--;


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rterm"

    public static class select_column_return extends ParserRuleReturnScope {
        public String cname;
        public String tname;
        public String calias;
    };

    // $ANTLR start "select_column"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:277:1: select_column returns [String cname, String tname, String calias] : ( table_name Dot )? column_name ( AS alias )? ;
    public final ASSQLParser.select_column_return select_column() throws RecognitionException {
        ASSQLParser.select_column_return retval = new ASSQLParser.select_column_return();
        retval.start = input.LT(1);

        ASSQLParser.table_name_return table_name19 = null;

        ASSQLParser.column_name_return column_name20 = null;

        ASSQLParser.alias_return alias21 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:278:5: ( ( table_name Dot )? column_name ( AS alias )? )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:278:7: ( table_name Dot )? column_name ( AS alias )?
            {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:278:7: ( table_name Dot )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Identifier) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==Dot) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:278:8: table_name Dot
                    {
                    pushFollow(FOLLOW_table_name_in_select_column1446);
                    table_name19=table_name();

                    state._fsp--;

                    match(input,Dot,FOLLOW_Dot_in_select_column1448); 
                     retval.tname = (table_name19!=null?input.toString(table_name19.start,table_name19.stop):null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_column_name_in_select_column1461);
            column_name20=column_name();

            state._fsp--;

             retval.cname = (column_name20!=null?input.toString(column_name20.start,column_name20.stop):null); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:280:7: ( AS alias )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==AS) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:280:8: AS alias
                    {
                    match(input,AS,FOLLOW_AS_in_select_column1472); 
                    pushFollow(FOLLOW_alias_in_select_column1474);
                    alias21=alias();

                    state._fsp--;

                     retval.calias = (alias21!=null?input.toString(alias21.start,alias21.stop):null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "select_column"


    // $ANTLR start "select_column_list"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:283:1: select_column_list : a= select_column ( Comma b= select_column )* ;
    public final void select_column_list() throws RecognitionException {
        ASSQLParser.select_column_return a = null;

        ASSQLParser.select_column_return b = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:284:5: (a= select_column ( Comma b= select_column )* )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:284:7: a= select_column ( Comma b= select_column )*
            {
            pushFollow(FOLLOW_select_column_in_select_column_list1497);
            a=select_column();

            state._fsp--;

             addColumnInfo((a!=null?a.cname:null), (a!=null?a.tname:null), (a!=null?a.calias:null), null); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:285:7: ( Comma b= select_column )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==Comma) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:285:8: Comma b= select_column
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_select_column_list1508); 
            	    pushFollow(FOLLOW_select_column_in_select_column_list1512);
            	    b=select_column();

            	    state._fsp--;

            	     addColumnInfo((b!=null?b.cname:null), (b!=null?b.tname:null), (b!=null?b.calias:null), null); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "select_column_list"


    // $ANTLR start "select_list"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:288:1: select_list : ( (fn= COUNT OParen )? Asterisk ( CParen )? | a= table_name Dot b= Asterisk ( Comma c= table_name Dot d= Asterisk )* | select_column_list );
    public final void select_list() throws RecognitionException {
        Token fn=null;
        Token b=null;
        Token d=null;
        Token Asterisk22=null;
        ASSQLParser.table_name_return a = null;

        ASSQLParser.table_name_return c = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:5: ( (fn= COUNT OParen )? Asterisk ( CParen )? | a= table_name Dot b= Asterisk ( Comma c= table_name Dot d= Asterisk )* | select_column_list )
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=COUNT && LA30_0<=Asterisk)) ) {
                alt30=1;
            }
            else if ( (LA30_0==Identifier) ) {
                int LA30_2 = input.LA(2);

                if ( (LA30_2==Dot) ) {
                    int LA30_3 = input.LA(3);

                    if ( (LA30_3==Asterisk) ) {
                        alt30=2;
                    }
                    else if ( (LA30_3==Identifier) ) {
                        alt30=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA30_2==Comma||LA30_2==FROM||LA30_2==AS) ) {
                    alt30=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:7: (fn= COUNT OParen )? Asterisk ( CParen )?
                    {
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:7: (fn= COUNT OParen )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==COUNT) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:8: fn= COUNT OParen
                            {
                            fn=(Token)match(input,COUNT,FOLLOW_COUNT_in_select_list1536); 
                            match(input,OParen,FOLLOW_OParen_in_select_list1538); 

                            }
                            break;

                    }

                    Asterisk22=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_select_list1542); 
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:35: ( CParen )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==CParen) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:36: CParen
                            {
                            match(input,CParen,FOLLOW_CParen_in_select_list1545); 

                            }
                            break;

                    }

                     addColumnInfo((Asterisk22!=null?Asterisk22.getText():null), null, null, (fn!=null?fn.getText():null)); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:290:7: a= table_name Dot b= Asterisk ( Comma c= table_name Dot d= Asterisk )*
                    {
                    pushFollow(FOLLOW_table_name_in_select_list1559);
                    a=table_name();

                    state._fsp--;

                    match(input,Dot,FOLLOW_Dot_in_select_list1561); 
                    b=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_select_list1565); 
                     addColumnInfo((b!=null?b.getText():null), (a!=null?input.toString(a.start,a.stop):null), null, null); 
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:291:7: ( Comma c= table_name Dot d= Asterisk )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==Comma) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:291:8: Comma c= table_name Dot d= Asterisk
                    	    {
                    	    match(input,Comma,FOLLOW_Comma_in_select_list1576); 
                    	    pushFollow(FOLLOW_table_name_in_select_list1580);
                    	    c=table_name();

                    	    state._fsp--;

                    	    match(input,Dot,FOLLOW_Dot_in_select_list1582); 
                    	    d=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_select_list1586); 
                    	     addColumnInfo((d!=null?d.getText():null), (c!=null?input.toString(c.start,c.stop):null), null, null); 

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:292:7: select_column_list
                    {
                    pushFollow(FOLLOW_select_column_list_in_select_list1598);
                    select_column_list();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "select_list"

    public static class select_quantifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "select_quantifier"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:295:1: select_quantifier : ( ALL | DISTINCT );
    public final ASSQLParser.select_quantifier_return select_quantifier() throws RecognitionException {
        ASSQLParser.select_quantifier_return retval = new ASSQLParser.select_quantifier_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:296:5: ( ALL | DISTINCT )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:
            {
            if ( (input.LA(1)>=ALL && input.LA(1)<=DISTINCT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "select_quantifier"

    public static class set_clause_return extends ParserRuleReturnScope {
        public String cname;
        public String cvalue;
    };

    // $ANTLR start "set_clause"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:300:1: set_clause returns [String cname, String cvalue] : c= column_name Equals v= column_value ;
    public final ASSQLParser.set_clause_return set_clause() throws RecognitionException {
        ASSQLParser.set_clause_return retval = new ASSQLParser.set_clause_return();
        retval.start = input.LT(1);

        ASSQLParser.column_name_return c = null;

        ASSQLParser.column_value_return v = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:301:5: (c= column_name Equals v= column_value )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:301:7: c= column_name Equals v= column_value
            {
            pushFollow(FOLLOW_column_name_in_set_clause1646);
            c=column_name();

            state._fsp--;

            match(input,Equals,FOLLOW_Equals_in_set_clause1648); 
            pushFollow(FOLLOW_column_value_in_set_clause1652);
            v=column_value();

            state._fsp--;

             retval.cname = (c!=null?input.toString(c.start,c.stop):null); retval.cvalue = (v!=null?input.toString(v.start,v.stop):null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "set_clause"

    public static class space_property_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_property"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:304:1: space_property returns [String key, String value] : ( space_capacity | space_cache_policy | space_distribution_policy | space_eviction_policy | space_file_sync_interval | space_forget_old_value | space_host_aware_replication | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_query_limit | space_query_timeout | space_read_timeout | space_replication_count | space_replication_policy | space_routed | space_ttl | space_update_transport | space_virtual_node_count | space_wait | space_write_timeout ) ;
    public final ASSQLParser.space_property_return space_property() throws RecognitionException {
        ASSQLParser.space_property_return retval = new ASSQLParser.space_property_return();
        retval.start = input.LT(1);

        ASSQLParser.space_capacity_return space_capacity23 = null;

        ASSQLParser.space_cache_policy_return space_cache_policy24 = null;

        ASSQLParser.space_distribution_policy_return space_distribution_policy25 = null;

        ASSQLParser.space_eviction_policy_return space_eviction_policy26 = null;

        ASSQLParser.space_file_sync_interval_return space_file_sync_interval27 = null;

        ASSQLParser.space_forget_old_value_return space_forget_old_value28 = null;

        ASSQLParser.space_host_aware_replication_return space_host_aware_replication29 = null;

        ASSQLParser.space_lock_scope_return space_lock_scope30 = null;

        ASSQLParser.space_lock_ttl_return space_lock_ttl31 = null;

        ASSQLParser.space_lock_wait_return space_lock_wait32 = null;

        ASSQLParser.space_min_seeders_return space_min_seeders33 = null;

        ASSQLParser.space_persistence_policy_return space_persistence_policy34 = null;

        ASSQLParser.space_persistence_type_return space_persistence_type35 = null;

        ASSQLParser.space_phase_count_return space_phase_count36 = null;

        ASSQLParser.space_phase_interval_return space_phase_interval37 = null;

        ASSQLParser.space_query_limit_return space_query_limit38 = null;

        ASSQLParser.space_query_timeout_return space_query_timeout39 = null;

        ASSQLParser.space_read_timeout_return space_read_timeout40 = null;

        ASSQLParser.space_replication_count_return space_replication_count41 = null;

        ASSQLParser.space_replication_policy_return space_replication_policy42 = null;

        ASSQLParser.space_routed_return space_routed43 = null;

        ASSQLParser.space_ttl_return space_ttl44 = null;

        ASSQLParser.space_update_transport_return space_update_transport45 = null;

        ASSQLParser.space_virtual_node_count_return space_virtual_node_count46 = null;

        ASSQLParser.space_wait_return space_wait47 = null;

        ASSQLParser.space_write_timeout_return space_write_timeout48 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:305:5: ( ( space_capacity | space_cache_policy | space_distribution_policy | space_eviction_policy | space_file_sync_interval | space_forget_old_value | space_host_aware_replication | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_query_limit | space_query_timeout | space_read_timeout | space_replication_count | space_replication_policy | space_routed | space_ttl | space_update_transport | space_virtual_node_count | space_wait | space_write_timeout ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:305:7: ( space_capacity | space_cache_policy | space_distribution_policy | space_eviction_policy | space_file_sync_interval | space_forget_old_value | space_host_aware_replication | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_query_limit | space_query_timeout | space_read_timeout | space_replication_count | space_replication_policy | space_routed | space_ttl | space_update_transport | space_virtual_node_count | space_wait | space_write_timeout )
            {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:305:7: ( space_capacity | space_cache_policy | space_distribution_policy | space_eviction_policy | space_file_sync_interval | space_forget_old_value | space_host_aware_replication | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_query_limit | space_query_timeout | space_read_timeout | space_replication_count | space_replication_policy | space_routed | space_ttl | space_update_transport | space_virtual_node_count | space_wait | space_write_timeout )
            int alt31=26;
            switch ( input.LA(1) ) {
            case CAPACITY:
                {
                alt31=1;
                }
                break;
            case CACHE_POLICY:
                {
                alt31=2;
                }
                break;
            case DISTRIBUTION_POLICY:
                {
                alt31=3;
                }
                break;
            case EVICTION_POLICY:
                {
                alt31=4;
                }
                break;
            case FILE_SYNC_INTERVAL:
                {
                alt31=5;
                }
                break;
            case FORGET_OLD_VALUE:
                {
                alt31=6;
                }
                break;
            case HOST_AWARE_REPLICATION:
                {
                alt31=7;
                }
                break;
            case LOCK_SCOPE:
                {
                alt31=8;
                }
                break;
            case LOCK_TTL:
                {
                alt31=9;
                }
                break;
            case LOCK_WAIT:
                {
                alt31=10;
                }
                break;
            case MIN_SEEDERS:
                {
                alt31=11;
                }
                break;
            case PERSISTENCE_POLICY:
                {
                alt31=12;
                }
                break;
            case PERSISTENCE:
            case PERSISTENCE_TYPE:
                {
                alt31=13;
                }
                break;
            case PHASE_COUNT:
                {
                alt31=14;
                }
                break;
            case PHASE_INTERVAL:
                {
                alt31=15;
                }
                break;
            case QUERY_LIMIT:
                {
                alt31=16;
                }
                break;
            case QUERY_TIMEOUT:
                {
                alt31=17;
                }
                break;
            case READ_TIMEOUT:
                {
                alt31=18;
                }
                break;
            case REPLICATION_COUNT:
                {
                alt31=19;
                }
                break;
            case REPLICATION_POLICY:
                {
                alt31=20;
                }
                break;
            case ROUTED:
                {
                alt31=21;
                }
                break;
            case TTL:
                {
                alt31=22;
                }
                break;
            case UPDATE_TRANSPORT:
                {
                alt31=23;
                }
                break;
            case VIRTUAL_NODE_COUNT:
                {
                alt31=24;
                }
                break;
            case SPACE_WAIT:
                {
                alt31=25;
                }
                break;
            case WRITE_TIMEOUT:
                {
                alt31=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:305:11: space_capacity
                    {
                    pushFollow(FOLLOW_space_capacity_in_space_property1679);
                    space_capacity23=space_capacity();

                    state._fsp--;

                     retval.key = (space_capacity23!=null?space_capacity23.key:null); retval.value = (space_capacity23!=null?space_capacity23.value:null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:306:11: space_cache_policy
                    {
                    pushFollow(FOLLOW_space_cache_policy_in_space_property1693);
                    space_cache_policy24=space_cache_policy();

                    state._fsp--;

                     retval.key = (space_cache_policy24!=null?space_cache_policy24.key:null); retval.value = (space_cache_policy24!=null?space_cache_policy24.value:null); 

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:307:11: space_distribution_policy
                    {
                    pushFollow(FOLLOW_space_distribution_policy_in_space_property1707);
                    space_distribution_policy25=space_distribution_policy();

                    state._fsp--;

                     retval.key = (space_distribution_policy25!=null?space_distribution_policy25.key:null); retval.value = (space_distribution_policy25!=null?space_distribution_policy25.value:null); 

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:308:11: space_eviction_policy
                    {
                    pushFollow(FOLLOW_space_eviction_policy_in_space_property1721);
                    space_eviction_policy26=space_eviction_policy();

                    state._fsp--;

                     retval.key = (space_eviction_policy26!=null?space_eviction_policy26.key:null); retval.value = (space_eviction_policy26!=null?space_eviction_policy26.value:null); 

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:309:11: space_file_sync_interval
                    {
                    pushFollow(FOLLOW_space_file_sync_interval_in_space_property1735);
                    space_file_sync_interval27=space_file_sync_interval();

                    state._fsp--;

                     retval.key = (space_file_sync_interval27!=null?space_file_sync_interval27.key:null); retval.value = (space_file_sync_interval27!=null?space_file_sync_interval27.value:null); 

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:310:11: space_forget_old_value
                    {
                    pushFollow(FOLLOW_space_forget_old_value_in_space_property1749);
                    space_forget_old_value28=space_forget_old_value();

                    state._fsp--;

                     retval.key = (space_forget_old_value28!=null?space_forget_old_value28.key:null); retval.value = (space_forget_old_value28!=null?space_forget_old_value28.value:null); 

                    }
                    break;
                case 7 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:311:11: space_host_aware_replication
                    {
                    pushFollow(FOLLOW_space_host_aware_replication_in_space_property1763);
                    space_host_aware_replication29=space_host_aware_replication();

                    state._fsp--;

                     retval.key = (space_host_aware_replication29!=null?space_host_aware_replication29.key:null); retval.value = (space_host_aware_replication29!=null?space_host_aware_replication29.value:null); 

                    }
                    break;
                case 8 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:312:11: space_lock_scope
                    {
                    pushFollow(FOLLOW_space_lock_scope_in_space_property1777);
                    space_lock_scope30=space_lock_scope();

                    state._fsp--;

                     retval.key = (space_lock_scope30!=null?space_lock_scope30.key:null); retval.value = (space_lock_scope30!=null?space_lock_scope30.value:null); 

                    }
                    break;
                case 9 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:313:11: space_lock_ttl
                    {
                    pushFollow(FOLLOW_space_lock_ttl_in_space_property1791);
                    space_lock_ttl31=space_lock_ttl();

                    state._fsp--;

                     retval.key = (space_lock_ttl31!=null?space_lock_ttl31.key:null); retval.value = (space_lock_ttl31!=null?space_lock_ttl31.value:null); 

                    }
                    break;
                case 10 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:314:11: space_lock_wait
                    {
                    pushFollow(FOLLOW_space_lock_wait_in_space_property1805);
                    space_lock_wait32=space_lock_wait();

                    state._fsp--;

                     retval.key = (space_lock_wait32!=null?space_lock_wait32.key:null); retval.value = (space_lock_wait32!=null?space_lock_wait32.value:null); 

                    }
                    break;
                case 11 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:315:11: space_min_seeders
                    {
                    pushFollow(FOLLOW_space_min_seeders_in_space_property1819);
                    space_min_seeders33=space_min_seeders();

                    state._fsp--;

                     retval.key = (space_min_seeders33!=null?space_min_seeders33.key:null); retval.value = (space_min_seeders33!=null?space_min_seeders33.value:null); 

                    }
                    break;
                case 12 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:316:11: space_persistence_policy
                    {
                    pushFollow(FOLLOW_space_persistence_policy_in_space_property1833);
                    space_persistence_policy34=space_persistence_policy();

                    state._fsp--;

                     retval.key = (space_persistence_policy34!=null?space_persistence_policy34.key:null); retval.value = (space_persistence_policy34!=null?space_persistence_policy34.value:null); 

                    }
                    break;
                case 13 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:317:11: space_persistence_type
                    {
                    pushFollow(FOLLOW_space_persistence_type_in_space_property1847);
                    space_persistence_type35=space_persistence_type();

                    state._fsp--;

                     retval.key = (space_persistence_type35!=null?space_persistence_type35.key:null); retval.value = (space_persistence_type35!=null?space_persistence_type35.value:null); 

                    }
                    break;
                case 14 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:318:11: space_phase_count
                    {
                    pushFollow(FOLLOW_space_phase_count_in_space_property1861);
                    space_phase_count36=space_phase_count();

                    state._fsp--;

                     retval.key = (space_phase_count36!=null?space_phase_count36.key:null); retval.value = (space_phase_count36!=null?space_phase_count36.value:null); 

                    }
                    break;
                case 15 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:319:11: space_phase_interval
                    {
                    pushFollow(FOLLOW_space_phase_interval_in_space_property1875);
                    space_phase_interval37=space_phase_interval();

                    state._fsp--;

                     retval.key = (space_phase_interval37!=null?space_phase_interval37.key:null); retval.value = (space_phase_interval37!=null?space_phase_interval37.value:null); 

                    }
                    break;
                case 16 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:320:11: space_query_limit
                    {
                    pushFollow(FOLLOW_space_query_limit_in_space_property1889);
                    space_query_limit38=space_query_limit();

                    state._fsp--;

                     retval.key = (space_query_limit38!=null?space_query_limit38.key:null); retval.value = (space_query_limit38!=null?space_query_limit38.value:null); 

                    }
                    break;
                case 17 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:321:11: space_query_timeout
                    {
                    pushFollow(FOLLOW_space_query_timeout_in_space_property1903);
                    space_query_timeout39=space_query_timeout();

                    state._fsp--;

                     retval.key = (space_query_timeout39!=null?space_query_timeout39.key:null); retval.value = (space_query_timeout39!=null?space_query_timeout39.value:null); 

                    }
                    break;
                case 18 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:322:11: space_read_timeout
                    {
                    pushFollow(FOLLOW_space_read_timeout_in_space_property1917);
                    space_read_timeout40=space_read_timeout();

                    state._fsp--;

                     retval.key = (space_read_timeout40!=null?space_read_timeout40.key:null); retval.value = (space_read_timeout40!=null?space_read_timeout40.value:null); 

                    }
                    break;
                case 19 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:323:11: space_replication_count
                    {
                    pushFollow(FOLLOW_space_replication_count_in_space_property1931);
                    space_replication_count41=space_replication_count();

                    state._fsp--;

                     retval.key = (space_replication_count41!=null?space_replication_count41.key:null); retval.value = (space_replication_count41!=null?space_replication_count41.value:null); 

                    }
                    break;
                case 20 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:324:11: space_replication_policy
                    {
                    pushFollow(FOLLOW_space_replication_policy_in_space_property1945);
                    space_replication_policy42=space_replication_policy();

                    state._fsp--;

                     retval.key = (space_replication_policy42!=null?space_replication_policy42.key:null); retval.value = (space_replication_policy42!=null?space_replication_policy42.value:null); 

                    }
                    break;
                case 21 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:325:11: space_routed
                    {
                    pushFollow(FOLLOW_space_routed_in_space_property1959);
                    space_routed43=space_routed();

                    state._fsp--;

                     retval.key = (space_routed43!=null?space_routed43.key:null); retval.value = (space_routed43!=null?space_routed43.value:null); 

                    }
                    break;
                case 22 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:326:11: space_ttl
                    {
                    pushFollow(FOLLOW_space_ttl_in_space_property1973);
                    space_ttl44=space_ttl();

                    state._fsp--;

                     retval.key = (space_ttl44!=null?space_ttl44.key:null); retval.value = (space_ttl44!=null?space_ttl44.value:null); 

                    }
                    break;
                case 23 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:327:11: space_update_transport
                    {
                    pushFollow(FOLLOW_space_update_transport_in_space_property1987);
                    space_update_transport45=space_update_transport();

                    state._fsp--;

                     retval.key = (space_update_transport45!=null?space_update_transport45.key:null); retval.value = (space_update_transport45!=null?space_update_transport45.value:null); 

                    }
                    break;
                case 24 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:328:11: space_virtual_node_count
                    {
                    pushFollow(FOLLOW_space_virtual_node_count_in_space_property2001);
                    space_virtual_node_count46=space_virtual_node_count();

                    state._fsp--;

                     retval.key = (space_virtual_node_count46!=null?space_virtual_node_count46.key:null); retval.value = (space_virtual_node_count46!=null?space_virtual_node_count46.value:null); 

                    }
                    break;
                case 25 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:329:11: space_wait
                    {
                    pushFollow(FOLLOW_space_wait_in_space_property2015);
                    space_wait47=space_wait();

                    state._fsp--;

                     retval.key = (space_wait47!=null?space_wait47.key:null); retval.value = (space_wait47!=null?space_wait47.value:null); 

                    }
                    break;
                case 26 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:330:11: space_write_timeout
                    {
                    pushFollow(FOLLOW_space_write_timeout_in_space_property2029);
                    space_write_timeout48=space_write_timeout();

                    state._fsp--;

                     retval.key = (space_write_timeout48!=null?space_write_timeout48.key:null); retval.value = (space_write_timeout48!=null?space_write_timeout48.value:null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_property"

    public static class space_capacity_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_capacity"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:334:1: space_capacity returns [String key, String value] : CAPACITY ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_capacity_return space_capacity() throws RecognitionException {
        ASSQLParser.space_capacity_return retval = new ASSQLParser.space_capacity_return();
        retval.start = input.LT(1);

        Token NegativeNumber49=null;
        Token PositiveNumber50=null;

         retval.key = CreateStatement.CAPACITY; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:336:5: ( CAPACITY ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:336:7: CAPACITY ( NegativeNumber | PositiveNumber )
            {
            match(input,CAPACITY,FOLLOW_CAPACITY_in_space_capacity2069); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:336:16: ( NegativeNumber | PositiveNumber )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==NegativeNumber) ) {
                alt32=1;
            }
            else if ( (LA32_0==PositiveNumber) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:336:18: NegativeNumber
                    {
                    NegativeNumber49=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_capacity2073); 
                     retval.value = (NegativeNumber49!=null?NegativeNumber49.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:336:70: PositiveNumber
                    {
                    PositiveNumber50=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_capacity2079); 
                     retval.value = (PositiveNumber50!=null?PositiveNumber50.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_capacity"

    public static class space_cache_policy_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_cache_policy"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:339:1: space_cache_policy returns [String key, String value] : ( CACHE_POLICY READ_WRITE_THROUGH | CACHE_POLICY READ_THROUGH );
    public final ASSQLParser.space_cache_policy_return space_cache_policy() throws RecognitionException {
        ASSQLParser.space_cache_policy_return retval = new ASSQLParser.space_cache_policy_return();
        retval.start = input.LT(1);

        Token READ_WRITE_THROUGH51=null;
        Token READ_THROUGH52=null;

         retval.key = CreateStatement.CACHE_POLICY; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:341:5: ( CACHE_POLICY READ_WRITE_THROUGH | CACHE_POLICY READ_THROUGH )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==CACHE_POLICY) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==READ_WRITE_THROUGH) ) {
                    alt33=1;
                }
                else if ( (LA33_1==READ_THROUGH) ) {
                    alt33=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:341:7: CACHE_POLICY READ_WRITE_THROUGH
                    {
                    match(input,CACHE_POLICY,FOLLOW_CACHE_POLICY_in_space_cache_policy2113); 
                    READ_WRITE_THROUGH51=(Token)match(input,READ_WRITE_THROUGH,FOLLOW_READ_WRITE_THROUGH_in_space_cache_policy2115); 
                     retval.value = (READ_WRITE_THROUGH51!=null?READ_WRITE_THROUGH51.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:342:7: CACHE_POLICY READ_THROUGH
                    {
                    match(input,CACHE_POLICY,FOLLOW_CACHE_POLICY_in_space_cache_policy2125); 
                    READ_THROUGH52=(Token)match(input,READ_THROUGH,FOLLOW_READ_THROUGH_in_space_cache_policy2127); 
                     retval.value = (READ_THROUGH52!=null?READ_THROUGH52.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_cache_policy"

    public static class space_distribution_policy_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_distribution_policy"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:346:1: space_distribution_policy returns [String key, String value] : ( DISTRIBUTION_POLICY DISTRIBUTED | DISTRIBUTION_POLICY NON_DISTRIBUTED );
    public final ASSQLParser.space_distribution_policy_return space_distribution_policy() throws RecognitionException {
        ASSQLParser.space_distribution_policy_return retval = new ASSQLParser.space_distribution_policy_return();
        retval.start = input.LT(1);

        Token DISTRIBUTED53=null;
        Token NON_DISTRIBUTED54=null;

         retval.key = CreateStatement.DISTRIBUTION_POLICY; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:348:5: ( DISTRIBUTION_POLICY DISTRIBUTED | DISTRIBUTION_POLICY NON_DISTRIBUTED )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==DISTRIBUTION_POLICY) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==DISTRIBUTED) ) {
                    alt34=1;
                }
                else if ( (LA34_1==NON_DISTRIBUTED) ) {
                    alt34=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:348:7: DISTRIBUTION_POLICY DISTRIBUTED
                    {
                    match(input,DISTRIBUTION_POLICY,FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy2165); 
                    DISTRIBUTED53=(Token)match(input,DISTRIBUTED,FOLLOW_DISTRIBUTED_in_space_distribution_policy2167); 
                     retval.value = (DISTRIBUTED53!=null?DISTRIBUTED53.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:349:7: DISTRIBUTION_POLICY NON_DISTRIBUTED
                    {
                    match(input,DISTRIBUTION_POLICY,FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy2177); 
                    NON_DISTRIBUTED54=(Token)match(input,NON_DISTRIBUTED,FOLLOW_NON_DISTRIBUTED_in_space_distribution_policy2179); 
                     retval.value = (NON_DISTRIBUTED54!=null?NON_DISTRIBUTED54.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_distribution_policy"

    public static class space_eviction_policy_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_eviction_policy"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:352:1: space_eviction_policy returns [String key, String value] : ( EVICTION_POLICY NONE | EVICTION_POLICY LRU );
    public final ASSQLParser.space_eviction_policy_return space_eviction_policy() throws RecognitionException {
        ASSQLParser.space_eviction_policy_return retval = new ASSQLParser.space_eviction_policy_return();
        retval.start = input.LT(1);

        Token NONE55=null;
        Token LRU56=null;

         retval.key = CreateStatement.EVICTION_POLICY; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:354:5: ( EVICTION_POLICY NONE | EVICTION_POLICY LRU )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==EVICTION_POLICY) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==NONE) ) {
                    alt35=1;
                }
                else if ( (LA35_1==LRU) ) {
                    alt35=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:354:7: EVICTION_POLICY NONE
                    {
                    match(input,EVICTION_POLICY,FOLLOW_EVICTION_POLICY_in_space_eviction_policy2215); 
                    NONE55=(Token)match(input,NONE,FOLLOW_NONE_in_space_eviction_policy2217); 
                     retval.value = (NONE55!=null?NONE55.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:355:7: EVICTION_POLICY LRU
                    {
                    match(input,EVICTION_POLICY,FOLLOW_EVICTION_POLICY_in_space_eviction_policy2227); 
                    LRU56=(Token)match(input,LRU,FOLLOW_LRU_in_space_eviction_policy2229); 
                     retval.value = (LRU56!=null?LRU56.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_eviction_policy"

    public static class space_file_sync_interval_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_file_sync_interval"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:358:1: space_file_sync_interval returns [String key, String value] : FILE_SYNC_INTERVAL ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_file_sync_interval_return space_file_sync_interval() throws RecognitionException {
        ASSQLParser.space_file_sync_interval_return retval = new ASSQLParser.space_file_sync_interval_return();
        retval.start = input.LT(1);

        Token NegativeNumber57=null;
        Token PositiveNumber58=null;

         retval.key = CreateStatement.FILE_SYNC_INTERVAL; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:360:5: ( FILE_SYNC_INTERVAL ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:360:7: FILE_SYNC_INTERVAL ( NegativeNumber | PositiveNumber )
            {
            match(input,FILE_SYNC_INTERVAL,FOLLOW_FILE_SYNC_INTERVAL_in_space_file_sync_interval2261); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:360:26: ( NegativeNumber | PositiveNumber )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==NegativeNumber) ) {
                alt36=1;
            }
            else if ( (LA36_0==PositiveNumber) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:360:28: NegativeNumber
                    {
                    NegativeNumber57=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_file_sync_interval2265); 
                     retval.value = (NegativeNumber57!=null?NegativeNumber57.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:360:80: PositiveNumber
                    {
                    PositiveNumber58=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_file_sync_interval2271); 
                     retval.value = (PositiveNumber58!=null?PositiveNumber58.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_file_sync_interval"

    public static class space_forget_old_value_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_forget_old_value"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:363:1: space_forget_old_value returns [String key, String value] : ( FORGET_OLD_VALUE TRUE | FORGET_OLD_VALUE FALSE );
    public final ASSQLParser.space_forget_old_value_return space_forget_old_value() throws RecognitionException {
        ASSQLParser.space_forget_old_value_return retval = new ASSQLParser.space_forget_old_value_return();
        retval.start = input.LT(1);

        Token TRUE59=null;
        Token FALSE60=null;

         retval.key = CreateStatement.FORGET_OLD_VALUE; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:365:5: ( FORGET_OLD_VALUE TRUE | FORGET_OLD_VALUE FALSE )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==FORGET_OLD_VALUE) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==TRUE) ) {
                    alt37=1;
                }
                else if ( (LA37_1==FALSE) ) {
                    alt37=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:365:7: FORGET_OLD_VALUE TRUE
                    {
                    match(input,FORGET_OLD_VALUE,FOLLOW_FORGET_OLD_VALUE_in_space_forget_old_value2305); 
                    TRUE59=(Token)match(input,TRUE,FOLLOW_TRUE_in_space_forget_old_value2307); 
                     retval.value = (TRUE59!=null?TRUE59.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:366:7: FORGET_OLD_VALUE FALSE
                    {
                    match(input,FORGET_OLD_VALUE,FOLLOW_FORGET_OLD_VALUE_in_space_forget_old_value2317); 
                    FALSE60=(Token)match(input,FALSE,FOLLOW_FALSE_in_space_forget_old_value2319); 
                     retval.value = (FALSE60!=null?FALSE60.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_forget_old_value"

    public static class space_host_aware_replication_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_host_aware_replication"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:369:1: space_host_aware_replication returns [String key, String value] : ( HOST_AWARE_REPLICATION TRUE | HOST_AWARE_REPLICATION FALSE );
    public final ASSQLParser.space_host_aware_replication_return space_host_aware_replication() throws RecognitionException {
        ASSQLParser.space_host_aware_replication_return retval = new ASSQLParser.space_host_aware_replication_return();
        retval.start = input.LT(1);

        Token TRUE61=null;
        Token FALSE62=null;

         retval.key = CreateStatement.HOST_AWARE_REPLICATION; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:371:5: ( HOST_AWARE_REPLICATION TRUE | HOST_AWARE_REPLICATION FALSE )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==HOST_AWARE_REPLICATION) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==TRUE) ) {
                    alt38=1;
                }
                else if ( (LA38_1==FALSE) ) {
                    alt38=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:371:7: HOST_AWARE_REPLICATION TRUE
                    {
                    match(input,HOST_AWARE_REPLICATION,FOLLOW_HOST_AWARE_REPLICATION_in_space_host_aware_replication2351); 
                    TRUE61=(Token)match(input,TRUE,FOLLOW_TRUE_in_space_host_aware_replication2353); 
                     retval.value = (TRUE61!=null?TRUE61.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:372:7: HOST_AWARE_REPLICATION FALSE
                    {
                    match(input,HOST_AWARE_REPLICATION,FOLLOW_HOST_AWARE_REPLICATION_in_space_host_aware_replication2363); 
                    FALSE62=(Token)match(input,FALSE,FOLLOW_FALSE_in_space_host_aware_replication2365); 
                     retval.value = (FALSE62!=null?FALSE62.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_host_aware_replication"

    public static class space_lock_scope_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_lock_scope"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:375:1: space_lock_scope returns [String key, String value] : ( LOCK_SCOPE THREAD | LOCK_SCOPE PROCESS );
    public final ASSQLParser.space_lock_scope_return space_lock_scope() throws RecognitionException {
        ASSQLParser.space_lock_scope_return retval = new ASSQLParser.space_lock_scope_return();
        retval.start = input.LT(1);

        Token THREAD63=null;
        Token PROCESS64=null;

         retval.key = CreateStatement.LOCK_SCOPE; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:377:5: ( LOCK_SCOPE THREAD | LOCK_SCOPE PROCESS )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LOCK_SCOPE) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==THREAD) ) {
                    alt39=1;
                }
                else if ( (LA39_1==PROCESS) ) {
                    alt39=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:377:7: LOCK_SCOPE THREAD
                    {
                    match(input,LOCK_SCOPE,FOLLOW_LOCK_SCOPE_in_space_lock_scope2397); 
                    THREAD63=(Token)match(input,THREAD,FOLLOW_THREAD_in_space_lock_scope2399); 
                     retval.value = (THREAD63!=null?THREAD63.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:378:7: LOCK_SCOPE PROCESS
                    {
                    match(input,LOCK_SCOPE,FOLLOW_LOCK_SCOPE_in_space_lock_scope2409); 
                    PROCESS64=(Token)match(input,PROCESS,FOLLOW_PROCESS_in_space_lock_scope2411); 
                     retval.value = (PROCESS64!=null?PROCESS64.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_lock_scope"

    public static class space_lock_ttl_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_lock_ttl"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:381:1: space_lock_ttl returns [String key, String value] : LOCK_TTL ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_lock_ttl_return space_lock_ttl() throws RecognitionException {
        ASSQLParser.space_lock_ttl_return retval = new ASSQLParser.space_lock_ttl_return();
        retval.start = input.LT(1);

        Token NegativeNumber65=null;
        Token PositiveNumber66=null;

         retval.key = CreateStatement.LOCK_TTL; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:383:5: ( LOCK_TTL ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:383:7: LOCK_TTL ( NegativeNumber | PositiveNumber )
            {
            match(input,LOCK_TTL,FOLLOW_LOCK_TTL_in_space_lock_ttl2443); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:383:16: ( NegativeNumber | PositiveNumber )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==NegativeNumber) ) {
                alt40=1;
            }
            else if ( (LA40_0==PositiveNumber) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:383:18: NegativeNumber
                    {
                    NegativeNumber65=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_lock_ttl2447); 
                     retval.value = (NegativeNumber65!=null?NegativeNumber65.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:383:70: PositiveNumber
                    {
                    PositiveNumber66=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_lock_ttl2453); 
                     retval.value = (PositiveNumber66!=null?PositiveNumber66.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_lock_ttl"

    public static class space_lock_wait_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_lock_wait"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:386:1: space_lock_wait returns [String key, String value] : LOCK_WAIT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_lock_wait_return space_lock_wait() throws RecognitionException {
        ASSQLParser.space_lock_wait_return retval = new ASSQLParser.space_lock_wait_return();
        retval.start = input.LT(1);

        Token NegativeNumber67=null;
        Token PositiveNumber68=null;

         retval.key = CreateStatement.LOCK_WAIT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:388:5: ( LOCK_WAIT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:388:7: LOCK_WAIT ( NegativeNumber | PositiveNumber )
            {
            match(input,LOCK_WAIT,FOLLOW_LOCK_WAIT_in_space_lock_wait2487); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:388:17: ( NegativeNumber | PositiveNumber )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==NegativeNumber) ) {
                alt41=1;
            }
            else if ( (LA41_0==PositiveNumber) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:388:19: NegativeNumber
                    {
                    NegativeNumber67=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_lock_wait2491); 
                     retval.value = (NegativeNumber67!=null?NegativeNumber67.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:388:71: PositiveNumber
                    {
                    PositiveNumber68=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_lock_wait2497); 
                     retval.value = (PositiveNumber68!=null?PositiveNumber68.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_lock_wait"

    public static class space_min_seeders_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_min_seeders"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:391:1: space_min_seeders returns [String key, String value] : MIN_SEEDERS PositiveNumber ;
    public final ASSQLParser.space_min_seeders_return space_min_seeders() throws RecognitionException {
        ASSQLParser.space_min_seeders_return retval = new ASSQLParser.space_min_seeders_return();
        retval.start = input.LT(1);

        Token PositiveNumber69=null;

         retval.key = CreateStatement.MIN_SEEDERS; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:393:5: ( MIN_SEEDERS PositiveNumber )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:393:7: MIN_SEEDERS PositiveNumber
            {
            match(input,MIN_SEEDERS,FOLLOW_MIN_SEEDERS_in_space_min_seeders2532); 
            PositiveNumber69=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_min_seeders2534); 
             retval.value = (PositiveNumber69!=null?PositiveNumber69.getText():null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_min_seeders"

    public static class space_persistence_policy_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_persistence_policy"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:396:1: space_persistence_policy returns [String key, String value] : ( PERSISTENCE_POLICY SYNC | PERSISTENCE_POLICY ASYNC );
    public final ASSQLParser.space_persistence_policy_return space_persistence_policy() throws RecognitionException {
        ASSQLParser.space_persistence_policy_return retval = new ASSQLParser.space_persistence_policy_return();
        retval.start = input.LT(1);

        Token SYNC70=null;
        Token ASYNC71=null;

         retval.key = CreateStatement.PERSISTENCE_POLICY; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:398:5: ( PERSISTENCE_POLICY SYNC | PERSISTENCE_POLICY ASYNC )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==PERSISTENCE_POLICY) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==SYNC) ) {
                    alt42=1;
                }
                else if ( (LA42_1==ASYNC) ) {
                    alt42=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:398:7: PERSISTENCE_POLICY SYNC
                    {
                    match(input,PERSISTENCE_POLICY,FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2570); 
                    SYNC70=(Token)match(input,SYNC,FOLLOW_SYNC_in_space_persistence_policy2572); 
                     retval.value = (SYNC70!=null?SYNC70.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:399:7: PERSISTENCE_POLICY ASYNC
                    {
                    match(input,PERSISTENCE_POLICY,FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2582); 
                    ASYNC71=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_space_persistence_policy2584); 
                     retval.value = (ASYNC71!=null?ASYNC71.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_persistence_policy"

    public static class space_persistence_type_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_persistence_type"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:402:1: space_persistence_type returns [String key, String value] : ( PERSISTENCE a= NONE | PERSISTENCE b= ( SHARED_ALL ) | PERSISTENCE c= ( SHARED_NOTHING ) | PERSISTENCE_TYPE d= NONE | PERSISTENCE_TYPE e= ( SHARED_ALL ) | PERSISTENCE_TYPE f= ( SHARED_NOTHING ) );
    public final ASSQLParser.space_persistence_type_return space_persistence_type() throws RecognitionException {
        ASSQLParser.space_persistence_type_return retval = new ASSQLParser.space_persistence_type_return();
        retval.start = input.LT(1);

        Token a=null;
        Token b=null;
        Token c=null;
        Token d=null;
        Token e=null;
        Token f=null;

         retval.key = CreateStatement.PERSISTENCE_TYPE; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:404:5: ( PERSISTENCE a= NONE | PERSISTENCE b= ( SHARED_ALL ) | PERSISTENCE c= ( SHARED_NOTHING ) | PERSISTENCE_TYPE d= NONE | PERSISTENCE_TYPE e= ( SHARED_ALL ) | PERSISTENCE_TYPE f= ( SHARED_NOTHING ) )
            int alt43=6;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==PERSISTENCE) ) {
                switch ( input.LA(2) ) {
                case NONE:
                    {
                    alt43=1;
                    }
                    break;
                case SHARED_ALL:
                    {
                    alt43=2;
                    }
                    break;
                case SHARED_NOTHING:
                    {
                    alt43=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA43_0==PERSISTENCE_TYPE) ) {
                switch ( input.LA(2) ) {
                case NONE:
                    {
                    alt43=4;
                    }
                    break;
                case SHARED_NOTHING:
                    {
                    alt43=6;
                    }
                    break;
                case SHARED_ALL:
                    {
                    alt43=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:404:7: PERSISTENCE a= NONE
                    {
                    match(input,PERSISTENCE,FOLLOW_PERSISTENCE_in_space_persistence_type2618); 
                    a=(Token)match(input,NONE,FOLLOW_NONE_in_space_persistence_type2622); 
                     retval.value = (a!=null?a.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:405:7: PERSISTENCE b= ( SHARED_ALL )
                    {
                    match(input,PERSISTENCE,FOLLOW_PERSISTENCE_in_space_persistence_type2632); 
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:405:21: ( SHARED_ALL )
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:405:22: SHARED_ALL
                    {
                    match(input,SHARED_ALL,FOLLOW_SHARED_ALL_in_space_persistence_type2637); 

                    }

                     retval.value = (b!=null?b.getText():null).toLowerCase(); 

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:406:7: PERSISTENCE c= ( SHARED_NOTHING )
                    {
                    match(input,PERSISTENCE,FOLLOW_PERSISTENCE_in_space_persistence_type2648); 
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:406:21: ( SHARED_NOTHING )
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:406:22: SHARED_NOTHING
                    {
                    match(input,SHARED_NOTHING,FOLLOW_SHARED_NOTHING_in_space_persistence_type2653); 

                    }

                     retval.value = (c!=null?c.getText():null).toLowerCase(); 

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:407:7: PERSISTENCE_TYPE d= NONE
                    {
                    match(input,PERSISTENCE_TYPE,FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2664); 
                    d=(Token)match(input,NONE,FOLLOW_NONE_in_space_persistence_type2668); 
                     retval.value = (d!=null?d.getText():null).toLowerCase(); 

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:408:7: PERSISTENCE_TYPE e= ( SHARED_ALL )
                    {
                    match(input,PERSISTENCE_TYPE,FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2678); 
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:408:26: ( SHARED_ALL )
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:408:27: SHARED_ALL
                    {
                    match(input,SHARED_ALL,FOLLOW_SHARED_ALL_in_space_persistence_type2683); 

                    }

                     retval.value = (e!=null?e.getText():null).toLowerCase(); 

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:409:7: PERSISTENCE_TYPE f= ( SHARED_NOTHING )
                    {
                    match(input,PERSISTENCE_TYPE,FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2694); 
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:409:26: ( SHARED_NOTHING )
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:409:27: SHARED_NOTHING
                    {
                    match(input,SHARED_NOTHING,FOLLOW_SHARED_NOTHING_in_space_persistence_type2699); 

                    }

                     retval.value = (f!=null?f.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_persistence_type"

    public static class space_phase_count_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_phase_count"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:412:1: space_phase_count returns [String key, String value] : PHASE_COUNT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_phase_count_return space_phase_count() throws RecognitionException {
        ASSQLParser.space_phase_count_return retval = new ASSQLParser.space_phase_count_return();
        retval.start = input.LT(1);

        Token NegativeNumber72=null;
        Token PositiveNumber73=null;

         retval.key = CreateStatement.PHASE_COUNT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:414:5: ( PHASE_COUNT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:414:7: PHASE_COUNT ( NegativeNumber | PositiveNumber )
            {
            match(input,PHASE_COUNT,FOLLOW_PHASE_COUNT_in_space_phase_count2732); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:414:19: ( NegativeNumber | PositiveNumber )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==NegativeNumber) ) {
                alt44=1;
            }
            else if ( (LA44_0==PositiveNumber) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:414:21: NegativeNumber
                    {
                    NegativeNumber72=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_phase_count2736); 
                     retval.value = (NegativeNumber72!=null?NegativeNumber72.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:414:73: PositiveNumber
                    {
                    PositiveNumber73=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_phase_count2742); 
                     retval.value = (PositiveNumber73!=null?PositiveNumber73.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_phase_count"

    public static class space_phase_interval_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_phase_interval"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:417:1: space_phase_interval returns [String key, String value] : PHASE_INTERVAL PositiveNumber ;
    public final ASSQLParser.space_phase_interval_return space_phase_interval() throws RecognitionException {
        ASSQLParser.space_phase_interval_return retval = new ASSQLParser.space_phase_interval_return();
        retval.start = input.LT(1);

        Token PositiveNumber74=null;

         retval.key = CreateStatement.PHASE_INTERVAL; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:419:5: ( PHASE_INTERVAL PositiveNumber )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:419:7: PHASE_INTERVAL PositiveNumber
            {
            match(input,PHASE_INTERVAL,FOLLOW_PHASE_INTERVAL_in_space_phase_interval2776); 
            PositiveNumber74=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_phase_interval2778); 
             retval.value = (PositiveNumber74!=null?PositiveNumber74.getText():null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_phase_interval"

    public static class space_query_limit_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_query_limit"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:422:1: space_query_limit returns [String key, String value] : QUERY_LIMIT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_query_limit_return space_query_limit() throws RecognitionException {
        ASSQLParser.space_query_limit_return retval = new ASSQLParser.space_query_limit_return();
        retval.start = input.LT(1);

        Token NegativeNumber75=null;
        Token PositiveNumber76=null;

         retval.key = CreateStatement.QUERY_LIMIT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:424:5: ( QUERY_LIMIT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:424:7: QUERY_LIMIT ( NegativeNumber | PositiveNumber )
            {
            match(input,QUERY_LIMIT,FOLLOW_QUERY_LIMIT_in_space_query_limit2810); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:424:19: ( NegativeNumber | PositiveNumber )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NegativeNumber) ) {
                alt45=1;
            }
            else if ( (LA45_0==PositiveNumber) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:424:21: NegativeNumber
                    {
                    NegativeNumber75=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_query_limit2814); 
                     retval.value = (NegativeNumber75!=null?NegativeNumber75.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:424:73: PositiveNumber
                    {
                    PositiveNumber76=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_query_limit2820); 
                     retval.value = (PositiveNumber76!=null?PositiveNumber76.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_query_limit"

    public static class space_query_timeout_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_query_timeout"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:427:1: space_query_timeout returns [String key, String value] : QUERY_TIMEOUT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_query_timeout_return space_query_timeout() throws RecognitionException {
        ASSQLParser.space_query_timeout_return retval = new ASSQLParser.space_query_timeout_return();
        retval.start = input.LT(1);

        Token NegativeNumber77=null;
        Token PositiveNumber78=null;

         retval.key = CreateStatement.QUERY_TIMEOUT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:5: ( QUERY_TIMEOUT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:7: QUERY_TIMEOUT ( NegativeNumber | PositiveNumber )
            {
            match(input,QUERY_TIMEOUT,FOLLOW_QUERY_TIMEOUT_in_space_query_timeout2854); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:21: ( NegativeNumber | PositiveNumber )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==NegativeNumber) ) {
                alt46=1;
            }
            else if ( (LA46_0==PositiveNumber) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:23: NegativeNumber
                    {
                    NegativeNumber77=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_query_timeout2858); 
                     retval.value = (NegativeNumber77!=null?NegativeNumber77.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:75: PositiveNumber
                    {
                    PositiveNumber78=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_query_timeout2864); 
                     retval.value = (PositiveNumber78!=null?PositiveNumber78.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_query_timeout"

    public static class space_read_timeout_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_read_timeout"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:432:1: space_read_timeout returns [String key, String value] : READ_TIMEOUT PositiveNumber ;
    public final ASSQLParser.space_read_timeout_return space_read_timeout() throws RecognitionException {
        ASSQLParser.space_read_timeout_return retval = new ASSQLParser.space_read_timeout_return();
        retval.start = input.LT(1);

        Token PositiveNumber79=null;

         retval.key = CreateStatement.READ_TIMEOUT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:434:5: ( READ_TIMEOUT PositiveNumber )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:434:7: READ_TIMEOUT PositiveNumber
            {
            match(input,READ_TIMEOUT,FOLLOW_READ_TIMEOUT_in_space_read_timeout2898); 
            PositiveNumber79=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_read_timeout2900); 
             retval.value = (PositiveNumber79!=null?PositiveNumber79.getText():null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_read_timeout"

    public static class space_replication_count_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_replication_count"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:437:1: space_replication_count returns [String key, String value] : REPLICATION_COUNT PositiveNumber ;
    public final ASSQLParser.space_replication_count_return space_replication_count() throws RecognitionException {
        ASSQLParser.space_replication_count_return retval = new ASSQLParser.space_replication_count_return();
        retval.start = input.LT(1);

        Token PositiveNumber80=null;

         retval.key = CreateStatement.REPLICATION_COUNT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:439:5: ( REPLICATION_COUNT PositiveNumber )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:439:7: REPLICATION_COUNT PositiveNumber
            {
            match(input,REPLICATION_COUNT,FOLLOW_REPLICATION_COUNT_in_space_replication_count2932); 
            PositiveNumber80=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_replication_count2934); 
             retval.value = (PositiveNumber80!=null?PositiveNumber80.getText():null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_replication_count"

    public static class space_replication_policy_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_replication_policy"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:442:1: space_replication_policy returns [String key, String value] : ( REPLICATION_POLICY SYNC | REPLICATION_POLICY ASYNC );
    public final ASSQLParser.space_replication_policy_return space_replication_policy() throws RecognitionException {
        ASSQLParser.space_replication_policy_return retval = new ASSQLParser.space_replication_policy_return();
        retval.start = input.LT(1);

        Token SYNC81=null;
        Token ASYNC82=null;

         retval.key = CreateStatement.REPLICATION_POLICY; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:444:5: ( REPLICATION_POLICY SYNC | REPLICATION_POLICY ASYNC )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==REPLICATION_POLICY) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==SYNC) ) {
                    alt47=1;
                }
                else if ( (LA47_1==ASYNC) ) {
                    alt47=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:444:7: REPLICATION_POLICY SYNC
                    {
                    match(input,REPLICATION_POLICY,FOLLOW_REPLICATION_POLICY_in_space_replication_policy2966); 
                    SYNC81=(Token)match(input,SYNC,FOLLOW_SYNC_in_space_replication_policy2968); 
                     retval.value = (SYNC81!=null?SYNC81.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:445:7: REPLICATION_POLICY ASYNC
                    {
                    match(input,REPLICATION_POLICY,FOLLOW_REPLICATION_POLICY_in_space_replication_policy2978); 
                    ASYNC82=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_space_replication_policy2980); 
                     retval.value = (ASYNC82!=null?ASYNC82.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_replication_policy"

    public static class space_routed_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_routed"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:448:1: space_routed returns [String key, String value] : ( ROUTED TRUE | ROUTED FALSE );
    public final ASSQLParser.space_routed_return space_routed() throws RecognitionException {
        ASSQLParser.space_routed_return retval = new ASSQLParser.space_routed_return();
        retval.start = input.LT(1);

        Token TRUE83=null;
        Token FALSE84=null;

         retval.key = CreateStatement.ROUTED; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:450:5: ( ROUTED TRUE | ROUTED FALSE )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==ROUTED) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==TRUE) ) {
                    alt48=1;
                }
                else if ( (LA48_1==FALSE) ) {
                    alt48=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:450:7: ROUTED TRUE
                    {
                    match(input,ROUTED,FOLLOW_ROUTED_in_space_routed3012); 
                    TRUE83=(Token)match(input,TRUE,FOLLOW_TRUE_in_space_routed3014); 
                     retval.value = (TRUE83!=null?TRUE83.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:451:7: ROUTED FALSE
                    {
                    match(input,ROUTED,FOLLOW_ROUTED_in_space_routed3024); 
                    FALSE84=(Token)match(input,FALSE,FOLLOW_FALSE_in_space_routed3026); 
                     retval.value = (FALSE84!=null?FALSE84.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_routed"

    public static class space_ttl_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_ttl"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:454:1: space_ttl returns [String key, String value] : TTL ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_ttl_return space_ttl() throws RecognitionException {
        ASSQLParser.space_ttl_return retval = new ASSQLParser.space_ttl_return();
        retval.start = input.LT(1);

        Token NegativeNumber85=null;
        Token PositiveNumber86=null;

         retval.key = CreateStatement.TTL; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:456:5: ( TTL ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:456:7: TTL ( NegativeNumber | PositiveNumber )
            {
            match(input,TTL,FOLLOW_TTL_in_space_ttl3058); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:456:11: ( NegativeNumber | PositiveNumber )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==NegativeNumber) ) {
                alt49=1;
            }
            else if ( (LA49_0==PositiveNumber) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:456:13: NegativeNumber
                    {
                    NegativeNumber85=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_ttl3062); 
                     retval.value = (NegativeNumber85!=null?NegativeNumber85.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:456:65: PositiveNumber
                    {
                    PositiveNumber86=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_ttl3068); 
                     retval.value = (PositiveNumber86!=null?PositiveNumber86.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_ttl"

    public static class space_update_transport_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_update_transport"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:459:1: space_update_transport returns [String key, String value] : ( UPDATE_TRANSPORT UNICAST | UPDATE_TRANSPORT MULTICAST );
    public final ASSQLParser.space_update_transport_return space_update_transport() throws RecognitionException {
        ASSQLParser.space_update_transport_return retval = new ASSQLParser.space_update_transport_return();
        retval.start = input.LT(1);

        Token UNICAST87=null;
        Token MULTICAST88=null;

         retval.key = CreateStatement.UPDATE_TRANSPORT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:461:5: ( UPDATE_TRANSPORT UNICAST | UPDATE_TRANSPORT MULTICAST )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==UPDATE_TRANSPORT) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==UNICAST) ) {
                    alt50=1;
                }
                else if ( (LA50_1==MULTICAST) ) {
                    alt50=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:461:7: UPDATE_TRANSPORT UNICAST
                    {
                    match(input,UPDATE_TRANSPORT,FOLLOW_UPDATE_TRANSPORT_in_space_update_transport3102); 
                    UNICAST87=(Token)match(input,UNICAST,FOLLOW_UNICAST_in_space_update_transport3104); 
                     retval.value = (UNICAST87!=null?UNICAST87.getText():null).toLowerCase(); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:462:7: UPDATE_TRANSPORT MULTICAST
                    {
                    match(input,UPDATE_TRANSPORT,FOLLOW_UPDATE_TRANSPORT_in_space_update_transport3114); 
                    MULTICAST88=(Token)match(input,MULTICAST,FOLLOW_MULTICAST_in_space_update_transport3116); 
                     retval.value = (MULTICAST88!=null?MULTICAST88.getText():null).toLowerCase(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_update_transport"

    public static class space_virtual_node_count_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_virtual_node_count"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:465:1: space_virtual_node_count returns [String key, String value] : VIRTUAL_NODE_COUNT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_virtual_node_count_return space_virtual_node_count() throws RecognitionException {
        ASSQLParser.space_virtual_node_count_return retval = new ASSQLParser.space_virtual_node_count_return();
        retval.start = input.LT(1);

        Token NegativeNumber89=null;
        Token PositiveNumber90=null;

         retval.key = CreateStatement.VIRTUAL_NODE_COUNT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:467:5: ( VIRTUAL_NODE_COUNT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:467:7: VIRTUAL_NODE_COUNT ( NegativeNumber | PositiveNumber )
            {
            match(input,VIRTUAL_NODE_COUNT,FOLLOW_VIRTUAL_NODE_COUNT_in_space_virtual_node_count3148); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:467:26: ( NegativeNumber | PositiveNumber )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==NegativeNumber) ) {
                alt51=1;
            }
            else if ( (LA51_0==PositiveNumber) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:467:28: NegativeNumber
                    {
                    NegativeNumber89=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_virtual_node_count3152); 
                     retval.value = (NegativeNumber89!=null?NegativeNumber89.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:467:80: PositiveNumber
                    {
                    PositiveNumber90=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_virtual_node_count3158); 
                     retval.value = (PositiveNumber90!=null?PositiveNumber90.getText():null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_virtual_node_count"

    public static class space_wait_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_wait"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:470:1: space_wait returns [String key, String value] : SPACE_WAIT PositiveNumber ;
    public final ASSQLParser.space_wait_return space_wait() throws RecognitionException {
        ASSQLParser.space_wait_return retval = new ASSQLParser.space_wait_return();
        retval.start = input.LT(1);

        Token PositiveNumber91=null;

         retval.key = CreateStatement.SPACE_WAIT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:472:5: ( SPACE_WAIT PositiveNumber )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:472:7: SPACE_WAIT PositiveNumber
            {
            match(input,SPACE_WAIT,FOLLOW_SPACE_WAIT_in_space_wait3192); 
            PositiveNumber91=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_wait3194); 
             retval.value = (PositiveNumber91!=null?PositiveNumber91.getText():null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_wait"

    public static class space_write_timeout_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_write_timeout"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:475:1: space_write_timeout returns [String key, String value] : WRITE_TIMEOUT PositiveNumber ;
    public final ASSQLParser.space_write_timeout_return space_write_timeout() throws RecognitionException {
        ASSQLParser.space_write_timeout_return retval = new ASSQLParser.space_write_timeout_return();
        retval.start = input.LT(1);

        Token PositiveNumber92=null;

         retval.key = CreateStatement.WRITE_TIMEOUT; 
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:477:5: ( WRITE_TIMEOUT PositiveNumber )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:477:7: WRITE_TIMEOUT PositiveNumber
            {
            match(input,WRITE_TIMEOUT,FOLLOW_WRITE_TIMEOUT_in_space_write_timeout3226); 
            PositiveNumber92=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_write_timeout3228); 
             retval.value = (PositiveNumber92!=null?PositiveNumber92.getText():null); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "space_write_timeout"


    // $ANTLR start "table_constraint"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:480:1: table_constraint : PRIMARY_KEY ( key_type )? OParen a= column_name ( Comma b= column_name )* CParen ;
    public final void table_constraint() throws RecognitionException {
        ASSQLParser.column_name_return a = null;

        ASSQLParser.column_name_return b = null;

        ASSQLParser.key_type_return key_type93 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:481:5: ( PRIMARY_KEY ( key_type )? OParen a= column_name ( Comma b= column_name )* CParen )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:481:7: PRIMARY_KEY ( key_type )? OParen a= column_name ( Comma b= column_name )* CParen
            {
            match(input,PRIMARY_KEY,FOLLOW_PRIMARY_KEY_in_table_constraint3251); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:481:19: ( key_type )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=HASH && LA52_0<=TREE)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:481:20: key_type
                    {
                    pushFollow(FOLLOW_key_type_in_table_constraint3254);
                    key_type93=key_type();

                    state._fsp--;

                    pkeyType = (key_type93!=null?input.toString(key_type93.start,key_type93.stop):null); 

                    }
                    break;

            }

            match(input,OParen,FOLLOW_OParen_in_table_constraint3267); 
            pushFollow(FOLLOW_column_name_in_table_constraint3271);
            a=column_name();

            state._fsp--;

             pkeyList.add((a!=null?input.toString(a.start,a.stop):null)); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:483:7: ( Comma b= column_name )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==Comma) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:483:9: Comma b= column_name
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_table_constraint3284); 
            	    pushFollow(FOLLOW_column_name_in_table_constraint3288);
            	    b=column_name();

            	    state._fsp--;

            	     pkeyList.add((b!=null?input.toString(b.start,b.stop):null)); 

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_table_constraint3295); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "table_constraint"


    // $ANTLR start "table_constraint_def"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:486:1: table_constraint_def : ( CONSTRAINT Identifier )? table_constraint ;
    public final void table_constraint_def() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:487:5: ( ( CONSTRAINT Identifier )? table_constraint )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:487:7: ( CONSTRAINT Identifier )? table_constraint
            {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:487:7: ( CONSTRAINT Identifier )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==CONSTRAINT) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:487:8: CONSTRAINT Identifier
                    {
                    match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_table_constraint_def3313); 
                    match(input,Identifier,FOLLOW_Identifier_in_table_constraint_def3315); 

                    }
                    break;

            }

            pushFollow(FOLLOW_table_constraint_in_table_constraint_def3319);
            table_constraint();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "table_constraint_def"


    // $ANTLR start "table_element"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:490:1: table_element : ( column_def | table_constraint_def | table_index );
    public final void table_element() throws RecognitionException {
        ASSQLIndex table_index94 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:491:5: ( column_def | table_constraint_def | table_index )
            int alt55=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt55=1;
                }
                break;
            case PRIMARY_KEY:
            case CONSTRAINT:
                {
                alt55=2;
                }
                break;
            case INDEX:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:491:7: column_def
                    {
                    pushFollow(FOLLOW_column_def_in_table_element3336);
                    column_def();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:492:7: table_constraint_def
                    {
                    pushFollow(FOLLOW_table_constraint_def_in_table_element3344);
                    table_constraint_def();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:493:7: table_index
                    {
                    pushFollow(FOLLOW_table_index_in_table_element3352);
                    table_index94=table_index();

                    state._fsp--;

                     indexList.add(table_index94); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "table_element"


    // $ANTLR start "table_index"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:496:1: table_index returns [ASSQLIndex index] : INDEX table_index_name ( key_type )? table_index_list ;
    public final ASSQLIndex table_index() throws RecognitionException {
        ASSQLIndex index = null;

        ASSQLParser.key_type_return key_type95 = null;

        ASSQLParser.table_index_name_return table_index_name96 = null;

        ArrayList<String> table_index_list97 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:497:5: ( INDEX table_index_name ( key_type )? table_index_list )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:497:7: INDEX table_index_name ( key_type )? table_index_list
            {

                      String type = null;
                  
            match(input,INDEX,FOLLOW_INDEX_in_table_index3383); 
            pushFollow(FOLLOW_table_index_name_in_table_index3385);
            table_index_name96=table_index_name();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:500:30: ( key_type )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=HASH && LA56_0<=TREE)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:500:31: key_type
                    {
                    pushFollow(FOLLOW_key_type_in_table_index3388);
                    key_type95=key_type();

                    state._fsp--;

                    type = (key_type95!=null?input.toString(key_type95.start,key_type95.stop):null);

                    }
                    break;

            }

            pushFollow(FOLLOW_table_index_list_in_table_index3394);
            table_index_list97=table_index_list();

            state._fsp--;


                      return new ASSQLIndex((table_index_name96!=null?input.toString(table_index_name96.start,table_index_name96.stop):null), type, table_index_list97);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return index;
    }
    // $ANTLR end "table_index"


    // $ANTLR start "table_index_list"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:506:1: table_index_list returns [ArrayList<String> indexColumns] : OParen a= column_name ( Comma b= column_name )* CParen ;
    public final ArrayList<String> table_index_list() throws RecognitionException {
        ArrayList<String> indexColumns = null;

        ASSQLParser.column_name_return a = null;

        ASSQLParser.column_name_return b = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:507:5: ( OParen a= column_name ( Comma b= column_name )* CParen )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:507:7: OParen a= column_name ( Comma b= column_name )* CParen
            {

                      indexColumns = new ArrayList<String>();
                  
            match(input,OParen,FOLLOW_OParen_in_table_index_list3431); 
            pushFollow(FOLLOW_column_name_in_table_index_list3435);
            a=column_name();

            state._fsp--;

             indexColumns.add((a!=null?input.toString(a.start,a.stop):null)); 
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:510:60: ( Comma b= column_name )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==Comma) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:510:61: Comma b= column_name
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_table_index_list3440); 
            	    pushFollow(FOLLOW_column_name_in_table_index_list3444);
            	    b=column_name();

            	    state._fsp--;

            	     indexColumns.add((b!=null?input.toString(b.start,b.stop):null)); 

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_table_index_list3450); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return indexColumns;
    }
    // $ANTLR end "table_index_list"

    public static class table_index_name_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "table_index_name"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:513:1: table_index_name : Identifier ;
    public final ASSQLParser.table_index_name_return table_index_name() throws RecognitionException {
        ASSQLParser.table_index_name_return retval = new ASSQLParser.table_index_name_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:514:5: ( Identifier )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:514:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_table_index_name3468); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "table_index_name"

    public static class table_name_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "table_name"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:517:1: table_name : Identifier ;
    public final ASSQLParser.table_name_return table_name() throws RecognitionException {
        ASSQLParser.table_name_return retval = new ASSQLParser.table_name_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:518:5: ( Identifier )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:518:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_table_name3485); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "table_name"


    // $ANTLR start "table_reference_list"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:521:1: table_reference_list : a= table_name (b= table_name )? ( Comma c= table_name (d= table_name )? )* ;
    public final void table_reference_list() throws RecognitionException {
        ASSQLParser.table_name_return a = null;

        ASSQLParser.table_name_return b = null;

        ASSQLParser.table_name_return c = null;

        ASSQLParser.table_name_return d = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:522:5: (a= table_name (b= table_name )? ( Comma c= table_name (d= table_name )? )* )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:523:7: a= table_name (b= table_name )? ( Comma c= table_name (d= table_name )? )*
            {
            pushFollow(FOLLOW_table_name_in_table_reference_list3515);
            a=table_name();

            state._fsp--;

            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:523:20: (b= table_name )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Identifier) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:523:21: b= table_name
                    {
                    pushFollow(FOLLOW_table_name_in_table_reference_list3520);
                    b=table_name();

                    state._fsp--;


                    }
                    break;

            }

            addTableInfo((a!=null?input.toString(a.start,a.stop):null), (b!=null?input.toString(b.start,b.stop):null));
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:524:7: ( Comma c= table_name (d= table_name )? )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==Comma) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:524:9: Comma c= table_name (d= table_name )?
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_table_reference_list3534); 
            	    pushFollow(FOLLOW_table_name_in_table_reference_list3538);
            	    c=table_name();

            	    state._fsp--;

            	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:524:28: (d= table_name )?
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==Identifier) ) {
            	        alt59=1;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:524:29: d= table_name
            	            {
            	            pushFollow(FOLLOW_table_name_in_table_reference_list3543);
            	            d=table_name();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    addTableInfo((c!=null?input.toString(c.start,c.stop):null), (d!=null?input.toString(d.start,d.stop):null));

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "table_reference_list"


    // $ANTLR start "target_table"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:527:1: target_table returns [String arg] : ( table_name | ONLY OParen table_name CParen );
    public final String target_table() throws RecognitionException {
        String arg = null;

        ASSQLParser.table_name_return table_name98 = null;

        ASSQLParser.table_name_return table_name99 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:528:5: ( table_name | ONLY OParen table_name CParen )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==Identifier) ) {
                alt61=1;
            }
            else if ( (LA61_0==ONLY) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:528:7: table_name
                    {
                    pushFollow(FOLLOW_table_name_in_target_table3570);
                    table_name98=table_name();

                    state._fsp--;

                     arg = (table_name98!=null?input.toString(table_name98.start,table_name98.stop):null); 

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:529:7: ONLY OParen table_name CParen
                    {
                    match(input,ONLY,FOLLOW_ONLY_in_target_table3580); 
                    match(input,OParen,FOLLOW_OParen_in_target_table3582); 
                    pushFollow(FOLLOW_table_name_in_target_table3584);
                    table_name99=table_name();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_target_table3586); 
                     arg = (table_name99!=null?input.toString(table_name99.start,table_name99.stop):null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "target_table"


    // $ANTLR start "where_condition"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:532:1: where_condition returns [String arg] : (a= where_relation | b= where_relation_group | c= where_relation AND d= where_relation_group | e= where_relation OR f= where_relation_group | g= where_relation_group OR h= where_relation_group | i= where_relation_group AND j= where_relation_group | where_relation_set );
    public final String where_condition() throws RecognitionException {
        String arg = null;

        String a = null;

        String b = null;

        String c = null;

        String d = null;

        String e = null;

        String f = null;

        String g = null;

        String h = null;

        String i = null;

        String j = null;

        String where_relation_set100 = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:533:5: (a= where_relation | b= where_relation_group | c= where_relation AND d= where_relation_group | e= where_relation OR f= where_relation_group | g= where_relation_group OR h= where_relation_group | i= where_relation_group AND j= where_relation_group | where_relation_set )
            int alt62=7;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:533:7: a= where_relation
                    {
                    pushFollow(FOLLOW_where_relation_in_where_condition3611);
                    a=where_relation();

                    state._fsp--;

                    arg = a;

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:534:7: b= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3629);
                    b=where_relation_group();

                    state._fsp--;

                    arg = b;

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:535:7: c= where_relation AND d= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_in_where_condition3641);
                    c=where_relation();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_where_condition3643); 
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3647);
                    d=where_relation_group();

                    state._fsp--;

                    arg = c + " AND " + d;

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:536:7: e= where_relation OR f= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_in_where_condition3659);
                    e=where_relation();

                    state._fsp--;

                    match(input,OR,FOLLOW_OR_in_where_condition3661); 
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3665);
                    f=where_relation_group();

                    state._fsp--;

                    arg = e + " OR " + f;

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:537:7: g= where_relation_group OR h= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3677);
                    g=where_relation_group();

                    state._fsp--;

                    match(input,OR,FOLLOW_OR_in_where_condition3679); 
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3683);
                    h=where_relation_group();

                    state._fsp--;

                    arg = g + " OR " + h;

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:538:7: i= where_relation_group AND j= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3695);
                    i=where_relation_group();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_where_condition3697); 
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3701);
                    j=where_relation_group();

                    state._fsp--;

                    arg = i + " AND " + j;

                    }
                    break;
                case 7 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:539:7: where_relation_set
                    {
                    pushFollow(FOLLOW_where_relation_set_in_where_condition3711);
                    where_relation_set100=where_relation_set();

                    state._fsp--;

                    arg = where_relation_set100;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "where_condition"


    // $ANTLR start "where_relation"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:542:1: where_relation returns [String arg] : (a= relation | b= relation ( AND c= relation )+ | d= relation ( OR e= relation )+ );
    public final String where_relation() throws RecognitionException {
        String arg = null;

        String a = null;

        String b = null;

        String c = null;

        String d = null;

        String e = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:543:5: (a= relation | b= relation ( AND c= relation )+ | d= relation ( OR e= relation )+ )
            int alt65=3;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:543:7: a= relation
                    {
                    pushFollow(FOLLOW_relation_in_where_relation3736);
                    a=relation();

                    state._fsp--;

                    arg = a;

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:544:7: b= relation ( AND c= relation )+
                    {
                    pushFollow(FOLLOW_relation_in_where_relation3748);
                    b=relation();

                    state._fsp--;

                    arg = b;
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:544:35: ( AND c= relation )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==AND) ) {
                            int LA63_2 = input.LA(2);

                            if ( (LA63_2==Identifier||LA63_2==PositiveNumber||(LA63_2>=QuotedString && LA63_2<=FALSE)||LA63_2==QMark) ) {
                                alt63=1;
                            }


                        }


                        switch (alt63) {
                    	case 1 :
                    	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:544:36: AND c= relation
                    	    {
                    	    match(input,AND,FOLLOW_AND_in_where_relation3753); 
                    	    pushFollow(FOLLOW_relation_in_where_relation3757);
                    	    c=relation();

                    	    state._fsp--;

                    	    arg += " AND " + c;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:545:7: d= relation ( OR e= relation )+
                    {
                    pushFollow(FOLLOW_relation_in_where_relation3771);
                    d=relation();

                    state._fsp--;

                    arg = d;
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:545:35: ( OR e= relation )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==OR) ) {
                            int LA64_2 = input.LA(2);

                            if ( (LA64_2==Identifier||LA64_2==PositiveNumber||(LA64_2>=QuotedString && LA64_2<=FALSE)||LA64_2==QMark) ) {
                                alt64=1;
                            }


                        }


                        switch (alt64) {
                    	case 1 :
                    	    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:545:36: OR e= relation
                    	    {
                    	    match(input,OR,FOLLOW_OR_in_where_relation3776); 
                    	    pushFollow(FOLLOW_relation_in_where_relation3780);
                    	    e=relation();

                    	    state._fsp--;

                    	    arg += " OR " + e;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt64 >= 1 ) break loop64;
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "where_relation"


    // $ANTLR start "where_relation_group"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:548:1: where_relation_group returns [String arg] : OParen a= where_relation CParen ;
    public final String where_relation_group() throws RecognitionException {
        String arg = null;

        String a = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:549:5: ( OParen a= where_relation CParen )
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:549:7: OParen a= where_relation CParen
            {
            match(input,OParen,FOLLOW_OParen_in_where_relation_group3810); 
            pushFollow(FOLLOW_where_relation_in_where_relation_group3814);
            a=where_relation();

            state._fsp--;

            match(input,CParen,FOLLOW_CParen_in_where_relation_group3816); 
            arg = "(" + a + ")";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "where_relation_group"


    // $ANTLR start "where_relation_set"
    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:552:1: where_relation_set returns [String arg] : ( OParen c= where_relation AND d= where_relation_group CParen | OParen e= where_relation OR f= where_relation_group CParen | OParen g= where_relation_group OR h= where_relation_group CParen | OParen i= where_relation_group AND j= where_relation_group CParen );
    public final String where_relation_set() throws RecognitionException {
        String arg = null;

        String c = null;

        String d = null;

        String e = null;

        String f = null;

        String g = null;

        String h = null;

        String i = null;

        String j = null;


        try {
            // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:553:5: ( OParen c= where_relation AND d= where_relation_group CParen | OParen e= where_relation OR f= where_relation_group CParen | OParen g= where_relation_group OR h= where_relation_group CParen | OParen i= where_relation_group AND j= where_relation_group CParen )
            int alt66=4;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:553:7: OParen c= where_relation AND d= where_relation_group CParen
                    {
                    match(input,OParen,FOLLOW_OParen_in_where_relation_set3839); 
                    pushFollow(FOLLOW_where_relation_in_where_relation_set3843);
                    c=where_relation();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_where_relation_set3845); 
                    pushFollow(FOLLOW_where_relation_group_in_where_relation_set3849);
                    d=where_relation_group();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_where_relation_set3851); 
                    arg = "(" + c + " AND " + d + ")";

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:554:7: OParen e= where_relation OR f= where_relation_group CParen
                    {
                    match(input,OParen,FOLLOW_OParen_in_where_relation_set3861); 
                    pushFollow(FOLLOW_where_relation_in_where_relation_set3865);
                    e=where_relation();

                    state._fsp--;

                    match(input,OR,FOLLOW_OR_in_where_relation_set3867); 
                    pushFollow(FOLLOW_where_relation_group_in_where_relation_set3871);
                    f=where_relation_group();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_where_relation_set3873); 
                    arg = "(" + e + " OR " + f + ")";

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:555:7: OParen g= where_relation_group OR h= where_relation_group CParen
                    {
                    match(input,OParen,FOLLOW_OParen_in_where_relation_set3883); 
                    pushFollow(FOLLOW_where_relation_group_in_where_relation_set3887);
                    g=where_relation_group();

                    state._fsp--;

                    match(input,OR,FOLLOW_OR_in_where_relation_set3889); 
                    pushFollow(FOLLOW_where_relation_group_in_where_relation_set3893);
                    h=where_relation_group();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_where_relation_set3895); 
                    arg = "(" + g + " OR " + h + ")";

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.1\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:556:7: OParen i= where_relation_group AND j= where_relation_group CParen
                    {
                    match(input,OParen,FOLLOW_OParen_in_where_relation_set3905); 
                    pushFollow(FOLLOW_where_relation_group_in_where_relation_set3909);
                    i=where_relation_group();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_where_relation_set3911); 
                    pushFollow(FOLLOW_where_relation_group_in_where_relation_set3915);
                    j=where_relation_group();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_where_relation_set3917); 
                    arg = "(" + i + " AND " + j + ")";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "where_relation_set"

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA66 dfa66 = new DFA66(this);
    static final String DFA15_eotS =
        "\26\uffff";
    static final String DFA15_eofS =
        "\26\uffff";
    static final String DFA15_minS =
        "\1\26\1\uffff\1\6\1\uffff\2\6\20\uffff";
    static final String DFA15_maxS =
        "\1\45\1\uffff\1\25\1\uffff\2\25\20\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\2\uffff\1\11\1\12\1\13\1\14\1\15\1\16"+
        "\1\17\1\20\1\21\1\22\1\4\1\2\1\6\1\5\1\10\1\7";
    static final String DFA15_specialS =
        "\26\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
            "\14\1\15\1\16\1\17",
            "",
            "\1\20\2\21\13\uffff\2\21",
            "",
            "\1\22\2\23\13\uffff\2\23",
            "\1\24\2\25\13\uffff\2\25",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "198:1: column_type returns [String type] : ( BIT | CHAR | CHAR1 | CHAR OParen PositiveNumber CParen | VARCHAR | VARCHAR OParen PositiveNumber CParen | LONGVARCHAR | LONGVARCHAR OParen PositiveNumber CParen | SMALLINT | INTEGER | BIGINT | REAL | DOUBLE | BLOB | DATETIME | DATE | TIME | TIMESTAMP );";
        }
    }
    static final String DFA18_eotS =
        "\12\uffff";
    static final String DFA18_eofS =
        "\12\uffff";
    static final String DFA18_minS =
        "\1\23\3\60\1\23\4\uffff\1\60";
    static final String DFA18_maxS =
        "\1\74\1\73\2\66\1\23\4\uffff\1\71";
    static final String DFA18_acceptS =
        "\5\uffff\1\4\1\2\1\3\1\1\1\uffff";
    static final String DFA18_specialS =
        "\12\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\5\uffff\1\3\14\uffff\6\3\20\uffff\1\2",
            "\6\10\1\5\2\6\1\7\1\uffff\1\4",
            "\6\10\1\5",
            "\6\10\1\5",
            "\1\11",
            "",
            "",
            "",
            "",
            "\6\10\1\5\2\6\1\7"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "243:1: relation returns [String arg] : (a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm | c= relation_null | d= relation_not | e= relation_in );";
        }
    }
    static final String DFA62_eotS =
        "\u00c8\uffff";
    static final String DFA62_eofS =
        "\6\uffff\1\22\1\uffff\1\22\12\uffff\4\22\26\uffff\1\111\6\uffff"+
        "\1\22\2\uffff\1\22\3\uffff\1\22\1\uffff\1\22\2\uffff\2\22\1\uffff"+
        "\1\22\17\uffff\1\22\2\uffff\3\22\1\uffff\1\22\1\uffff\3\22\60\uffff"+
        "\1\22\2\uffff\3\22\1\uffff\1\22\1\uffff\1\22\57\uffff";
    static final String DFA62_minS =
        "\1\6\3\60\1\6\1\23\1\20\1\31\1\20\1\23\1\6\3\60\1\uffff\1\60\2"+
        "\6\1\uffff\4\20\2\23\2\10\1\31\1\6\1\23\3\60\1\uffff\3\60\1\uffff"+
        "\1\31\1\23\3\7\1\60\1\6\1\20\1\6\1\10\1\23\3\10\1\20\1\31\1\6\1"+
        "\20\3\23\1\20\1\31\1\20\1\6\1\23\2\20\1\23\1\20\1\23\3\60\3\uffff"+
        "\3\60\1\31\3\7\1\23\1\20\1\23\1\60\3\20\1\60\1\20\1\23\3\20\4\7"+
        "\1\10\2\23\1\10\1\31\1\6\2\23\1\31\2\10\1\6\1\10\1\23\1\10\1\23"+
        "\1\10\1\31\3\7\1\23\1\31\3\7\2\23\3\10\1\60\1\10\1\23\1\60\4\10"+
        "\1\23\4\7\1\20\2\23\3\20\1\23\1\20\1\23\1\20\1\7\1\23\1\31\3\7\1"+
        "\23\1\31\3\7\1\23\10\7\2\10\2\23\3\10\2\23\1\10\1\7\2\23\12\7\2"+
        "\23\2\7";
    static final String DFA62_maxS =
        "\1\74\1\73\2\66\1\74\1\23\1\157\1\53\1\157\1\74\1\6\1\73\2\66\1"+
        "\uffff\1\71\2\74\1\uffff\4\157\1\74\1\23\2\157\1\53\1\6\1\74\1\73"+
        "\2\66\1\uffff\1\73\2\66\1\uffff\1\53\1\23\1\73\2\10\1\71\1\74\1"+
        "\157\1\74\1\157\1\74\4\157\1\53\1\6\1\157\1\23\1\74\1\23\1\157\1"+
        "\53\1\157\1\6\1\74\2\157\1\74\1\157\1\23\1\73\2\66\3\uffff\1\73"+
        "\2\66\1\53\1\73\2\10\1\23\1\157\1\74\1\71\3\157\1\71\1\157\1\74"+
        "\3\157\1\73\3\10\1\157\1\74\1\23\1\157\1\53\1\6\1\23\1\74\1\53\2"+
        "\157\1\6\1\157\1\74\1\157\1\23\1\157\1\53\1\73\2\10\1\23\1\53\1"+
        "\73\2\10\2\23\3\157\1\71\1\157\1\74\1\71\4\157\1\74\1\73\3\10\1"+
        "\157\1\23\1\74\3\157\1\74\1\157\1\23\1\157\1\10\1\23\1\53\1\73\2"+
        "\10\1\23\1\53\1\73\2\10\1\23\1\10\1\73\2\10\1\73\3\10\2\157\1\23"+
        "\1\74\3\157\1\23\1\74\1\157\1\10\2\23\1\10\1\73\3\10\1\73\4\10\2"+
        "\23\2\10";
    static final String DFA62_acceptS =
        "\16\uffff\1\7\3\uffff\1\1\16\uffff\1\4\3\uffff\1\3\42\uffff\1\5"+
        "\1\2\1\6\175\uffff";
    static final String DFA62_specialS =
        "\u00c8\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\4\14\uffff\1\1\5\uffff\1\3\14\uffff\6\3\20\uffff\1\2",
            "\6\11\1\12\1\10\1\6\1\7\1\uffff\1\5",
            "\6\11\1\12",
            "\6\11\1\12",
            "\1\16\14\uffff\1\13\5\uffff\1\15\14\uffff\6\15\20\uffff\1"+
            "\14",
            "\1\17",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\23\14\uffff\6\23",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\24\5\uffff\1\26\14\uffff\6\26\20\uffff\1\25",
            "\1\27",
            "\6\35\1\34\1\31\1\32\1\33\1\uffff\1\30",
            "\6\35\1\34",
            "\6\35\1\34",
            "",
            "\6\11\1\12\1\10\1\6\1\7",
            "\1\41\14\uffff\1\36\5\uffff\1\40\14\uffff\6\40\20\uffff\1"+
            "\37",
            "\1\45\14\uffff\1\42\5\uffff\1\44\14\uffff\6\44\20\uffff\1"+
            "\43",
            "",
            "\1\22\33\uffff\1\22\15\uffff\1\46\63\uffff\1\21\1\20",
            "\1\22\33\uffff\1\22\16\uffff\1\47\62\uffff\1\21\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\50\5\uffff\1\52\14\uffff\6\52\20\uffff\1\51",
            "\1\53",
            "\1\55\145\uffff\1\54\1\56",
            "\1\55\145\uffff\1\54\1\56",
            "\1\57\14\uffff\6\57",
            "\1\60",
            "\1\61\5\uffff\1\63\14\uffff\6\63\20\uffff\1\62",
            "\6\71\1\66\1\64\1\67\1\65\1\uffff\1\70",
            "\6\71\1\66",
            "\6\71\1\66",
            "",
            "\6\77\1\76\1\75\1\73\1\74\1\uffff\1\72",
            "\6\77\1\76",
            "\6\77\1\76",
            "",
            "\1\100\14\uffff\6\100",
            "\1\101",
            "\1\102\1\103\62\uffff\1\104",
            "\1\102\1\103",
            "\1\102\1\103",
            "\6\35\1\34\1\31\1\32\1\33",
            "\1\16\14\uffff\1\105\5\uffff\1\107\14\uffff\6\107\20\uffff"+
            "\1\106",
            "\1\111\33\uffff\1\111\101\uffff\1\112\1\110",
            "\1\16\14\uffff\1\113\5\uffff\1\115\14\uffff\6\115\20\uffff"+
            "\1\114",
            "\1\55\61\uffff\1\116\63\uffff\1\54\1\56",
            "\1\117\5\uffff\1\121\14\uffff\6\121\20\uffff\1\120",
            "\1\55\62\uffff\1\122\62\uffff\1\54\1\56",
            "\1\55\145\uffff\1\54\1\56",
            "\1\55\145\uffff\1\54\1\56",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\1\123\14\uffff\6\123",
            "\1\124",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\1\125",
            "\1\126\5\uffff\1\130\14\uffff\6\130\20\uffff\1\127",
            "\1\131",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\132\14\uffff\6\132",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\133",
            "\1\134\5\uffff\1\136\14\uffff\6\136\20\uffff\1\135",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\137\5\uffff\1\141\14\uffff\6\141\20\uffff\1\140",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\20",
            "\1\142",
            "\6\144\1\150\1\143\1\146\1\147\1\uffff\1\145",
            "\6\144\1\150",
            "\6\144\1\150",
            "",
            "",
            "",
            "\6\152\1\156\1\154\1\155\1\153\1\uffff\1\151",
            "\6\152\1\156",
            "\6\152\1\156",
            "\1\157\14\uffff\6\157",
            "\1\160\1\161\62\uffff\1\162",
            "\1\160\1\161",
            "\1\160\1\161",
            "\1\163",
            "\1\22\33\uffff\1\22\15\uffff\1\164\63\uffff\1\45\1\20",
            "\1\165\5\uffff\1\167\14\uffff\6\167\20\uffff\1\166",
            "\6\71\1\66\1\64\1\67\1\65",
            "\1\22\33\uffff\1\22\16\uffff\1\170\62\uffff\1\45\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\6\77\1\76\1\75\1\73\1\74",
            "\1\22\33\uffff\1\22\15\uffff\1\171\63\uffff\1\21\1\41",
            "\1\172\5\uffff\1\174\14\uffff\6\174\20\uffff\1\173",
            "\1\22\33\uffff\1\22\16\uffff\1\175\62\uffff\1\21\1\41",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\102\1\103\62\uffff\1\176",
            "\1\102\1\103",
            "\1\102\1\103",
            "\1\102\1\103",
            "\1\55\145\uffff\1\54\1\16",
            "\1\177\5\uffff\1\u0081\14\uffff\6\u0081\20\uffff\1\u0080",
            "\1\u0082",
            "\1\55\145\uffff\1\54\1\16",
            "\1\u0083\14\uffff\6\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086\5\uffff\1\u0088\14\uffff\6\u0088\20\uffff\1\u0087",
            "\1\u0089\14\uffff\6\u0089",
            "\1\55\145\uffff\1\16\1\56",
            "\1\55\145\uffff\1\16\1\56",
            "\1\u008a",
            "\1\55\145\uffff\1\54\1\56",
            "\1\u008b\5\uffff\1\u008d\14\uffff\6\u008d\20\uffff\1\u008c",
            "\1\55\145\uffff\1\54\1\56",
            "\1\u008e",
            "\1\55\145\uffff\1\54\1\56",
            "\1\u008f\14\uffff\6\u008f",
            "\1\u0091\1\u0092\62\uffff\1\u0090",
            "\1\u0091\1\u0092",
            "\1\u0091\1\u0092",
            "\1\u0093",
            "\1\u0094\14\uffff\6\u0094",
            "\1\u0095\1\u0096\62\uffff\1\u0097",
            "\1\u0095\1\u0096",
            "\1\u0095\1\u0096",
            "\1\u0098",
            "\1\u0099",
            "\1\55\62\uffff\1\u009a\62\uffff\1\54\1\16",
            "\1\55\145\uffff\1\54\1\16",
            "\1\55\145\uffff\1\54\1\16",
            "\6\144\1\150\1\143\1\146\1\147",
            "\1\55\61\uffff\1\u009b\63\uffff\1\54\1\16",
            "\1\u009c\5\uffff\1\u009e\14\uffff\6\u009e\20\uffff\1\u009d",
            "\6\152\1\156\1\154\1\155\1\153",
            "\1\55\62\uffff\1\u009f\62\uffff\1\16\1\56",
            "\1\55\145\uffff\1\16\1\56",
            "\1\55\145\uffff\1\16\1\56",
            "\1\55\61\uffff\1\u00a0\63\uffff\1\16\1\56",
            "\1\u00a1\5\uffff\1\u00a3\14\uffff\6\u00a3\20\uffff\1\u00a2",
            "\1\160\1\161\62\uffff\1\u00a4",
            "\1\160\1\161",
            "\1\160\1\161",
            "\1\160\1\161",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\1\u00a5",
            "\1\u00a6\5\uffff\1\u00a8\14\uffff\6\u00a8\20\uffff\1\u00a7",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\45\1\20",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\u00a9\5\uffff\1\u00ab\14\uffff\6\u00ab\20\uffff\1\u00aa",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\u00ac",
            "\1\22\33\uffff\1\22\101\uffff\1\21\1\41",
            "\1\102\1\103",
            "\1\u00ad",
            "\1\u00ae\14\uffff\6\u00ae",
            "\1\u00b0\1\u00b1\62\uffff\1\u00af",
            "\1\u00b0\1\u00b1",
            "\1\u00b0\1\u00b1",
            "\1\u00b2",
            "\1\u00b3\14\uffff\6\u00b3",
            "\1\u00b5\1\u00b6\62\uffff\1\u00b4",
            "\1\u00b5\1\u00b6",
            "\1\u00b5\1\u00b6",
            "\1\u00b7",
            "\1\u0091\1\u0092",
            "\1\u0091\1\u0092\62\uffff\1\u00b8",
            "\1\u0091\1\u0092",
            "\1\u0091\1\u0092",
            "\1\u0095\1\u0096\62\uffff\1\u00b9",
            "\1\u0095\1\u0096",
            "\1\u0095\1\u0096",
            "\1\u0095\1\u0096",
            "\1\55\145\uffff\1\54\1\16",
            "\1\55\145\uffff\1\54\1\16",
            "\1\u00ba",
            "\1\u00bb\5\uffff\1\u00bd\14\uffff\6\u00bd\20\uffff\1\u00bc",
            "\1\55\145\uffff\1\54\1\16",
            "\1\55\145\uffff\1\16\1\56",
            "\1\55\145\uffff\1\16\1\56",
            "\1\u00be",
            "\1\u00bf\5\uffff\1\u00c1\14\uffff\6\u00c1\20\uffff\1\u00c0",
            "\1\55\145\uffff\1\16\1\56",
            "\1\160\1\161",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00b0\1\u00b1",
            "\1\u00b0\1\u00b1\62\uffff\1\u00c4",
            "\1\u00b0\1\u00b1",
            "\1\u00b0\1\u00b1",
            "\1\u00b5\1\u00b6",
            "\1\u00b5\1\u00b6\62\uffff\1\u00c5",
            "\1\u00b5\1\u00b6",
            "\1\u00b5\1\u00b6",
            "\1\u0091\1\u0092",
            "\1\u0095\1\u0096",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00b0\1\u00b1",
            "\1\u00b5\1\u00b6"
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "532:1: where_condition returns [String arg] : (a= where_relation | b= where_relation_group | c= where_relation AND d= where_relation_group | e= where_relation OR f= where_relation_group | g= where_relation_group OR h= where_relation_group | i= where_relation_group AND j= where_relation_group | where_relation_set );";
        }
    }
    static final String DFA65_eotS =
        "\45\uffff";
    static final String DFA65_eofS =
        "\7\uffff\2\15\3\uffff\1\15\3\uffff\3\15\11\uffff\3\15\6\uffff";
    static final String DFA65_minS =
        "\1\23\3\60\1\23\1\6\1\31\2\10\1\23\1\60\1\23\1\10\1\uffff\2\6\3"+
        "\10\3\7\1\31\2\uffff\3\23\3\10\4\7\1\23\1\7";
    static final String DFA65_maxS =
        "\1\74\1\73\2\66\1\23\1\6\1\53\2\157\1\74\1\71\1\74\1\157\1\uffff"+
        "\2\74\3\157\1\73\2\10\1\53\2\uffff\2\23\1\74\3\157\1\10\1\73\2\10"+
        "\1\23\1\10";
    static final String DFA65_acceptS =
        "\15\uffff\1\1\11\uffff\1\2\1\3\14\uffff";
    static final String DFA65_specialS =
        "\45\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\1\5\uffff\1\3\14\uffff\6\3\20\uffff\1\2",
            "\6\11\1\5\1\7\1\10\1\6\1\uffff\1\4",
            "\6\11\1\5",
            "\6\11\1\5",
            "\1\12",
            "\1\13",
            "\1\14\14\uffff\6\14",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\20\5\uffff\1\22\14\uffff\6\22\20\uffff\1\21",
            "\6\11\1\5\1\7\1\10\1\6",
            "\1\23\5\uffff\1\25\14\uffff\6\25\20\uffff\1\24",
            "\1\15\7\uffff\1\15\33\uffff\1\15\15\uffff\1\26\63\uffff\1"+
            "\16\1\17",
            "",
            "\1\15\14\uffff\1\27\5\uffff\1\27\14\uffff\6\27\20\uffff\1"+
            "\27",
            "\1\15\14\uffff\1\30\5\uffff\1\30\14\uffff\6\30\20\uffff\1"+
            "\30",
            "\1\15\7\uffff\1\15\33\uffff\1\15\16\uffff\1\31\62\uffff\1"+
            "\16\1\17",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\33\1\34\62\uffff\1\32",
            "\1\33\1\34",
            "\1\33\1\34",
            "\1\35\14\uffff\6\35",
            "",
            "",
            "\1\36",
            "\1\37",
            "\1\40\5\uffff\1\42\14\uffff\6\42\20\uffff\1\41",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\15\7\uffff\1\15\33\uffff\1\15\101\uffff\1\16\1\17",
            "\1\33\1\34",
            "\1\33\1\34\62\uffff\1\43",
            "\1\33\1\34",
            "\1\33\1\34",
            "\1\44",
            "\1\33\1\34"
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "542:1: where_relation returns [String arg] : (a= relation | b= relation ( AND c= relation )+ | d= relation ( OR e= relation )+ );";
        }
    }
    static final String DFA66_eotS =
        "\u00c6\uffff";
    static final String DFA66_eofS =
        "\u00c6\uffff";
    static final String DFA66_minS =
        "\2\6\1\23\6\60\2\23\1\6\2\156\1\31\1\10\1\23\1\10\1\6\1\23\1\31"+
        "\1\73\2\156\1\60\1\23\2\6\1\72\2\23\1\156\1\60\1\23\4\10\1\23\3"+
        "\7\3\60\1\uffff\3\60\1\uffff\1\31\6\60\2\uffff\3\7\1\23\1\31\1\156"+
        "\2\23\1\156\1\23\1\156\1\6\1\23\1\156\1\31\1\23\1\156\1\31\1\23"+
        "\1\6\2\156\1\23\1\6\1\31\1\10\1\23\1\10\1\23\1\6\2\10\1\31\2\23"+
        "\1\10\1\23\2\10\4\7\1\60\1\23\1\73\2\156\1\72\1\60\1\72\1\73\2\156"+
        "\1\23\1\60\1\23\4\10\1\60\1\23\4\10\4\7\1\23\3\7\1\23\2\31\1\23"+
        "\6\7\1\31\1\23\3\7\1\31\2\23\1\7\1\23\1\156\1\23\4\156\1\23\1\156"+
        "\3\23\3\10\1\23\1\10\1\23\2\10\21\7\4\23\4\7";
    static final String DFA66_maxS =
        "\1\6\2\74\1\73\2\66\1\73\2\66\1\74\1\23\1\6\2\157\1\53\1\157\1"+
        "\23\1\157\1\6\1\74\1\53\3\157\1\71\3\74\1\157\2\74\1\157\1\71\1"+
        "\74\4\157\1\23\1\73\2\10\1\73\2\66\1\uffff\1\73\2\66\1\uffff\1\53"+
        "\1\73\2\66\1\73\2\66\2\uffff\1\73\2\10\1\23\1\53\1\157\1\23\1\74"+
        "\1\157\1\23\1\157\1\6\1\74\1\157\1\53\1\23\1\157\1\53\1\74\1\6\2"+
        "\157\1\23\1\6\1\53\1\156\1\74\1\156\1\23\1\6\2\157\1\53\2\74\1\157"+
        "\1\23\2\157\1\10\1\73\2\10\1\71\1\74\4\157\1\71\4\157\1\74\1\71"+
        "\1\74\4\156\1\71\1\74\4\157\1\73\3\10\1\23\1\73\2\10\1\23\2\53\1"+
        "\23\1\73\2\10\1\73\2\10\1\53\1\23\1\73\2\10\1\53\2\23\1\10\1\74"+
        "\1\157\1\23\4\157\1\74\1\157\2\23\1\74\3\156\1\74\1\157\1\23\2\157"+
        "\1\10\1\73\3\10\1\73\4\10\1\73\2\10\1\73\3\10\4\23\4\10";
    static final String DFA66_acceptS =
        "\55\uffff\1\2\3\uffff\1\1\7\uffff\1\4\1\3\u008b\uffff";
    static final String DFA66_specialS =
        "\u00c6\uffff}>";
    static final String[] DFA66_transitionS = {
            "\1\1",
            "\1\2\14\uffff\1\3\5\uffff\1\5\14\uffff\6\5\20\uffff\1\4",
            "\1\6\5\uffff\1\10\14\uffff\6\10\20\uffff\1\7",
            "\6\11\1\13\1\14\1\15\1\16\1\uffff\1\12",
            "\6\11\1\13",
            "\6\11\1\13",
            "\6\23\1\22\1\17\1\21\1\24\1\uffff\1\20",
            "\6\23\1\22",
            "\6\23\1\22",
            "\1\25\5\uffff\1\27\14\uffff\6\27\20\uffff\1\26",
            "\1\30",
            "\1\31",
            "\1\33\1\32",
            "\1\33\1\32",
            "\1\34\14\uffff\6\34",
            "\1\37\145\uffff\1\35\1\36",
            "\1\40",
            "\1\37\145\uffff\1\35\1\36",
            "\1\41",
            "\1\42\5\uffff\1\44\14\uffff\6\44\20\uffff\1\43",
            "\1\45\14\uffff\6\45",
            "\1\46\62\uffff\1\33\1\32",
            "\1\33\1\32",
            "\1\33\1\32",
            "\6\11\1\13\1\14\1\15\1\16",
            "\1\47\5\uffff\1\51\14\uffff\6\51\20\uffff\1\50",
            "\1\55\14\uffff\1\52\5\uffff\1\54\14\uffff\6\54\20\uffff\1"+
            "\53",
            "\1\61\14\uffff\1\56\5\uffff\1\60\14\uffff\6\60\20\uffff\1"+
            "\57",
            "\1\62\63\uffff\1\33\1\32",
            "\1\63\5\uffff\1\65\14\uffff\6\65\20\uffff\1\64",
            "\1\66\5\uffff\1\70\14\uffff\6\70\20\uffff\1\67",
            "\1\71\1\72",
            "\6\23\1\22\1\17\1\21\1\24",
            "\1\73\5\uffff\1\75\14\uffff\6\75\20\uffff\1\74",
            "\1\37\62\uffff\1\76\62\uffff\1\35\1\36",
            "\1\37\145\uffff\1\35\1\36",
            "\1\37\145\uffff\1\35\1\36",
            "\1\37\61\uffff\1\77\63\uffff\1\35\1\36",
            "\1\100",
            "\1\102\1\103\62\uffff\1\101",
            "\1\102\1\103",
            "\1\102\1\103",
            "\6\107\1\106\1\110\1\105\1\111\1\uffff\1\104",
            "\6\107\1\106",
            "\6\107\1\106",
            "",
            "\6\115\1\116\1\117\1\113\1\114\1\uffff\1\112",
            "\6\115\1\116",
            "\6\115\1\116",
            "",
            "\1\120\14\uffff\6\120",
            "\6\125\1\122\1\126\1\124\1\123\1\uffff\1\121",
            "\6\125\1\122",
            "\6\125\1\122",
            "\6\134\1\130\1\132\1\131\1\133\1\uffff\1\127",
            "\6\134\1\130",
            "\6\134\1\130",
            "",
            "",
            "\1\135\1\136\62\uffff\1\137",
            "\1\135\1\136",
            "\1\135\1\136",
            "\1\140",
            "\1\141\14\uffff\6\141",
            "\1\33\1\32",
            "\1\142",
            "\1\143\5\uffff\1\145\14\uffff\6\145\20\uffff\1\144",
            "\1\33\1\32",
            "\1\146",
            "\1\61\1\32",
            "\1\147",
            "\1\150\5\uffff\1\152\14\uffff\6\152\20\uffff\1\151",
            "\1\61\1\32",
            "\1\153\14\uffff\6\153",
            "\1\154",
            "\1\33\1\55",
            "\1\155\14\uffff\6\155",
            "\1\156\5\uffff\1\160\14\uffff\6\160\20\uffff\1\157",
            "\1\161",
            "\1\33\1\55",
            "\1\33\1\32",
            "\1\162",
            "\1\163",
            "\1\164\14\uffff\6\164",
            "\1\37\145\uffff\1\35",
            "\1\165\5\uffff\1\167\14\uffff\6\167\20\uffff\1\166",
            "\1\37\145\uffff\1\35",
            "\1\170",
            "\1\171",
            "\1\37\146\uffff\1\36",
            "\1\37\146\uffff\1\36",
            "\1\172\14\uffff\6\172",
            "\1\173\5\uffff\1\175\14\uffff\6\175\20\uffff\1\174",
            "\1\176\5\uffff\1\u0080\14\uffff\6\u0080\20\uffff\1\177",
            "\1\37\145\uffff\1\35\1\36",
            "\1\u0081",
            "\1\37\145\uffff\1\35\1\36",
            "\1\37\145\uffff\1\35\1\36",
            "\1\102\1\103",
            "\1\102\1\103\62\uffff\1\u0082",
            "\1\102\1\103",
            "\1\102\1\103",
            "\6\107\1\106\1\110\1\105\1\111",
            "\1\u0083\5\uffff\1\u0085\14\uffff\6\u0085\20\uffff\1\u0084",
            "\1\u0086\62\uffff\1\61\1\32",
            "\1\61\1\32",
            "\1\61\1\32",
            "\1\u0087\63\uffff\1\61\1\32",
            "\6\115\1\116\1\117\1\113\1\114",
            "\1\u0088\63\uffff\1\33\1\55",
            "\1\u0089\62\uffff\1\33\1\55",
            "\1\33\1\55",
            "\1\33\1\55",
            "\1\u008a\5\uffff\1\u008c\14\uffff\6\u008c\20\uffff\1\u008b",
            "\6\125\1\122\1\126\1\124\1\123",
            "\1\u008d\5\uffff\1\u008f\14\uffff\6\u008f\20\uffff\1\u008e",
            "\1\37\61\uffff\1\u0090\63\uffff\1\35",
            "\1\37\62\uffff\1\u0091\62\uffff\1\35",
            "\1\37\145\uffff\1\35",
            "\1\37\145\uffff\1\35",
            "\6\134\1\130\1\132\1\131\1\133",
            "\1\u0092\5\uffff\1\u0094\14\uffff\6\u0094\20\uffff\1\u0093",
            "\1\37\61\uffff\1\u0095\64\uffff\1\36",
            "\1\37\62\uffff\1\u0096\63\uffff\1\36",
            "\1\37\146\uffff\1\36",
            "\1\37\146\uffff\1\36",
            "\1\135\1\136\62\uffff\1\u0097",
            "\1\135\1\136",
            "\1\135\1\136",
            "\1\135\1\136",
            "\1\u0098",
            "\1\u0099\1\u009a\62\uffff\1\u009b",
            "\1\u0099\1\u009a",
            "\1\u0099\1\u009a",
            "\1\u009c",
            "\1\u009d\14\uffff\6\u009d",
            "\1\u009e\14\uffff\6\u009e",
            "\1\u009f",
            "\1\u00a0\1\u00a1\62\uffff\1\u00a2",
            "\1\u00a0\1\u00a1",
            "\1\u00a0\1\u00a1",
            "\1\u00a4\1\u00a5\62\uffff\1\u00a3",
            "\1\u00a4\1\u00a5",
            "\1\u00a4\1\u00a5",
            "\1\u00a6\14\uffff\6\u00a6",
            "\1\u00a7",
            "\1\u00a8\1\u00a9\62\uffff\1\u00aa",
            "\1\u00a8\1\u00a9",
            "\1\u00a8\1\u00a9",
            "\1\u00ab\14\uffff\6\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\102\1\103",
            "\1\u00ae\5\uffff\1\u00b0\14\uffff\6\u00b0\20\uffff\1\u00af",
            "\1\61\1\32",
            "\1\u00b1",
            "\1\61\1\32",
            "\1\61\1\32",
            "\1\33\1\55",
            "\1\33\1\55",
            "\1\u00b2\5\uffff\1\u00b4\14\uffff\6\u00b4\20\uffff\1\u00b3",
            "\1\33\1\55",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7\5\uffff\1\u00b9\14\uffff\6\u00b9\20\uffff\1\u00b8",
            "\1\37\145\uffff\1\35",
            "\1\37\145\uffff\1\35",
            "\1\37\145\uffff\1\35",
            "\1\u00ba\5\uffff\1\u00bc\14\uffff\6\u00bc\20\uffff\1\u00bb",
            "\1\37\146\uffff\1\36",
            "\1\u00bd",
            "\1\37\146\uffff\1\36",
            "\1\37\146\uffff\1\36",
            "\1\135\1\136",
            "\1\u0099\1\u009a\62\uffff\1\u00be",
            "\1\u0099\1\u009a",
            "\1\u0099\1\u009a",
            "\1\u0099\1\u009a",
            "\1\u00a0\1\u00a1\62\uffff\1\u00bf",
            "\1\u00a0\1\u00a1",
            "\1\u00a0\1\u00a1",
            "\1\u00a0\1\u00a1",
            "\1\u00a4\1\u00a5",
            "\1\u00a4\1\u00a5\62\uffff\1\u00c0",
            "\1\u00a4\1\u00a5",
            "\1\u00a4\1\u00a5",
            "\1\u00a8\1\u00a9\62\uffff\1\u00c1",
            "\1\u00a8\1\u00a9",
            "\1\u00a8\1\u00a9",
            "\1\u00a8\1\u00a9",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u0099\1\u009a",
            "\1\u00a0\1\u00a1",
            "\1\u00a4\1\u00a5",
            "\1\u00a8\1\u00a9"
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "552:1: where_relation_set returns [String arg] : ( OParen c= where_relation AND d= where_relation_group CParen | OParen e= where_relation OR f= where_relation_group CParen | OParen g= where_relation_group OR h= where_relation_group CParen | OParen i= where_relation_group AND j= where_relation_group CParen );";
        }
    }
 

    public static final BitSet FOLLOW_createStatement_in_query62 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_query75 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_query88 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectStatement_in_query101 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_query114 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_createStatement148 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TABLE_in_createStatement150 = new BitSet(new long[]{0x0000000000080000L,0x0000200000000000L});
    public static final BitSet FOLLOW_target_table_in_createStatement152 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_createStatement160 = new BitSet(new long[]{0x0000000000280000L,0x0000180000000000L});
    public static final BitSet FOLLOW_table_element_in_createStatement162 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_createStatement165 = new BitSet(new long[]{0x0000000000280000L,0x0000180000000000L});
    public static final BitSet FOLLOW_table_element_in_createStatement167 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_createStatement171 = new BitSet(new long[]{0x0000000000000002L,0x0000073FF93CF24CL});
    public static final BitSet FOLLOW_space_property_in_createStatement182 = new BitSet(new long[]{0x0000000000000082L,0x0000073FF93CF24CL});
    public static final BitSet FOLLOW_Comma_in_createStatement187 = new BitSet(new long[]{0x0000000000000000L,0x0000073FF93CF24CL});
    public static final BitSet FOLLOW_space_property_in_createStatement191 = new BitSet(new long[]{0x0000000000000082L,0x0000073FF93CF24CL});
    public static final BitSet FOLLOW_DELETE_in_deleteStatement227 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FROM_in_deleteStatement229 = new BitSet(new long[]{0x0000000000080000L,0x0000200000000000L});
    public static final BitSet FOLLOW_target_table_in_deleteStatement231 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_WHERE_in_deleteStatement240 = new BitSet(new long[]{0x10000FC002080040L});
    public static final BitSet FOLLOW_where_condition_in_deleteStatement242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERT_in_insertStatement281 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_INTO_in_insertStatement283 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_insertStatement285 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_insertStatement293 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_insertStatement297 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_insertStatement303 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_insertStatement307 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_insertStatement314 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_VALUES_in_insertStatement322 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_insertStatement324 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_column_value_in_insertStatement328 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_insertStatement334 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_column_value_in_insertStatement338 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_insertStatement345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_selectStatement374 = new BitSet(new long[]{0xC000000000080000L,0x0000000000000003L});
    public static final BitSet FOLLOW_select_quantifier_in_selectStatement377 = new BitSet(new long[]{0xC000000000080000L,0x0000000000000003L});
    public static final BitSet FOLLOW_select_list_in_selectStatement387 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FROM_in_selectStatement402 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_reference_list_in_selectStatement404 = new BitSet(new long[]{0x0000000000010802L});
    public static final BitSet FOLLOW_WHERE_in_selectStatement413 = new BitSet(new long[]{0x10000FC002080040L});
    public static final BitSet FOLLOW_where_condition_in_selectStatement415 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_LIMIT_in_selectStatement426 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_limit_clause_in_selectStatement428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateStatement495 = new BitSet(new long[]{0x0000000000080000L,0x0000200000000000L});
    public static final BitSet FOLLOW_target_table_in_updateStatement497 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SET_in_updateStatement505 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_set_clause_in_updateStatement509 = new BitSet(new long[]{0x0000000000000882L});
    public static final BitSet FOLLOW_Comma_in_updateStatement523 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_set_clause_in_updateStatement527 = new BitSet(new long[]{0x0000000000000882L});
    public static final BitSet FOLLOW_WHERE_in_updateStatement541 = new BitSet(new long[]{0x10000FC002080040L});
    public static final BitSet FOLLOW_where_condition_in_updateStatement543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_alias570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_name_in_column_def595 = new BitSet(new long[]{0x0000003FFDC00000L});
    public static final BitSet FOLLOW_column_type_in_column_def597 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_NOT_NULL_in_column_def615 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_PRIMARY_KEY_in_column_def627 = new BitSet(new long[]{0x0000600000300002L});
    public static final BitSet FOLLOW_key_type_in_column_def633 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_Identifier_in_column_name671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIT_in_column_type692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_column_type710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR1_in_column_type728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_column_type744 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_column_type746 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_column_type748 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_column_type750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARCHAR_in_column_type760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARCHAR_in_column_type774 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_column_type776 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_column_type778 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_column_type780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGVARCHAR_in_column_type790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGVARCHAR_in_column_type800 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_column_type802 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_column_type804 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_column_type806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SMALLINT_in_column_type816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_column_type829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINT_in_column_type843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_column_type858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_column_type875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOB_in_column_type890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_column_type907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_column_type920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIME_in_column_type937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIMESTAMP_in_column_type954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_column_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SColon_in_endStmnt1054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_endStmnt1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_key_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1100 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_OFFSET_in_limit_clause1102 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1113 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Comma_in_limit_clause1115 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_in_relation1141 = new BitSet(new long[]{0x003F000000000000L});
    public static final BitSet FOLLOW_set_in_relation1145 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_rterm_in_relation1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_null_in_relation1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_not_in_relation1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_in_relation1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_in_relation_in1230 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IN_in_relation_in1232 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_relation_in1234 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_rterm_list_in_relation_in1236 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_relation_in1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_identifier_in_relation_null1263 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IS_NULL_in_relation_null1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_identifier_in_relation_null1277 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IS_NOT_NULL_in_relation_null1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_identifier_in_relation_not1304 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_NOT_in_relation_not1306 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_column_value_in_relation_not1310 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_NOR_in_relation_not1315 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_column_value_in_relation_not1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_in_rterm_list1352 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_rterm_list1355 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_rterm_in_rterm_list1357 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_table_name_in_rterm_identifier1377 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Dot_in_rterm_identifier1379 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_Identifier_in_rterm_identifier1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_identifier_in_rterm1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMark_in_rterm1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_value_in_rterm1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_select_column1446 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Dot_in_select_column1448 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_select_column1461 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_AS_in_select_column1472 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_alias_in_select_column1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_column_in_select_column_list1497 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_select_column_list1508 = new BitSet(new long[]{0xC000000000080000L,0x0000000000000003L});
    public static final BitSet FOLLOW_select_column_in_select_column_list1512 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_COUNT_in_select_list1536 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_select_list1538 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_Asterisk_in_select_list1542 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_CParen_in_select_list1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_select_list1559 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Dot_in_select_list1561 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_Asterisk_in_select_list1565 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_select_list1576 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_select_list1580 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Dot_in_select_list1582 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_Asterisk_in_select_list1586 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_select_column_list_in_select_list1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_select_quantifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_name_in_set_clause1646 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_Equals_in_set_clause1648 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_column_value_in_set_clause1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_capacity_in_space_property1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_cache_policy_in_space_property1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_distribution_policy_in_space_property1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_eviction_policy_in_space_property1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_file_sync_interval_in_space_property1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_forget_old_value_in_space_property1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_host_aware_replication_in_space_property1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_lock_scope_in_space_property1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_lock_ttl_in_space_property1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_lock_wait_in_space_property1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_min_seeders_in_space_property1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_persistence_policy_in_space_property1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_persistence_type_in_space_property1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_phase_count_in_space_property1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_phase_interval_in_space_property1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_query_limit_in_space_property1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_query_timeout_in_space_property1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_read_timeout_in_space_property1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_replication_count_in_space_property1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_replication_policy_in_space_property1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_routed_in_space_property1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_ttl_in_space_property1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_update_transport_in_space_property1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_virtual_node_count_in_space_property2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_wait_in_space_property2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_write_timeout_in_space_property2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPACITY_in_space_capacity2069 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_capacity2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_capacity2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_POLICY_in_space_cache_policy2113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_READ_WRITE_THROUGH_in_space_cache_policy2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_POLICY_in_space_cache_policy2125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_READ_THROUGH_in_space_cache_policy2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy2165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_DISTRIBUTED_in_space_distribution_policy2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy2177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_NON_DISTRIBUTED_in_space_distribution_policy2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVICTION_POLICY_in_space_eviction_policy2215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_NONE_in_space_eviction_policy2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVICTION_POLICY_in_space_eviction_policy2227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_LRU_in_space_eviction_policy2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILE_SYNC_INTERVAL_in_space_file_sync_interval2261 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_file_sync_interval2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_file_sync_interval2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORGET_OLD_VALUE_in_space_forget_old_value2305 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_TRUE_in_space_forget_old_value2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORGET_OLD_VALUE_in_space_forget_old_value2317 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_FALSE_in_space_forget_old_value2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOST_AWARE_REPLICATION_in_space_host_aware_replication2351 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_TRUE_in_space_host_aware_replication2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOST_AWARE_REPLICATION_in_space_host_aware_replication2363 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_FALSE_in_space_host_aware_replication2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_SCOPE_in_space_lock_scope2397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_THREAD_in_space_lock_scope2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_SCOPE_in_space_lock_scope2409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_PROCESS_in_space_lock_scope2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_TTL_in_space_lock_ttl2443 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_lock_ttl2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_lock_ttl2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_WAIT_in_space_lock_wait2487 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_lock_wait2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_lock_wait2497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_SEEDERS_in_space_min_seeders2532 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_min_seeders2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_SYNC_in_space_persistence_policy2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_ASYNC_in_space_persistence_policy2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_in_space_persistence_type2618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_NONE_in_space_persistence_type2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_in_space_persistence_type2632 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SHARED_ALL_in_space_persistence_type2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_in_space_persistence_type2648 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_SHARED_NOTHING_in_space_persistence_type2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_NONE_in_space_persistence_type2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2678 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SHARED_ALL_in_space_persistence_type2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2694 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_SHARED_NOTHING_in_space_persistence_type2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PHASE_COUNT_in_space_phase_count2732 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_phase_count2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_phase_count2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PHASE_INTERVAL_in_space_phase_interval2776 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_phase_interval2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_LIMIT_in_space_query_limit2810 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_query_limit2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_query_limit2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_TIMEOUT_in_space_query_timeout2854 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_query_timeout2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_query_timeout2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_TIMEOUT_in_space_read_timeout2898 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_read_timeout2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLICATION_COUNT_in_space_replication_count2932 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_replication_count2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLICATION_POLICY_in_space_replication_policy2966 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_SYNC_in_space_replication_policy2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLICATION_POLICY_in_space_replication_policy2978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_ASYNC_in_space_replication_policy2980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROUTED_in_space_routed3012 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_TRUE_in_space_routed3014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROUTED_in_space_routed3024 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_FALSE_in_space_routed3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TTL_in_space_ttl3058 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_ttl3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_ttl3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_TRANSPORT_in_space_update_transport3102 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_UNICAST_in_space_update_transport3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_TRANSPORT_in_space_update_transport3114 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_MULTICAST_in_space_update_transport3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VIRTUAL_NODE_COUNT_in_space_virtual_node_count3148 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_virtual_node_count3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_virtual_node_count3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPACE_WAIT_in_space_wait3192 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_wait3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_TIMEOUT_in_space_write_timeout3226 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_write_timeout3228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMARY_KEY_in_table_constraint3251 = new BitSet(new long[]{0x0000600000000040L});
    public static final BitSet FOLLOW_key_type_in_table_constraint3254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_table_constraint3267 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_constraint3271 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_table_constraint3284 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_constraint3288 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_table_constraint3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAINT_in_table_constraint_def3313 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_Identifier_in_table_constraint_def3315 = new BitSet(new long[]{0x0000000000200000L,0x0000080000000000L});
    public static final BitSet FOLLOW_table_constraint_in_table_constraint_def3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_table_element3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_constraint_def_in_table_element3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_index_in_table_element3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDEX_in_table_index3383 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_index_name_in_table_index3385 = new BitSet(new long[]{0x0000600000000040L});
    public static final BitSet FOLLOW_key_type_in_table_index3388 = new BitSet(new long[]{0x0000600000000040L});
    public static final BitSet FOLLOW_table_index_list_in_table_index3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_table_index_list3431 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_index_list3435 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_table_index_list3440 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_index_list3444 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_table_index_list3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_table_index_name3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_table_name3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_table_reference_list3515 = new BitSet(new long[]{0x0000000000080082L});
    public static final BitSet FOLLOW_table_name_in_table_reference_list3520 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_table_reference_list3534 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_table_reference_list3538 = new BitSet(new long[]{0x0000000000080082L});
    public static final BitSet FOLLOW_table_name_in_table_reference_list3543 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_table_name_in_target_table3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ONLY_in_target_table3580 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_target_table3582 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_target_table3584 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_target_table3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_in_where_condition3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_in_where_condition3641 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_AND_in_where_condition3643 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_in_where_condition3659 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_OR_in_where_condition3661 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3677 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_OR_in_where_condition3679 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3695 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_AND_in_where_condition3697 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_set_in_where_condition3711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_where_relation3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_where_relation3748 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_AND_in_where_relation3753 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_relation_in_where_relation3757 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_relation_in_where_relation3771 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_OR_in_where_relation3776 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_relation_in_where_relation3780 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_OParen_in_where_relation_group3810 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_where_relation_in_where_relation_group3814 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_relation_group3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_where_relation_set3839 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_where_relation_in_where_relation_set3843 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_AND_in_where_relation_set3845 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_relation_set3849 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_relation_set3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_where_relation_set3861 = new BitSet(new long[]{0x10000FC002080000L});
    public static final BitSet FOLLOW_where_relation_in_where_relation_set3865 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_OR_in_where_relation_set3867 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_relation_set3871 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_relation_set3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_where_relation_set3883 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_relation_set3887 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_OR_in_where_relation_set3889 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_relation_set3893 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_relation_set3895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_where_relation_set3905 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_relation_set3909 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_AND_in_where_relation_set3911 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_relation_set3915 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_relation_set3917 = new BitSet(new long[]{0x0000000000000002L});

}