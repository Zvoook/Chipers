import java.util.Scanner;

public class MixedAlphabetScrambler {
    private int shift;
    Scanner scan;

    MixedAlphabetScrambler(Scanner scanner) {
        scan = scanner;
    }

    public void setShift(int s) {
        shift = s % 26;
    }

    public void encrypt(String str) {
        for (int i=0; i<str.length(); ++i) {
            char c = str.charAt(i);
            int idx = c - 'a';
            int let = (idx + shift) % 26;
            char res = (char) (let + 'a');
            System.out.print(res);
        }
    }

    public void decrypt(String str) {
        for (int i=0; i<str.length(); ++i) {
            char c = str.charAt(i);
            int idx = c - 'a';
            int let = (((idx - shift) % 26) + 26) % 26;
            char res = (char) (let + 'a');
            System.out.print(res);
        }
    }
}