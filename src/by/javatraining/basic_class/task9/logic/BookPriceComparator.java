package by.javatraining.basic_class.task9.logic;

import java.util.Comparator;

import by.javatraining.basic_class.task9.entity.Book;

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

public class BookPriceComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		if (book1.getPrice() > book2.getPrice()) {
			return 1;
		} else if (book1.getPrice() < book2.getPrice()) {
			return -1;
		} else {
			return 0;
		}
	}
}
