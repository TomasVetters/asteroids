package asteroids.model;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Set;

import asteroids.CollisionListener;
import asteroids.IFacade;
import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalRadiusException;
import asteroids.exceptions.IllegalSizeException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.IllegalTimeException;
import asteroids.exceptions.ModelException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.programs.Program;
import asteroids.model.programs.ProgramFactoryImpl;
import asteroids.model.programs.expressions.Expression;
import asteroids.model.programs.parsing.ProgramParser;
import asteroids.model.programs.statements.Statement;
import asteroids.model.programs.types.Type;


public class Facade implements IFacade<World, Ship, Asteroid, Bullet, Program> {
	
    	/**
    	 * Create a new world with the given width and height.
    	 */
		public World createWorld(double width, double height) throws ModelException{
		try {
			World newWorld = new World(width, height);
			return newWorld;
		}
		catch(IllegalSizeException exc) {
			throw new ModelException("The height and/or width is not allowed.");
		}
	}
	
	/**
	  * Return the width of world.
	  */
	public double getWorldWidth(World world) throws ModelException {
		try {
			return world.getWidth();
		}
		catch(NullPointerException exc) {
			throw new ModelException("Not an existing world!");
		}
	}
	
	/**
	  * Return the heigth of world.
	  */
	public double getWorldHeight(World world) throws ModelException {
		try {
			return world.getHeight();
		}
		catch(NullPointerException exc) {
			throw new ModelException("Not an existing world!");
		}
	}
	
	/**
	 * Return the ships located in world.
	 */
	public Set<Ship> getShips(World world) throws ModelException{
		try {
			return world.getShips();
		}
		catch(NullPointerException exc) {
			throw new ModelException("Not an existing world!");
		}
	}
	
	/**
	 * Return the asteroids located in world.
	 */
	public Set<Asteroid> getAsteroids(World world) throws ModelException{
		try {
			return world.getAsteroids();
		}
		catch(NullPointerException exc) {
			throw new ModelException("Not an existing world!");
		}
	}
	
	/**
	 * return the bullets located in world.
	 */
	public Set<Bullet> getBullets(World world) throws ModelException{
		try {
			return world.getBullets();
		}
		catch(NullPointerException exc) {
			throw new ModelException("Not an existing world!");
		}
	}
	
	/**
	 * Add ship to world.
	 */
	public void addShip(World world, Ship ship) throws ModelException {
		try {
			ship.setWorld(world);
			world.addObject(ship);
		}
		catch(IllegalArgumentException exc) {
			throw new ModelException("The given ship is either null or is already added to the given world!");
		}
		catch(IllegalPlacementException pexc) {
			throw new ModelException("Invalid placement of the new ship!");
		}
		catch(NullPointerException nexc) {
			throw new ModelException("NullPointer");
		}
		catch(PlacementOutsideBorderException bexc) {
			 throw new ModelException("An entity was placed outside the borders of the world!");
		 }
	}
	
	/**
	 * Add asteroid to world.
	 */
	public void addAsteroid(World world, Asteroid asteroid) throws ModelException {
		try {
			world.addObject(asteroid);
		}
		catch(IllegalArgumentException exc) {
			throw new ModelException("The given Asteroid is either null or is already added to the given world!");
		}
		catch(IllegalPlacementException pexc) {
			throw new ModelException("Invalid placement of the new asteroid!");
		}
		catch(NullPointerException nexc) {
			throw new ModelException("NullPointer");
		}
		catch(PlacementOutsideBorderException bexc) {
			 throw new ModelException("An entity was placed outside the borders of the world!");
		}
	}
	
	/**
	 * Remove ship from world.
	 */
	public void removeShip(World world, Ship ship) throws ModelException {
		if(ship.getWorld().equals(world)) {
			try {
				ship.terminate();
			}
			catch(NullPointerException exc) {
				throw new ModelException("The ship was not correctly terminated!");
			}
		}
		else {
			throw new ModelException("The ship is not in the given world!");
		}
	}
	
	/**
	 * Remove asteroid from world.
	 */
	public void removeAsteroid(World world, Asteroid asteroid) throws ModelException {
		if(asteroid.getWorld().equals(world)) {
			 try {
				asteroid.terminate();
			 }
			 catch(NullPointerException exc) {
				throw new ModelException("The asteroid was not correctly terminated!");
			 }
		}
	}
	  
	  /**
	   * Check whether o is a ship.
	   */
	  public boolean isShip(Object o) {
		  return o instanceof Ship;
	  }
	
	 /**
	   * Create a new non-null ship with the given position, velocity, radius,
	   * direction and mass.
	   * 
	   * The thruster of the new ship is initially inactive. The ship is not located
	   * in a world.
	   */
	  public Ship createShip(double x, double y, double xVelocity, double yVelocity, double radius, double direction, double mass) throws ModelException {
		  try {
			  Ship ship = new Ship(x,y,xVelocity, yVelocity, radius, direction, mass);
			  return ship;
		  }
		  catch(IllegalComponentException exc) {
			  throw new ModelException("One of the given parameters is not valid!");
		  }
		  catch(IllegalRadiusException rexc) {
			  throw new ModelException("The given radius is not valid!");
		  }
	  }
	  
	  /**
	   * Return the x-coordinate of Ship.
	   */
	  public double getShipX(Ship ship) throws ModelException {
		  try {
			  return ship.getX();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Return the y-coordinate of Ship.
	   */
	  public double getShipY(Ship ship) throws ModelException {
		  try {
			  return ship.getY();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Return the velocity of ship along the X-axis.
	   */
	  public double getShipXVelocity(Ship ship) throws ModelException {
		  try {
			  return ship.getXVelocity();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }

	  /**
	   * Return the velocity of ship along the Y-axis.
	   */
	  public double getShipYVelocity(Ship ship) throws ModelException {
		  try {
			  return ship.getYVelocity();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Return the radius of ship.
	   */
	  public double getShipRadius(Ship ship) throws ModelException {
		  try {
			  return ship.getRadius();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }

	  /**
	   * Return the direction of ship (in radians).
	   */
	  public double getShipDirection(Ship ship) throws ModelException {
		  try {
			  return ship.getDirection();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  /**
	   * Return the mass of ship.
	   */
	  public double getShipMass(Ship ship) throws ModelException {
		  try {
			  return ship.getMass();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Return the world of ship.
	   */
	  public World getShipWorld(Ship ship) throws ModelException {
		  try {
			  return ship.getWorld();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Return whether ship's thruster is active.
	   */
	  public boolean isShipThrusterActive(Ship ship) {
		  return ship.isThrusterActive();
	  }
	  
	  /**
	   * Enables or disables ship's thruster depending on the value of
	   * the parameter active.
	   */
	  public void setThrusterActive(Ship ship, boolean active) {
		  ship.setThrusterActive(active);
	  }
	  
	  /**
	   * Update the direction of ship by adding angle (in radians) to its current direction. Angle may be negative.
	   */
	  public void turn(Ship ship, double angle) throws ModelException {
		   try{
			  ship.turn(angle);
		  }
		  catch(NullPointerException exc){
			  throw new ModelException("The given ship is not an existing ship!");
		  }
	  }
	  
	  /**
	   * Advance world by dt seconds. 
	   */
	  public void evolve(World world, double dt, CollisionListener colList) throws ModelException {
		  try {
			  world.evolve(dt, colList);
		  }
		  catch(IllegalComponentException cexc) {
			  throw new ModelException("Invalid position or velocity during execution!");
		  }
		  catch(IllegalDoubleException dexc) {
			  throw new ModelException("Invalid double was used during execution!");
		  }
		  catch(IllegalRadiusException rexc) {
			  throw new ModelException("Entity with invalid radius spotted!");
		  }
		  catch(IllegalPlacementException pexc) {
			  throw new ModelException("Entity was placed outside the world or on top of an existing entity!");
		  }
		  catch(PlacementOutsideBorderException bexc) {
			  throw new ModelException("An entity was placed outside the borders of the world!");
		  }
		  catch(IllegalTimeException texc) {
			  throw new ModelException("An invalid time was given during the execution!");
		  }
		  catch(IllegalSourceException sexc) {
			  throw new ModelException("An invalid source was given to a bullet!");
		  }
	  }
	  
	  
	  /**
	   * Ship fires a bullet. 
	   */
	  public void fireBullet(Ship ship) throws ModelException{
		  try {
			  ship.fireBullet();
		  }
		  catch(IllegalComponentException cexc) {
			  throw new ModelException("Invalid position or velocity!");
		  }
		  catch(IllegalPlacementException pexc) {
			  throw new ModelException("An invalid placement of an entity occured!");
		  }
		  catch(PlacementOutsideBorderException bexc) {
			  throw new ModelException("An entity was placed outside the borders of the world!");
		  }
		  catch(IllegalSourceException sexc) {
			  throw new ModelException("A bullet was given an invalid source!");
		  }
		  catch(IllegalDoubleException dexc) {
			  throw new ModelException("An illegal double was used!");
		  }
	  }
	  
	  /**
	   * Create a new non-null asteroid with the given position, velocity and radius.
	   * 
	   * The asteroid is not located in a world.
	   */
	  public Asteroid createAsteroid(double x, double y, double xVelocity, double yVelocity, double radius) {
		  
		  try {
			  Asteroid asteroid = new Asteroid(x,y,xVelocity, yVelocity, radius, 0);
			  return asteroid;
		  }
		  catch(IllegalComponentException exc) {
			  throw new ModelException("One of the given parameters is not valid!");
		  }
		  catch(IllegalRadiusException rexc) {
			  throw new ModelException("The given radius is not valid!");
		  }
	  }
	  
	  /**
	   * Create a new non-null asteroid with the given position, velocity,
	   * radius and random direction.
	   * 
	   * The asteroid is not located in a world.
	   */
	  public Asteroid createAsteroid(double x, double y, double xVelocity, double yVelocity, double radius, Random random) {
		  try {
			  Asteroid asteroid = new Asteroid(x,y,xVelocity, yVelocity, radius, random.nextDouble());
			  return asteroid;
		  }
		  catch(IllegalComponentException exc) {
			  throw new ModelException("One of the given parameters is not valid!");
		  }
		  catch(IllegalRadiusException rexc) {
			  throw new ModelException("The given radius is not valid!");
		  }
	  }
	  
	  /**
	   * Check whether o is an asteroid.
	   */
	  public boolean isAsteroid(Object o) {
		  return o instanceof Asteroid;
	  }
	  
	  /**
	   * Return the x-coordinate of asteroid.
	   */
	  public double getAsteroidX(Asteroid asteroid) throws ModelException{
		  try {
			  return asteroid.getX();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing asteroid!");
		  }
	  }

	  /**
	   * Return the y-coordinate of asteroid.
	   */
	  public double getAsteroidY(Asteroid asteroid) throws ModelException {
		  try {
			  return asteroid.getY();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing asteroid!");
		  }
	  }

	  /**
	   * Return the velocity of asteroid along the X-axis.
	   */
	  public double getAsteroidXVelocity(Asteroid asteroid) throws ModelException {
		  try {
			  return asteroid.getXVelocity();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }

	  /**
	   * Return the velocity of asteroid along the Y-axis.
	   */
	  public double getAsteroidYVelocity(Asteroid asteroid) throws ModelException {
		  try {
			  return asteroid.getYVelocity();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Return the radius of asteroid.
	   */
	  public double getAsteroidRadius(Asteroid asteroid) throws ModelException {
		  try {
			  return asteroid.getRadius();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }

	  /**
	   * Return the mass of asteroid.
	   */
	  public double getAsteroidMass(Asteroid asteroid) throws ModelException {
		  try {
			  return asteroid.getMass();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }

	  /**
	   * Return the world of asteroid.
	   */
	  public World getAsteroidWorld(Asteroid asteroid) throws ModelException {
		  try {
			  return asteroid.getWorld();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an existing ship!");
		  }
	  }
	  
	  /**
	   * Check whether o is a bullet.
	   */
	  public boolean isBullets(Object o) {
		  return o instanceof Bullet;
	  }

	  /**
	   * Return the x-coordinate of bullet.
	   */
	  public double getBulletX(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getX();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	  /**
	   * Return the y-coordinate of bullet.
	   */
	  public double getBulletY(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getY();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	  /**
	   * Return the velocity of bullet along the X-axis.
	   */
	  public double getBulletXVelocity(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getXVelocity();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }
	  
	  /**
	   * Return the velocity of bullet along the Y-axis.
	   */
	  public double getBulletYVelocity(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getYVelocity();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	  /**
	   * Return the radius of bullet.
	   */
	  public double getBulletRadius(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getRadius();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	  /**
	   * Return the mass of bullet.
	   */
	  public double getBulletMass(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getMass();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	  /**
	   * Return the world of bullet.
	   */
	  public World getBulletWorld(Bullet bullet) throws ModelException {
		  try {
			  return bullet.getWorld();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	  /**
	   * Return the source of bullet.
	   */
	  public Ship getBulletSource(Bullet bullet)  throws ModelException {
		  try {
			  return bullet.getSource();
		  }
		  catch(NullPointerException exc) {
			  throw new ModelException("Not an exisiting bullet!");
		  }
	  }

	@Override
	public ParseOutcome<Program> parseProgram(String text) {
		 ProgramFactoryImpl factory = new ProgramFactoryImpl();
		 ProgramParser<Expression, Statement, Type> parser = new ProgramParser<>(factory);
		 parser.parse(text);
		 List<String> errors = parser.getErrors();
		 if(! errors.isEmpty()) {
			 return ParseOutcome.failure(errors.get(0));
		 } 
		 else {
			 return ParseOutcome.success(new Program(parser.getGlobals(), parser.getStatement())); 
		 }
	} 
	
	public static String convertStreamToString(InputStream stream) {
		java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	@Override
	public ParseOutcome<Program> loadProgramFromStream(InputStream stream) throws IOException {
		String text = convertStreamToString(stream);
		return parseProgram(text);
	}

	@Override
	public ParseOutcome<Program> loadProgramFromUrl(URL url) throws IOException {
		InputStream in = url.openStream();
		ParseOutcome<Program> outcome =  loadProgramFromStream(in);
		return outcome;
	}

	@Override
	public boolean isTypeCheckingSupported() {
		return false;
	}

	@Override
	public TypeCheckOutcome typeCheckProgram(Program program) {
		return null;
	}

	@Override
	public void setShipProgram(Ship ship, Program program) {
		try {
			ship.setProgram(program);
			program.setShip(ship);
			if(program.getStatement()!=null && ship != null) {
				program.getStatement().setShip(ship);
			}
		}
		catch (NullPointerException nexc) {
			throw new ModelException("The given ship is null!");
		}
		
	}
}
