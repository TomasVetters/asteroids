package asteroids.model.programs.expressions;

public abstract class Method extends Expression {

	protected Method(int line, int column, Expression e) {
		super(line,column);
		this.e = e;
	}
	
	private Expression e;

	protected Expression getE() {
		return e;
	}

	protected void setE(Expression e) {
		this.e = e;
	}
	
	
}
