public class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, String department, double baseSalary, double hourlyRate, int hoursWorked) throws InvalidSalaryException {
        super(id, name, department, baseSalary);
        if(hourlyRate < 0){
            throw new InvalidSalaryException("Saatlik ücret negatif olamaz.");
        }
        if(hoursWorked < 0){
            throw new InvalidSalaryException("Çalışılan saat negatif olamaz.");
        }
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }


    @Override
    public double calculateSalary() {
        return hourlyRate*hoursWorked;
    }
}
