package asteroids.model.programs.statements;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.programs.expressions.DoubleLiteral;
import asteroids.model.programs.expressions.Expression;

public class Turn extends Action {
	public Turn(int line, int column, Expression angle) {
		super(line, column);
		this.angle = angle;
	}
	
	private Expression angle;

	public Expression getAngle() {
		return angle;
	}

	public void setAngle(Expression angle) {
		this.angle = angle;
	}

	@Override
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		this.getShip().turn(((DoubleLiteral) getAngle()).getDouble());
	}
	
	
}
