package asteroids.model;
import asteroids.exceptions.IllegalComponentException;
import be.kuleuven.cs.som.annotate.*;
/**
 * @author 	Tomas Vetters & Steven Vits
 *
 */
@Value
public class Velocity extends Vector{
	
	/**
	 * Create a new Velocity with the given x- and yComponent
	 * @param	xPos
	 * 			The number for the x-velocity.
	 * @param 	yPos
	 * 			The number for the y-velocity.
	 * @post	The new x-velocity is equal to the given x-velocity.
	 * 			| (new this).getXComponent() == xVel
	 * @post	The new y-velocity is equal to the given y-velocity.
	 * 			| (new this).getYComponent() == yVel
	 * @throws	IllegalComponentException
	 * 			The given velocity is not a valid velocity for a ship.
	 * 			| !isValidPositionComponent(xVel)||!isValidPositionComponent(yVel)
	 */
	public Velocity(double xVel, double yVel) throws IllegalComponentException {
		super(xVel, yVel);
	}

}