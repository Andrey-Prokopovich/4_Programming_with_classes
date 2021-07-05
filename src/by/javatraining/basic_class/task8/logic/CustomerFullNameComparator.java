package by.javatraining.basic_class.task8.logic;

import java.util.Comparator;

import by.javatraining.basic_class.task8.entity.Customer;

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

public class CustomerFullNameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer customer1, Customer customer2) {
		int result = customer1.getSurName().compareToIgnoreCase(customer2.getSurName());
		if(result != 0) {
			return result;
		}
		
		result = customer1.getFirstName().compareToIgnoreCase(customer2.getFirstName());
		if(result != 0) {
			return result;
		}
		
		return customer1.getPatronymic().compareToIgnoreCase(customer2.getPatronymic());
	}
}
