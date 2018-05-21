// Generated from src/Gramatika/Princess.g4 by ANTLR 4.7
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PrincessParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PrincessVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PrincessParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(PrincessParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PrincessParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PrincessParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PrincessParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierFunctionCall(PrincessParser.IdentifierFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteFunctionCall(PrincessParser.WriteFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintFunctionCall(PrincessParser.PrintFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertFunctionCall(PrincessParser.AssertFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link PrincessParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeFunctionCall(PrincessParser.SizeFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PrincessParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(PrincessParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#elseIfStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStat(PrincessParser.ElseIfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#elseStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStat(PrincessParser.ElseStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(PrincessParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#functionForAttr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionForAttr(PrincessParser.FunctionForAttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(PrincessParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PrincessParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(PrincessParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(PrincessParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpression(PrincessParser.LtExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(PrincessParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGExpression(PrincessParser.GExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqExpression(PrincessParser.NotEqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(PrincessParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(PrincessParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExpression(PrincessParser.MultiplyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtEqExpression(PrincessParser.GtEqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivideExpression(PrincessParser.DivideExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(PrincessParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(PrincessParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(PrincessParser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(PrincessParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(PrincessParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(PrincessParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionExpression(PrincessParser.ExpressionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(PrincessParser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractExpression(PrincessParser.SubtractExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpression(PrincessParser.NullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(PrincessParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(PrincessParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtEqExpression(PrincessParser.LtEqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(PrincessParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link PrincessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpression(PrincessParser.InputExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(PrincessParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrincessParser#indexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexes(PrincessParser.IndexesContext ctx);
}