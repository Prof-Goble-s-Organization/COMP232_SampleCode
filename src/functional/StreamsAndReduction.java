package functional;

import java.util.stream.IntStream;

public class StreamsAndReduction {
    private static void externalSum() {
        int total = 0;
        for (int number = 1; number <= 10; number++) {
            total += number;
        }
        System.out.printf("Sum of 1 through 10 is %d%n", total);
    }

    private static void streamAdd() {
        System.out.printf("Sum of 1 through 10 is %d%n", 
            IntStream.rangeClosed(1, 10)
                      .sum()
        );
    }

    private static void externalMapping() {
        int total = 0;
        for (int number = 2; number <= 20; number+=2) {
            total += number;
        }
        System.out.printf("Sum of the even values between 2 and 20 is %d%n", total);
    }

    private static void streamMapping() {
        System.out.printf("Sum of the even values between 2 and 20 is %d%n", 
            IntStream.rangeClosed(1, 10)
                     .map((int x) -> {return x * 2;})
                     .sum()
        );
    }

    private static void externalFiltering() {
        int total = 0;
        for (int number = 1; number <= 10; number++) {
            if (number % 2 == 0) {
                total += number * 3;
            }
        }
        System.out.printf("Sum of the triples of the even ints from 2 through 10 is %d%n", total);
    }

    private static void internalFiltering() {
        System.out.printf("Sum of the even values between 2 and 20 is %d%n", 
            IntStream.rangeClosed(1, 10)
                     .filter(x -> x % 2 == 0)
                     .map(x -> x * 3)
                     .sum()
        );
    }

    public static void main(String[] args) {
        externalSum();
        streamAdd();
    }
}
