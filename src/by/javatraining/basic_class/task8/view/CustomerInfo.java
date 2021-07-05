package by.javatraining.basic_class.task8.view;

import java.util.Arrays;

import by.javatraining.basic_class.task8.entity.Address;
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

public class CustomerInfo {

	public static String getFullName(Customer customer) {
		return customer.getSurName() + " " + customer.getFirstName() + " " + customer.getPatronymic();
	}

	public static String formAddressInfo(Address fullAddress) {
		return ((fullAddress.getCityName() != "") ? "г." + fullAddress.getCityName() : "") + ", "
				+ ((fullAddress.getStreetName() != "") ? "ул." + fullAddress.getStreetName() : "") + ", "
				+ ((fullAddress.getBuildingNum() != 0) ? "д." + fullAddress.getBuildingNum() : "") + ", "
				+ ((fullAddress.getKorpus() != 0) ? ", корпус " + fullAddress.getKorpus() + ", " : "")
				+ ((fullAddress.getOfficeNum() != 0) ? "кв." + fullAddress.getOfficeNum() : "");
	}

	public static String formCustomerInfo(Customer customer) {
		return String.valueOf(customer.getId()) + " " + getFullName(customer) + " "
				+ formAddressInfo(customer.getFullAddress()) + " " + String.valueOf(customer.getCreditCardNumber())
				+ " " + Arrays.toString(customer.getBankAccountNumber());
	}
}
