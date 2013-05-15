package asteroids.model.programs.expressions;

public class Or extends LogicalBinary {

	public Or(int line, int column, Expression e1, Expression e2) {
		super(line, column, e1, e2);
	}
	
	@Override
	public Expression getValue() {
		return new BooleanLiteral(this.getLine(), this.getColumn(), ((BooleanLiteral) (this.getE1())).getBool() || ((BooleanLiteral) (this.getE2())).getBool());
	}	
}
