package asteroids.model;
import asteroids.exceptions.IllegalComponentException;
import be.kuleuven.cs.som.annotate.*;
/**
 * @invar 	The x- and yComponent of each Vector must be valid components.
 *			| isValidComponent(xPos)&&isValidComponent(yPos)
 * @author  Tomas Vetters & Steven Vits
 *
 */

@Value
public abstract class Vector {
	/**
	 * Create a new Vector with the given x- and yComponent
	 * @param x
	 * 		  The x-component for the Vector
	 * @param y
	 * 	      The y-component for the Vector
	 * @post  If the given components are valid components the x- and yComponent are equal to the given components.
	 * 		  | if((isValidComponent(x))&&(isValidComponent(y))) 
	 * 				(new this).getXComponent() == x
	 * 				(new this).getYComponent() == y
	 * @throws 	IllegalComponentException
	 * 			The given components are invalid components for a Vector.
	 * 			| !(isValidComponent(x))||!(isValidComponent(y))
	 */
	public Vector(double x, double y) throws IllegalComponentException {
		if(isValidComponent(x)&&isValidComponent(y)){
			this.xComp = x;
			this.yComp = y;		
		}
		else {
			throw new IllegalComponentException(x);
		}
	}
	
	/**
	 * Method that returns the x-component of this vector.
	 */
	@Basic
	public double getXComponent() {
		return this.xComp;
	}
	
	/**
	 * Method that returns the y-component of this vector.
	 */
	@Basic
	public double getYComponent() {
		return this.yComp;
	}
	
	/**
	 * Method that returns true if and only if the given number is a valid component.
	 * @param	comp
	 * 			The number that will be checked to be a valid component.
	 * @return	True if and only if the given double is not NaN and not an infinity value.
	 * 			| result == (!myDouble.isNaN())&&(myDouble!=Double.POSITIVE_INFINITY)&&(myDouble!=Double.NEGATIVE_INFINITY)
	 */
	public static boolean isValidComponent(double comp) {
		Double myDouble = new Double(comp);
		return (!myDouble.isNaN())&&(myDouble!=Double.POSITIVE_INFINITY)&&(myDouble!=Double.NEGATIVE_INFINITY);
	}
	
	
	/**
	 * Variable registering the x-component of this vector.
	 */
	private double xComp;
	
	/**
	 * Variable registering the y-component of this vector.
	 */
	private double yComp;
	
	/**
	 * @return ...
	 * 		   | result == Math.sqrt(Math.pow(getXComponent(),2)+Math.pow(getYComponent(),2))
	 */
	public double getTotalLength() {
		return Math.sqrt(Math.pow(xComp,2)+Math.pow(yComp,2));
	
	}
	
}
