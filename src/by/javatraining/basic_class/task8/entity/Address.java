package by.javatraining.basic_class.task8.entity;

import java.io.Serializable;

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

public class Address implements Serializable, Cloneable {

	private static final long serialVersionUID = 4296802751674313363L;

	private String cityName;
	private String streetName;
	private int buildingNum;
	private char korpus;
	private int officeNum;

	public Address() {
	}

	public Address(String cityName, String streetName, int buildingNum, char korpus, int officeNum) {
		setCityName(cityName);
		setStreetName(streetName);
		setBuildingNum(buildingNum);
		setKorpus(korpus);
		setOfficeNum(officeNum);
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setBuildingNum(int buildingNum) {
		this.buildingNum = buildingNum;
	}

	public void setKorpus(char korpus) {
		this.korpus = korpus;
	}

	public void setOfficeNum(int officeNum) {
		this.officeNum = officeNum;
	}

	public String getCityName() {
		return cityName;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getBuildingNum() {
		return buildingNum;
	}

	public char getKorpus() {
		return korpus;
	}

	public int getOfficeNum() {
		return officeNum;
	}
	
	@Override
	public Address clone() {
		Address addressCopy = new Address();
		
		addressCopy.cityName = this.cityName;
		addressCopy.streetName = this.streetName;
		addressCopy.buildingNum = this.buildingNum;
		addressCopy.korpus = this.korpus;
		addressCopy.officeNum = this.officeNum;
		
		return addressCopy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buildingNum;
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + korpus;
		result = prime * result + officeNum;
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
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
		Address other = (Address) obj;
		if (buildingNum != other.buildingNum) {
			return false;
		}
		if (cityName == null) {
			if (other.cityName != null) {
				return false;
			}
		} else if (!cityName.equals(other.cityName)) {
			return false;
		}
		if (korpus != other.korpus) {
			return false;
		}
		if (officeNum != other.officeNum) {
			return false;
		}
		if (streetName == null) {
			if (other.streetName != null) {
				return false;
			}
		} else if (!streetName.equals(other.streetName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", streetName=" + streetName + ", buildingNum=" + buildingNum
				+ ", korpus=" + korpus + ", officeNum=" + officeNum + "]";
	}
}
