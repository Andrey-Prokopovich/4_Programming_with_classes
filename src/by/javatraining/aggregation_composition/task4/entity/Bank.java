package by.javatraining.aggregation_composition.task4.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class Bank implements Serializable {

	private static final long serialVersionUID = 8716235267892229866L;

	private String name;
	private List<Customer> customerList;

	public Bank() {
		customerList = new LinkedList<Customer>();
	}

	public Bank(String name) {
		this();

		setName(name);
	}

	public String getName() {
		return name;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerList == null) ? 0 : customerList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Bank other = (Bank) obj;
		if (customerList == null) {
			if (other.customerList != null) {
				return false;
			}
		} else if (!customerList.equals(other.customerList)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", customerList=" + customerList + "]";
	}
}
