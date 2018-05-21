grammar LitOn;

parse
 : block EOF
 ;

block
 : (statement | functionDecl | functionForAttr)* (Return expression )?
 ;

statement
 : assignment 
 | functionCall ';'
 | ifStatement
 | forStatement
 | whileStatement
 ;

assignment
 : Identifier indexes? '=' expression
 ;

functionCall
 : Identifier '(' exprList? ')' #identifierFunctionCall
 | Rasyti '(' exprList ')'    #RasytiFunctionCall
 | Spausdinti '(' expression? ')'  #SpausdintiFunctionCall
 | Assert '(' expression ')'    #assertFunctionCall
 | Size '(' expression ')'      #sizeFunctionCall
 ;

ifStatement
 : ifStat elseIfStat* elseStat? End
 ;

ifStat
 : Jei expression Colon block
 ;

elseIfStat
 : Taciau expression Colon block
 ;

elseStat
 : JeiNe Colon block
 ;

functionDecl
 : Identifier OParen idList? CParen Colon block End
 ;

functionForAttr
 : Identifier '=' functionDecl
 ;

forStatement
 : Kilpa OParen Identifier '=' expression Comma expression CParen Colon block End
 ;

whileStatement
 : Kol expression Colon block End
 ;

idList
 : Identifier (',' Identifier)*
 ;

exprList
 : expression (',' expression)*
 ;

expression
 : '-' expression                           #unaryMinusExpression
 | '!' expression                           #notExpression
 | expression '^' expression                #powerExpression
 | expression '*' expression                #multiplyExpression
 | expression '/' expression                #divideExpression
 | expression '%' expression                #modulusExpression
 | expression '+' expression                #addExpression
 | expression '-' expression                #subtractExpression
 | expression '>=' expression               #gtEqExpression
 | expression '<=' expression               #ltEqExpression
 | expression '>' expression                #gtExpression
 | expression '<' expression                #ltExpression
 | expression '==' expression               #eqExpression
 | expression '!=' expression               #notEqExpression
 | expression '&&' expression               #andExpression
 | expression '||' expression               #orExpression
 | expression '?' expression ':' expression #ternaryExpression
 | expression In expression                 #inExpression
 | Number                                   #numberExpression
 | Bool                                     #boolExpression
 | Null                                     #nullExpression
 | functionCall indexes?                    #functionCallExpression
 | list indexes?                            #listExpression
 | Identifier indexes?                      #identifierExpression
 | String indexes?                          #stringExpression
 | '(' expression ')' indexes?              #expressionExpression
 | Input '(' String? ')'                    #inputExpression
 ;

list
 : '[' exprList? ']'
 ;

indexes
 : ('[' expression ']')+
 ;

Rasyti   : 'rasyti';
Spausdinti: 'spausdinti';
Input    : 'input';
Assert   : 'assert';
Size     : 'size';
Def      : 'def';
Jei      : 'jei';
JeiNe    : 'jeiNe';
Taciau   : 'taciau';
Return   : '<<<';
Ratas    : 'ratas';
Kol    : 'kol';
To       : 'to';
End      : '>>>';
In       : 'in';
Null     : 'null';

Or       : '||';
And      : '&&';
Equals   : '==';
NEquals  : '!=';
GTEquals : '>=';
LTEquals : '<=';
Pow      : '^';
Excl     : '!';
GT       : '>';
LT       : '<';
Add      : '+';
Subtract : '-';
Multiply : '*';
Divide   : '/';
Modulus  : '%';
OBrace   : '{';
CBrace   : '}';
OBracket : '[';
CBracket : ']';
OParen   : '(';
CParen   : ')';
SColon   : ';';
Assign   : '=';
Comma    : ',';
QMark    : '?';
Colon    : ':';

Bool
 : 'true' 
 | 'false'
 ;

Number
 : Int ('.' Digit*)?
 ;

Identifier
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

String
 : ["] (~["\r\n] | '\\\\' | '\\"')* ["]
 | ['] (~['\r\n] | '\\\\' | '\\\'')* [']
 ;

Comment
 : ('/' ~[\r\n]* | '/**' .*? '*/') -> skip
 ;

Space
 : [ \t\r\n\u000C] -> skip
 ;

fragment Int
 : [1-9] Digit*
 | '0'
 ;
  
fragment Digit 
 : [0-9]
 ;