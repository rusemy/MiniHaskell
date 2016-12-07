package haskell;

public class ValueEmptyList extends ValueList{
	static ValueEmptyList emptyList;
	
	public ValueEmptyList(){
		super(emptyList);
	}
	
	@Override
	public Type type(){
		return Type.Empty_List;
	}
}
