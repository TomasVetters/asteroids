package asteroids.model.programs;

import java.util.List;
import java.util.Map;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.Ship;
import asteroids.model.programs.statements.Sequence;
import asteroids.model.programs.statements.Statement;
import asteroids.model.programs.types.Type;

/**
 * 
 * @author Steven
 *
 */
public class Program {
	public Program(Map<String, Type> globals, Statement statement){
		this.statement = statement;
		this.globals = globals;
	}
	
	private Statement statement;
	
	private Map<String, Type> globals;
	
	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public Map<String, Type> getGlobals() {
		return globals;
	}

	public void setGlobals(Map<String, Type> globals) {
		this.globals = globals;
	}

	private Ship ship;

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		statement.execute();
	}
	
	public List<Statement> getAssignments() {
		return ((Sequence) statement).getAssignments();
	}
}
