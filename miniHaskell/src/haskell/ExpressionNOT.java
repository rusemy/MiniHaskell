package haskell;

public class ExpressionNOT implements Expression {
	protected Expression exp;
	
	public ExpressionNOT(Expression exp) {
		this.exp = exp;
	}

	@Override
	public Value apprise() {
		ValueBoolean value = (ValueBoolean)exp.apprise();
		if(value.getValue()){
			return new ValueBoolean(false);
		}else{
			return new ValueBoolean(true);
		}
	}
	@Override
	public Type type() {
		return (exp.type() == Type.Boolean ) ? Type.Boolean : Type.Error;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
