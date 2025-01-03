package hust.soict.dsai.lab01;

import java.util.Scanner;

public class TriangleMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the height of the triangle (n): ");
        int n = scanner.nextInt();
        
        if (n<1) {
        	System.out.println("Invalid height!");
        }
        else {
        	for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
