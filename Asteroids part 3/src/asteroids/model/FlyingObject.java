package asteroids.model;

import asteroids.Util;
import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalTimeException;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class that represents flyingObjects with each a position, velocity, orientation, radius and mass.
 * @invar	The direction of each flyingObject must be a valid direction.
 * 			| isValidDirection(getDirection())
 * @invar	The mass of each flyingObject must be a valid mass.
 * 			| isValidMass(getMass())
 * @invar	The position and velocity of this flying object must be valid vectors.
 * 			| isValidVector(position)&&isValidVector(velocity)
 * @author Tomas Vetters & Steven Vits
 * @version 1.0
 *
 */
public abstract class FlyingObject {
	
	/**
	 * Create a new non-null flyingObject with the given position, velocity, radius and angle (in radians) and the default speedlimit.
	 * @param	x
	 * 			The x-position for this flyingObject.
	 * @param	y
	 * 			The y-position for this flyingObject.
	 * @param	xVelocity
	 * 			The velocity along the X-axis for this flyingObject.
	 * @param	yVelocity
	 * 			The velocity along the Y-axis for this flyingObject.
	 * @param	radius
	 * 			The radius for this flyingObject.
	 * @param	angle
	 * 			The angle for this flyingObject.
	 * @effect	A new flyingObject is created with the given position, velocity and orientation.
	 * 			| (new this).setX(x) && (new this).setY(y) && (new this).setSpeedLimit(speedOfLight) && (new this).setVelocity(xVelocity,yVelocity)
	 * 			  (new this).setOrientation(angle) && (new this).setMass(mass)
	 */
	public FlyingObject(double x, double y, double xVelocity, double yVelocity, double angle, double mass) throws IllegalComponentException {
		  setPosition(x, y);
		  setSpeedLimit(speedOfLight);
		  setVelocity(xVelocity,yVelocity);
		  setDirection(angle);
		  setMass(mass);
	}
	
	/**
	 * Method that returns the world this flying object belongs to.
	 */
	@Basic 
	public World getWorld() {
		return this.world;
	}
	
	/**
	 * Method that sets the world of this ship to the given value.
	 * @param 	world
	 * @post	...
	 * 			| (new this).getWorld() == world
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	
	/**
	 * Variable registering the world in which the ship is located.
	 */
	private World world;
	
	
	
	/**
	 * Method that returns the x-position of this flyingObject.
	 */
	@Basic @Raw
	public double getX() {
		return position.getXComponent();
	}
	
	
	
	/**
	 * Method that returns the y-position of this flyingObject.
	 */
	@Basic @Raw
	public double getY() {
		return position.getYComponent();
	}
	
	/**
	 * Method that returns and creates a new position for this flyingObject.
	 * @param  xPos
	 * 		   The x-component you want to give to the position.
	 * @param  yPos
	 *         The y-component you want to give to the position.
	 * @post   If the given components are valid the components of the position are equal to the given components.
	 * 		   if(Vector.isValidComponent(xPos)&&Vector.isValidComponent(yPos)) 
	 * 				(new this).getX() = xPos && (new this).getY() = yPos
	 * @throws IllegalComponentException
	 * 		   One of the given components is not a valid component for a Vector.
	 * 		   | !Vector.isValidComponent(xPos)||!Vector.isValidComponent(yPos)
	 */
	@Raw
	public void setPosition(double xPos, double yPos) throws IllegalComponentException {
		this.position = new Position(xPos,yPos);
	}
	
	/**
	 * Returns the position of this flying object.
	 */
	@Raw
	public Vector getPosition() {
		return position;
	}
	
	/**
	 * Variable registering the position of this flyingObject.
	 */
	private Vector position;
	
	/**
	 * @param vector
	 * @return ...
	 * 		   | result == Vector.isValidComponent(vector.getXComponent())&&Vector.isValidComponent(vector.getYComponent())
	 */
	@SuppressWarnings("unused")
	private static boolean isValidVector(Vector vector) {
		return Vector.isValidComponent(vector.getXComponent())&&Vector.isValidComponent(vector.getYComponent());
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Method that checks whether this flying object is terminated.
	 * @return	...
	 * 			| result == this.terminated
	 */
	public boolean isTerminated() {
		return this.terminated;
	}
	
	/**
	 * Variable boolean registering whether this flying object is terminated.
	 */
	private boolean terminated = false;
	
	/**
	 * Method that terminates this flying object.
	 * @post	...
	 * 			| (new this).isTerminated() == true
	 */
	public void terminate() {
		this.terminated = true;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Method that returns the speedlimit of this flyingObject.
	 */
	@Basic 
	public double getSpeedLimit() {
		return speedLimit;
	}
	
	/**
	 * Method that sets the speedlimit of this flyingObject to the given number.
	 * @param	speedLimit
	 * 			The number for the speedlimit.
	 * @post	If the given number is bigger than speedOfLight, then the speedlimit is equal to speedOfLight.
	 * 			| if(speedLimit > speedOfLight)
	 * 				(new this).getSpeedLimit() == speedOfLight
	 * @post	If the given number is negative, then the speedlimit is equal to zero.
	 * 			| if(speedLimit < 0)
	 * 				(new this).getSpeedLimit() == 0
	 * @post	If the given number is appropriate (between 0 and speedOfLight), then the speedlimit is equal to the given number.
	 * 			| if((speedLimit >= 0) && (speedLimit <= speedOfLight))
	 * 				(new this).getSpeedLimit() == speedLimit
	 */
	public void setSpeedLimit(double speedLimit) {
		if(speedLimit < 0) {
			this.speedLimit = 0;
		}
		else if(speedLimit > speedOfLight) {
			this.speedLimit = speedOfLight;
		}
		else if((speedLimit >= 0) && (speedLimit <= speedOfLight)) {
			this.speedLimit = speedLimit;
		}
					
	}
	
	/**
	 * Variable registering the speedlimit of this flyingObject.
	 */
	private double speedLimit;
	
	/**
	 * A constant registering the speed of light. 
	 */
	private static final double speedOfLight = 300000D;
	
	/**
	 * Return the velocity of this flyingObject along the X-axis.
	 */
	@Basic @Raw
	public double getXVelocity() {
		  return velocity.getXComponent();
	  }
	  
	/**
	 * Return the velocity of this flyingObject along the Y-axis.
	 */
	@Basic @Raw
	public double getYVelocity() {
		return velocity.getYComponent();
	}
	
	/**
	 * Return the velocity (vector) of this ship.
	 */
	@Basic @Raw
	public Vector getVelocity() {
		return velocity;
	}
	
	
	/**
	 * Method that sets the velocities along the X-axis and Y-axis of this flyingObject to the given numbers.
	 * @post	If the square root of the sum of the squares of both velocities is smaller than or equal to the speedlimit of this flyingObject, both velocities are equal to the given numbers.
	 * 			| if(Math.sqrt(xVel*xVel + yVel*yVel) <= this.getSpeedLimit())
	 * 				(new this).getXVelocity() == xVel
	 * 				(new this).getYVelocity() == yVel
	 * @post	If the square root of the sum of the squares of both velocities is bigger than the speedlimit of this flyingObject, 
	 * 			both velocities are equal to the maximum velocity along the current direction.
	 * 			| if(Math.sqrt(xVel*xVel + yVel*yVel) > this.getSpeedLimit())
	 * 				(new this).getXVelocity() == Math.abs(Math.cos(this.getDirection())*this.getSpeedLimit())
	 * 				(new this).getYVelocity() == Math.abs(Math.sin(this.getDirection())*this.getSpeedLimit())
	 * @post	If one or both of the given numbers are NaN, the velocities stay in their current state.
	 * 			| if((!isValidDouble(xVel)) || (!isValidDouble(yVel)))
	 * 				((new this).getXVelocity() == this.getXVelocity) && ((new this).getYVelocity() == this.getYVelocity())
	 * @throws	IllegalComponentException
	 * 			...
	 * 			|!Vector.isValidComponent(xVel)||!Vector.isValidComponent(yVel)
	 * @param	xVel
	 * 			The new number for the variable xVel
	 * @param	yVel
	 * 			The new number for the variable yVel
	 */
	@Raw
	public void setVelocity(double xVel, double yVel) throws IllegalComponentException {
		if(Math.sqrt(xVel*xVel + yVel*yVel) <= this.speedLimit) {
			this.velocity = new Velocity(xVel,yVel);
		}
		else if(Math.sqrt(xVel*xVel + yVel*yVel) > this.speedLimit){
			this.velocity = new Velocity(Math.abs(Math.cos(this.getDirection())*this.getSpeedLimit()),Math.abs(Math.sin(this.getDirection())*this.getSpeedLimit()));
		}
		else {
		}
	}
	
	/**
	 * Variable object of the type Vector registering the velocity of this flying object.
	 */
	private Vector velocity;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Method to set the angle of orientation of the flyingObject to the given number.
	 * @param	angle
	 * 			The angle with which the flyingObject oriented.
	 * @pre		The given angle must be a valid double.
	 * 			| isValidDouble(angle)
	 * @pre		The given angle is never an infinity value.
	 * 			|(angle!=Double.POSITIVE_INFINITY)&&(angle!=Double.NEGATIVE_INFINITY)		
	 * @post	If the given angle is positive, then the orientation of the flyingObject is equal to the modulo 2*Math.PI division of the given angle.
	 * 			| if(angle >=0)
	 * 				(new this).getOrientation() == angle % 2*Math.PI
	 * @post	If the given angle is negative, then the orientation of the flyingObject is equal to 2*Math.PI incremented with the modulo 2*Math.PI division of the given angle.
	 * 			| if(angle < 0)
	 * 				(new this).getOrientation() == 2*Math.PI + angle % 2*Math.PI
	 */
	@Raw
	public void setDirection(double angle) {
		double orientation;
		if(angle >=0) {
			orientation = angle % (2*Math.PI);
		}
		else {
			orientation = 2*Math.PI + 	angle % (2*Math.PI);
		}
		assert (isValidDirection(orientation));
		this.direction=orientation;
	}
	
	/**
	 * Method that returns the orientation of this flyingObject.
	 */
	@Basic @Raw
	public double getDirection() {
		return this.direction;
	}
	
	/**
	 * Variable registering the orientation of this flyingObject.
	 */
	private double direction;
	
	/**
	 * Methods that checks whether the given number is a valid direction.
	 * @param 	direction
	 * @return	True if and only if the given number is between 0 and 2*Pi, is not NaN and is not an infinity value.
	 * 			| result == ((direction >= 0)&&(direction<= 2*Math.PI)&&isValidDouble(direction)&&(direction!=Double.POSITIVE_INFINITY)&&(direction!=Double.NEGATIVE_INFINITY))
	 */
	public static boolean isValidDirection(double direction) {
		return ((direction >= 0)&&(direction<= 2*Math.PI)&&isValidDouble(direction)&&(direction!=Double.POSITIVE_INFINITY)&&(direction!=Double.NEGATIVE_INFINITY));
	}
	

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Method that returns the mass of this flyingObject.
	 */
	@Basic @Immutable @Raw
	public double getMass() {
		return this.mass;
	}
	
	/**
	 * Method that sets the mass of this flyingObject to the given number.
	 * @pre		The given number is a valid mass.
	 * 			| isValidMass(mass)
	 * @param 	mass
	 * 			The mass you want to give to this flyingObject.
	 * @post	The mass of this flyingObject is equal to the given mass.
	 * 			| (new this).getMass() == mass
	 */
	@Raw
	public void setMass(double mass) {
		assert(isValidMass(mass));
		this.mass = mass;
	}
	/**
	 * Method that checks whether the given mass is a valid mass for this flyingObject.
	 * @param mass
	 * 		  The mass that will be checked to be a valid mass.
	 * @return True if and only if the mass is not NaN, strictly positive and smaller than infinity.
	 * 		   | (isValidDouble(mass) && mass > 0 && mass < Double.POSITIVE_INFINITY)
	 */
	public static boolean isValidMass(double mass) {
		return (isValidDouble(mass) && mass > 0 && mass < Double.POSITIVE_INFINITY);
	}
	
	/**
	 * Variable registering the mass of this flyingObject.
	 */
	private double mass;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Returns the radius of this flying object.
	 */
	public abstract double getRadius();
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Method that returns true if the given number is valid.
	 * @param	number
	 * 			The number to check
	 * @return	True if and only if the given double is not NaN.
	 * 			| result == !isNaN(number)
	 */
	public static boolean isValidDouble(double number) {
		Double myDouble = new Double(number);
		return !myDouble.isNaN();
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/**
	 * Method that moves this ship.
	 * @param	dt
	 * 			The amount of time the ship moves along its current direction, at its current speed.
	 * @throws	IllegalTimeException
	 * 			The given amount of time is not valid.
	 * 			| !isValidTime(dt)
	 * @effect	The position of the ship is set to the new position according the movement.
	 * 			| setX(this.getX() + this.getXVelocity()*dt) && setY(this.getY()+this.getYVelocity()*dt)
	 */
	public void move(double dt) throws IllegalTimeException, IllegalComponentException{
		if(!isValidTime(dt)) {
			throw new IllegalTimeException(dt);
		}
		else {
			setPosition(this.getX()+this.getXVelocity()*dt, this.getY()+this.getYVelocity()*dt);
		}
	}
	
	/**
	 * Method that returns the distance between this object and the given object.
	 * @param	object
	 * 			The object where to the distance is calculated.
	 * @return	The distance between this object and the given object if the given object is a valid object, and not equal to this object.
	 * 			| if((object != null) && (!object.equals(this)) {
	 * 				result == Math.sqrt(Math.pow(this.getX() - object.getX(),2) + Math.pow(this.getY() - object.getY(),2)) - this.getRadius() - object.getRadius()
	 * @return	Zero if the given object is equal to this object.
	 * 			| if(object.equals(this))
	 * 				result == 0
	 * @throws	NullPointerException
	 * 			The given object does not exist.
	 * 			| object == null
	 * 
	 */
	public double getDistanceBetween(FlyingObject object) throws NullPointerException {
		if(!this.isValidDistance(object)) {
			return Double.POSITIVE_INFINITY;
		}
		else if(this.equals(object)) {
			return 0;
		}
		else {
			double xDis = this.getX() - object.getX();
			double yDis = this.getY() - object.getY();
			double totalDis = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));
			return totalDis - this.getRadius() - object.getRadius();
		}
	}
	
	/**
	 * @param world
	 * @return 	double distLeft = this.getX() - this.getRadius()
	 *			double distRight = world.getWidth() - this.getX()-this.getRadius()
	 *			double distUp = world.getHeight() - this.getY() - this.getRadius()
	 *			double distDown = this.getY() - this.getRadius()
	 *			result == Math.min(Math.min(distLeft,distRight), Math.min(distUp, distDown))
	 */
	public double getDistanceToClosestBorder(World world) {
		double distLeft = this.getX() - this.getRadius();
		double distRight = world.getWidth() - this.getX()-this.getRadius();
		double distUp = world.getHeight() - this.getY() - this.getRadius();
		double distDown = this.getY() - this.getRadius();
		return Math.min(Math.min(distLeft,distRight), Math.min(distUp, distDown));
	}
	
	
	/**
	 * Method to check whether the distance between this object and a given object can be calculated
	 * @param 	object
	 * 			The object where to the distance will be checked.
	 * @return	True if and only if the x-coordinates or y-coordinates of this object and the given object are not both equal to the same infinity value.
	 * 			| if(!(((this.getX()==(Double.POSITIVE_INFINITY))&&(object.getX()==(Double.POSITIVE_INFINITY)))||
	 *				((this.getY()==(Double.POSITIVE_INFINITY))&&(object.getY()==(Double.POSITIVE_INFINITY)))||
	 *				((this.getX()==(Double.NEGATIVE_INFINITY))&&(object.getX()==(Double.NEGATIVE_INFINITY)))||
	 *				((this.getX()==(Double.NEGATIVE_INFINITY))&&(object.getX()==(Double.NEGATIVE_INFINITY)))))
	 *					result == true
	 *			  else
	 *					result == false
	 */
	public boolean isValidDistance(FlyingObject object) {
		if(((this.getX()==(Double.POSITIVE_INFINITY))&&(object.getX()==(Double.POSITIVE_INFINITY)))||
		((this.getY()==(Double.POSITIVE_INFINITY))&&(object.getY()==(Double.POSITIVE_INFINITY)))||
		((this.getX()==(Double.NEGATIVE_INFINITY))&&(object.getX()==(Double.NEGATIVE_INFINITY)))||
		((this.getX()==(Double.NEGATIVE_INFINITY))&&(object.getX()==(Double.NEGATIVE_INFINITY)))) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Method that returns true if this object overlaps with the given object.
	 * @param	object
	 * 			The object with which the overlap is checked.
	 * @return	True if and only if this object overlaps with the given object or is equal to the given object.
	 * 			| if(this.equals(object)||(this.getDistanceBetween(object) < 0)) 
	 * 				result == true
	 * 			  else 
	 * 				result == false
	 * @throws	NullPointerException
	 * 			The given object does not exist.
	 * 			| object == null
	 */
	public boolean overlap(FlyingObject object) throws NullPointerException {
		if(this.equals(object)||(this.getDistanceBetween(object) < 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param world
	 * @return 	if(this.getDistanceToClosestBorder(world)<0) {
	 *				result == true
	 *			}
	 *			else {
	 *				result == false
	 *			}
	 */
	public boolean overlapBorder(World world) {
		if(this.getDistanceToClosestBorder(world)<0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method that returns when this object will collide with the given object, given their current speed and position.
	 * @param	object
	 * 			The object that will possibly collide with this object.
	 * @return	Double.POSITIVE_INFINITY if and only if the objects will never collide.
	 * 			Else the time to collision of the objects. (the other case).
	 * 			| double dRx = object.getX() - this.getX();
	 *			  double dRy = object.getY() - this.getY();
	 *			  double dVx = object.getXVelocity() - this.getXVelocity();
	 *			  double dVy = object.getYVelocity() - this.getYVelocity();
	 *			  double d = Math.pow((dRx*dVx+dRy*dVy),2)-(Math.pow(dVx, 2)+Math.pow(dVy, 2))*(Math.pow(dRx, 2)+Math.pow(dRy, 2)-Math.pow(sigma, 2));
	 * 			  if((dVx*dRx+dVy*dRy >= 0)||(d <= 0)) {
	 *	 			result == Double.POSITIVE_INFINITY
	 *		 		}
	 *			  else {
	 *				this.move(result+Util.EPSILON)
	 *			  	object.move(result+Util.EPSILON)
	 *			  	this.overlap(object) == true
	 *				}
	 * @throws  NullPointerException
	 * 			The given object does not exist
	 * 			| object == null
	 */
	public double getTimeToCollision(FlyingObject object) throws NullPointerException{
		double sigma = this.getRadius() + object.getRadius();
		double dRx = object.getX() - this.getX();
		double dRy = object.getY() - this.getY();
		double dVx = object.getXVelocity() - this.getXVelocity();
		double dVy = object.getYVelocity() - this.getYVelocity();
		double d = Math.pow((dRx*dVx+dRy*dVy),2)-(Math.pow(dVx, 2)+Math.pow(dVy, 2))*(Math.pow(dRx, 2)+Math.pow(dRy, 2)-Math.pow(sigma, 2));
		if((dVx*dRx+dVy*dRy >= 0)||(d <= 0)||(dVx*dRx+dVy*dRy == Double.NaN)||(d == Double.NaN)) {
			return Double.POSITIVE_INFINITY;
		}
		else {
			return -(dVx*dRx+dVy*dRy+Math.sqrt(d))/(Math.pow(dVx, 2)+Math.pow(dVy, 2));
		}
	}
	
	/**
	 * @return	...
	 * 			| this.move(result + Util.EPSILON)
	 * 			  this.overlapBorder == true
	 */
	public double getTimeToCollisionBorder() {
		double xTime;
		double yTime;
		double distLeft = this.getX() - this.getRadius();
		double distRight = this.getWorld().getWidth() - this.getX()-this.getRadius();
		double distUp = this.getWorld().getHeight() - this.getY() - this.getRadius();
		double distDown = this.getY() - this.getRadius();
		if(this.getXVelocity()>=0) {
			xTime = Math.abs(distRight/this.getXVelocity());
		}
		else {
			xTime = Math.abs(distLeft/this.getXVelocity());
		}
		if(this.getYVelocity()>=0) {
			yTime = Math.abs(distUp/this.getYVelocity());
		}
		else {
			yTime = Math.abs(distDown/this.getYVelocity());
		}
		return Math.min(xTime, yTime);
	}
	
	/**
	 * Method that returns the position where this object will collide with the given object.
	 * @param 	object
	 * 			The object that will possibly collide with this object.
	 * @return	null if and only if the objects will never collide.
	 * 			| double timeToCollision = this.getTimeToCollision(object);
	 * 			  if(timeToCollision == Double.POSITIVE_INFINITY) {
	 *				result == null
	 *  			}
	 * @return 	The position of collision if the objects will collide (the other case).
	 * 			| else {
	 * 				this.move(timeToCollision)
	 * 				object.move(timeToCollision)
	 * 				this.getRadius() == Math.sqrt(Math.pow(this.getX()-result[0],2)+Math.pow(this.getY()-result[1],2))
	 * 				object.getRadius() == Math.sqrt(Math.pow(object.getX()-result[0],2)+Math.pow(object.getY()-result[1],2))
	 *			  } 
	 * @throws 	IllegalDoubleException
	 * 		  	timeToCollision is NaN.
	 * 			|(!isValidDouble(timeToCollision))
	 * @throws	NullPointerException
	 * 			The given object does not exist.
	 * 			| object == null
	 */
	public Vector getCollisionPosition(FlyingObject object) throws IllegalDoubleException, NullPointerException, IllegalComponentException {
		double timeToCollision = this.getTimeToCollision(object);
		if(!isValidDouble(timeToCollision)) {
			throw new IllegalDoubleException(Double.NaN);
		}
		else if(timeToCollision == Double.POSITIVE_INFINITY) {
			return null;
		}
		else {
			Vector thisPosition = this.calculateNewPosition(timeToCollision);
			Vector objectPosition = object.calculateNewPosition(timeToCollision);
			double angle = this.getDirectionBetween(thisPosition, objectPosition);
			if(thisPosition.getXComponent() < objectPosition.getXComponent()) {
				Vector position = new Position(thisPosition.getXComponent() + Math.cos(angle)*this.getRadius(), thisPosition.getYComponent() + Math.sin(angle)*this.getRadius());
				return position;
			}
			else {
				Vector position = new Position(objectPosition.getXComponent() + Math.cos(angle)*object.getRadius(), objectPosition.getYComponent() + Math.sin(angle)*object.getRadius());
				return position;
			}
		}
	}
	
	/**
	 * @return	...
	 * 			| double timeToCollision = this.getTimeToCollisionBorder()
	 * 			  if((timeToCollision == Double.POSITIVE_INFINITY)||(timeToCollision == Double.NEGATIVE_INFINITY)) {
	 *			  		result == null
	 *			  }
	 *			  else {
	 *				 	this.move(timeToCollision)
	 *					result == this.getBorderPosition(this.getPosition())
	 *			  }
	 * @throws 	IllegalDoubleException
	 * 			...
	 * 			| double timeToCollision = this.getTimeToCollisionBorder()
	 * 			  !isValidDouble(timeToCollision)
	 */
	public Vector getCollisionBorderPosition() throws IllegalDoubleException, IllegalComponentException {
		double timeToCollision = this.getTimeToCollisionBorder();
		if(!isValidDouble(timeToCollision)) {
			throw new IllegalDoubleException(timeToCollision);
		}
		else if((timeToCollision == Double.POSITIVE_INFINITY)||(timeToCollision == Double.NEGATIVE_INFINITY)) {
			return null;
		}
		else {
			Vector thisPosition = this.calculateNewPosition(timeToCollision);
			return this.getBorderPosition(thisPosition);
		}
	}
	
	/**
	 * @param time
	 * @return ...
	 * 		   | result == (!myDouble.isNaN())&&(myDouble!=Double.POSITIVE_INFINITY)&&(myDouble!=Double.NEGATIVE_INFINITY)
	 */
	public static boolean isValidTime(double time) {
		Double myDouble = new Double(time);
		return (myDouble>=0)&&(!myDouble.isNaN())&&(myDouble!=Double.POSITIVE_INFINITY)&&(myDouble!=Double.NEGATIVE_INFINITY);
	}
	
	/**
	 * @param collisionPosition
	 * @return ...
	 * 		   Vector borderPosition;
	 *		   if(Util.fuzzyEquals((collisionPosition.getXComponent()+this.getRadius()),this.getWorld().getWidth())) {
	 *				borderPosition = new Position(this.getWorld().getWidth(), this.getY())
	 *		   }
	 *		   else if(Util.fuzzyEquals((collisionPosition.getXComponent()-this.getRadius()),0)) {
	 *				borderPosition = new Position(0,this.getY())
	 *		   }
	 *		   else if(Util.fuzzyEquals((collisionPosition.getYComponent()-this.getRadius()),0)) {
	 *				borderPosition = new Position(this.getX(),0)
	 *	       }
	 *	       else {
	 *				borderPosition = new Position(this.getX(), this.getWorld().getHeight())
	 *		   }
	 *		   result == borderPosition
	 * @throws IllegalComponentException
	 * 		   ...
	 * 		   !isValidVector(result)
	 */
	private Vector getBorderPosition(Vector collisionPosition) throws IllegalComponentException {
		Vector borderPosition;
		if(Util.fuzzyEquals((collisionPosition.getXComponent()+this.getRadius()),this.getWorld().getWidth())) {
			borderPosition = new Position(this.getWorld().getWidth(), this.getY());
		}
		else if(Util.fuzzyEquals((collisionPosition.getXComponent()-this.getRadius()),0)) {
			borderPosition = new Position(0,this.getY());
		}
		else if(Util.fuzzyEquals((collisionPosition.getYComponent()-this.getRadius()),0)) {
			borderPosition = new Position(this.getX(),0);
		}
		else {
			borderPosition = new Position(this.getX(), this.getWorld().getHeight());
		}
		return borderPosition;
	}
	
	/**
	 * Method that calculates the position of a object given a certain time of movement.
	 * @param 	dt
	 * 			The time of movement.
	 * @return 	An array with the new position of a object, with the x-coordinate on the first position and the y-coordinate on the second.
	 * 			| double[] newPosition = {this.getX()+this.getXVelocity()*dt, this.getY()+this.getYVelocity()*dt}
	 *			  result == newPosition
	 * @throws 	IllegalDoubleException
	 * 			The given time is NaN.
	 * 			| (!isValidDouble(dt))
	 */
	public Vector calculateNewPosition(double dt) throws IllegalDoubleException, IllegalComponentException {
		if(!isValidDouble(dt)) {
			throw new IllegalDoubleException(dt);
		}
		else {
			Vector newPosition = new Position(this.getX()+this.getXVelocity()*dt, this.getY()+this.getYVelocity()*dt);
			return newPosition;
		}
	}
	
	/**
	 * Method that calculates the angle between the centers of two objects.
	 * @param	firstPosition
	 * 		  	An array that gives the position of the first object.
	 * @param 	secondPosition
	 * 		  	An array that gives the position of the second object.
	 * @return  The angle between the centers of two objects.
	 * 			| double rico = (secondPosition[1]-firstPosition[1])/(secondPosition[0]-firstPosition[0])
	 *			  double angle = Math.atan(rico)
	 *		      result == angle
	 * @throws	IllegalDoubleException
	 * 			A double of one of the arrays is NaN
	 * 			| (!isValidDouble(secondPosition[0])||!isValidDouble(firstPosition[0])||!isValidDouble(secondPosition[1])||!isValidDouble(firstPosition[1]))
	 */
	public double getDirectionBetween(Vector firstPosition, Vector secondPosition) throws IllegalDoubleException{
		if(!isValidDouble(secondPosition.getXComponent())||!isValidDouble(firstPosition.getXComponent())||!isValidDouble(secondPosition.getYComponent())||!isValidDouble(firstPosition.getYComponent())) {
			throw new IllegalDoubleException(0);
		}
		double rico = (secondPosition.getYComponent()-firstPosition.getYComponent())/(secondPosition.getXComponent()-firstPosition.getXComponent());
		double angle = Math.atan(rico);
		return angle;
	}
}
