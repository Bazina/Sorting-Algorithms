import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    public static ArrayList<Integer> random(int size) {
        Random rd = new Random(); // creating Random object

        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add(rd.nextInt()); // storing random integers in an array
        }
        return data;
    }
}
