package asteroids.model;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalRadiusException;
import be.kuleuven.cs.som.annotate.*;
/**
 * @invar	The radius of each ship must be a valid radius.
 * 			| isValidRadius(getRadius())
 * @author Tomas
 *
 */
public class Asteroid extends FlyingObject {
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param xVelocity
	 * @param yVelocity
	 * @param radius
	 * @param angle
	 * @post 	...
	 * 			if(isValidRadius(radius))
	 * 				(new this).getRadius() == radius
	 * @throws IllegalRadiusException
	 * 			...
	 *  		!isValidRadius(radius)
	 * @effect	...
	 * 			(this).setX(x) && (this).setY(y) && (this).setVelocity(xVelocity,yVelocity)
	 * 			  (this).setOrientation(angle) && (this).setMass((Math.pow(radius,3)*4*Math.PI*rho)/3)
	 */
	public Asteroid(double x, double y, double xVelocity, double yVelocity, double radius, double angle) throws IllegalComponentException, IllegalRadiusException{
		super(x,y,xVelocity,yVelocity, angle, (Math.pow(radius,3)*4*Math.PI*rho)/3);
		if(isValidRadius(radius)) {
			  this.radius = radius;
		  }
		  else {
			  throw new IllegalRadiusException(radius);
		  }
	}
	
	/**
	 * Constant registering the mass density of an asteroid.
	 */
	private static final double rho = 2.65D;
	

	/**
	 * Return the radius of this asteroid.
	 */
	@Basic @Immutable @Raw
	public double getRadius(){
		  return radius;
	}
	
	
	
	/**
	 * Method that returns true if and only if the given number is a valid radius.
	 * @param	radius
	 * 			The number that will be checked to be a valid radius.
	 * @return	True if and only if the given number is bigger than minRadius and the double is not NaN.
	 * 			| result == (isValidDouble(radius) && radius > minRadius)
	 */
	public static boolean isValidRadius(double radius) {
		return (isValidDouble(radius) && radius > minRadius && radius < Double.POSITIVE_INFINITY);
	}
	
	/**
	 * Variable registering the radius of this asteroid.
	 */
	private final double radius;
	
	
	/**
	 * Returns the minimum value for the radius of a asteroid.
	 */
	@Basic @Immutable @Raw
	public static double getMinRadius() {
		return minRadius;
	}
	
	/**
	 * Variable registering the minimum radius of a asteroid.
	 */
	private final static double minRadius = 0D;
	
	/**
	 * @post	...
	 * 			| !(new this).getWorld().getAsteroids().contains(new this)
	 * @throws 	NullPointerException
	 * 			...
	 * 			| this.getWorld == null
	 */
	public void removeAsteroidFromWorld() throws NullPointerException {
		this.getWorld().deleteObject(this);
	}
	
	/**
	 * @effect 	...
	 * 			| this.setWorld(null)
	 */
	public void removeWorldFromAsteroid() {
		this.setWorld(null);
	}
	
	
	/**
	 * Terminate this asteroid by removing this asteroid from its world and by removing the world from this asteroid.
	 *
	 *
	 * @post   	...
	 *       	| new.isTerminated() == true
	 * @effect	...
	 *       	| this.removeAsteroidFromWorld()
	 * @effect	...
	 * 			| this.removeWorldFromAsteroid()
	 * @effect	...
	 * 			| super.terminate()	
	 */
	@Override
	public void terminate() throws NullPointerException{
		if(!this.isTerminated()) {
			removeAsteroidFromWorld();
			removeWorldFromAsteroid();
			super.terminate();
		}
	}
}
