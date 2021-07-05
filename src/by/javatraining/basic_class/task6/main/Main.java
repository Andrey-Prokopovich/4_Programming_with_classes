package by.javatraining.basic_class.task6.main;

import by.javatraining.basic_class.task6.main.TimeRepresentation.TimePiece;

/*
 * Составьте описание класса для представления времени. Предусмотрите возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений.
 * В случае недопустимых значений - поле устанавливать в значение ноль. Создать методы изменения
 * времени на заданное количество часов, минут и секунд.
 */

public class Main {

	public static void main(String[] args) {
		TimeRepresentation cTask6 = new TimeRepresentation();

		System.out.println(cTask6.printTime());

		cTask6.roll(TimePiece.HOUR, -30);
		cTask6.roll(TimePiece.MINUTE, -30);
		cTask6.roll(TimePiece.SECOND, -30);

		System.out.println(cTask6.printTime());

		cTask6.add(TimePiece.HOUR, 100);
		cTask6.add(TimePiece.MINUTE, 327);
		cTask6.add(TimePiece.SECOND, 1024);

		System.out.println(cTask6.printTime());

		cTask6.add(TimePiece.HOUR, -100);
		cTask6.add(TimePiece.MINUTE, -327);
		cTask6.add(TimePiece.SECOND, -1024);

		System.out.println(cTask6.printTime());
	}
}
