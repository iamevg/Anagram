import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    static int size;
    static int count;
    static char[] arr = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word: ");

        String input = getString();
        size = input.length();
        count = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i);
        }

        doAnagram(size);
    }

    public static void doAnagram(int size) {
        if (size == 1) {
            return;
        }

        for (int i = 0; i < size; i++) {
            doAnagram(size - 1);

            if (size == 2) {
                displayWord();
            }

            rotate(size);
        }
    }

    public static void rotate(int newSize) {
        int i;
        int position = size - newSize;
        char tmp = arr[position];

        for (i = position + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        arr[i - 1] = tmp;
    }

    public static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }

        if (count < 9) {
            System.out.print(" ");
        }

        System.out.print(++count + " ");

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }

        System.out.print("   ");
        System.out.flush();

        if (count % 6 == 0) {
            System.out.println("");
        }
    }

    public static String getString() throws IOException {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(stream);

        String str = in.readLine();

        return str;
    }
}