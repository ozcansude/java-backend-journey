public class FullTimeEmployee extends Employee implements BonusEligible{
    private double monthlyBonus;

    public FullTimeEmployee(int id, String name, String department, double baseSalary, double monthlyBonus) throws InvalidSalaryException {
        super(id, name, department, baseSalary);
        if(monthlyBonus < 0){
            throw new InvalidSalaryException("Bonus negatif olamaz.");
        }
        this.monthlyBonus = monthlyBonus;
    }

    @Override
    public double calculateSalary() {
        return monthlyBonus + getBaseSalary();
    }

    @Override
    public double calculateBonus() {
        return monthlyBonus;
    }
}
