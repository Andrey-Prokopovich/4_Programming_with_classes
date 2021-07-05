package by.javatraining.basic_class.task8.main;

import by.javatraining.basic_class.task8.entity.Customer;
import by.javatraining.basic_class.task8.exception.InvalidValueException;
import by.javatraining.basic_class.task8.logic.CustomerListLogic;

/*
 * Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 *  a) список покупателей в алфавитном порядке;
 *  b) список покупателей, у которых номер кредитной карты находится в заданном интервале.
 */

public class Main {

	public static void main(String[] args) {
		CustomerListLogic logic = new CustomerListLogic();

		try {
			logic.addCustomer(new Customer(4889159, "Евглиев", "Святослав", "Павлович", 1589148924836452L,
					"BY13NBRB3600900000002Z00AB33".toCharArray()));
			logic.setFullAddressByIndex(-1, "Минск", "Притыцкого", 4, (char) 0, 10);

			logic.addCustomer(new Customer(1119159, "Кастричин", "Павел", "Иванович", 1589998924836444l,
					"RU15NBRF3700500120005C00AC13".toCharArray()));
			logic.setFullAddressByIndex(-1, "Москва", "Победителей", 51, (char) 0, 82);

			logic.addCustomer(new Customer(3889159, "Местная", "Елена", "Ивановна", 952474136541237l,
					"RU15NBRF3700500120005C00AC58".toCharArray()));
			logic.setFullAddressByIndex(-1, "Сочи", "Звездная", 4, 'а', 5);

			logic.addCustomer(new Customer(5590000, "Местная", "Татьяна", "Павловна", 4613791728394862l,
					"BY13NBRB3600900000002Z00AB92".toCharArray()));
			logic.setFullAddressByIndex(-1, "Минск", "Сурганова", 27, (char) 0, 305);

			logic.addCustomer(new Customer(119, "Быков", "Николай", "Иосифович", 1234567891597535l,
					"BY13NBRB3600900000002Z00AB81".toCharArray()));
			logic.setFullAddressByIndex(-1, "Минск", "Скрипникова", 52, (char) 0, 92);
		} catch (InvalidValueException exc) {
			System.out.println(exc.getMessage());
			return;
		}

		System.out.println("Список отсортированный по ID");
		logic.printCustomersBySort();

		System.out.println();

		logic.sortFullName();
		System.out.println("Список отсортированный по ФИО");
		logic.printCustomersBySort();

		System.out.println();

		logic.printCustomersCCNumInterval(1200000000000000l, 1600000000000000l);
	}
}
