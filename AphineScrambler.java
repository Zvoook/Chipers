import java.util.Scanner;

public class AphineScrambler {
    private int a, b;
    private int reverse_a;
    Scanner scan;

    AphineScrambler(Scanner scanner) {
        scan = scanner;
    }

    protected boolean checkSimple(int a, int b) {
        if (b > a) {
            int n = a;
            a=b;
            b=n;
        }

        int r;

        while (b>0) {
            r = a%b;
            a = b;
            b = r;
        }

        if (a==1) return true;
        return false;
    }

    protected int calculateReverseAlpha(int a, int b) {
        if (b > a) {
            int n = a;
            a=b;
            b=n;
        }

        int q, r, x, y, x1 = 0, x2 = 1, y1 = 1, y2 = 0;

        while (b>0) {
            q = (int)a/b;
            r = a%b;
            a = b;
            b = r;

            x = x2 - q * x1;
            y = y2 - q * y1;

            x2 = x1;
            x1 = x;

            y2 = y1;
            y1 = y;
        }

        return y2;
    }

    public void setAlpha(int alpha) {
        alpha = alpha % 26;
        while (!checkSimple(alpha, 26)) {
            System.out.println("Alpha isn't simple with 26!");
            System.out.print("Input alpha again: ");
            alpha = scan.nextInt();
        }
        a=alpha;
        scan.nextLine();
        reverse_a = ((calculateReverseAlpha(a, 26) % 26) + 26) % 26;
    }

    public void setBeta(int beta) {
        beta = beta % 26;
        b = beta;
    }

    public void encrypt(String str) {
        for (int i=0; i<str.length(); ++i) {
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
            char c = str.charAt(i);
            int idx = c - 'a';
            int let = (((idx - b) % 26) + 26) % 26;
            int let2 = (((let * reverse_a) % 26) + 26) % 26;
            char res = (char) (let2 + 'a');
            System.out.print(res);
        }
    }
}