import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class BookReview {
    String title;
    int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
}
public class BookAnalyzer {
    public static void main(String[] args) {
        List<BookReview> reviews = new ArrayList<>();
        reviews.add(new BookReview("Book1", 4));
        reviews.add(new BookReview("Book2", 7));
        reviews.add(new BookReview("Book3", 2));
        int[] ratingRanges = {1, 5, 10}; 
        Map<String, Integer> rangeCounts = new HashMap<>();
        rangeCounts.put("1-5 stars", 0);
        rangeCounts.put("6-10 stars", 0);
        int positive = 0, neutral = 0, negative = 0;
        for (BookReview review : reviews) {
            if (review.rating >= ratingRanges[0] && review.rating <= ratingRanges[1])
                rangeCounts.put("1-5 stars", rangeCounts.get("1-5 stars") + 1);
            else
                rangeCounts.put("6-10 stars", rangeCounts.get("6-10 stars") + 1);
            if (review.rating >= 6)
                positive++;
            else if (review.rating >= 3)
                neutral++;
            else
                negative++;
        }
        System.out.println("Rating Range Counts:");
        for (Map.Entry<String, Integer> entry : rangeCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\nPositive Reviews: " + positive);
        System.out.println("Neutral Reviews: " + neutral);
        System.out.println("Negative Reviews: " + negative);
    }
}
