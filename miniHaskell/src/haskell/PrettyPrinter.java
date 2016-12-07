package haskell;

public class PrettyPrinter implements Visitor{

	@Override
	public void visit(ValueInteger exp) {
		System.out.print(exp.getValue());
	}

	@Override
	public void visit(ValueBoolean exp) {
		System.out.print(exp.getValue());
	}

	@Override
	public void visit(ExpressionSum exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("+");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionBin exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print(",");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionSubtraction exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("-");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	
	@Override
	public void visit(Multiplication exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("*");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	
	public void visit(ExpressionAND exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("&&");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionEqual exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("==");
		exp.expRight.accept(this);
		System.out.print(")");
	}

	public void visit(Division exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("/");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	
	@Override
	public void visit(IfThenElse exp) {
		System.out.print("if( ");
		exp.condition.accept(this);
		System.out.println(")");
		
		System.out.print("then ");
		exp.clauseThen.accept(this);
		
		System.out.println("else " );
		exp.clauseElse.accept(this);
	}

	@Override
	public void visit(ApplicationFunction exp) {
		System.out.print(exp.name);
		System.out.print("(");
		int i = 0;
		while(i < exp.parameters.size() - 1) {
			exp.parameters.get(i++).accept(this);
			System.out.print(",");
		}
		if(i == exp.parameters.size() - 1) {
			exp.parameters.get(i++).accept(this);
		}
		System.out.println(")");
	}

	@Override
	public void visit(Indentifier exp) {
		System.out.println(exp.id);
	}
	public void visit(ExpressionLess exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("<");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionLessEqual exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("<=");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionMore exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print(">");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionMoreEqual exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print(">=");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionOR exp) {
		System.out.print("(");
		exp.expLeft.accept(this);
		System.out.print("||");
		exp.expRight.accept(this);
		System.out.print(")");
	}
	public void visit(ExpressionNOT exp) {
		System.out.print("(");
		System.out.print("!");
		exp.exp.accept(this);
		System.out.print(")");
	}
	public void visit(ValueList exp) {
		System.out.print("[");
		System.out.print(exp.getIndex());
		System.out.print("]");
	}

}
