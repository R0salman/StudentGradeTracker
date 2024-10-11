import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        if (numStudents <= 0) {
            System.out.println("Error: Number of students must be greater than 0.");
            return; 
        }

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Error: Number of subjects must be greater than 0.");
            return; 
        }

        double[][] grades = new double[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter grades for student " + (i + 1) + ":");
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Subject " + (j + 1) + " grade: ");
                double grade = sc.nextDouble();
                
                while (grade < 0 || grade > 100) {
                    System.out.println("Error: Grade must be between 0 and 100.");
                    System.out.print("Please enter a valid grade for Subject " + (j + 1) + ": ");
                    grade = sc.nextDouble();
                }

                grades[i][j] = grade;
            }
        }

        double classTotal = 0;
        for (int i = 0; i < numStudents; i++) {
            double total = 0;
            double highest = grades[i][0];
            double lowest = grades[i][0];

            for (int j = 0; j < numSubjects; j++) {
                total += grades[i][j];

                if (grades[i][j] > highest) {
                    highest = grades[i][j];
                }

                if (grades[i][j] < lowest) {
                    lowest = grades[i][j];
                }
            }

            double average = total / numSubjects;
            classTotal += average; 

            System.out.println("\nStatistics for student " + (i + 1) + ":");
            System.out.printf("Average grade: %.2f\n", average);
            System.out.printf("Highest grade: %.2f\n", highest);
            System.out.printf("Lowest grade: %.2f\n", lowest);
        }

        double classAverage = classTotal / numStudents;
        System.out.printf("\nOverall class average: %.2f\n", classAverage);
    }
}
