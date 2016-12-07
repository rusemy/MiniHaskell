package haskell;

/**
 * Interface com a declaracao dos metodos que 
 * "visitam" aplicando alguma operacao sobre 
 * os elementos sintaticos de uma linguagem 
 * de programacao. 
 * @author rbonifacio
 *
 */
public interface Visitor {
	public void visit(ValueInteger exp);
	public void visit(ValueBoolean exp);
	public void visit(ExpressionSum exp);
	public void visit(Multiplication exp);
	public void visit(IfThenElse exp);
	public void visit(ApplicationFunction exp);
	public void visit(Indentifier exp);
	public void visit(ExpressionSubtraction exp);
	public void visit(Division exp);
	public void visit(ExpressionAND exp);
	public void visit(ExpressionLess exp);
	public void visit(ExpressionLessEqual exp);
	public void visit(ExpressionMoreEqual exp);
	public void visit(ExpressionMore exp);
	public void visit(ExpressionOR exp);
	public void visit(ExpressionNOT exp);
	public void visit(ExpressionEqual exp);
	public void visit(ValueList exp);
}
