package by.javatraining.aggregation_composition.task3.exception;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class NameTakenException extends Exception {

	private static final long serialVersionUID = 5952244306704121380L;

	public NameTakenException(String message) {
		super(message);
	}

	public NameTakenException(String message, Throwable cause) {
		super(message, cause);
	}
}
