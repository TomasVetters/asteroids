package asteroids.model.programs.expressions;

public class Subtraction extends MathBinary {
	public Subtraction(int line, int column, Expression e1, Expression e2){
		super(line, column, e1, e2);
	}
	
	public Expression getValue() {
		return new DoubleLiteral(this.getLine(), this.getColumn(), ((DoubleLiteral) (this.getE1())).getDouble() - ((DoubleLiteral) (this.getE2())).getDouble());
	}
}
