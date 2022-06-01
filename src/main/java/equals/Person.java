package equals;

import java.util.Objects;

public class Person {
    private final String name;
    private final short age;

    public Person() {
        name = "Stephen";
        age = 23;
    }

    public Person(Person that) {
        this.name = that.name;
        this.age = that.age;
    }

    @Override
    public String toString() {
        return "\nname = " + name + ", age = " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
