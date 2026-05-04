import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService{
    private List<Book> books;

    public LibraryService(List<Book> books){
        this.books = books;
    }

    public List<String> showAllBooks(List<Book> books){
        List<String> bookNames = books.stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());

        return bookNames;
    }

    public List<Book> showAvailableBooks(List<Book> books){
        List<Book> bookList = books.stream()
                .filter(b -> b.isAvailable()) // borrowBook ile bu kontrolü yapmaya çalıştım ancak bu sırada kitapları ödünç aldım
                .collect(Collectors.toList());
        return bookList;
    }


    public boolean borrowBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                if(book.isAvailable()){
                    book.setAvailable(false);
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> filterByCategory(String category){
        List<String> categoryList = books.stream()
                .filter(book -> book.getCategory().equals(category))
                .map(Book::getTitle)
                .collect(Collectors.toList());
        return categoryList;
    }

    public List<String> sortByTitle(){
        List<String> bookList = books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .map(Book::getTitle)
                .collect(Collectors.toList());
        return bookList;
    }






}