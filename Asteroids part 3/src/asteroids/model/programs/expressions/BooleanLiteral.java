package asteroids.model.programs.expressions;
import be.kuleuven.cs.som.annotate.*;

public class BooleanLiteral extends Literal {
	public BooleanLiteral(int line, int column, boolean bool){
		super(line, column);
		this.bool = bool;
	}
	
	private boolean bool;

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
	@Override
	public Expression getValue(){
		return this;
	}
	
	@Override 
	public boolean equals(Object a) {
		if(a instanceof BooleanLiteral) {
			return ((BooleanLiteral) a).getBool() == this.getBool();
		}
		else {
			return false;
		}
	}
	
	@Basic
	public boolean getBool(){
		return this.bool;
	}
	
	public String toString() {
		return Boolean.toString(bool);
	}
}
