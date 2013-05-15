package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;

import asteroids.model.FlyingObject;
/**
 * A class for signaling illegal Placement for flying objects.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalPlacementException extends Exception {

	/**
	 * Initialize this new illegal Placement exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal Placement exception.
	 * @post   The value of this new illegal Placement exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalPlacementException(FlyingObject value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal Placement exception.
	 */
	@Basic @Immutable
	public FlyingObject getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal Placement
	 * exception.
	 */
	private final FlyingObject value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}