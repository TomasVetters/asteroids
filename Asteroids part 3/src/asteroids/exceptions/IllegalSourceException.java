package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal source for ships.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalSourceException extends Exception {

	/**
	 * Initialize this new illegal source exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal source exception.
	 * @post   The value of this new illegal source exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalSourceException(double value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal source exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal source
	 * exception.
	 */
	private final double value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}