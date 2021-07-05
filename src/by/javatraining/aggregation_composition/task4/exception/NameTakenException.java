package by.javatraining.aggregation_composition.task4.exception;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class NameTakenException extends Exception {

	private static final long serialVersionUID = -3967148668275354838L;

	public NameTakenException(String message) {
		super(message);
	}

	public NameTakenException(String message, Throwable cause) {
		super(message, cause);
	}
}
