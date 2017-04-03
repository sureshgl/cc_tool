package com.proteus.parser.code_coverage;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.code_coverage.ext.*;
import com.proteus.parser.code_coverage.gen.CCoverageParser;
import com.proteus.parser.code_coverage.gen.CCoverageParserBaseVisitor;
public class PopulateExtendedContextVisitor extends CCoverageParserBaseVisitor<ParserRuleContext>{
	@Override public org.antlr.v4.runtime.ParserRuleContext visitPrimaryExpression(CCoverageParser.PrimaryExpressionContext ctx) {
		super.visitPrimaryExpression(ctx);
		ctx.extendedContext = new PrimaryExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGenericSelection(CCoverageParser.GenericSelectionContext ctx) {
		super.visitGenericSelection(ctx);
		ctx.extendedContext = new GenericSelectionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGenericAssocList(CCoverageParser.GenericAssocListContext ctx) {
		super.visitGenericAssocList(ctx);
		ctx.extendedContext = new GenericAssocListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGenericAssociation(CCoverageParser.GenericAssociationContext ctx) {
		super.visitGenericAssociation(ctx);
		ctx.extendedContext = new GenericAssociationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPostfixExpression(CCoverageParser.PostfixExpressionContext ctx) {
		super.visitPostfixExpression(ctx);
		ctx.extendedContext = new PostfixExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitArgumentExpressionList(CCoverageParser.ArgumentExpressionListContext ctx) {
		super.visitArgumentExpressionList(ctx);
		ctx.extendedContext = new ArgumentExpressionListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitUnaryExpression(CCoverageParser.UnaryExpressionContext ctx) {
		super.visitUnaryExpression(ctx);
		ctx.extendedContext = new UnaryExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitUnaryOperator(CCoverageParser.UnaryOperatorContext ctx) {
		super.visitUnaryOperator(ctx);
		ctx.extendedContext = new UnaryOperatorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitCastExpression(CCoverageParser.CastExpressionContext ctx) {
		super.visitCastExpression(ctx);
		ctx.extendedContext = new CastExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitMultiplicativeExpression(CCoverageParser.MultiplicativeExpressionContext ctx) {
		super.visitMultiplicativeExpression(ctx);
		ctx.extendedContext = new MultiplicativeExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAdditiveExpression(CCoverageParser.AdditiveExpressionContext ctx) {
		super.visitAdditiveExpression(ctx);
		ctx.extendedContext = new AdditiveExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitShiftExpression(CCoverageParser.ShiftExpressionContext ctx) {
		super.visitShiftExpression(ctx);
		ctx.extendedContext = new ShiftExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitRelationalExpression(CCoverageParser.RelationalExpressionContext ctx) {
		super.visitRelationalExpression(ctx);
		ctx.extendedContext = new RelationalExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEqualityExpression(CCoverageParser.EqualityExpressionContext ctx) {
		super.visitEqualityExpression(ctx);
		ctx.extendedContext = new EqualityExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAndExpression(CCoverageParser.AndExpressionContext ctx) {
		super.visitAndExpression(ctx);
		ctx.extendedContext = new AndExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExclusiveOrExpression(CCoverageParser.ExclusiveOrExpressionContext ctx) {
		super.visitExclusiveOrExpression(ctx);
		ctx.extendedContext = new ExclusiveOrExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInclusiveOrExpression(CCoverageParser.InclusiveOrExpressionContext ctx) {
		super.visitInclusiveOrExpression(ctx);
		ctx.extendedContext = new InclusiveOrExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLogicalAndExpression(CCoverageParser.LogicalAndExpressionContext ctx) {
		super.visitLogicalAndExpression(ctx);
		ctx.extendedContext = new LogicalAndExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLogicalOrExpression(CCoverageParser.LogicalOrExpressionContext ctx) {
		super.visitLogicalOrExpression(ctx);
		ctx.extendedContext = new LogicalOrExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitConditionalExpression(CCoverageParser.ConditionalExpressionContext ctx) {
		super.visitConditionalExpression(ctx);
		ctx.extendedContext = new ConditionalExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAssignmentExpression(CCoverageParser.AssignmentExpressionContext ctx) {
		super.visitAssignmentExpression(ctx);
		ctx.extendedContext = new AssignmentExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAssignmentOperator(CCoverageParser.AssignmentOperatorContext ctx) {
		super.visitAssignmentOperator(ctx);
		ctx.extendedContext = new AssignmentOperatorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExpression(CCoverageParser.ExpressionContext ctx) {
		super.visitExpression(ctx);
		ctx.extendedContext = new ExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitConstantExpression(CCoverageParser.ConstantExpressionContext ctx) {
		super.visitConstantExpression(ctx);
		ctx.extendedContext = new ConstantExpressionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclaration(CCoverageParser.DeclarationContext ctx) {
		super.visitDeclaration(ctx);
		ctx.extendedContext = new DeclarationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationSpecifiers(CCoverageParser.DeclarationSpecifiersContext ctx) {
		super.visitDeclarationSpecifiers(ctx);
		ctx.extendedContext = new DeclarationSpecifiersContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationSpecifiers2(CCoverageParser.DeclarationSpecifiers2Context ctx) {
		super.visitDeclarationSpecifiers2(ctx);
		ctx.extendedContext = new DeclarationSpecifiers2ContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationSpecifier(CCoverageParser.DeclarationSpecifierContext ctx) {
		super.visitDeclarationSpecifier(ctx);
		ctx.extendedContext = new DeclarationSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitDeclaratorList(CCoverageParser.InitDeclaratorListContext ctx) {
		super.visitInitDeclaratorList(ctx);
		ctx.extendedContext = new InitDeclaratorListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitDeclarator(CCoverageParser.InitDeclaratorContext ctx) {
		super.visitInitDeclarator(ctx);
		ctx.extendedContext = new InitDeclaratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStorageClassSpecifier(CCoverageParser.StorageClassSpecifierContext ctx) {
		super.visitStorageClassSpecifier(ctx);
		ctx.extendedContext = new StorageClassSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeSpecifier(CCoverageParser.TypeSpecifierContext ctx) {
		super.visitTypeSpecifier(ctx);
		ctx.extendedContext = new TypeSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructOrUnionSpecifier(CCoverageParser.StructOrUnionSpecifierContext ctx) {
		super.visitStructOrUnionSpecifier(ctx);
		ctx.extendedContext = new StructOrUnionSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructOrUnion(CCoverageParser.StructOrUnionContext ctx) {
		super.visitStructOrUnion(ctx);
		ctx.extendedContext = new StructOrUnionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclarationList(CCoverageParser.StructDeclarationListContext ctx) {
		super.visitStructDeclarationList(ctx);
		ctx.extendedContext = new StructDeclarationListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclaration(CCoverageParser.StructDeclarationContext ctx) {
		super.visitStructDeclaration(ctx);
		ctx.extendedContext = new StructDeclarationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSpecifierQualifierList(CCoverageParser.SpecifierQualifierListContext ctx) {
		super.visitSpecifierQualifierList(ctx);
		ctx.extendedContext = new SpecifierQualifierListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclaratorList(CCoverageParser.StructDeclaratorListContext ctx) {
		super.visitStructDeclaratorList(ctx);
		ctx.extendedContext = new StructDeclaratorListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclarator(CCoverageParser.StructDeclaratorContext ctx) {
		super.visitStructDeclarator(ctx);
		ctx.extendedContext = new StructDeclaratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumSpecifier(CCoverageParser.EnumSpecifierContext ctx) {
		super.visitEnumSpecifier(ctx);
		ctx.extendedContext = new EnumSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumeratorList(CCoverageParser.EnumeratorListContext ctx) {
		super.visitEnumeratorList(ctx);
		ctx.extendedContext = new EnumeratorListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumerator(CCoverageParser.EnumeratorContext ctx) {
		super.visitEnumerator(ctx);
		ctx.extendedContext = new EnumeratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumerationConstant(CCoverageParser.EnumerationConstantContext ctx) {
		super.visitEnumerationConstant(ctx);
		ctx.extendedContext = new EnumerationConstantContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAtomicTypeSpecifier(CCoverageParser.AtomicTypeSpecifierContext ctx) {
		super.visitAtomicTypeSpecifier(ctx);
		ctx.extendedContext = new AtomicTypeSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeQualifier(CCoverageParser.TypeQualifierContext ctx) {
		super.visitTypeQualifier(ctx);
		ctx.extendedContext = new TypeQualifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitFunctionSpecifier(CCoverageParser.FunctionSpecifierContext ctx) {
		super.visitFunctionSpecifier(ctx);
		ctx.extendedContext = new FunctionSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAlignmentSpecifier(CCoverageParser.AlignmentSpecifierContext ctx) {
		super.visitAlignmentSpecifier(ctx);
		ctx.extendedContext = new AlignmentSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarator(CCoverageParser.DeclaratorContext ctx) {
		super.visitDeclarator(ctx);
		ctx.extendedContext = new DeclaratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDirectDeclarator(CCoverageParser.DirectDeclaratorContext ctx) {
		super.visitDirectDeclarator(ctx);
		ctx.extendedContext = new DirectDeclaratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccDeclaratorExtension(CCoverageParser.GccDeclaratorExtensionContext ctx) {
		super.visitGccDeclaratorExtension(ctx);
		ctx.extendedContext = new GccDeclaratorExtensionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccAttributeSpecifier(CCoverageParser.GccAttributeSpecifierContext ctx) {
		super.visitGccAttributeSpecifier(ctx);
		ctx.extendedContext = new GccAttributeSpecifierContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccAttributeList(CCoverageParser.GccAttributeListContext ctx) {
		super.visitGccAttributeList(ctx);
		ctx.extendedContext = new GccAttributeListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccAttribute(CCoverageParser.GccAttributeContext ctx) {
		super.visitGccAttribute(ctx);
		ctx.extendedContext = new GccAttributeContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitNestedParenthesesBlock(CCoverageParser.NestedParenthesesBlockContext ctx) {
		super.visitNestedParenthesesBlock(ctx);
		ctx.extendedContext = new NestedParenthesesBlockContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPointer(CCoverageParser.PointerContext ctx) {
		super.visitPointer(ctx);
		ctx.extendedContext = new PointerContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeQualifierList(CCoverageParser.TypeQualifierListContext ctx) {
		super.visitTypeQualifierList(ctx);
		ctx.extendedContext = new TypeQualifierListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterTypeList(CCoverageParser.ParameterTypeListContext ctx) {
		super.visitParameterTypeList(ctx);
		ctx.extendedContext = new ParameterTypeListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterList(CCoverageParser.ParameterListContext ctx) {
		super.visitParameterList(ctx);
		ctx.extendedContext = new ParameterListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterDeclaration(CCoverageParser.ParameterDeclarationContext ctx) {
		super.visitParameterDeclaration(ctx);
		ctx.extendedContext = new ParameterDeclarationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitIdentifierList(CCoverageParser.IdentifierListContext ctx) {
		super.visitIdentifierList(ctx);
		ctx.extendedContext = new IdentifierListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeName(CCoverageParser.TypeNameContext ctx) {
		super.visitTypeName(ctx);
		ctx.extendedContext = new TypeNameContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAbstractDeclarator(CCoverageParser.AbstractDeclaratorContext ctx) {
		super.visitAbstractDeclarator(ctx);
		ctx.extendedContext = new AbstractDeclaratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDirectAbstractDeclarator(CCoverageParser.DirectAbstractDeclaratorContext ctx) {
		super.visitDirectAbstractDeclarator(ctx);
		ctx.extendedContext = new DirectAbstractDeclaratorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypedefName(CCoverageParser.TypedefNameContext ctx) {
		super.visitTypedefName(ctx);
		ctx.extendedContext = new TypedefNameContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitializer(CCoverageParser.InitializerContext ctx) {
		super.visitInitializer(ctx);
		ctx.extendedContext = new InitializerContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitializerList(CCoverageParser.InitializerListContext ctx) {
		super.visitInitializerList(ctx);
		ctx.extendedContext = new InitializerListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDesignation(CCoverageParser.DesignationContext ctx) {
		super.visitDesignation(ctx);
		ctx.extendedContext = new DesignationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDesignatorList(CCoverageParser.DesignatorListContext ctx) {
		super.visitDesignatorList(ctx);
		ctx.extendedContext = new DesignatorListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDesignator(CCoverageParser.DesignatorContext ctx) {
		super.visitDesignator(ctx);
		ctx.extendedContext = new DesignatorContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStaticAssertDeclaration(CCoverageParser.StaticAssertDeclarationContext ctx) {
		super.visitStaticAssertDeclaration(ctx);
		ctx.extendedContext = new StaticAssertDeclarationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatement(CCoverageParser.StatementContext ctx) {
		super.visitStatement(ctx);
		ctx.extendedContext = new StatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLabeledStatement(CCoverageParser.LabeledStatementContext ctx) {
		super.visitLabeledStatement(ctx);
		ctx.extendedContext = new LabeledStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitCompoundStatement(CCoverageParser.CompoundStatementContext ctx) {
		super.visitCompoundStatement(ctx);
		ctx.extendedContext = new CompoundStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitBlockItemList(CCoverageParser.BlockItemListContext ctx) {
		super.visitBlockItemList(ctx);
		ctx.extendedContext = new BlockItemListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitBlockItem(CCoverageParser.BlockItemContext ctx) {
		super.visitBlockItem(ctx);
		ctx.extendedContext = new BlockItemContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExpressionStatement(CCoverageParser.ExpressionStatementContext ctx) {
		super.visitExpressionStatement(ctx);
		ctx.extendedContext = new ExpressionStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSelectionStatement(CCoverageParser.SelectionStatementContext ctx) {
		super.visitSelectionStatement(ctx);
		ctx.extendedContext = new SelectionStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitIterationStatement(CCoverageParser.IterationStatementContext ctx) {
		super.visitIterationStatement(ctx);
		ctx.extendedContext = new IterationStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitJumpStatement(CCoverageParser.JumpStatementContext ctx) {
		super.visitJumpStatement(ctx);
		ctx.extendedContext = new JumpStatementContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitCompilationUnit(CCoverageParser.CompilationUnitContext ctx) {
		super.visitCompilationUnit(ctx);
		ctx.extendedContext = new CompilationUnitContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTranslationUnit(CCoverageParser.TranslationUnitContext ctx) {
		super.visitTranslationUnit(ctx);
		ctx.extendedContext = new TranslationUnitContextExt(ctx);
		return ctx;
	}
	
	@Override public org.antlr.v4.runtime.ParserRuleContext visitIncludeDirectives(CCoverageParser.IncludeDirectivesContext ctx) {
		super.visitIncludeDirectives(ctx);
		ctx.extendedContext = new IncludeDirectivesContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExternalDeclaration(CCoverageParser.ExternalDeclarationContext ctx) {
		super.visitExternalDeclaration(ctx);
		ctx.extendedContext = new ExternalDeclarationContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitFunctionDefinition(CCoverageParser.FunctionDefinitionContext ctx) {
		super.visitFunctionDefinition(ctx);
		ctx.extendedContext = new FunctionDefinitionContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationList(CCoverageParser.DeclarationListContext ctx) {
		super.visitDeclarationList(ctx);
		ctx.extendedContext = new DeclarationListContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPragma_def(CCoverageParser.Pragma_defContext ctx) {
		super.visitPragma_def(ctx);
		ctx.extendedContext = new Pragma_defContextExt(ctx);
		return ctx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPragma_text(CCoverageParser.Pragma_textContext ctx) {
		super.visitPragma_text(ctx);
		ctx.extendedContext = new Pragma_textContextExt(ctx);
		return ctx;
	}

}
