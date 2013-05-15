package asteroids.model.programs.statements;

import java.util.ArrayList;
import java.util.List;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;


public class Sequence extends Statement {
	public Sequence(int line, int column, List<Statement> statements){
		super(line, column);
		this.statements = statements;
	}
	
	private List<Statement> statements;

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		if(statements != null) {
			for(Statement statement: statements) {
				statement.execute();
			}
		}
	}
	
	@Override
	public void setShip(asteroids.model.Ship ship){
		for(Statement statement: statements){
			statement.setShip(ship);
		}
	}
	
	public List<Statement> getAssignments(){
		List<Statement> assignments = new ArrayList<Statement>();
		for(Statement statement: statements) {
			if(statement instanceof Assignment) {
				assignments.add(statement);
			}
			else if(statement instanceof Sequence) {
				((Sequence) statement).getAssignments();
			}
		}
		return assignments;
	}
}
