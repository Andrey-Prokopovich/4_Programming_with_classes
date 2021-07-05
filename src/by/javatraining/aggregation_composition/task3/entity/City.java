package by.javatraining.aggregation_composition.task3.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class City implements Serializable {

	private static final long serialVersionUID = 2077577464774543163L;

	private String name;
	private List<District> districtList;

	public City() {
		districtList = new LinkedList<District>();
	}

	public City(String name) {
		this();

		setName(name);
	}

	public String getName() {
		return name;
	}

	public List<District> getDistrictList() {
		return districtList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtList == null) ? 0 : districtList.hashCode());
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
		City other = (City) obj;
		if (districtList == null) {
			if (other.districtList != null) {
				return false;
			}
		} else if (!districtList.equals(other.districtList)) {
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
		return "City [name=" + name + ", districtList=" + districtList + "]";
	}
}
