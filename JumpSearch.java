package jumpSearchAlgorithm;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author valit
 * date     12.04.2022
 * @version 1.0
 * @project Poligon
 */

public class JumpSearch {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\valit\\Downloads\\hyperskill-dataset-58795054.txt");
        String first = null;
        String second = null;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file))
        ) {
            first = reader.readLine();
            second = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert first != null;
        String[] firstArray = first.split(" ");
        int[] descArray = new int[firstArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            descArray[i] = Integer.parseInt(firstArray[i]);
        }
        assert second != null;
        String[] secondArray = second.split(" ");
        int[] numArray = new int[secondArray.length];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(secondArray[i]);
        }

        int[] result = new int[numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            result[i] = search(descArray, numArray[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            stringBuilder.append(" ").append(result[i]);
        }
        System.out.println(stringBuilder.toString().trim());
    }

    public static int search(int[] array, int value) {
        int step = (int) Math.sqrt(array.length);
        int curr = 1;
        while (curr < array.length) {
            if (array[curr] == value) {
                return curr;
            } else if (array[curr] < value) {
                int index = curr - 1;
                while (index > curr - step && index >= 0) {
                    if (array[index] == value) {
                        return index;
                    }
                    index = index - 1;
                }
                return -1;
            }
            curr = curr + step;
        }
        int index = array.length - 1;
        while (index > curr - step) {
            if (array[index] == value) {
                return index;
            }
            index--;
        }
        return -1;
    }
}
