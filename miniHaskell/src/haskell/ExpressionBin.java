package haskell;

public class ExpressionBin implements Expression{

	protected Expression expRight;
	protected Expression expLeft; 
	
	public ExpressionBin(Expression expRight, Expression expLeft) {
		this.expRight = expRight;
		this.expLeft = expLeft;
	}

	@Override
	public Value apprise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type type() {
		return (expLeft.type() == Type.Boolean && expRight.type() == Type.Boolean) ? Type.Boolean : Type.Error;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
