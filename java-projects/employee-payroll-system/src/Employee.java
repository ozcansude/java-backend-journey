public abstract class Employee {
    int id;
    String name;
    String department;
    int baseSalary;

    public String displayInfo(){
        return "";
    }
    abstract int calculateSalary();

}
