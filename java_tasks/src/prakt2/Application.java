package prakt2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application{
    List<Human> input = new ArrayList<>();


    public Application(List<Human> input){
        this.input=input;
    }
    public void go(){
        System.out.println("input:"); //+ human_List);
        input.forEach(System.out::println);

        List<Human> list1 = input.stream()
                .sorted(Comparator.comparing(Human::getFirstNameSecondLetter).reversed())
                .collect(Collectors.toList());
        System.out.println("sort by Second letter:");
        list1.forEach(System.out::println);

        List<Human> list2 = list1.stream()
                .filter(human -> human.getWeight() > 60)
                .collect(Collectors.toList());
        System.out.println("filter at Weight > 60:");
        list2.forEach(System.out::println);

        List<Human> list3 = list2.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .collect(Collectors.toList());
        System.out.println("sort by Age:");
        list3.forEach(System.out::println);
        System.out.println("Age Multiply:");
        System.out.println(list3.stream()
               .map(ob -> (ob.getWeight()))
               .reduce((a, b) -> a * b));
    }
}
