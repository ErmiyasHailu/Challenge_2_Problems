import java.util.Scanner;

public class REPL{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Welcome to my REPL App!");

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("help")) {
                System.out.println(" Available commands: ");
                System.out.println("add : ");
                System.out.println("subtract : ");
                System.out.println("multiply : ");
                System.out.println("divide : ");
                System.out.println("random : ");
                System.out.println("Reverse : " );
                System.out.println("quit");


            } else if (command.equals("add")) {
                System.out.print("First number : ");
                double firstnumber = scanner.nextDouble();
                System.out.print("Second number : ");
                double secondnumber = scanner.nextDouble();
                System.out.println("Result: " + (firstnumber + secondnumber));

            } else if (command.equals("subtract")) {
                System.out.print("First number : ");
                double firstnumber = scanner.nextDouble();
                System.out.print("Second number : ");
                double secondnumber = scanner.nextDouble();
                System.out.println( "Result : " + (firstnumber - secondnumber));

            } else if (command.equals("multiply")) {
                System.out.print("First number : ");
                double firstnumber = scanner.nextDouble();
                System.out.print("Second number : ");
                double secondnumber = scanner.nextDouble();
                System.out.println("Result: " + (firstnumber * secondnumber));

            } else if (command.equals("divide")) {
                System.out.print("First number : ");
                double firstnumber = scanner.nextDouble();
                System.out.print("Second number : ");
                double secondnumber = scanner.nextDouble();
                System.out.println("Result : " + (firstnumber / secondnumber));
            }

            else if (command.equals("reverse")) {
                System.out.print("Enter Text: ");
                String text = scanner.nextLine();
                ;
                System.out.println("Reverse : " + new StringBuilder(text).reverse());

            }else if (command.equals("random")) {
                System.out.print("Minimum: ");
                int min = scanner.nextInt();
                System.out.print("Maximum: ");
                int max = scanner.nextInt();
                int randomNumber = (int)(Math.random() * (max - min + 1)) + min;
                System.out.println("Random number: " + randomNumber);

            } else if (command.equals("quit")){
                System.out.println("Goodbye");
                break;

            }}}}



