package asteroids.model.programs.statements;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;

public class Thrust extends Action {
	public Thrust(int line, int column){
		super(line, column);
	}

	@Override
	public void execute() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		this.getShip().setThrusterActive(true);
	}
}
