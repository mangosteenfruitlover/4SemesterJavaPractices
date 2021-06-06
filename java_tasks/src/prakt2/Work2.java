package prakt2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Work2{
    public static void main(String... args){
        List<Human> input=new ArrayList<>();

        input.add(new Human(70,"MrC70","LastMrC70",LocalDate.of(1970,7,7),70));
        input.add(new Human(60,"MrB60","LastMrB60",LocalDate.of(1960,6,6),60));
        input.add(new Human(65,"MrD65","LastMrD65",LocalDate.of(1965,6,5),65));
        input.add(new Human(55,"MrA55","LastMrA55",LocalDate.of(1955,5,5),55));
        Application application=new Application(input);
        application.go();
    }
}
