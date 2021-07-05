package by.javatraining.aggregation_composition.task4.entity;

import java.io.Serializable;

/*
 * Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки\разблокировки счета.
 * Реализовать поиск и сортировку счетов.
 * Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class Account implements Serializable {

	private static final long serialVersionUID = -7789808623716805868L;

	private long number;
	private boolean locked;
	private double balance;

	public Account() {
	}

	public Account(long number) {
		this.number = number;
	}

	public long getNumber() {
		return number;
	}

	public boolean isLocked() {
		return locked;
	}

	public double getBalance() {
		return balance;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (locked ? 1231 : 1237);
		result = prime * result + (int) (number ^ (number >>> 32));
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance)) {
			return false;
		}
		if (locked != other.locked) {
			return false;
		}
		if (number != other.number) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", locked=" + locked + ", balance=" + balance + "]";
	}
}
