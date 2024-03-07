package output;

public class SimulationResults {
    private boolean collisionDetected;
    private double timeToCollision;
    private double distanceToCollision;
    private String collisionType;

    // Constructor
    public SimulationResults(boolean collisionDetected, double timeToCollision, double distanceToCollision, String collisionType) {
        this.collisionDetected = collisionDetected;
        this.timeToCollision = timeToCollision;
        this.distanceToCollision = distanceToCollision;
        this.collisionType = collisionType;
    }

    // Getter methods
    public boolean isCollisionDetected() {
        return collisionDetected;
    }

    public double getTimeToCollision() {
        return timeToCollision;
    }

    public double getDistanceToCollision() {
        return distanceToCollision;
    }

    public String getCollisionType() {
        return collisionType;
    }

    // Method to display simulation results
    public void displayResults() {
        System.out.println("Simulation Results:");
        System.out.println("Collision Detected: " + collisionDetected);
        if (collisionDetected) {
            System.out.println("Time to Collision: " + timeToCollision + " seconds");
            System.out.println("Distance to Collision: " + distanceToCollision + " km");
            System.out.println("Collision Type: " + collisionType);
        }
    }
}
