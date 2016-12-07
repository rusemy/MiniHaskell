package haskell;

public class ValueList extends  ValueConcrete<ValueList> {
	private int index;
	
	public ValueList(ValueList list) {
		super(list);
	}

	@Override
	public Type type() {
		return Type.List;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public boolean isEmpty(){
		return this instanceof ValueEmptyList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
