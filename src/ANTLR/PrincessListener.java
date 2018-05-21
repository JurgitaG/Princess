// Generated from src/Gramatika/Princess.g4 by ANTLR 4.7
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrincessParser}.
 */
public interface PrincessListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrincessParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(PrincessParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(PrincessParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PrincessParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PrincessParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PrincessParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PrincessParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PrincessParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PrincessParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(PrincessParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(PrincessParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterWriteFunctionCall(PrincessParser.WriteFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitWriteFunctionCall(PrincessParser.WriteFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(PrincessParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(PrincessParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAssertFunctionCall(PrincessParser.AssertFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAssertFunctionCall(PrincessParser.AssertFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterSizeFunctionCall(PrincessParser.SizeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitSizeFunctionCall(PrincessParser.SizeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PrincessParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PrincessParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(PrincessParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(PrincessParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(PrincessParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(PrincessParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(PrincessParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(PrincessParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(PrincessParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(PrincessParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#functionForAttr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionForAttr(PrincessParser.FunctionForAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#functionForAttr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionForAttr(PrincessParser.FunctionForAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(PrincessParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(PrincessParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PrincessParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PrincessParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(PrincessParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(PrincessParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(PrincessParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(PrincessParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(PrincessParser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(PrincessParser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(PrincessParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(PrincessParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGExpression(PrincessParser.GExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGExpression(PrincessParser.GExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqExpression(PrincessParser.NotEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqExpression(PrincessParser.NotEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(PrincessParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(PrincessParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(PrincessParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(PrincessParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(PrincessParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(PrincessParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtEqExpression(PrincessParser.GtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtEqExpression(PrincessParser.GtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpression(PrincessParser.DivideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpression(PrincessParser.DivideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(PrincessParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(PrincessParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(PrincessParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(PrincessParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(PrincessParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(PrincessParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(PrincessParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(PrincessParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(PrincessParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(PrincessParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(PrincessParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(PrincessParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(PrincessParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(PrincessParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(PrincessParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(PrincessParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpression(PrincessParser.SubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpression(PrincessParser.SubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(PrincessParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(PrincessParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(PrincessParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(PrincessParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(PrincessParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(PrincessParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtEqExpression(PrincessParser.LtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtEqExpression(PrincessParser.LtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(PrincessParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(PrincessParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(PrincessParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(PrincessParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(PrincessParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(PrincessParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrincessParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(PrincessParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrincessParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(PrincessParser.IndexesContext ctx);
}