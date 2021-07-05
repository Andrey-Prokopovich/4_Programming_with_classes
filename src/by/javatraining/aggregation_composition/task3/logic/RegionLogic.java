package by.javatraining.aggregation_composition.task3.logic;

import by.javatraining.aggregation_composition.task3.entity.City;
import by.javatraining.aggregation_composition.task3.entity.Region;
import by.javatraining.aggregation_composition.task3.exception.NameTakenException;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class RegionLogic {

	private final CityLogic cityLogic;

	private Region region;

	public RegionLogic() {
		cityLogic = new CityLogic();
	}

	public void setRegion(Region region) {
		if (region == null) {
			this.region = new Region();
		} else {
			this.region = region;
		}
	}

	public CityLogic getCityLogic() {
		return cityLogic;
	}

	public City findCityByName(String name) {
		for (City city : region.getCityList()) {
			if (city.getName().equals(name)) {
				return city;
			}
		}

		return null;
	}

	public void setRegionCapital(String name) {
		region.setRegionCapital(findCityByName(name));
	}

	public void addCity(String name) throws NameTakenException {
		if (findCityByName(name) == null) {
			throw new NameTakenException("Город с этим именем уже есть в этой области.");
		} else {
			region.getCityList().add(new City(name));
		}
	}

	public void addCity(String name, boolean makeCapital) throws NameTakenException {
		if (findCityByName(name) == null) {
			throw new NameTakenException("Город с этим именем уже есть в этой области.");
		} else {
			City newCity = new City(name);
			region.getCityList().add(newCity);

			if (makeCapital) {
				region.setRegionCapital(newCity);
			}
		}
	}

	public void removeCity(String name) {
		City forRemoval;

		forRemoval = findCityByName(name);

		if (forRemoval != null) {
			cityLogic.setCity(forRemoval);
			cityLogic.removeAllDistricts();
			region.getCityList().remove(forRemoval);

			if (forRemoval == region.getRegionCapital()) {
				region.setRegionCapital(null);
			}
		}
	}

	public void removeAllCitys() {
		for (City city : region.getCityList()) {
			cityLogic.setCity(city);
			cityLogic.removeAllDistricts();
		}

		region.setRegionCapital(null);
		region.getCityList().clear();
	}
}
