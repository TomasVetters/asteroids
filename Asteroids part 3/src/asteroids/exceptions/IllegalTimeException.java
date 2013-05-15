package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal Time for ships.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalTimeException extends Exception {

	/**
	 * Initialize this new illegal Time exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal Time exception.
	 * @post   The value of this new illegal Time exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalTimeException(double value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal Time exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal Time
	 * exception.
	 */
	private final double value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}