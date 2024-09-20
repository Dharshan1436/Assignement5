package assignment5.setInterfaceAndClass;

import java.util.LinkedHashSet;
import java.util.Objects;

class Person {
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	} 
	@Override
	public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (o == null || getClass() != o.getClass()) {
        	return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
	 @Override
	    public int hashCode() {
	        return Objects.hash(name, age);
	    }
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	

}

public class Program5 {

	 public static boolean containsPerson(LinkedHashSet<Person> set, Person p) {
	        return set.contains(p);
	    }

	    public static void main(String[] args) {

	        LinkedHashSet<Person> personSet = new LinkedHashSet<>();
	        Person p1 = new Person("Alice", 30);
	        Person p2 = new Person("Bob", 25);
	        personSet.add(p1);
	        personSet.add(p2);

	        System.out.println("Set of persons: " + personSet);

	       
	        Person checkPerson = new Person("Alice", 30);
	        boolean exists = containsPerson(personSet, checkPerson);
	        System.out.println("Is Alice (age 30) in the set? " + exists);
	}

}
