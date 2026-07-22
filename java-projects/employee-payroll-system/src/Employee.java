public abstract class Employee {
    private int id;
    private String name;
    private String department;
    private double baseSalary;
    public Employee(int id,String name,String department,double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Maaş negatif olamaz.");
        }
        this.baseSalary = baseSalary;
        this.id =id;
        this.name =name;
        this.department= department;


    }

    public String displayInfo(){
        return "ID : "+ getId()
                +", Name : "+ getName()
                +", Department : " + getDepartment()
                +", Salary : " + calculateSalary();
    }
    public abstract double calculateSalary();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Maaş negatif olamaz.");
        }
        this.baseSalary = baseSalary;
    }
}
