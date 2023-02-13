import java.io.*;
import java.util.*;

public class SpanishLastnames {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedReader reader = null;
        Map<String, Integer> map = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                Integer frequency = Integer.parseInt(items[1]);
                map.put(items[0], frequency);
            }
            String lastname;
            while (true) {
                System.out.println("Introduce your lastname(empty to exit): ");
                lastname = input.nextLine().toUpperCase();
                if (lastname.equals("")) {
                    break;
                }
                Integer freq = map.get(lastname);
                if (freq == null) {
                    System.out.println(lastname + " not found");
                } else {
                    System.out.println("Frequency: " + freq);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
