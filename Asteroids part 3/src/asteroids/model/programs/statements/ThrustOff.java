package asteroids.model.programs.statements;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;

public class ThrustOff extends Action {
	public ThrustOff(int line, int column){
		super(line, column);
	}

	@Override
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		this.getShip().setThrusterActive(false);
	}
}
