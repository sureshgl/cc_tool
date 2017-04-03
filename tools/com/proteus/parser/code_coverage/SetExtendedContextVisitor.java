package com.proteus.parser.code_coverage;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.code_coverage.gen.CCoverageParser;
import com.proteus.parser.code_coverage.gen.CCoverageParserBaseVisitor;
import com.proteus.parser.code_coverage.ext.*;

public class SetExtendedContextVisitor extends CCoverageParserBaseVisitor<ParserRuleContext>{
	private AbstractBaseExt extendedContext;
	public SetExtendedContextVisitor( AbstractBaseExt extendedCtx){
		this.extendedContext = extendedCtx;
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPrimaryExpression(CCoverageParser.PrimaryExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PrimaryExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PrimaryExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGenericSelection(CCoverageParser.GenericSelectionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GenericSelectionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GenericSelectionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGenericAssocList(CCoverageParser.GenericAssocListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GenericAssocListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GenericAssocListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGenericAssociation(CCoverageParser.GenericAssociationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GenericAssociationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GenericAssociationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPostfixExpression(CCoverageParser.PostfixExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PostfixExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PostfixExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitArgumentExpressionList(CCoverageParser.ArgumentExpressionListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ArgumentExpressionListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ArgumentExpressionListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitUnaryExpression(CCoverageParser.UnaryExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof UnaryExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((UnaryExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitUnaryOperator(CCoverageParser.UnaryOperatorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof UnaryOperatorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((UnaryOperatorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitCastExpression(CCoverageParser.CastExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof CastExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((CastExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitMultiplicativeExpression(CCoverageParser.MultiplicativeExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof MultiplicativeExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((MultiplicativeExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAdditiveExpression(CCoverageParser.AdditiveExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AdditiveExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AdditiveExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitShiftExpression(CCoverageParser.ShiftExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ShiftExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ShiftExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitRelationalExpression(CCoverageParser.RelationalExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof RelationalExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((RelationalExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEqualityExpression(CCoverageParser.EqualityExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof EqualityExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((EqualityExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAndExpression(CCoverageParser.AndExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AndExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AndExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExclusiveOrExpression(CCoverageParser.ExclusiveOrExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ExclusiveOrExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ExclusiveOrExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInclusiveOrExpression(CCoverageParser.InclusiveOrExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof InclusiveOrExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((InclusiveOrExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLogicalAndExpression(CCoverageParser.LogicalAndExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof LogicalAndExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((LogicalAndExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLogicalOrExpression(CCoverageParser.LogicalOrExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof LogicalOrExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((LogicalOrExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitConditionalExpression(CCoverageParser.ConditionalExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ConditionalExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ConditionalExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAssignmentExpression(CCoverageParser.AssignmentExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AssignmentExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AssignmentExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAssignmentOperator(CCoverageParser.AssignmentOperatorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AssignmentOperatorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AssignmentOperatorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExpression(CCoverageParser.ExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitConstantExpression(CCoverageParser.ConstantExpressionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ConstantExpressionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ConstantExpressionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclaration(CCoverageParser.DeclarationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DeclarationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DeclarationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationSpecifiers(CCoverageParser.DeclarationSpecifiersContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DeclarationSpecifiersContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DeclarationSpecifiersContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationSpecifiers2(CCoverageParser.DeclarationSpecifiers2Context ctx) {
		if ( extendedContext != null && extendedContext instanceof DeclarationSpecifiers2ContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DeclarationSpecifiers2ContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationSpecifier(CCoverageParser.DeclarationSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DeclarationSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DeclarationSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitDeclaratorList(CCoverageParser.InitDeclaratorListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof InitDeclaratorListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((InitDeclaratorListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitDeclarator(CCoverageParser.InitDeclaratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof InitDeclaratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((InitDeclaratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStorageClassSpecifier(CCoverageParser.StorageClassSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StorageClassSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StorageClassSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeSpecifier(CCoverageParser.TypeSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof TypeSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((TypeSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructOrUnionSpecifier(CCoverageParser.StructOrUnionSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StructOrUnionSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StructOrUnionSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructOrUnion(CCoverageParser.StructOrUnionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StructOrUnionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StructOrUnionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclarationList(CCoverageParser.StructDeclarationListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StructDeclarationListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StructDeclarationListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclaration(CCoverageParser.StructDeclarationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StructDeclarationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StructDeclarationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSpecifierQualifierList(CCoverageParser.SpecifierQualifierListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof SpecifierQualifierListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((SpecifierQualifierListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclaratorList(CCoverageParser.StructDeclaratorListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StructDeclaratorListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StructDeclaratorListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStructDeclarator(CCoverageParser.StructDeclaratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StructDeclaratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StructDeclaratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumSpecifier(CCoverageParser.EnumSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof EnumSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((EnumSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumeratorList(CCoverageParser.EnumeratorListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof EnumeratorListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((EnumeratorListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumerator(CCoverageParser.EnumeratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof EnumeratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((EnumeratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitEnumerationConstant(CCoverageParser.EnumerationConstantContext ctx) {
		if ( extendedContext != null && extendedContext instanceof EnumerationConstantContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((EnumerationConstantContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAtomicTypeSpecifier(CCoverageParser.AtomicTypeSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AtomicTypeSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AtomicTypeSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeQualifier(CCoverageParser.TypeQualifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof TypeQualifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((TypeQualifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitFunctionSpecifier(CCoverageParser.FunctionSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof FunctionSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((FunctionSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAlignmentSpecifier(CCoverageParser.AlignmentSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AlignmentSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AlignmentSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarator(CCoverageParser.DeclaratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DeclaratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DeclaratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDirectDeclarator(CCoverageParser.DirectDeclaratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DirectDeclaratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DirectDeclaratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccDeclaratorExtension(CCoverageParser.GccDeclaratorExtensionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GccDeclaratorExtensionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GccDeclaratorExtensionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccAttributeSpecifier(CCoverageParser.GccAttributeSpecifierContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GccAttributeSpecifierContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GccAttributeSpecifierContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccAttributeList(CCoverageParser.GccAttributeListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GccAttributeListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GccAttributeListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitGccAttribute(CCoverageParser.GccAttributeContext ctx) {
		if ( extendedContext != null && extendedContext instanceof GccAttributeContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((GccAttributeContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitNestedParenthesesBlock(CCoverageParser.NestedParenthesesBlockContext ctx) {
		if ( extendedContext != null && extendedContext instanceof NestedParenthesesBlockContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((NestedParenthesesBlockContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPointer(CCoverageParser.PointerContext ctx) {
		if ( extendedContext != null && extendedContext instanceof PointerContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((PointerContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeQualifierList(CCoverageParser.TypeQualifierListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof TypeQualifierListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((TypeQualifierListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterTypeList(CCoverageParser.ParameterTypeListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ParameterTypeListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ParameterTypeListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterList(CCoverageParser.ParameterListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ParameterListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ParameterListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitParameterDeclaration(CCoverageParser.ParameterDeclarationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ParameterDeclarationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ParameterDeclarationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitIdentifierList(CCoverageParser.IdentifierListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof IdentifierListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((IdentifierListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypeName(CCoverageParser.TypeNameContext ctx) {
		if ( extendedContext != null && extendedContext instanceof TypeNameContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((TypeNameContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitAbstractDeclarator(CCoverageParser.AbstractDeclaratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof AbstractDeclaratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((AbstractDeclaratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDirectAbstractDeclarator(CCoverageParser.DirectAbstractDeclaratorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DirectAbstractDeclaratorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DirectAbstractDeclaratorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTypedefName(CCoverageParser.TypedefNameContext ctx) {
		if ( extendedContext != null && extendedContext instanceof TypedefNameContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((TypedefNameContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitializer(CCoverageParser.InitializerContext ctx) {
		if ( extendedContext != null && extendedContext instanceof InitializerContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((InitializerContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitInitializerList(CCoverageParser.InitializerListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof InitializerListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((InitializerListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDesignation(CCoverageParser.DesignationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DesignationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DesignationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDesignatorList(CCoverageParser.DesignatorListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DesignatorListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DesignatorListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDesignator(CCoverageParser.DesignatorContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DesignatorContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DesignatorContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStaticAssertDeclaration(CCoverageParser.StaticAssertDeclarationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StaticAssertDeclarationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StaticAssertDeclarationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitStatement(CCoverageParser.StatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof StatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((StatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitLabeledStatement(CCoverageParser.LabeledStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof LabeledStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((LabeledStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitCompoundStatement(CCoverageParser.CompoundStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof CompoundStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((CompoundStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitBlockItemList(CCoverageParser.BlockItemListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof BlockItemListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((BlockItemListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitBlockItem(CCoverageParser.BlockItemContext ctx) {
		if ( extendedContext != null && extendedContext instanceof BlockItemContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((BlockItemContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExpressionStatement(CCoverageParser.ExpressionStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ExpressionStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ExpressionStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitSelectionStatement(CCoverageParser.SelectionStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof SelectionStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((SelectionStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitIterationStatement(CCoverageParser.IterationStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof IterationStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((IterationStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitJumpStatement(CCoverageParser.JumpStatementContext ctx) {
		if ( extendedContext != null && extendedContext instanceof JumpStatementContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((JumpStatementContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitCompilationUnit(CCoverageParser.CompilationUnitContext ctx) {
		if ( extendedContext != null && extendedContext instanceof CompilationUnitContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((CompilationUnitContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitTranslationUnit(CCoverageParser.TranslationUnitContext ctx) {
		if ( extendedContext != null && extendedContext instanceof TranslationUnitContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((TranslationUnitContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}
	
	@Override public org.antlr.v4.runtime.ParserRuleContext visitIncludeDirectives(CCoverageParser.IncludeDirectivesContext ctx) {
		if ( extendedContext != null && extendedContext instanceof IncludeDirectivesContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((IncludeDirectivesContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitExternalDeclaration(CCoverageParser.ExternalDeclarationContext ctx) {
		if ( extendedContext != null && extendedContext instanceof ExternalDeclarationContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((ExternalDeclarationContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitFunctionDefinition(CCoverageParser.FunctionDefinitionContext ctx) {
		if ( extendedContext != null && extendedContext instanceof FunctionDefinitionContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((FunctionDefinitionContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitDeclarationList(CCoverageParser.DeclarationListContext ctx) {
		if ( extendedContext != null && extendedContext instanceof DeclarationListContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((DeclarationListContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPragma_def(CCoverageParser.Pragma_defContext ctx) {
		if ( extendedContext != null && extendedContext instanceof Pragma_defContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((Pragma_defContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

	@Override public org.antlr.v4.runtime.ParserRuleContext visitPragma_text(CCoverageParser.Pragma_textContext ctx) {
		if ( extendedContext != null && extendedContext instanceof Pragma_textContextExt){
			ctx.extendedContext.setTransformation(extendedContext.getTransformation());
			((Pragma_textContextExt)extendedContext).setContext(ctx);
			return ctx;
		}
		else{
			throw new ClassCastException(extendedContext.getClass().toString());
		}
	}

}
