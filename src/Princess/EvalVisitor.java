package Princess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import ANTLR.*;
import ANTLR.PrincessParser.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvalVisitor extends PrincessBaseVisitor<PrincessValue> {
	private static ReturnValue returnValue = new ReturnValue();
    private Scope scope;
    private Map<String, Function> functions;
    
    public EvalVisitor(Scope scope, Map<String, Function> functions) {
        this.scope = scope;
        this.functions = functions;
    }

    // functionDecl
    @Override
    public PrincessValue visitFunctionDecl(FunctionDeclContext ctx) {
        return PrincessValue.VOID;
    }
    
    // list: '[' exprList? ']'
    @Override
    public PrincessValue visitList(ListContext ctx) {
        List<PrincessValue> list = new ArrayList<PrincessValue>();
        if (ctx.exprList() != null) {
	        for(ExpressionContext ex: ctx.exprList().expression()) {
	            list.add(this.visit(ex));
	        }
        }
        return new PrincessValue(list);
    }
    
    
    // '-' expression                           #unaryMinusExpression
    @Override
    public PrincessValue visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
    	PrincessValue v = this.visit(ctx.expression());
    	if (!v.isNumber()) {
    	    throw new EvalException(ctx);
        }
    	return new PrincessValue(-1 * v.asDouble());
    }

//    // '!' expression                           #notExpression
//    @Override
//    public PrincessValue visitNotExpression(NotExpressionContext ctx) {
//    	PrincessValue v = this.visit(ctx.expression());
//    	if(!v.isBoolean()) {
//    	    throw new EvalException(ctx);
//        }
//    	return new PrincessValue(!v.asBoolean());
//    }

//    // expression '^' expression                #powerExpression
//    @Override
//    public PrincessValue visitPowerExpression(PowerExpressionContext ctx) {
//    	PrincessValue lhs = this.visit(ctx.expression(0));
//    	PrincessValue rhs = this.visit(ctx.expression(1));
//    	if (lhs.isNumber() && rhs.isNumber()) {
//    		return new PrincessValue(Math.pow(lhs.asDouble(), rhs.asDouble()));
//    	}
//    	throw new EvalException(ctx);
//    }

    // expression '*' expression                #multiplyExpression
    @Override
    public PrincessValue visitMultiplyExpression(MultiplyExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if(lhs == null || rhs == null) {
    		System.err.println("lhs "+ lhs+ " rhs "+rhs);
    	    throw new EvalException(ctx);
    	}
    	
    	// number * number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new PrincessValue(lhs.asDouble() * rhs.asDouble());
        }

        // string * number
        if(lhs.isString() && rhs.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                str.append(lhs.asString());
            }
            return new PrincessValue(str.toString());
        }

        // list * number
        if(lhs.isList() && rhs.isNumber()) {
            List<PrincessValue> total = new ArrayList<PrincessValue>();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                total.addAll(lhs.asList());
            }
            return new PrincessValue(total);
        }    	
    	throw new EvalException(ctx);
    }

    // expression '/' expression                #divideExpression
    @Override
    public PrincessValue visitDivideExpression(DivideExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new PrincessValue(lhs.asDouble() / rhs.asDouble());
    	}
    	throw new EvalException(ctx);
    }

    // expression '%' expression                #modulusExpression
//	@Override
//	public PrincessValue visitModulusExpression(ModulusExpressionContext ctx) {
//		PrincessValue lhs = this.visit(ctx.expression(0));
//    	PrincessValue rhs = this.visit(ctx.expression(1));
//    	if (lhs.isNumber() && rhs.isNumber()) {
//    		return new PrincessValue(lhs.asDouble() % rhs.asDouble());
//    	}
//    	throw new EvalException(ctx);
//	}
	
    // expression '+' expression                #addExpression
    @Override
    public PrincessValue visitAddExpression(@NotNull PrincessParser.AddExpressionContext ctx) {
        PrincessValue lhs = this.visit(ctx.expression(0));
        PrincessValue rhs = this.visit(ctx.expression(1));
        
        if(lhs == null || rhs == null) {
            throw new EvalException(ctx);
        }
        
        if(lhs.isInteger() && rhs.isInteger()){
            return new PrincessValue(lhs.asInteger() + rhs.asInteger());
        }
//        // number + number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new PrincessValue(lhs.asDouble() + rhs.asDouble());
        }
        
        //list + list
        if(lhs.isList() && rhs.isList()){
            List<PrincessValue> leftList = lhs.asList();
            List<PrincessValue> rightList = rhs.asList();
            for(int i=0; i < rightList.size(); i++){
                leftList.add(rightList.get(i));
            }
            return new PrincessValue(leftList);
        }
        else if(lhs.isList()) {
            // list + any
            List<PrincessValue> list = lhs.asList();
            list.add(rhs);
            return new PrincessValue(list);
        }
        

        // string + any
        if(lhs.isString()) {
            return new PrincessValue(lhs.asString() + "" + rhs.toString());
        }

        // any + string
        if(rhs.isString()) {
            return new PrincessValue(lhs.toString() + "" + rhs.asString());
        }
        
        return new PrincessValue(lhs.toString() + rhs.toString());
    }

    // expression '-' expression                #subtractExpression
    @Override
    public PrincessValue visitSubtractExpression(SubtractExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new PrincessValue(lhs.asDouble() - rhs.asDouble());
    	}
    	if (lhs.isList()) {
            List<PrincessValue> list = lhs.asList();
            list.remove(rhs);
            return new PrincessValue(list);
        }
    	throw new EvalException(ctx);
    }

    // expression '>=' expression               #gtEqExpression
    @Override
    public PrincessValue visitGtEqExpression(GtEqExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new PrincessValue(lhs.asDouble() >= rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new PrincessValue(lhs.asString().compareTo(rhs.asString()) >= 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '<=' expression               #ltEqExpression
    @Override
    public PrincessValue visitLtEqExpression(LtEqExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new PrincessValue(lhs.asDouble() <= rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new PrincessValue(lhs.asString().compareTo(rhs.asString()) <= 0);
        }
    	throw new EvalException(ctx);
    }

//     expression '>' expression                #gtExpression
//    @Override
    public PrincessValue visitGtExpression(GExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new PrincessValue(lhs.asDouble() > rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new PrincessValue(lhs.asString().compareTo(rhs.asString()) > 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '<' expression                #ltExpression
    @Override
    public PrincessValue visitLtExpression(LtExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new PrincessValue(lhs.asDouble() < rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new PrincessValue(lhs.asString().compareTo(rhs.asString()) < 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '==' expression               #eqExpression
    @Override
    public PrincessValue visitEqExpression(@NotNull PrincessParser.EqExpressionContext ctx) {
        PrincessValue lhs = this.visit(ctx.expression(0));
        PrincessValue rhs = this.visit(ctx.expression(1));
        if (lhs == null) {
        	throw new EvalException(ctx);
        }
        return new PrincessValue(lhs.equals(rhs));
    }

    // expression '!=' expression               #notEqExpression
    @Override
    public PrincessValue visitNotEqExpression(@NotNull PrincessParser.NotEqExpressionContext ctx) {
        PrincessValue lhs = this.visit(ctx.expression(0));
        PrincessValue rhs = this.visit(ctx.expression(1));
        return new PrincessValue(!lhs.equals(rhs));
    }

    // expression '&&' expression               #andExpression
    @Override
    public PrincessValue visitAndExpression(AndExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	
    	if(!lhs.isBoolean() || !rhs.isBoolean()) {
    	    throw new EvalException(ctx);
        }
		return new PrincessValue(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public PrincessValue visitOrExpression(OrExpressionContext ctx) {
    	PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	
    	if(!lhs.isBoolean() || !rhs.isBoolean()) {
    	    throw new EvalException(ctx);
        }
		return new PrincessValue(lhs.asBoolean() || rhs.asBoolean());
    }

    // expression '?' expression ':' expression #ternaryExpression
    @Override
    public PrincessValue visitTernaryExpression(TernaryExpressionContext ctx) {
    	PrincessValue condition = this.visit(ctx.expression(0));
    	if (condition.asBoolean()) {
    		return new PrincessValue(this.visit(ctx.expression(1)));
    	} else {
    		return new PrincessValue(this.visit(ctx.expression(2)));
    	}
    }

    // expression In expression                 #inExpression
	@Override
	public PrincessValue visitInExpression(InExpressionContext ctx) {
		PrincessValue lhs = this.visit(ctx.expression(0));
    	PrincessValue rhs = this.visit(ctx.expression(1));
    	
    	if (rhs.isList()) {
    		for(PrincessValue val: rhs.asList()) {
    			if (val.equals(lhs)) {
    				return new PrincessValue(true);
    			}
    		}
    		return new PrincessValue(false);
    	}
    	throw new EvalException(ctx);
	}
	
    // Number                                   #numberExpression
    @Override
    public PrincessValue visitNumberExpression(@NotNull PrincessParser.NumberExpressionContext ctx) {
        return new PrincessValue(Double.valueOf(ctx.getText()));
    }

    // Bool                                     #boolExpression
    @Override
    public PrincessValue visitBoolExpression(@NotNull PrincessParser.BoolExpressionContext ctx) {
        return new PrincessValue(Boolean.valueOf(ctx.getText()));
    }

    // Null                                     #nullExpression
    @Override
    public PrincessValue visitNullExpression(@NotNull PrincessParser.NullExpressionContext ctx) {
        return PrincessValue.NULL;
    }

    private PrincessValue resolveIndexes(ParserRuleContext ctx, PrincessValue val, List<ExpressionContext> indexes) {
    	for (ExpressionContext ec: indexes) {
    		PrincessValue idx = this.visit(ec);
    		if (!idx.isNumber() || (!val.isList() && !val.isString()) ) {
        		throw new EvalException("Problem resolving indexes on "+val+" at "+idx, ec);
    		}
    		int i = idx.asDouble().intValue();
    		if (val.isString()) {
    			val = new PrincessValue(val.asString().substring(i, i+1));
    		} else {
    			val = val.asList().get(i);
    		}
    	}
    	return val;
    }
    
    private void setAtIndex(ParserRuleContext ctx, List<ExpressionContext> indexes, PrincessValue val, PrincessValue newVal) {
    	if (!val.isList()) {
    		throw new EvalException(ctx);
    	}
    	// TODO some more list size checking in here
    	for (int i = 0; i < indexes.size() - 1; i++) {
    		PrincessValue idx = this.visit(indexes.get(i));
    		if (!idx.isNumber()) {
        		throw new EvalException(ctx);
    		}
    		val = val.asList().get(idx.asDouble().intValue());
    	}
    	PrincessValue idx = this.visit(indexes.get(indexes.size() - 1));
		if (!idx.isNumber()) {
    		throw new EvalException(ctx);
		}
    	val.asList().set(idx.asDouble().intValue(), newVal);
    }
    
    // functionCall indexes?                    #functionCallExpression
    @Override
    public PrincessValue visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
    	PrincessValue val = this.visit(ctx.functionCall());
    	if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
    	return val;
    }

    // list indexes?                            #listExpression
    @Override
    public PrincessValue visitListExpression(ListExpressionContext ctx) {
    	PrincessValue val = this.visit(ctx.list());
    	if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
    	return val;
    }

    // Identifier indexes?                      #identifierExpression
    @Override
    public PrincessValue visitIdentifierExpression(@NotNull PrincessParser.IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        PrincessValue val = scope.resolve(id);
        
        if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
        return val;
    }

    // String indexes?                          #stringExpression
    @Override
    public PrincessValue visitStringExpression(@NotNull PrincessParser.StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        PrincessValue val = new PrincessValue(text);
        if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
        return val;
    }

    // '(' expression ')' indexes?              #expressionExpression
    @Override
    public PrincessValue visitExpressionExpression(ExpressionExpressionContext ctx) {
        PrincessValue val = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
        return val;
    }

    // Input '(' String? ')'                    #inputExpression
    @Override
    public PrincessValue visitInputExpression(InputExpressionContext ctx) {
    	TerminalNode inputString = ctx.String();
		try {
			if (inputString != null) {
				String text = inputString.getText();
		        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
				return new PrincessValue(new String(Files.readAllBytes(Paths.get(text))));
			} else {
				BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				return new PrincessValue(buffer.readLine());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }

    
    // assignment
    // : Identifier indexes? '=' expression
    // ;
    @Override
    public PrincessValue visitAssignment(@NotNull PrincessParser.AssignmentContext ctx) {
        PrincessValue newVal = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
        	PrincessValue val = scope.resolve(ctx.Identifier().getText());
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	setAtIndex(ctx, exps, val, newVal);
        } else {
        	String id = ctx.Identifier().getText();        	
        	scope.assign(id, newVal);
        }
        return PrincessValue.VOID;
    }

    // Identifier '(' exprList? ')' #identifierFunctionCall
    @Override
    public PrincessValue visitIdentifierFunctionCall(IdentifierFunctionCallContext ctx) {
        List<ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<ExpressionContext>();
        String id = ctx.Identifier().getText() + params.size();
        Function function;      
        if ((function = functions.get(id)) != null) {
            return function.invoke(params, functions, scope);
        }
        throw new EvalException(ctx);
    }
    
    // Rasyti '(' expression ')'     #rasytiFunctionCall   
//    @Override
    public PrincessValue visitRasytiFunctionCall(@NotNull PrincessParser.WriteFunctionCallContext ctx) {
        List<ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<ExpressionContext>();
        String path = "log.txt";
        PrincessValue expr;
        if (params.size() == 2) {
            path = this.visit(params.get(0)).toString();
            expr = this.visit(params.get(1));     
        } else {
            expr = this.visit(params.get(0));
        }
        try(  PrintWriter out = new PrintWriter( path )  ){
            out.println( expr );
            System.out.println("Spausdinta faile: " + path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PrincessValue.VOID;
    }

    //  | Spausdinti '(' expression? ')'  #SpausdintiFunctionCall
//    @Override
    public PrincessValue visitSpausdintiFunctionCall(@NotNull PrincessParser.PrintFunctionCallContext ctx) {
        System.out.println(this.visit(ctx.expression()));
        return PrincessValue.VOID;
    }


    // Assert '(' expression ')'    #assertFunctionCall
    @Override
    public PrincessValue visitAssertFunctionCall(AssertFunctionCallContext ctx) {
    	PrincessValue value = this.visit(ctx.expression());

        if(!value.isBoolean()) {
            throw new EvalException(ctx);
        }

        if(!value.asBoolean()) {
            throw new AssertionError("Failed Assertion "+ctx.expression().getText()+" line:"+ctx.start.getLine());
        }

        return PrincessValue.VOID;
    }

    // Size '(' expression ')'      #sizeFunctionCall
    @Override
    public PrincessValue visitSizeFunctionCall(SizeFunctionCallContext ctx) {
    	PrincessValue value = this.visit(ctx.expression());

        if(value.isString()) {
            return new PrincessValue(value.asString().length());
        }

        if(value.isList()) {
            return new PrincessValue(value.asList().size());
        }

        throw new EvalException(ctx);
    }

    // ifStatement
    //  : ifStat elseIfStat* elseStat? End
    //  ;
    //
    // ifStat
    //  : If expression Do block
    //  ;
    //
    // elseIfStat
    //  : Else If expression Do block
    //  ;
    //
    // elseStat
    //  : Else Do block
    //  ;
    @Override
    public PrincessValue visitIfStatement(@NotNull PrincessParser.IfStatementContext ctx) {

        // if ...
        if(this.visit(ctx.ifStat().expression()).asBoolean()) {
            return this.visit(ctx.ifStat().block());
        }

        // else if ...
        for(int i = 0; i < ctx.elseIfStat().size(); i++) {
            if(this.visit(ctx.elseIfStat(i).expression()).asBoolean()) {
                return this.visit(ctx.elseIfStat(i).block());
            }
        }

        // else ...
        if(ctx.elseStat() != null) {
            return this.visit(ctx.elseStat().block());
        }

        return PrincessValue.VOID;
    }
    
    // block
    // : (statement | functionDecl)* (Return expression)?
    // ;
    @Override
    public PrincessValue visitBlock(BlockContext ctx) {
    		
    	scope = new Scope(scope); // create new local scope
        for (StatementContext sx: ctx.statement()) {
            this.visit(sx);
        }
        ExpressionContext ex;
        if ((ex = ctx.expression()) != null) {
        	returnValue.value = this.visit(ex);
        	scope = scope.parent();
        	throw returnValue;
        }
        scope = scope.parent();
        return PrincessValue.VOID;
    }
    
    // forStatement
    // : For Identifier '=' expression To expression OBrace block CBrace
    // ;
    @Override
    public PrincessValue visitForStatement(ForStatementContext ctx) {
        int start = this.visit(ctx.expression(0)).asDouble().intValue();
        int stop = this.visit(ctx.expression(1)).asDouble().intValue();
        for(int i = start; i <= stop; i++) {
            scope.assign(ctx.Identifier().getText(), new PrincessValue(i));
            PrincessValue returnValue = this.visit(ctx.block());
            if(returnValue != PrincessValue.VOID) {
                return returnValue;
            }
        }
        return PrincessValue.VOID;
    }
    
    // whileStatement
    // : While expression OBrace block CBrace
    // ;
    @Override
    public PrincessValue visitWhileStatement(WhileStatementContext ctx) {
        while( this.visit(ctx.expression()).asBoolean() ) {
            PrincessValue returnValue = this.visit(ctx.block());
            if (returnValue != PrincessValue.VOID) {
                return returnValue;
            }
        }
        return PrincessValue.VOID;
    }
    
}
