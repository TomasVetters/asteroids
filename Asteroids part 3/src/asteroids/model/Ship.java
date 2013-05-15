package asteroids.model;
import java.util.Set;

import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalRadiusException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.programs.Program;
import be.kuleuven.cs.som.annotate.*;



/**
 * A class that represents ships with each a position, velocity, orientation and radius.
 * @invar	The radius of each ship must be a valid radius.
 * 			| isValidRadius(getRadius())
 * @author Tomas Vetters & Steven Vits
 * @version 1.0
 *
 */
public class Ship extends FlyingObject {
	
	/**
	 * Create a new non-null ship with the given position, velocity, radius and angle (in radians) and the default speedlimit.
	 * @param	x
	 * 			The x-position for this ship.
	 * @param	y
	 * 			The y-position for this ship.
	 * @param	xVelocity
	 * 			The velocity along the X-axis for this ship.
	 * @param	yVelocity
	 * 			The velocity along the Y-axis for this ship.
	 * @param	radius
	 * 			The radius for this ship.
	 * @param	angle
	 * 			The angle for this ship.
	 * @post	If the given number is a valid radius, then the radius will be equal to the given number.
	 * 			| if(isValidRadius(radius))
	 * 				(new this).getRadius() == radius
	 * @throws	IllegalRadiusException
	 * 			The given radius is not a valid radius for a ship.
	 * 			| ! isValidRadius(radius)
	 * @effect	A new ship is created with the given position, velocity and orientation.
	 * 			| (new this).setX(x) && (new this).setY(y) && (new this).setSpeedLimit(speedOfLight) && (new this).setVelocity(xVelocity,yVelocity)
	 * 			  (new this).setOrientation(angle) && (new this).setMass(mass)
	 */
	public Ship(double x, double y, double xVelocity, double yVelocity, double radius, double angle, double mass) throws IllegalComponentException, IllegalRadiusException {
		  super(x,y,xVelocity,yVelocity, angle, mass);
		  if(isValidRadius(radius)) {
			  this.radius = radius;
		  }
		  else {
			  throw new IllegalRadiusException(radius);
		  }
	}
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Return the radius of this ship.
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
	 * 			| result == (isValidDouble(radius) && radius > getMinRadius())
	 */
	public static boolean isValidRadius(double radius) {
		return (isValidDouble(radius) && radius > getMinRadius() && radius < Double.POSITIVE_INFINITY);
	}
	
	/**
	 * Variable registering the radius of this ship.
	 */
	private final double radius;
	
	
	/**
	 * Returns the minimum value for the radius of a ship.
	 */
	@Basic @Immutable @Raw
	public static double getMinRadius() {
		return minRadius;
	}
	
	/**
	 * Variable registering the minimum radius of a ship.
	 */
	private final static double minRadius = 0;
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Boolean registering whether the thruster of this ship is active.
	 */
	private boolean thrusterActive = false;
	
	/**
	 * Return boolean indication whether the thruster of this ship is active.
	 */
	@Basic
	public boolean isThrusterActive() {
		return thrusterActive;
	}
	
	/** 
	 * @param active
	 * @post ...
	 * 		 | (new this).isThrusterActive() == active
	 */
	public void setThrusterActive(Boolean active) {
		this.thrusterActive = active;  
	}
	
	  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Update the direction of the ship by adding an angle (in radians) to its current direction. The angle may be negative.
	 * @param	angle
	 * 			The angle with which the ship is turned.
	 * @pre		The given number must be a valid double.
	 * 			| isValidDouble(angle)
	 * @effect	The orientation of the ship will be set to the new orientation according to the rotation.
	 * 			| this.setDirection(this.getDirection() + angle)
	 */
	public void turn(double angle) {
		assert isValidDouble(angle);
		this.setDirection(this.getDirection() + angle);
	}
	
	
	/**
	 * Update the ship's velocity based on its current velocity, its direction and the given amount.
	 * @param	amount
	 * 			The number of km/h to add to the speed.
	 * @post	If amount is negative, the velocities are left untouched.
	 * 			| if(amount < 0)
	 * 				((new this).getXVelocity() == this.getXVelocity()) && ((new this).getYVelocity() == this.getYVelocity())
	 * @post	If the given number is NaN, the velocities are left untouched.
	 * 			| if(!isValidDouble(amount))
	 * 				((new this).getXVelocity() == this.getXVelocity()) && ((new this).getYVelocity() == this.getYVelocity())
	 * @effect	The ships velocity will be set to the current velocities incremented with the amount of speed according the direction.
	 * 			| this.setVelocity(this.getXVelocity() + amount*Math.abs(Math.cos(this.getDirection())), this.getYVelocity() + amount*Math.abs(Math.sin(this.getDirection()))) 
	 */
	public void thrust(double dt) throws IllegalComponentException {
		double amount = getAcceleration(dt);
		if(!isValidDouble(amount)) {
		}
		else if(amount<0) {
		}
		else if(amount >= 0) {
			this.setVelocity(this.getXVelocity() + amount*(Math.cos(this.getDirection())), this.getYVelocity() + amount*(Math.sin(this.getDirection())));
		}
	}
	
	/**
	 * Constant registering the force that is applied during the thrust action.
	 */
	private static final double force = 1.1E18;
	
	/**
	 * Returns the force of this ship.
	 */
	public double getForce() {
		return Ship.force;
	}
	
	/**
	 * @param dt
	 * @return result == (getForce()*dt)/(this.getMass())
	 */
	private double getAcceleration(double dt) {
		return (getForce()*dt)/(this.getMass());
	}
	
	/**
	 * @effect	...
	 * 		    | if(this.getWorld() == null) {
	 * 			  }
	 * @effect	...
	 * 			| if(this.getWorld() != null) {
	 * 				Bullet bullet = new Bullet(this.getX()+(this.getRadius()+Bullet.getInitialRadius())*Math.cos(this.getDirection()),this.getY()+(this.getRadius()+Bullet.getInitialRadius())*Math.sin(this.getDirection()),
	 *					Bullet.getInitialBulletSpeed()*Math.cos(this.getDirection()), Bullet.getInitialBulletSpeed()*Math.sin(this.getDirection()),0,this)
	 *				this.getWorld().addObject(bullet)
	 *			  }
	 */
	public void fireBullet() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		if(!firingAllowed()) {
		}
		else if(this.getWorld() == null) {
		}
		else if(this.isTerminated()) {
		}
		else {
			Bullet bullet = new Bullet(this.getX()+(this.getRadius()+Bullet.getInitialRadius())*Math.cos(this.getDirection()),this.getY()+(this.getRadius()+Bullet.getInitialRadius())*Math.sin(this.getDirection()),
				Bullet.getInitialBulletSpeed()*Math.cos(this.getDirection()), Bullet.getInitialBulletSpeed()*Math.sin(this.getDirection()),0,this);
			try {
				this.getWorld().addObject(bullet);
			}
			catch (PlacementOutsideBorderException exc) {
			}
		}
	}
	
	/**
	 * Variable boolean registering whether the ship is allowed to fire bullets.
	 */
	public boolean firingAllowed() {
		int counter = 0;
		for(FlyingObject bullet: this.getWorld().getBullets()) {
			if(((Bullet) bullet).getSource().equals(this)) {
				counter++;
			}
		}
		if(counter >= maxBullets) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private static final double maxBullets = 3;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	private Program program;
	
	public void setProgram(Program program) {
		this.program = program;
	}
	
	public Program getProgram() {
		return this.program;
	}


	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/**
	 * @post 	...
	 * 			| !(new this).getWorld().getShips().contains(new this)
	 * @throws 	NullPointerException
	 * 			...
	 * 			| this.getWorld() == null
	 */
	private void removeShipFromWorld() throws NullPointerException{
		this.getWorld().deleteObject(this);
		
	}
	
	/**
	 * @post	...
	 * 			| (new this).getWorld() == null
	 */
	private void removeWorldFromShip() {
		this.setWorld(null);
	}
	
	/**
	 * @post	...
	 * 			| Set<Bullet> bullets = this.getWorld().getBullets()
	 * 			  for(Bullet bullet : bullets) {
	 * 					!bullet.getSource().equals(new this)
	 * 			  }		
	 * @throws 	NullPointerException
	 * 			...
	 * 			| this.getWorld() == null
	 */
	private void removeShipFromBullets() throws NullPointerException {
			Set<Bullet> bullets = this.getWorld().getBullets();
			if(bullets != null) {
				for(Bullet bullet : bullets) {
					if(bullet.getSource().equals(this)) {
						bullet.setSource(null);
					}
				}
			}
	}
	
    
	@Override
	/**
	 * @post   	...
	 *       	| (new this).isTerminated() == true
	 * @effect	...
	 *       	| this.removeShipFromWorld()
	 * @effect	...
	 * 			| this.removeWorldFromShip()
	 * @effect	...
	 * 			| this.removeShipFromBullets()
	 * @effect  ...
	 * 			| super.terminate()
	 */
	public void terminate() throws NullPointerException {
		if(!this.isTerminated()) {
			removeShipFromBullets();
			removeShipFromWorld();
			removeWorldFromShip();
			super.terminate();
		}
	}
	
	
}
