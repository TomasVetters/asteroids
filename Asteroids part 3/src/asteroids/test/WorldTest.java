package asteroids.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

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
import asteroids.model.Asteroid;
import asteroids.model.Bullet;
import asteroids.model.FlyingObject;
import asteroids.model.Ship;
import asteroids.model.World;



public class WorldTest {
	
	private static World testWorld;
	
	private static FlyingObject testShip1, testAsteroid1, testAsteroid2;
	
	@Before
	public void setUpMutableFixture() throws IllegalComponentException, IllegalRadiusException, IllegalSizeException, IllegalPlacementException, PlacementOutsideBorderException{
		testWorld = new World(1600, 900);
		testShip1 = new Ship(testWorld.getWidth() / 2., testWorld.getHeight() / 2., 0, 0, 40, 0, 5E15);
		testAsteroid1 = new Asteroid(291.6999999999999,483.3999999999980, 25, 50, 60, 0);
		testAsteroid2 = new Asteroid(369.9600000000033, 366.72000000000185, -30, 40, 80, 0);
		testWorld.addObject(testShip1);
		testWorld.addObject(testAsteroid1);
		testWorld.addObject(testAsteroid2);
	}
	
	
	@Test
	public void terminateBullet() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		 ((Ship) testShip1).fireBullet();
		 Set<Bullet> bullets = testWorld.getBullets();
		 for(Bullet bullet: bullets) {
			 bullet.terminate();
		 }
		 Set<Bullet> newBullets = testWorld.getBullets();
		 assertTrue(newBullets.isEmpty());
	}
	
	@Test
	public void testGetVelocity() {
		assertEquals(25, testAsteroid1.getXVelocity(), Util.EPSILON);
		assertEquals(50, testAsteroid1.getYVelocity(), Util.EPSILON);
	}
	
	
	
	@Test
	public void testGetShipsFilled() {
		Set<Ship> ships = testWorld.getShips();
		assertTrue(ships.contains(testShip1));
	}
	
	@Test
	public void testGetShipsEmpty() {
		Set<Ship> ships = testWorld.getShips();
		ships.remove(testShip1);
		assertFalse(ships.contains(testShip1));
	}
	
	@Test
	public void testGetAsteroids() {
		Set<Asteroid> asteroids = testWorld.getAsteroids();
		asteroids.remove(testAsteroid1);
		assertFalse(asteroids.contains(testAsteroid1));
		assertTrue(asteroids.contains(testAsteroid2));
	}
	
	@Test
	public void testFireBullet() throws IllegalComponentException, IllegalPlacementException, PlacementOutsideBorderException, IllegalSourceException, IllegalDoubleException {
		((Ship)testShip1).fireBullet();
		Set<Bullet> bullets = testWorld.getBullets();
		assertFalse(bullets.isEmpty());
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(1600,testWorld.getWidth(),Util.EPSILON);
	}
	
	@Test
	public void testGetHeight() {
		assertEquals(900,testWorld.getHeight(),Util.EPSILON);
	}
	
	@Test
	public void testDeleteObject() {
		testWorld.deleteObject(testAsteroid1);
		assertEquals(1,testWorld.getAsteroids().size(),Util.EPSILON);
		assertEquals(1,testWorld.getShips().size(),Util.EPSILON);
	}
	
	@Test
	public void testInstanceOf() {
		assertFalse(testWorld.isShip(testAsteroid1));
		assertTrue(testWorld.isAsteroid(testAsteroid2));
		assertTrue(testWorld.isShip(testShip1));
	}
	
	@Test
	public void testEvolve() throws IllegalComponentException, IllegalDoubleException, IllegalRadiusException, IllegalPlacementException, PlacementOutsideBorderException, IllegalTimeException {
		testAsteroid1 = null;
		testAsteroid2 = null;
		testShip1.setVelocity(50, 0);
		testWorld.evolve(20, new DummyListener());
		assertEquals(-50, testShip1.getVelocity().getXComponent(), Util.EPSILON);
		assertEquals( 0, testShip1.getVelocity().getYComponent(), Util.EPSILON);
		assertEquals(1320, testShip1.getPosition().getXComponent(), Util.EPSILON);
		assertEquals(450, testShip1.getPosition().getYComponent(), Util.EPSILON);
	}
	
}
