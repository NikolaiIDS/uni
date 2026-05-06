package bg.tu_varna.sit.task06;

public class Calculator {
    public static void performAction(long[] arr, String action, int[] params){
        int pos = params[0];
        int value = params[1];

        switch (action) {
            case "multiply":
                arr[pos] *= value;
                break;
            case "add":
                arr[pos] += value;
                break;
            case "subtract":
                arr[pos] -= value;
                break;
            case "lshift":
                ArrayWrapper.arrayShiftLeft(arr);
                break;
            case "rshift":
                ArrayWrapper.arrayShiftRight(arr);
                break;
        }
    }
}
