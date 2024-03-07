package detection;

import java.util.Random;

import input.Vector;

public class ManeuverGeneration {
    private static final double MAX_MANEUVER_MAGNITUDE = 1.0; // Maximum magnitude of maneuver

    public static Vector generateManeuver(Vector currentPosition, Vector currentVelocity) {
        // Generate a random maneuver vector with magnitude up to MAX_MANEUVER_MAGNITUDE
        Random rand = new Random();
        double dx = rand.nextDouble() * MAX_MANEUVER_MAGNITUDE;
        double dy = rand.nextDouble() * MAX_MANEUVER_MAGNITUDE;
        
        // Determine the direction of maneuver based on current velocity
        double vx = currentVelocity.getX();
        double vy = currentVelocity.getY();
        double magnitude = Math.sqrt(vx * vx + vy * vy);
        double maneuverDirectionX = -vy / magnitude; // perpendicular to velocity
        double maneuverDirectionY = vx / magnitude; // perpendicular to velocity

        // Apply maneuver in the determined direction
        double newX = currentPosition.getX() + dx * maneuverDirectionX;
        double newY = currentPosition.getY() + dy * maneuverDirectionY;
        
        return new Vector(newX, newY);
    }
}
