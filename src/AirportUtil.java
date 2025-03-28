import java.util.ArrayList;
import static java.util.Arrays.sort;

/**
 * Utility class for handling operations related to transportation in an airport.
 */
public class AirportUtil {
    /**
     * Sorts an array of transport objects that implement {@code Comparable}.
     *
     * @param transport an array of comparable transport objects
     */
    public static void sortTransport(Comparable[] transport) {
        sort(transport);
    }

    /**
     * Generates a report for all movable transport objects.
     *
     * @param movables an array of objects that implement {@code Movable}
     * @return a formatted string report listing all movable transports with their details
     */
    static String reportAll(Movable[] movables) {
        ArrayList<String> buffer = new ArrayList<>();
        for (Movable m : movables) {
            buffer.add(m.getType() + " " + m.getId() + " going from " + m.getSource() + " to " + m.getDestination() + ". " +
                    "Currently in " + m.getCurrentLocation());
        }
        return String.join("\n", buffer);
    }
}
