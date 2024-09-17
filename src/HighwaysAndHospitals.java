import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: SIERRA SHAW
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        long hospitalCost1 = (long) hospitalCost;
        // If hospitalCost is <= highwayCost, just put all hospitals down
        if (hospitalCost1 <= highwayCost) {
            return hospitalCost1 * n;
        }

        int c = 0;
        int[] roots = new int[n + 1];

        // For every edge
        for (int i = 0; i < cities.length; i++) {
            boolean union = fastfind(cities[i][0], cities[i][1], roots);
        }

        for (int i = 1; i < roots.length; i++) {
            if (roots[i] <= 0) {
                c += 1;
            }
        }

        return c * hospitalCost1 + (n-c) * highwayCost;
    }

    public static boolean find(int x, int y, int[] roots) {
        int i = x;
        int j = y;

        // Find the roots of both vertices
        while (roots[i] > 0) {
            i = roots[i];
        }
        while (roots[j] > 0) {
            j = roots[j];
        }
        // If the roots aren't the same, make the 1st vertex the root of the 2nd
        if (i != j) {
            roots[j] = i;
        }
        return i != j;
    }

    // Should we be traversing each time to reset the nodes? - seems a lot more time consuming..
    public static boolean fastfind(int x, int y, int[] roots) {
        int i = x;
        int j = y;
        int t = 0;

        // Find the roots of both vertices
        while (roots[i] > 0) { i = roots[i]; }
        while (roots[j] > 0) { j = roots[j]; }

        while (roots[x] > 0) {
            t = x;
            x = roots[x];
            roots[t] = i;
        }

        while (roots[y] > 0) {
            t = y;
            y = roots[y];
            roots[t] = j;
        }
        // If the roots aren't the same, make the 1st vertex the root of the 2nd
        if (i != j) {
            if (roots[j] < roots[i]) {
                roots[j] = roots[j] + roots[i] - 1;
                roots[i] = j;
            }
            else {
                roots[i] = roots[i] + roots[j] - 1;
                roots[j] = i;
            }
        }
        return i != j;
    }
}
