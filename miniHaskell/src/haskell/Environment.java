package haskell;

import java.util.HashMap;
import java.util.Stack;

/*
 * Classe utilitaria para permitir overloading. 
 * Com o uso dessa classe, podemos ter funcoes 
 * na linguagem MiniHaskell com mesmo nome mas 
 * aridades diferente. 
 */
class SignatureFunction {
	private String name;
	private int aridity;
	
	public SignatureFunction(String name, int aridity) {
		this.name = name;
		this.aridity = aridity; 
	}
	
	public SignatureFunction(StatementFunction dec) {
		this(dec.getname(), dec.getArgs().size());
	}
	
	public String getname() {
		return name;
	}
	
	public int getaridity() {
		return aridity;
	}
	
	/*
	 * Necessaria a implementacao do metodo hashCode para 
	 * fazer com que o "get" de um hash map funcione. A 
	 * falta desse metodo originou o "bug" que ocorreu 
	 * no final da aula do dia 10/11/2016. 
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aridity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof SignatureFunction) &&
				((SignatureFunction)obj).name.equals(name) &&
				((SignatureFunction)obj).aridity == aridity;
	}
	
	
}
/**
 * Ambiente de execucao. Representa uma 
 * area de memoria que eh populada a cada 
 * chamada de funcao, associando os argumentos 
 * formais da declaracao de uma funcao com os 
 * parametros (expressoes) passados na chamada 
 * de uma funcao. 
 * 
 * @author rbonifacio
 *
 */
public class Environment{
	
	
	private HashMap<SignatureFunction, StatementFunction> functions;
	private Stack<HashMap<String, Expression>> executionStack;	
	private static Environment instance;
	private Environment() {
		executionStack = new Stack<>();
		functions = new HashMap<>();
	}

		
	public static Environment instance() {
		if(instance == null) {
			instance = new Environment();
		}
		return instance;
	}

		/**
		 * Declara uma funcao no Environment de execucao.
		 * @param decl Declaracao de funcao. 
		 */
	public void declareFunction(StatementFunction decl) {
		functions.put(new SignatureFunction(decl), decl);
	}
		
		/**
		 * Obtem uma declaracao de funcao no Environment de execucao.
		 * @param name da funcao
		 * @param aridity da funcao
		 * @return Declaracao de funcao com dado name / aridity.
		 * 
		 * @throws RuntimeException, caso a funcao nao tenha sido declarada.
		 */
	public StatementFunction getStatementFunction(String name, int aridity) {
		StatementFunction dec = functions.get(new SignatureFunction(name, aridity));
		
		if(dec == null) {
			throw new RuntimeException("Funcao " + name + " nao definida");
		}
		return dec;
	}
		
		/**
		 * Adiciona uma nova tabela (vazia) entre ids e 
		 * expressoes no topo da pilha. Esse metodo eh 
		 * particularmente util quando uma funcao eh chamada.
		 */
	public void stackUp() {
		executionStack.push(new HashMap<>());
	}
		
		/**
		 * Remove uma associacao entre names e expressoes 
		 * do topo da pilha. Util quando ocorre o retorno 
		 * de uma funcao. 
		 */
	public void destackUp() {
		if(!executionStack.isEmpty()) {
			executionStack.pop();
		}
	}

		/**
		 * Associa um identificador a uma Expression 
		 * na tabela que esta no topo da pilha. 
		 * 
		 * @param id identificador da variavel ou argumento
		 * @param exp Expression associada ao identificador
		 */
	public void associatesExpression(String id, Expression exp) {
		if(executionStack.isEmpty()) {
			stackUp();
		}
		HashMap<String, Expression> currentTable = executionStack.peek();
		currentTable.put(id, exp);
	}
		
		/**
		 * Obtem o valor da Expression associado a um identificador 
		 * na tabela que esta no topo da pilha. 
		 * @param id identificador da variavel
		 * @return Expression associada
		 * @throws RuntimeException quando a variavel nao foi associada
		 */
	public Expression getExpression(String id) {
		Expression exp = null;
		if(!executionStack.isEmpty()) {
			exp = executionStack.peek().get(id);
		}
		if(exp == null) {
			throw new RuntimeException("Variavel nao declarada");
		}
		return exp;
	}
}
	