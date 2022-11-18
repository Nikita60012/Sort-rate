import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arrayInput = new int[size];
        for (int i = 0; i < size; i++) {
            arrayInput[i] = in.nextInt();
        }

        int[][] myArray = new int[2][size];
        int currentNumber;
        int count = 0;

        for (int i = 0; i < size; i++) {
            currentNumber = arrayInput[i];
            int arraySize = 0;
            while (arraySize < size) {
                if (currentNumber == arrayInput[arraySize]) {
                    count++;
                }
                arraySize++;
            }
            myArray[0][i] = count;
            myArray[1][i] = currentNumber;
            count = 0;
        }

        System.out.println();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(myArray[i][j] + " ");
            System.out.println();
        }

        int[] movedNumber = new int[2];

        for (int i = size - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (myArray[0][i] > myArray[0][j]) {
                    movedNumber[0] = myArray[0][j];
                    movedNumber[1] = myArray[1][j];

                    myArray[0][j] = myArray[0][i];
                    myArray[1][j] = myArray[1][i];

                    myArray[0][i] = movedNumber[0];
                    myArray[1][i] = movedNumber[1];
                }
            }
        }
        count = 0;

        int[] finishArray = new int[size];

        for (int i = 0; i < size; i++) {
            currentNumber = myArray[1][i];
            for (int j = 0; j < size; j++) {
                if (currentNumber == myArray[1][j] && currentNumber != 0) {
                    finishArray[count] = currentNumber;
                    myArray[1][j] = 0;
                    count++;

                }
            }
        }

            System.out.println();


                for (int j = 0; j < size; j++)
                    System.out.print(Integer.parseInt(String.valueOf(finishArray[j])) + " ");
                System.out.println();


        }
    }