package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;
/**
 * A class for signaling illegal Doubles for ships.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalDoubleException extends Exception {

	/**
	 * Initialize this new illegal Double exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal Double exception.
	 * @post   The value of this new illegal Double exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalDoubleException(double value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal Double exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal Double
	 * exception.
	 */
	private final double value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}


