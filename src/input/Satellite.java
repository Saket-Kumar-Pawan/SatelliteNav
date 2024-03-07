package input;

public class Satellite {
	private static int nextId = 1;
	private int id;
    private Vector position;
    private Vector velocity;

    // Constructor to initialize position and velocity
    public Satellite(Vector position, Vector velocity) {
    	this.id = nextId++;
        this.position = position;
        this.velocity = velocity;
    }
    public int getId() {
        return id;
    }

    // Getter method for position
    public Vector getPosition() {
        return position;
    }

    // Setter method for position
    public void setPosition(Vector position) {
        this.position = position;
    }

    // Getter method for velocity
    public Vector getVelocity() {
        return velocity;
    }

    // Setter method for velocity
    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
}
