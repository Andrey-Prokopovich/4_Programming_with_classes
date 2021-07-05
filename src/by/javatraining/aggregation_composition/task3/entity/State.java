package by.javatraining.aggregation_composition.task3.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class State implements Serializable {

	private static final long serialVersionUID = 6276466228301628429L;

	private String name;
	private Region mainRegion;
	private List<Region> regionList;

	public State() {
		regionList = new LinkedList<>();
	}

	public State(String name) {
		this();

		setName(name);
	}

	public String getName() {
		return name;
	}

	public Region getMainRegion() {
		return mainRegion;
	}

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMainRegion(Region mainRegion) {
		this.mainRegion = mainRegion;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mainRegion == null) ? 0 : mainRegion.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regionList == null) ? 0 : regionList.hashCode());
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
		State other = (State) obj;
		if (mainRegion == null) {
			if (other.mainRegion != null) {
				return false;
			}
		} else if (!mainRegion.equals(other.mainRegion)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (regionList == null) {
			if (other.regionList != null) {
				return false;
			}
		} else if (!regionList.equals(other.regionList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", mainRegion=" + mainRegion + ", regionList=" + regionList + "]";
	}
}
