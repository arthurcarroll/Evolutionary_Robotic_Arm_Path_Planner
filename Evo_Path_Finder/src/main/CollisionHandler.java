package main;

import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.RigidBodyControl;

/**
 *
 * @author Arthur Carroll
 */
public class CollisionHandler extends RigidBodyControl implements PhysicsCollisionListener {

    private Path p;

    public void collision(PhysicsCollisionEvent event) {
        System.out.println("collision");
        if (p != null) {
            if (event.getNodeA().getName().compareToIgnoreCase("obstacle") == 0 && event.getNodeB().getName().compareToIgnoreCase("robot") == 0) {
                p.addCollision();
            }
        } else {
            System.out.println("null path");
        }
    }

    public Path getP() {
        return p;
    }

    public void setPath(Path p) {
        this.p = p;
    }
}
