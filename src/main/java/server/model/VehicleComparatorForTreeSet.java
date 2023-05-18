package server.model;

import java.util.Comparator;

/**
 * The type Vehicle comparator for tree set.
 */
public class VehicleComparatorForTreeSet implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getEnginePower() - o2.getEnginePower();
    }
}
