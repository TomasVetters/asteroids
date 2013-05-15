package asteroids.model.programs.expressions;

public abstract class MathUnary extends MathOperator {

	protected MathUnary(Expression e, int line, int column){
		super(line, column);
		if(canHaveAsExpression(e)) {
			this.e = e;
		}
	}
	
	public Expression getE() {
		return e;
	}

	public void setE(Expression e) {
		if(canHaveAsExpression(e)) {
			this.e = e;
		}
	}

	private boolean canHaveAsExpression(Expression e) {
		return e.getValue() instanceof DoubleLiteral;
	}
	
	private Expression e;
	
	public abstract Expression getValue();
}
