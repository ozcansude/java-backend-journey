package exceptionpractice;

import java.util.InputMismatchException;
import java.util.Scanner;



public class ThrowsPractice {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Miktar giriniz : ");
        try{
            int miktar = scanner.nextInt();
            bakiyeKontrolEt(miktar);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("Lütfen geçerli bir tamsayı giriniz!");
        }finally {
            scanner.close();
        }


    }
    public static void bakiyeKontrolEt(int miktar) throws IllegalArgumentException{

            if(miktar<0){
                throw new IllegalArgumentException("Miktar negatif olamaz.");
            }
            System.out.println("İşlem yapılabilir.");

    }
}