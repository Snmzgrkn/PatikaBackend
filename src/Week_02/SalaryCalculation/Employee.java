package Week_02.SalaryCalculation;

public class Employee {
    String name;

    double salary;

    int workHours;

    int hireYear;

    public  Employee(String name,double salary, int workHours,int hireYear){
        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;
    }

    public double tax(double salary){
        //Maaşa uygulanan vergiyi hesaplayacak

        if(salary<1000){
            return  0;
        }
        else {
           return  salary*0.03;
        }

    }
    public double bonus(int workHours){
        if (workHours>40){
            int bonusTime = workHours-40;
            int totalBonusPrice = bonusTime*30;
            return totalBonusPrice;
        }
        else {
            return 0;
        }
    }

    public double raiseSalary(int hireYear,double salary){
        if (2024-hireYear<10){
            double raise=salary*0.05;
            return raise;
        }
        else if(2024-hireYear>9 && 2024-hireYear<20) {
            double raise = salary*0.10;
            return raise;
        } else if (2024-hireYear>19) {
            double raise = salary*0.15;
            return raise;
        }
        else {
            return 0;
        }
    }
    public  String toString(){
        return "Name : " +name +"\n" +
                "Salary : " + salary + "\n" +
                "Work Hours :" + workHours + "\n" +
                "Hire Year :" +hireYear +"\n" +
                "Tax : " + tax(salary) + "\n" +
                "Bonus : " + bonus(workHours) + "\n" +
                "Salary Raise : " + raiseSalary(hireYear,salary) +"\n" +
                "Tax + Bonus = Salary : " + (salary+bonus(workHours)-tax(salary)) + "\n"+
                "Total Salary : " + ((salary+bonus(workHours)-tax(salary))+raiseSalary(hireYear,salary));
    }
    /*public void print(){
        System.out.println("Name :" + name);
        System.out.println("Salary :" + salary);
        System.out.println("Work Hours :" + workHours);
        System.out.println("Hire Year :" + hireYear);
        System.out.println("Tax :" + tax(salary));
        System.out.println("Bonus :" + bonus(workHours));
        System.out.println("Raise Salary :" + raiseSalary(hireYear,salary));
        System.out.println("Tax + Bonus = Salary :" + name);
        System.out.println("Total Salary :" + name);
    }*/
}
