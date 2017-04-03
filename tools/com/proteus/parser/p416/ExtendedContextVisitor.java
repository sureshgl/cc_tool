package com.proteus.parser.p416;

import com.proteus.parser.p416.ext.AbstractBaseExt;
import com.proteus.parser.p416.gen.p416BaseVisitor;
import com.proteus.parser.p416.gen.p416Parser;


public class ExtendedContextVisitor extends p416BaseVisitor<AbstractBaseExt>{
	
	@Override public AbstractBaseExt visitInput(p416Parser.InputContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitDeclaration(p416Parser.DeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitNonTypeName(p416Parser.NonTypeNameContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitName(p416Parser.NameContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitOptAnnotations(p416Parser.OptAnnotationsContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitAnnotations(p416Parser.AnnotationsContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitAnnotation(p416Parser.AnnotationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParameterList(p416Parser.ParameterListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitNonEmptyParameterList(p416Parser.NonEmptyParameterListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParameter(p416Parser.ParameterContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitDirection(p416Parser.DirectionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitPackageTypeDeclaration(p416Parser.PackageTypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitInstantiation(p416Parser.InstantiationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitObjInitializer(p416Parser.ObjInitializerContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitObjDeclarations(p416Parser.ObjDeclarationsContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitObjDeclaration(p416Parser.ObjDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitOptConstructorParameters(p416Parser.OptConstructorParametersContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitDotPrefix(p416Parser.DotPrefixContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserDeclaration(p416Parser.ParserDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserLocalElements(p416Parser.ParserLocalElementsContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserLocalElement(p416Parser.ParserLocalElementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserTypeDeclaration(p416Parser.ParserTypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserStates(p416Parser.ParserStatesContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserState(p416Parser.ParserStateContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserStatements(p416Parser.ParserStatementsContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserStatement(p416Parser.ParserStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitParserBlockStatement(p416Parser.ParserBlockStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTransitionStatement(p416Parser.TransitionStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStateExpression(p416Parser.StateExpressionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSelectExpression(p416Parser.SelectExpressionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSelectCaseList(p416Parser.SelectCaseListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSelectCase(p416Parser.SelectCaseContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitKeysetExpression(p416Parser.KeysetExpressionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTupleKeysetExpression(p416Parser.TupleKeysetExpressionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSimpleExpressionList(p416Parser.SimpleExpressionListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSimpleKeysetExpression(p416Parser.SimpleKeysetExpressionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitControlDeclaration(p416Parser.ControlDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitControlTypeDeclaration(p416Parser.ControlTypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitControlLocalDeclarations(p416Parser.ControlLocalDeclarationsContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitControlLocalDeclaration(p416Parser.ControlLocalDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitControlBody(p416Parser.ControlBodyContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitExternDeclaration(p416Parser.ExternDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitMethodPrototypes(p416Parser.MethodPrototypesContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitFunctionPrototype(p416Parser.FunctionPrototypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitMethodPrototype(p416Parser.MethodPrototypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeRef(p416Parser.TypeRefContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitPrefixedType(p416Parser.PrefixedTypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeName(p416Parser.TypeNameContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTupleType(p416Parser.TupleTypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitHeaderStackType(p416Parser.HeaderStackTypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSpecializedType(p416Parser.SpecializedTypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitBaseType(p416Parser.BaseTypeContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeOrVoid(p416Parser.TypeOrVoidContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitOptTypeParameters(p416Parser.OptTypeParametersContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeParameterList(p416Parser.TypeParameterListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeArg(p416Parser.TypeArgContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeArgumentList(p416Parser.TypeArgumentListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypeDeclaration(p416Parser.TypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitDerivedTypeDeclaration(p416Parser.DerivedTypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitHeaderTypeDeclaration(p416Parser.HeaderTypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStructTypeDeclaration(p416Parser.StructTypeDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitHeaderUnionDeclaration(p416Parser.HeaderUnionDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStructFieldList(p416Parser.StructFieldListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStructField(p416Parser.StructFieldContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitEnumDeclaration(p416Parser.EnumDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitErrorDeclaration(p416Parser.ErrorDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitMatchKindDeclaration(p416Parser.MatchKindDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitIdentifierList(p416Parser.IdentifierListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTypedefDeclaration(p416Parser.TypedefDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitAssignmentOrMethodCallStatement(p416Parser.AssignmentOrMethodCallStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitEmptyStatement(p416Parser.EmptyStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitExitStatement(p416Parser.ExitStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitReturnStatement(p416Parser.ReturnStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitConditionalStatement(p416Parser.ConditionalStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStatement(p416Parser.StatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitBlockStatement(p416Parser.BlockStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStatOrDeclList(p416Parser.StatOrDeclListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSwitchStatement(p416Parser.SwitchStatementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSwitchCases(p416Parser.SwitchCasesContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSwitchCase(p416Parser.SwitchCaseContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitSwitchLabel(p416Parser.SwitchLabelContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitStatementOrDeclaration(p416Parser.StatementOrDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTableDeclaration(p416Parser.TableDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTablePropertyList(p416Parser.TablePropertyListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitTableProperty(p416Parser.TablePropertyContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitKeyElementList(p416Parser.KeyElementListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitKeyElement(p416Parser.KeyElementContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitActionList(p416Parser.ActionListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitActionRef(p416Parser.ActionRefContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitActionDeclaration(p416Parser.ActionDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitVariableDeclaration(p416Parser.VariableDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitConstantDeclaration(p416Parser.ConstantDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitOptInitializer(p416Parser.OptInitializerContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitInitializer(p416Parser.InitializerContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitFunctionDeclaration(p416Parser.FunctionDeclarationContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitArgumentList(p416Parser.ArgumentListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitNonEmptyArgList(p416Parser.NonEmptyArgListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitArgument(p416Parser.ArgumentContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitExpressionList(p416Parser.ExpressionListContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitPrefixedNonTypeName(p416Parser.PrefixedNonTypeNameContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitLvalue(p416Parser.LvalueContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitExpression(p416Parser.ExpressionContext ctx) {return ctx.extendedContext;}

	@Override public AbstractBaseExt visitNumber(p416Parser.NumberContext ctx) {return ctx.extendedContext;}

	
}
