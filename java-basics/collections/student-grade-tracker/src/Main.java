import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Student> students = Arrays.asList(
              new Student(1,"Sude","SWE",new int[]{80,70,90}),
              new Student(2,"Berke","SWE",new int[]{95,65,70}),
                new Student(3,"Cansu","ME",new int[]{50,80,70}),
                new Student(4,"Dicle","SBP",new int[]{65,55,85}),
                new Student(5,"Egemu","Medicine",new int[]{46,34,70}),
                new Student(6,"iklima","nurse",new int[]{80,50,70}),
                new Student(7,"aysun","NAD",new int[]{75,60,40}),
                new Student(8,"Rabos","Nurse",new int[]{90,60,90})
        );

        List<Student> regulatedList = students.stream()
                .filter(student -> student.getGrade() >= 70)
                .sorted(Comparator.comparing(Student::getGrade).reversed()
                        .thenComparing(Comparator.comparing(Student::getDepartment)))
                .collect(Collectors.toList());


        System.out.println("top 3 students for grade");
        for(int i = 0; i <Math.min(3, regulatedList.size()); i++){ //BURADA eğer 3 yazarsam yukarıda ortalaması alınan öğrenciler 3'ü geçezse sıkıntı çıkarabilirdi.
            System.out.println(i+1+". student " + regulatedList.get(i).getName()+" --> grade : "+regulatedList.get(i).getGrade() );
        }


    }
}