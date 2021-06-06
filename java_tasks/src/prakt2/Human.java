package prakt2;
import java.time.LocalDate;
import java.util.Objects;

public class Human{
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    Human(int age, String firstName, String lastName, LocalDate birthDate, int weight){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getAge(){
        return age;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getFirstNameSecondLetter(){
        return firstName.substring(1, 2);
    }

    public String getLastName(){
        return lastName;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString(){
        return "Human{"+
                "age="+age+
                ", firstName='"+firstName+'\''+
                ", lastName='"+lastName+'\''+
                ", birthDate="+birthDate+
                ", weight="+weight+
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Human)) return false;
        Human human=(Human)o;
        return getAge()==human.getAge()&&
                getWeight()==human.getWeight()&&
                Objects.equals(getFirstName(),human.getFirstName())&&
                Objects.equals(getLastName(),human.getLastName())&&
                Objects.equals(getBirthDate(),human.getBirthDate());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getAge(),getFirstName(),getLastName(),getBirthDate(),getWeight());
    }
}
