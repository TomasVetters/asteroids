package asteroids.model.programs.expressions;

public class Cos extends MathUnary {
	public Cos(Expression e, int line, int column) {
		super(e, line, column);
	}
	
	public Expression getValue() {
		return new DoubleLiteral(this.getLine(), this.getColumn(), Math.cos(((DoubleLiteral) (this.getE())).getDouble()));
	}
}
