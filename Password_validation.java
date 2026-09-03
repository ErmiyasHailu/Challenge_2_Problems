package Code_Challenges;
import java.util.Scanner;


public class Password_validation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create a password: ");
        String password = scanner.nextLine();

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasUppercase = true;
            }

            if (Character.isLowerCase(character)) {
                hasLowercase = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }
        }

        boolean validLength = password.length() >= 8;

        if (validLength && hasUppercase && hasLowercase && hasNumber) {
            System.out.println("Password accepted!");
        } else {
            System.out.println("Password rejected:");

            if (!validLength) {
                System.out.println("- Must be at least 8 characters");
            }

            if (!hasUppercase) {
                System.out.println("- Must contain an uppercase letter");
            }

            if (!hasLowercase) {
                System.out.println("- Must contain a lowercase letter");
            }

            if (!hasNumber) {
                System.out.println("- Must contain a number");
            }
        }
    }
}

