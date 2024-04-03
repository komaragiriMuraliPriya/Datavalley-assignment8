import java.util.*;
class Restaurant {
    private String name;
    private double rating;
    public Restaurant(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }
    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
}
public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        // Sample restaurant ratings
        List<Restaurant> restaurants = Arrays.asList(
                new Restaurant("Restaurant 1", 4.5),
                new Restaurant("Restaurant 2", 7.2),
                new Restaurant("Restaurant 3", 8.9),
                new Restaurant("Restaurant 4", 3.2),
                new Restaurant("Restaurant 5", 6.8),
                new Restaurant("Restaurant 6", 9.5)
        );
        int[] ratingRanges = {1, 5, 10};
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            ratingRangeCounts.put(ratingRanges[i] + "-" + ratingRanges[i + 1], 0);
        }
        Map<String, Double> ratingRangeTotal = new HashMap<>();
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            ratingRangeTotal.put(ratingRanges[i] + "-" + ratingRanges[i + 1], 0.0);
        }
        for (Restaurant restaurant : restaurants) {
            double rating = restaurant.getRating();
            for (int i = 0; i < ratingRanges.length - 1; i++) {
                if (rating >= ratingRanges[i] && rating <= ratingRanges[i + 1]) {
                    ratingRangeCounts.put(ratingRanges[i] + "-" + ratingRanges[i + 1],
                            ratingRangeCounts.get(ratingRanges[i] + "-" + ratingRanges[i + 1]) + 1);
                    ratingRangeTotal.put(ratingRanges[i] + "-" + ratingRanges[i + 1],
                            ratingRangeTotal.get(ratingRanges[i] + "-" + ratingRanges[i + 1]) + rating);
                    break;
                }
            }
        }
        Map<String, Double> averageRatingRange = new HashMap<>();
        for (String range : ratingRangeCounts.keySet()) {
            int count = ratingRangeCounts.get(range);
            double totalRating = ratingRangeTotal.get(range);
            double averageRating = count == 0 ? 0 : totalRating / count;
            averageRatingRange.put(range, averageRating);
        }
        System.out.println("Restaurant Rating Analysis:");
        for (String range : ratingRangeCounts.keySet()) {
            int count = ratingRangeCounts.get(range);
            double averageRating = averageRatingRange.get(range);
            System.out.println("Rating Range: " + range);
            System.out.println("Number of Restaurants: " + count);
            System.out.println("Average Rating: " + averageRating);
            System.out.println();
        }
    }
}
