package hust.soict.dsai.lab01;

import java.util.Scanner;

public class DaysInMonth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput;
        int year;

        while (true) {
            System.out.print("Enter the month (full name, abbreviation, or number): ");
            monthInput = scanner.nextLine().trim();

            System.out.print("Enter the year: ");
            try {
                year = Integer.parseInt(scanner.nextLine().trim());
                if (year < 0) {
                    System.out.println("Invalid year. Please enter a non-negative number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Please enter the year as a full number.");
                continue;
            }

            int days = getDaysInMonth(monthInput, year);
            if (days != -1) {
                System.out.println("The number of days in " + monthInput + " of " + year + " is: " + days);
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }

        scanner.close();
    }

    private static int getDaysInMonth(String monthInput, int year) {
        monthInput = monthInput.toLowerCase();
        int month = -1;

        switch (monthInput) {
            case "1":
            case "january":
            case "jan.":
            case "jan":
                month = 1;
                break;
            case "2":
            case "february":
            case "feb.":
            case "feb":
                month = 2;
                break;
            case "3":
            case "march":
            case "mar.":
            case "mar":
                month = 3;
                break;
            case "4":
            case "april":
            case "apr.":
            case "apr":
                month = 4;
                break;
            case "5":
            case "may":
                month = 5;
                break;
            case "6":
            case "june":
            case "jun.":
            case "jun":
                month = 6;
                break;
            case "7":
            case "july":
            case "jul.":
            case "jul":
                month = 7;
                break;
            case "8":
            case "august":
            case "aug.":
            case "aug":
                month = 8;
                break;
            case "9":
            case "september":
            case "sept.":
            case "sep":
                month = 9;
                break;
            case "10":
            case "october":
            case "oct.":
            case "oct":
                month = 10;
                break;
            case "11":
            case "november":
            case "nov.":
            case "nov":
                month = 11;
                break;
            case "12":
            case "december":
            case "dec.":
            case "dec":
                month = 12;
                break;
            default:
                return -1; 
        }

        return calculateDaysInMonth(month, year);
    }

    private static int calculateDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1; 
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0; 
            } else {
                return true; 
            }
        }
        return false;
    }
}
