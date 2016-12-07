package haskell;

public class ValueNotEmptyList extends ValueList{
	private ValueConcrete concrete;
	private ValueList list;
	
	public ValueNotEmptyList(ValueConcrete concrete, ValueList list){
		super(list);
		this.concrete = concrete;
		this.list = list;
	}

	
	public ValueConcrete getValueConcrete() {
		return concrete;
	}

	public ValueList getValueList() {
		return list;
	}

	public void setValueList(ValueList ValueList) {
		this.list = list;
	}	
}
