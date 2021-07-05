package by.javatraining.aggregation_composition.task2.exception;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class BustedTireException extends Exception {

	private static final long serialVersionUID = -6939444858751612342L;

	public BustedTireException(String message) {
		super(message);
	}

	public BustedTireException(String message, Throwable cause) {
		super(message, cause);
	}
}
