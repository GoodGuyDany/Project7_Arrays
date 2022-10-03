import java.util.Arrays;
import java.util.Scanner;

// Part 1.1(method creation)
class Main {
    static Scanner sc = new Scanner(System.in);

    // Method for printing
    public static void print(String str) {
        System.out.print(str);
    }

    //Method for new line printing
    public static void println(String str) {
        System.out.println(str);
    }

    // Method for array output(1.1.1)
    public static void printArray(int[] array) {
        print("{");
        for (int i = 0; i < array.length - 1; ++i) {
            print(array[i] + ", ");
        }
        print(array[array.length - 1] + "}\n");
    }

    // Method to get an array of random values(1.1.2)
    public static int[] getRandomUserArray(int arraylength){
        int[] array = new int[arraylength];
        for(int i = 0; i < arraylength; i++){
            array[i] = (int) (100 * Math.random());
        }
        return array;
    }

    // Method to get an array created by user(1.1.3)
    public static int[] getUserArray(int arraylength){
        int[] array = new int[arraylength];
        for(int i = 0; i < arraylength; i++){
            println("Please input a number.");
            array[i] = getUserInt();
            getUserString();
        }
        return array;
    }

    // Method for bubblesorting(1.1.4)
    public static int[] bubbleSort(int[] array){
        boolean isSorted = false;
        int iterations = 0;
        int replacements = 0;

        int[] sortedArray = Arrays.copyOf(array, array.length);

        while (!isSorted){
            isSorted = true;

            for (int i = 0; i < sortedArray.length - 1; i++){
                if (sortedArray[i] > sortedArray[i + 1]){
                    isSorted = false;
                    replacements++;

                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                }
                iterations++;
            }
        }
        print("It took the algorithm " + iterations + " iterations and " + replacements + " replacements to sort this array\n");

        return sortedArray;
    }

    // Method for getting user String
    public static String getUserString() {
        return sc.nextLine();
    }

    // Method for getting user int
    public static int getUserInt() {
        return sc.nextInt();
    }

    // Part 1.2
    public static void main(String[] args)
    {
        boolean go = true;
        while(go) {
            println("How big would you like your array to be?"); // (1.2.1)
            int arraylength = getUserInt();
            getUserString();
            println("Would you like to input the values yourself of generate them randomly? (Me/Rand)"); // (1.2.2)
            String answer = getUserString();
            int[] userarray;
            // (1.2.3)
            if (answer.equalsIgnoreCase("Me")){
                userarray = getUserArray(arraylength);
            }
            else{
                userarray = getRandomUserArray(arraylength);
            }
            printArray(userarray); // (1.2.4)
            int[] sortedarray = bubbleSort(userarray); // (1.2.5)
            printArray(sortedarray); // (1.2.6)
            println("Would you like to repeat? (Y/N)"); // (1.2.7)
            String repeat = getUserString();
            if (repeat.equalsIgnoreCase("Y")){
                println("Let's go then!");
            }
            else{
                println("Sad to see you go!");
                go = false;
            }
        }
    }
}