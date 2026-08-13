package exceptionpractice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowPractice {
    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    System.out.print("Yaşınızı giriniz : ");



    try{
        int age = scanner.nextInt();
        if(age < 18){
            throw new IllegalArgumentException("Kullanıcının yaşı 18'den küçük olamaz!");
        }
        System.out.println("Giriş yapabilirsiniz."); //throw çalışırsa program zaten çıkar else'e gerek yok.
    }catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
    }catch (InputMismatchException e) {
        System.out.println("Lütfen geçerli bir tam sayı giriniz!");
    }finally
     {
        scanner.close();
    }

    }
}
