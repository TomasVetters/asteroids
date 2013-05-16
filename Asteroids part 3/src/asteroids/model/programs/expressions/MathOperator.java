package asteroids.model.programs.expressions;

public abstract class MathOperator extends Expression {
	protected MathOperator(int line, int column) {
		super(line, column);
	}
	
	public abstract Expression getValue();
	
	@Override
	public String toString() {
		return (getDouble(this.getValue()).toString());
	}
}
