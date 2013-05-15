package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal Component for ships.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalComponentException extends Exception {

	/**
	 * Initialize this new illegal Component exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal Component exception.
	 * @post   The value of this new illegal Component exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalComponentException(double value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal Component exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal Component
	 * exception.
	 */
	private final double value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}