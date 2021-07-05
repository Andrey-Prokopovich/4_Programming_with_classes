package by.javatraining.basic_class.task4.exception;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
 * массива по номерам поездов. Добавьте возможность ввода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
 * одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class NonUniqueNumberException extends Exception {

	private static final long serialVersionUID = -3016758471612322897L;

	public NonUniqueNumberException(String message) {
		super(message);
	}

	public NonUniqueNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
