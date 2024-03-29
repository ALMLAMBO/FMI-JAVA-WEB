public class Person {
    private String name;
    private int age;

    Person() {
        name = "";
        age = -1;
    }

    Person(String name) {
        this.name = name;
        this.age = -1;
    }

    Person(String name, int age) {
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
    public String toString() {
        if(name == "") {
            return "I am John Doe";
        }

        if(age == -1)  {
            return "I am " + name;
        }

        return "I am " + name + ". I am " + age + " years old.";
    }
}
