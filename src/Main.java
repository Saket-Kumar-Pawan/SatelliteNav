import detection.CollisionDetection;
import detection.TrajectoryPrediction;
import input.*;
import output.SimulationResults;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Get input for Satellite 1
            System.out.println("Enter details for Satellite 1:");
            Satellite satellite1 = new Satellite(null, null);
            inputSatelliteData(satellite1);

            // Get input for Satellite 2
            System.out.println("Enter details for Satellite 2:");
            Satellite satellite2 = new Satellite(null, null);
            inputSatelliteData(satellite2);

            // Check for collision if requested
            if (requestCollisionCheck(scanner)) {
                Vector predictedPosition1 = TrajectoryPrediction.predictNextPosition(satellite1.getPosition(), satellite1.getVelocity(), 60); // Predict next position after 1 minute
                Vector predictedPosition2 = TrajectoryPrediction.predictNextPosition(satellite2.getPosition(), satellite2.getVelocity(), 60); // Predict next position after 1 minute

                double collisionThreshold = 100.0; // Adjust threshold as needed
                boolean collisionDetected = CollisionDetection.isCollision(predictedPosition1, predictedPosition2, collisionThreshold);
                if (collisionDetected) {
                    double timeToCollision = calculateTimeToCollision(predictedPosition1, predictedPosition2, satellite1.getVelocity());
                    double distanceToCollision = calculateDistance(predictedPosition1, predictedPosition2);
                    String collisionType = "Type A"; // Example collision type
                    SimulationResults results = new SimulationResults(true, timeToCollision, distanceToCollision, collisionType);
                    results.displayResults();
                } else {
                    System.out.println("No collision detected between Satellite 1 and Satellite 2.");
                }
            } else {
                System.out.println("No collision check requested.");
            }

            // Ask if the user wants to reset or exit
            System.out.print("Do you want to reset with fresh data? (Y/N): ");
            String resetChoice = scanner.next().trim().toUpperCase();
            if (!resetChoice.equals("Y")) {
                break;
            }
        }

        scanner.close();
    }

    private static void inputSatelliteData(Satellite satellite) {
        UserInputHandler inputHandler = new UserInputHandler();
        inputHandler.getUserInput(satellite);
    }

    private static boolean requestCollisionCheck(Scanner scanner) {
        System.out.print("Do you want to check for collisions? (Y/N): ");
        String userInput = scanner.next().trim().toUpperCase();
        return userInput.equals("Y");
    }

    private static double calculateTimeToCollision(Vector predictedPosition1, Vector predictedPosition2, Vector velocity) {
        // ... 
    	// Calculate the distance between the predicted positions
        double dx = predictedPosition1.getX() - predictedPosition2.getX();
        double dy = predictedPosition1.getY() - predictedPosition2.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Calculate the relative velocity of the satellites
        double relativeVelocity = Math.sqrt(velocity.getX() * velocity.getX() + velocity.getY() * velocity.getY()); // Assuming constant velocity

        // Calculate the time to collision based on the distance and relative velocity
        if (relativeVelocity == 0) {
            return -1; // No collision if relative velocity is zero
        } else {
            return distance / relativeVelocity;
        }
    }

    private static double calculateDistance(Vector vector1, Vector vector2) {
        // ... 
    	double dx = vector1.getX() - vector2.getX();
        double dy = vector1.getY() - vector2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
