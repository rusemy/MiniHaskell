package haskell;

import java.util.List;

public class ApplicationFunction implements Expression {

/**
 * Corresponde a uma Expression do tipo 
 * aplicacao de funcao. 
 * 
 * @author rbonifacio
 */	
	String name;
	List<Expression> parameters;

	public ApplicationFunction(String name, List<Expression> parameters) {
		this.name = name;
		this.parameters = parameters;
	}

	@Override
	public Value apprise() {
		StatementFunction dec = Environment.instance().
				getStatementFunction(name, parameters.size());
		
		Environment.instance().stackUp();
		
		for(int i = 0; i < dec.getArgs().size(); i++) {
			String arg = dec.getArgs().get(i);
			Expression pmt = parameters.get(i);
			
			Environment.instance().associatesExpression(arg, pmt);
		}
		Value res = dec.getframe().apprise();
		Environment.instance().destackUp();
		
		return res;
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
