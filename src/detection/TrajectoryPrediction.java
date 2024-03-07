package detection;

import input.Vector;

public class TrajectoryPrediction {
    public static Vector predictNextPosition(Vector currentPosition, Vector currentVelocity, double time) {
        // Predict the next position based on current position, velocity, and time
        double newX = currentPosition.getX() + currentVelocity.getX() * time;
        double newY = currentPosition.getY() + currentVelocity.getY() * time;
        return new Vector(newX, newY);
    }
}
