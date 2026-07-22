import java.util.ArrayList;

public class PayrollService {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public Employee removeEmployeeById(int id) throws EmployeeNotFoundException {
        Employee employee = findEmployeeById(id);
        employees.remove(employee);
        return employee;
    }
    public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
        for(Employee e : employees){
            if(e.getId() == id){
                return e;
            }
        }
        throw new EmployeeNotFoundException(id + " ID'li kullanıcı bulunamadı.");
    }

    public void printAllEmployees(){
        for(Employee e : employees){
            System.out.println(e.displayInfo());
        }
    }
    public double calculateTotalPayroll(){
        double total = 0;

        for(Employee e : employees){
            total+=e.calculateSalary();
        }

        return total;
    }


}
