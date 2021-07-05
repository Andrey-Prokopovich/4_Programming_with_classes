package by.javatraining.basic_class.task8.entity;

import java.io.Serializable;
import java.util.Arrays;

import by.javatraining.basic_class.task8.exception.InvalidValueException;

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

public class Customer implements Serializable {

	private static final long serialVersionUID = 8150359004791966931L;

	private static final long maxCreditCardNumber = 9999999999999999l;

	private long id;
	private String surName;
	private String firstName;
	private String patronymic;
	private Address fullAddress;
	private long creditCardNumber; // 16 CHAR MAX;
	private char[] bankAccountNumber = new char[28];

	public Customer() {
		fullAddress = new Address();
	}

	public Customer(long id) throws InvalidValueException {
		setId(id);
	}

	public Customer(long id, String surName, String firstName, String patronymic) throws InvalidValueException {
		this(id);

		setSurName(surName);
		setFirstName(firstName);
		setPatronymic(patronymic);
	}

	public Customer(long id, String surName, String firstName, String patronymic, long creditCardNumber,
			char[] bankAccountNumber) throws InvalidValueException {
		this(id, surName, firstName, patronymic);

		setCreditCardNumber(creditCardNumber);
		setBankAccountNumber(bankAccountNumber);
	}

	public void setId(long id) throws InvalidValueException {
		if (id < 0) {
			throw new InvalidValueException("ID не может быть отрицательным.");
		}

		this.id = id;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public void setFullAddress(Address fullAddress) throws InvalidValueException {
		if (fullAddress == null) {
			throw new InvalidValueException("Ссылка на адресс не может быть null.");
		}

		this.fullAddress.setCityName(fullAddress.getCityName());
		this.fullAddress.setStreetName(fullAddress.getStreetName());
		this.fullAddress.setBuildingNum(fullAddress.getBuildingNum());
		this.fullAddress.setKorpus(fullAddress.getKorpus());
		this.fullAddress.setOfficeNum(fullAddress.getOfficeNum());
	}

	public void setCreditCardNumber(long creditCardNumber) throws InvalidValueException {
		if (creditCardNumber > maxCreditCardNumber) {
			throw new InvalidValueException("Превышена максимально допустимая длинна номера кредитной карточки (16).");
		}

		this.creditCardNumber = creditCardNumber;
	}

	public void setBankAccountNumber(char[] bankAccountNumber) throws InvalidValueException {
		if (bankAccountNumber.length > 28) {
			throw new InvalidValueException("Превышена максимально допустимая длинна номера банковского счета (28).");
		}

		for (int i = 0; i < bankAccountNumber.length; i++) {
			this.bankAccountNumber[i] = bankAccountNumber[i];
		}
	}

	public long getId() {
		return id;
	}

	public String getSurName() {
		return ((surName != null) ? surName : "");
	}

	public String getFirstName() {
		return ((firstName != null) ? firstName : "");
	}

	public String getPatronymic() {
		return ((patronymic != null) ? patronymic : "");
	}

	public Address getFullAddress() {
		return fullAddress.clone();
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public char[] getBankAccountNumber() {
		return bankAccountNumber.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bankAccountNumber);
		result = prime * result + (int) (creditCardNumber ^ (creditCardNumber >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		if (!Arrays.equals(bankAccountNumber, other.bankAccountNumber)) {
			return false;
		}
		if (creditCardNumber != other.creditCardNumber) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (fullAddress == null) {
			if (other.fullAddress != null) {
				return false;
			}
		} else if (!fullAddress.equals(other.fullAddress)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (patronymic == null) {
			if (other.patronymic != null) {
				return false;
			}
		} else if (!patronymic.equals(other.patronymic)) {
			return false;
		}
		if (surName == null) {
			if (other.surName != null) {
				return false;
			}
		} else if (!surName.equals(other.surName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", surName=" + surName + ", firstName=" + firstName + ", patronymic=" + patronymic
				+ ", fullAddress=" + fullAddress + ", creditCardNumber=" + creditCardNumber + ", bankAccountNumber="
				+ Arrays.toString(bankAccountNumber) + "]";
	}
}
