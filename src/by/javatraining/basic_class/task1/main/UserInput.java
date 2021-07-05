package by.javatraining.basic_class.task1.main;

import java.util.Scanner;

public class UserInput {

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputInt(String message) {
		System.out.println(message);
		System.out.print(">> ");

		do {
			if (!scanner.hasNextInt()) {
				System.out.println("Некорректный ввод! Введите целое число!");
				System.out.print(">> ");
				scanner.next();
			} else {
				return scanner.nextInt();
			}
		} while (true);
	}
}
