package by.javatraining.aggregation_composition.task2.exception;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class EngineNotStartedException extends Exception {

	private static final long serialVersionUID = 2612650804760402125L;

	public EngineNotStartedException(String message) {
		super(message);
	}

	public EngineNotStartedException(String message, Throwable cause) {
		super(message, cause);
	}
}
