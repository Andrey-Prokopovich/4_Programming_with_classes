package by.javatraining.basic_class.task9.main;

import by.javatraining.basic_class.task8.exception.InvalidValueException;
import by.javatraining.basic_class.task9.entity.Book;
import by.javatraining.basic_class.task9.logic.BookListLogic;

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

public class Main {

	public static void main(String[] args) {
		BookListLogic cTask9 = new BookListLogic();

		try {
			cTask9.addBook(new Book(4889159, "Баллада о змеях и певчих птицах", "Сьюзен Коллинз", "АСТ", 2020, 512, 18.26,
					(byte) 1));
			cTask9.addBook(
					new Book(1119159, "Творец Заклинаний", "Себастьян де Кастелл", "Эксмо", 2019, 480, 16.36, (byte) 1));
			cTask9.addBook(new Book(3889159, "Эрагон. Вилка, Ведьма и Дракон", "Кристофер Паолини", "Росмэн-Пресс", 2019,
					288, 16.70, (byte) 1));
			cTask9.addBook(new Book(5590000, "Пикник на обочине", "Братья Стругацкие", "АСТ", 2019, 256, 11.38, (byte) 0));
			cTask9.addBook(new Book(5591000, "Понедельник начинается в субботу", "Братья Стругацкие", "АСТ", 2019, 288,
					16.29, (byte) 1));
			cTask9.addBook(new Book(5592000, "Трудно быть богом", "Братья Стругацкие", "АСТ", 2020, 224, 16.02, (byte) 1));
			cTask9.addBook(new Book(5590181, "Автостопом по Галактике", "Дуглас Адамс", "АСТ", 2008, 346, 11.73, (byte) 0));
			cTask9.addBook(new Book(5597181, "Детективное агентство Дирка Джентли", "Дуглас Адамс", "АСТ", 2017, 576, 17.76,
					(byte) 0));
			cTask9.addBook(new Book(5590182, "Лосось сомнений", "Дуглас Адамс", "АСТ", 2018, 320, 19.28, (byte) 1));
			cTask9.addBook(
					new Book(5592191, "Доктор Кто. Город смерти", "Дуглас Адамс", "АСТ", 2018, 352, 17.08, (byte) 0));
		} catch (InvalidValueException exc) {
			System.out.println(exc.getMessage());
			return;
		}

		cTask9.printBooksByAuthor("Дуглас Адамс");

		System.out.println();

		cTask9.printBooksByPublisher("АСТ");

		System.out.println();

		cTask9.printBooksByYearPublished(2010);
	}
}
