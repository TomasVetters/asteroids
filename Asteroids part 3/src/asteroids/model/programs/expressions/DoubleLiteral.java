package asteroids.model.programs.expressions;
import be.kuleuven.cs.som.annotate.*;

public class DoubleLiteral extends Literal {
	public DoubleLiteral(int line, int column, double value) {
		super(line, column);
		this.value = value;
	}
	
	private double value;

	@Override
	public Expression getValue() {
		return this;
	}
	
	public double getDouble() {
		return value;
	}

	@Basic
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}
}
