public class ContractEmployee extends Employee{
    private double contractAmount;

    public ContractEmployee(int id, String name, String department, double baseSalary, double contractAmount) throws InvalidSalaryException {
        super(id, name, department, baseSalary);
        if (contractAmount < 0) {
            throw new InvalidSalaryException("Sözleşme ücreti negatif olamaz.");
        }
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        return contractAmount;
    }
}
