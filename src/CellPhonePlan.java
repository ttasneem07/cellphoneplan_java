package src;

import java.util.Scanner;
import java.time.temporal.ValueRange;

/**
 * The Cell Phone Plan class determines the plan cost and end date based on the
 * number of students & type of plan
 * 
 * @author Tasfia Tasneem
 * 
 */
public class CellPhonePlan {
    /**
     * Constants representing valid day ranges for January (10, 31), February (1,
     * 28) and March (1, 11)
     */
    public static final ValueRange DAYSJAN = ValueRange.of(10, 31);

    /** Valid Day ranges for February (1,28) */
    public static final ValueRange DAYSFEB = ValueRange.of(1, 28);

    /** Valid Day Ranges for March (1, 11) */
    public static final ValueRange DAYSMAR = ValueRange.of(1, 11);

    /**
     * isValidDate() Method: Boolean
     * 
     * Returns true, if the month and day represent a date that is between January
     * 10 and March 11, 2022, inclusive otherwise, returns false
     * 
     * @param month gets month in the form of integers (1 = January, 2 =
     *              February...)
     * @param day   gets days in the form of integer Uses ValueRange and
     *              isValidIntValue to check whether days are in the range depending
     *              on the month
     * 
     * @return true if day is between ranges returns false otherwise
     */
    public static boolean isValidDate(int month, int day) {
        ValueRange DAYSJAN = ValueRange.of(10, 31);
        ValueRange DAYSFEB = ValueRange.of(1, 28);
        ValueRange DAYSMAR = ValueRange.of(1, 11);

        // If month input is January (10, 31)
        if (month == 1) {
            // Checking whether the day input is within range
            // Based on month
            if (DAYSJAN.isValidIntValue(day)) {
                return true;
            } else {
                return false;
            }
            // If month input is February
        } else if (month == 2) {
            // Checking whether the day input is within range (2, 28)
            // Based on month
            if (DAYSFEB.isValidIntValue(day)) {
                return true;
            } else {
                return false;
            }
            // If month input is Marh
        } else if (month == 3) {
            // Checking whether the day input is within range (1, 11)
            // Based on month
            if (DAYSMAR.isValidIntValue(day)) {
                return true;
            } else {
                return false;
            }

        }

        return false;
    }

    /**
     * isValidPlan() Method: Boolean Checks whether user input for a Data Plan is
     * valid "4" = 4GB "10" = 10GB "15" = 15GB "U" or "u" = Unlimited
     * 
     * @param dataPlan gets Data Plan in the form of strings
     * 
     * @return true if the data plan equals "4", "10", "15", "U", or "u" false
     *         otherwise
     */
    public static boolean isValidPlan(String dataPlan) {
        // Checks whether dataPlan equals "4", "10",
        // "15", or Upper or Lowercase "U"
        if (dataPlan.equals("4") || dataPlan.equals("10") || dataPlan.equals("15")
                || dataPlan.toLowerCase().equals("u")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * getDate() Method: String
     * 
     * Calculates end date; 90 days after you start (First day inclusive)
     * 
     * @param month takes month as an integer (1 = January...)
     * @param day   gets days in the form of integer
     * 
     * @return date: end date as string formatted as month/day/2022 (eg. 6/10/2022)
     * @throws IllegalArgmentException if isValidDate() methods evaluates as false
     */
    public static String getEndDate(int month, int day) {
        // Initialize endMonth and endDay integers as 0
        int endMonth = 0;
        int endDay = 0;
        String date;

        // Throw Statement
        if (isValidDate(month, day) == false) {
            throw new IllegalArgumentException("Invalid date");
        }

        // If month is January (1), then
        // End month is April (4) and
        // End day is beginning day (n) - 1
        if (month == 1) {
            endMonth = 4;
            endDay = day - 1;

            // Else if month is February (2)
            // End month is May (5)
            // End day is the same as beginning day
        } else if (month == 2) {
            endMonth = 5;
            endDay = day;

            // Special Case for March
            // If month is March (3)
            // If day is 1, 2, or 3
            // endMonth is May,
            // Days are 29, 30, 31 respecitivelly
        } else if (month == 3) {
            if (day == 1) {
                endMonth = 5;
                endDay = 29;

            } else if (day == 2) {
                endMonth = 5;
                endDay = 30;

            } else if (day == 3) {
                endMonth = 5;
                endDay = 31;

            } else {
                endMonth = 6;
                endDay = day - 3;

            }
        }
        // return date
        date = endMonth + "/" + endDay + "/22";
        return date;
    }

    /**
     * getPlanCost(): Integer
     * 
     * Calculates plan cost based on the number of students and Data Plan
     * 
     * @param numberOfStudents gets number of students if it's a group plan (more
     *                         than 1 student), discounts are applied
     * @param dataPlan         gets the type of dataPlan in he form of a string
     *                         ("4", "10"..)
     * 
     * @return planCost: the total cost of the plan after three months (90 days)
     * @throws IllegalArgmentException if isValidPlan() methods evaluates as false
     */
    public static int getPlanCost(int numberOfStudents, String dataPlan) {

        // 4GB = $15
        final int _4GB = 15;

        // 10GB = $20
        final int _10GB = 20;

        // 15GB = $25
        final int _15GB = 25;

        // Unlimited = $30
        final int _UNLIMITED = 30;

        // Initialize planCost at 0
        int planCost = 0;

        // Throw Statement if Data Plan is not valid
        if (isValidPlan(dataPlan) == false) {
            throw new IllegalArgumentException("Invalid plan");
        }

        if ((numberOfStudents < 1 || numberOfStudents > 3)) {
            throw new IllegalArgumentException("Invalid number");
        }

        // If one student...
        if (numberOfStudents == 1) {
            // Checks data plan
            if (dataPlan.equals("4")) {
                // Multiplies by 3 (months)
                planCost = _4GB * 3;

            } else if (dataPlan.equals("10")) {
                planCost = _10GB * 3;

            } else if (dataPlan.equals("15")) {
                planCost = _15GB * 3;

                // Sets string to lowercase so that both "u" and "U" are valid
            } else if (dataPlan.toLowerCase().equals("u")) {
                planCost = _UNLIMITED * 3;

            }
            // If two students are applying for a group plan
        } else if (numberOfStudents == 2) {
            if (dataPlan.equals("4")) {
                // Applies a discount of $5,
                // Then Multiplies by 3 months
                // Finally, multiplying by the number of students (2)
                planCost = 2 * ((_4GB - 5) * 3);

            } else if (dataPlan.equals("10")) {
                planCost = 2 * ((_10GB - 5) * 3);

            } else if (dataPlan.equals("15")) {
                planCost = 2 * ((_15GB - 5) * 3);

            } else if (dataPlan.toLowerCase().equals("u")) {
                planCost = 2 * ((_UNLIMITED - 5) * 3);

            }

            // If three students are applying for a group plan
        } else if (numberOfStudents == 3) {
            if (dataPlan.equals("4")) {
                // Applies a discount of $10,
                // Then Multiplies by 3 months
                // Finally, multiplying by the number of students (3)
                planCost = 3 * ((_4GB - 10) * 3);

            } else if (dataPlan.equals("10")) {
                planCost = 3 * ((_10GB - 10) * 3);

            } else if (dataPlan.equals("15")) {
                planCost = 3 * ((_15GB - 10) * 3);

            } else if (dataPlan.toLowerCase().equals("u")) {
                planCost = 3 * ((_UNLIMITED - 10) * 3);

            }
        }
        // Returns planCost
        return planCost;
    }

    /**
     * Where program begins
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int mnth;
        int dy;
        int numOfStud;
        String dPlan;
        String yesNo;

        System.out.println(" Welcome to the Wolfpack Cell Phone Company!"
                + " We offer 90 day individual and group plans for up to 3 students."
                + " Plans must start between Jan 10 and Mar 11, 2022. You may choose"
                + " from data plans offering 4, 10, 15, or unlimited GB per month!"
                + " When prompted, please enter the start date, whether it is a group"
                + " plan and the number of students in the group, and your data plan"
                + " choice. Your total plan cost and end date will then be output.");

        System.out.println("Start date (month day, eg. 2 17): ");
        mnth = scnr.nextInt();
        dy = scnr.nextInt();

        // Checks if Date is valid
        // If false; prints "Invalid Date" and exits
        if (isValidDate(mnth, dy) == false) {
            System.out.println("Invalid Date.");
            System.exit(1);
        }

        System.out.println("Data plan (4, 10, 15, U): ");
        dPlan = scnr.next();

        // Checks if Plan is valid
        // If false; prints "Invalid Plan" and exits
        if (isValidPlan(dPlan) == false) {
            System.out.println("Invalid Plan");
            System.exit(1);
        }

        // Checks if whether input for Group Plan is "Yes" or "No"
        // If Character at index 0 is upper/lowercase "Y",
        // then it's a "yes"
        // Anything else is a "no"
        System.out.println("Group plan (y,n): ");
        yesNo = scnr.next();

        if (yesNo.charAt(0) == 'Y' || yesNo.charAt(0) == 'y') {
            System.out.println("Number of students: ");
            numOfStud = scnr.nextInt();
            System.out.println("Plan Cost: $" + getPlanCost(numOfStud, dPlan));

        } else {
            numOfStud = 1;
            System.out.println("Plan Cost: $" + getPlanCost(numOfStud, dPlan));
        }

        System.out.println("End Date: " + getEndDate(mnth, dy));

        scnr.close();
    }
}