import java.util.Scanner;

public class AphineReccurentScrambler extends AphineScrambler  {
    private int a1, a2, b1, b2;
    private int reverse_a1, reverse_a2;

    AphineReccurentScrambler(Scanner scanner) {
        super(scanner);
    }

    public void setAlpha(int alpha, int num) {
        alpha = alpha % 26;
        while (!checkSimple(alpha, 26)) {
            System.out.println("Alpha isn't simple with 26!");
            System.out.print("Input alpha again: ");
            alpha = scan.nextInt();
        }
        if (num==1){
            a1=alpha;
            reverse_a1 = calculateReverseAlpha(a1, 26);
        }
        else{
            a2=alpha;
            reverse_a2 = calculateReverseAlpha(a2, 26);
        }
        scan.nextLine();
    }

    public void setBeta(int beta, int num) {
        beta = beta % 26;
        if (num == 1) b1 = beta;
        else b2 = beta;
    }

    private int getAlpha(int i) {
        if (i == 0) return a1;
        if (i == 1) return a2;

        int prev2 = a1;
        int prev1 = a2;
        int current = 0;

        for (int k = 2; k <= i; k++) {
            current = (prev1 * prev2) % 26;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    private int getBeta(int i) {
        if (i == 0) return b1;
        if (i == 1) return b2;

        int prev2 = b1;
        int prev1 = b2;
        int current = 0;

        for (int k = 2; k <= i; k++) {
            current = (prev1 + prev2) % 26;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    private int getReverseAlpha(int num) {
        int a = getAlpha(num);
        return calculateReverseAlpha(a, 26);
    }

    public void encrypt(String str) {
        for (int i=0; i<str.length(); ++i) {
            int a = getAlpha(i);
            int b = getBeta(i);

            char c = str.charAt(i);
            int idx = c - 'a';
            int let = (idx * a) % 26;
            int let2 = (let + b) % 26;
            char res = (char) (let2 + 'a');
            System.out.print(res);
        }
    }

    public void decrypt(String str) {
        for (int i=0; i<str.length(); ++i) {
            int reverse_a = getReverseAlpha(i);
            int b = getBeta(i);

            char c = str.charAt(i);
            int idx = c - 'a';
            int let = (((idx - b) % 26) + 26) % 26;
            int let2 = (let * reverse_a) % 26;
            char res = (char) (let2 + 'a');
            System.out.print(res);
        }
    }
}