package by.javatraining.aggregation_composition.task2.exception;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class InvalidValueException extends Exception {

	private static final long serialVersionUID = -1751002320618804503L;

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}
}
