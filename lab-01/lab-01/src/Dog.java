public class Dog implements Comparable {
    private String breed;
    private int weight;

    public Dog() {

    }

    public Dog(String breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public int compareTo(Object o) {
        return Integer.compare(getWeight(), ((Dog)o).getWeight());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }
}
