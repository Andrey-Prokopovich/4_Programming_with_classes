package by.javatraining.aggregation_composition.task2.exception;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class EmptyTankException extends Exception {

	private static final long serialVersionUID = 7642386512983184095L;

	public EmptyTankException(String message) {
		super(message);
	}

	public EmptyTankException(String message, Throwable cause) {
		super(message, cause);
	}
}
