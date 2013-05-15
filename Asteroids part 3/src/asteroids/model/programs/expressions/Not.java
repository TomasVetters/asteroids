package asteroids.model.programs.expressions;

public class Not extends LogicalUnary {

	public Not(int line, int column, Expression e1) {
		super(line, column, e1);
	}
	
	
	@Override
	public Expression getValue() {
		return new BooleanLiteral(this.getLine(), this.getColumn(), !((BooleanLiteral) (this.getE())).getBool());
	}	
}
