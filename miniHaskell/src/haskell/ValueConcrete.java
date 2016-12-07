package haskell;

public abstract class ValueConcrete<T> extends Value {

	protected T value;

	public ValueConcrete(T value) {
		this.value = value;
	}

	@Override
	public Value apprise() {
		return this;
	}

	@Override
	public Type type() {
		return Type.List;
	}
	
	public T getValue() {
		return value;
	}

	@Override
	public boolean equals(Object othervalue) {
		if(othervalue instanceof ValueConcrete) {
			ValueConcrete ConcrereValue = (ValueConcrete) othervalue;
			return ConcrereValue.value.equals(value);
		}
		return false;
	}

}