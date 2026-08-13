package hashmap.expense.exception;

public class InvalidCategoryException extends RuntimeException{
    private String message;

    public InvalidCategoryException(String message){
        super(message);
    }


}
