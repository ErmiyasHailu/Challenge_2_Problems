import java.util.Scanner;

/*  challenge 1. calculate  5 Test score

Ask for 5 test scores and calculate: if ? the 5 test score is 100,90, 60,75, 20
Total
Average
Highest Score
Lowest Score

Then assign a letter grade.

 */
import java.util.Scanner;

public class TestScores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] scores = new int[5];
        int total = 0;
        double average = total / 5.0;
        int highest = scores[0];
        int lowest = scores[0];

        // Get 5 scores from the user input() 
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter test score " + (i + 1) + ": ");
            scores[i] = input.nextInt();
            total += scores[i];
        }
        for (int i = 1; i < 5; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }


        System.out.println();
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest); 
        System.out.println("Your values were:");
        for (int i = 0; i < 5; i++) {
            System.out.println(scores[i] + " - " + getGrade(scores[i]));
        }

        input.close();
    }

    static char getGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
