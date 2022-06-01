package memleakapp;

import equals.People;
import equals.Person;


/*
*

        LeaksExamples.getListOfIntsCorrect().forEach(es -> {
            System.out.print("Array: ");
            for (var element: es) System.out.print(element + " ");
            System.out.println();
        });
* */

public class MemLeakApp {
    public static void main(String[] args) {

        var person = new Person();
        for (var i = 0; i < 5; ++i) {
            People.addPerson(person);
            person = new Person();
        }
        var newPerson = new Person(person);
        People.addPerson(newPerson);
        People.count();

        var array = new int[3];
        System.out.println(array[3]);

        int[] nullArray = null;
        nullArray[0] = 3;
        System.out.println(nullArray[0]);

    }
}
