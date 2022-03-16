package lambda;

import lambda.classes.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        var arr = new ArrayList<Person>();
        arr.add(new Person(1.32));
        arr.add(new Person(1.52));
        arr.add(new Person(1.17));
        System.out.println(arr);
        Collections.sort(arr, new PersonComparatorByHeight());
//        Collections.sort(arr, (Person first, Person second) -> {return Double.compare(first.getHeight(), second.getHeight());});
        System.out.println(arr);
    }
}
