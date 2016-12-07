package haskell;

public class IfThenElse implements Expression {
	Expression condition;
	Expression clauseThen;
	Expression clauseElse;
	
	public IfThenElse(Expression condition, Expression clauseThen, Expression clauseElse) {
		this.condition = condition;
		this.clauseThen = clauseThen;
		this.clauseElse = clauseElse;
	} 
	
	public Value apprise() {
		ValueBoolean Value = (ValueBoolean)condition.apprise();
		if(Value.getValue()) {
			return clauseThen.apprise();
		}
		return 			clauseElse.apprise();
	}

	@Override
	public Type type() {
		return Type.Error;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
