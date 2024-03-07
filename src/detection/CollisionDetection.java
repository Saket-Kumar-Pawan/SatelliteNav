package detection;

import input.Vector;

public class CollisionDetection {
    private static final double DEFAULT_COLLISION_THRESHOLD = 100.0;

    public static double predictTimeToCollision(Vector position1, Vector velocity1, Vector position2, Vector velocity2, double collisionThreshold) {
        double relativeVelocityX = velocity1.getX() - velocity2.getX();
        double relativeVelocityY = velocity1.getY() - velocity2.getY();

        double relativeDistanceX = position2.getX() - position1.getX();
        double relativeDistanceY = position2.getY() - position1.getY();

        double a = relativeVelocityX * relativeVelocityX + relativeVelocityY * relativeVelocityY;
        double b = 2 * (relativeVelocityX * relativeDistanceX + relativeVelocityY * relativeDistanceY);
        double c = relativeDistanceX * relativeDistanceX + relativeDistanceY * relativeDistanceY - collisionThreshold * collisionThreshold;

        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return Double.POSITIVE_INFINITY;
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double t1 = (-b + sqrtDiscriminant) / (2 * a);
        double t2 = (-b - sqrtDiscriminant) / (2 * a);

        if (t1 > 0 && t2 > 0) {
            return Math.min(t1, t2);
        } else if (t1 > 0) {
            return t1;
        } else if (t2 > 0) {
            return t2;
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    public static double getDefaultCollisionThreshold() {
        return DEFAULT_COLLISION_THRESHOLD;
    }

    public static boolean isCollision(Vector predictedPosition1, Vector predictedPosition2, double collisionThreshold) {
        double dx = predictedPosition1.getX() - predictedPosition2.getX();
        double dy = predictedPosition1.getY() - predictedPosition2.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < collisionThreshold;
    }
}
