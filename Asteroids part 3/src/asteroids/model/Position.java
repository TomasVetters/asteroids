package asteroids.model;
import asteroids.exceptions.IllegalComponentException;
import be.kuleuven.cs.som.annotate.*;
/**
 * @author Tomas Vetters & Steven Vits
 *
 */

@Value
public class Position extends Vector{
	
	/**
	 * Create a new Position with the given x- and yComponent
	 * @param	xPos
	 * 			The number for the x-position.
	 * @param 	yPos
	 * 			The number for the y-position.
	 * @effect  ...
	 * 			| super(xPos,yPos)
	 */
	public Position(double xPos, double yPos) throws IllegalComponentException {
		super(xPos, yPos);
	}

	
}
