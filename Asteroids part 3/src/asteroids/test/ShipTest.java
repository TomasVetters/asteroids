package asteroids.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import asteroids.Util;
import asteroids.exceptions.IllegalComponentException;
import asteroids.exceptions.IllegalDoubleException;
import asteroids.exceptions.IllegalPlacementException;
import asteroids.exceptions.IllegalRadiusException;
import asteroids.exceptions.IllegalSizeException;
import asteroids.exceptions.IllegalSourceException;
import asteroids.exceptions.IllegalTimeException;
import asteroids.exceptions.PlacementOutsideBorderException;
import asteroids.model.FlyingObject;
import asteroids.model.Ship;
import asteroids.model.Vector;
import asteroids.model.World;



/**
 * A class with tests for all public methods of the class Ship.
 * @author Tomas and Steven
 *
 */
public class ShipTest {
	/**
	 * Variable referencing a ship with default properties.
	 */
	private static Ship defaultShip;
	
	
	/**
	 * Variables referencing ships with given properties.
	 */
	private static Ship movingShip1, movingShip2;
	
	private static World testWorld;
	/**
	 * Set up a mutable test fixture.
	 * 
	 * @post 	The variable movingShip1 references a new ship with position (5,10), velocity (4,6), radius 20 and angle 50.
	 * @post	The variable movingShip2 references a new ship with position (-5,4), velocity (-6,-8), radius 15 and angle -30.
	 * @throws 	IllegalDoubleException
	 * 			One of the given parameters is NaN.
	 * @throws 	IllegalRadiusException
	 * 			The given radius for one of the ships is not valid.
	 * @throws IllegalSizeException 
	 * @throws PlacementOutsideBorderException 
	 * @throws IllegalPlacementException 
	 */
	@Before
	public void setUpMutableFixture() throws IllegalComponentException, IllegalRadiusException, IllegalSizeException, IllegalPlacementException, PlacementOutsideBorderException{
		movingShip1 = new Ship(500, 100, 4, 6, 20, 50, 5E15);
		movingShip2 = new Ship(200, 300, -6, -8, 15, -30, 5E15);
		testWorld = new World(1000, 1000);
		testWorld.addObject(movingShip1);
		testWorld.addObject(movingShip2);
	}
	

	/**
	 * A method testing an illegal case (illegal radius) of the non-default constructor.
	 */
	@Test(expected=IllegalRadiusException.class)
	public void createIllegalRadiusShip() throws IllegalRadiusException, IllegalComponentException{
		@SuppressWarnings("unused")
		Ship illegalShip = new Ship(5,10,4,6,-5,10,5E15);
	}
	
	/**
	 * A method testing an illegal case (using NaN) of the non-default constructor.
	 */
	@Test(expected=IllegalComponentException.class)
	public void createIllegalDoubleShip() throws IllegalRadiusException, IllegalComponentException{
		@SuppressWarnings("unused")
		Ship illegalShip = new Ship(Double.NaN,10,4,6,12,10, 5E15);
	}
	
	/**
	 * A method testing the getter-methods of the position of the ship.
	 */
	@Test
	public void checkPosition() {
		assertEquals(500, movingShip1.getX(), Util.EPSILON);
		assertEquals(100, movingShip1.getY(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-methods of the position of the ship.
	 */
	@Test
	public void setPositionLegalCase() throws IllegalComponentException {
		movingShip1.setPosition(15,25);
		assertEquals(15, movingShip1.getX(), Util.EPSILON);
		assertEquals(25, movingShip1.getY(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method of the position of the ship with an infinity value.
	 */
	
	@Test (expected = IllegalComponentException.class)
	public void setPositionInfinity() throws IllegalComponentException {
		movingShip1.setPosition(Double.POSITIVE_INFINITY,10);
		
	}
	
	/**
	 * A method testing the getter-method of the speedlimit variable (default value).
	 */
	@Test
	public void getSpeedLimit() {
		assertEquals(300000, movingShip1.getSpeedLimit(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method of the speedlimit variable.
	 */
	@Test
	public void setSpeedLimitLegalCase() {
		movingShip1.setSpeedLimit(100000);
		assertEquals(100000, movingShip1.getSpeedLimit(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method of speedlimit with a negative value.
	 */
	@Test
	public void setNegativeSpeedLimit() {
		movingShip1.setSpeedLimit(-100000);
		assertEquals(0, movingShip1.getSpeedLimit(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for speedlimit with a value that is too high.
	 */
	@Test 
	public void setTooHighSpeedLimit() {
		movingShip1.setSpeedLimit(2000000);
		assertEquals(300000, movingShip1.getSpeedLimit(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for speedlimit with an infinity value.
	 */
	@Test
	public void setSpeedLimitInfinity() {
		movingShip1.setSpeedLimit(Double.POSITIVE_INFINITY);
		assertEquals(300000, movingShip1.getSpeedLimit(), Util.EPSILON);
	}
	
	/**
	 * A method testing the legal case of the setter-method for the velocity.
	 */
	@Test
	public void setVelocityLegalCase() throws IllegalComponentException {
		movingShip1.setVelocity(10, 15);
		assertEquals(10, movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(15, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for the velocity with an infinity value.
	 */
	@Test
	public void setVelocityLegalCaseInfinity() throws IllegalComponentException {
		movingShip1.setVelocity(Double.POSITIVE_INFINITY, 15);
		assertEquals(Math.abs(Math.cos(movingShip1.getDirection())*movingShip1.getSpeedLimit()), movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(Math.abs(Math.sin(movingShip1.getDirection())*movingShip1.getSpeedLimit()), movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for the velocity with value that is too high.
	 */
	@Test
	public void setVelocityHigherThanSpeedLimit() throws IllegalComponentException {
		movingShip1.setDirection(0);
		movingShip1.setVelocity(350000, 370000);
		assertEquals(movingShip1.getSpeedLimit(), movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(0, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for the velocity with value that is NaN.
	 */
	@Test
	public void setVelocityIllegalNumber() throws IllegalComponentException {
		movingShip1.setVelocity(15, 20);
		movingShip1.setVelocity(Double.NaN, 25);
		assertEquals(15, movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(20, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for the radius with an acceptable value.
	 */
	@Test
	public void setOrientationLegalCasePositive() {
		movingShip1.setDirection(3*Math.PI);
		assertEquals(Math.PI, movingShip1.getDirection(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for the radius with a negative value.
	 */
	@Test
	public void setOrientationLegalCaseNegative() {
		movingShip1.setDirection(-(Math.PI)/2);
		assertEquals(1.5*(Math.PI), movingShip1.getDirection(), Util.EPSILON);
	}
	
	/**
	 * A method testing the setter-method for the radius with an infinity value.
	 */
	@Test (expected = AssertionError.class)
	public void setOrientationIllegalCaseInfinity() {
		movingShip1.setDirection(Double.POSITIVE_INFINITY);
	}
	
	/**
	 * A method testing the setter-method for the radius with a NaN value.
	 */
	@Test (expected=AssertionError.class)
	public void setOrientationIllegalCaseNaN() {
		movingShip1.setDirection(Double.NaN);
	}
	
	@Test
	public void testTerminate() {
		movingShip1.terminate();
		assertTrue(movingShip1.isTerminated());
		assertEquals(null,movingShip1.getWorld());
		assertFalse(testWorld.getShips().contains(movingShip1));
	}
	
	@Test
	public void testMassLegalCase() {
		movingShip1.setMass(4E15);
		assertEquals(4E15, movingShip1.getMass(), Util.EPSILON);
	}
	
	@Test (expected = AssertionError.class)
	public void testMassIllegalCase() {
		movingShip1.setMass(-1000);
	}
	
	@Test 
	public void testOverlapBorderFalse() {
		assertFalse(movingShip1.overlapBorder(testWorld));
	}
	
	@Test
	public void testOverlapBorderTrue() throws IllegalComponentException {
		movingShip1.setPosition(10,10);
		assertTrue(movingShip1.overlapBorder(testWorld));
	}
	
	@Test
	public void testSetWorldLegalCase() {
		assertEquals(testWorld, movingShip1.getWorld());
	}
	
	@Test
	public void testGetTimeToCollisionBorder() {
		assertEquals(120, movingShip1.getTimeToCollisionBorder(), Util.EPSILON);
	}
	
	@Test
	public void testFireBullet() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		movingShip1.fireBullet();
		assertFalse(testWorld.getBullets().isEmpty());
	}
	
	@Test
	public void testGetForce() {
		assertEquals(1.1E18,movingShip1.getForce(),Util.EPSILON);
	}
	
	@Test
	public void testThrusterActive() {
		assertFalse(movingShip1.isThrusterActive());
	}
	
	@Test
	public void testThrusterActivePositive() {
		movingShip1.setThrusterActive(true);
		assertTrue(movingShip1.isThrusterActive());
	}
	
	@Test
	public void testThrusterActiveNegative() {
		movingShip1.setThrusterActive(false);
		assertFalse(movingShip1.isThrusterActive());
	}
	
	/**
	 * A method testing the checker-method whether the given number is a valid value for the variable radius 
	 * with an acceptable value.
	 */
	@Test
	public void isValidRadiusLegalCase() {
		assertTrue(Ship.isValidRadius(200000));
	}
	
	/**
	 * A method testing the checker-method whether the given number is a valid value for the variable radius 
	 * with a value that is too low.
	 */
	@Test
	public void isValidRadiusIllegalCaseTooLow() {
		assertFalse(Ship.isValidRadius(-5000));
	}
	
	/**
	 * A method testing the checker-method whether the given number is a valid value for the variable radius 
	 * with a NaN value.
	 */
	@Test
	public void isValidRadiusIllegalCaseNaN() {
		assertFalse(Ship.isValidRadius(Double.NaN));
	}
	
	/**
	 * A method testing the move-method in a legal way.
	 */
	@Test
	public void moveLegalCase() throws IllegalComponentException, IllegalTimeException {
		movingShip1.setPosition(0,0);
		movingShip1.setVelocity(10, 0);
		movingShip1.move(500);
		assertEquals(5000, movingShip1.getX(), Util.EPSILON);
		assertEquals(0, movingShip1.getY(), Util.EPSILON);
	}
	
	/**
	 * A method testing the move-method with an infinity-value.
	 */
	@Test (expected = IllegalTimeException.class)
	public void moveLegalCaseInfinity() throws IllegalComponentException, IllegalTimeException {
		movingShip1.setPosition(0,0);
		movingShip1.setVelocity(10, -8);
		movingShip1.move(Double.POSITIVE_INFINITY);
		
	}
	
	/**
	 * A method testing the move-method with a NaN value.
	 */
	@Test (expected= IllegalTimeException.class)
	public void moveIllegalCaseNaN() throws IllegalComponentException, IllegalTimeException {
		movingShip1.move(Double.NaN);
	}
	
	/**
	 * A method testing the move-method with a negative value.
	 */
	@Test (expected= IllegalTimeException.class)
	public void moveIllegalCaseNegativeTime() throws IllegalComponentException, IllegalTimeException {
		movingShip1.move(-50000);
	}
	
	/**
	 * A method testing the checker-method whether the given value is a valid amount of time
	 * with an acceptable value.
	 */
	@Test
	public void isValidTimeLegalCase() {
		assertTrue(FlyingObject.isValidTime(200000));
	}
	
	/**
	 * A method testing the checker-method whether the given value is a valid amount of time
	 * with a value that is too low.
	 */
	@Test
	public void isValidTimeIllegalCaseTooLow() {
		assertFalse(FlyingObject.isValidTime(-5000));
	}
	
	/**
	 * A method testing the checker-method whether the given value is a valid amount of time
	 * with a NaN value.
	 */
	@Test
	public void isValidTimeIllegalCaseNaN() {
		assertFalse(FlyingObject.isValidTime(Double.NaN));
	}
	
	/**
	 * A method testing the turn-method with an acceptable value.
	 */
	@Test
	public void turnLegalCase() {
		movingShip1.setDirection(0);
		movingShip1.turn(3*Math.PI);
		assertEquals(Math.PI, movingShip1.getDirection(), Util.EPSILON);
	}
	
	/**
	 * A method testing the turn-method with an infinity value.
	 */
	@Test (expected = AssertionError.class)
	public void turnLegalCaseInfinity() {
		movingShip1.turn(Double.POSITIVE_INFINITY);
	}
	
	/**
	 * A method testing the turn-method with a NaN value.
	 */
	@Test (expected = AssertionError.class)
	public void turnIllegalCaseNaN() {
		movingShip1.turn(Double.NaN);
	}
	
	/**
	 * A method testing the thrust-method with an acceptable value.
	 */
	@Test
	public void thrustLegalCase() throws IllegalComponentException {
		movingShip1.setDirection((Math.PI)/4);
		movingShip1.setVelocity(10, -8);
		movingShip1.thrust(10*Math.sqrt(2));
		assertEquals(2210, movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(2192, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the thrust-method with an infinity value.
	 */
	@Test
	public void thrustLegalCaseInfinity() throws IllegalComponentException {
		movingShip1.setDirection((Math.PI)/4);
		movingShip1.setVelocity(10, -8);
		movingShip1.thrust(Double.POSITIVE_INFINITY);
		assertEquals(300000*(Math.sqrt(2))/2, movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(300000*(Math.sqrt(2))/2, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the thrust-method with a negative value.
	 */
	@Test
	public void thrustIllegalCaseNegative() throws IllegalComponentException {
		movingShip1.setVelocity(10, -8);
		movingShip1.thrust(-10*Math.sqrt(2));
		assertEquals(10, movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(-8, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the thrust-method with a NaN value.
	 */
	@Test
	public void thrustIllegalCaseNaN() throws IllegalComponentException {
		movingShip1.setVelocity(10, -8);
		movingShip1.thrust(Double.NaN);
		assertEquals(10, movingShip1.getXVelocity(), Util.EPSILON);
		assertEquals(-8, movingShip1.getYVelocity(), Util.EPSILON);
	}
	
	/**
	 * A method testing the getDistanceBetween-method in an acceptable case.
	 */
	@Test
	public void distanceBetweenLegalCase() throws NullPointerException, IllegalComponentException {
		movingShip1.setPosition(10,10);
		movingShip2.setPosition(50,10);
	    assertEquals(5, movingShip1.getDistanceBetween(movingShip2), Util.EPSILON) ;
	}
	
	/**
	 * A method testing the getDistanceBetween-method in the case where the two ships are the same ship.
	 */
	@Test
	public void distanceBetweenLegalCaseSameShip()  {
		assertEquals(0,movingShip1.getDistanceBetween(movingShip1),Util.EPSILON);
	}
	
	/**
	 * A method testing the getDistanceBetween-method in an case where one of the positions is infinity.
	 */
	@Test (expected = IllegalComponentException.class)
	public void distanceBetweenLegalCaseInfinity() throws NullPointerException, IllegalComponentException {
		movingShip1.setPosition(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		movingShip2.setPosition(50, 10);
		
	}
	
	/**
	 * A method testing the getDistanceBetween-method in a case where the x-coordinate of both ships is infinity.
	 */
	@Test  (expected = IllegalComponentException.class)
	public void distanceBetweenIllegalCaseInfinity() throws NullPointerException, IllegalComponentException {
		movingShip1.setPosition(Double.POSITIVE_INFINITY,10);
		movingShip2.setPosition(Double.POSITIVE_INFINITY,10);
	}
	
	/**
	 * A method testing the getDistanceBetween-method in a case where one of the given ships is null.
	 */
	@Test (expected = NullPointerException.class)
	public void distanceBetweenIllegalCaseNullShip() throws NullPointerException {
		Ship movingShip3 = null;
		movingShip1.getDistanceBetween(movingShip3);
	}
	
	/**
	 * A method testing the overlap-method in a case where the two different ships overlap.
	 */
	@Test
	public void overlapLegalCaseTrue() throws IllegalComponentException {
		movingShip1.setPosition(10,10);
		movingShip2.setPosition(20,20);
		assertTrue(movingShip1.overlap(movingShip2));
	}
	
	/**
	 * A method testing the overlap-method in a case where the two different ships do not overlap.
	 */
	@Test
	public void overlapLegalCaseFalse() throws IllegalComponentException {
		movingShip1.setPosition(10,10);
		movingShip2.setPosition(200,20);
		assertFalse(movingShip1.overlap(movingShip2));
	}
	
	/**
	 * A method testing the overlap-method in a case where the two ships are the same ship.
	 */
	@Test
	public void overlapLegalCaseSameShip() {
		assertTrue(movingShip1.overlap(movingShip1));
	}
	
	/**
	 * A method testing the overlap-method in a case where one of the two ships is null.
	 */
	@Test (expected = NullPointerException.class)
	public void overlapIllegalCaseNullShip() throws NullPointerException {
		Ship movingShip3 = null;
		movingShip1.overlap(movingShip3);
	}
	
	/**
	 * A method testing the getTimeToCollision-method in a legal case where the two ships will collide.
	 */
	@Test
	public void getTimeToCollisionLegalCaseTrue() throws IllegalComponentException {
		movingShip1.setPosition(-40,0);
		movingShip2.setPosition(35,0);
		movingShip1.setVelocity(10,0);
		movingShip2.setVelocity(0,0);
		assertEquals(4, movingShip1.getTimeToCollision(movingShip2), Util.EPSILON);
	}
	
	/**
	 * A method testing the getTimeToCollision-method in a legal case where the two ships will not collide.
	 */
	@Test
	public void getTimeToCollisionLegalCaseFalse() throws IllegalComponentException {
		movingShip1.setPosition(-40,0);
		movingShip2.setPosition(35,0);
		movingShip1.setVelocity(0,50);
		movingShip2.setVelocity(0,0);
		assertEquals(Double.POSITIVE_INFINITY, movingShip1.getTimeToCollision(movingShip2), Util.EPSILON);
	}
	
	/**
	 * A method testing the getTimeToCollision-method in a legal case where the position of one of the ships is infinity.
	 */
	@Test (expected = IllegalComponentException.class)
	public void getTimeToCollisionLegalCaseInfinity() throws IllegalComponentException {
		movingShip1.setPosition(Double.POSITIVE_INFINITY,0);
		movingShip2.setPosition(35,0);
		movingShip1.setVelocity(0,0);
		movingShip2.setVelocity(1000,0);
	}
	
	/**
	 * A method testing the getTimeToCollision-method in a legal case where one of the ships is null.
	 */
	@Test (expected=NullPointerException.class)
	public void getTimeToCollisionIllegalCaseNullShip() throws NullPointerException {
		Ship movingShip3 = null;
		movingShip1.getTimeToCollision(movingShip3);
	}
	
	
	/**
	 * A method testing the getCollisionPosition-method in a legal case where the two ships will not collide.
	 */
	@Test
	public void getCollisionPositionLegalCaseNull() throws IllegalComponentException, IllegalDoubleException {
		movingShip1.setPosition(-10,0);
		movingShip2.setPosition(30,0);
		movingShip1.setVelocity(0,30);
		movingShip2.setVelocity(0,10);
		assertEquals(null, movingShip1.getCollisionPosition(movingShip2));
	}
	
	/**
	 * A method testing the getCollisionPosition-method in a legal case where the two ships will collide.
	 */
	@Test
	public void getCollisionPositionLegalCaseTrue() throws IllegalComponentException, IllegalDoubleException{
		movingShip1.setPosition(-40,0);
		movingShip2.setPosition(35,0);
		movingShip1.setVelocity(10,0);
		movingShip2.setVelocity(-10,0);
		Vector position = movingShip1.getCollisionPosition(movingShip2);
		assertEquals(0, position.getXComponent(), Util.EPSILON);
		assertEquals(0, position.getYComponent(), Util.EPSILON);
	}
	
	/**
	 * A method testing the getCollisionPosition-method in an illegal case where the x-coordinate of the two ships is infinity.
	 */
	@Test (expected=IllegalComponentException.class)
	public void getCollisionPositionIllegalCaseInfinity() throws IllegalDoubleException, IllegalComponentException{
		movingShip1.setPosition(Double.POSITIVE_INFINITY,100);
		movingShip2.setPosition(Double.POSITIVE_INFINITY,0);
		movingShip1.setVelocity(0,-10);
		movingShip2.setVelocity(0,10);
		movingShip1.getCollisionPosition(movingShip2);
	}
	
	/**
	 * A method testing the getCollisionPosition-method in a legal case where the x-coordinate of one of the two ships is infinity.
	 */
	@Test (expected=IllegalComponentException.class)
	public void getCollisionPositionIllegalCaseInfinity2() throws IllegalDoubleException, IllegalComponentException{
		movingShip1.setPosition(Double.POSITIVE_INFINITY,0);
		movingShip2.setPosition(100,0);
		movingShip1.setVelocity(0,0);
		movingShip2.setVelocity(100000,0);
		movingShip1.getCollisionPosition(movingShip2);
	}
	
	/**
	 * A method testing the getCollisionPosition-method in an illegal case where one of the ships is null.
	 * @throws IllegalComponentException 
	 */
	@Test (expected=NullPointerException.class)
	public void getCollisionPositionIllegalCaseNullShip() throws IllegalDoubleException, NullPointerException, IllegalComponentException{
		Ship movingShip3 = null;
		movingShip1.getCollisionPosition(movingShip3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}