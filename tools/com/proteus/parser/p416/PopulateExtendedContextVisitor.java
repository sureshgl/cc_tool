package com.proteus.parser.p416;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.ext.*;
import com.proteus.parser.p416.gen.p416BaseVisitor;
import com.proteus.parser.p416.gen.p416Parser;


public class PopulateExtendedContextVisitor extends p416BaseVisitor<ParserRuleContext> {

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInput(p416Parser.InputContext ctx) {
		super.visitInput(ctx);
		ctx.extendedContext = new InputContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclaration(p416Parser.DeclarationContext ctx) {
		super.visitDeclaration(ctx);
		ctx.extendedContext = new DeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitNonTypeName(p416Parser.NonTypeNameContext ctx) {
		super.visitNonTypeName(ctx);
		ctx.extendedContext = new NonTypeNameContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitName(p416Parser.NameContext ctx) {
		super.visitName(ctx);
		ctx.extendedContext = new NameContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitOptAnnotations(p416Parser.OptAnnotationsContext ctx) {
		super.visitOptAnnotations(ctx);
		ctx.extendedContext = new OptAnnotationsContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAnnotations(p416Parser.AnnotationsContext ctx) {
		super.visitAnnotations(ctx);
		ctx.extendedContext = new AnnotationsContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAnnotation(p416Parser.AnnotationContext ctx) {
		super.visitAnnotation(ctx);
		ctx.extendedContext = new AnnotationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterList(p416Parser.ParameterListContext ctx) {
		super.visitParameterList(ctx);
		ctx.extendedContext = new ParameterListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitNonEmptyParameterList(p416Parser.NonEmptyParameterListContext ctx) {
		super.visitNonEmptyParameterList(ctx);
		ctx.extendedContext = new NonEmptyParameterListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameter(p416Parser.ParameterContext ctx) {
		super.visitParameter(ctx);
		ctx.extendedContext = new ParameterContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDirection(p416Parser.DirectionContext ctx) {
		super.visitDirection(ctx);
		ctx.extendedContext = new DirectionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPackageTypeDeclaration(p416Parser.PackageTypeDeclarationContext ctx) {
		super.visitPackageTypeDeclaration(ctx);
		ctx.extendedContext = new PackageTypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInstantiation(p416Parser.InstantiationContext ctx) {
		super.visitInstantiation(ctx);
		ctx.extendedContext = new InstantiationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitObjInitializer(p416Parser.ObjInitializerContext ctx) {
		super.visitObjInitializer(ctx);
		ctx.extendedContext = new ObjInitializerContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitObjDeclarations(p416Parser.ObjDeclarationsContext ctx) {
		super.visitObjDeclarations(ctx);
		ctx.extendedContext = new ObjDeclarationsContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitObjDeclaration(p416Parser.ObjDeclarationContext ctx) {
		super.visitObjDeclaration(ctx);
		ctx.extendedContext = new ObjDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitOptConstructorParameters(p416Parser.OptConstructorParametersContext ctx) {
		super.visitOptConstructorParameters(ctx);
		ctx.extendedContext = new OptConstructorParametersContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDotPrefix(p416Parser.DotPrefixContext ctx) {
		super.visitDotPrefix(ctx);
		ctx.extendedContext = new DotPrefixContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserDeclaration(p416Parser.ParserDeclarationContext ctx) {
		super.visitParserDeclaration(ctx);
		ctx.extendedContext = new ParserDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserLocalElements(p416Parser.ParserLocalElementsContext ctx) {
		super.visitParserLocalElements(ctx);
		ctx.extendedContext = new ParserLocalElementsContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserLocalElement(p416Parser.ParserLocalElementContext ctx) {
		super.visitParserLocalElement(ctx);
		ctx.extendedContext = new ParserLocalElementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserTypeDeclaration(p416Parser.ParserTypeDeclarationContext ctx) {
		super.visitParserTypeDeclaration(ctx);
		ctx.extendedContext = new ParserTypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserStates(p416Parser.ParserStatesContext ctx) {
		super.visitParserStates(ctx);
		ctx.extendedContext = new ParserStatesContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserState(p416Parser.ParserStateContext ctx) {
		super.visitParserState(ctx);
		ctx.extendedContext = new ParserStateContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserStatements(p416Parser.ParserStatementsContext ctx) {
		super.visitParserStatements(ctx);
		ctx.extendedContext = new ParserStatementsContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserStatement(p416Parser.ParserStatementContext ctx) {
		super.visitParserStatement(ctx);
		ctx.extendedContext = new ParserStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParserBlockStatement(p416Parser.ParserBlockStatementContext ctx) {
		super.visitParserBlockStatement(ctx);
		ctx.extendedContext = new ParserBlockStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTransitionStatement(p416Parser.TransitionStatementContext ctx) {
		super.visitTransitionStatement(ctx);
		ctx.extendedContext = new TransitionStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStateExpression(p416Parser.StateExpressionContext ctx) {
		super.visitStateExpression(ctx);
		ctx.extendedContext = new StateExpressionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSelectExpression(p416Parser.SelectExpressionContext ctx) {
		super.visitSelectExpression(ctx);
		ctx.extendedContext = new SelectExpressionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSelectCaseList(p416Parser.SelectCaseListContext ctx) {
		super.visitSelectCaseList(ctx);
		ctx.extendedContext = new SelectCaseListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSelectCase(p416Parser.SelectCaseContext ctx) {
		super.visitSelectCase(ctx);
		ctx.extendedContext = new SelectCaseContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitKeysetExpression(p416Parser.KeysetExpressionContext ctx) {
		super.visitKeysetExpression(ctx);
		ctx.extendedContext = new KeysetExpressionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTupleKeysetExpression(p416Parser.TupleKeysetExpressionContext ctx) {
		super.visitTupleKeysetExpression(ctx);
		ctx.extendedContext = new TupleKeysetExpressionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSimpleExpressionList(p416Parser.SimpleExpressionListContext ctx) {
		super.visitSimpleExpressionList(ctx);
		ctx.extendedContext = new SimpleExpressionListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSimpleKeysetExpression(p416Parser.SimpleKeysetExpressionContext ctx) {
		super.visitSimpleKeysetExpression(ctx);
		ctx.extendedContext = new SimpleKeysetExpressionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitControlDeclaration(p416Parser.ControlDeclarationContext ctx) {
		super.visitControlDeclaration(ctx);
		ctx.extendedContext = new ControlDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitControlTypeDeclaration(p416Parser.ControlTypeDeclarationContext ctx) {
		super.visitControlTypeDeclaration(ctx);
		ctx.extendedContext = new ControlTypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitControlLocalDeclarations(p416Parser.ControlLocalDeclarationsContext ctx) {
		super.visitControlLocalDeclarations(ctx);
		ctx.extendedContext = new ControlLocalDeclarationsContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitControlLocalDeclaration(p416Parser.ControlLocalDeclarationContext ctx) {
		super.visitControlLocalDeclaration(ctx);
		ctx.extendedContext = new ControlLocalDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitControlBody(p416Parser.ControlBodyContext ctx) {
		super.visitControlBody(ctx);
		ctx.extendedContext = new ControlBodyContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExternDeclaration(p416Parser.ExternDeclarationContext ctx) {
		super.visitExternDeclaration(ctx);
		ctx.extendedContext = new ExternDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitMethodPrototypes(p416Parser.MethodPrototypesContext ctx) {
		super.visitMethodPrototypes(ctx);
		ctx.extendedContext = new MethodPrototypesContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitFunctionPrototype(p416Parser.FunctionPrototypeContext ctx) {
		super.visitFunctionPrototype(ctx);
		ctx.extendedContext = new FunctionPrototypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitMethodPrototype(p416Parser.MethodPrototypeContext ctx) {
		super.visitMethodPrototype(ctx);
		ctx.extendedContext = new MethodPrototypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeRef(p416Parser.TypeRefContext ctx) {
		super.visitTypeRef(ctx);
		ctx.extendedContext = new TypeRefContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPrefixedType(p416Parser.PrefixedTypeContext ctx) {
		super.visitPrefixedType(ctx);
		ctx.extendedContext = new PrefixedTypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeName(p416Parser.TypeNameContext ctx) {
		super.visitTypeName(ctx);
		ctx.extendedContext = new TypeNameContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTupleType(p416Parser.TupleTypeContext ctx) {
		super.visitTupleType(ctx);
		ctx.extendedContext = new TupleTypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitHeaderStackType(p416Parser.HeaderStackTypeContext ctx) {
		super.visitHeaderStackType(ctx);
		ctx.extendedContext = new HeaderStackTypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSpecializedType(p416Parser.SpecializedTypeContext ctx) {
		super.visitSpecializedType(ctx);
		ctx.extendedContext = new SpecializedTypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitBaseType(p416Parser.BaseTypeContext ctx) {
		super.visitBaseType(ctx);
		ctx.extendedContext = new BaseTypeContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeOrVoid(p416Parser.TypeOrVoidContext ctx) {
		super.visitTypeOrVoid(ctx);
		ctx.extendedContext = new TypeOrVoidContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitOptTypeParameters(p416Parser.OptTypeParametersContext ctx) {
		super.visitOptTypeParameters(ctx);
		ctx.extendedContext = new OptTypeParametersContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeParameterList(p416Parser.TypeParameterListContext ctx) {
		super.visitTypeParameterList(ctx);
		ctx.extendedContext = new TypeParameterListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeArg(p416Parser.TypeArgContext ctx) {
		super.visitTypeArg(ctx);
		ctx.extendedContext = new TypeArgContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeArgumentList(p416Parser.TypeArgumentListContext ctx) {
		super.visitTypeArgumentList(ctx);
		ctx.extendedContext = new TypeArgumentListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeDeclaration(p416Parser.TypeDeclarationContext ctx) {
		super.visitTypeDeclaration(ctx);
		ctx.extendedContext = new TypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDerivedTypeDeclaration(p416Parser.DerivedTypeDeclarationContext ctx) {
		super.visitDerivedTypeDeclaration(ctx);
		ctx.extendedContext = new DerivedTypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitHeaderTypeDeclaration(p416Parser.HeaderTypeDeclarationContext ctx) {
		super.visitHeaderTypeDeclaration(ctx);
		ctx.extendedContext = new HeaderTypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructTypeDeclaration(p416Parser.StructTypeDeclarationContext ctx) {
		super.visitStructTypeDeclaration(ctx);
		ctx.extendedContext = new StructTypeDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitHeaderUnionDeclaration(p416Parser.HeaderUnionDeclarationContext ctx) {
		super.visitHeaderUnionDeclaration(ctx);
		ctx.extendedContext = new HeaderUnionDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructFieldList(p416Parser.StructFieldListContext ctx) {
		super.visitStructFieldList(ctx);
		ctx.extendedContext = new StructFieldListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructField(p416Parser.StructFieldContext ctx) {
		super.visitStructField(ctx);
		ctx.extendedContext = new StructFieldContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumDeclaration(p416Parser.EnumDeclarationContext ctx) {
		super.visitEnumDeclaration(ctx);
		ctx.extendedContext = new EnumDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitErrorDeclaration(p416Parser.ErrorDeclarationContext ctx) {
		super.visitErrorDeclaration(ctx);
		ctx.extendedContext = new ErrorDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitMatchKindDeclaration(p416Parser.MatchKindDeclarationContext ctx) {
		super.visitMatchKindDeclaration(ctx);
		ctx.extendedContext = new MatchKindDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitIdentifierList(p416Parser.IdentifierListContext ctx) {
		super.visitIdentifierList(ctx);
		ctx.extendedContext = new IdentifierListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypedefDeclaration(p416Parser.TypedefDeclarationContext ctx) {
		super.visitTypedefDeclaration(ctx);
		ctx.extendedContext = new TypedefDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAssignmentOrMethodCallStatement(p416Parser.AssignmentOrMethodCallStatementContext ctx) {
		super.visitAssignmentOrMethodCallStatement(ctx);
		ctx.extendedContext = new AssignmentOrMethodCallStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEmptyStatement(p416Parser.EmptyStatementContext ctx) {
		super.visitEmptyStatement(ctx);
		ctx.extendedContext = new EmptyStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExitStatement(p416Parser.ExitStatementContext ctx) {
		super.visitExitStatement(ctx);
		ctx.extendedContext = new ExitStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitReturnStatement(p416Parser.ReturnStatementContext ctx) {
		super.visitReturnStatement(ctx);
		ctx.extendedContext = new ReturnStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitConditionalStatement(p416Parser.ConditionalStatementContext ctx) {
		super.visitConditionalStatement(ctx);
		ctx.extendedContext = new ConditionalStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatement(p416Parser.StatementContext ctx) {
		super.visitStatement(ctx);
		ctx.extendedContext = new StatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitBlockStatement(p416Parser.BlockStatementContext ctx) {
		super.visitBlockStatement(ctx);
		ctx.extendedContext = new BlockStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatOrDeclList(p416Parser.StatOrDeclListContext ctx) {
		super.visitStatOrDeclList(ctx);
		ctx.extendedContext = new StatOrDeclListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSwitchStatement(p416Parser.SwitchStatementContext ctx) {
		super.visitSwitchStatement(ctx);
		ctx.extendedContext = new SwitchStatementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSwitchCases(p416Parser.SwitchCasesContext ctx) {
		super.visitSwitchCases(ctx);
		ctx.extendedContext = new SwitchCasesContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSwitchCase(p416Parser.SwitchCaseContext ctx) {
		super.visitSwitchCase(ctx);
		ctx.extendedContext = new SwitchCaseContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSwitchLabel(p416Parser.SwitchLabelContext ctx) {
		super.visitSwitchLabel(ctx);
		ctx.extendedContext = new SwitchLabelContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatementOrDeclaration(p416Parser.StatementOrDeclarationContext ctx) {
		super.visitStatementOrDeclaration(ctx);
		ctx.extendedContext = new StatementOrDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTableDeclaration(p416Parser.TableDeclarationContext ctx) {
		super.visitTableDeclaration(ctx);
		ctx.extendedContext = new TableDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTablePropertyList(p416Parser.TablePropertyListContext ctx) {
		super.visitTablePropertyList(ctx);
		ctx.extendedContext = new TablePropertyListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTableProperty(p416Parser.TablePropertyContext ctx) {
		super.visitTableProperty(ctx);
		ctx.extendedContext = new TablePropertyContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitKeyElementList(p416Parser.KeyElementListContext ctx) {
		super.visitKeyElementList(ctx);
		ctx.extendedContext = new KeyElementListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitKeyElement(p416Parser.KeyElementContext ctx) {
		super.visitKeyElement(ctx);
		ctx.extendedContext = new KeyElementContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitActionList(p416Parser.ActionListContext ctx) {
		super.visitActionList(ctx);
		ctx.extendedContext = new ActionListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitActionRef(p416Parser.ActionRefContext ctx) {
		super.visitActionRef(ctx);
		ctx.extendedContext = new ActionRefContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitActionDeclaration(p416Parser.ActionDeclarationContext ctx) {
		super.visitActionDeclaration(ctx);
		ctx.extendedContext = new ActionDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitVariableDeclaration(p416Parser.VariableDeclarationContext ctx) {
		super.visitVariableDeclaration(ctx);
		ctx.extendedContext = new VariableDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitConstantDeclaration(p416Parser.ConstantDeclarationContext ctx) {
		super.visitConstantDeclaration(ctx);
		ctx.extendedContext = new ConstantDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitOptInitializer(p416Parser.OptInitializerContext ctx) {
		super.visitOptInitializer(ctx);
		ctx.extendedContext = new OptInitializerContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitializer(p416Parser.InitializerContext ctx) {
		super.visitInitializer(ctx);
		ctx.extendedContext = new InitializerContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitFunctionDeclaration(p416Parser.FunctionDeclarationContext ctx) {
		super.visitFunctionDeclaration(ctx);
		ctx.extendedContext = new FunctionDeclarationContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitArgumentList(p416Parser.ArgumentListContext ctx) {
		super.visitArgumentList(ctx);
		ctx.extendedContext = new ArgumentListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitNonEmptyArgList(p416Parser.NonEmptyArgListContext ctx) {
		super.visitNonEmptyArgList(ctx);
		ctx.extendedContext = new NonEmptyArgListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitArgument(p416Parser.ArgumentContext ctx) {
		super.visitArgument(ctx);
		ctx.extendedContext = new ArgumentContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExpressionList(p416Parser.ExpressionListContext ctx) {
		super.visitExpressionList(ctx);
		ctx.extendedContext = new ExpressionListContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPrefixedNonTypeName(p416Parser.PrefixedNonTypeNameContext ctx) {
		super.visitPrefixedNonTypeName(ctx);
		ctx.extendedContext = new PrefixedNonTypeNameContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLvalue(p416Parser.LvalueContext ctx) {
		super.visitLvalue(ctx);
		ctx.extendedContext = new LvalueContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExpression(p416Parser.ExpressionContext ctx) {
		super.visitExpression(ctx);
		ctx.extendedContext = new ExpressionContextExt(ctx);return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitNumber(p416Parser.NumberContext ctx) {
		super.visitNumber(ctx);
		ctx.extendedContext = new NumberContextExt(ctx);return ctx;
	}
}
