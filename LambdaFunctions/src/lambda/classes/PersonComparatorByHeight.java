package lambda.classes;


import java.util.Comparator;

public class PersonComparatorByHeight implements Comparator<Person> {
    public int compare(Person first, Person second) {
        return Double.compare(first.getHeight(), second.getHeight());
    }
}
