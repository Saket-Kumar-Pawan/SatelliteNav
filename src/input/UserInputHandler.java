package input;

import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public void getUserInput(Satellite satellite) {
        System.out.println("Enter details for Satellite " + satellite.getId() + ":");
        System.out.print("Enter x-position (in km): ");
        double xPosition = scanner.nextDouble();
        System.out.print("Enter y-position (in km): ");
        double yPosition = scanner.nextDouble();
        System.out.print("Enter x-velocity (in km/s): ");
        double xVelocity = scanner.nextDouble();
        System.out.print("Enter y-velocity (in km/s): ");
        double yVelocity = scanner.nextDouble();

        // Set satellite parameters based on user input
        satellite.setPosition(new Vector(xPosition, yPosition));
        satellite.setVelocity(new Vector(xVelocity, yVelocity));
    }

    public boolean requestCollisionCheck() {
        System.out.print("Do you want to check for collisions? (Y/N): ");
        String userInput = scanner.next().trim().toUpperCase();
        return userInput.equals("Y");
    }

    public boolean requestReset() {
        System.out.print("Do you want to reset with fresh data? (Y/N): ");
        String userInput = scanner.next().trim().toUpperCase();
        return userInput.equals("Y");
    }

    public void closeScanner() {
        scanner.close();
    }
}
