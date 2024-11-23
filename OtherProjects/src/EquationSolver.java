import java.util.Scanner;

public class EquationSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation (quadratic equation ax^2 + bx + c = 0)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveFirstDegreeEquation(scanner);
                break;
            case 2:
                solveSystemOfFirstDegreeEquations(scanner);
                break;
            case 3:
                solveSecondDegreeEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

    // First-degree equation (ax + b = 0)
    private static void solveFirstDegreeEquation(Scanner scanner) {
        System.out.println("Enter coefficients a and b for the equation ax + b = 0:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Invalid equation: a must not be zero.");
        } else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

    // System of first-degree equations (a11 * x1 + a12 * x2 = b1 and a21 * x1 + a22 * x2 = b2)
    private static void solveSystemOfFirstDegreeEquations(Scanner scanner) {
        System.out.println("Enter coefficients a11, a12, b1, a21, a22, b2 for the system of equations:");
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        }
    }

    // Second-degree equation (quadratic equation ax^2 + bx + c = 0)
    private static void solveSecondDegreeEquation(Scanner scanner) {
        System.out.println("Enter coefficients a, b, and c for the equation ax^2 + bx + c = 0:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Invalid equation: a must not be zero.");
        } else {
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Two distinct real roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("Double root: x = " + x);
            } else {
                System.out.println("No real roots.");
            }
        }
    }
}
