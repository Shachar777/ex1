/**
 * Represents a Train that can move between multiple stations and be compared based on its passenger capacity.
 * Implements {@code Comparable} and {@code Movable} interfaces.
 */
public class Train implements Comparable, Movable {
    /** The maximum number of passengers a train can hold. */
    public static final int PASSENGER_LIMIT = 500;

    /** The maximum number of stations a train can travel through. */
    public static final int STATION_LIMIT = 5;

    /** The license number of the train. */
    int licenceNumber;

    /** The source location of the train. */
    Location source;

    /** The destination location of the train. */
    Location destination;

    /** The total number of stations between the source and destination. */
    int numberOfStations;

    /** The current station number where the train is located. */
    int currentStation;

    /** The maximum number of passengers allowed on the train. */
    int maximalPassenger;

    /**
     * Constructs a new Train with the specified ID, source, destination, number of stations, and passenger capacity.
     *
     * @param id the license number of the train
     * @param src the starting location of the train
     * @param dst the destination location of the train
     * @param numOfStations the number of stations along the route
     * @param maxPassengers the maximum number of passengers allowed
     */
    public Train(int id, Location src, Location dst, int numOfStations, int maxPassengers) {
        licenceNumber = id;
        source = src;
        destination = dst;
        numberOfStations = numOfStations;
        currentStation = 0;
        maximalPassenger = maxPassengers;
    }

    /**
     * Returns a string representation of the train.
     *
     * @return a formatted string containing the train's details
     */
    @Override
    public String toString() {
        return String.format("licence = %d, source = %s, destination = %s, station = %d, maxPassengers = %d",
                licenceNumber, source, destination, currentStation, maximalPassenger);
    }

    /**
     * Returns the type of the vehicle.
     *
     * @return the string "Train"
     */
    @Override
    public String getType() {
        return "Train";
    }

    /**
     * Returns the license number of the train.
     *
     * @return the train's ID
     */
    @Override
    public int getId() {
        return licenceNumber;
    }

    /**
     * Returns the source location of the train.
     *
     * @return the source location
     */
    @Override
    public Location getSource() {
        return source;
    }

    /**
     * Returns the destination location of the train.
     *
     * @return the destination location
     */
    @Override
    public Location getDestination() {
        return destination;
    }

    /**
     * Returns the current location of the train.
     *
     * @return a string representing the train's current location
     */
    @Override
    public String getCurrentLocation() {
        if (currentStation == 0) return source.toString();
        return "station " + currentStation + " between " + source + " and " + destination + ".";
    }

    /**
     * Moves the train to the next station. If it reaches the last station, it swaps the source and destination and resets.
     */
    @Override
    public void move() {
        currentStation++;
        if (currentStation == numberOfStations) {
            Location tmp = source;
            source = destination;
            destination = tmp;
            currentStation = 0;
        }
    }

    /**
     * Compares this train with another train based on passenger capacity.
     *
     * @param o the object to compare with
     * @return the difference in maximal passenger capacity between this train and the other train
     * @throws ClassCastException if the object is not a Train
     */
    @Override
    public int compareTo(Object o) {
        return maximalPassenger - ((Train) o).maximalPassenger;
    }
}
