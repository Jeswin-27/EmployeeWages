package com.example;
import java.util.*;
import java.util.List;

class PartTime
{

    public void partTimeEmployeeDetails (String partTimeEmployeeAttendance)
    {

            System.out.println("Enter hours Working");
            Scanner scanner = new Scanner(System.in);
            Integer partTimeHour = scanner.nextInt();
            System.out.println("Part Time Employee is :" + partTimeEmployeeAttendance);
            if (partTimeEmployeeAttendance.contentEquals("PRESENT")) {
                System.out.println("Employee Salary : " + partTimeHour/8 * 8 * 20);
            } else {
                System.out.println("Employee Salary : " + 0);
            }

    }
}

class FullTime {
    public void employeeDetails(String employeeAttendance, Integer workingHours) {

        System.out.println("Press 1 if you want to calculate Wages Based on Working Hours otherwise 0 for Working Days");
        Scanner scanner = new Scanner(System.in);
        Integer input = scanner.nextInt();
        switch (input) {
            case 0:
                System.out.println("Employee Details");
                if (employeeAttendance == "PRESENT") {
                    System.out.println("Employee Attendance : " + employeeAttendance);
                    Double days = Math.floor(workingHours / 8);
                    Integer daysWorked = days.intValue();
                    if (daysWorked < 20) {

                        System.out.println("Caution : Cannot Calculate Monthly Wage if Working Days is less than 20");
                        System.out.println("Would you want to know the wages till now 1 for yes 0 for no");
                        Scanner scanner1 = new Scanner(System.in);
                        Integer interest = scanner1.nextInt();
                        if (interest > 1) {
                            System.out.println("Invalid");
                        }
                        switch (interest) {
                            case 1:
                                System.out.println("Your Total Wages : " + (int) (days * 8 * 20));
                                break;
                            case 0:
                                System.out.println("Thank you");
                                break;
                        }
                    } else {
                        System.out.println("Employee Salary : " + 100 * 20);
                    }
                }
                break;
            case 1:
                if (workingHours > 100) {
                    System.out.println("You are Exceeded the hours Working");
                    System.out.println("Employee is Present");
                    System.out.println("Employee Salary : " + 100 * 20);
                } else {
                    System.out.println("Employee Details");
                    if (employeeAttendance == "PRESENT") {
                        System.out.println("Employee Attendance : " + employeeAttendance);
                        System.out.println("Employee Salary : " + workingHours * 20);
                    }
                    break;
                }
        }
    }
}



public class EmployeeWage
{
    public static void main (String[] args) {
        List<String> employeeStatus = new ArrayList<>();
        employeeStatus.add("PRESENT");
        employeeStatus.add("ABSENT");
        Random random = new Random();
        String attendance = employeeStatus.get(random.nextInt(employeeStatus.size()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 0 if you are a PART TIME otherwise 1");
        Integer typeOf = scanner.nextInt();
        if(typeOf == 0)
        {
            if(attendance == "ABSENT")
            {
                System.out.println("PT Employee is Absent");
                System.out.println("PT Employee Salary 0");
            }
            else {
                PartTime partTime = new PartTime();
                partTime.partTimeEmployeeDetails(attendance);
            }
        }
        else
        {
            if(attendance == "ABSENT")
            {
                System.out.println("FT Employee is Absent");
                System.out.println("FT Employee Salary 0");
            }
            else {
                FullTime fullTime = new FullTime();
                System.out.println("Enter Working Hours");
                Integer hoursWorking = scanner.nextInt();
                fullTime.employeeDetails(attendance, hoursWorking);
            }
        }

        System.out.println("Condition");
        int days=0;
        double wagesTotal =0;
        int hours=0;
        int ch = 0;
        while (true)
        {

            if(attendance == "PRESENT")
            {
                ch = 1;
            }

            switch (ch)
            {
                case 0:
                    System.out.println("Employee is Absent");
                    break;
                case 1:
                    days++;
                    hours +=8;
                    break;
                case 2:
                    days++;
                    hours +=4;
                    break;
            }
            if(days >= 20 || hours >= 100){
                break;
            }
            wagesTotal = days * 8 *20;
        }
        System.out.println(wagesTotal);
    }
}
