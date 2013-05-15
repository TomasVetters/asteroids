package asteroids.model.programs.expressions;

public class Variable extends Expression {
	public Variable(int line, int column, String name){
		super(line, column);
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Expression getValue(){
		return this;
	}
}
