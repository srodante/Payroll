import java.util.Scanner;

public class Payroll {
    static double overTime(double x){
        if (x <= 35){
            return 0;
        }else {
            return x - 35;
        }
    }
    public static void main (String[] args){
        Scanner keybd = new Scanner(System.in);
        int employeeNum;
        double payRate, hours;
        double amountDue, overTime;
        double minPay = 10, maxPay = 25;
        String cont;

        do {
            System.out.print("Enter the employee's number: ");
            employeeNum = keybd.nextInt();
            payRate = 0;

            while (payRate < minPay || payRate > maxPay){  //This will do the test first
                System.out.print("Enter the employee's pay rate: ");
                payRate = keybd.nextDouble();
                if (payRate < minPay || payRate > maxPay){
                    System.out.println("Invalid pay rate entered");
                }
            }
            do { //This will do the test last Doing both ways to practice
                System.out.print("Enter the number of hours the employee worked: ");
                hours = keybd.nextDouble();
                overTime = 0;
                if (hours < 1 || hours > 60){
                    System.out.println("Invalid hours entered");
                } else {
                    overTime = overTime(hours);
                    if (overTime > 0) {
                        hours -= overTime;
                    }
                    System.out.println("overtime hours: " + overTime);
                    System.out.println("hours: " + hours);
                }
            } while (hours < 1 || hours > 60);
            amountDue = (hours * payRate) + (overTime * (payRate * 1.5));
            System.out.printf("Employee number %d worked %.2f hours and is due $%.2f\n",
                    employeeNum, hours + overTime, amountDue);
            System.out.print("Continue (y/n): ");
            keybd.nextLine();
            cont = keybd.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
