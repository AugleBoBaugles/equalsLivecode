package io.github.auberonedu.equalsLivecode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // To start, look at Centroid.java
        // BEFORE running the code, make a prediction of what the following will print:

        Centroid locA = new Centroid(4, 9, "Salamander");
        Centroid locB = new Centroid(4, 9, "Salamander");

        System.out.println("Result of locA == locB " + (locA == locB)); // comparing reference
        System.out.println("Result of locA.equals(locB) " + locA.equals(locB)); // hopefully value equality (if rewritten in Centroid.java)

        Set<Centroid> centroids = new HashSet<>();
        centroids.add(locA);
        centroids.add(locB);

        System.out.println(locA.hashCode());
        System.out.println(locB.hashCode());

        System.out.println(centroids.contains(locB));


        System.out.println("--- Records ---");
        Location a = new Location(5, 1, "food");
        Location b = new Location(5, 1, "food");

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


        //videoDemo();
    }

    // We will look at this a bit later in the livecode, please ignore for first part
     
    public static void videoDemo() {
        List<char[][]> video = List.of(
            // Frame 0: Salamander is at [2, 3] (all locations in [row, column] format)
            //          Food is at [4, 5]
            new char[][]{{'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','s','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','f','.',},
                         {'.','.','.','.','.','.','.',}},

            // Frame 2: Salamander is at [2, 4]
            //          Food is at [4, 5]
            new char[][]{{'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','s','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','f','.',},
                         {'.','.','.','.','.','.','.',}},

            // Frame 3: Salamander is at [2, 4] (it didn't move)
            //          Food is at [4, 5]
            new char[][]{{'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','s','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','f','.',},
                         {'.','.','.','.','.','.','.',}},


            // Frame 4: Salamander is at [3, 4]
            //          Food is at [4, 5]
            new char[][]{{'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','s','.','.',},
                         {'.','.','.','.','.','f','.',},
                         {'.','.','.','.','.','.','.',}},

            // Frame 5: Salamander is at [4, 4]
            //          Food is at [4, 5]
            new char[][]{{'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','s','f','.',},
                         {'.','.','.','.','.','.','.',}},

            // Frame 6: Salamander is at [4, 5]
            //          No food present (the salamander ate it!)
            new char[][]{{'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','.','.',},
                         {'.','.','.','.','.','s','.',},
                         {'.','.','.','.','.','.','.',}}
        );

        Map<String, Character> legend = Map.of(
            "Salamander", 's',
            "Food", 'f'
        );

        Finder finder = new Finder(legend);
        Set<Centroid> salamanderLocations = finder.allLocations(video, "Salamander");
        Set<Centroid> foodLocations = finder.allLocations(video, "Food");

        System.out.println("Number of locations the salamander visited " + salamanderLocations.size());
        System.out.println("Number of locations the food was at " + foodLocations.size());

        boolean hasOverlap = !Collections.disjoint(salamanderLocations, foodLocations);
        System.out.println("Do the salamander locations overlap with the food locations: " + hasOverlap);
    }
    
}
