package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal Radius for ships.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalRadiusException extends Exception {

	/**
	 * Initialize this new illegal Radius exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal Radius exception.
	 * @post   The value of this new illegal Radius exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalRadiusException(double value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal Radius exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal Radius
	 * exception.
	 */
	private final double value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}