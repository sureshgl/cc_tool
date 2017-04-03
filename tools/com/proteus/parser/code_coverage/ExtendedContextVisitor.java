package com.proteus.parser.code_coverage;

import com.proteus.parser.code_coverage.ext.AbstractBaseExt;
import com.proteus.parser.code_coverage.gen.CCoverageParserBaseVisitor;
import com.proteus.parser.code_coverage.gen.CCoverageParser;

public class ExtendedContextVisitor extends CCoverageParserBaseVisitor<AbstractBaseExt>{
	@Override public AbstractBaseExt visitPrimaryExpression(CCoverageParser.PrimaryExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGenericSelection(CCoverageParser.GenericSelectionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGenericAssocList(CCoverageParser.GenericAssocListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGenericAssociation(CCoverageParser.GenericAssociationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPostfixExpression(CCoverageParser.PostfixExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitArgumentExpressionList(CCoverageParser.ArgumentExpressionListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitUnaryExpression(CCoverageParser.UnaryExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitUnaryOperator(CCoverageParser.UnaryOperatorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitCastExpression(CCoverageParser.CastExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitMultiplicativeExpression(CCoverageParser.MultiplicativeExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAdditiveExpression(CCoverageParser.AdditiveExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitShiftExpression(CCoverageParser.ShiftExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitRelationalExpression(CCoverageParser.RelationalExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitEqualityExpression(CCoverageParser.EqualityExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAndExpression(CCoverageParser.AndExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitExclusiveOrExpression(CCoverageParser.ExclusiveOrExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitInclusiveOrExpression(CCoverageParser.InclusiveOrExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitLogicalAndExpression(CCoverageParser.LogicalAndExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitLogicalOrExpression(CCoverageParser.LogicalOrExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitConditionalExpression(CCoverageParser.ConditionalExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAssignmentExpression(CCoverageParser.AssignmentExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAssignmentOperator(CCoverageParser.AssignmentOperatorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitExpression(CCoverageParser.ExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitConstantExpression(CCoverageParser.ConstantExpressionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDeclaration(CCoverageParser.DeclarationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDeclarationSpecifiers(CCoverageParser.DeclarationSpecifiersContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDeclarationSpecifiers2(CCoverageParser.DeclarationSpecifiers2Context ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDeclarationSpecifier(CCoverageParser.DeclarationSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitInitDeclaratorList(CCoverageParser.InitDeclaratorListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitInitDeclarator(CCoverageParser.InitDeclaratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStorageClassSpecifier(CCoverageParser.StorageClassSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitTypeSpecifier(CCoverageParser.TypeSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStructOrUnionSpecifier(CCoverageParser.StructOrUnionSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStructOrUnion(CCoverageParser.StructOrUnionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStructDeclarationList(CCoverageParser.StructDeclarationListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStructDeclaration(CCoverageParser.StructDeclarationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitSpecifierQualifierList(CCoverageParser.SpecifierQualifierListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStructDeclaratorList(CCoverageParser.StructDeclaratorListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStructDeclarator(CCoverageParser.StructDeclaratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitEnumSpecifier(CCoverageParser.EnumSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitEnumeratorList(CCoverageParser.EnumeratorListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitEnumerator(CCoverageParser.EnumeratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitEnumerationConstant(CCoverageParser.EnumerationConstantContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAtomicTypeSpecifier(CCoverageParser.AtomicTypeSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitTypeQualifier(CCoverageParser.TypeQualifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitFunctionSpecifier(CCoverageParser.FunctionSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAlignmentSpecifier(CCoverageParser.AlignmentSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDeclarator(CCoverageParser.DeclaratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDirectDeclarator(CCoverageParser.DirectDeclaratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGccDeclaratorExtension(CCoverageParser.GccDeclaratorExtensionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGccAttributeSpecifier(CCoverageParser.GccAttributeSpecifierContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGccAttributeList(CCoverageParser.GccAttributeListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitGccAttribute(CCoverageParser.GccAttributeContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitNestedParenthesesBlock(CCoverageParser.NestedParenthesesBlockContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPointer(CCoverageParser.PointerContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitTypeQualifierList(CCoverageParser.TypeQualifierListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitParameterTypeList(CCoverageParser.ParameterTypeListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitParameterList(CCoverageParser.ParameterListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitParameterDeclaration(CCoverageParser.ParameterDeclarationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitIdentifierList(CCoverageParser.IdentifierListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitTypeName(CCoverageParser.TypeNameContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitAbstractDeclarator(CCoverageParser.AbstractDeclaratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDirectAbstractDeclarator(CCoverageParser.DirectAbstractDeclaratorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitTypedefName(CCoverageParser.TypedefNameContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitInitializer(CCoverageParser.InitializerContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitInitializerList(CCoverageParser.InitializerListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDesignation(CCoverageParser.DesignationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDesignatorList(CCoverageParser.DesignatorListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDesignator(CCoverageParser.DesignatorContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStaticAssertDeclaration(CCoverageParser.StaticAssertDeclarationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitStatement(CCoverageParser.StatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitLabeledStatement(CCoverageParser.LabeledStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitCompoundStatement(CCoverageParser.CompoundStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitBlockItemList(CCoverageParser.BlockItemListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitBlockItem(CCoverageParser.BlockItemContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitExpressionStatement(CCoverageParser.ExpressionStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitSelectionStatement(CCoverageParser.SelectionStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitIterationStatement(CCoverageParser.IterationStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitJumpStatement(CCoverageParser.JumpStatementContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitCompilationUnit(CCoverageParser.CompilationUnitContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitTranslationUnit(CCoverageParser.TranslationUnitContext ctx) {
		return ctx.extendedContext;
	}
	
	@Override public AbstractBaseExt visitIncludeDirectives(CCoverageParser.IncludeDirectivesContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitExternalDeclaration(CCoverageParser.ExternalDeclarationContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitFunctionDefinition(CCoverageParser.FunctionDefinitionContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitDeclarationList(CCoverageParser.DeclarationListContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPragma_def(CCoverageParser.Pragma_defContext ctx) {
		return ctx.extendedContext;
	}

	@Override public AbstractBaseExt visitPragma_text(CCoverageParser.Pragma_textContext ctx) {
		return ctx.extendedContext;
	}

}
