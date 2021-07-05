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

public class Customer implements Serializable {

	private static final long serialVersionUID = -3925910902042214041L;

	private String fullName;
	private List<Account> accountList;

	public Customer() {
		accountList = new LinkedList<Account>();
	}

	public Customer(String fullName) {
		this();

		setFullName(fullName);
	}

	public String getFullName() {
		return fullName;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountList == null) ? 0 : accountList.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
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
		Customer other = (Customer) obj;
		if (accountList == null) {
			if (other.accountList != null) {
				return false;
			}
		} else if (!accountList.equals(other.accountList)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [fullName=" + fullName + ", accountList=" + accountList + "]";
	}
}
