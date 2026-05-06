package bg.tu_varna.sit.task06;

public class ArrayWrapper {
    public static void arrayShiftLeft(long[] array) {
        long[] arrCopy = array.clone();
        int end = array.length;
        long start = array[0];
        for (int i = 0; i < end - 1; i++) {
            array[i] = arrCopy[i + 1];
        }
        array[end-1] = start;
    }

    public static void arrayShiftRight(long[] array) {
        long start = array[0];
        long[] arrCopy = array.clone();
        int end = array.length -1;
        long valEnd = array[end];

        for (int i = end; i >= 1 ; i--) {
            array[i] = arrCopy[i-1];
        }
        array[0] = valEnd;
    }

    public static void printArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
