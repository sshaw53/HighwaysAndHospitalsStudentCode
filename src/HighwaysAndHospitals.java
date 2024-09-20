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

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        long hospitalCost1 = (long) hospitalCost;
        // If hospitalCost is <= highwayCost, just put all hospitals down
        if (hospitalCost1 <= highwayCost) {
            return hospitalCost1 * n;
        }

        int c = 0;
        int[] roots = new int[n + 1];

        // For every edge, use union find with path compression and weight balancing to set the trees up and fill the roots map
        for (int i = 0; i < cities.length; i++) {
            fastfind(cities[i][0], cities[i][1], roots);
        }

        // The number of negative values or values of 0 represent the number of clusters
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] <= 0) {
                c += 1;
            }
        }

        return c * hospitalCost1 + (n-c) * highwayCost;
    }

    public static void fastfind(int x, int y, int[] roots) {
        int i = x;
        int j = y;
        int t = 0;

        // Find the roots of both vertices
        while (roots[i] > 0) { i = roots[i]; }
        while (roots[j] > 0) { j = roots[j]; }

        // Uses path compression to set the leaves of the tree to attach directly to the root
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

        // Weight balancing - If the roots aren't the same, check to see whether the order of the trees are
        // equivalent, take the bigger tree (order) and make it the root of the smaller tree (order)
        if (i != j) {
            if (roots[j] < roots[i]) {
                roots[j] = roots[j] + roots[i] - 1;
                roots[i] = j;
            }
            // Otherwise, just make the first tree the root of the second
            else {
                roots[i] = roots[i] + roots[j] - 1;
                roots[j] = i;
            }
        }
    }
}
