package haskell;

public class Indentifier implements Expression {
	String id;

	public Indentifier(String id) {
		this.id = id;
	}
	
	public Value apprise() {
		Expression exp = Environment.instance().getExpression(id);
		return exp.apprise();
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
