package prakt1;

public class Work1{
    public static void main(String[] args){
        StringPredicate stringPredicate=new StringPredicate();
        String str1="wow@gmail.com";
        System.out.println("Email: "+str1);
        System.out.println("Answer: "+stringPredicate.test(str1)); //Получение ответа

        System.out.println("__________________");

        String str2="wow";
        System.out.println("Email: "+str2);
        System.out.println("Answer: "+stringPredicate.test(str2)); //Получение ответа
    }
}
