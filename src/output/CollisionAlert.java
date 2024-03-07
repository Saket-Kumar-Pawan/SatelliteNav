package output;

import java.text.DecimalFormat;

import input.Vector;

public class CollisionAlert {
    public static void generateAlert(Vector predictedPosition1, Vector predictedPosition2, double collisionThreshold, double velocity) {
        double timeToCollision = calculateTimeToCollision(predictedPosition1, predictedPosition2, velocity);
        
        if (timeToCollision >= 0) {
            System.out.println("Collision Alert: Satellites are on a collision course!");
            System.out.println("Time remaining until collision: " + formatTime(timeToCollision) + " seconds");
        } else {
            System.out.println("No collision detected.");
        }
    }

    private static double calculateTimeToCollision(Vector predictedPosition1, Vector predictedPosition2, double velocity) {
        // Calculate the distance between the predicted positions
        double dx = predictedPosition1.getX() - predictedPosition2.getX();
        double dy = predictedPosition1.getY() - predictedPosition2.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Calculate the relative velocity of the satellites
        double relativeVelocity = velocity; // assuming constant velocity

        // Calculate the time to collision based on the distance and relative velocity
        if (relativeVelocity == 0) {
            return -1; // No collision if relative velocity is zero
        } else {
            return distance / relativeVelocity;
        }
    }

    private static String formatTime(double timeInSeconds) {
        // Format time in seconds to a more readable format
        DecimalFormat df = new DecimalFormat("#.##");
        double hours = timeInSeconds / 3600;
        double minutes = (timeInSeconds % 3600) / 60;
        double seconds = timeInSeconds % 60;
        return df.format(hours) + " hours, " + df.format(minutes) + " minutes, " + df.format(seconds) + " seconds";
    }
}
