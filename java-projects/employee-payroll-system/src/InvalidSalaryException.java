public class InvalidSalaryException extends Exception{
    //Negatif maaş, negatif saat, negatif bonus gibi durumlarda fırlatılacak.
    public InvalidSalaryException(String message){
        super(message);
    }

}
