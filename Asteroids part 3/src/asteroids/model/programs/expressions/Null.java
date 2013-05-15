package asteroids.model.programs.expressions;

public class Null extends Expression {
	public Null(int line, int column) {
		super(line, column);
	}
	
	public Expression getValue() {
		return this;
	}
}
