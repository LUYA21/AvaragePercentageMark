import java.util.Scanner;

public class avarageCalculator {
    public static double calculateAverage(double[] scores) {
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }

    public static char calculateGrade(double average) {
        if (average >= 90 && average <= 100) {
            return 'A';
        } else if (average >= 80 && average < 90) {
            return 'B';
        } else if (average >= 70 && average < 80) {
            return 'C';
        } else if (average >= 60 && average < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String[] studentNames = new String[numStudents];
        double[][] testScores = new double[numStudents][4];
        double[] averages = new double[numStudents];
        char[] grades = new char[numStudents];

        System.out.println("Enter the test scores for each student:");

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student's name: ");
            studentNames[i] = scanner.nextLine();

            for (int j = 0; j < 4; j++) {
                System.out.print("Enter test score " + (j + 1) + ": ");
                testScores[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();  // Consume newline

            averages[i] = calculateAverage(testScores[i]);
            grades[i] = calculateGrade(averages[i]);
        }

        // Display the table with all student information
        System.out.printf("%-15s%-8s%-8s%-8s%-8s%-8s%-6s%n", "Student", "Test 1", "Test 2", "Test 3", "Test 4", "Average", "Grade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s%-8.2f%-8.2f%-8.2f%-8.2f%-8.2f%-6s%n", studentNames[i], 
                    testScores[i][0], testScores[i][1], testScores[i][2], testScores[i][3], averages[i], grades[i]);
        }

        scanner.close();
    }
}

