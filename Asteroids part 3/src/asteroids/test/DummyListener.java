package asteroids.test;

import asteroids.CollisionListener;



public class DummyListener implements CollisionListener {
	
@Override
public void boundaryCollision(Object entity, double x, double y) {}

@Override
public void objectCollision(Object entity1, Object entity2, double x, double y) {}

}