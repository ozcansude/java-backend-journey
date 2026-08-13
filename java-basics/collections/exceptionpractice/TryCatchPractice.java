package exceptionpractice;

import java.util.Scanner;


public class TryCatchPractice {
    public static void main(String[] args){

        System.out.println("iki sayı girin : ");
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        System.out.println("Birinci sayı : "+ a);
        int b = scanner.nextInt();
        System.out.println("İkinci sayı : "+ b);

        try{
            System.out.println("Sonuç : "+ bolme(a,b));
        }catch (ArithmeticException e){
            System.out.println("Sayı sıfıra bölünemez! \n");
        }finally {
            System.out.println("Bölme işlemi sona erdi.");
            scanner.close();
        }


    }
    public static int bolme(int a, int b){
        int sonuc = a / b;

        return sonuc;
    }
}
