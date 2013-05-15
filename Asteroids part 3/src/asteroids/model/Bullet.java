package asteroids.model;
import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalSourceException;
import be.kuleuven.cs.som.annotate.*;
/**
 * @invar	The radius of each ship must be a valid radius.
 * 			| isValidRadius(getRadius())
 * @invar 	...
 * 			| isValidSource(getSource())
 * @author Steven
 *
 */
public class Bullet extends FlyingObject{
	
	/**
	 * ...
	 * @param x
	 * @param y
	 * @param xVelocity
	 * @param yVelocity
	 * @param angle
	 * @param source
	 * @post	...
	 * 			if(isValidSource(source))
	 * 				(new this).getSource() == source
	 * @throws 	IllegalSourceException 
	 * 			...
	 * 			!isValidSource(source)
	 * @effect	...
	 * 			(this).setX(x) && (this).setY(y) && (this).setVelocity(xVelocity,yVelocity)
	 * 			  (this).setOrientation(angle) && (this).setMass((Math.pow(radius,3)*4*Math.PI*rho)/3)
	 */
	public Bullet(double x, double y, double xVelocity, double yVelocity, double angle, Ship source) throws IllegalComponentException, IllegalSourceException{
		super(x,y,xVelocity,yVelocity, angle, (Math.pow(radius,3)*4*(Math.PI)*rho)/3);
		if(isValidSource(source)) {
			this.sourceShip = source;
		}
		else {
			throw new IllegalSourceException(0);
		}
	}
	
	/**
	 * Constant registering the mass density of a bullet.
	 */
	private static final double rho = 7.8*Math.pow(10, 12);
	
	/**
	 * @param ship
	 * @return ...
	 * 		   | result == (ship != null)
	 */
	private static boolean isValidSource(Ship ship) {
		return ship != null;
	}
	
	/**
	 * Variable registering the source that fired this bullet.
	 */
	private Ship sourceShip;
	
	/**
	 * Method returning the Ship-object that fired this bullet.
	 */
	@Basic @Raw
	public Ship getSource() {
		return this.sourceShip;
	}
	
	/**
	 * Method that sets the source of this bullet to the given value.
	 * @param 	ship
	 * @post	...
	 * 			| (new this).getSource() == source
	 */
	@Raw
	public void setSource(Ship ship) {
		this.sourceShip = ship;
	}
	
	/**
	 * Constant registering the radius of this bullet.
	 */
	private static final double radius = 3D;
	
	/**
	 * Return the radius of a bullet.
	 */
	@Basic @Immutable
	public static double getInitialRadius() {
		return radius;
	}
	
	/**
	 * Return the radius of this bullet.
	 */
	@Basic @Immutable
	public double getRadius(){
		  return radius;
	}
	
	/**
	 * Method that returns the initial standard speed of a bullet.
	 */
	@Basic @Immutable
	public static double getInitialBulletSpeed() {
		return initialBulletSpeed;
	}
	
	/**
	 * Constant registering the initial speed a bullet always has.
	 */
	private static final double initialBulletSpeed = 250D;
	
	/**
	 * Helping method that deletes the reference to the bullet in the world it belongs.
	 * @post	...
	 * 			| !(new this).getWorld().getBullets().contains(new this)
	 * @throws 	NullPointerException
	 * 			...
	 * 			| this.getWorld == null
	 */
	private void removeBulletFromWorld() throws NullPointerException{
		this.getWorld().deleteObject(this);
	}
	
	/**
	 * Helping method that deletes the reference to the world from the bullet.
	 * @effect 	...
	 * 			| this.setWorld(null)
	 */
	private void removeWorldFromBullet() {
		this.setWorld(null);
	}
	
	/**
	 * Method that terminates this bullet by deleting all existing references.
	 * @post   	...
	 *       	| new.isTerminated() == true
	 * @effect	...
	 *       	| this.removeBulletFromWorld()
	 * @effect	...
	 * 			| this.removeWorldFromBullet()
	 * @effect	...
	 * 			| super.terminate()
	 */
	@Override
	public void terminate() throws NullPointerException{
		if(!this.isTerminated()) {
			removeBulletFromWorld();
			removeWorldFromBullet();
			super.terminate();
		}
		else {
		}
	}
	
	/**
	 * Method that returns the bounced boolean of this bullet.
	 */
	@Basic
	public boolean isBounced() {
		return this.bounced;
	}
	
	/**
	 * @post	...
	 * 			| (new this).isBounced() == true
	 */
	public void bounce() {
		this.bounced = true;
	}
	
	/**
	 * Variable registering whether a bullet already bounced.
	 */
	private boolean bounced = false;
	
}
