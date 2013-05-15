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
public class PlacementOutsideBorderException extends Exception {

	/**
	 * Initialize this new placement outside border exception with given value.
	 * 
	 * @param  value
	 *         The value for this new placement outside border exception.
	 * @post   The value of this new placement outside border exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public PlacementOutsideBorderException(FlyingObject value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this placement outside border exception.
	 */
	@Basic @Immutable
	public FlyingObject getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this placement outside border exception.
	 */
	private final FlyingObject value;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}