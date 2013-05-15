package asteroids.model.programs.statements;

import java.util.List;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.programs.expressions.Expression;
import asteroids.model.programs.expressions.Variable;

public class Print extends Statement {
	public Print(int line, int column, Expression e){
		super(line, column);
		this.e = e;
	}
	
	private Expression e;

	public Expression getE() {
		return e;
	}

	public void setE(Expression e) {
		this.e = e;
	}

	@Override
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		Expression eToPrint = null;
		List<Statement> assignments = this.getShip().getProgram().getAssignments();
		for(Statement s: assignments) {
			if(((Assignment) s).getVariableName().equals(((Variable)e).getName())) {
				eToPrint = ((Assignment) s).getAssignedE();
			}
		}
		if(eToPrint != null){
			System.out.println(eToPrint.toString());
		}
	}
	
}
