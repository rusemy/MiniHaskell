package haskell;

public class ExpressionSum extends ExpressionBin {

	public ExpressionSum(Expression expRight, Expression expLeft) {
		super(expRight, expLeft);
	}

	@Override
	public Value apprise() {
		ValueInteger ve = (ValueInteger)expLeft.apprise();
		ValueInteger vd = (ValueInteger)expRight.apprise();
		
		return new ValueInteger(ve.getValue() + vd.getValue());
	}
	
	@Override
	public Type type() {
		return (expLeft.type() == Type.Integer && expRight.type() == Type.Integer) ? Type.Integer : Type.Error;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
