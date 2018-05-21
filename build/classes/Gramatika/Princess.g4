grammar Princess;

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
 | Write '(' exprList ')'    #WriteFunctionCall
 | Print '(' expression? ')'  #PrintFunctionCall
 | Assert '(' expression ')'    #assertFunctionCall
 | Size '(' expression ')'      #sizeFunctionCall
 ;

ifStatement
 : ifStat elseIfStat* elseStat? End
 ;

ifStat
 : IfYes expression Colon block
 ;

elseIfStat
 : IfElse expression Colon block
 ;

elseStat
 : IfNot Colon block
 ;

functionDecl
 : Identifier OParen idList? CParen Colon block End
 ;

functionForAttr
 : Identifier '=' functionDecl
 ;

forStatement
 : For OParen Identifier '=' expression Comma expression CParen Colon block End
 ;

whileStatement
 : While expression Colon block End
 ;

idList
 : Identifier (',' Identifier)*
 ;

exprList
 : expression (',' expression)*
 ;

expression
 : 'MINUS' expression                           #unaryMinusExpression
 | expression 'SPARKLE' expression                #multiplyExpression
 | expression 'APPLE' expression                #divideExpression
 | expression 'UNICORN' expression                #addExpression
 | expression 'MINUS' expression                #subtractExpression
 | expression 'ISGIANT' expression               #gtEqExpression
 | expression 'ISDWARF' expression               #ltEqExpression
 | expression 'GIANT' expression                #GExpression
 | expression 'DRAWF' expression                #ltExpression
 | expression 'KING' expression               #eqExpression
 | expression 'NOTKING' expression               #notEqExpression
 | expression 'AND' expression               #andExpression
 | expression 'OR' expression               #orExpression
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

Write    : 'DRAW';
Print    : 'PAINT';
Input    : 'GATE';
Assert   : 'ASSERT';
Size     : 'POTION';
IfYes    : 'IFYES';
IfNot    : 'IFNOT';
IfElse   : 'IFELSE';
Return   : 'LOBBY';
For      : 'FOR';
While    : 'WHILE';
To       : 'TO';
End      : 'DEAD';
In       : 'IN';
Null     : 'UNBORN';

Or       : 'OR';
And      : 'AND';
Equals   : 'KING';
NotEquals : 'NOTKING';
GTEquals : 'ISGIANT';
LTEquals : 'ISDWARF';
More     : 'GIANT';
Less     : 'DWARF';
Add      : 'UNICORN';
Subtract : 'MINUS';
Multiply : 'SPARKLE';
Divide   : 'APPLE';
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
 : ['] (~['\r\n] | '\\\\' | '\\\'')* [']
 ;

Comment
 : ('--' ~[\r\n]* ) -> skip
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
