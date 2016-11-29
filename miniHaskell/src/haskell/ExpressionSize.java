package haskell;

public class ExpressionSize implements Visitor {

	private int size = 0;
	public int getsize() {
		return size;
	}
	
	@Override
	public void visit(ValueInteger exp) {
		size += 1;
	}

	@Override
	public void visit(ValueBoolean exp) {
		size += 1;
	}

	@Override
	public void visit(ExpressionSum exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;
	}

	public void visit(ExpressionSubtraction exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;
	}
	
	@Override
	public void visit(Multiplication exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}

	public void visit(Division exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionAND exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionEqual exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	
	@Override
	public void visit(IfThenElse exp) {
		exp.condition.accept(this);
		exp.clauseThen.accept(this);
		exp.clauseElse.accept(this);
		size += 1;
	}

	@Override
	public void visit(ApplicationFunction exp) {
		exp.parameters.stream().forEach(p -> { p.accept(this); });
		size += 1;
		
//		for(Expression p: exp.parameters) {
//			p.accept(this);
//		}
	}

	@Override
	public void visit(Indentifier exp) {
		size += 1;
	}
	public void visit(ExpressionLess exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionLessEqual exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionMore exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionMoreEqual exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionOR exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionBin exp) {
		 exp.expLeft.accept(this);
		 exp.expRight.accept(this);
		 size += 1;	
	}
	public void visit(ExpressionNOT exp) {
		 exp.exp.accept(this);
		 size += 1;	
	}

}
