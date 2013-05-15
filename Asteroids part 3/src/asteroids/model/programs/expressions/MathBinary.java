package asteroids.model.programs.expressions;

public abstract class MathBinary extends MathOperator {

	protected MathBinary(int line, int column, Expression e1, Expression e2){
		super(line, column);
		if(canHaveAsExpression(e1)&&canHaveAsExpression(e2)) {
			this.e1 = e1;
			this.e1 = e2;
		}
	}
	
	public Expression getE1() {
		return e1;
	}

	public void setE1(Expression e1) {
		if(canHaveAsExpression(e1)) {
			this.e1 = e1;
		}
	}

	public Expression getE2() {
		return e2;
	}

	public void setE2(Expression e2) {
		if(canHaveAsExpression(e2)) {
			this.e2 = e2;
		}	
	}
	
	private boolean canHaveAsExpression(Expression e) {
		return e.getValue() instanceof DoubleLiteral;
	}

	private Expression e1;
	
	private Expression e2;
	
	public abstract Expression getValue();
}
