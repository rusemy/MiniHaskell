package haskell;

public class ValueBoolean extends ParameterizedValue<Boolean>{

	public ValueBoolean(Boolean value) {
		super(value);
	}

	@Override
	public Type type() {
		return Type.Boolean;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
