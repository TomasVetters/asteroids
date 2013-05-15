package asteroids.model.programs.expressions;

public abstract class LogicalUnary extends Logical {

	protected LogicalUnary(int line, int column, Expression e1) {
		super(line, column);
		if(canHaveAsExpression(e1)) {
			this.e = e1;
		}
	}
	
	private boolean canHaveAsExpression(Expression e) {
		return e.getValue() instanceof BooleanLiteral;
	}
	
	private Expression e;

	protected Expression getE() {
		return e;
	}

	protected void setE(Expression e) {
		if(canHaveAsExpression(e)){
			this.e = e;
		}
	}
	
}
