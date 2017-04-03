parser grammar CCoverageParser;

options {
	tokenVocab=CCoverageLexer;
}
@header{
        import com.proteus.parser.code_coverage.ext.*;
}
// parser rules must start with lower case.

@lexer::members {

    private boolean isPragma(){

        StringBuilder commentText = new StringBuilder();
        int ahead = 1;
        int next = _input.LA(ahead++);
        commentText.append((char)next);
        while(next != -1 && next != '\r' && next != '\n')
        {
            next = _input.LA(ahead++);
            commentText.append((char)next);
        }

        if(commentText.toString().trim().startsWith("pragma")) {
            return true;
        }
        else {
            // Let the lexer consume all the characters!
            for(int i = 0; i < commentText.length(); i++)
            {
                _input.consume();
            }
            return false;
        }
    }
}

primaryExpression
locals [ PrimaryExpressionContextExt extendedContext ]
: Identifier 
|  Constant 
|  StringLiteral+ 
|  LeftParen  expression  RightParen 
|  genericSelection 
|  Extension?  LeftParen  compoundStatement  RightParen 
|  Builtin_va_arg  LeftParen  unaryExpression  Comma  typeName  RightParen 
|  Builtin_offsetof  LeftParen  typeName  Comma  unaryExpression  RightParen ;

genericSelection
locals [ GenericSelectionContextExt extendedContext ]
: Generic  LeftParen  assignmentExpression  Comma  genericAssocList  RightParen ;

genericAssocList
locals [ GenericAssocListContextExt extendedContext ]
: genericAssociation 
|  genericAssocList  Comma  genericAssociation ;

genericAssociation
locals [ GenericAssociationContextExt extendedContext ]
: typeName  Colon  assignmentExpression 
|  Default  Colon  assignmentExpression ;

postfixExpression
locals [ PostfixExpressionContextExt extendedContext ]
: primaryExpression 
|  postfixExpression  LeftBracket  expression  RightBracket 
|  postfixExpression  LeftParen  argumentExpressionList?  RightParen 
|  postfixExpression  Dot  Identifier 
|  postfixExpression  Arrow  Identifier 
|  postfixExpression  PlusPlus 
|  postfixExpression  MinusMinus 
|  LeftParen  typeName  RightParen  LeftBrace  initializerList  RightBrace 
|  LeftParen  typeName  RightParen  LeftBrace  initializerList  Comma  RightBrace 
|  Extension  LeftParen  typeName  RightParen  LeftBrace  initializerList  RightBrace 
|  Extension  LeftParen  typeName  RightParen  LeftBrace  initializerList  Comma  RightBrace ;

argumentExpressionList
locals [ ArgumentExpressionListContextExt extendedContext ]
: assignmentExpression 
|  argumentExpressionList  Comma  assignmentExpression ;

unaryExpression
locals [ UnaryExpressionContextExt extendedContext ]
: postfixExpression 
|  PlusPlus  unaryExpression 
|  MinusMinus  unaryExpression 
|  unaryOperator  castExpression 
|  Sizeof  unaryExpression 
|  Sizeof  LeftParen  typeName  RightParen 
|  Alignof  LeftParen  typeName  RightParen 
|  AndAnd  Identifier ;

unaryOperator
locals [ UnaryOperatorContextExt extendedContext ]
: And 
|  Star 
|  Plus 
|  Minus 
|  Tilde 
|  Not ;

castExpression
locals [ CastExpressionContextExt extendedContext ]
: unaryExpression 
|  LeftParen  typeName  RightParen  castExpression 
|  Extension  LeftParen  typeName  RightParen  castExpression ;

multiplicativeExpression
locals [ MultiplicativeExpressionContextExt extendedContext ]
: castExpression 
|  multiplicativeExpression  Star  castExpression 
|  multiplicativeExpression  Div  castExpression 
|  multiplicativeExpression  Mod  castExpression ;

additiveExpression
locals [ AdditiveExpressionContextExt extendedContext ]
: multiplicativeExpression 
|  additiveExpression  Plus  multiplicativeExpression 
|  additiveExpression  Minus  multiplicativeExpression ;

shiftExpression
locals [ ShiftExpressionContextExt extendedContext ]
: additiveExpression 
|  shiftExpression  LeftShift  additiveExpression 
|  shiftExpression  RightShift  additiveExpression ;

relationalExpression
locals [ RelationalExpressionContextExt extendedContext ]
: shiftExpression 
|  relationalExpression  Less  shiftExpression 
|  relationalExpression  Greater  shiftExpression 
|  relationalExpression  LessEqual  shiftExpression 
|  relationalExpression  GreaterEqual  shiftExpression ;

equalityExpression
locals [ EqualityExpressionContextExt extendedContext ]
: relationalExpression 
|  equalityExpression  Equal  relationalExpression 
|  equalityExpression  NotEqual  relationalExpression ;

andExpression
locals [ AndExpressionContextExt extendedContext ]
: equalityExpression 
|  andExpression  And  equalityExpression ;

exclusiveOrExpression
locals [ ExclusiveOrExpressionContextExt extendedContext ]
: andExpression 
|  exclusiveOrExpression  Caret  andExpression ;

inclusiveOrExpression
locals [ InclusiveOrExpressionContextExt extendedContext ]
: exclusiveOrExpression 
|  inclusiveOrExpression  Or  exclusiveOrExpression ;

logicalAndExpression
locals [ LogicalAndExpressionContextExt extendedContext ]
: inclusiveOrExpression 
|  logicalAndExpression  AndAnd  inclusiveOrExpression ;

logicalOrExpression
locals [ LogicalOrExpressionContextExt extendedContext ]
: logicalAndExpression 
|  logicalOrExpression  OrOr  logicalAndExpression ;

conditionalExpression
locals [ ConditionalExpressionContextExt extendedContext ]
: logicalOrExpression (  Question  expression  Colon  conditionalExpression  )? ;

assignmentExpression
locals [ AssignmentExpressionContextExt extendedContext ]
: conditionalExpression 
|  unaryExpression  assignmentOperator  assignmentExpression ;

assignmentOperator
locals [ AssignmentOperatorContextExt extendedContext ]
: Assign 
|  StarAssign 
|  DivAssign 
|  ModAssign 
|  PlusAssign 
|  MinusAssign 
|  LeftShiftAssign 
|  RightShiftAssign 
|  AndAssign 
|  XorAssign 
|  OrAssign ;

expression
locals [ ExpressionContextExt extendedContext ]
: assignmentExpression 
|  expression  Comma  assignmentExpression ;

constantExpression
locals [ ConstantExpressionContextExt extendedContext ]
: conditionalExpression ;

declaration
locals [ DeclarationContextExt extendedContext ]
: declarationSpecifiers  initDeclaratorList?  Semi 
|  staticAssertDeclaration ;

declarationSpecifiers
locals [ DeclarationSpecifiersContextExt extendedContext ]
: declarationSpecifier+ ;

declarationSpecifiers2
locals [ DeclarationSpecifiers2ContextExt extendedContext ]
: declarationSpecifier+ ;

declarationSpecifier
locals [ DeclarationSpecifierContextExt extendedContext ]
: storageClassSpecifier 
|  typeSpecifier 
|  typeQualifier 
|  functionSpecifier 
|  alignmentSpecifier ;

initDeclaratorList
locals [ InitDeclaratorListContextExt extendedContext ]
: initDeclarator 
|  initDeclaratorList  Comma  initDeclarator ;

initDeclarator
locals [ InitDeclaratorContextExt extendedContext ]
: declarator 
|  declarator  Assign  initializer ;

storageClassSpecifier
locals [ StorageClassSpecifierContextExt extendedContext ]
: Typedef 
|  Extern 
|  Static 
|  ThreadLocal 
|  Auto 
|  Register ;

typeSpecifier
locals [ TypeSpecifierContextExt extendedContext ]
:(  Void 
| Char 
| Short 
| Int 
| Long 
| Float 
| Double 
| Signed 
| Unsigned 
| Bool 
| Complex 
| M128 
| M128d 
| M128i  )
|  Extension  LeftParen (  M128 
| M128d 
| M128i  ) RightParen 
|  atomicTypeSpecifier 
|  structOrUnionSpecifier 
|  enumSpecifier 
|  typedefName 
|  Typeof  LeftParen  constantExpression  RightParen ;

structOrUnionSpecifier
locals [ StructOrUnionSpecifierContextExt extendedContext ]
: structOrUnion  Identifier?  LeftBrace  structDeclarationList  RightBrace 
|  structOrUnion  Identifier ;

structOrUnion
locals [ StructOrUnionContextExt extendedContext ]
: Struct 
|  Union ;

structDeclarationList
locals [ StructDeclarationListContextExt extendedContext ]
: structDeclaration 
|  structDeclarationList  structDeclaration ;

structDeclaration
locals [ StructDeclarationContextExt extendedContext ]
: specifierQualifierList  structDeclaratorList?  Semi 
|  staticAssertDeclaration ;

specifierQualifierList
locals [ SpecifierQualifierListContextExt extendedContext ]
: typeSpecifier  specifierQualifierList? 
|  typeQualifier  specifierQualifierList? ;

structDeclaratorList
locals [ StructDeclaratorListContextExt extendedContext ]
: structDeclarator 
|  structDeclaratorList  Comma  structDeclarator ;

structDeclarator
locals [ StructDeclaratorContextExt extendedContext ]
: declarator 
|  declarator?  Colon  constantExpression ;

enumSpecifier
locals [ EnumSpecifierContextExt extendedContext ]
: Enum  Identifier?  LeftBrace  enumeratorList  RightBrace 
|  Enum  Identifier?  LeftBrace  enumeratorList  Comma  RightBrace 
|  Enum  Identifier ;

enumeratorList
locals [ EnumeratorListContextExt extendedContext ]
: enumerator 
|  enumeratorList  Comma  enumerator ;

enumerator
locals [ EnumeratorContextExt extendedContext ]
: enumerationConstant 
|  enumerationConstant  Assign  constantExpression ;

enumerationConstant
locals [ EnumerationConstantContextExt extendedContext ]
: Identifier ;

atomicTypeSpecifier
locals [ AtomicTypeSpecifierContextExt extendedContext ]
: Atomic  LeftParen  typeName  RightParen ;

typeQualifier
locals [ TypeQualifierContextExt extendedContext ]
: Const 
|  Restrict 
|  Volatile 
|  Atomic ;

functionSpecifier
locals [ FunctionSpecifierContextExt extendedContext ]
:(  Inline 
| Noreturn 
| Inline_ 
| Stdcall  )
|  gccAttributeSpecifier 
|  Declspec  LeftParen  Identifier  RightParen ;

alignmentSpecifier
locals [ AlignmentSpecifierContextExt extendedContext ]
: Alignas  LeftParen  typeName  RightParen 
|  Alignas  LeftParen  constantExpression  RightParen ;

declarator
locals [ DeclaratorContextExt extendedContext ]
: pointer?  directDeclarator  gccDeclaratorExtension* ;

directDeclarator
locals [ DirectDeclaratorContextExt extendedContext ]
: Identifier 
|  LeftParen  declarator  RightParen 
|  directDeclarator  LeftBracket  typeQualifierList?  assignmentExpression?  RightBracket 
|  directDeclarator  LeftBracket  Static  typeQualifierList?  assignmentExpression  RightBracket 
|  directDeclarator  LeftBracket  typeQualifierList  Static  assignmentExpression  RightBracket 
|  directDeclarator  LeftBracket  typeQualifierList?  Star  RightBracket 
|  directDeclarator  LeftParen  parameterTypeList  RightParen 
|  directDeclarator  LeftParen  identifierList?  RightParen ;

gccDeclaratorExtension
locals [ GccDeclaratorExtensionContextExt extendedContext ]
: Asm  LeftParen  StringLiteral+  RightParen 
|  gccAttributeSpecifier ;

gccAttributeSpecifier
locals [ GccAttributeSpecifierContextExt extendedContext ]
: Attribute  LeftParen  LeftParen  gccAttributeList  RightParen  RightParen ;

gccAttributeList
locals [ GccAttributeListContextExt extendedContext ]
: gccAttribute (  Comma  gccAttribute  )* 
| ;

gccAttribute
locals [ GccAttributeContextExt extendedContext ]
: ~(Comma|LeftParen|RightParen) (  LeftParen  argumentExpressionList?  RightParen  )? 
| ;

nestedParenthesesBlock
locals [ NestedParenthesesBlockContextExt extendedContext ]
:(  ~(LeftParen|RightParen) 
| LeftParen  nestedParenthesesBlock  RightParen  )* ;

pointer
locals [ PointerContextExt extendedContext ]
: Star  typeQualifierList? 
|  Star  typeQualifierList?  pointer 
|  Caret  typeQualifierList? 
|  Caret  typeQualifierList?  pointer ;

typeQualifierList
locals [ TypeQualifierListContextExt extendedContext ]
: typeQualifier 
|  typeQualifierList  typeQualifier ;

parameterTypeList
locals [ ParameterTypeListContextExt extendedContext ]
: parameterList 
|  parameterList  Comma  Ellipsis ;

parameterList
locals [ ParameterListContextExt extendedContext ]
: parameterDeclaration 
|  parameterList  Comma  parameterDeclaration ;

parameterDeclaration
locals [ ParameterDeclarationContextExt extendedContext ]
: declarationSpecifiers  declarator 
|  declarationSpecifiers2  abstractDeclarator? ;

identifierList
locals [ IdentifierListContextExt extendedContext ]
: Identifier 
|  identifierList  Comma  Identifier ;

typeName
locals [ TypeNameContextExt extendedContext ]
: specifierQualifierList  abstractDeclarator? ;

abstractDeclarator
locals [ AbstractDeclaratorContextExt extendedContext ]
: pointer 
|  pointer?  directAbstractDeclarator  gccDeclaratorExtension* ;

directAbstractDeclarator
locals [ DirectAbstractDeclaratorContextExt extendedContext ]
: LeftParen  abstractDeclarator  RightParen  gccDeclaratorExtension* 
|  LeftBracket  typeQualifierList?  assignmentExpression?  RightBracket 
|  LeftBracket  Static  typeQualifierList?  assignmentExpression  RightBracket 
|  LeftBracket  typeQualifierList  Static  assignmentExpression  RightBracket 
|  LeftBracket  Star  RightBracket 
|  LeftParen  parameterTypeList?  RightParen  gccDeclaratorExtension* 
|  directAbstractDeclarator  LeftBracket  typeQualifierList?  assignmentExpression?  RightBracket 
|  directAbstractDeclarator  LeftBracket  Static  typeQualifierList?  assignmentExpression  RightBracket 
|  directAbstractDeclarator  LeftBracket  typeQualifierList  Static  assignmentExpression  RightBracket 
|  directAbstractDeclarator  LeftBracket  Star  RightBracket 
|  directAbstractDeclarator  LeftParen  parameterTypeList?  RightParen  gccDeclaratorExtension* ;

typedefName
locals [ TypedefNameContextExt extendedContext ]
: Identifier ;

initializer
locals [ InitializerContextExt extendedContext ]
: assignmentExpression 
|  LeftBrace  initializerList  RightBrace 
|  LeftBrace  initializerList  Comma  RightBrace ;

initializerList
locals [ InitializerListContextExt extendedContext ]
: designation?  initializer 
|  initializerList  Comma  designation?  initializer ;

designation
locals [ DesignationContextExt extendedContext ]
: designatorList  Assign ;

designatorList
locals [ DesignatorListContextExt extendedContext ]
: designator 
|  designatorList  designator ;

designator
locals [ DesignatorContextExt extendedContext ]
: LeftBracket  constantExpression  RightBracket 
|  Dot  Identifier ;

staticAssertDeclaration
locals [ StaticAssertDeclarationContextExt extendedContext ]
: StaticAssert  LeftParen  constantExpression  Comma  StringLiteral+  RightParen  Semi ;

statement
locals [ StatementContextExt extendedContext ]
: (labeledStatement 
|  compoundStatement 
|  expressionStatement 
|  selectionStatement 
|  iterationStatement 
|  jumpStatement 
| (  Asm 
| Asm_  )(  Volatile 
| Volatile_  ) LeftParen (  logicalOrExpression (  Comma  logicalOrExpression  )*  )? (  Colon (  logicalOrExpression (  Comma  logicalOrExpression  )*  )?  )*  RightParen  Semi ) pragma_def?;

labeledStatement
locals [ LabeledStatementContextExt extendedContext ]
: Identifier  Colon  statement 
|  Case  constantExpression  Colon  statement 
|  Default  Colon  statement ;

compoundStatement
locals [ CompoundStatementContextExt extendedContext ]
: pragma_def? LeftBrace pragma_def? blockItemList?  RightBrace pragma_def?;

blockItemList
locals [ BlockItemListContextExt extendedContext ]
: blockItem 
|  blockItemList  blockItem ;

blockItem
locals [ BlockItemContextExt extendedContext ]
: declaration pragma_def?
|  statement;

expressionStatement
locals [ ExpressionStatementContextExt extendedContext ]
: expression?  Semi  pragma_def? ;

selectionStatement
locals [ SelectionStatementContextExt extendedContext ]
: If  LeftParen  expression  RightParen  statement (  Else  statement  )? 
|  Switch  LeftParen  expression  RightParen  statement ;

iterationStatement
locals [ IterationStatementContextExt extendedContext ]
: While  LeftParen  expression  RightParen  statement 
|  Do  statement  While  LeftParen  expression  RightParen  Semi 
|  For  LeftParen  expression?  Semi  expression?  Semi  expression?  RightParen  statement 
|  For  LeftParen  declaration  expression?  Semi  expression?  RightParen  statement ;

jumpStatement
locals [ JumpStatementContextExt extendedContext ]
: Goto  Identifier  Semi 
|  Continue  Semi 
|  Break  Semi 
|  Return  expression?  Semi 
|  Goto  unaryExpression  Semi ;

compilationUnit
locals [ CompilationUnitContextExt extendedContext ]
: translationUnit?  EOF ;

translationUnit
locals [ TranslationUnitContextExt extendedContext ]
: externalDeclaration 
|  translationUnit  externalDeclaration 
|  includeDirectives ;

includeDirectives
locals [ IncludeDirectivesContextExt extendedContext ]
: IncludeDirective*
;


externalDeclaration
locals [ ExternalDeclarationContextExt extendedContext ]
: functionDefinition pragma_def?
|  declaration pragma_def?
|  Semi ;

functionDefinition
locals [ FunctionDefinitionContextExt extendedContext ]
: declarationSpecifiers?  declarator  declarationList?  compoundStatement ;

declarationList
locals [ DeclarationListContextExt extendedContext ]
: declaration 
|  declarationList  declaration ;

pragma_def
locals [ Pragma_defContextExt extendedContext ]
: PRAGMA_SPECIFIER  pragma_text  NEW_LINE ;

pragma_text
locals [ Pragma_textContextExt extendedContext ]
: PRAGMALeftBracket  PRAGMADigit (  PRAGMAMinus  PRAGMADigit  )?  PRAGMARightBracket ;
