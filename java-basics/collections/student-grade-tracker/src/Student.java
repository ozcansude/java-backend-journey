
public class Student{
    private int id ;
    private String name;
    private String department;
    private int[] grades;


    Student(int id, String name, String department, int[] grades){
        this.setDepartment(department);
        this.setGrades(grades);
        this.setId(id);
        this.setName(name);
    }


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

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public double getGrade(){
        return GradeTracker.calculateGrades(this.grades);
    }

}