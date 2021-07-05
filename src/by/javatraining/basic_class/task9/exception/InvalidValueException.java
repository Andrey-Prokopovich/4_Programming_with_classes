package by.javatraining.basic_class.task9.exception;

/*
 * Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Book: ID, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 *  a) список книг заданного автора;
 *  b) список книг, выпущенных заданным издательством;
 *  c) список книг, выпущенных после заданного года.
 */

public class InvalidValueException extends Exception {

	private static final long serialVersionUID = -6065518891140773035L;

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}
}
