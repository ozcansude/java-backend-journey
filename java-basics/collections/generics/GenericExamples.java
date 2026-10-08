package generics;

public class GenericExamples {
    public static void main(String[] args){
        Box<String> nameBox = new Box<>("Berke");
        Box<Integer> integerBox = new Box<>(21);

        Pair<String,Integer> nameAge = new Pair<>("Sude",22);

        System.out.println(nameBox.getValue());
        System.out.println(integerBox.getValue());
        integerBox.setValue(31);
        System.out.println("Yeni integerBox : " +integerBox.getValue());

        System.out.println(nameAge.getKey());
        System.out.println(nameAge.getValue());
        nameAge.setValue(21);
        System.out.println("Yeni value : " +nameAge.getValue());

        Result<String> successResult =
                new Result<>(true, "Kullanıcı bulundu.","İşlem başarılı");

        Result<String> errorResult =
                new Result<>(false, null, "Kullanıcı bulunamadı");

        System.out.println(successResult.isSuccess());
        System.out.println(successResult.getData());
        System.out.println(successResult.getMessage());

        System.out.println("---------------------");

        System.out.println(errorResult.isSuccess());
        System.out.println(errorResult.getData());
        System.out.println(errorResult.getMessage());


    }

}
