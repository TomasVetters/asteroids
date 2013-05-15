package asteroids.model.programs.expressions;

public class Add extends MathBinary {
	public Add(Expression e1, Expression e2, int line, int column){
		super(line, column, e1, e2);
	}
	
	@Override
	public Expression getValue() {
		if((this.getE1() instanceof DoubleLiteral)&&(this.getE2() instanceof DoubleLiteral)) {
			return new DoubleLiteral(this.getLine(), this.getColumn(), ((DoubleLiteral) (this.getE1())).getDouble() + ((DoubleLiteral) (this.getE2())).getDouble());
		}
		else {
			return new Add(this.getE1().getValue(), this.getE2().getValue(),this.getLine(), this.getColumn());
		}
	}
}
