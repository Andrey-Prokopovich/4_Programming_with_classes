package by.javatraining.aggregation_composition.task5.exception;

/*
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической
 * путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для
 * оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 */

public class NameTakenException extends Exception {

	private static final long serialVersionUID = 6718884580140291108L;

	public NameTakenException(String message) {
		super(message);
	}

	public NameTakenException(String message, Throwable cause) {
		super(message, cause);
	}
}
