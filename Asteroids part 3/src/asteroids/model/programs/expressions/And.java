package asteroids.model.programs.expressions;

public class And extends LogicalBinary {

	public And(int line, int column, Expression e1, Expression e2) {
		super(line, column, e1, e2);
	}

		
	@Override
	public Expression getValue() {
		if((this.getE1() instanceof BooleanLiteral)&&(this.getE2() instanceof BooleanLiteral)) {
			return new BooleanLiteral(this.getLine(), this.getColumn(), ((BooleanLiteral) (this.getE1())).getBool() && ((BooleanLiteral) (this.getE2())).getBool());
		}
		else {
			return new And(this.getLine(), this.getColumn(), this.getE1().getValue(), this.getE2().getValue());
		}
	}
}
