package by.javatraining.aggregation_composition.task3.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import by.javatraining.aggregation_composition.task3.exception.InvalidValueException;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class Region implements Serializable {

	private static final long serialVersionUID = 5569902532808564251L;

	private String name;
	private double areaSize;
	private City regionCapital;
	private List<City> cityList;

	public Region() {
		cityList = new LinkedList<City>();
	}

	public Region(String name, double areaSize) throws InvalidValueException {
		this();

		setName(name);
		setAreaSize(areaSize);
	}

	public String getName() {
		return name;
	}

	public double getAreaSize() {
		return areaSize;
	}

	public City getRegionCapital() {
		return regionCapital;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAreaSize(double areaSize) throws InvalidValueException {
		if (areaSize < 0.0) {
			throw new InvalidValueException("Площадь области не может быть отрицательной.");
		}

		this.areaSize = areaSize;
	}

	public void setRegionCapital(City regionCapital) {
		this.regionCapital = regionCapital;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(areaSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cityList == null) ? 0 : cityList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regionCapital == null) ? 0 : regionCapital.hashCode());
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
		Region other = (Region) obj;
		if (Double.doubleToLongBits(areaSize) != Double.doubleToLongBits(other.areaSize)) {
			return false;
		}
		if (cityList == null) {
			if (other.cityList != null) {
				return false;
			}
		} else if (!cityList.equals(other.cityList)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (regionCapital == null) {
			if (other.regionCapital != null) {
				return false;
			}
		} else if (!regionCapital.equals(other.regionCapital)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Region [name=" + name + ", areaSize=" + areaSize + ", regionCapital=" + regionCapital + ", cityList="
				+ cityList + "]";
	}
}
