package assignment5.setInterfaceAndClass;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
class Persons implements Comparable<Persons> {
    private String name;
    private int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Persons other) {
        int nameComparison = this.name.compareTo(other.name);
        return nameComparison != 0 ? nameComparison : Integer.compare(this.age, other.age);
    }


    @Override
	public String toString() {
		return "Persons [name=" + name + ", age=" + age + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persons)) return false;
        Persons person = (Persons) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class Program9 {

    public static Set<Persons> union(Set<Persons> set1, Set<Persons> set2) {
        Set<Persons> result = new TreeSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Persons> difference(Set<Persons> set1, Set<Persons> set2) {
        Set<Persons> result = new TreeSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Persons> set1 = new TreeSet<>();
        set1.add(new Persons("Alice", 30));
        set1.add(new Persons("Bob", 25));

        Set<Persons> set2 = new TreeSet<>();
        set2.add(new Persons("Bob", 25));
        set2.add(new Persons("Charlie", 35));

        Set<Persons> unionResult = union(set1, set2);
        Set<Persons> differenceResult = difference(set1, set2);

        System.out.println("Union: " + unionResult); 
        System.out.println("Difference: " + differenceResult); 
    }
}