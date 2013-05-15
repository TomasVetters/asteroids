package asteroids.model.programs.statements;
import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.Ship;

public abstract class Statement {
	protected Statement(int line, int column){
		this.line = line;
		this.column = column;
	}
	
	private int line;
	
	private int column;

	protected int getLine() {
		return line;
	}

	protected void setLine(int line) {
		this.line = line;
	}

	protected int getColumn() {
		return column;
	}

	protected void setColumn(int column) {
		this.column = column;
	}
	
	private Ship ship;
	
	protected Ship getShip() {
		return ship;
	}

	public abstract void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException;

	public void setShip(asteroids.model.Ship ship2) {
		this.ship = ship2;
	}
	
	
	
}
