grammar p416;

@header {
	import com.proteus.parser.p416.ext.*;
}

input
locals [ InputContextExt extendedContext ]
: declaration  declaration* ;

declaration
locals [ DeclarationContextExt extendedContext ]
: constantDeclaration 
|  externDeclaration 
|  actionDeclaration 
|  parserDeclaration 
|  typeDeclaration 
|  controlDeclaration 
|  instantiation 
|  errorDeclaration 
|  matchKindDeclaration ;

nonTypeName
locals [ NonTypeNameContextExt extendedContext ]
: IDENTIFIER 
|  APPLY 
|  KEY 
|  ACTIONS 
|  STATE ;

name
locals [ NameContextExt extendedContext ]
: nonTypeName 
|  IDENTIFIER ;

optAnnotations
locals [ OptAnnotationsContextExt extendedContext ]
:(  annotations  )? ;

annotations
locals [ AnnotationsContextExt extendedContext ]
: annotation 
|  annotations  annotation ;

annotation
locals [ AnnotationContextExt extendedContext ]
: '@'  name 
|  '@'  name  '('  expressionList  ')' ;

parameterList
locals [ ParameterListContextExt extendedContext ]
:(  nonEmptyParameterList  )? ;

nonEmptyParameterList
locals [ NonEmptyParameterListContextExt extendedContext ]
: parameter 
|  nonEmptyParameterList  ','  parameter ;

parameter
locals [ ParameterContextExt extendedContext ]
: optAnnotations  direction  typeRef  name ;

direction
locals [ DirectionContextExt extendedContext ]
:(  IN 
| OUT 
| INOUT  )? ;

packageTypeDeclaration
locals [ PackageTypeDeclarationContextExt extendedContext ]
: optAnnotations  PACKAGE  name  optTypeParameters  '('  parameterList  ')' ;

instantiation
locals [ InstantiationContextExt extendedContext ]
: annotations  typeRef  '('  argumentList  ')'  name  ';' 
|  typeRef  '('  argumentList  ')'  name  ';' 
|  annotations  typeRef  '('  argumentList  ')'  name  '='  objInitializer  ';' 
|  typeRef  '('  argumentList  ')'  name  '='  objInitializer  ';' ;

objInitializer
locals [ ObjInitializerContextExt extendedContext ]
: '{'  objDeclarations  '}' ;

objDeclarations
locals [ ObjDeclarationsContextExt extendedContext ]
: objDeclaration* ;

objDeclaration
locals [ ObjDeclarationContextExt extendedContext ]
: functionDeclaration 
|  instantiation ;

optConstructorParameters
locals [ OptConstructorParametersContextExt extendedContext ]
:(  '('  parameterList  ')'  )? ;

dotPrefix
locals [ DotPrefixContextExt extendedContext ]
: '.' ;

parserDeclaration
locals [ ParserDeclarationContextExt extendedContext ]
: parserTypeDeclaration  optConstructorParameters  '{'  parserLocalElements  parserStates  '}' ;

parserLocalElements
locals [ ParserLocalElementsContextExt extendedContext ]
: parserLocalElement* ;

parserLocalElement
locals [ ParserLocalElementContextExt extendedContext ]
: constantDeclaration 
|  instantiation 
|  variableDeclaration ;

parserTypeDeclaration
locals [ ParserTypeDeclarationContextExt extendedContext ]
: optAnnotations  PARSER  name  optTypeParameters  '('  parameterList  ')' ;

parserStates
locals [ ParserStatesContextExt extendedContext ]
: parserState 
|  parserStates  parserState ;

parserState
locals [ ParserStateContextExt extendedContext ]
: optAnnotations  STATE  name  '{'  parserStatements  transitionStatement  '}' ;

parserStatements
locals [ ParserStatementsContextExt extendedContext ]
: parserStatement* ;

parserStatement
locals [ ParserStatementContextExt extendedContext ]
: assignmentOrMethodCallStatement 
|  variableDeclaration 
|  parserBlockStatement ;

parserBlockStatement
locals [ ParserBlockStatementContextExt extendedContext ]
: optAnnotations  '{'  parserStatements  '}' ;

transitionStatement
locals [ TransitionStatementContextExt extendedContext ]
:(  TRANSITION  stateExpression  )? ;

stateExpression
locals [ StateExpressionContextExt extendedContext ]
: name  ';' 
|  selectExpression ;

selectExpression
locals [ SelectExpressionContextExt extendedContext ]
: SELECT  '('  expressionList  ')'  '{'  selectCaseList  '}' ;

selectCaseList
locals [ SelectCaseListContextExt extendedContext ]
: selectCase* ;

selectCase
locals [ SelectCaseContextExt extendedContext ]
: keysetExpression  ':'  name  ';' ;

keysetExpression
locals [ KeysetExpressionContextExt extendedContext ]
: tupleKeysetExpression 
|  simpleKeysetExpression ;

tupleKeysetExpression
locals [ TupleKeysetExpressionContextExt extendedContext ]
: '('  simpleKeysetExpression  ','  simpleExpressionList  ')' ;

simpleExpressionList
locals [ SimpleExpressionListContextExt extendedContext ]
: simpleKeysetExpression 
|  simpleExpressionList  ','  simpleKeysetExpression ;

simpleKeysetExpression
locals [ SimpleKeysetExpressionContextExt extendedContext ]
: expression 
|  expression  MASK  expression 
|  expression  RANGE  expression 
|  DEFAULT 
|  DONTCARE ;

controlDeclaration
locals [ ControlDeclarationContextExt extendedContext ]
: controlTypeDeclaration  optConstructorParameters  '{'  controlLocalDeclarations  APPLY  controlBody  '}' ;

controlTypeDeclaration
locals [ ControlTypeDeclarationContextExt extendedContext ]
: optAnnotations  CONTROL  name  optTypeParameters  '('  parameterList  ')' ;

controlLocalDeclarations
locals [ ControlLocalDeclarationsContextExt extendedContext ]
: controlLocalDeclaration* ;

controlLocalDeclaration
locals [ ControlLocalDeclarationContextExt extendedContext ]
: constantDeclaration 
|  actionDeclaration 
|  tableDeclaration 
|  instantiation 
|  variableDeclaration ;

controlBody
locals [ ControlBodyContextExt extendedContext ]
: blockStatement ;

externDeclaration
locals [ ExternDeclarationContextExt extendedContext ]
: optAnnotations  EXTERN  nonTypeName  optTypeParameters  '{'  methodPrototypes  '}' 
|  optAnnotations  EXTERN  functionPrototype  ';' ;

methodPrototypes
locals [ MethodPrototypesContextExt extendedContext ]
: methodPrototype* ;

functionPrototype
locals [ FunctionPrototypeContextExt extendedContext ]
: typeOrVoid  name  optTypeParameters  '('  parameterList  ')' ;

methodPrototype
locals [ MethodPrototypeContextExt extendedContext ]
: functionPrototype  ';' 
|  ABSTRACT  functionPrototype  ';' 
|  IDENTIFIER  '('  parameterList  ')'  ';' ;

typeRef
locals [ TypeRefContextExt extendedContext ]
: baseType 
|  typeName 
|  specializedType 
|  headerStackType 
|  tupleType ;

prefixedType
locals [ PrefixedTypeContextExt extendedContext ]
: IDENTIFIER 
|  T_ERROR 
|  dotPrefix  IDENTIFIER ;

typeName
locals [ TypeNameContextExt extendedContext ]
: prefixedType ;

tupleType
locals [ TupleTypeContextExt extendedContext ]
: TUPLE  '<'  typeArgumentList  '>' ;

headerStackType
locals [ HeaderStackTypeContextExt extendedContext ]
: typeName  '['  expression  ']' ;

specializedType
locals [ SpecializedTypeContextExt extendedContext ]
: typeName  '<'  typeArgumentList  '>' ;

baseType
locals [ BaseTypeContextExt extendedContext ]
: BOOL 
|  BIT 
|  BIT  '<'  number  '>' 
|  INT  '<'  number  '>' 
|  VARBIT  '<'  number  '>' ;

typeOrVoid
locals [ TypeOrVoidContextExt extendedContext ]
: typeRef 
|  VOID 
|  nonTypeName ;

optTypeParameters
locals [ OptTypeParametersContextExt extendedContext ]
:(  '<'  typeParameterList  '>'  )? ;

typeParameterList
locals [ TypeParameterListContextExt extendedContext ]
: name 
|  typeParameterList  ','  name ;

typeArg
locals [ TypeArgContextExt extendedContext ]
: typeRef 
|  DONTCARE ;

typeArgumentList
locals [ TypeArgumentListContextExt extendedContext ]
: typeArg 
|  typeArgumentList  ','  typeArg ;

typeDeclaration
locals [ TypeDeclarationContextExt extendedContext ]
: derivedTypeDeclaration 
|  typedefDeclaration  ';' 
|  parserTypeDeclaration  ';' 
|  controlTypeDeclaration  ';' 
|  packageTypeDeclaration  ';' ;

derivedTypeDeclaration
locals [ DerivedTypeDeclarationContextExt extendedContext ]
: headerTypeDeclaration 
|  headerUnionDeclaration 
|  structTypeDeclaration 
|  enumDeclaration ;

headerTypeDeclaration
locals [ HeaderTypeDeclarationContextExt extendedContext ]
: optAnnotations  HEADER  name  '{'  structFieldList  '}' ;

structTypeDeclaration
locals [ StructTypeDeclarationContextExt extendedContext ]
: optAnnotations  STRUCT  name  '{'  structFieldList  '}' ;

headerUnionDeclaration
locals [ HeaderUnionDeclarationContextExt extendedContext ]
: optAnnotations  HEADER_UNION  name  '{'  structFieldList  '}' ;

structFieldList
locals [ StructFieldListContextExt extendedContext ]
: structField* ;

structField
locals [ StructFieldContextExt extendedContext ]
: optAnnotations  typeRef  name  ';' ;

enumDeclaration
locals [ EnumDeclarationContextExt extendedContext ]
: optAnnotations  ENUM  name  '{'  identifierList  '}' ;

errorDeclaration
locals [ ErrorDeclarationContextExt extendedContext ]
: T_ERROR  '{'  identifierList  '}' ;

matchKindDeclaration
locals [ MatchKindDeclarationContextExt extendedContext ]
: MATCH_KIND  '{'  identifierList  '}' ;

identifierList
locals [ IdentifierListContextExt extendedContext ]
: name 
|  identifierList  ','  name ;

typedefDeclaration
locals [ TypedefDeclarationContextExt extendedContext ]
: annotations  TYPEDEF  typeRef  name 
|  TYPEDEF  typeRef  name 
|  annotations  TYPEDEF  derivedTypeDeclaration  name 
|  TYPEDEF  derivedTypeDeclaration  name ;

assignmentOrMethodCallStatement
locals [ AssignmentOrMethodCallStatementContextExt extendedContext ]
: lvalue  '('  argumentList  ')'  ';' 
|  lvalue  '<'  typeArgumentList  '>'  '('  argumentList  ')'  ';' 
|  lvalue  '='  expression  ';' ;

emptyStatement
locals [ EmptyStatementContextExt extendedContext ]
: ';' ;

exitStatement
locals [ ExitStatementContextExt extendedContext ]
: EXIT  ';' ;

returnStatement
locals [ ReturnStatementContextExt extendedContext ]
: RETURN  ';' 
|  RETURN  expression  ';' ;

conditionalStatement
locals [ ConditionalStatementContextExt extendedContext ]
: IF  '('  expression  ')'  statement 
|  IF  '('  expression  ')'  statement  ELSE  statement ;

statement
locals [ StatementContextExt extendedContext ]
: assignmentOrMethodCallStatement 
|  conditionalStatement 
|  emptyStatement 
|  blockStatement 
|  returnStatement 
|  exitStatement 
|  switchStatement ;

blockStatement
locals [ BlockStatementContextExt extendedContext ]
: optAnnotations  '{'  statOrDeclList  '}' ;

statOrDeclList
locals [ StatOrDeclListContextExt extendedContext ]
: statementOrDeclaration* ;

switchStatement
locals [ SwitchStatementContextExt extendedContext ]
: SWITCH  '('  expression  ')'  '{'  switchCases  '}' ;

switchCases
locals [ SwitchCasesContextExt extendedContext ]
: switchCase* ;

switchCase
locals [ SwitchCaseContextExt extendedContext ]
: switchLabel  ':'  blockStatement 
|  switchLabel  ':' ;

switchLabel
locals [ SwitchLabelContextExt extendedContext ]
: name 
|  DEFAULT ;

statementOrDeclaration
locals [ StatementOrDeclarationContextExt extendedContext ]
: variableDeclaration 
|  constantDeclaration 
|  statement 
|  instantiation ;

tableDeclaration
locals [ TableDeclarationContextExt extendedContext ]
: optAnnotations  TABLE  name  '('  parameterList  ')'  '{'  tablePropertyList  '}' 
|  optAnnotations  TABLE  name  '{'  tablePropertyList  '}' ;

tablePropertyList
locals [ TablePropertyListContextExt extendedContext ]
: tableProperty 
|  tablePropertyList  tableProperty ;

tableProperty
locals [ TablePropertyContextExt extendedContext ]
: KEY  '='  '{'  keyElementList  '}' 
|  ACTIONS  '='  '{'  actionList  '}' 
|  optAnnotations  CONST  IDENTIFIER  '='  initializer  ';' 
|  optAnnotations  IDENTIFIER  '='  initializer  ';' ;

keyElementList
locals [ KeyElementListContextExt extendedContext ]
: keyElement* ;

keyElement
locals [ KeyElementContextExt extendedContext ]
: expression  ':'  name  optAnnotations  ';' ;

actionList
locals [ ActionListContextExt extendedContext ]
: actionRef  ';' 
|  actionList  actionRef  ';' ;

actionRef
locals [ ActionRefContextExt extendedContext ]
: optAnnotations  name 
|  optAnnotations  name  '('  argumentList  ')' ;

actionDeclaration
locals [ ActionDeclarationContextExt extendedContext ]
: optAnnotations  ACTION  name  '('  parameterList  ')'  blockStatement ;

variableDeclaration
locals [ VariableDeclarationContextExt extendedContext ]
: annotations  typeRef  name  optInitializer  ';' 
|  typeRef  name  optInitializer  ';' ;

constantDeclaration
locals [ ConstantDeclarationContextExt extendedContext ]
: optAnnotations  CONST  typeRef  name  '='  initializer  ';' ;

optInitializer
locals [ OptInitializerContextExt extendedContext ]
:(  '='  initializer  )? ;

initializer
locals [ InitializerContextExt extendedContext ]
: expression ;

functionDeclaration
locals [ FunctionDeclarationContextExt extendedContext ]
: functionPrototype  blockStatement ;

argumentList
locals [ ArgumentListContextExt extendedContext ]
:(  nonEmptyArgList  )? ;

nonEmptyArgList
locals [ NonEmptyArgListContextExt extendedContext ]
: argument 
|  nonEmptyArgList  ','  argument ;

argument
locals [ ArgumentContextExt extendedContext ]
: expression ;

expressionList
locals [ ExpressionListContextExt extendedContext ]
: expression 
|  expressionList  ','  expression ;

prefixedNonTypeName
locals [ PrefixedNonTypeNameContextExt extendedContext ]
: nonTypeName 
|  dotPrefix  nonTypeName ;

lvalue
locals [ LvalueContextExt extendedContext ]
: prefixedNonTypeName 
|  THIS 
|  lvalue  '.'  name 
|  lvalue  '['  expression  ']' 
|  lvalue  '['  expression  ':'  expression  ']' ;

expression
locals [ ExpressionContextExt extendedContext ]
: number 
|  STRING 
|  TRUE 
|  FALSE 
|  THIS 
|  nonTypeName 
|  '.'  nonTypeName 
|  expression  '['  expression  ']' 
|  expression  '['  expression  ':'  expression  ']' 
|  '{'  expressionList  '}' 
|  '('  expression  ')' 
|  '!'  expression 
|  '~'  expression 
|  '-'  expression 
|  '+'  expression 
|  typeName  '.'  name 
|  T_ERROR  '.'  name 
|  expression  '.'  name 
|  expression  '*'  expression 
|  expression  '/'  expression 
|  expression  '%'  expression 
|  expression  '+'  expression 
|  expression  '-'  expression 
|  expression  SHL  expression 
|  expression  '>'  '>'  expression 
|  expression  LE  expression 
|  expression  GE  expression 
|  expression  '<'  expression 
|  expression  '>'  expression 
|  expression  NE  expression 
|  expression  EQ  expression 
|  expression  '&'  expression 
|  expression  '^'  expression 
|  expression  '|'  expression 
|  expression  PP  expression 
|  expression  AND  expression 
|  expression  OR  expression 
|  expression  '?'  expression  ':'  expression 
|  expression  '<'  typeArgumentList  '>'  '('  argumentList  ')' 
|  expression  '('  argumentList  ')' 
|  typeRef  '('  argumentList  ')' 
|  '('  typeRef  ')'  expression ;

number
locals [ NumberContextExt extendedContext ]
: Decimal_number 
|  Octal_number 
|  Binary_number 
|  Hex_number 
|  Real_number ;



Hex_number : '0'[xX][0-9a-fA-F_]+ | [0-9]+[ws]'0'[xX][0-9a-fA-F_]+;
Decimal_number : '0'[dD][0-9_]+ | [0-9]+[ws]'0'[dD][0-9_]+;
Octal_number : '0'[oO][0-7_]+ | [0-9]+[ws]'0'[oO][0-7_]+;
Binary_number : '0'[bB][01_]+ | [0-9]+[ws]'0'[bB][01_]+;
Real_number : [0-9][0-9_]* | [0-9]+[ws][0-9_]+ ;

/*Real_number
  :   Unsigned_number '.' Unsigned_number
  |   Unsigned_number ( '.' Unsigned_number )? [eE] ( [+-] )? Unsigned_number
  ;
Hex_number : ( Size )? Hex_base Hex_value ;
Decimal_number
:   Unsigned_number
| ( Size )? Decimal_base Unsigned_number
| ( Size )? Decimal_base X_digit ( '_' )*
| ( Size )? Decimal_base Z_digit ( '_' )*
;

Binary_number : ( Size )? Binary_base Binary_value ;
Octal_number : ( Size )? Octal_base Octal_value ;

fragment
X_digit : '0'[xX]|[xX];
fragment
Sign : [+-] ;
fragment
Size : Non_zero_unsigned_number ;
fragment
Non_zero_unsigned_number : Non_zero_decimal_digit ( '_' | Decimal_digit )* ;
fragment
Unsigned_number : Decimal_digit ( '_' | Decimal_digit )* ;
fragment
Binary_value : Binary_digit ( '_' | Binary_digit )* ;
fragment
Octal_value : Octal_digit ( '_' | Octal_digit )* ;
fragment
Hex_value : Hex_digit ( '_' | Hex_digit )* ;
fragment
Decimal_base : '\'' [sS]? [dD] ;
fragment
Binary_base : '\''  [sS]? [bB] ;
fragment
Octal_base : '\'' [sS]? [oO] ;
fragment
Hex_base : '\'' [sS]? [hH] ;
fragment
Non_zero_decimal_digit : [1-9] ;
fragment
Decimal_digit : [0-9] | W_digit;
fragment
Binary_digit :   X_digit | Z_digit | W_digit | [01] ;
fragment
Octal_digit : X_digit | Z_digit | W_digit | [0-7] ;
fragment
Hex_digit :  X_digit | Z_digit | W_digit | [0-9a-fA-F] ;
fragment
W_digit : [wW];
fragment
Z_digit : [z_X: X_digit|Z_digit];



Zero_Or_One: [01];

EDGE_SPEC:
'01'|'10';

 */




COMMENT
:   ('//' ~('\n'|'\r')* '\r'? '\n' 
        |   '/*' .*? '*/' )-> channel(HIDDEN)
;

WS  :   [ \t\n\r]+ -> channel(HIDDEN)
    ;


STRING : '"' ( ~[\n\r"] )* '"' ;

ABSTRACT : 'abstract';
ACTION : 'action';
ACTIONS : 'actions';
APPLY : 'apply';
BOOL : 'bool';
BIT : 'bit';
CONST : 'const';
CONTROL : 'control';
DEFAULT : 'default';
ELSE : 'else';
ENUM : 'enum';
T_ERROR : 'error' ;
EXIT : 'exit';
EXTERN : 'extern';
FALSE : 'false';
HEADER : 'header';
HEADER_UNION : 'header_union';
IF : 'if';
IN : 'in';
INOUT : 'inout';
INT : 'int';
KEY : 'key';
MATCH_KIND : 'match_kind';
OUT : 'out';
PARSER : 'parser';
PACKAGE : 'package';
RETURN : 'return';
SELECT : 'select';
STATE : 'state';
STRUCT : 'struct';
SWITCH : 'switch';
TABLE : 'table';
THIS : 'this';
TRANSITION : 'transition';
TRUE : 'true';
TUPLE : 'tuple';
TYPEDEF : 'typedef';
VARBIT : 'varbit';
VOID : 'void';
DONTCARE : '_';
IDENTIFIER : [A-Za-z_][A-Za-z0-9_]*;





MASK : '&&&' ;
RANGE : '..';
SHL : '<<';
AND : '&&' ;
OR : '||';
EQ : '==';
NE : '!=';
GE : '>=';
LE : '<=';
PP : '++';



