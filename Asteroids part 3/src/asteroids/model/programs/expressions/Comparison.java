package asteroids.model.programs.expressions;

public abstract class Comparison extends Expression {
	protected Comparison(int line, int column, Expression e1, Expression e2){
		super(line, column);
		if(canHaveAsExpression(e1)&&canHaveAsExpression(e2)) {
			this.e1 = e1;
			this.e2 = e2;
		}
	}
	
	private boolean canHaveAsExpression(Expression e) {
		return e.getValue() instanceof BooleanLiteral;
	}

	private Expression e1;
	
	private Expression e2;

	protected Expression getE1() {
		return e1;
	}

	protected void setE1(Expression e1) {
		if(canHaveAsExpression(e1)) {
			this.e1 = e1;
		}
	}

	protected Expression getE2() {
		return e2;
	}

	protected void setE2(Expression e2) {
		if(canHaveAsExpression(e2)) {
			this.e2 = e2;
		}
	}
	
}
