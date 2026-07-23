package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExpenseApp {
    public static void main(String[] args){

        List<Expense> expenses = new ArrayList<>();

        Expense e1 = new Expense(1, "Market harcaması","Market", 1000);
        Expense e2 = new Expense(2,"Kişisel bakım harcaması","kişisel bakım",500);
        Expense e3 = new Expense(3,"Kitap-kırtasiye harcaması","Kitap-kırtasiye",1400);
        Expense e4 = new Expense(4,"Kafe harcaması","Eğlence",300);
        Expense e5 = new Expense(5,"Online alışveriş sitesi harcaması","Online Harcamalar",2400);
        Expense e6 = new Expense(6,"Online oyun içi harcama","Online Harcamalar",1600);
        Expense e7 = new Expense(7,"Online yemek alışveriş harcaması","Online Harcamalar",800);
        Expense e8 = new Expense(8,"Kişisel bakım harcaması","kişisel bakım",600);
        Expense e9 = new Expense(9,"Online yemekk alışveriş harcaması","Online Harcamalar",500);
        Expense e10 = new Expense(10,"Kitap-kırtasiye harcaması","Kitap-kırtasiye",100);

        expenses.add(e1);
        expenses.add(e2);
        expenses.add(e3);
        expenses.add(e4);
        expenses.add(e5);
        expenses.add(e6);
        expenses.add(e7);
        expenses.add(e8);
        expenses.add(e9);
        expenses.add(e10);


        System.out.println("Harcamalar: " + expenses);

        Expense e11 = new Expense(11,"Market harcaması","Market", 700);
        expenses.add(e11);
        System.out.println("Yeni harcama ekleme : " + expenses);

        expenses.remove(e6);
        System.out.println("Güncel harcamalar : " + expenses);

        //bir harcamanın fiyatını güncelle
        e2.setAmount(2000);
        System.out.println("Güncel harcamalar : " + expenses);

        //id'si 5 olan harcamayı bul
        for(Expense e : expenses){
            if(e.getId() == 5){
                System.out.println(e);
            }
        }

        //kategorisi online harcamalar olan harcamaları bul
        for(Expense e : expenses){
            if (e.getCategory().equalsIgnoreCase("Online Harcamalar")){
                System.out.println(e);
            }
        }


        System.out.println("Toplam harcama tutarı : "+ totalExpenseAmount(expenses));


        Iterator<Expense> iterator = expenses.iterator();
        while (iterator.hasNext()){
            Expense expense = iterator.next();
            if(expense.getAmount() < 700){
                iterator.remove();
            }
        }
        System.out.println(expenses);

    }
    public static double totalExpenseAmount(List<Expense> expenses){
        int total = 0;
        for(Expense e : expenses){
            total+=e.getAmount();
        }
        return total;
    }
}
