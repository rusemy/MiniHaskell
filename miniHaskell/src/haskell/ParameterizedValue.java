package haskell;

public abstract class ParameterizedValue<T> extends Value {

	private T Value;
	
	public ParameterizedValue(T Value) {
		this.Value = Value;
	}
	
	public T getValue() {
		return Value;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof ParameterizedValue) {
			return Value.equals(((ParameterizedValue)other).getValue());
		}
		return false;
	}
}
