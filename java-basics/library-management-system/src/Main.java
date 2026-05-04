import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args){
        List<Book> kitapListesi = Arrays.asList(
                new Book(5,"Bir idam mahkumunun son günü","Victor Hugo","klasik",true),
                new Book(2,"Anna Karenina","Tolstoy","klasik",true),
                new Book(3,"Yer Altından Notlar","Dostoyevski","klasik", true),
                new Book(7,"Kendime Düşünceler","Marcus Aurelus","felsefik", true),
                new Book(1,"Sofie'nin Dünyası","Jostein Gaarder","felsefik", true),
                new Book(6,"Sokrates'in Savunması","Platon","felsefik",true),
                new Book(4,"Zamanın Kısa Tarihi","Stephen Hawking","bilim",true)
        );

        LibraryService libraryService = new LibraryService(kitapListesi);


        System.out.println("Tüm kitaplar : "+ libraryService.showAllBooks(kitapListesi));
        System.out.println("tüm müsait kitaplar: " + libraryService.showAvailableBooks(kitapListesi));
        System.out.println("İsme göre sıralanmış kitaplar : "+ libraryService.sortByTitle());
        System.out.println("Bilim kategorisindeki kitap : "+libraryService.filterByCategory("bilim"));


        if(libraryService.borrowBook(1)){
            System.out.println("Sofie'nin Dünyası kitabını ödünç aldınız.");
        }else{
            System.out.println("Sofie'nin Dünyası kitabı mevcut değil");
        }

        if(libraryService.borrowBook(1)){ // aynı kitabı önceki kişi bırakmadan tekrar istedim.
            System.out.println("Sofie'nin Dünyası kitabını ödünç aldınız.");
        }else{
            System.out.println("Sofie'nin Dünyası kitabı mevcut değil");
        }

        System.out.println("Tüm müsait kitaplar : "+libraryService.showAvailableBooks(kitapListesi));









    }
}