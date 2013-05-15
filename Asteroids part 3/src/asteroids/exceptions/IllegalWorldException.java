package asteroids.exceptions;
import be.kuleuven.cs.som.annotate.*;

import asteroids.model.World;
/**
 * A class for signaling illegal World for ships.
 * 
 * 
 * @version  1.0
 * @author   Steven Vits & Tomas Vetters
 */
public class IllegalWorldException extends Exception {

	/**
	 * Initialize this new illegal World exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal World exception.
	 * @post   The value of this new illegal World exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalWorldException(World world) {
		this.world = world;
	}

	/**
	 * Return the value registered for this illegal World exception.
	 */
	@Basic @Immutable
	public World getValue() {
		return this.world;
	}

	/**
	 * Variable registering the value involved in this illegal World
	 * exception.
	 */
	private final World world;

	/**
	 * A version number for this implementation of the interface Serializable.
	 */
	private static final long serialVersionUID = 2003001L;

}