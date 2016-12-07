package haskell;

public class ValueInteger extends ParameterizedValue<Integer> {

	public ValueInteger(Integer value) {
		super(value);
	}

	@Override
	public Type type() {
		return Type.Integer;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
