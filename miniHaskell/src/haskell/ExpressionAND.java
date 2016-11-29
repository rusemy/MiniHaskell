package haskell;

public class ExpressionAND extends ExpressionBin{
	public ExpressionAND(Expression expRight, Expression expLeft) {
		super(expRight, expLeft);
	}

	@Override
	public Value apprise() {
		ValueBoolean ve = (ValueBoolean)expLeft.apprise();
		ValueBoolean vd = (ValueBoolean)expRight.apprise();
		
		if(ve.getValue() && vd.getValue()){
			return new ValueBoolean(true);
		}else{
			return new ValueBoolean(false);
		}
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
