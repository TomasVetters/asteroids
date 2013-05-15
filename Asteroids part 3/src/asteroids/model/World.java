package asteroids.model;
import java.util.HashSet;
import be.kuleuven.cs.som.annotate.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import asteroids.CollisionListener;
import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalRadiusException;
import asteroids.exceptions.IllegalSizeException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.IllegalTimeException;
import asteroids.exceptions.PlacementOutsideBorderException;

/**
 * @invar	isValidSize(width)&&isValidSize(height)
 * @author Tomas
 *
 */
public class World {
	
	/**
	 * Create a new non-null world with the given height and width. 
	 * @param 	width
	 * @param 	height
	 * @post	...
	 * 			| (new this).getWidth() == width
	 * @post	...
	 * 			| (new this).getHeight() == heigth
	 * @throws 	IllegalSizeException
	 * 			...
	 * 			| !isValidSize(width)||!isValidSize(height)
	 */
	public World(double width, double height) throws IllegalSizeException{
		if(isValidSize(width)&&isValidSize(height)) {
			this.width = width;
			this.height = height;
		}
		else {
			throw new IllegalSizeException(width);
		}
	}
	
	/**
	 * Method that returns a list that contains all the ships that are located in this world.
	 * @return	for(Ship ship: result) {
	 * 				isShip(ship) == true
	 * 				objects.contains(ship) == true
	 * 			}
	 */
	public Set<Ship> getShips() {
		Set<Ship> result = new HashSet<Ship>();
		Iterator<FlyingObject> iter = objects.iterator();
		while(iter.hasNext()){
			FlyingObject nextObject = iter.next();
			if(Ship.class.isInstance(nextObject)){
				Ship foundShip = (Ship) nextObject;
				result.add(foundShip);
			}
		}
		return result;
	}

	/**
	 * Method that returns a list that contains all the asteroids that are located in this world.
	 * @return	for(Asteroid asteroid: result) {
	 * 				isAsteroid(asteroid) == true
	 * 				objects.contains(asteroid) == true
	 * 			}
	 */
	public Set<Asteroid> getAsteroids() {
		Set<Asteroid> result = new HashSet<Asteroid>();
		Iterator<FlyingObject> iter = objects.iterator();
		while(iter.hasNext()) {
			FlyingObject nextObject = iter.next();
			if(Asteroid.class.isInstance(nextObject)){
				Asteroid foundAsteroid = (Asteroid) nextObject;
				result.add(foundAsteroid);
			}
		}
		return result;
	}

	/**
	 * Method that returns a list which contains all the bullets that are located in this world.
	 * @return	for(Bullet bullet: result) {
	 * 				isbullet(bullet) == true
	 * 				objects.contains(bullet) == true
	 * 			}
	 */
	public Set<Bullet> getBullets() {
		Set<Bullet> result = new HashSet<Bullet>();
		Iterator<FlyingObject> iter = objects.iterator();
		while(iter.hasNext()) {
			FlyingObject nextObject = iter.next();
			if(Bullet.class.isInstance(nextObject)){
				Bullet foundBullet = (Bullet) nextObject;
				result.add(foundBullet);
			}
		}
		return result;
	}
	
	/**
	 * Method that adds the given flying object to the list of this world.
	 * @param 	object
	 * @throws  PlacementOutsideBorderException
	 * 			...
	 * 			| object.overlapBorder(this)
	 * @throws	IllegalPlacementException
	 * 			...
	 * 			| randomOverlap(object)&&(isShip(object)||isAsteroid(object)) 
	 * @throws	IllegalArgumentException
	 * 			...
	 * 			| object == null
	 * @post	...
	 * 			| (new this).objects.contains(object) == true
	 * @post	...
	 * 			| (new object).getWorld().equals(this)
	 */
	public void addObject(FlyingObject object) throws IllegalPlacementException, PlacementOutsideBorderException{
		if(object == null) {
			throw new IllegalArgumentException();
		}
		else if(objects.contains(object)) {
			throw new IllegalArgumentException();
		}
		else if(object.overlapBorder(this)) {
			throw new PlacementOutsideBorderException(object);
		}
		else if(randomOverlap(object)&&(isShip(object)||isAsteroid(object))) {
			throw new IllegalPlacementException(object);
		}
		else {
			objects.add(object);
			object.setWorld(this);
		}
	}
	
	/**
	 * @param object
	 * @return 	...
	 * 			| boolean result == false
	 * 			  for(FlyingObject item: objects) {
	 * 				if(object.overlap(item)) {
	 * 					result = true
	 * 			  }
	 */
	private boolean randomOverlap(FlyingObject object) {
		boolean overlap = false;
		Iterator<FlyingObject> iter = objects.iterator();
		while(iter.hasNext()) {
			FlyingObject nextItem = iter.next();
			if(object.overlap(nextItem)) {
					overlap = true;
			}
	    }
		return overlap;
	}
	
	
	/**
	 * Variable set registering all the flying objects.
	 */
	private Set<FlyingObject> objects = new HashSet<FlyingObject>();
	
	
	
	/**
	 * Method that returns the width of this world.
	 */
	@Basic @Raw
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * Method that returns the height of this world.
	 */
	@Basic @Raw
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * Method that checks whether the given number is a valid size.
	 * @param 	size
	 * @return	True if and only if the given number is bigger than or equal to zero and smaller than maxSize.
	 * 			| result == (size>=0)&&(size<=maxSize)
	 */
	public static boolean isValidSize(double size) {
		return (size>=0)&&(size<=maxSize);
	}
	
	/**
	 * Variable registering the width of this world.
	 */
	private final double width;
	
	/**
	 * Variable registering the height of this world.
	 */
	private final double height;
	
	/**
	 * Constant registering the maximum value for the height or width of a world.
	 */
	private final static double maxSize = Double.MAX_VALUE;
	
	/**
	 * Method that updates the position of the flying objects over a time dt.
	 * @param dt
	 * @effect	...
	 * 			| if(isValidTime(dt)) {
	 * 			  	for(FlyingObject object: objects) {
	 * 					object.move(dt)
	 * 			  	}
	 * 			  }
	 */
	private void advance(double dt) throws IllegalComponentException, IllegalTimeException {
		Iterator<FlyingObject> iter = objects.iterator();
		if(isValidTime(dt)) {
			while(iter.hasNext()) {
				FlyingObject object = iter.next();
				object.move(dt);
			}
		}
	}
	
	/**
	 * Method that accelerates the ships of which the thruster is active.
	 * @param dt
	 * @effect ...
	 * 		   | for(Ships ship: this.getShips()) {
	 * 				if(ship.isThrustActive()) {
	 * 					ship.thrust(dt)
	 * 				}
	 * 			 }
	 */
	private void accelerate(double dt) throws IllegalComponentException {
		Iterator<Ship> iter = this.getShips().iterator();
		while(iter.hasNext()) {
			Ship nextShip = iter.next();
			if(nextShip.isThrusterActive()) {
				nextShip.thrust(dt);
			}
		}
	}
	
	/**
	 * @param dt
	 * @return ...
	 * 		   for(Collision collision: result.values()) {
	 * 				collision.getTime() < dt
	 * 		   }
	 * @throws IllegalComponentException
	 * 		   ...
	 * 		   for(Collision collision: result.values()) {
	 * 				!FlyingObject.isValidVector(collision.getPosition())
	 * 		   }
	 * @throws IllegalDoubleException
	 * 		   ...
	 * 		   for(Collision collision: result.values()) {
	 * 				!isValidDouble(collision.getTime())
	 * 		   }
	 */
	private Map<Double,Collision> predictCollisions(double dt) throws IllegalDoubleException, IllegalComponentException {
		Map<Double, Collision> collisions = new TreeMap<Double, Collision>();
		if(isValidTime(dt)) {
			Iterator<FlyingObject> iter1 = objects.iterator();
			while(iter1.hasNext()) {
				FlyingObject nextObject1 = iter1.next();
				if(nextObject1.getTimeToCollisionBorder() < dt) {
					Collision borderCollision = new Collision(nextObject1, null, nextObject1.getCollisionBorderPosition(), nextObject1.getTimeToCollisionBorder());
					collisions.put(nextObject1.getTimeToCollisionBorder(), borderCollision);
				}
				Iterator<FlyingObject> iter2 = objects.iterator();
				while(iter2.hasNext()) {
					FlyingObject nextObject2 = iter2.next();
					if ((nextObject1.getTimeToCollision(nextObject2) < dt) && !nextObject1.equals(nextObject2)) {
						Collision newCollision = new Collision(nextObject1, nextObject2, nextObject1.getCollisionPosition(nextObject2), nextObject1.getTimeToCollision(nextObject2));
						if(!collidesWithOwnSource(newCollision)) {
							collisions.put(nextObject1.getTimeToCollision(nextObject2), newCollision);
						}
					}
				}
			}
		}
		return collisions;
	}
	
	/**
	 * @param collision
	 * @return result == (isBullet(collision.getObject1())&&((Bullet) collision.getObject1()).getSource().equals(collision.getObject2()))||
	 *			(isBullet(collision.getObject2())&&((Bullet) collision.getObject2()).getSource().equals(collision.getObject1()))
	 */
	private boolean collidesWithOwnSource(Collision collision) {
		boolean ownSource = false;
		if((isBullet(collision.getObject1())&&((Bullet) collision.getObject1()).getSource().equals(collision.getObject2()))||
				(isBullet(collision.getObject2())&&((Bullet) collision.getObject2()).getSource().equals(collision.getObject1()))){
			ownSource = true;
		}
		return ownSource;
	}
	
	/**
	 * @param time
	 * @return 	Double myDouble = new Double(time)
	 * 			result == (!myDouble.isNaN())&&(myDouble!=Double.POSITIVE_INFINITY)&&(myDouble!=Double.NEGATIVE_INFINITY)
	 */
	public static boolean isValidTime(double time) {
		Double myDouble = new Double(time);
		return (!myDouble.isNaN())&&(myDouble!=Double.POSITIVE_INFINITY)&&(myDouble!=Double.NEGATIVE_INFINITY);
	}
	
	/**
	 * @param dt
	 * @return ...
	 * 		   | Map<Double, Collision> collisions = predictCollisions(dt)
	 * 			 for(Collision collision: collisions.values()) {
	 * 				result.getTime() <= collision.getTime()
	 * 			 }
	 */
	public Collision getFirstCollision(double dt) throws IllegalDoubleException, IllegalComponentException  {
		Map<Double, Collision> collisions = predictCollisions(dt);
		Collision firstCollision = null;
		if(collisions.size()>0) {
			firstCollision = collisions.get(((TreeMap<Double, Collision>) collisions).firstKey());
		}
		return firstCollision;
	}
	
	/**
	 * @param object
	 * @post  ...
	 * 		  | (new this).objects.contains(object) == false
	 */
	public void deleteObject(FlyingObject object) {
		objects.remove(object);
	}
	
	
	/**
	 * @param collision
	 * @param colList
	 * @effect if(collision.getObject2()==null) {
	 * 				bounceFromBorder(collision)
	 * 		   }
	 * @effect if((isShip(collision.getObject1())&&isShip(collision.getObject2()))||(isAsteroid(collision.getObject1())&&isAsteroid(collision.getObject2()))) {
	 * 				bounceFromEachOther(collision)
	 * 		   }
	 * @effect if(isBullet(collision.getObject1())) {
	 * 				explode(collision.getObject1(), collision.getObject2())
	 * 		   }
	 * @effect if(isBullet(collision.getObject2())) {
	 * 				explode(collision.getObject2(), collision.getObject1())
	 * 		   }
	 * @effect if(isAsteroid(collision.getObject1())&&(isShip(collision.getObject2()))) {
	 * 				collision.getObject2().terminate()
	 * 		   }
	 * @effect if(isAsteroid(collision.getObject2())&&(isShip(collision.getObject1()))) {
	 * 				collision.getObject1().terminate()
	 * 		   }
	 */
	private void handleCollisions(Collision collision, CollisionListener colList) throws IllegalComponentException, IllegalRadiusException, IllegalPlacementException, PlacementOutsideBorderException {
		if(collision.getObject2()==null){
			colList.boundaryCollision(collision.getObject1(), collision.getPosition().getXComponent(), collision.getPosition().getYComponent());
			bounceFromBorder(collision);
		}
		else if((isShip(collision.getObject1())&&isShip(collision.getObject2()))||(isAsteroid(collision.getObject1())&&isAsteroid(collision.getObject2()))) {
			bounceFromEachOther(collision);
			colList.objectCollision(collision.getObject1(), collision.getObject2(), collision.getPosition().getXComponent(), collision.getPosition().getYComponent());
		}
		else if(isBullet(collision.getObject1())) {
			colList.objectCollision(collision.getObject1(), collision.getObject2(), collision.getPosition().getXComponent(), collision.getPosition().getYComponent());
			explode(collision.getObject1(), collision.getObject2());
		}
		else if(isBullet(collision.getObject2())) {
			colList.objectCollision(collision.getObject1(), collision.getObject2(), collision.getPosition().getXComponent(), collision.getPosition().getYComponent());
			explode(collision.getObject2(), collision.getObject1());
		}
		else if(isAsteroid(collision.getObject1())&&(isShip(collision.getObject2()))){
			colList.objectCollision(collision.getObject1(), collision.getObject2(), collision.getPosition().getXComponent(), collision.getPosition().getYComponent());
			collision.getObject2().terminate();
		}
		else if(isAsteroid(collision.getObject2())&&(isShip(collision.getObject1()))){
			colList.objectCollision(collision.getObject1(), collision.getObject2(), collision.getPosition().getXComponent(), collision.getPosition().getYComponent());
			collision.getObject1().terminate();
		}
	}
	
	/**
	 * @param bullet
	 * @param exploder
	 * @effect if(isAsteroid(exploder)) {
	 * 			if(exploder.getRadius()>=30){
	 * 				exploder.terminate()
	 *				bullet.terminate()
	 *				createBabyAsteroids(exploder.getX(), exploder.getY(), exploder.getRadius(), exploder.getVelocity())
	 *			}
	 *		   }
	 * @effect if(isAsteroid(exploder)&& (exploder.getRadius < 30)) {
	 * 				exploder.terminate()
	 *				bullet.terminate()
	 *		   }
	 * @effect if(isBullet(exploder)||(isShip(exploder)&&!((Bullet) bullet).getSource().equals(exploder))) {
	 * 				exploder.terminate()
	 *				bullet.terminate()
	 *		   }
	 */
	private void explode(FlyingObject bullet, FlyingObject exploder) throws IllegalComponentException, IllegalRadiusException, IllegalPlacementException, PlacementOutsideBorderException {
		if(isAsteroid(exploder)) {
			if(exploder.getRadius()>=30){
				double xPos = exploder.getX();
				double yPos = exploder.getY();
				double radius = exploder.getRadius();
				Vector velocity = exploder.getVelocity();
				exploder.terminate();
				bullet.terminate();
				createBabyAsteroids(xPos, yPos, radius, velocity);
			}
			else {
				exploder.terminate();
				bullet.terminate();
			}
		}
		else if(isShip(exploder)) {
			if(((Bullet) bullet).getSource().equals(exploder)) {
			}
			else {
				exploder.terminate();
				bullet.terminate();
			}
		}
		else {
			exploder.terminate();
			bullet.terminate();
		}
		
	}
	
	/**
	 * @param xPos
	 * @param yPos
	 * @param radius
	 * @param velocity
	 * @effect Random random = new Random()
	 *		   double direction = random.nextDouble()%(2*Math.PI)
	 *	       FlyingObject babyAsteroid1 = new Asteroid(xPos+(Math.cos(direction)*radius+0.01)/2, yPos+(Math.sin(direction)*radius+0.01)/2, 1.5*velocity.getTotalLength()*Math.cos(direction),
	 *		   1.5*velocity.getTotalLength()*Math.sin(direction), radius/2, direction)
	 *	       FlyingObject babyAsteroid2 = new Asteroid(xPos-Math.cos(direction)*radius/2, yPos-Math.sin(direction)*radius/2, -1.5*velocity.getTotalLength()*Math.cos(direction),
	 *		   -1.5*velocity.getTotalLength()*Math.sin(direction), radius/2, (-1)*direction)
	 *	       this.addObject(babyAsteroid1)
	 *	       this.addObject(babyAsteroid2)
	 */
	private void createBabyAsteroids(double xPos, double yPos, double radius, Vector velocity) throws IllegalComponentException, IllegalRadiusException, IllegalPlacementException, PlacementOutsideBorderException {
		Random random = new Random();
		double direction = random.nextDouble()%(2*Math.PI);
		FlyingObject babyAsteroid1 = new Asteroid(xPos+(Math.cos(direction)*radius+0.01)/2, yPos+(Math.sin(direction)*radius+0.01)/2, 1.5*velocity.getTotalLength()*Math.cos(direction),
				1.5*velocity.getTotalLength()*Math.sin(direction), radius/2, direction);
		FlyingObject babyAsteroid2 = new Asteroid(xPos-Math.cos(direction)*radius/2, yPos-Math.sin(direction)*radius/2, -1.5*velocity.getTotalLength()*Math.cos(direction),
				-1.5*velocity.getTotalLength()*Math.sin(direction), radius/2, (-1)*direction);
		this.addObject(babyAsteroid1);
		this.addObject(babyAsteroid2);
	}
	
	/**
	 * @param collision
	 * @effect if(isBullet(collision.getObject1())&&((Bullet)collision.getObject1()).isBounced()) {
	 * 				collision.getObject1().terminate()
	 * 		   }
	 * @effect if(isBullet(collision.getObject1())&&!((Bullet)collision.getObject1()).isBounced()) {
	 * 				((Bullet)collision.getObject1()).bounce()
	 * 				if(collision.getPosition().getXComponent()==0||collision.getPosition().getXComponent()==this.width) {
	 *					collision.getObject1().setVelocity((-1)*collision.getObject1().getXVelocity(), collision.getObject1().getYVelocity());
	 *				}
	 *				else {
	 *					collision.getObject1().setVelocity(collision.getObject1().getXVelocity(), (-1)*(collision.getObject1().getYVelocity()));
	 *				}
	 * 		   }
	 * @effect if(!isBullet(collision.getObject1())) {
	 * 				if(collision.getPosition().getXComponent()==0||collision.getPosition().getXComponent()==this.width) {
	 *				collision.getObject1().setVelocity((-1)*(collision.getObject1().getXVelocity()), collision.getObject1().getYVelocity());
	 *			}
	 *		 	else {
	 *			 	collision.getObject1().setVelocity(collision.getObject1().getXVelocity(), (-1)*(collision.getObject1().getYVelocity()));
	 *			} 
	 */
	private void bounceFromBorder(Collision collision) throws IllegalComponentException {
		if(isBullet(collision.getObject1())) {
			if(((Bullet)collision.getObject1()).isBounced()) {
				collision.getObject1().terminate();
			}
			else {
				((Bullet)collision.getObject1()).bounce();
				if(collision.getPosition().getXComponent()==0||collision.getPosition().getXComponent()==this.width) {
					collision.getObject1().setVelocity((-1)*collision.getObject1().getXVelocity(), collision.getObject1().getYVelocity());
				}
				else {
					collision.getObject1().setVelocity(collision.getObject1().getXVelocity(), (-1)*(collision.getObject1().getYVelocity()));
				}
			}
		}
		else {
			if(collision.getPosition().getXComponent()==0||collision.getPosition().getXComponent()==this.width) {
				collision.getObject1().setVelocity((-1)*(collision.getObject1().getXVelocity()), collision.getObject1().getYVelocity());
			}
			else {
				collision.getObject1().setVelocity(collision.getObject1().getXVelocity(), (-1)*(collision.getObject1().getYVelocity()));
			}
		}
	}
	
	
	/**
	 * @param   collision
	 * @effect 	double sigma = collision.getObject1().getRadius() + collision.getObject2().getRadius()
	 *			double dRx = collision.getObject2().getX() - collision.getObject1().getX()
	 *			double dRy = collision.getObject2().getY() - collision.getObject1().getY()
	 *			double dVx = collision.getObject2().getXVelocity() - collision.getObject1().getXVelocity()
	 *			double dVy = collision.getObject2().getYVelocity() - collision.getObject1().getYVelocity()
	 *			double J = (2*(collision.getObject1().getMass())*(collision.getObject2().getMass())*(dVx*dRx+dVy*dRy))/(sigma*(collision.getObject1().getMass()+collision.getObject2().getMass()))
	 *			double Jx = (J*dRx)/sigma
	 *			double Jy = (J*dRy)/sigma
	 *			collision.getObject1().setVelocity(collision.getObject1().getXVelocity()+Jx/(collision.getObject1().getMass()), collision.getObject1().getYVelocity()+Jy/(collision.getObject1().getMass()))
	 *			collision.getObject2().setVelocity(collision.getObject2().getXVelocity()-Jx/(collision.getObject2().getMass()), collision.getObject2().getYVelocity()-Jy/(collision.getObject2().getMass()))
	 */
	private void bounceFromEachOther(Collision collision) throws IllegalComponentException {
		double sigma = collision.getObject1().getRadius() + collision.getObject2().getRadius();
		double dRx = collision.getObject2().getX() - collision.getObject1().getX();
		double dRy = collision.getObject2().getY() - collision.getObject1().getY();
		double dVx = collision.getObject2().getXVelocity() - collision.getObject1().getXVelocity();
		double dVy = collision.getObject2().getYVelocity() - collision.getObject1().getYVelocity();
		double J = (2*(collision.getObject1().getMass())*(collision.getObject2().getMass())*(dVx*dRx+dVy*dRy))/(sigma*(collision.getObject1().getMass()+collision.getObject2().getMass()));
		double Jx = (J*dRx)/sigma;
		double Jy = (J*dRy)/sigma;
		collision.getObject1().setVelocity(collision.getObject1().getXVelocity()+Jx/(collision.getObject1().getMass()), collision.getObject1().getYVelocity()+Jy/(collision.getObject1().getMass()));
		collision.getObject2().setVelocity(collision.getObject2().getXVelocity()-Jx/(collision.getObject2().getMass()), collision.getObject2().getYVelocity()-Jy/(collision.getObject2().getMass()));
	}
	
	/**
	 * Check whether o is an asteroid.
	 * @return result == o instanceof Asteroid
	 */
	public boolean isAsteroid(Object o) {
		return o instanceof Asteroid;
	}
	  
	  /**
	   * Check whether o is a Bullet.
	   * @return result == o instanceof Asteroid
	   */
	  public boolean isBullet(Object o) {
		  return o instanceof Bullet;
	  }
	  /**
	   * Check whether o is a Ship.
	   * @return result == o instanceof Asteroid
	   */
	  public boolean isShip(Object o) {
		  return o instanceof Ship;
	  }
	  
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

		/**
		 * @param dt
		 * @param colList
		 * @throws IllegalSourceException 
		 * @effect if(dt>0) {
		 *				Collision firstCollision = this.getFirstCollision(dt);
		 *				if ((firstCollision != null)&&(isValidTime(firstCollision.getTime()))) {
		 *					accelerate(firstCollision.getTime());
		 *					advance(firstCollision.getTime());
		 *					handleCollisions(firstCollision, colList);
		 *					double time = firstCollision.getTime();
		 *					firstCollision.terminate();
		 *					evolve(dt-time, colList);
		 *				}
		 * 				else {
		 *					accelerate(dt);
		 *					advance(dt);
		 *				}
		 *		  }
		 */
		public void evolve(double dt, CollisionListener colList) throws IllegalComponentException, IllegalRadiusException, IllegalPlacementException, IllegalDoubleException, PlacementOutsideBorderException, IllegalTimeException, IllegalSourceException {
			if(dt>0) {
				Collision firstCollision = this.getFirstCollision(dt);
				if ((firstCollision != null)&&(isValidTime(firstCollision.getTime()))) {
					for(Ship ship: this.getShips()){
						if(ship.getProgram() != null) {
							ship.getProgram().execute();
						}
					}
					accelerate(firstCollision.getTime());
					advance(firstCollision.getTime());
					handleCollisions(firstCollision, colList);
					double time = firstCollision.getTime();
					firstCollision.terminate();
					evolve(dt-time, colList);
				}
				else {
					accelerate(dt);
					advance(dt);
				}
			}
		}
}
