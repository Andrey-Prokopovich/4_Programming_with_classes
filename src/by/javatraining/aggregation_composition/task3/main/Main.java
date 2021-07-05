package by.javatraining.aggregation_composition.task3.main;

import by.javatraining.aggregation_composition.task3.entity.State;
import by.javatraining.aggregation_composition.task3.exception.InvalidValueException;
import by.javatraining.aggregation_composition.task3.exception.NameTakenException;
import by.javatraining.aggregation_composition.task3.logic.StateLogic;

/*
 * Создать объект класса Государство, использую классы Область, Район, Город. 
 * Методы: вывести на консоль столицу,количество областей, площадь, областные центры.
 */

public class Main {

	public static void main(String[] args) {
		StateLogic stateLogic = new StateLogic();

		stateLogic.setState(new State("Беларусь"));

		try {
			stateLogic.addRegion("Минская", 39849.0, true);
			stateLogic.addRegion("Брестская", 32786.44);
			stateLogic.addRegion("Витебская", 40051.34);
			stateLogic.addRegion("Гомельская", 40371.36);
			stateLogic.addRegion("Гродненская", 25126.98);
			stateLogic.addRegion("Могилёвская", 29067.62);
	
			stateLogic.getRegionLogic().setRegion(stateLogic.findRegionByName("Минская"));
			stateLogic.getRegionLogic().addCity("Минск", true);
			stateLogic.getRegionLogic().getCityLogic().setCity(stateLogic.getRegionLogic().findCityByName("Минск"));
			stateLogic.getRegionLogic().getCityLogic().addDistrict("Фрунзенский");
	
			stateLogic.getRegionLogic().setRegion(stateLogic.findRegionByName("Брестская"));
			stateLogic.getRegionLogic().addCity("Брест", true);
			stateLogic.getRegionLogic().getCityLogic().setCity(stateLogic.getRegionLogic().findCityByName("Брест"));
			stateLogic.getRegionLogic().getCityLogic().addDistrict("Ленинский");
	
			stateLogic.getRegionLogic().setRegion(stateLogic.findRegionByName("Витебская"));
			stateLogic.getRegionLogic().addCity("Витебск", true);
			stateLogic.getRegionLogic().getCityLogic().setCity(stateLogic.getRegionLogic().findCityByName("Витебск"));
			stateLogic.getRegionLogic().getCityLogic().addDistrict("Первомайский");
	
			stateLogic.getRegionLogic().setRegion(stateLogic.findRegionByName("Гомельская"));
			stateLogic.getRegionLogic().addCity("Гомель", true);
			stateLogic.getRegionLogic().getCityLogic().setCity(stateLogic.getRegionLogic().findCityByName("Гомель"));
			stateLogic.getRegionLogic().getCityLogic().addDistrict("Советсткий");
	
			stateLogic.getRegionLogic().setRegion(stateLogic.findRegionByName("Гродненская"));
			stateLogic.getRegionLogic().addCity("Гродно", true);
			stateLogic.getRegionLogic().getCityLogic().setCity(stateLogic.getRegionLogic().findCityByName("Гродно"));
			stateLogic.getRegionLogic().getCityLogic().addDistrict("Октябрьский");
	
			stateLogic.getRegionLogic().setRegion(stateLogic.findRegionByName("Могилёвская"));
			stateLogic.getRegionLogic().addCity("Могилёв", true);
			stateLogic.getRegionLogic().getCityLogic().setCity(stateLogic.getRegionLogic().findCityByName("Могилёв"));
			stateLogic.getRegionLogic().getCityLogic().addDistrict("Ленинский");
		} catch (InvalidValueException | NameTakenException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println();

		System.out.println(stateLogic.printStateCapital());

		System.out.println();

		System.out.println(stateLogic.printRegionsCount());

		System.out.println();

		System.out.println(stateLogic.printStateAreaSize());

		System.out.println();

		System.out.println(stateLogic.printRegionCapitals());

		System.out.println();
	}
}
