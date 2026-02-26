// Abstract Person class
public abstract class Person {
    String id;
    String name;
    int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public abstract String getDetails();
}