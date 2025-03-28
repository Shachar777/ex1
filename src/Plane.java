/**
 * Represents a Plane that can move between two locations and be compared based on its maximal height.
 * Implements {@code Movable} and {@code Comparable} interfaces.
 */
public class Plane implements Movable, Comparable {
    /** The maximum allowed height for the plane. */
    public static final int HEIGHT_LIMIT = 1500;

    /** The license number of the plane. */
    int licenceNumber;

    /** The source location of the plane. */
    Location source;

    /** The destination location of the plane. */
    Location destination;

    /** The maximum height the plane can reach. */
    int maximalHeight;

    /**
     * Constructs a new Plane with the specified ID, source, destination, and maximal height.
     *
     * @param id the license number of the plane
     * @param src the starting location of the plane
     * @param dst the destination location of the plane
     * @param maxHeight the maximum height the plane can reach
     */
    public Plane(int id, Location src, Location dst, int maxHeight) {
        licenceNumber = id;
        source = src;
        destination = dst;
        maximalHeight = maxHeight;
    }

    /**
     * Returns a string representation of the plane.
     *
     * @return a formatted string containing the plane's details
     */
    @Override
    public String toString() {
        return String.format("licence = %d, source = %s, destination = %s, maxHeight = %d",
                licenceNumber, source, destination, maximalHeight);
    }

    /**
     * Returns the type of the vehicle.
     *
     * @return the string "Plane"
     */
    @Override
    public String getType() {
        return "Plane";
    }

    /**
     * Returns the license number of the plane.
     *
     * @return the plane's ID
     */
    @Override
    public int getId() {
        return licenceNumber;
    }

    /**
     * Returns the source location of the plane.
     *
     * @return the source location
     */
    @Override
    public Location getSource() {
        return source;
    }

    /**
     * Returns the destination location of the plane.
     *
     * @return the destination location
     */
    @Override
    public Location getDestination() {
        return destination;
    }

    /**
     * Returns the current location of the plane as a string.
     *
     * @return the string representation of the current location
     */
    @Override
    public String getCurrentLocation() {
        return this.source.toString();
    }

    /**
     * Moves the plane by swapping its source and destination locations.
     */
    @Override
    public void move() {
        Location tmp = source;
        source = destination;
        destination = tmp;
    }

    /**
     * Compares this plane with another plane based on maximal height.
     *
     * @param o the object to compare with
     * @return the difference in maximal height between this plane and the other plane
     * @throws ClassCastException if the object is not a Plane
     */
    @Override
    public int compareTo(Object o) {
        return maximalHeight - ((Plane)o).maximalHeight;
    }
}