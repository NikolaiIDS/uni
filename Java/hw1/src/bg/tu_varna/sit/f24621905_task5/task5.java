package bg.tu_varna.sit.f24621905_task5;

public class task5 {

        public static void main(String[] args) {
            int[] numbers = {5, 12, 7, 20, 4, 9, 18, 2, 15, 10};

            topThreeEven(numbers);
        }

        public static void topThreeEven(int[] array) {
            int first = -1, second = -1, third = -1;

            for (int i = 0; i < array.length; i++) {
                int n = array[i];

                if (n % 2 == 0) {
                    if (n > first) {
                        third = second;
                        second = first;
                        first = n;
                    } else if (n > second) {
                        third = second;
                        second = n;
                    } else if (n > third) {
                        third = n;
                    }
                }
            }

            System.out.println("The three largest even numbers are:");
            if (first != -1) System.out.println(first);
            if (second != -1) System.out.println(second);
            if (third != -1) System.out.println(third);
        }
}
