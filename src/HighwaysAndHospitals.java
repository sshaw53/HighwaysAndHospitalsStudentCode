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
        long price = 0;
        // If hospitalCost is <= highwayCost, just put all hospitals down
        if (hospitalCost1 <= highwayCost) {
            return hospitalCost1 * n;
        }

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
        ArrayList[] clusters = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            clusters[i] = new ArrayList<Integer>();
        }

        // Add the first node to the queue
        queue.add(1);
        // While there are still nodes left in the queue
        while (!queue.isEmpty()) {
            // Remove it from the current queue
            currentCity = queue.remove();

            // Finding the possible future cities
            for (int i = 0; i < cityConnections[currentCity].size(); i++) {
                node = (int) cityConnections[currentCity].get(i);

                // If the node hasn't been visited, add it to the back of the queue and save cluster spot (and mark as visited)
                if (!visited[node]) {
                    clusters[currentCity].add(node);
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

        System.out.print(clusters);


        // make an array of possible roads - how can we do that and is it beneficial?
            // would it make sense to do this or does it just take up space bc there can be multiple roads from a city
        // main idea: create a map - nodes are cities, edges are highways
        // start at a city, choose either to create a highway (if possible) or choose to start at a new city
        // create an array that notes for the cost in each version ? or the cost it takes to get to the next node / city
        // repeats until there is access to hospitals for everyone - recursion? breadth first search?
            // ideally aim for the smallest price



        return 0;
    }
}
