import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidSalaryException, EmployeeNotFoundException {
        PayrollService service = new PayrollService();
        Scanner scan = new Scanner(System.in);

        System.out.print("Yapmak istediğiniz işlemi girin : ");
        int islem = scan.nextInt();
        do{
            printMenu();
            switch (islem){
                case 1: {// 1 - Full-time işçi oluştur

                    Employee employee = createFullTimeEmployee(scan);
                    service.addEmployee(employee);
                    System.out.println(employee.getName() + " başarıyla eklendi.");
                    break;
                }
                case 2:{ // 2 - Part-Time işçi oluştur
                    Employee employee = createPartTimeEmployee(scan);
                    service.addEmployee(employee);
                    System.out.println(employee.getName() + " başarıyla eklendi.");
                    break;
                }
                case 3:{ // 3 - Sözleşmeli işçi oluştur
                    Employee employee = createContractEmployee(scan);
                    service.addEmployee(employee);
                    System.out.println(employee.getName() + " başarıyla eklendi.");
                    break;
                }
                case 4:{ // 4 - Tüm işçileri listele
                    service.printAllEmployees();
                    break;
                }
                case 5: { // 5 - İşçiyi id ile bul
                    System.out.print("Çalışanın id'sini girin : ");
                    int id = scan.nextInt();
                    service.findEmployeeById(id);
                    break;
                }
                case 6: { // "6 - İşçiyi id ile sil
                    System.out.print("Silmek istediğiniz çalışanın id'sini girin : ");
                    int id = scan.nextInt();
                    service.removeEmployeeById(id);
                    break;
                }
                case 7: { // 7 - Toplam maaş bordrosunu göster
                    System.out.println("Toplam maaş bordrosu : "+service.calculateTotalPayroll());
                    break;
                }
                case 8:{ // 8 - Çalışanın bonus bilgisini göster
                    System.out.print("Çalışanın id'sini girin : ");
                    int id = scan.nextInt();
                    Employee employee = service.findEmployeeById(id);
                    if(employee)
                }

            }
        }while(islem != 0);
    }

    private static Employee createPartTimeEmployee(Scanner scan) throws InvalidSalaryException {
        System.out.print("Yeni çalışanın id'sini giriniz : ");
        int id = scan.nextInt();
        System.out.print("Yeni çalışanın ismini giriniz : ");
        String name = scan.next();
        System.out.print("Yeni çalışanın departmanını giriniz : ");
        String department = scan.next();
        System.out.print("Base salary giriniz : ");
        double baseSalary = scan.nextInt();
        System.out.print("Saatlik maaşını giriniz : ");
        double hourlyRate = scan.nextInt();
        System.out.print("Çalışanın kaç saat çalışacağını giriniz : ");
        int hoursWorked = scan.nextInt();

        Employee employee = new PartTimeEmployee(id, name, department, baseSalary, hourlyRate, hoursWorked);

        return employee;

    }

    private static Employee createFullTimeEmployee(Scanner scan) throws InvalidSalaryException {
        System.out.print("Yeni çalışanın id'sini giriniz : ");
        int id = scan.nextInt();
        System.out.print("Yeni çalışanın ismini giriniz : ");
        String name = scan.next();
        System.out.print("Yeni çalışanın departmanını giriniz : ");
        String department = scan.next();
        System.out.print("Base salary giriniz : ");
        double baseSalary = scan.nextInt();
        System.out.print("Çalışanın aylık bonusunu giriniz : ");
        double monthlyBonus = scan.nextInt();

        Employee employee = new FullTimeEmployee(id, name, department, baseSalary, monthlyBonus);

        return employee;
    }
    private static Employee createContractEmployee(Scanner scan) throws InvalidSalaryException {
        System.out.print("Yeni çalışanın id'sini giriniz : ");
        int id = scan.nextInt();
        System.out.print("Yeni çalışanın ismini giriniz : ");
        String name = scan.next();
        System.out.print("Yeni çalışanın departmanını giriniz : ");
        String department = scan.next();
        System.out.print("Base salary giriniz : ");
        double baseSalary = scan.nextInt();
        System.out.print("Sözleşme tutarını giriniz : ");
        double contractAmount = scan.nextInt();

        Employee employee = new ContractEmployee(id, name, department, baseSalary, contractAmount);

        return employee;

    }
    private static void showBonusInfo(){
        // -- buraaası
    }


        private static void printMenu(){
            System.out.println("Menü");
            System.out.print("-------------------------------------------------");
            System.out.print(
                    "1 - Full-time işçi oluştur\n" +
                            "2 - Part-Time işçi oluştur\n" +
                            "3 - Sözleşmeli işçi oluştur\n" +
                            "4 - Tüm işçileri listele\n" +
                            "5 - İşçiyi id ile bul\n" +
                            "6 - İşçiyi id ile sil\n" +
                            "7 - Toplam maaş bordrosunu göster\n" +
                            "8 - Çalışanın bonus bilgisini göster\n" +
                            "0 - Çıkış");
            System.out.print("-------------------------------------------------");
        }
}
