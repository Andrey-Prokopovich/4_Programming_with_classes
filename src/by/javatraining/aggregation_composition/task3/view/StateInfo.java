package by.javatraining.aggregation_composition.task3.view;

import by.javatraining.aggregation_composition.task3.entity.Region;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class StateInfo {

	public static String getMainRegionName(Region mainRegion) {
		if (mainRegion != null) {
			return mainRegion.getName();
		} else {
			return "не назначен";
		}
	}
}
