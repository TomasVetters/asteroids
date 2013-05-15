package asteroids.model;
import be.kuleuven.cs.som.annotate.*;

/**
 * 
 * @author Steven
 *
 */
public class Collision {
	
	/**
	 * @param object1
	 * @param object2
	 * @param position
	 * @param time
	 * @effect ...
	 * 		   |(this).setObject1(object1) && (this).setObject2(object2) && (this).setPosition(position) && (this).setTime(time)
	 */
	public Collision(FlyingObject object1, FlyingObject object2, Vector position, double time) {
		this.setObject1(object1);
		this.setObject2(object2);
		this.setPosition(position);
		this.setTime(time);
	}

	/**
	 * Returns the first colliding object of this collision.
	 */
	@Basic 
	public FlyingObject getObject1() {
		return object1;
	}

	/**
	 * 
	 * @param object1
	 * @post  ...
	 *        | (this).getObject1() == object1
	 */
	public void setObject1(FlyingObject object1) {
		this.object1 = object1;
	}
	
	/**
	 * Variable registering the first colliding object.
	 */
	private FlyingObject object1;

	/**
	 * Returns the second colliding object of this collision.
	 */
	@Basic 
	public FlyingObject getObject2() {
		return object2;
	}

	/**
	 * @param object2
	 * @post  ...
	 * 		  | (this).getObject2() == object2
	 */
	public void setObject2(FlyingObject object2) {
		this.object2 = object2;
	}
	
	/**
	 * Variable registering the second colliding object.
	 */
	private FlyingObject object2;

	/**
	 * Returns the position of this collision.
	 */
	@Basic
	public Vector getPosition() {
		return position;
	}

	/**
	 * @param position
	 * @post  ...
	 * 		  | (this).getPosition() == position
	 */
	public void setPosition(Vector position) {
		this.position = position;
	}

	/**
	 * Variable registering the position of this collision.
	 */
	private Vector position;
	

	/**
	 * Returns the time till collision of this collision.
	 */
	@Basic
	public double getTime() {
		return time;
	}

	/**
	 * @param time
	 * @post  ...
	 * 		  | (this).getTime() == time
	 */
	public void setTime(double time) {
		this.time = time;
	}
	
	/**
	 * Variable registering the time till collision of this collision.
	 */
	private double time;
	
	/**
	 * Boolean indicating whether or not this collision is terminated.
	 */
	private boolean isTerminated = false;
	
	/**
	 * Return a boolean indicating whether or not this collision is terminated.
	 */
	@Basic
	public boolean isTerminated() {
		return this.isTerminated;
	}
	
	/**
	 * @post   ...
	 * 		   | (this).isTerminated() == true
	 * @effect ...
	 * 		   | (this).setObject1(null) && (this).setObject2(null) && (this).setPosition(null) && (this).setTime(null)
	 */
	public void terminate() {
		this.setObject1(null);
		this.setObject2(null);
		this.setPosition(null);
		this.setTime(0);
		this.isTerminated = true;
	}



}
