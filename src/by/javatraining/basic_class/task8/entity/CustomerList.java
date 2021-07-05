package by.javatraining.basic_class.task8.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

public class CustomerList implements Serializable {

	private static final long serialVersionUID = -2432293686338252453L;

	private List<Customer> customerList;

	public CustomerList() {
		customerList = new LinkedList<>();
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerList == null) ? 0 : customerList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomerList other = (CustomerList) obj;
		if (customerList == null) {
			if (other.customerList != null) {
				return false;
			}
		} else if (!customerList.equals(other.customerList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CustomerList [customerList=" + customerList + "]";
	}
}
