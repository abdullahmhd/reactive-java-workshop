package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("I");
        StreamSources.intNumbersStream().forEach(i -> System.out.println(i));

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("\nII");
        StreamSources.intNumbersStream().filter(n -> n < 5).forEach(i -> System.out.println(i));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("\nIII");
        StreamSources.intNumbersStream().filter(n -> n > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("\nIV");
        Integer value = StreamSources.intNumbersStream().filter(n -> n > 5)
//                .skip(1)
//                .limit(1)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        System.out.println("\nV");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("\nVI");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(u -> u.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        System.out.println();
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(n -> n == u.getId()))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

    }

}
