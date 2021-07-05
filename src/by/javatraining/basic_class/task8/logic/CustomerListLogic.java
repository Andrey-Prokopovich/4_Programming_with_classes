package by.javatraining.basic_class.task8.logic;

import java.util.List;

import by.javatraining.basic_class.task8.entity.Address;
import by.javatraining.basic_class.task8.entity.Customer;
import by.javatraining.basic_class.task8.entity.CustomerList;
import by.javatraining.basic_class.task8.exception.InvalidValueException;
import by.javatraining.basic_class.task8.view.CustomerInfo;

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

public class CustomerListLogic {

	public static final byte SORT_ID = 0;
	public static final byte SORT_FULL_NAME = 1;

	private final CustomerList customerList;
	private final CustomerIdComparator idComparator;
	private final CustomerFullNameComparator fullNameComparator;

	private byte sortMode;
	private int index_LastAdded;

	public CustomerListLogic() {
		sortMode = SORT_ID;

		customerList = new CustomerList();
		idComparator = new CustomerIdComparator();
		fullNameComparator = new CustomerFullNameComparator();
	}

	public void addCustomer(Customer customer) {
		List<Customer> list = customerList.getCustomerList();

		if (list.isEmpty()) {
			list.add(customer);
			index_LastAdded = 0;

			return;
		}

		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			switch (sortMode) {
			case SORT_ID:
				if (list.get(i).getId() > customer.getId()) {
					list.add(i, customer);
					index_LastAdded = i;

					return;
				}
				break;
			case SORT_FULL_NAME:
				int compareSur = list.get(i).getSurName().compareToIgnoreCase(customer.getSurName());
				int compareFirst = list.get(i).getFirstName().compareToIgnoreCase(customer.getFirstName());
				int comparePatronymic = list.get(i).getPatronymic().compareToIgnoreCase(customer.getPatronymic());

				if ((compareSur > 0) || ((compareSur == 0) && (compareFirst > 0))
						|| ((compareSur >= 0) && (compareFirst >= 0) && (comparePatronymic > 0))) {
					list.add(i, customer);
					index_LastAdded = i;

					return;
				}
				break;
			}
		}

		list.add(customer);
		index_LastAdded = list.size() - 1;
	}

	public void setSortMode(byte bMode) throws InvalidValueException {
		if (sortMode == bMode) {
			return;
		}

		switch (bMode) {
		case SORT_ID:
			sortId();
			break;
		case SORT_FULL_NAME:
			sortFullName();
			break;
		default:
			throw new InvalidValueException("Неизвестное значение режима сортировки.");
		}

		sortMode = bMode;
	}

	public void sortId() {
		customerList.getCustomerList().sort(idComparator);
	}

	public void sortFullName() {
		customerList.getCustomerList().sort(fullNameComparator);
	}

	public void setFullAddressByIndex(int listIndex, String cityNew, String streetNew, int buildingNew, char newKorpus,
			int officeNew) throws InvalidValueException {
		if (listIndex < 0) {
			listIndex = index_LastAdded;
		}

		customerList.getCustomerList().get(listIndex)
				.setFullAddress(new Address(cityNew, streetNew, buildingNew, newKorpus, officeNew));
	}

	public String printCustomersBySort() {
		List<Customer> list = customerList.getCustomerList();
		StringBuilder strCustomerList = new StringBuilder();

		strCustomerList.append("Список покупателей (все):\n");
		for (int i = 0; i < list.size(); i++) {
			strCustomerList.append(CustomerInfo.formCustomerInfo(list.get(i)) + "\n");
		}

		return strCustomerList.toString();
	}

	public void printCustomersCCNumInterval(long intervalBeg, long intervalEnd) {
		List<Customer> list = customerList.getCustomerList();
		StringBuilder strCustomerList = new StringBuilder();

		strCustomerList.append("Список покупателей (с номером кредитной карты в интервале " + intervalBeg + " - "
				+ intervalEnd + "):\n");
		for (int i = 0; i < list.size(); i++) {
			if ((intervalBeg < list.get(i).getCreditCardNumber())
					&& (intervalEnd > list.get(i).getCreditCardNumber())) {
				strCustomerList.append(CustomerInfo.formCustomerInfo(list.get(i)));
			}
		}
	}
}
