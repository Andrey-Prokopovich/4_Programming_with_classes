package by.javatraining.aggregation_composition.task3.logic;

import by.javatraining.aggregation_composition.task3.entity.City;
import by.javatraining.aggregation_composition.task3.entity.District;
import by.javatraining.aggregation_composition.task3.exception.NameTakenException;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class CityLogic {

	private City city;

	public CityLogic() {
	}

	public void setCity(City city) {
		if (city == null) {
			this.city = new City();
		} else {
			this.city = city;
		}
	}

	public District findDistrictByName(String name) {
		for (District district : city.getDistrictList()) {
			if (district.getName().equals(name)) {
				return district;
			}
		}

		return null;
	}

	public void addDistrict(String name) throws NameTakenException {
		if (findDistrictByName(name) != null) {
			throw new NameTakenException("Район с этим именем уже есть в этом городе.");
		} else {
			city.getDistrictList().add(new District(name));
		}
	}

	public void removeDistrict(String name) {
		District forRemoval;

		forRemoval = findDistrictByName(name);

		if (forRemoval != null) {
			city.getDistrictList().remove(forRemoval);
		}
	}

	public void removeAllDistricts() {
		city.getDistrictList().clear();
	}
}
