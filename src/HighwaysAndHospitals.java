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
            boolean union = HighwaysAndHospitals.find(cities[i][0], cities[i][1], roots);
        }
            // Find the roots of both vertices
            // If they are not the same
                // Make the 1st vertex the root of the 2nd
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == 0) {
                c += 1;
            }
        }
        return c * hospitalCost1 + (n-c) * highwayCost;

        /*
        // If highwayCost > hospitalCost, there's a different approach
            // We need to find the number of clusters possible. Place 1 hospital at a city and add all highways to it
            // also seen as # cities per cluster - 1
        // First, make an arrayList of each city's connections
        ArrayList[] cityConnections = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            cityConnections[i] = new ArrayList<Integer>();
        }

        // Add  each possible road to each city's arrayList
        for (int i = 0; i < cities.length; i++) {
            int idx = cities[i][0];
            cityConnections[idx].add((Integer)cities[i][1]);
            cityConnections[cities[i][1]].add((Integer)idx);
        }

        // Traverse through to find the number of "clusters" there are

        Queue<Integer> queue = new LinkedList<Integer>();
        int currentCity;
        int node;
        boolean[] visited = new boolean[n + 1];
        //ArrayList<Integer> myCluster = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> myClusters = new ArrayList<ArrayList<Integer>>();

        // Add the first node to the queue
        myClusters.add(new ArrayList<Integer>());
        queue.add(1);
        myClusters.get(myClusters.size() - 1).add(1);
        visited[1] = true;

        // Once we find a cluster, try to find the next cluster of connections since they haven't been visited
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                queue.add(i);
                myClusters.get(myClusters.size() - 1).add(i);
                visited[i] = true;
                // While there are still nodes left in the queue
                while (!queue.isEmpty()) {
                    // Remove it from the current queue
                    currentCity = queue.remove();

                    // Finding the possible future cities through the cityConnections (possible roads)
                    for (int j = 0; j < cityConnections[currentCity].size(); j++) {
                        node = (int) cityConnections[currentCity].get(j);

                        // If the node hasn't been visited, add it to the back of the queue, save to cluster, and mark as visited
                        if (!visited[node]) {
                            myClusters.get(myClusters.size() - 1).add(node);
                            queue.add(node);
                            visited[node] = true;
                        }
                    }
                }
                myClusters.add(new ArrayList<Integer>());
            }
        }

        for (int i = 0; i < myClusters.size(); i++) {
            if (!myClusters.get(i).isEmpty()) {
                if (myClusters.get(i).size() == 1) {
                    price += hospitalCost1;
                }
                else {
                    price += highwayCost * (myClusters.get(i).size() - 1) + hospitalCost1;
                }
            }
        }

        */
    }

    public boolean find(int x, int y, int[] roots) {
        int i = x;
        int j = y;
        while (roots[i] > 0) {
            i = roots[i];
        }
        while (roots[j] > 0) {
            j = roots[j];
        }
        if ((i == 0 && j == 0) || i != j) {
            roots[j] = i;
        }
        return i != j;
    }
}
