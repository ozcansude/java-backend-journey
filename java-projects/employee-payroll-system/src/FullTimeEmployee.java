public class FullTimeEmployee extends Employee {
    int monthlyBonus;

    @Override
    int calculateSalary() {
        return monthlyBonus + baseSalary;
    }
}
