package equals;

import java.util.HashMap;

public class People {
    private static final HashMap<Person, Integer> people = new HashMap<>();

    public static void addPerson(Person person) {
        people.put(person, 1);
    }

    public static void count() {
        System.out.println("There are " + people.size() + " different people: " + people);
    }
}
