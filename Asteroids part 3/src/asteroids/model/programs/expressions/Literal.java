package asteroids.model.programs.expressions;

public abstract class Literal extends Expression {
	public Literal(int line, int column) {
		super(line, column);
	}
	
	public abstract String toString();
	
}
