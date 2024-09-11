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
        // make an array of possible roads - how can we do that and is it beneficial?
            // would it make sense to do this or does it just take up space bc there can be multiple roads from a city
        // main idea: create a map - nodes are cities, edges are highways
        // start at a city, choose either to create a highway (if possible) or choose to start at a new city
        // create an array that notes for the cost in each version ? or the cost it takes to get to the next node / city
        // repeats until there is access to hospitals for everyone - recursion? breadth first search?
            // ideally aim for the smallest price
        // if we know that hospitalCost > highwayCost or vice versa, should that change our approach?
        // if hospitalCost is less, should we always just put all hospitals down?


        return 0;
    }
}
