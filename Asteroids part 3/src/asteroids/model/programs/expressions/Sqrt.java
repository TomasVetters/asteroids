package asteroids.model.programs.expressions;

public class Sqrt extends MathUnary {
	
	public Sqrt(int line, int column, Expression e) {
		super(e, line, column);
	}
	
	@Override
	public Expression getValue() {
		Expression doubleLiteral = new DoubleLiteral(this.getLine(), this.getColumn(), Math.sqrt(((DoubleLiteral) this.getE()).getDouble()));
		return doubleLiteral;
	}
}
