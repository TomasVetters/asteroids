package asteroids.model.programs.expressions;

public abstract class Expression {
	protected Expression(int line, int column) {
		this.line = line; 
		this.column = column;
	}
	
	private int line;
	
	private int column;

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public abstract Expression getValue();
}
