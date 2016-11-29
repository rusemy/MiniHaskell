package haskell;

public class ExpressionLess extends ExpressionBin{
	public ExpressionLess(Expression expRight, Expression expLeft) {
		super(expRight, expLeft);
	}

	@Override
	public Value apprise() {
		ValueInteger ve = (ValueInteger)expLeft.apprise();
		ValueInteger vd = (ValueInteger)expRight.apprise();
		
		if(ve.getValue() < vd.getValue()){
			return new ValueBoolean(true);
		}else{
			return new ValueBoolean(false);
		}
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
