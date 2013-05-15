// Generated from AsteroidsParser.g4 by ANTLR 4.0
 package asteroids.model.programs.parsing; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AsteroidsParserLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELF=1, TRUE=2, FALSE=3, NULL=4, BOOL=5, DOUBLE=6, ENTITY=7, SHIP=8, ASTEROID=9, 
		BULLET=10, ANY=11, GETRADIUS=12, GETX=13, GETY=14, GETVX=15, GETVY=16, 
		GETDIR=17, SQRT=18, SIN=19, COS=20, NOT=21, THRUSTON=22, THRUSTOFF=23, 
		TURN=24, FIRE=25, SKIP=26, PRINT=27, IF=28, THEN=29, ELSE=30, WHILE=31, 
		DO=32, FOREACH=33, ASSIGN=34, MUL=35, DIV=36, ADD=37, SUB=38, EQ=39, NEQ=40, 
		LT=41, GT=42, LEQ=43, GEQ=44, AND=45, OR=46, NUMBER=47, FLOAT=48, INTEGER=49, 
		SIGN=50, IDENTIFIER=51, LEFT_PAREN=52, RIGHT_PAREN=53, LEFT_BRACE=54, 
		RIGHT_BRACE=55, SEMICOLON=56, COMMA=57, WHITESPACE=58, SINGLE_COMMENT=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'self'", "'true'", "'false'", "'null'", "'bool'", "'double'", "'entity'", 
		"'ship'", "'asteroid'", "'bullet'", "'any'", "'getradius'", "'getx'", 
		"'gety'", "'getvx'", "'getvy'", "'getdir'", "'sqrt'", "'sin'", "'cos'", 
		"'!'", "'thrust'", "'thrust_off'", "'turn'", "'fire'", "'skip'", "'print'", 
		"'if'", "'then'", "'else'", "'while'", "'do'", "'foreach'", "':='", "'*'", 
		"'/'", "'+'", "'-'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", 
		"'||'", "NUMBER", "FLOAT", "INTEGER", "SIGN", "IDENTIFIER", "'('", "')'", 
		"'{'", "'}'", "';'", "','", "WHITESPACE", "SINGLE_COMMENT"
	};
	public static final String[] ruleNames = {
		"SELF", "TRUE", "FALSE", "NULL", "BOOL", "DOUBLE", "ENTITY", "SHIP", "ASTEROID", 
		"BULLET", "ANY", "GETRADIUS", "GETX", "GETY", "GETVX", "GETVY", "GETDIR", 
		"SQRT", "SIN", "COS", "NOT", "THRUSTON", "THRUSTOFF", "TURN", "FIRE", 
		"SKIP", "PRINT", "IF", "THEN", "ELSE", "WHILE", "DO", "FOREACH", "ASSIGN", 
		"MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "LT", "GT", "LEQ", "GEQ", "AND", 
		"OR", "NUMBER", "FLOAT", "INTEGER", "SIGN", "IDENTIFIER", "LETTER", "LOWER", 
		"UPPER", "DIGIT", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
		"SEMICOLON", "COMMA", "WHITESPACE", "SINGLE_COMMENT", "NEWLINE"
	};





	public AsteroidsParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AsteroidsParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 61: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;

		case 62: SINGLE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void SINGLE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4=\u01b7\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$"+
		"\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3"+
		".\3.\3.\3/\3/\3/\3\60\3\60\5\60\u0163\n\60\3\61\3\61\3\61\6\61\u0168\n"+
		"\61\r\61\16\61\u0169\3\62\3\62\5\62\u016e\n\62\3\62\3\62\7\62\u0172\n"+
		"\62\f\62\16\62\u0175\13\62\5\62\u0177\n\62\3\63\3\63\5\63\u017b\n\63\3"+
		"\64\3\64\3\64\3\64\7\64\u0181\n\64\f\64\16\64\u0184\13\64\3\65\3\65\5"+
		"\65\u0188\n\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\6?\u019d\n?\r?\16?\u019e\3?\3?\3@\3@\3@\3@\7@\u01a7\n@\f@\16"+
		"@\u01aa\13@\3@\3@\3@\3@\3A\5A\u01b1\nA\3A\6A\u01b4\nA\rA\16A\u01b5\2B"+
		"\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\1g\65\1i\2\1k\2\1m\2\1o\2\1q\66\1s\67\1u8\1w9\1y:\1{;\1}"+
		"<\2\177=\3\u0081\2\1\3\2\4\5\13\f\17\17\"\"\4\f\f\17\17\u01bf\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3"+
		"\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0083\3\2\2\2"+
		"\5\u0088\3\2\2\2\7\u008d\3\2\2\2\t\u0093\3\2\2\2\13\u0098\3\2\2\2\r\u009d"+
		"\3\2\2\2\17\u00a4\3\2\2\2\21\u00ab\3\2\2\2\23\u00b0\3\2\2\2\25\u00b9\3"+
		"\2\2\2\27\u00c0\3\2\2\2\31\u00c4\3\2\2\2\33\u00ce\3\2\2\2\35\u00d3\3\2"+
		"\2\2\37\u00d8\3\2\2\2!\u00de\3\2\2\2#\u00e4\3\2\2\2%\u00eb\3\2\2\2\'\u00f0"+
		"\3\2\2\2)\u00f4\3\2\2\2+\u00f8\3\2\2\2-\u00fa\3\2\2\2/\u0101\3\2\2\2\61"+
		"\u010c\3\2\2\2\63\u0111\3\2\2\2\65\u0116\3\2\2\2\67\u011b\3\2\2\29\u0121"+
		"\3\2\2\2;\u0124\3\2\2\2=\u0129\3\2\2\2?\u012e\3\2\2\2A\u0134\3\2\2\2C"+
		"\u0137\3\2\2\2E\u013f\3\2\2\2G\u0142\3\2\2\2I\u0144\3\2\2\2K\u0146\3\2"+
		"\2\2M\u0148\3\2\2\2O\u014a\3\2\2\2Q\u014d\3\2\2\2S\u0150\3\2\2\2U\u0152"+
		"\3\2\2\2W\u0154\3\2\2\2Y\u0157\3\2\2\2[\u015a\3\2\2\2]\u015d\3\2\2\2_"+
		"\u0162\3\2\2\2a\u0164\3\2\2\2c\u0176\3\2\2\2e\u017a\3\2\2\2g\u017c\3\2"+
		"\2\2i\u0187\3\2\2\2k\u0189\3\2\2\2m\u018b\3\2\2\2o\u018d\3\2\2\2q\u018f"+
		"\3\2\2\2s\u0191\3\2\2\2u\u0193\3\2\2\2w\u0195\3\2\2\2y\u0197\3\2\2\2{"+
		"\u0199\3\2\2\2}\u019c\3\2\2\2\177\u01a2\3\2\2\2\u0081\u01b3\3\2\2\2\u0083"+
		"\u0084\7u\2\2\u0084\u0085\7g\2\2\u0085\u0086\7n\2\2\u0086\u0087\7h\2\2"+
		"\u0087\4\3\2\2\2\u0088\u0089\7v\2\2\u0089\u008a\7t\2\2\u008a\u008b\7w"+
		"\2\2\u008b\u008c\7g\2\2\u008c\6\3\2\2\2\u008d\u008e\7h\2\2\u008e\u008f"+
		"\7c\2\2\u008f\u0090\7n\2\2\u0090\u0091\7u\2\2\u0091\u0092\7g\2\2\u0092"+
		"\b\3\2\2\2\u0093\u0094\7p\2\2\u0094\u0095\7w\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7n\2\2\u0097\n\3\2\2\2\u0098\u0099\7d\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7q\2\2\u009b\u009c\7n\2\2\u009c\f\3\2\2\2\u009d\u009e\7f\2\2\u009e"+
		"\u009f\7q\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7d\2\2\u00a1\u00a2\7n\2\2"+
		"\u00a2\u00a3\7g\2\2\u00a3\16\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7"+
		"p\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa"+
		"\7{\2\2\u00aa\20\3\2\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae"+
		"\7k\2\2\u00ae\u00af\7r\2\2\u00af\22\3\2\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2"+
		"\7u\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7t\2\2\u00b5"+
		"\u00b6\7q\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7f\2\2\u00b8\24\3\2\2\2\u00b9"+
		"\u00ba\7d\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7n\2\2"+
		"\u00bd\u00be\7g\2\2\u00be\u00bf\7v\2\2\u00bf\26\3\2\2\2\u00c0\u00c1\7"+
		"c\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7{\2\2\u00c3\30\3\2\2\2\u00c4\u00c5"+
		"\7i\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7t\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00ca\7f\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7w\2\2"+
		"\u00cc\u00cd\7u\2\2\u00cd\32\3\2\2\2\u00ce\u00cf\7i\2\2\u00cf\u00d0\7"+
		"g\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7z\2\2\u00d2\34\3\2\2\2\u00d3\u00d4"+
		"\7i\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7{\2\2\u00d7"+
		"\36\3\2\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7v\2\2\u00db"+
		"\u00dc\7x\2\2\u00dc\u00dd\7z\2\2\u00dd \3\2\2\2\u00de\u00df\7i\2\2\u00df"+
		"\u00e0\7g\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7x\2\2\u00e2\u00e3\7{\2\2"+
		"\u00e3\"\3\2\2\2\u00e4\u00e5\7i\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7v"+
		"\2\2\u00e7\u00e8\7f\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7t\2\2\u00ea$\3"+
		"\2\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed\7s\2\2\u00ed\u00ee\7t\2\2\u00ee"+
		"\u00ef\7v\2\2\u00ef&\3\2\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7k\2\2\u00f2"+
		"\u00f3\7p\2\2\u00f3(\3\2\2\2\u00f4\u00f5\7e\2\2\u00f5\u00f6\7q\2\2\u00f6"+
		"\u00f7\7u\2\2\u00f7*\3\2\2\2\u00f8\u00f9\7#\2\2\u00f9,\3\2\2\2\u00fa\u00fb"+
		"\7v\2\2\u00fb\u00fc\7j\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7w\2\2\u00fe"+
		"\u00ff\7u\2\2\u00ff\u0100\7v\2\2\u0100.\3\2\2\2\u0101\u0102\7v\2\2\u0102"+
		"\u0103\7j\2\2\u0103\u0104\7t\2\2\u0104\u0105\7w\2\2\u0105\u0106\7u\2\2"+
		"\u0106\u0107\7v\2\2\u0107\u0108\7a\2\2\u0108\u0109\7q\2\2\u0109\u010a"+
		"\7h\2\2\u010a\u010b\7h\2\2\u010b\60\3\2\2\2\u010c\u010d\7v\2\2\u010d\u010e"+
		"\7w\2\2\u010e\u010f\7t\2\2\u010f\u0110\7p\2\2\u0110\62\3\2\2\2\u0111\u0112"+
		"\7h\2\2\u0112\u0113\7k\2\2\u0113\u0114\7t\2\2\u0114\u0115\7g\2\2\u0115"+
		"\64\3\2\2\2\u0116\u0117\7u\2\2\u0117\u0118\7m\2\2\u0118\u0119\7k\2\2\u0119"+
		"\u011a\7r\2\2\u011a\66\3\2\2\2\u011b\u011c\7r\2\2\u011c\u011d\7t\2\2\u011d"+
		"\u011e\7k\2\2\u011e\u011f\7p\2\2\u011f\u0120\7v\2\2\u01208\3\2\2\2\u0121"+
		"\u0122\7k\2\2\u0122\u0123\7h\2\2\u0123:\3\2\2\2\u0124\u0125\7v\2\2\u0125"+
		"\u0126\7j\2\2\u0126\u0127\7g\2\2\u0127\u0128\7p\2\2\u0128<\3\2\2\2\u0129"+
		"\u012a\7g\2\2\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c\u012d\7g\2\2"+
		"\u012d>\3\2\2\2\u012e\u012f\7y\2\2\u012f\u0130\7j\2\2\u0130\u0131\7k\2"+
		"\2\u0131\u0132\7n\2\2\u0132\u0133\7g\2\2\u0133@\3\2\2\2\u0134\u0135\7"+
		"f\2\2\u0135\u0136\7q\2\2\u0136B\3\2\2\2\u0137\u0138\7h\2\2\u0138\u0139"+
		"\7q\2\2\u0139\u013a\7t\2\2\u013a\u013b\7g\2\2\u013b\u013c\7c\2\2\u013c"+
		"\u013d\7e\2\2\u013d\u013e\7j\2\2\u013eD\3\2\2\2\u013f\u0140\7<\2\2\u0140"+
		"\u0141\7?\2\2\u0141F\3\2\2\2\u0142\u0143\7,\2\2\u0143H\3\2\2\2\u0144\u0145"+
		"\7\61\2\2\u0145J\3\2\2\2\u0146\u0147\7-\2\2\u0147L\3\2\2\2\u0148\u0149"+
		"\7/\2\2\u0149N\3\2\2\2\u014a\u014b\7?\2\2\u014b\u014c\7?\2\2\u014cP\3"+
		"\2\2\2\u014d\u014e\7#\2\2\u014e\u014f\7?\2\2\u014fR\3\2\2\2\u0150\u0151"+
		"\7>\2\2\u0151T\3\2\2\2\u0152\u0153\7@\2\2\u0153V\3\2\2\2\u0154\u0155\7"+
		">\2\2\u0155\u0156\7?\2\2\u0156X\3\2\2\2\u0157\u0158\7@\2\2\u0158\u0159"+
		"\7?\2\2\u0159Z\3\2\2\2\u015a\u015b\7(\2\2\u015b\u015c\7(\2\2\u015c\\\3"+
		"\2\2\2\u015d\u015e\7~\2\2\u015e\u015f\7~\2\2\u015f^\3\2\2\2\u0160\u0163"+
		"\5c\62\2\u0161\u0163\5a\61\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163"+
		"`\3\2\2\2\u0164\u0165\5c\62\2\u0165\u0167\7\60\2\2\u0166\u0168\4\62;\2"+
		"\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a"+
		"\3\2\2\2\u016ab\3\2\2\2\u016b\u0177\7\62\2\2\u016c\u016e\5e\63\2\u016d"+
		"\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0173\4\63"+
		";\2\u0170\u0172\4\62;\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0176\u016b\3\2\2\2\u0176\u016d\3\2\2\2\u0177d\3\2\2\2\u0178\u017b"+
		"\5K&\2\u0179\u017b\5M\'\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b"+
		"f\3\2\2\2\u017c\u0182\5i\65\2\u017d\u0181\5i\65\2\u017e\u0181\5o8\2\u017f"+
		"\u0181\7a\2\2\u0180\u017d\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u017f\3\2"+
		"\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"h\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0188\5k\66\2\u0186\u0188\5m\67\2"+
		"\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188j\3\2\2\2\u0189\u018a\4"+
		"c|\2\u018al\3\2\2\2\u018b\u018c\4C\\\2\u018cn\3\2\2\2\u018d\u018e\4\62"+
		";\2\u018ep\3\2\2\2\u018f\u0190\7*\2\2\u0190r\3\2\2\2\u0191\u0192\7+\2"+
		"\2\u0192t\3\2\2\2\u0193\u0194\7}\2\2\u0194v\3\2\2\2\u0195\u0196\7\177"+
		"\2\2\u0196x\3\2\2\2\u0197\u0198\7=\2\2\u0198z\3\2\2\2\u0199\u019a\7.\2"+
		"\2\u019a|\3\2\2\2\u019b\u019d\t\2\2\2\u019c\u019b\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\b?\2\2\u01a1~\3\2\2\2\u01a2\u01a3\7\61\2\2\u01a3\u01a4\7\61\2\2"+
		"\u01a4\u01a8\3\2\2\2\u01a5\u01a7\n\3\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa"+
		"\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01ab\u01ac\5\u0081A\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae"+
		"\b@\3\2\u01ae\u0080\3\2\2\2\u01af\u01b1\7\17\2\2\u01b0\u01af\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b4\7\f\2\2\u01b3\u01b0\3\2"+
		"\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6"+
		"\u0082\3\2\2\2\20\2\u0162\u0169\u016d\u0173\u0176\u017a\u0180\u0182\u0187"+
		"\u019e\u01a8\u01b0\u01b5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}