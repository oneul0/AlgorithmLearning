import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        if (a.equals("S")) {
            System.out.println("Superior");
        }
        else if (a.equals("A")) {
            System.out.println("Excellent");
        }
        else if (a.equals("B")) {
            System.out.println("Good");
        }
        else if (a.equals("C")) {
            System.out.println("Usually");
        }
        else if (a.equals("D")) {
            System.out.println("Effort");
        }
        else {
            System.out.println("Failure");
        }
    }
}
