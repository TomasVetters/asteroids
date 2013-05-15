package asteroids.model.programs.expressions;

public class GreaterThan extends Comparison {
	public GreaterThan(int line, int column, Expression e1, Expression e2) {
		super(line, column, e1 , e2);
	}

	@Override
	public Expression getValue() {
		return new BooleanLiteral(this.getLine(), this.getColumn(), ((DoubleLiteral) (this.getE1())).getDouble()>((DoubleLiteral) (this.getE2())).getDouble());
	}
}
