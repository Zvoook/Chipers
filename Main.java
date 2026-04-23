import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input cipher (0 - mixed alphabet cipher, 1 - aphine cipher, 2 - aphine reccurent cipher): ");
        int cipher = scan.nextInt();

        System.out.print("Input mode (0 - encrypt, 1 - decrypt): ");
        int mode = scan.nextInt();

        if (cipher == 0) {
            MixedAlphabetScrambler scram = new MixedAlphabetScrambler(scan);

            if (mode == 0) System.out.println("[!] You use mixed alphabet cipher on encryption");
            else System.out.println("[!] You use mixed alphabet cipher on decryption");

            System.out.print("Input shift: ");
            int shift = scan.nextInt();
            scram.setShift(shift);
            scan.nextLine();

            System.out.print("Input message: ");
            String input = scan.nextLine().trim();

            System.out.print("Result: ");
            if (mode == 1) scram.decrypt(input);
            else scram.encrypt(input);
        }
        if (cipher == 1) {
            AphineScrambler scram = new AphineScrambler(scan);

            if (mode == 0) System.out.println("[!] You use aphine cipher on encryption");
            else System.out.println("[!] You use aphine cipher on decryption");

            System.out.print("Input alpha: ");
            int alpha = scan.nextInt();
            scram.setAlpha(alpha);

            System.out.print("Input beta: ");
            int beta = scan.nextInt();
            scram.setBeta(beta);
            scan.nextLine();

            System.out.print("Input message: ");
            String input = scan.nextLine().trim();

            System.out.print("Result: ");
            if (mode == 1) scram.decrypt(input);
            else scram.encrypt(input);
        }
        else if (cipher == 2) {
            AphineReccurentScrambler scram = new AphineReccurentScrambler(scan);

            if (mode == 0) System.out.println("[!] You use aphine reccurent cipher on encryption");
            else System.out.println("[!] You use aphine reccurent cipher on decryption");

            System.out.print("Input alpha #1: ");
            int alpha1 = scan.nextInt();
            scram.setAlpha(alpha1,1);

            System.out.print("Input alpha #2: ");
            int alpha2 = scan.nextInt();
            scram.setAlpha(alpha2,2);

            System.out.print("Input beta #1: ");
            int beta1 = scan.nextInt();
            scram.setBeta(beta1,1);

            System.out.print("Input beta #2: ");
            int beta2 = scan.nextInt();
            scram.setBeta(beta2, 2);

            scan.nextLine();

            System.out.print("Input message: ");
            String input = scan.nextLine().trim();

            System.out.print("Result: ");
            if (mode == 1) scram.decrypt(input);
            else scram.encrypt(input);
        }
    }
}