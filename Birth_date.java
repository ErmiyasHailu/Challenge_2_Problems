package Code_Challenges;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Birth_date {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 1. Today's date
        LocalDate today = LocalDate.now();

        System.out.println("Date: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());

        // 2. Calculate age
        System.out.print("Enter your birth date: ");
        LocalDate birthDate = LocalDate.parse(input.nextLine());

        Period age = Period.between(birthDate, today);

        System.out.println("You are " + age.getYears() + " years old.");

        // 3. Days until birthday
        System.out.print("Enter your birthday: ");
        LocalDate birthdayInput = LocalDate.parse(input.nextLine());

        LocalDate birthday = LocalDate.of(
                today.getYear(),
                birthdayInput.getMonthValue(),
                birthdayInput.getDayOfMonth()
        );

        if (birthday.isBefore(today)) {
            birthday = birthday.plusYears(1);
        }

        long daysUntilBirthday =
                ChronoUnit.DAYS.between(today, birthday);

        System.out.println("Days until your next birthday: " + daysUntilBirthday);

        input.close();
    }
}




