// $ANTLR 3.2 Sep 23, 2009 12:02:23

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CREATE", "TABLE", "OParen", "Comma", "CParen", "DELETE", "FROM", "WHERE", "INSERT", "INTO", "VALUES", "SELECT", "LIMIT", "UPDATE", "SET", "Identifier", "NOT_NULL", "PRIMARY_KEY", "BIT", "CHAR", "CHAR1", "PositiveNumber", "VARCHAR", "LONGVARCHAR", "SMALLINT", "INTEGER", "BIGINT", "REAL", "DOUBLE", "BLOB", "DATETIME", "DATE", "TIME", "TIMESTAMP", "QuotedString", "NegativeNumber", "Float", "NULL", "SColon", "HASH", "TREE", "OFFSET", "Equals", "NotEquals", "GThan", "GTEquals", "LThan", "LTEquals", "IS_NULL", "IS_NOT_NULL", "NOT", "NOR", "QMark", "Dot", "AS", "Asterisk", "ALL", "DISTINCT", "CAPACITY", "DISTRIBUTION_POLICY", "DISTRIBUTED", "NON_DISTRIBUTED", "EVICTION_POLICY", "NONE", "LRU", "LOCK_SCOPE", "THREAD", "PROCESS", "LOCK_TTL", "LOCK_WAIT", "MIN_SEEDERS", "PERSISTENCE_POLICY", "SYNC", "ASYNC", "PERSISTENCE", "SHARED_ALL", "SHARED_NOTHING", "PERSISTENCE_TYPE", "PHASE_COUNT", "PHASE_INTERVAL", "READ_TIMEOUT", "REPLICATION_COUNT", "REPLICATION_POLICY", "TTL", "UPDATE_TRANSPORT", "UNICAST", "MULTICAST", "SPACE_WAIT", "WRITE_TIMEOUT", "CONSTRAINT", "INDEX", "ONLY", "AND", "OR", "IN", "Period", "Plus", "Minus", "Divide", "DVertbar", "Range", "Underscore", "C", "R", "E", "A", "T", "S", "L", "I", "N", "U", "P", "D", "B", "G", "O", "H", "M", "F", "X", "V", "MODULE", "Y", "K", "W", "IS", "J", "Q", "Z", "Int", "Digit", "IdentifierStart", "IdentifierPart", "DoubleQuotedIdentifier", "Comment", "SingleSpace", "ControlSpace", "Space"
    };
    public static final int UNICAST=89;
    public static final int CAPACITY=62;
    public static final int DVertbar=103;
    public static final int TTL=87;
    public static final int CHAR=23;
    public static final int NOR=55;
    public static final int NOT=54;
    public static final int EOF=-1;
    public static final int QMark=56;
    public static final int Int=134;
    public static final int Identifier=19;
    public static final int CREATE=4;
    public static final int CParen=8;
    public static final int INSERT=12;
    public static final int IS_NULL=52;
    public static final int Comment=139;
    public static final int PRIMARY_KEY=21;
    public static final int DOUBLE=32;
    public static final int EVICTION_POLICY=66;
    public static final int UPDATE_TRANSPORT=88;
    public static final int PHASE_INTERVAL=83;
    public static final int SELECT=15;
    public static final int INTO=13;
    public static final int ControlSpace=141;
    public static final int D=117;
    public static final int Period=99;
    public static final int E=108;
    public static final int F=123;
    public static final int G=119;
    public static final int LThan=50;
    public static final int BLOB=33;
    public static final int A=109;
    public static final int Underscore=105;
    public static final int B=118;
    public static final int C=106;
    public static final int L=112;
    public static final int M=122;
    public static final int N=114;
    public static final int DISTRIBUTION_POLICY=63;
    public static final int O=120;
    public static final int H=121;
    public static final int I=113;
    public static final int NULL=41;
    public static final int J=131;
    public static final int K=128;
    public static final int IdentifierStart=136;
    public static final int U=115;
    public static final int T=110;
    public static final int W=129;
    public static final int V=125;
    public static final int Q=132;
    public static final int P=116;
    public static final int CHAR1=24;
    public static final int DELETE=9;
    public static final int S=111;
    public static final int R=107;
    public static final int Y=127;
    public static final int X=124;
    public static final int Z=133;
    public static final int Float=40;
    public static final int REAL=31;
    public static final int Range=104;
    public static final int LOCK_WAIT=73;
    public static final int Minus=101;
    public static final int REPLICATION_POLICY=86;
    public static final int NONE=67;
    public static final int OR=97;
    public static final int PERSISTENCE=78;
    public static final int FROM=10;
    public static final int CONSTRAINT=93;
    public static final int Equals=46;
    public static final int DISTINCT=61;
    public static final int TIMESTAMP=37;
    public static final int PHASE_COUNT=82;
    public static final int WHERE=11;
    public static final int OParen=6;
    public static final int SingleSpace=140;
    public static final int LIMIT=16;
    public static final int ONLY=95;
    public static final int TABLE=5;
    public static final int UPDATE=17;
    public static final int VARCHAR=26;
    public static final int DISTRIBUTED=64;
    public static final int SHARED_NOTHING=80;
    public static final int AND=96;
    public static final int QuotedString=38;
    public static final int MIN_SEEDERS=74;
    public static final int NOT_NULL=20;
    public static final int Space=142;
    public static final int INDEX=94;
    public static final int TIME=36;
    public static final int AS=58;
    public static final int IN=98;
    public static final int TREE=44;
    public static final int ASYNC=77;
    public static final int IS=130;
    public static final int OFFSET=45;
    public static final int LRU=68;
    public static final int NegativeNumber=39;
    public static final int ALL=60;
    public static final int GTEquals=49;
    public static final int IdentifierPart=137;
    public static final int GThan=48;
    public static final int INTEGER=29;
    public static final int Asterisk=59;
    public static final int THREAD=70;
    public static final int NotEquals=47;
    public static final int SYNC=76;
    public static final int PERSISTENCE_POLICY=75;
    public static final int WRITE_TIMEOUT=92;
    public static final int DATETIME=34;
    public static final int VALUES=14;
    public static final int HASH=43;
    public static final int SET=18;
    public static final int PositiveNumber=25;
    public static final int IS_NOT_NULL=53;
    public static final int Digit=135;
    public static final int MODULE=126;
    public static final int Divide=102;
    public static final int PERSISTENCE_TYPE=81;
    public static final int SPACE_WAIT=91;
    public static final int SColon=42;
    public static final int SHARED_ALL=79;
    public static final int Plus=100;
    public static final int DoubleQuotedIdentifier=138;
    public static final int LOCK_SCOPE=69;
    public static final int BIGINT=30;
    public static final int LONGVARCHAR=27;
    public static final int LOCK_TTL=72;
    public static final int NON_DISTRIBUTED=65;
    public static final int MULTICAST=90;
    public static final int Dot=57;
    public static final int BIT=22;
    public static final int DATE=35;
    public static final int PROCESS=71;
    public static final int Comma=7;
    public static final int REPLICATION_COUNT=85;
    public static final int SMALLINT=28;
    public static final int LTEquals=51;
    public static final int READ_TIMEOUT=84;

    // delegates
    // delegators


        public ASSQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ASSQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return ASSQLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g"; }


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



    // $ANTLR start "query"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:92:1: query returns [ASSQLStatement stmnt] : ( createStatement endStmnt | deleteStatement endStmnt | insertStatement endStmnt | selectStatement endStmnt | updateStatement endStmnt );
    public final ASSQLStatement query() throws RecognitionException {
        ASSQLStatement stmnt = null;

        CreateStatement createStatement1 = null;

        DeleteStatement deleteStatement2 = null;

        InsertStatement insertStatement3 = null;

        SelectStatement selectStatement4 = null;

        UpdateStatement updateStatement5 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:93:5: ( createStatement endStmnt | deleteStatement endStmnt | insertStatement endStmnt | selectStatement endStmnt | updateStatement endStmnt )
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:93:7: createStatement endStmnt
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:94:7: deleteStatement endStmnt
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:95:7: insertStatement endStmnt
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:96:7: selectStatement endStmnt
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:97:7: updateStatement endStmnt
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:100:1: createStatement returns [CreateStatement expr] : CREATE TABLE target_table OParen table_element ( Comma table_element )* CParen (c= space_property ( Comma d= space_property )* )* ;
    public final CreateStatement createStatement() throws RecognitionException {
        CreateStatement expr = null;

        ASSQLParser.space_property_return c = null;

        ASSQLParser.space_property_return d = null;

        String target_table6 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:101:5: ( CREATE TABLE target_table OParen table_element ( Comma table_element )* CParen (c= space_property ( Comma d= space_property )* )* )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:101:7: CREATE TABLE target_table OParen table_element ( Comma table_element )* CParen (c= space_property ( Comma d= space_property )* )*
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

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:106:28: ( Comma table_element )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comma) ) {
                    alt2=1;
                }


                switch (alt2) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:106:29: Comma table_element
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
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:107:7: (c= space_property ( Comma d= space_property )* )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CAPACITY && LA4_0<=DISTRIBUTION_POLICY)||LA4_0==EVICTION_POLICY||LA4_0==LOCK_SCOPE||(LA4_0>=LOCK_TTL && LA4_0<=PERSISTENCE_POLICY)||LA4_0==PERSISTENCE||(LA4_0>=PERSISTENCE_TYPE && LA4_0<=UPDATE_TRANSPORT)||(LA4_0>=SPACE_WAIT && LA4_0<=WRITE_TIMEOUT)) ) {
                    alt4=1;
                }


                switch (alt4) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:107:8: c= space_property ( Comma d= space_property )*
                    {
                    pushFollow(FOLLOW_space_property_in_createStatement182);
                    c=space_property();

                    state._fsp--;

                    sdprops.put((c!=null?c.key:null), (c!=null?c.value:null));
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:107:58: ( Comma d= space_property )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==Comma) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                        case 1 :
                            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:107:59: Comma d= space_property
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:113:1: deleteStatement returns [DeleteStatement expr] : DELETE FROM target_table ( WHERE where_condition )? ;
    public final DeleteStatement deleteStatement() throws RecognitionException {
        DeleteStatement expr = null;

        String target_table7 = null;

        String where_condition8 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:114:5: ( DELETE FROM target_table ( WHERE where_condition )? )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:114:7: DELETE FROM target_table ( WHERE where_condition )?
            {
            match(input,DELETE,FOLLOW_DELETE_in_deleteStatement227);
            match(input,FROM,FOLLOW_FROM_in_deleteStatement229);
            pushFollow(FOLLOW_target_table_in_deleteStatement231);
            target_table7=target_table();

            state._fsp--;

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:115:7: ( WHERE where_condition )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WHERE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:115:8: WHERE where_condition
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:121:1: insertStatement returns [InsertStatement expr] : INSERT INTO table_name OParen c= column_name ( Comma d= column_name )* CParen VALUES OParen e= column_value ( Comma f= column_value )* CParen ;
    public final InsertStatement insertStatement() throws RecognitionException {
        InsertStatement expr = null;

        ASSQLParser.column_name_return c = null;

        ASSQLParser.column_name_return d = null;

        ASSQLParser.column_value_return e = null;

        ASSQLParser.column_value_return f = null;

        ASSQLParser.table_name_return table_name9 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:122:5: ( INSERT INTO table_name OParen c= column_name ( Comma d= column_name )* CParen VALUES OParen e= column_value ( Comma f= column_value )* CParen )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:122:7: INSERT INTO table_name OParen c= column_name ( Comma d= column_name )* CParen VALUES OParen e= column_value ( Comma f= column_value )* CParen
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
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:127:56: ( Comma d= column_name )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Comma) ) {
                    alt6=1;
                }


                switch (alt6) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:127:58: Comma d= column_name
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
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:128:65: ( Comma f= column_value )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Comma) ) {
                    alt7=1;
                }


                switch (alt7) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:128:67: Comma f= column_value
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:134:1: selectStatement returns [SelectStatement expr] : SELECT ( select_quantifier )? select_list FROM table_reference_list ( WHERE where_condition )? ( LIMIT limit_clause )? ;
    public final SelectStatement selectStatement() throws RecognitionException {
        SelectStatement expr = null;

        ASSQLParser.select_quantifier_return select_quantifier10 = null;

        List<String> table_reference_list11 = null;

        String where_condition12 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:135:5: ( SELECT ( select_quantifier )? select_list FROM table_reference_list ( WHERE where_condition )? ( LIMIT limit_clause )? )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:135:7: SELECT ( select_quantifier )? select_list FROM table_reference_list ( WHERE where_condition )? ( LIMIT limit_clause )?
            {
            match(input,SELECT,FOLLOW_SELECT_in_selectStatement374);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:135:14: ( select_quantifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=ALL && LA8_0<=DISTINCT)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:135:15: select_quantifier
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
            table_reference_list11=table_reference_list();

            state._fsp--;

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:139:7: ( WHERE where_condition )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==WHERE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:139:8: WHERE where_condition
                    {
                    match(input,WHERE,FOLLOW_WHERE_in_selectStatement413);
                    pushFollow(FOLLOW_where_condition_in_selectStatement415);
                    where_condition12=where_condition();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:140:7: ( LIMIT limit_clause )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LIMIT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:140:8: LIMIT limit_clause
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_selectStatement426);
                    pushFollow(FOLLOW_limit_clause_in_selectStatement428);
                    limit_clause();

                    state._fsp--;


                    }
                    break;

            }


                      return new SelectStatement((select_quantifier10!=null?input.toString(select_quantifier10.start,select_quantifier10.stop):null), columnInfo, table_reference_list11, where_condition12);


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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:150:1: updateStatement returns [UpdateStatement expr] : UPDATE target_table SET a= set_clause ( Comma b= set_clause )* ( WHERE where_condition )? ;
    public final UpdateStatement updateStatement() throws RecognitionException {
        UpdateStatement expr = null;

        ASSQLParser.set_clause_return a = null;

        ASSQLParser.set_clause_return b = null;

        String target_table13 = null;

        String where_condition14 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:151:5: ( UPDATE target_table SET a= set_clause ( Comma b= set_clause )* ( WHERE where_condition )? )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:151:7: UPDATE target_table SET a= set_clause ( Comma b= set_clause )* ( WHERE where_condition )?
            {

                      HashMap<String,String> cValues = new HashMap<String,String>();

            match(input,UPDATE,FOLLOW_UPDATE_in_updateStatement495);
            pushFollow(FOLLOW_target_table_in_updateStatement497);
            target_table13=target_table();

            state._fsp--;

            match(input,SET,FOLLOW_SET_in_updateStatement505);
            pushFollow(FOLLOW_set_clause_in_updateStatement509);
            a=set_clause();

            state._fsp--;

             cValues.put((a!=null?a.cname:null), (a!=null?a.cvalue:null));
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:156:10: ( Comma b= set_clause )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Comma) ) {
                    alt11=1;
                }


                switch (alt11) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:156:11: Comma b= set_clause
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

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:157:7: ( WHERE where_condition )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WHERE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:157:8: WHERE where_condition
                    {
                    match(input,WHERE,FOLLOW_WHERE_in_updateStatement541);
                    pushFollow(FOLLOW_where_condition_in_updateStatement543);
                    where_condition14=where_condition();

                    state._fsp--;


                    }
                    break;

            }


                      return new UpdateStatement(target_table13, cValues, where_condition14);


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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:163:1: alias : Identifier ;
    public final ASSQLParser.alias_return alias() throws RecognitionException {
        ASSQLParser.alias_return retval = new ASSQLParser.alias_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:164:5: ( Identifier )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:164:7: Identifier
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:167:1: column_def : column_name column_type ( NOT_NULL | PRIMARY_KEY ( key_type )? )* ;
    public final void column_def() throws RecognitionException {
        ASSQLParser.key_type_return key_type15 = null;

        ASSQLParser.column_name_return column_name16 = null;

        String column_type17 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:168:5: ( column_name column_type ( NOT_NULL | PRIMARY_KEY ( key_type )? )* )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:168:7: column_name column_type ( NOT_NULL | PRIMARY_KEY ( key_type )? )*
            {

                      String not_null = null;
                      String pkey = null;
                      String pkey_type = null;

            pushFollow(FOLLOW_column_name_in_column_def595);
            column_name16=column_name();

            state._fsp--;

            pushFollow(FOLLOW_column_type_in_column_def597);
            column_type17=column_type();

            state._fsp--;

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:174:7: ( NOT_NULL | PRIMARY_KEY ( key_type )? )*
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:175:9: NOT_NULL
                    {
                    match(input,NOT_NULL,FOLLOW_NOT_NULL_in_column_def615);
                     not_null = "true";

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:176:9: PRIMARY_KEY ( key_type )?
                    {
                    match(input,PRIMARY_KEY,FOLLOW_PRIMARY_KEY_in_column_def627);
                     pkey = "true";
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:176:41: ( key_type )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=HASH && LA13_0<=TREE)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:176:42: key_type
                            {
                            pushFollow(FOLLOW_key_type_in_column_def633);
                            key_type15=key_type();

                            state._fsp--;

                             pkey_type = (key_type15!=null?input.toString(key_type15.start,key_type15.stop):null).toLowerCase();

                            }
                            break;

                    }


                    }
                    break;

                default :
                    break loop14;
                }
            } while (true);


                      addColumnDef((column_name16!=null?input.toString(column_name16.start,column_name16.stop):null), column_type17, not_null, pkey, pkey_type);


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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:183:1: column_name : Identifier ;
    public final ASSQLParser.column_name_return column_name() throws RecognitionException {
        ASSQLParser.column_name_return retval = new ASSQLParser.column_name_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:184:5: ( Identifier )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:184:7: Identifier
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:187:1: column_type returns [String type] : ( BIT | CHAR | CHAR1 | CHAR OParen PositiveNumber CParen | VARCHAR | VARCHAR OParen PositiveNumber CParen | LONGVARCHAR | LONGVARCHAR OParen PositiveNumber CParen | SMALLINT | INTEGER | BIGINT | REAL | DOUBLE | BLOB | DATETIME | DATE | TIME | TIMESTAMP );
    public final String column_type() throws RecognitionException {
        String type = null;

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:188:5: ( BIT | CHAR | CHAR1 | CHAR OParen PositiveNumber CParen | VARCHAR | VARCHAR OParen PositiveNumber CParen | LONGVARCHAR | LONGVARCHAR OParen PositiveNumber CParen | SMALLINT | INTEGER | BIGINT | REAL | DOUBLE | BLOB | DATETIME | DATE | TIME | TIMESTAMP )
            int alt15=18;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:188:7: BIT
                    {
                    match(input,BIT,FOLLOW_BIT_in_column_type692);
                     type = "boolean";

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:189:7: CHAR
                    {
                    match(input,CHAR,FOLLOW_CHAR_in_column_type710);
                     type = "char";

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:190:7: CHAR1
                    {
                    match(input,CHAR1,FOLLOW_CHAR1_in_column_type728);
                     type = "char";

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:191:7: CHAR OParen PositiveNumber CParen
                    {
                    match(input,CHAR,FOLLOW_CHAR_in_column_type744);
                    match(input,OParen,FOLLOW_OParen_in_column_type746);
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_column_type748);
                    match(input,CParen,FOLLOW_CParen_in_column_type750);
                     type = "string";

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:192:7: VARCHAR
                    {
                    match(input,VARCHAR,FOLLOW_VARCHAR_in_column_type760);
                     type = "string";

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:193:7: VARCHAR OParen PositiveNumber CParen
                    {
                    match(input,VARCHAR,FOLLOW_VARCHAR_in_column_type774);
                    match(input,OParen,FOLLOW_OParen_in_column_type776);
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_column_type778);
                    match(input,CParen,FOLLOW_CParen_in_column_type780);
                     type = "string";

                    }
                    break;
                case 7 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:194:7: LONGVARCHAR
                    {
                    match(input,LONGVARCHAR,FOLLOW_LONGVARCHAR_in_column_type790);
                     type = "string";

                    }
                    break;
                case 8 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:195:7: LONGVARCHAR OParen PositiveNumber CParen
                    {
                    match(input,LONGVARCHAR,FOLLOW_LONGVARCHAR_in_column_type800);
                    match(input,OParen,FOLLOW_OParen_in_column_type802);
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_column_type804);
                    match(input,CParen,FOLLOW_CParen_in_column_type806);
                     type = "string";

                    }
                    break;
                case 9 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:196:7: SMALLINT
                    {
                    match(input,SMALLINT,FOLLOW_SMALLINT_in_column_type816);
                     type = "short";

                    }
                    break;
                case 10 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:197:7: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_column_type829);
                     type = "integer";

                    }
                    break;
                case 11 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:198:7: BIGINT
                    {
                    match(input,BIGINT,FOLLOW_BIGINT_in_column_type843);
                     type = "long";

                    }
                    break;
                case 12 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:199:7: REAL
                    {
                    match(input,REAL,FOLLOW_REAL_in_column_type858);
                     type = "float";

                    }
                    break;
                case 13 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:200:7: DOUBLE
                    {
                    match(input,DOUBLE,FOLLOW_DOUBLE_in_column_type875);
                     type = "double";

                    }
                    break;
                case 14 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:201:7: BLOB
                    {
                    match(input,BLOB,FOLLOW_BLOB_in_column_type890);
                     type = "blob";

                    }
                    break;
                case 15 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:202:7: DATETIME
                    {
                    match(input,DATETIME,FOLLOW_DATETIME_in_column_type907);
                     type = "datetime";

                    }
                    break;
                case 16 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:203:7: DATE
                    {
                    match(input,DATE,FOLLOW_DATE_in_column_type920);
                     type = "datetime";

                    }
                    break;
                case 17 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:204:7: TIME
                    {
                    match(input,TIME,FOLLOW_TIME_in_column_type937);
                     type = "datetime";

                    }
                    break;
                case 18 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:205:7: TIMESTAMP
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:208:1: column_value : ( QuotedString | PositiveNumber | NegativeNumber | Float | NULL );
    public final ASSQLParser.column_value_return column_value() throws RecognitionException {
        ASSQLParser.column_value_return retval = new ASSQLParser.column_value_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:209:5: ( QuotedString | PositiveNumber | NegativeNumber | Float | NULL )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:
            {
            if ( input.LA(1)==PositiveNumber||(input.LA(1)>=QuotedString && input.LA(1)<=NULL) ) {
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:216:1: endStmnt : ( SColon )? EOF ;
    public final void endStmnt() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:217:5: ( ( SColon )? EOF )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:217:7: ( SColon )? EOF
            {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:217:7: ( SColon )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SColon) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:217:7: SColon
                    {
                    match(input,SColon,FOLLOW_SColon_in_endStmnt1034);

                    }
                    break;

            }

            match(input,EOF,FOLLOW_EOF_in_endStmnt1038);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:220:1: key_type : ( HASH | TREE );
    public final ASSQLParser.key_type_return key_type() throws RecognitionException {
        ASSQLParser.key_type_return retval = new ASSQLParser.key_type_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:221:5: ( HASH | TREE )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:225:1: limit_clause : ( PositiveNumber OFFSET PositiveNumber | ( PositiveNumber Comma ) PositiveNumber );
    public final void limit_clause() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:226:5: ( PositiveNumber OFFSET PositiveNumber | ( PositiveNumber Comma ) PositiveNumber )
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:226:7: PositiveNumber OFFSET PositiveNumber
                    {
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1080);
                    match(input,OFFSET,FOLLOW_OFFSET_in_limit_clause1082);
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1084);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:227:7: ( PositiveNumber Comma ) PositiveNumber
                    {
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:227:7: ( PositiveNumber Comma )
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:227:8: PositiveNumber Comma
                    {
                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1093);
                    match(input,Comma,FOLLOW_Comma_in_limit_clause1095);

                    }

                    match(input,PositiveNumber,FOLLOW_PositiveNumber_in_limit_clause1098);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:230:1: relation returns [String arg] : (a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm | c= relation_null | d= relation_not );
    public final String relation() throws RecognitionException {
        String arg = null;

        Token type=null;
        ASSQLParser.rterm_return a = null;

        ASSQLParser.rterm_return b = null;

        String c = null;

        String d = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:231:5: (a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm | c= relation_null | d= relation_not )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Identifier) ) {
                switch ( input.LA(2) ) {
                case IS_NULL:
                case IS_NOT_NULL:
                    {
                    alt18=2;
                    }
                    break;
                case NOT:
                    {
                    alt18=3;
                    }
                    break;
                case Equals:
                case NotEquals:
                case GThan:
                case GTEquals:
                case LThan:
                case LTEquals:
                    {
                    alt18=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA18_0==PositiveNumber||(LA18_0>=QuotedString && LA18_0<=NULL)||LA18_0==QMark) ) {
                alt18=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:231:7: a= rterm type= ( Equals | NotEquals | GThan | GTEquals | LThan | LTEquals ) b= rterm
                    {
                    pushFollow(FOLLOW_rterm_in_relation1121);
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

                    pushFollow(FOLLOW_rterm_in_relation1151);
                    b=rterm();

                    state._fsp--;

                    arg = (a!=null?input.toString(a.start,a.stop):null) + (type!=null?type.getText():null) + (b!=null?input.toString(b.start,b.stop):null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:232:7: c= relation_null
                    {
                    pushFollow(FOLLOW_relation_null_in_relation1163);
                    c=relation_null();

                    state._fsp--;

                    arg = c;

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:233:7: d= relation_not
                    {
                    pushFollow(FOLLOW_relation_not_in_relation1175);
                    d=relation_not();

                    state._fsp--;

                    arg = d;

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


    // $ANTLR start "relation_null"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:236:1: relation_null returns [String arg] : ( Identifier IS_NULL | Identifier IS_NOT_NULL );
    public final String relation_null() throws RecognitionException {
        String arg = null;

        Token Identifier18=null;
        Token Identifier19=null;

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:237:5: ( Identifier IS_NULL | Identifier IS_NOT_NULL )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Identifier) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==IS_NULL) ) {
                    alt19=1;
                }
                else if ( (LA19_1==IS_NOT_NULL) ) {
                    alt19=2;
                }
                else {
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:237:7: Identifier IS_NULL
                    {
                    Identifier18=(Token)match(input,Identifier,FOLLOW_Identifier_in_relation_null1198);
                    match(input,IS_NULL,FOLLOW_IS_NULL_in_relation_null1200);
                    arg = (Identifier18!=null?Identifier18.getText():null) + " IS NULL";

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:238:7: Identifier IS_NOT_NULL
                    {
                    Identifier19=(Token)match(input,Identifier,FOLLOW_Identifier_in_relation_null1210);
                    match(input,IS_NOT_NULL,FOLLOW_IS_NOT_NULL_in_relation_null1212);
                    arg = (Identifier19!=null?Identifier19.getText():null) + " IS NOT NULL";

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:241:1: relation_not returns [String arg] : a= Identifier NOT b= column_value ( NOR c= column_value )? ;
    public final String relation_not() throws RecognitionException {
        String arg = null;

        Token a=null;
        ASSQLParser.column_value_return b = null;

        ASSQLParser.column_value_return c = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:242:5: (a= Identifier NOT b= column_value ( NOR c= column_value )? )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:242:7: a= Identifier NOT b= column_value ( NOR c= column_value )?
            {
            a=(Token)match(input,Identifier,FOLLOW_Identifier_in_relation_not1237);
            match(input,NOT,FOLLOW_NOT_in_relation_not1239);
            pushFollow(FOLLOW_column_value_in_relation_not1243);
            b=column_value();

            state._fsp--;

            arg = (a!=null?a.getText():null) + " NOT " + (b!=null?input.toString(b.start,b.stop):null);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:242:77: ( NOR c= column_value )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NOR) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:242:78: NOR c= column_value
                    {
                    match(input,NOR,FOLLOW_NOR_in_relation_not1248);
                    pushFollow(FOLLOW_column_value_in_relation_not1252);
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:245:1: rterm_list : rterm ( Comma rterm )* ;
    public final ASSQLParser.rterm_list_return rterm_list() throws RecognitionException {
        ASSQLParser.rterm_list_return retval = new ASSQLParser.rterm_list_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:246:5: ( rterm ( Comma rterm )* )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:246:7: rterm ( Comma rterm )*
            {
            pushFollow(FOLLOW_rterm_in_rterm_list1285);
            rterm();

            state._fsp--;

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:246:13: ( Comma rterm )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Comma) ) {
                    alt21=1;
                }


                switch (alt21) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:246:14: Comma rterm
                    {
                    match(input,Comma,FOLLOW_Comma_in_rterm_list1288);
                    pushFollow(FOLLOW_rterm_in_rterm_list1290);
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

    public static class rterm_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "rterm"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:249:1: rterm : ( Identifier | QMark | column_value );
    public final ASSQLParser.rterm_return rterm() throws RecognitionException {
        ASSQLParser.rterm_return retval = new ASSQLParser.rterm_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:250:5: ( Identifier | QMark | column_value )
            int alt22=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt22=1;
                }
                break;
            case QMark:
                {
                alt22=2;
                }
                break;
            case PositiveNumber:
            case QuotedString:
            case NegativeNumber:
            case Float:
            case NULL:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:250:7: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_rterm1309);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:251:7: QMark
                    {
                    match(input,QMark,FOLLOW_QMark_in_rterm1317);

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:252:7: column_value
                    {
                    pushFollow(FOLLOW_column_value_in_rterm1325);
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


    // $ANTLR start "schema_name"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:255:1: schema_name : Identifier ;
    public final void schema_name() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:256:5: ( Identifier )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:256:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_schema_name1342);

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
    // $ANTLR end "schema_name"

    public static class select_column_return extends ParserRuleReturnScope {
        public String cname;
        public String tname;
        public String calias;
    };

    // $ANTLR start "select_column"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:259:1: select_column returns [String cname, String tname, String calias] : ( table_name Dot )? column_name ( AS alias )? ;
    public final ASSQLParser.select_column_return select_column() throws RecognitionException {
        ASSQLParser.select_column_return retval = new ASSQLParser.select_column_return();
        retval.start = input.LT(1);

        ASSQLParser.table_name_return table_name20 = null;

        ASSQLParser.column_name_return column_name21 = null;

        ASSQLParser.alias_return alias22 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:5: ( ( table_name Dot )? column_name ( AS alias )? )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:7: ( table_name Dot )? column_name ( AS alias )?
            {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:7: ( table_name Dot )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Identifier) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==Dot) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:260:8: table_name Dot
                    {
                    pushFollow(FOLLOW_table_name_in_select_column1372);
                    table_name20=table_name();

                    state._fsp--;

                    match(input,Dot,FOLLOW_Dot_in_select_column1374);
                     retval.tname = (table_name20!=null?input.toString(table_name20.start,table_name20.stop):null);

                    }
                    break;

            }

            pushFollow(FOLLOW_column_name_in_select_column1381);
            column_name21=column_name();

            state._fsp--;

             retval.cname = (column_name21!=null?input.toString(column_name21.start,column_name21.stop):null);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:261:7: ( AS alias )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==AS) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:261:8: AS alias
                    {
                    match(input,AS,FOLLOW_AS_in_select_column1392);
                    pushFollow(FOLLOW_alias_in_select_column1394);
                    alias22=alias();

                    state._fsp--;

                     retval.calias = (alias22!=null?input.toString(alias22.start,alias22.stop):null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:264:1: select_column_list : a= select_column ( Comma b= select_column )* ;
    public final void select_column_list() throws RecognitionException {
        ASSQLParser.select_column_return a = null;

        ASSQLParser.select_column_return b = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:265:5: (a= select_column ( Comma b= select_column )* )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:265:7: a= select_column ( Comma b= select_column )*
            {
            pushFollow(FOLLOW_select_column_in_select_column_list1417);
            a=select_column();

            state._fsp--;

             addColumnInfo((a!=null?a.cname:null), (a!=null?a.tname:null), (a!=null?a.calias:null));
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:266:7: ( Comma b= select_column )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==Comma) ) {
                    alt25=1;
                }


                switch (alt25) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:266:8: Comma b= select_column
                    {
                    match(input,Comma,FOLLOW_Comma_in_select_column_list1428);
                    pushFollow(FOLLOW_select_column_in_select_column_list1432);
                    b=select_column();

                    state._fsp--;

                     addColumnInfo((b!=null?b.cname:null), (b!=null?b.tname:null), (b!=null?b.calias:null));

                    }
                    break;

                default :
                    break loop25;
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:269:1: select_list : ( Asterisk | a= table_name Dot b= Asterisk ( Comma c= table_name Dot d= Asterisk )* | select_column_list );
    public final void select_list() throws RecognitionException {
        Token b=null;
        Token d=null;
        Token Asterisk23=null;
        ASSQLParser.table_name_return a = null;

        ASSQLParser.table_name_return c = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:270:5: ( Asterisk | a= table_name Dot b= Asterisk ( Comma c= table_name Dot d= Asterisk )* | select_column_list )
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Asterisk) ) {
                alt27=1;
            }
            else if ( (LA27_0==Identifier) ) {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==Dot) ) {
                    int LA27_3 = input.LA(3);

                    if ( (LA27_3==Asterisk) ) {
                        alt27=2;
                    }
                    else if ( (LA27_3==Identifier) ) {
                        alt27=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA27_2==Comma||LA27_2==FROM||LA27_2==AS) ) {
                    alt27=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:270:7: Asterisk
                    {
                    Asterisk23=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_select_list1453);
                     addColumnInfo((Asterisk23!=null?Asterisk23.getText():null),null,null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:271:7: a= table_name Dot b= Asterisk ( Comma c= table_name Dot d= Asterisk )*
                    {
                    pushFollow(FOLLOW_table_name_in_select_list1465);
                    a=table_name();

                    state._fsp--;

                    match(input,Dot,FOLLOW_Dot_in_select_list1467);
                    b=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_select_list1471);
                     addColumnInfo((b!=null?b.getText():null), (a!=null?input.toString(a.start,a.stop):null), null);
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:272:7: ( Comma c= table_name Dot d= Asterisk )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==Comma) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                        case 1 :
                            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:272:8: Comma c= table_name Dot d= Asterisk
                            {
                            match(input,Comma,FOLLOW_Comma_in_select_list1482);
                            pushFollow(FOLLOW_table_name_in_select_list1486);
                            c=table_name();

                            state._fsp--;

                            match(input,Dot,FOLLOW_Dot_in_select_list1488);
                            d=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_select_list1492);
                             addColumnInfo((d!=null?d.getText():null), (c!=null?input.toString(c.start,c.stop):null), null);

                            }
                            break;

                        default :
                            break loop26;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:273:7: select_column_list
                    {
                    pushFollow(FOLLOW_select_column_list_in_select_list1504);
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:276:1: select_quantifier : ( ALL | DISTINCT );
    public final ASSQLParser.select_quantifier_return select_quantifier() throws RecognitionException {
        ASSQLParser.select_quantifier_return retval = new ASSQLParser.select_quantifier_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:277:5: ( ALL | DISTINCT )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:281:1: set_clause returns [String cname, String cvalue] : c= column_name Equals v= column_value ;
    public final ASSQLParser.set_clause_return set_clause() throws RecognitionException {
        ASSQLParser.set_clause_return retval = new ASSQLParser.set_clause_return();
        retval.start = input.LT(1);

        ASSQLParser.column_name_return c = null;

        ASSQLParser.column_value_return v = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:282:5: (c= column_name Equals v= column_value )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:282:7: c= column_name Equals v= column_value
            {
            pushFollow(FOLLOW_column_name_in_set_clause1552);
            c=column_name();

            state._fsp--;

            match(input,Equals,FOLLOW_Equals_in_set_clause1554);
            pushFollow(FOLLOW_column_value_in_set_clause1558);
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:285:1: space_property returns [String key, String value] : ( space_capacity | space_distribution_policy | space_eviction_policy | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_read_timeout | space_replication_count | space_replication_policy | space_ttl | space_update_transport | space_wait | space_write_timeout ) ;
    public final ASSQLParser.space_property_return space_property() throws RecognitionException {
        ASSQLParser.space_property_return retval = new ASSQLParser.space_property_return();
        retval.start = input.LT(1);

        ASSQLParser.space_capacity_return space_capacity24 = null;

        ASSQLParser.space_distribution_policy_return space_distribution_policy25 = null;

        ASSQLParser.space_eviction_policy_return space_eviction_policy26 = null;

        ASSQLParser.space_lock_scope_return space_lock_scope27 = null;

        ASSQLParser.space_lock_ttl_return space_lock_ttl28 = null;

        ASSQLParser.space_lock_wait_return space_lock_wait29 = null;

        ASSQLParser.space_min_seeders_return space_min_seeders30 = null;

        ASSQLParser.space_persistence_policy_return space_persistence_policy31 = null;

        ASSQLParser.space_persistence_type_return space_persistence_type32 = null;

        ASSQLParser.space_phase_count_return space_phase_count33 = null;

        ASSQLParser.space_phase_interval_return space_phase_interval34 = null;

        ASSQLParser.space_read_timeout_return space_read_timeout35 = null;

        ASSQLParser.space_replication_count_return space_replication_count36 = null;

        ASSQLParser.space_replication_policy_return space_replication_policy37 = null;

        ASSQLParser.space_ttl_return space_ttl38 = null;

        ASSQLParser.space_update_transport_return space_update_transport39 = null;

        ASSQLParser.space_wait_return space_wait40 = null;

        ASSQLParser.space_write_timeout_return space_write_timeout41 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:286:5: ( ( space_capacity | space_distribution_policy | space_eviction_policy | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_read_timeout | space_replication_count | space_replication_policy | space_ttl | space_update_transport | space_wait | space_write_timeout ) )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:286:7: ( space_capacity | space_distribution_policy | space_eviction_policy | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_read_timeout | space_replication_count | space_replication_policy | space_ttl | space_update_transport | space_wait | space_write_timeout )
            {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:286:7: ( space_capacity | space_distribution_policy | space_eviction_policy | space_lock_scope | space_lock_ttl | space_lock_wait | space_min_seeders | space_persistence_policy | space_persistence_type | space_phase_count | space_phase_interval | space_read_timeout | space_replication_count | space_replication_policy | space_ttl | space_update_transport | space_wait | space_write_timeout )
            int alt28=18;
            switch ( input.LA(1) ) {
            case CAPACITY:
                {
                alt28=1;
                }
                break;
            case DISTRIBUTION_POLICY:
                {
                alt28=2;
                }
                break;
            case EVICTION_POLICY:
                {
                alt28=3;
                }
                break;
            case LOCK_SCOPE:
                {
                alt28=4;
                }
                break;
            case LOCK_TTL:
                {
                alt28=5;
                }
                break;
            case LOCK_WAIT:
                {
                alt28=6;
                }
                break;
            case MIN_SEEDERS:
                {
                alt28=7;
                }
                break;
            case PERSISTENCE_POLICY:
                {
                alt28=8;
                }
                break;
            case PERSISTENCE:
            case PERSISTENCE_TYPE:
                {
                alt28=9;
                }
                break;
            case PHASE_COUNT:
                {
                alt28=10;
                }
                break;
            case PHASE_INTERVAL:
                {
                alt28=11;
                }
                break;
            case READ_TIMEOUT:
                {
                alt28=12;
                }
                break;
            case REPLICATION_COUNT:
                {
                alt28=13;
                }
                break;
            case REPLICATION_POLICY:
                {
                alt28=14;
                }
                break;
            case TTL:
                {
                alt28=15;
                }
                break;
            case UPDATE_TRANSPORT:
                {
                alt28=16;
                }
                break;
            case SPACE_WAIT:
                {
                alt28=17;
                }
                break;
            case WRITE_TIMEOUT:
                {
                alt28=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:286:11: space_capacity
                    {
                    pushFollow(FOLLOW_space_capacity_in_space_property1585);
                    space_capacity24=space_capacity();

                    state._fsp--;

                     retval.key = (space_capacity24!=null?space_capacity24.key:null); retval.value = (space_capacity24!=null?space_capacity24.value:null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:287:11: space_distribution_policy
                    {
                    pushFollow(FOLLOW_space_distribution_policy_in_space_property1599);
                    space_distribution_policy25=space_distribution_policy();

                    state._fsp--;

                     retval.key = (space_distribution_policy25!=null?space_distribution_policy25.key:null); retval.value = (space_distribution_policy25!=null?space_distribution_policy25.value:null);

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:288:11: space_eviction_policy
                    {
                    pushFollow(FOLLOW_space_eviction_policy_in_space_property1613);
                    space_eviction_policy26=space_eviction_policy();

                    state._fsp--;

                     retval.key = (space_eviction_policy26!=null?space_eviction_policy26.key:null); retval.value = (space_eviction_policy26!=null?space_eviction_policy26.value:null);

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:289:11: space_lock_scope
                    {
                    pushFollow(FOLLOW_space_lock_scope_in_space_property1627);
                    space_lock_scope27=space_lock_scope();

                    state._fsp--;

                     retval.key = (space_lock_scope27!=null?space_lock_scope27.key:null); retval.value = (space_lock_scope27!=null?space_lock_scope27.value:null);

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:290:11: space_lock_ttl
                    {
                    pushFollow(FOLLOW_space_lock_ttl_in_space_property1641);
                    space_lock_ttl28=space_lock_ttl();

                    state._fsp--;

                     retval.key = (space_lock_ttl28!=null?space_lock_ttl28.key:null); retval.value = (space_lock_ttl28!=null?space_lock_ttl28.value:null);

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:291:11: space_lock_wait
                    {
                    pushFollow(FOLLOW_space_lock_wait_in_space_property1655);
                    space_lock_wait29=space_lock_wait();

                    state._fsp--;

                     retval.key = (space_lock_wait29!=null?space_lock_wait29.key:null); retval.value = (space_lock_wait29!=null?space_lock_wait29.value:null);

                    }
                    break;
                case 7 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:292:11: space_min_seeders
                    {
                    pushFollow(FOLLOW_space_min_seeders_in_space_property1669);
                    space_min_seeders30=space_min_seeders();

                    state._fsp--;

                     retval.key = (space_min_seeders30!=null?space_min_seeders30.key:null); retval.value = (space_min_seeders30!=null?space_min_seeders30.value:null);

                    }
                    break;
                case 8 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:293:11: space_persistence_policy
                    {
                    pushFollow(FOLLOW_space_persistence_policy_in_space_property1683);
                    space_persistence_policy31=space_persistence_policy();

                    state._fsp--;

                     retval.key = (space_persistence_policy31!=null?space_persistence_policy31.key:null); retval.value = (space_persistence_policy31!=null?space_persistence_policy31.value:null);

                    }
                    break;
                case 9 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:294:11: space_persistence_type
                    {
                    pushFollow(FOLLOW_space_persistence_type_in_space_property1697);
                    space_persistence_type32=space_persistence_type();

                    state._fsp--;

                     retval.key = (space_persistence_type32!=null?space_persistence_type32.key:null); retval.value = (space_persistence_type32!=null?space_persistence_type32.value:null);

                    }
                    break;
                case 10 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:295:11: space_phase_count
                    {
                    pushFollow(FOLLOW_space_phase_count_in_space_property1711);
                    space_phase_count33=space_phase_count();

                    state._fsp--;

                     retval.key = (space_phase_count33!=null?space_phase_count33.key:null); retval.value = (space_phase_count33!=null?space_phase_count33.value:null);

                    }
                    break;
                case 11 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:296:11: space_phase_interval
                    {
                    pushFollow(FOLLOW_space_phase_interval_in_space_property1725);
                    space_phase_interval34=space_phase_interval();

                    state._fsp--;

                     retval.key = (space_phase_interval34!=null?space_phase_interval34.key:null); retval.value = (space_phase_interval34!=null?space_phase_interval34.value:null);

                    }
                    break;
                case 12 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:297:11: space_read_timeout
                    {
                    pushFollow(FOLLOW_space_read_timeout_in_space_property1739);
                    space_read_timeout35=space_read_timeout();

                    state._fsp--;

                     retval.key = (space_read_timeout35!=null?space_read_timeout35.key:null); retval.value = (space_read_timeout35!=null?space_read_timeout35.value:null);

                    }
                    break;
                case 13 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:298:11: space_replication_count
                    {
                    pushFollow(FOLLOW_space_replication_count_in_space_property1753);
                    space_replication_count36=space_replication_count();

                    state._fsp--;

                     retval.key = (space_replication_count36!=null?space_replication_count36.key:null); retval.value = (space_replication_count36!=null?space_replication_count36.value:null);

                    }
                    break;
                case 14 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:299:11: space_replication_policy
                    {
                    pushFollow(FOLLOW_space_replication_policy_in_space_property1767);
                    space_replication_policy37=space_replication_policy();

                    state._fsp--;

                     retval.key = (space_replication_policy37!=null?space_replication_policy37.key:null); retval.value = (space_replication_policy37!=null?space_replication_policy37.value:null);

                    }
                    break;
                case 15 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:300:11: space_ttl
                    {
                    pushFollow(FOLLOW_space_ttl_in_space_property1781);
                    space_ttl38=space_ttl();

                    state._fsp--;

                     retval.key = (space_ttl38!=null?space_ttl38.key:null); retval.value = (space_ttl38!=null?space_ttl38.value:null);

                    }
                    break;
                case 16 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:301:11: space_update_transport
                    {
                    pushFollow(FOLLOW_space_update_transport_in_space_property1795);
                    space_update_transport39=space_update_transport();

                    state._fsp--;

                     retval.key = (space_update_transport39!=null?space_update_transport39.key:null); retval.value = (space_update_transport39!=null?space_update_transport39.value:null);

                    }
                    break;
                case 17 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:302:11: space_wait
                    {
                    pushFollow(FOLLOW_space_wait_in_space_property1809);
                    space_wait40=space_wait();

                    state._fsp--;

                     retval.key = (space_wait40!=null?space_wait40.key:null); retval.value = (space_wait40!=null?space_wait40.value:null);

                    }
                    break;
                case 18 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:303:11: space_write_timeout
                    {
                    pushFollow(FOLLOW_space_write_timeout_in_space_property1823);
                    space_write_timeout41=space_write_timeout();

                    state._fsp--;

                     retval.key = (space_write_timeout41!=null?space_write_timeout41.key:null); retval.value = (space_write_timeout41!=null?space_write_timeout41.value:null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:307:1: space_capacity returns [String key, String value] : CAPACITY ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_capacity_return space_capacity() throws RecognitionException {
        ASSQLParser.space_capacity_return retval = new ASSQLParser.space_capacity_return();
        retval.start = input.LT(1);

        Token NegativeNumber42=null;
        Token PositiveNumber43=null;

         retval.key = CreateStatement.CAPACITY;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:309:5: ( CAPACITY ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:309:7: CAPACITY ( NegativeNumber | PositiveNumber )
            {
            match(input,CAPACITY,FOLLOW_CAPACITY_in_space_capacity1863);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:309:16: ( NegativeNumber | PositiveNumber )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NegativeNumber) ) {
                alt29=1;
            }
            else if ( (LA29_0==PositiveNumber) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:309:18: NegativeNumber
                    {
                    NegativeNumber42=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_capacity1867);
                     retval.value = (NegativeNumber42!=null?NegativeNumber42.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:309:70: PositiveNumber
                    {
                    PositiveNumber43=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_capacity1873);
                     retval.value = (PositiveNumber43!=null?PositiveNumber43.getText():null);

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

    public static class space_distribution_policy_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_distribution_policy"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:312:1: space_distribution_policy returns [String key, String value] : ( DISTRIBUTION_POLICY a= DISTRIBUTED | DISTRIBUTION_POLICY b= NON_DISTRIBUTED );
    public final ASSQLParser.space_distribution_policy_return space_distribution_policy() throws RecognitionException {
        ASSQLParser.space_distribution_policy_return retval = new ASSQLParser.space_distribution_policy_return();
        retval.start = input.LT(1);

        Token a=null;
        Token b=null;

         retval.key = CreateStatement.DISTRIBUTION_POLICY;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:314:5: ( DISTRIBUTION_POLICY a= DISTRIBUTED | DISTRIBUTION_POLICY b= NON_DISTRIBUTED )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==DISTRIBUTION_POLICY) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==DISTRIBUTED) ) {
                    alt30=1;
                }
                else if ( (LA30_1==NON_DISTRIBUTED) ) {
                    alt30=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:314:7: DISTRIBUTION_POLICY a= DISTRIBUTED
                    {
                    match(input,DISTRIBUTION_POLICY,FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy1912);
                    a=(Token)match(input,DISTRIBUTED,FOLLOW_DISTRIBUTED_in_space_distribution_policy1916);
                     retval.value = (a!=null?a.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:315:7: DISTRIBUTION_POLICY b= NON_DISTRIBUTED
                    {
                    match(input,DISTRIBUTION_POLICY,FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy1926);
                    b=(Token)match(input,NON_DISTRIBUTED,FOLLOW_NON_DISTRIBUTED_in_space_distribution_policy1930);
                     retval.value = (b!=null?b.getText():null).toLowerCase();

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:318:1: space_eviction_policy returns [String key, String value] : ( EVICTION_POLICY NONE | EVICTION_POLICY LRU );
    public final ASSQLParser.space_eviction_policy_return space_eviction_policy() throws RecognitionException {
        ASSQLParser.space_eviction_policy_return retval = new ASSQLParser.space_eviction_policy_return();
        retval.start = input.LT(1);

        Token NONE44=null;
        Token LRU45=null;

         retval.key = CreateStatement.EVICTION_POLICY;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:320:5: ( EVICTION_POLICY NONE | EVICTION_POLICY LRU )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==EVICTION_POLICY) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==NONE) ) {
                    alt31=1;
                }
                else if ( (LA31_1==LRU) ) {
                    alt31=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:320:7: EVICTION_POLICY NONE
                    {
                    match(input,EVICTION_POLICY,FOLLOW_EVICTION_POLICY_in_space_eviction_policy1966);
                    NONE44=(Token)match(input,NONE,FOLLOW_NONE_in_space_eviction_policy1968);
                     retval.value = (NONE44!=null?NONE44.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:321:7: EVICTION_POLICY LRU
                    {
                    match(input,EVICTION_POLICY,FOLLOW_EVICTION_POLICY_in_space_eviction_policy1978);
                    LRU45=(Token)match(input,LRU,FOLLOW_LRU_in_space_eviction_policy1980);
                     retval.value = (LRU45!=null?LRU45.getText():null).toLowerCase();

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

    public static class space_lock_scope_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_lock_scope"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:324:1: space_lock_scope returns [String key, String value] : ( LOCK_SCOPE THREAD | LOCK_SCOPE PROCESS );
    public final ASSQLParser.space_lock_scope_return space_lock_scope() throws RecognitionException {
        ASSQLParser.space_lock_scope_return retval = new ASSQLParser.space_lock_scope_return();
        retval.start = input.LT(1);

        Token THREAD46=null;
        Token PROCESS47=null;

         retval.key = CreateStatement.LOCK_SCOPE;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:326:5: ( LOCK_SCOPE THREAD | LOCK_SCOPE PROCESS )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LOCK_SCOPE) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==THREAD) ) {
                    alt32=1;
                }
                else if ( (LA32_1==PROCESS) ) {
                    alt32=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:326:7: LOCK_SCOPE THREAD
                    {
                    match(input,LOCK_SCOPE,FOLLOW_LOCK_SCOPE_in_space_lock_scope2012);
                    THREAD46=(Token)match(input,THREAD,FOLLOW_THREAD_in_space_lock_scope2014);
                     retval.value = (THREAD46!=null?THREAD46.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:327:7: LOCK_SCOPE PROCESS
                    {
                    match(input,LOCK_SCOPE,FOLLOW_LOCK_SCOPE_in_space_lock_scope2024);
                    PROCESS47=(Token)match(input,PROCESS,FOLLOW_PROCESS_in_space_lock_scope2026);
                     retval.value = (PROCESS47!=null?PROCESS47.getText():null).toLowerCase();

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:330:1: space_lock_ttl returns [String key, String value] : LOCK_TTL ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_lock_ttl_return space_lock_ttl() throws RecognitionException {
        ASSQLParser.space_lock_ttl_return retval = new ASSQLParser.space_lock_ttl_return();
        retval.start = input.LT(1);

        Token NegativeNumber48=null;
        Token PositiveNumber49=null;

         retval.key = CreateStatement.LOCK_TTL;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:332:5: ( LOCK_TTL ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:332:7: LOCK_TTL ( NegativeNumber | PositiveNumber )
            {
            match(input,LOCK_TTL,FOLLOW_LOCK_TTL_in_space_lock_ttl2058);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:332:16: ( NegativeNumber | PositiveNumber )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==NegativeNumber) ) {
                alt33=1;
            }
            else if ( (LA33_0==PositiveNumber) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:332:18: NegativeNumber
                    {
                    NegativeNumber48=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_lock_ttl2062);
                     retval.value = (NegativeNumber48!=null?NegativeNumber48.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:332:70: PositiveNumber
                    {
                    PositiveNumber49=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_lock_ttl2068);
                     retval.value = (PositiveNumber49!=null?PositiveNumber49.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:335:1: space_lock_wait returns [String key, String value] : LOCK_WAIT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_lock_wait_return space_lock_wait() throws RecognitionException {
        ASSQLParser.space_lock_wait_return retval = new ASSQLParser.space_lock_wait_return();
        retval.start = input.LT(1);

        Token NegativeNumber50=null;
        Token PositiveNumber51=null;

         retval.key = CreateStatement.LOCK_WAIT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:337:5: ( LOCK_WAIT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:337:7: LOCK_WAIT ( NegativeNumber | PositiveNumber )
            {
            match(input,LOCK_WAIT,FOLLOW_LOCK_WAIT_in_space_lock_wait2102);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:337:17: ( NegativeNumber | PositiveNumber )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==NegativeNumber) ) {
                alt34=1;
            }
            else if ( (LA34_0==PositiveNumber) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:337:19: NegativeNumber
                    {
                    NegativeNumber50=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_lock_wait2106);
                     retval.value = (NegativeNumber50!=null?NegativeNumber50.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:337:71: PositiveNumber
                    {
                    PositiveNumber51=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_lock_wait2112);
                     retval.value = (PositiveNumber51!=null?PositiveNumber51.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:340:1: space_min_seeders returns [String key, String value] : MIN_SEEDERS PositiveNumber ;
    public final ASSQLParser.space_min_seeders_return space_min_seeders() throws RecognitionException {
        ASSQLParser.space_min_seeders_return retval = new ASSQLParser.space_min_seeders_return();
        retval.start = input.LT(1);

        Token PositiveNumber52=null;

         retval.key = CreateStatement.MIN_SEEDERS;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:342:5: ( MIN_SEEDERS PositiveNumber )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:342:7: MIN_SEEDERS PositiveNumber
            {
            match(input,MIN_SEEDERS,FOLLOW_MIN_SEEDERS_in_space_min_seeders2147);
            PositiveNumber52=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_min_seeders2149);
             retval.value = (PositiveNumber52!=null?PositiveNumber52.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:345:1: space_persistence_policy returns [String key, String value] : ( PERSISTENCE_POLICY SYNC | PERSISTENCE_POLICY ASYNC );
    public final ASSQLParser.space_persistence_policy_return space_persistence_policy() throws RecognitionException {
        ASSQLParser.space_persistence_policy_return retval = new ASSQLParser.space_persistence_policy_return();
        retval.start = input.LT(1);

        Token SYNC53=null;
        Token ASYNC54=null;

         retval.key = CreateStatement.PERSISTENCE_POLICY;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:347:5: ( PERSISTENCE_POLICY SYNC | PERSISTENCE_POLICY ASYNC )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==PERSISTENCE_POLICY) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==SYNC) ) {
                    alt35=1;
                }
                else if ( (LA35_1==ASYNC) ) {
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:347:7: PERSISTENCE_POLICY SYNC
                    {
                    match(input,PERSISTENCE_POLICY,FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2185);
                    SYNC53=(Token)match(input,SYNC,FOLLOW_SYNC_in_space_persistence_policy2187);
                     retval.value = (SYNC53!=null?SYNC53.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:348:7: PERSISTENCE_POLICY ASYNC
                    {
                    match(input,PERSISTENCE_POLICY,FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2197);
                    ASYNC54=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_space_persistence_policy2199);
                     retval.value = (ASYNC54!=null?ASYNC54.getText():null).toLowerCase();

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:351:1: space_persistence_type returns [String key, String value] : ( PERSISTENCE a= NONE | PERSISTENCE b= ( SHARED_ALL ) | PERSISTENCE c= ( SHARED_NOTHING ) | PERSISTENCE_TYPE d= NONE | PERSISTENCE_TYPE e= ( SHARED_ALL ) | PERSISTENCE_TYPE f= ( SHARED_NOTHING ) );
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
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:353:5: ( PERSISTENCE a= NONE | PERSISTENCE b= ( SHARED_ALL ) | PERSISTENCE c= ( SHARED_NOTHING ) | PERSISTENCE_TYPE d= NONE | PERSISTENCE_TYPE e= ( SHARED_ALL ) | PERSISTENCE_TYPE f= ( SHARED_NOTHING ) )
            int alt36=6;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==PERSISTENCE) ) {
                switch ( input.LA(2) ) {
                case NONE:
                    {
                    alt36=1;
                    }
                    break;
                case SHARED_ALL:
                    {
                    alt36=2;
                    }
                    break;
                case SHARED_NOTHING:
                    {
                    alt36=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA36_0==PERSISTENCE_TYPE) ) {
                switch ( input.LA(2) ) {
                case NONE:
                    {
                    alt36=4;
                    }
                    break;
                case SHARED_NOTHING:
                    {
                    alt36=6;
                    }
                    break;
                case SHARED_ALL:
                    {
                    alt36=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:353:7: PERSISTENCE a= NONE
                    {
                    match(input,PERSISTENCE,FOLLOW_PERSISTENCE_in_space_persistence_type2233);
                    a=(Token)match(input,NONE,FOLLOW_NONE_in_space_persistence_type2237);
                     retval.value = (a!=null?a.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:354:7: PERSISTENCE b= ( SHARED_ALL )
                    {
                    match(input,PERSISTENCE,FOLLOW_PERSISTENCE_in_space_persistence_type2247);
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:354:21: ( SHARED_ALL )
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:354:22: SHARED_ALL
                    {
                    match(input,SHARED_ALL,FOLLOW_SHARED_ALL_in_space_persistence_type2252);

                    }

                     retval.value = (b!=null?b.getText():null).toLowerCase();

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:355:7: PERSISTENCE c= ( SHARED_NOTHING )
                    {
                    match(input,PERSISTENCE,FOLLOW_PERSISTENCE_in_space_persistence_type2263);
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:355:21: ( SHARED_NOTHING )
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:355:22: SHARED_NOTHING
                    {
                    match(input,SHARED_NOTHING,FOLLOW_SHARED_NOTHING_in_space_persistence_type2268);

                    }

                     retval.value = (c!=null?c.getText():null).toLowerCase();

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:356:7: PERSISTENCE_TYPE d= NONE
                    {
                    match(input,PERSISTENCE_TYPE,FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2279);
                    d=(Token)match(input,NONE,FOLLOW_NONE_in_space_persistence_type2283);
                     retval.value = (d!=null?d.getText():null).toLowerCase();

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:357:7: PERSISTENCE_TYPE e= ( SHARED_ALL )
                    {
                    match(input,PERSISTENCE_TYPE,FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2293);
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:357:26: ( SHARED_ALL )
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:357:27: SHARED_ALL
                    {
                    match(input,SHARED_ALL,FOLLOW_SHARED_ALL_in_space_persistence_type2298);

                    }

                     retval.value = (e!=null?e.getText():null).toLowerCase();

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:358:7: PERSISTENCE_TYPE f= ( SHARED_NOTHING )
                    {
                    match(input,PERSISTENCE_TYPE,FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2309);
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:358:26: ( SHARED_NOTHING )
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:358:27: SHARED_NOTHING
                    {
                    match(input,SHARED_NOTHING,FOLLOW_SHARED_NOTHING_in_space_persistence_type2314);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:362:1: space_phase_count returns [String key, String value] : PHASE_COUNT ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_phase_count_return space_phase_count() throws RecognitionException {
        ASSQLParser.space_phase_count_return retval = new ASSQLParser.space_phase_count_return();
        retval.start = input.LT(1);

        Token NegativeNumber55=null;
        Token PositiveNumber56=null;

         retval.key = CreateStatement.PHASE_COUNT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:364:5: ( PHASE_COUNT ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:364:7: PHASE_COUNT ( NegativeNumber | PositiveNumber )
            {
            match(input,PHASE_COUNT,FOLLOW_PHASE_COUNT_in_space_phase_count2348);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:364:19: ( NegativeNumber | PositiveNumber )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==NegativeNumber) ) {
                alt37=1;
            }
            else if ( (LA37_0==PositiveNumber) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:364:21: NegativeNumber
                    {
                    NegativeNumber55=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_phase_count2352);
                     retval.value = (NegativeNumber55!=null?NegativeNumber55.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:364:73: PositiveNumber
                    {
                    PositiveNumber56=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_phase_count2358);
                     retval.value = (PositiveNumber56!=null?PositiveNumber56.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:367:1: space_phase_interval returns [String key, String value] : PHASE_INTERVAL PositiveNumber ;
    public final ASSQLParser.space_phase_interval_return space_phase_interval() throws RecognitionException {
        ASSQLParser.space_phase_interval_return retval = new ASSQLParser.space_phase_interval_return();
        retval.start = input.LT(1);

        Token PositiveNumber57=null;

         retval.key = CreateStatement.PHASE_INTERVAL;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:369:5: ( PHASE_INTERVAL PositiveNumber )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:369:7: PHASE_INTERVAL PositiveNumber
            {
            match(input,PHASE_INTERVAL,FOLLOW_PHASE_INTERVAL_in_space_phase_interval2392);
            PositiveNumber57=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_phase_interval2394);
             retval.value = (PositiveNumber57!=null?PositiveNumber57.getText():null);

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

    public static class space_read_timeout_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_read_timeout"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:372:1: space_read_timeout returns [String key, String value] : READ_TIMEOUT PositiveNumber ;
    public final ASSQLParser.space_read_timeout_return space_read_timeout() throws RecognitionException {
        ASSQLParser.space_read_timeout_return retval = new ASSQLParser.space_read_timeout_return();
        retval.start = input.LT(1);

        Token PositiveNumber58=null;

         retval.key = CreateStatement.READ_TIMEOUT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:374:5: ( READ_TIMEOUT PositiveNumber )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:374:7: READ_TIMEOUT PositiveNumber
            {
            match(input,READ_TIMEOUT,FOLLOW_READ_TIMEOUT_in_space_read_timeout2426);
            PositiveNumber58=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_read_timeout2428);
             retval.value = (PositiveNumber58!=null?PositiveNumber58.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:377:1: space_replication_count returns [String key, String value] : REPLICATION_COUNT PositiveNumber ;
    public final ASSQLParser.space_replication_count_return space_replication_count() throws RecognitionException {
        ASSQLParser.space_replication_count_return retval = new ASSQLParser.space_replication_count_return();
        retval.start = input.LT(1);

        Token PositiveNumber59=null;

         retval.key = CreateStatement.REPLICATION_COUNT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:379:5: ( REPLICATION_COUNT PositiveNumber )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:379:7: REPLICATION_COUNT PositiveNumber
            {
            match(input,REPLICATION_COUNT,FOLLOW_REPLICATION_COUNT_in_space_replication_count2460);
            PositiveNumber59=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_replication_count2462);
             retval.value = (PositiveNumber59!=null?PositiveNumber59.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:382:1: space_replication_policy returns [String key, String value] : ( REPLICATION_POLICY SYNC | REPLICATION_POLICY ASYNC );
    public final ASSQLParser.space_replication_policy_return space_replication_policy() throws RecognitionException {
        ASSQLParser.space_replication_policy_return retval = new ASSQLParser.space_replication_policy_return();
        retval.start = input.LT(1);

        Token SYNC60=null;
        Token ASYNC61=null;

         retval.key = CreateStatement.REPLICATION_POLICY;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:384:5: ( REPLICATION_POLICY SYNC | REPLICATION_POLICY ASYNC )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==REPLICATION_POLICY) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==SYNC) ) {
                    alt38=1;
                }
                else if ( (LA38_1==ASYNC) ) {
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
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:384:7: REPLICATION_POLICY SYNC
                    {
                    match(input,REPLICATION_POLICY,FOLLOW_REPLICATION_POLICY_in_space_replication_policy2494);
                    SYNC60=(Token)match(input,SYNC,FOLLOW_SYNC_in_space_replication_policy2496);
                     retval.value = (SYNC60!=null?SYNC60.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:385:7: REPLICATION_POLICY ASYNC
                    {
                    match(input,REPLICATION_POLICY,FOLLOW_REPLICATION_POLICY_in_space_replication_policy2506);
                    ASYNC61=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_space_replication_policy2508);
                     retval.value = (ASYNC61!=null?ASYNC61.getText():null).toLowerCase();

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

    public static class space_ttl_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_ttl"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:388:1: space_ttl returns [String key, String value] : TTL ( NegativeNumber | PositiveNumber ) ;
    public final ASSQLParser.space_ttl_return space_ttl() throws RecognitionException {
        ASSQLParser.space_ttl_return retval = new ASSQLParser.space_ttl_return();
        retval.start = input.LT(1);

        Token NegativeNumber62=null;
        Token PositiveNumber63=null;

         retval.key = CreateStatement.TTL;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:390:5: ( TTL ( NegativeNumber | PositiveNumber ) )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:390:7: TTL ( NegativeNumber | PositiveNumber )
            {
            match(input,TTL,FOLLOW_TTL_in_space_ttl2540);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:390:11: ( NegativeNumber | PositiveNumber )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==NegativeNumber) ) {
                alt39=1;
            }
            else if ( (LA39_0==PositiveNumber) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:390:13: NegativeNumber
                    {
                    NegativeNumber62=(Token)match(input,NegativeNumber,FOLLOW_NegativeNumber_in_space_ttl2544);
                     retval.value = (NegativeNumber62!=null?NegativeNumber62.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:390:65: PositiveNumber
                    {
                    PositiveNumber63=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_ttl2550);
                     retval.value = (PositiveNumber63!=null?PositiveNumber63.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:393:1: space_update_transport returns [String key, String value] : ( UPDATE_TRANSPORT UNICAST | UPDATE_TRANSPORT MULTICAST );
    public final ASSQLParser.space_update_transport_return space_update_transport() throws RecognitionException {
        ASSQLParser.space_update_transport_return retval = new ASSQLParser.space_update_transport_return();
        retval.start = input.LT(1);

        Token UNICAST64=null;
        Token MULTICAST65=null;

         retval.key = CreateStatement.UPDATE_TRANSPORT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:395:5: ( UPDATE_TRANSPORT UNICAST | UPDATE_TRANSPORT MULTICAST )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==UPDATE_TRANSPORT) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==UNICAST) ) {
                    alt40=1;
                }
                else if ( (LA40_1==MULTICAST) ) {
                    alt40=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:395:7: UPDATE_TRANSPORT UNICAST
                    {
                    match(input,UPDATE_TRANSPORT,FOLLOW_UPDATE_TRANSPORT_in_space_update_transport2584);
                    UNICAST64=(Token)match(input,UNICAST,FOLLOW_UNICAST_in_space_update_transport2586);
                     retval.value = (UNICAST64!=null?UNICAST64.getText():null).toLowerCase();

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:396:7: UPDATE_TRANSPORT MULTICAST
                    {
                    match(input,UPDATE_TRANSPORT,FOLLOW_UPDATE_TRANSPORT_in_space_update_transport2596);
                    MULTICAST65=(Token)match(input,MULTICAST,FOLLOW_MULTICAST_in_space_update_transport2598);
                     retval.value = (MULTICAST65!=null?MULTICAST65.getText():null).toLowerCase();

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

    public static class space_wait_return extends ParserRuleReturnScope {
        public String key;
        public String value;
    };

    // $ANTLR start "space_wait"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:399:1: space_wait returns [String key, String value] : SPACE_WAIT PositiveNumber ;
    public final ASSQLParser.space_wait_return space_wait() throws RecognitionException {
        ASSQLParser.space_wait_return retval = new ASSQLParser.space_wait_return();
        retval.start = input.LT(1);

        Token PositiveNumber66=null;

         retval.key = CreateStatement.SPACE_WAIT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:401:5: ( SPACE_WAIT PositiveNumber )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:401:7: SPACE_WAIT PositiveNumber
            {
            match(input,SPACE_WAIT,FOLLOW_SPACE_WAIT_in_space_wait2630);
            PositiveNumber66=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_wait2632);
             retval.value = (PositiveNumber66!=null?PositiveNumber66.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:404:1: space_write_timeout returns [String key, String value] : WRITE_TIMEOUT PositiveNumber ;
    public final ASSQLParser.space_write_timeout_return space_write_timeout() throws RecognitionException {
        ASSQLParser.space_write_timeout_return retval = new ASSQLParser.space_write_timeout_return();
        retval.start = input.LT(1);

        Token PositiveNumber67=null;

         retval.key = CreateStatement.WRITE_TIMEOUT;
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:406:5: ( WRITE_TIMEOUT PositiveNumber )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:406:7: WRITE_TIMEOUT PositiveNumber
            {
            match(input,WRITE_TIMEOUT,FOLLOW_WRITE_TIMEOUT_in_space_write_timeout2664);
            PositiveNumber67=(Token)match(input,PositiveNumber,FOLLOW_PositiveNumber_in_space_write_timeout2666);
             retval.value = (PositiveNumber67!=null?PositiveNumber67.getText():null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:409:1: table_constraint : PRIMARY_KEY ( key_type )? OParen a= column_name ( Comma b= column_name )* CParen ;
    public final void table_constraint() throws RecognitionException {
        ASSQLParser.column_name_return a = null;

        ASSQLParser.column_name_return b = null;

        ASSQLParser.key_type_return key_type68 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:410:5: ( PRIMARY_KEY ( key_type )? OParen a= column_name ( Comma b= column_name )* CParen )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:410:7: PRIMARY_KEY ( key_type )? OParen a= column_name ( Comma b= column_name )* CParen
            {
            match(input,PRIMARY_KEY,FOLLOW_PRIMARY_KEY_in_table_constraint2689);
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:410:19: ( key_type )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=HASH && LA41_0<=TREE)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:410:20: key_type
                    {
                    pushFollow(FOLLOW_key_type_in_table_constraint2692);
                    key_type68=key_type();

                    state._fsp--;

                    pkeyType = (key_type68!=null?input.toString(key_type68.start,key_type68.stop):null);

                    }
                    break;

            }

            match(input,OParen,FOLLOW_OParen_in_table_constraint2705);
            pushFollow(FOLLOW_column_name_in_table_constraint2709);
            a=column_name();

            state._fsp--;

             pkeyList.add((a!=null?input.toString(a.start,a.stop):null));
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:412:7: ( Comma b= column_name )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:412:9: Comma b= column_name
                    {
                    match(input,Comma,FOLLOW_Comma_in_table_constraint2722);
                    pushFollow(FOLLOW_column_name_in_table_constraint2726);
                    b=column_name();

                    state._fsp--;

                     pkeyList.add((b!=null?input.toString(b.start,b.stop):null));

                    }
                    break;

                default :
                    break loop42;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_table_constraint2733);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:415:1: table_constraint_def : ( CONSTRAINT Identifier )? table_constraint ;
    public final void table_constraint_def() throws RecognitionException {
        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:416:5: ( ( CONSTRAINT Identifier )? table_constraint )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:416:7: ( CONSTRAINT Identifier )? table_constraint
            {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:416:7: ( CONSTRAINT Identifier )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==CONSTRAINT) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:416:8: CONSTRAINT Identifier
                    {
                    match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_table_constraint_def2751);
                    match(input,Identifier,FOLLOW_Identifier_in_table_constraint_def2753);

                    }
                    break;

            }

            pushFollow(FOLLOW_table_constraint_in_table_constraint_def2757);
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:419:1: table_element : ( column_def | table_constraint_def | table_index );
    public final void table_element() throws RecognitionException {
        ASSQLIndex table_index69 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:420:5: ( column_def | table_constraint_def | table_index )
            int alt44=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt44=1;
                }
                break;
            case PRIMARY_KEY:
            case CONSTRAINT:
                {
                alt44=2;
                }
                break;
            case INDEX:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:420:7: column_def
                    {
                    pushFollow(FOLLOW_column_def_in_table_element2774);
                    column_def();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:421:7: table_constraint_def
                    {
                    pushFollow(FOLLOW_table_constraint_def_in_table_element2782);
                    table_constraint_def();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:422:7: table_index
                    {
                    pushFollow(FOLLOW_table_index_in_table_element2790);
                    table_index69=table_index();

                    state._fsp--;

                     indexList.add(table_index69);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:425:1: table_index returns [ASSQLIndex index] : INDEX table_index_name ( key_type )? table_index_list ;
    public final ASSQLIndex table_index() throws RecognitionException {
        ASSQLIndex index = null;

        ASSQLParser.key_type_return key_type70 = null;

        ASSQLParser.table_index_name_return table_index_name71 = null;

        ArrayList<String> table_index_list72 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:426:5: ( INDEX table_index_name ( key_type )? table_index_list )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:426:7: INDEX table_index_name ( key_type )? table_index_list
            {

                      String type = null;

            match(input,INDEX,FOLLOW_INDEX_in_table_index2821);
            pushFollow(FOLLOW_table_index_name_in_table_index2823);
            table_index_name71=table_index_name();

            state._fsp--;

            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:30: ( key_type )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=HASH && LA45_0<=TREE)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:429:31: key_type
                    {
                    pushFollow(FOLLOW_key_type_in_table_index2826);
                    key_type70=key_type();

                    state._fsp--;

                    type = (key_type70!=null?input.toString(key_type70.start,key_type70.stop):null);

                    }
                    break;

            }

            pushFollow(FOLLOW_table_index_list_in_table_index2832);
            table_index_list72=table_index_list();

            state._fsp--;


                      return new ASSQLIndex((table_index_name71!=null?input.toString(table_index_name71.start,table_index_name71.stop):null), type, table_index_list72);


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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:435:1: table_index_list returns [ArrayList<String> indexColumns] : OParen a= column_name ( Comma b= column_name )* CParen ;
    public final ArrayList<String> table_index_list() throws RecognitionException {
        ArrayList<String> indexColumns = null;

        ASSQLParser.column_name_return a = null;

        ASSQLParser.column_name_return b = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:436:5: ( OParen a= column_name ( Comma b= column_name )* CParen )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:436:7: OParen a= column_name ( Comma b= column_name )* CParen
            {

                      indexColumns = new ArrayList<String>();

            match(input,OParen,FOLLOW_OParen_in_table_index_list2869);
            pushFollow(FOLLOW_column_name_in_table_index_list2873);
            a=column_name();

            state._fsp--;

             indexColumns.add((a!=null?input.toString(a.start,a.stop):null));
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:439:60: ( Comma b= column_name )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==Comma) ) {
                    alt46=1;
                }


                switch (alt46) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:439:61: Comma b= column_name
                    {
                    match(input,Comma,FOLLOW_Comma_in_table_index_list2878);
                    pushFollow(FOLLOW_column_name_in_table_index_list2882);
                    b=column_name();

                    state._fsp--;

                     indexColumns.add((b!=null?input.toString(b.start,b.stop):null));

                    }
                    break;

                default :
                    break loop46;
                }
            } while (true);

            match(input,CParen,FOLLOW_CParen_in_table_index_list2888);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:442:1: table_index_name : Identifier ;
    public final ASSQLParser.table_index_name_return table_index_name() throws RecognitionException {
        ASSQLParser.table_index_name_return retval = new ASSQLParser.table_index_name_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:443:5: ( Identifier )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:443:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_table_index_name2906);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:446:1: table_name : Identifier ;
    public final ASSQLParser.table_name_return table_name() throws RecognitionException {
        ASSQLParser.table_name_return retval = new ASSQLParser.table_name_return();
        retval.start = input.LT(1);

        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:447:5: ( Identifier )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:447:7: Identifier
            {
            match(input,Identifier,FOLLOW_Identifier_in_table_name2923);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:450:1: table_reference_list returns [List<String> tableNames] : a= table_name ( Comma b= table_name )* ;
    public final List<String> table_reference_list() throws RecognitionException {
        List<String> tableNames = null;

        ASSQLParser.table_name_return a = null;

        ASSQLParser.table_name_return b = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:451:5: (a= table_name ( Comma b= table_name )* )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:451:7: a= table_name ( Comma b= table_name )*
            {

                      tableNames = new ArrayList<String>();

            pushFollow(FOLLOW_table_name_in_table_reference_list2954);
            a=table_name();

            state._fsp--;

            tableNames.add((a!=null?input.toString(a.start,a.stop):null));
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:454:46: ( Comma b= table_name )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==Comma) ) {
                    alt47=1;
                }


                switch (alt47) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:454:48: Comma b= table_name
                    {
                    match(input,Comma,FOLLOW_Comma_in_table_reference_list2959);
                    pushFollow(FOLLOW_table_name_in_table_reference_list2963);
                    b=table_name();

                    state._fsp--;

                    tableNames.add((b!=null?input.toString(b.start,b.stop):null));

                    }
                    break;

                default :
                    break loop47;
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
        return tableNames;
    }
    // $ANTLR end "table_reference_list"


    // $ANTLR start "target_table"
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:457:1: target_table returns [String arg] : ( table_name | ONLY OParen table_name CParen );
    public final String target_table() throws RecognitionException {
        String arg = null;

        ASSQLParser.table_name_return table_name73 = null;

        ASSQLParser.table_name_return table_name74 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:458:5: ( table_name | ONLY OParen table_name CParen )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Identifier) ) {
                alt48=1;
            }
            else if ( (LA48_0==ONLY) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:458:7: table_name
                    {
                    pushFollow(FOLLOW_table_name_in_target_table2988);
                    table_name73=table_name();

                    state._fsp--;

                     arg = (table_name73!=null?input.toString(table_name73.start,table_name73.stop):null);

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:459:7: ONLY OParen table_name CParen
                    {
                    match(input,ONLY,FOLLOW_ONLY_in_target_table2998);
                    match(input,OParen,FOLLOW_OParen_in_target_table3000);
                    pushFollow(FOLLOW_table_name_in_target_table3002);
                    table_name74=table_name();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_target_table3004);
                     arg = (table_name74!=null?input.toString(table_name74.start,table_name74.stop):null);

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:462:1: where_condition returns [String arg] : (a= where_relation | b= where_relation_group | c= where_relation AND d= where_relation_group | e= where_relation OR f= where_relation_group | g= where_relation_group OR h= where_relation_group | i= where_relation_group AND j= where_relation_group | rterm IN OParen rterm_list CParen );
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

        ASSQLParser.rterm_return rterm75 = null;

        ASSQLParser.rterm_list_return rterm_list76 = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:463:5: (a= where_relation | b= where_relation_group | c= where_relation AND d= where_relation_group | e= where_relation OR f= where_relation_group | g= where_relation_group OR h= where_relation_group | i= where_relation_group AND j= where_relation_group | rterm IN OParen rterm_list CParen )
            int alt49=7;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:463:7: a= where_relation
                    {
                    pushFollow(FOLLOW_where_relation_in_where_condition3029);
                    a=where_relation();

                    state._fsp--;

                    arg = a;

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:464:7: b= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3047);
                    b=where_relation_group();

                    state._fsp--;

                    arg = b;

                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:465:7: c= where_relation AND d= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_in_where_condition3059);
                    c=where_relation();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_where_condition3061);
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3065);
                    d=where_relation_group();

                    state._fsp--;

                    arg = c + " AND " + d;

                    }
                    break;
                case 4 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:466:7: e= where_relation OR f= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_in_where_condition3077);
                    e=where_relation();

                    state._fsp--;

                    match(input,OR,FOLLOW_OR_in_where_condition3079);
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3083);
                    f=where_relation_group();

                    state._fsp--;

                    arg = e + " OR " + f;

                    }
                    break;
                case 5 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:467:7: g= where_relation_group OR h= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3095);
                    g=where_relation_group();

                    state._fsp--;

                    match(input,OR,FOLLOW_OR_in_where_condition3097);
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3101);
                    h=where_relation_group();

                    state._fsp--;

                    arg = g + " OR " + h;

                    }
                    break;
                case 6 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:468:7: i= where_relation_group AND j= where_relation_group
                    {
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3113);
                    i=where_relation_group();

                    state._fsp--;

                    match(input,AND,FOLLOW_AND_in_where_condition3115);
                    pushFollow(FOLLOW_where_relation_group_in_where_condition3119);
                    j=where_relation_group();

                    state._fsp--;

                    arg = i + " AND " + j;

                    }
                    break;
                case 7 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:469:7: rterm IN OParen rterm_list CParen
                    {
                    pushFollow(FOLLOW_rterm_in_where_condition3129);
                    rterm75=rterm();

                    state._fsp--;

                    match(input,IN,FOLLOW_IN_in_where_condition3131);
                    match(input,OParen,FOLLOW_OParen_in_where_condition3133);
                    pushFollow(FOLLOW_rterm_list_in_where_condition3135);
                    rterm_list76=rterm_list();

                    state._fsp--;

                    match(input,CParen,FOLLOW_CParen_in_where_condition3137);
                     arg = (rterm75!=null?input.toString(rterm75.start,rterm75.stop):null) + " IN (" + (rterm_list76!=null?input.toString(rterm_list76.start,rterm_list76.stop):null) + ")";

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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:472:1: where_relation returns [String arg] : (a= relation | b= relation ( AND c= relation )+ | d= relation ( OR e= relation )+ );
    public final String where_relation() throws RecognitionException {
        String arg = null;

        String a = null;

        String b = null;

        String c = null;

        String d = null;

        String e = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:473:5: (a= relation | b= relation ( AND c= relation )+ | d= relation ( OR e= relation )+ )
            int alt52=3;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:473:7: a= relation
                    {
                    pushFollow(FOLLOW_relation_in_where_relation3162);
                    a=relation();

                    state._fsp--;

                    arg = a;

                    }
                    break;
                case 2 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:474:7: b= relation ( AND c= relation )+
                    {
                    pushFollow(FOLLOW_relation_in_where_relation3174);
                    b=relation();

                    state._fsp--;

                    arg = b;
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:474:35: ( AND c= relation )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==AND) ) {
                            int LA50_2 = input.LA(2);

                            if ( (LA50_2==Identifier||LA50_2==PositiveNumber||(LA50_2>=QuotedString && LA50_2<=NULL)||LA50_2==QMark) ) {
                                alt50=1;
                            }


                        }


                        switch (alt50) {
                        case 1 :
                            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:474:36: AND c= relation
                            {
                            match(input,AND,FOLLOW_AND_in_where_relation3179);
                            pushFollow(FOLLOW_relation_in_where_relation3183);
                            c=relation();

                            state._fsp--;

                            arg += " AND " + c;

                            }
                            break;

                        default :
                            if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:475:7: d= relation ( OR e= relation )+
                    {
                    pushFollow(FOLLOW_relation_in_where_relation3197);
                    d=relation();

                    state._fsp--;

                    arg = d;
                    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:475:35: ( OR e= relation )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==OR) ) {
                            int LA51_2 = input.LA(2);

                            if ( (LA51_2==Identifier||LA51_2==PositiveNumber||(LA51_2>=QuotedString && LA51_2<=NULL)||LA51_2==QMark) ) {
                                alt51=1;
                            }


                        }


                        switch (alt51) {
                        case 1 :
                            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:475:36: OR e= relation
                            {
                            match(input,OR,FOLLOW_OR_in_where_relation3202);
                            pushFollow(FOLLOW_relation_in_where_relation3206);
                            e=relation();

                            state._fsp--;

                            arg += " OR " + e;

                            }
                            break;

                        default :
                            if ( cnt51 >= 1 ) break loop51;
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
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
    // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:478:1: where_relation_group returns [String arg] : OParen a= where_relation CParen ;
    public final String where_relation_group() throws RecognitionException {
        String arg = null;

        String a = null;


        try {
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:479:5: ( OParen a= where_relation CParen )
            // C:\\src\\SVN\\as2.0.2_jdbc\\redist\\examples\\src\\java\\JDBCDriver\\src\\com\\tibco\\as\\sql\\grammar\\ASSQL.g:479:7: OParen a= where_relation CParen
            {
            match(input,OParen,FOLLOW_OParen_in_where_relation_group3236);
            pushFollow(FOLLOW_where_relation_in_where_relation_group3240);
            a=where_relation();

            state._fsp--;

            match(input,CParen,FOLLOW_CParen_in_where_relation_group3242);
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

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA52 dfa52 = new DFA52(this);
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
            return "187:1: column_type returns [String type] : ( BIT | CHAR | CHAR1 | CHAR OParen PositiveNumber CParen | VARCHAR | VARCHAR OParen PositiveNumber CParen | LONGVARCHAR | LONGVARCHAR OParen PositiveNumber CParen | SMALLINT | INTEGER | BIGINT | REAL | DOUBLE | BLOB | DATETIME | DATE | TIME | TIMESTAMP );";
        }
    }
    static final String DFA49_eotS =
        "\134\uffff";
    static final String DFA49_eofS =
        "\5\uffff\2\17\11\uffff\4\17\15\uffff\1\63\6\uffff\2\17\2\uffff"+
        "\2\17\2\uffff\1\17\12\uffff\10\17\23\uffff\2\17\4\uffff";
    static final String DFA49_minS =
        "\1\6\3\56\1\23\2\20\1\31\1\23\1\uffff\3\56\2\6\1\uffff\4\20\2\10"+
        "\1\31\1\23\3\56\2\uffff\3\56\1\31\1\20\2\23\4\10\2\20\1\31\1\23"+
        "\2\20\1\31\1\23\1\20\3\uffff\6\56\1\31\10\20\2\10\1\31\1\23\2\10"+
        "\1\31\1\23\1\10\2\31\10\10\2\20\2\31\2\10";
    static final String DFA49_maxS =
        "\1\70\3\142\1\70\2\141\1\51\1\70\1\uffff\1\66\2\63\2\70\1\uffff"+
        "\6\141\1\51\1\70\1\66\2\63\2\uffff\1\66\2\63\1\51\1\141\2\70\6\141"+
        "\1\51\1\70\2\141\1\51\1\70\1\141\3\uffff\1\66\2\63\1\66\2\63\1\51"+
        "\12\141\1\51\1\70\2\140\1\51\1\70\1\141\2\51\4\141\4\140\2\141\2"+
        "\51\1\141\1\140";
    static final String DFA49_acceptS =
        "\11\uffff\1\7\5\uffff\1\1\13\uffff\1\3\1\4\24\uffff\1\6\1\5\1\2"+
        "\50\uffff";
    static final String DFA49_specialS =
        "\134\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\4\14\uffff\1\1\5\uffff\1\3\14\uffff\4\3\16\uffff\1\2",
            "\6\10\1\5\1\6\1\7\53\uffff\1\11",
            "\6\10\56\uffff\1\11",
            "\6\10\56\uffff\1\11",
            "\1\12\5\uffff\1\14\14\uffff\4\14\16\uffff\1\13",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\16",
            "\1\20\14\uffff\4\20",
            "\1\21\5\uffff\1\23\14\uffff\4\23\16\uffff\1\22",
            "",
            "\6\27\1\24\1\25\1\26",
            "\6\27",
            "\6\27",
            "\1\33\14\uffff\1\30\5\uffff\1\32\14\uffff\4\32\16\uffff\1"+
            "\31",
            "\1\34\14\uffff\1\35\5\uffff\1\37\14\uffff\4\37\16\uffff\1"+
            "\36",
            "",
            "\1\17\31\uffff\1\17\14\uffff\1\40\50\uffff\1\15\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\16",
            "\1\41\127\uffff\1\43\1\42",
            "\1\41\127\uffff\1\43\1\42",
            "\1\44\14\uffff\4\44",
            "\1\45\5\uffff\1\47\14\uffff\4\47\16\uffff\1\46",
            "\6\53\1\50\1\51\1\52",
            "\6\53",
            "\6\53",
            "",
            "",
            "\6\57\1\54\1\55\1\56",
            "\6\57",
            "\6\57",
            "\1\60\14\uffff\4\60",
            "\1\63\31\uffff\1\63\65\uffff\1\61\1\62",
            "\1\64\5\uffff\1\66\14\uffff\4\66\16\uffff\1\65",
            "\1\67\5\uffff\1\71\14\uffff\4\71\16\uffff\1\70",
            "\1\41\56\uffff\1\72\50\uffff\1\43\1\42",
            "\1\41\127\uffff\1\43\1\42",
            "\1\41\127\uffff\1\43\1\42",
            "\1\41\127\uffff\1\43\1\42",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\34",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\34",
            "\1\73\14\uffff\4\73",
            "\1\74\5\uffff\1\76\14\uffff\4\76\16\uffff\1\75",
            "\1\17\31\uffff\1\17\65\uffff\1\33\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\33\1\16",
            "\1\77\14\uffff\4\77",
            "\1\100\5\uffff\1\102\14\uffff\4\102\16\uffff\1\101",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\16",
            "",
            "",
            "",
            "\6\106\1\103\1\104\1\105",
            "\6\106",
            "\6\106",
            "\6\112\1\107\1\110\1\111",
            "\6\112",
            "\6\112",
            "\1\113\14\uffff\4\113",
            "\1\17\31\uffff\1\17\14\uffff\1\114\50\uffff\1\15\1\34",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\34",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\34",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\34",
            "\1\17\31\uffff\1\17\14\uffff\1\115\50\uffff\1\33\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\33\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\33\1\16",
            "\1\17\31\uffff\1\17\65\uffff\1\33\1\16",
            "\1\41\130\uffff\1\42",
            "\1\41\130\uffff\1\42",
            "\1\116\14\uffff\4\116",
            "\1\117\5\uffff\1\121\14\uffff\4\121\16\uffff\1\120",
            "\1\41\127\uffff\1\43",
            "\1\41\127\uffff\1\43",
            "\1\122\14\uffff\4\122",
            "\1\123\5\uffff\1\125\14\uffff\4\125\16\uffff\1\124",
            "\1\41\127\uffff\1\43\1\42",
            "\1\126\14\uffff\4\126",
            "\1\127\14\uffff\4\127",
            "\1\41\56\uffff\1\130\51\uffff\1\42",
            "\1\41\130\uffff\1\42",
            "\1\41\130\uffff\1\42",
            "\1\41\130\uffff\1\42",
            "\1\41\56\uffff\1\131\50\uffff\1\43",
            "\1\41\127\uffff\1\43",
            "\1\41\127\uffff\1\43",
            "\1\41\127\uffff\1\43",
            "\1\17\31\uffff\1\17\65\uffff\1\15\1\34",
            "\1\17\31\uffff\1\17\65\uffff\1\33\1\16",
            "\1\132\14\uffff\4\132",
            "\1\133\14\uffff\4\133",
            "\1\41\130\uffff\1\42",
            "\1\41\127\uffff\1\43"
    };

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "462:1: where_condition returns [String arg] : (a= where_relation | b= where_relation_group | c= where_relation AND d= where_relation_group | e= where_relation OR f= where_relation_group | g= where_relation_group OR h= where_relation_group | i= where_relation_group AND j= where_relation_group | rterm IN OParen rterm_list CParen );";
        }
    }
    static final String DFA52_eotS =
        "\23\uffff";
    static final String DFA52_eofS =
        "\4\uffff\2\12\5\uffff\4\12\3\uffff\1\12";
    static final String DFA52_minS =
        "\1\23\3\56\2\10\1\31\1\23\2\6\1\uffff\4\10\2\uffff\1\31\1\10";
    static final String DFA52_maxS =
        "\1\70\1\66\2\63\2\141\1\51\3\70\1\uffff\4\141\2\uffff\1\51\1\141";
    static final String DFA52_acceptS =
        "\12\uffff\1\1\4\uffff\1\3\1\2\2\uffff";
    static final String DFA52_specialS =
        "\23\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\1\5\uffff\1\3\14\uffff\4\3\16\uffff\1\2",
            "\6\7\1\4\1\5\1\6",
            "\6\7",
            "\6\7",
            "\1\12\7\uffff\1\12\31\uffff\1\12\65\uffff\1\11\1\10",
            "\1\12\7\uffff\1\12\31\uffff\1\12\65\uffff\1\11\1\10",
            "\1\13\14\uffff\4\13",
            "\1\14\5\uffff\1\16\14\uffff\4\16\16\uffff\1\15",
            "\1\12\14\uffff\1\17\5\uffff\1\17\14\uffff\4\17\16\uffff\1"+
            "\17",
            "\1\12\14\uffff\1\20\5\uffff\1\20\14\uffff\4\20\16\uffff\1"+
            "\20",
            "",
            "\1\12\7\uffff\1\12\31\uffff\1\12\14\uffff\1\21\50\uffff\1"+
            "\11\1\10",
            "\1\12\7\uffff\1\12\31\uffff\1\12\65\uffff\1\11\1\10",
            "\1\12\7\uffff\1\12\31\uffff\1\12\65\uffff\1\11\1\10",
            "\1\12\7\uffff\1\12\31\uffff\1\12\65\uffff\1\11\1\10",
            "",
            "",
            "\1\22\14\uffff\4\22",
            "\1\12\7\uffff\1\12\31\uffff\1\12\65\uffff\1\11\1\10"
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "472:1: where_relation returns [String arg] : (a= relation | b= relation ( AND c= relation )+ | d= relation ( OR e= relation )+ );";
        }
    }


    public static final BitSet FOLLOW_createStatement_in_query62 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_query75 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_query88 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectStatement_in_query101 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_query114 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_endStmnt_in_query117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_createStatement148 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TABLE_in_createStatement150 = new BitSet(new long[]{0x0000000000080000L,0x0000000080000000L});
    public static final BitSet FOLLOW_target_table_in_createStatement152 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_createStatement160 = new BitSet(new long[]{0x0000000000280000L,0x0000000060000000L});
    public static final BitSet FOLLOW_table_element_in_createStatement162 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_createStatement165 = new BitSet(new long[]{0x0000000000280000L,0x0000000060000000L});
    public static final BitSet FOLLOW_table_element_in_createStatement167 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_createStatement171 = new BitSet(new long[]{0xC000000000000002L,0x0000000019FE4F24L});
    public static final BitSet FOLLOW_space_property_in_createStatement182 = new BitSet(new long[]{0xC000000000000082L,0x0000000019FE4F24L});
    public static final BitSet FOLLOW_Comma_in_createStatement187 = new BitSet(new long[]{0xC000000000000000L,0x0000000019FE4F24L});
    public static final BitSet FOLLOW_space_property_in_createStatement191 = new BitSet(new long[]{0xC000000000000082L,0x0000000019FE4F24L});
    public static final BitSet FOLLOW_DELETE_in_deleteStatement227 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FROM_in_deleteStatement229 = new BitSet(new long[]{0x0000000000080000L,0x0000000080000000L});
    public static final BitSet FOLLOW_target_table_in_deleteStatement231 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_WHERE_in_deleteStatement240 = new BitSet(new long[]{0x010003C002080040L});
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
    public static final BitSet FOLLOW_OParen_in_insertStatement324 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_column_value_in_insertStatement328 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_insertStatement334 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_column_value_in_insertStatement338 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_insertStatement345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_selectStatement374 = new BitSet(new long[]{0x3800000000080000L});
    public static final BitSet FOLLOW_select_quantifier_in_selectStatement377 = new BitSet(new long[]{0x3800000000080000L});
    public static final BitSet FOLLOW_select_list_in_selectStatement387 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FROM_in_selectStatement402 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_reference_list_in_selectStatement404 = new BitSet(new long[]{0x0000000000010802L});
    public static final BitSet FOLLOW_WHERE_in_selectStatement413 = new BitSet(new long[]{0x010003C002080040L});
    public static final BitSet FOLLOW_where_condition_in_selectStatement415 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_LIMIT_in_selectStatement426 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_limit_clause_in_selectStatement428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateStatement495 = new BitSet(new long[]{0x0000000000080000L,0x0000000080000000L});
    public static final BitSet FOLLOW_target_table_in_updateStatement497 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SET_in_updateStatement505 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_set_clause_in_updateStatement509 = new BitSet(new long[]{0x0000000000000882L});
    public static final BitSet FOLLOW_Comma_in_updateStatement523 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_set_clause_in_updateStatement527 = new BitSet(new long[]{0x0000000000000882L});
    public static final BitSet FOLLOW_WHERE_in_updateStatement541 = new BitSet(new long[]{0x010003C002080040L});
    public static final BitSet FOLLOW_where_condition_in_updateStatement543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_alias570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_name_in_column_def595 = new BitSet(new long[]{0x0000003FFDC00000L});
    public static final BitSet FOLLOW_column_type_in_column_def597 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_NOT_NULL_in_column_def615 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_PRIMARY_KEY_in_column_def627 = new BitSet(new long[]{0x0000180000300002L});
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
    public static final BitSet FOLLOW_SColon_in_endStmnt1034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_endStmnt1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_key_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1080 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_OFFSET_in_limit_clause1082 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1093 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Comma_in_limit_clause1095 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_limit_clause1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_in_relation1121 = new BitSet(new long[]{0x000FC00000000000L});
    public static final BitSet FOLLOW_set_in_relation1125 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_rterm_in_relation1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_null_in_relation1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_not_in_relation1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_relation_null1198 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_IS_NULL_in_relation_null1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_relation_null1210 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_IS_NOT_NULL_in_relation_null1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_relation_not1237 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_NOT_in_relation_not1239 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_column_value_in_relation_not1243 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_NOR_in_relation_not1248 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_column_value_in_relation_not1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_in_rterm_list1285 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_rterm_list1288 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_rterm_in_rterm_list1290 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Identifier_in_rterm1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMark_in_rterm1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_value_in_rterm1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_schema_name1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_select_column1372 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_Dot_in_select_column1374 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_select_column1381 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_AS_in_select_column1392 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_alias_in_select_column1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_column_in_select_column_list1417 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_select_column_list1428 = new BitSet(new long[]{0x3800000000080000L});
    public static final BitSet FOLLOW_select_column_in_select_column_list1432 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Asterisk_in_select_list1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_select_list1465 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_Dot_in_select_list1467 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Asterisk_in_select_list1471 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_select_list1482 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_select_list1486 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_Dot_in_select_list1488 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Asterisk_in_select_list1492 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_select_column_list_in_select_list1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_select_quantifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_name_in_set_clause1552 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_Equals_in_set_clause1554 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_column_value_in_set_clause1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_capacity_in_space_property1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_distribution_policy_in_space_property1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_eviction_policy_in_space_property1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_lock_scope_in_space_property1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_lock_ttl_in_space_property1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_lock_wait_in_space_property1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_min_seeders_in_space_property1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_persistence_policy_in_space_property1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_persistence_type_in_space_property1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_phase_count_in_space_property1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_phase_interval_in_space_property1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_read_timeout_in_space_property1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_replication_count_in_space_property1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_replication_policy_in_space_property1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_ttl_in_space_property1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_update_transport_in_space_property1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_wait_in_space_property1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_space_write_timeout_in_space_property1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAPACITY_in_space_capacity1863 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_capacity1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_capacity1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy1912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_DISTRIBUTED_in_space_distribution_policy1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTRIBUTION_POLICY_in_space_distribution_policy1926 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_NON_DISTRIBUTED_in_space_distribution_policy1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVICTION_POLICY_in_space_eviction_policy1966 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_NONE_in_space_eviction_policy1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVICTION_POLICY_in_space_eviction_policy1978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_LRU_in_space_eviction_policy1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_SCOPE_in_space_lock_scope2012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_THREAD_in_space_lock_scope2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_SCOPE_in_space_lock_scope2024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_PROCESS_in_space_lock_scope2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_TTL_in_space_lock_ttl2058 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_lock_ttl2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_lock_ttl2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_WAIT_in_space_lock_wait2102 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_lock_wait2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_lock_wait2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_SEEDERS_in_space_min_seeders2147 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_min_seeders2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2185 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_SYNC_in_space_persistence_policy2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_POLICY_in_space_persistence_policy2197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_ASYNC_in_space_persistence_policy2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_in_space_persistence_type2233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_NONE_in_space_persistence_type2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_in_space_persistence_type2247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_SHARED_ALL_in_space_persistence_type2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_in_space_persistence_type2263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SHARED_NOTHING_in_space_persistence_type2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_NONE_in_space_persistence_type2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_SHARED_ALL_in_space_persistence_type2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERSISTENCE_TYPE_in_space_persistence_type2309 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_SHARED_NOTHING_in_space_persistence_type2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PHASE_COUNT_in_space_phase_count2348 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_phase_count2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_phase_count2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PHASE_INTERVAL_in_space_phase_interval2392 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_phase_interval2394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_TIMEOUT_in_space_read_timeout2426 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_read_timeout2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLICATION_COUNT_in_space_replication_count2460 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_replication_count2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLICATION_POLICY_in_space_replication_policy2494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_SYNC_in_space_replication_policy2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPLICATION_POLICY_in_space_replication_policy2506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_ASYNC_in_space_replication_policy2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TTL_in_space_ttl2540 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_NegativeNumber_in_space_ttl2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_ttl2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_TRANSPORT_in_space_update_transport2584 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_UNICAST_in_space_update_transport2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_TRANSPORT_in_space_update_transport2596 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_MULTICAST_in_space_update_transport2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPACE_WAIT_in_space_wait2630 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_wait2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_TIMEOUT_in_space_write_timeout2664 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PositiveNumber_in_space_write_timeout2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIMARY_KEY_in_table_constraint2689 = new BitSet(new long[]{0x0000180000000040L});
    public static final BitSet FOLLOW_key_type_in_table_constraint2692 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_table_constraint2705 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_constraint2709 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_table_constraint2722 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_constraint2726 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_table_constraint2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAINT_in_table_constraint_def2751 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_Identifier_in_table_constraint_def2753 = new BitSet(new long[]{0x0000000000200000L,0x0000000020000000L});
    public static final BitSet FOLLOW_table_constraint_in_table_constraint_def2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_table_element2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_constraint_def_in_table_element2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_index_in_table_element2790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDEX_in_table_index2821 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_index_name_in_table_index2823 = new BitSet(new long[]{0x0000180000000040L});
    public static final BitSet FOLLOW_key_type_in_table_index2826 = new BitSet(new long[]{0x0000180000000040L});
    public static final BitSet FOLLOW_table_index_list_in_table_index2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OParen_in_table_index_list2869 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_index_list2873 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_Comma_in_table_index_list2878 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_column_name_in_table_index_list2882 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_CParen_in_table_index_list2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_table_index_name2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_table_name2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_table_reference_list2954 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_Comma_in_table_reference_list2959 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_table_reference_list2963 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_table_name_in_target_table2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ONLY_in_target_table2998 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_target_table3000 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_table_name_in_target_table3002 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_target_table3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_in_where_condition3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_in_where_condition3059 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_AND_in_where_condition3061 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_in_where_condition3077 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_OR_in_where_condition3079 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3095 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_OR_in_where_condition3097 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3113 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_AND_in_where_condition3115 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_relation_group_in_where_condition3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rterm_in_where_condition3129 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_IN_in_where_condition3131 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_OParen_in_where_condition3133 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_rterm_list_in_where_condition3135 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_condition3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_where_relation3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_where_relation3174 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_AND_in_where_relation3179 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_relation_in_where_relation3183 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_relation_in_where_relation3197 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_OR_in_where_relation3202 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_relation_in_where_relation3206 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_OParen_in_where_relation_group3236 = new BitSet(new long[]{0x010003C002080000L});
    public static final BitSet FOLLOW_where_relation_in_where_relation_group3240 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CParen_in_where_relation_group3242 = new BitSet(new long[]{0x0000000000000002L});

}