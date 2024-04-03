import java.util.*;
public class TestScoreAnalyzer {
    public static void main(String[] args) {
        List<Integer> testScores = Arrays.asList(85, 92, 78, 88, 90, 72, 68, 95, 82, 75);
        double averageScore = calculateAverage(testScores);
        double medianScore = calculateMedian(testScores);
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;
        for (int score : testScores) {
            if (score > averageScore) {
                aboveAverageCount++;
            } else if (score == averageScore) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }
        System.out.println("Test Score Analysis:");
        System.out.println("Average Score: " + averageScore);
        System.out.println("Median Score: " + medianScore);
        System.out.println("Number of Students Above Average: " + aboveAverageCount + ", Median Score: " + calculateMedian(getAboveAverageScores(testScores, averageScore)));
        System.out.println("Number of Students At Average: " + atAverageCount + ", Median Score: " + calculateMedian(getAtAverageScores(testScores, averageScore)));
        System.out.println("Number of Students Below Average: " + belowAverageCount + ", Median Score: " + calculateMedian(getBelowAverageScores(testScores, averageScore)));
    }
    public static double calculateAverage(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }
    public static double calculateMedian(List<Integer> scores) {
        Collections.sort(scores);
        int size = scores.size();
        if (size % 2 == 0) {
            return (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2.0;
        } else {
            return scores.get(size / 2);
        }
    }
    public static List<Integer> getAboveAverageScores(List<Integer> scores, double average) {
        List<Integer> aboveAverage = new ArrayList<>();
        for (int score : scores) {
            if (score > average) {
                aboveAverage.add(score);
            }
        }
        return aboveAverage;
    }
    public static List<Integer> getAtAverageScores(List<Integer> scores, double average) {
        List<Integer> atAverage = new ArrayList<>();
        for (int score : scores) {
            if (score == average) {
                atAverage.add(score);
            }
        }
        return atAverage;
    }
    public static List<Integer> getBelowAverageScores(List<Integer> scores, double average) {
        List<Integer> belowAverage = new ArrayList<>();
        for (int score : scores) {
            if (score < average) {
                belowAverage.add(score);
            }
        }
        return belowAverage;
    }
}
