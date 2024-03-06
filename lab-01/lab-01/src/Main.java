import bg.uni.fmi.lab01.flight.FlightLeg;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //testPerson();
        //sortDogs();
        testFlightLegs();
    }

    //task01
    public static int getNthOddElement(List<Integer> numbers, int nthOddElement) throws Exception {
        if(nthOddElement >= numbers.size()) {
            throw new Exception();
        }

        int count = 0;
        int number = 0;
        int finalIndex = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(count == nthOddElement) {
                finalIndex = i;
                break;
            }

            if(numbers.get(i) % 2 != 0) {
                count++;
            }
        }

        return numbers.get(finalIndex);
    }

    //task02
    public static void testPerson() {
        Person person = new Person();
        System.out.println(person);

        person = new Person("Pesho");
        System.out.println(person);

        person = new Person("Gosho", 29);
        System.out.println(person);
    }

    //task03
    public static void insertElementAtFirstPlace(List<String> list, String element) {
        list.add(0, element);
    }

    //task04
    public static String getElementAt(List<String> list, int index) {
        return list.get(index);
    }

    //task05
    public static void removeThirdElement(List<String> list) {
        list.remove(2);
    }

    //task06
    public static void searchElement(List<String> list, String element) {
        if(list.contains(element)) {
            System.out.println(list.indexOf(element));
        }
    }

    //task07
    public static void sortDogs() {
        List<Dog> dogList = new ArrayList<>();

        // Adding dogs to the list
        dogList.add(new Dog("Labrador Retriever", 25));
        dogList.add(new Dog("German Shepherd", 30));
        dogList.add(new Dog("Beagle", 15));
        dogList.add(new Dog("Golden Retriever", 28));
        dogList.add(new Dog("Bulldog", 20));

        Collections.sort(dogList);
        List<Dog> dogList2 = new ArrayList<>(dogList);
        dogList2.sort(new DogComparator());

        System.out.println(dogList);
        System.out.println(dogList2);
    }

    //task08
    public static <T> void replaceSecondElement(List<T> list, T element) {
        if(list.size() < 2) {
            throw new IndexOutOfBoundsException();
        }

        list.set(1, element);
    }

    //task09
    public static <K, V> void countValues(Map<K, V> map) {
        System.out.println(map.size());
    }

    //task10
    public static void testFlightLegs() {
        FlightLeg leg1 = new FlightLeg("JFK", "LAX", LocalDate.of(2024, 2, 29));
        FlightLeg leg2 = new FlightLeg("LAX", "ORD", LocalDate.of(2024, 3, 1));
        FlightLeg leg3 = new FlightLeg("ORD", "DFW", LocalDate.of(2024, 3, 2));
        FlightLeg leg4 = new FlightLeg("SOF", "MSW", LocalDate.of(2024, 3, 4));
        FlightLeg leg5 = new FlightLeg("VIN", "STP", LocalDate.of(2024, 3, 5));
        FlightLeg leg6 = new FlightLeg("SOF", "DFW", LocalDate.of(2024, 3, 6));

        Map<String, List<FlightLeg>> flightMap = new HashMap<>();

        flightMap.put("ABC123", new ArrayList<>(List.of(leg4, leg6)));
        flightMap.put("XYZ789", new ArrayList<>(List.of(leg5, leg2)));
        flightMap.put("ABC124", new ArrayList<>(List.of(leg1, leg3)));

        System.out.println("Get flight legs with start airport");
        flightMap
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(x -> x.getFromAirport().equals("SOF"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Get flight legs with end airport");
        flightMap
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(x -> x.getToAirport().equals("DFW"))
                .forEach(System.out::println);
    }

    //task11
}