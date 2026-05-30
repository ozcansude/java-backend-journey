public class PartTimeEmployee extends Employee{
    int hourlyRate;
    int hoursWorked;


    @Override
    int calculateSalary() {
        return hourlyRate*hoursWorked;
    }
}
