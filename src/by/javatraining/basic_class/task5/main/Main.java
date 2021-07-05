package by.javatraining.basic_class.task5.main;

import java.util.Scanner;

/*
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать
 * свое значение на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика
 * значениями по умолчанию и призвольными значениями. Счетчик имеет методы увеличения и
 * уменьшения состояния, и метод позволяющий получить его текущее состояние.
 * Напиать код, демонстрирующий все возможность класса.
 */

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		DexCounter cTask5;

		System.out.println("Задайте: начальное, минимально допустимое и максимально допустимое значения счетчика.\n"
				+ "Или введите \"default\" и будут установлены значения \"по умолчанию\"");

		do {
			scanner.useDelimiter("\r\n");

			if (scanner.hasNext("-?\\d+? -?\\d+? -?\\d+?")) {
				scanner.reset();

				int arg1 = Integer.parseInt(scanner.next("-?\\d+?"));
				int arg2 = Integer.parseInt(scanner.next("-?\\d+?"));
				int arg3 = Integer.parseInt(scanner.next("-?\\d+?"));

				if (arg1 < arg2) {
					System.out.println(
							"Некорректный ввод! начальное значение не может быть меньше минимально допустимого!");
					continue;
				}
				if (arg1 > arg3) {
					System.out.println(
							"Некорректный ввод! начальное значение не может быть больше максимально допустимого!");
					continue;
				}
				if (arg2 > arg3) {
					System.out.println(
							"Некорректный ввод! минимально допустимое значение не может быть больше максимально допустимого!");
					continue;
				}

				cTask5 = new DexCounter(arg1, arg2, arg3);
				break;
			}
			scanner.reset();

			if (scanner.hasNext("-?\\d+?")) {
				int arg1 = Integer.parseInt(scanner.next("-?\\d+?"));

				cTask5 = new DexCounter(arg1);
				break;
			}

			if (scanner.hasNext("default")) {
				cTask5 = new DexCounter();
				break;
			}

			System.out.println("Некорректный ввод! Введите либо три числа, либо одно, либо \"default\"");
			scanner.next();
		} while (true);

		System.out.println(cTask5.printValues());
		System.out.println("Доступные действия:\n" + "\"exit\" - выйти из программы;"
				+ "\"print\" - вывести текущее хначение счетчика;\n"
				+ "\"+\" - увеличить значение счетчика на единицу;\n"
				+ "\"-\" - уменьшить значение счетчика на единицу.");

		do {
			if (scanner.hasNext("exit")) {
				break;
			}

			if (scanner.hasNext("print")) {
				System.out.println("Текущее значение: " + cTask5.getDexValue());
			}

			if (scanner.hasNext("\\+")) {
				if (!cTask5.increase()) {
					System.out.println("Нельзя увеличить - достигнуто максимальное значение.");
				}
			}

			if (scanner.hasNext("\\-")) {
				if (cTask5.decrease()) {
					System.out.println("Нельзя уменьшить - достигнуто минимальное значение.");
				}
			}

			scanner.next();
		} while (true);
	}
}
