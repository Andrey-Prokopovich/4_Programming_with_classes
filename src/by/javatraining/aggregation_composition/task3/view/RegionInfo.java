package by.javatraining.aggregation_composition.task3.view;

import by.javatraining.aggregation_composition.task3.entity.City;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class RegionInfo {

	public static String getRegionCapitalName(City capital) {
		if (capital != null) {
			return capital.getName();
		} else {
			return "не назначен";
		}
	}
}
