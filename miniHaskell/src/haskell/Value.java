package haskell;

public abstract class Value implements Expression {
 
	@Override
	public Value apprise() {
		return this;
	}
}
