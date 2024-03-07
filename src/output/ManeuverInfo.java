package output;

import input.Satellite;
import input.Vector;

public class ManeuverInfo {
    private double maneuverDirectionX;
    private double maneuverDirectionY;
    private double magnitude;

    // Constructor
    public ManeuverInfo(double maneuverDirectionX, double maneuverDirectionY, double magnitude) {
        this.maneuverDirectionX = maneuverDirectionX;
        this.maneuverDirectionY = maneuverDirectionY;
        this.magnitude = magnitude;
    }

    // Getter methods
    public double getManeuverDirectionX() {
        return maneuverDirectionX;
    }

    public double getManeuverDirectionY() {
        return maneuverDirectionY;
    }

    public double getMagnitude() {
        return magnitude;
    }

    // Method to apply manual maneuver
    public void applyManualManeuver(Satellite satellite) {
        // Get current velocity of the satellite
        Vector currentVelocity = satellite.getVelocity();

        // Calculate new velocity after applying manual maneuver
        double newVelocityX = currentVelocity.getX() + magnitude * maneuverDirectionX;
        double newVelocityY = currentVelocity.getY() + magnitude * maneuverDirectionY;

        // Set the new velocity to the satellite
        satellite.setVelocity(new Vector(newVelocityX, newVelocityY));
    }
}
