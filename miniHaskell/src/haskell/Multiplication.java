package haskell;

public class Multiplication extends ExpressionBin {

	public Multiplication(Expression expRight, Expression expLeft) {
		super(expRight, expLeft);
	}

	@Override
	public Value apprise() {
		ValueInteger v1 = (ValueInteger) expLeft.apprise();
		ValueInteger v2 = (ValueInteger) expRight.apprise();

		return new ValueInteger(v1.getValue() * v2.getValue());
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
