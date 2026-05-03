public class GradeTracker{

    public static double calculateGrades(int[] grades){
        int total = 0;

        for(int note : grades){
            total+=note;
        }
        int average = total / grades.length;
        return average;
    }
}