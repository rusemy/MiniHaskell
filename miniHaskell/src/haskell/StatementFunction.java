package haskell;

import java.util.List;

public class StatementFunction {

	private String name;
	/*
	 * Na presenca de tipos, os argumentos formais 
	 * devem ser "anotados" com os respectivos tipos. 
	 * A verificacao de tipos da aplicacao de funcoes 
	 * deve checar se os argumentos atuais (que sao expressoes) 
	 * sao bem tipados em relacao aos argumentos formais. 
	 */
	private List<String> args;
	private Expression frame;
	
	public StatementFunction(String name, List<String> args, Expression frame) {
		this.name = name;
		this.args = args;
		this.frame = frame;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public Expression getframe() {
		return frame;
	}

	public void setFrame(Expression frame) {
		this.frame = frame;
	}
}
