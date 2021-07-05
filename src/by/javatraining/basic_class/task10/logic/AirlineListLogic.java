package by.javatraining.basic_class.task10.logic;

import java.util.List;

import by.javatraining.basic_class.task10.entity.Airline;
import by.javatraining.basic_class.task10.entity.AirlineList;
import by.javatraining.basic_class.task10.exception.InvalidValueException;
import by.javatraining.basic_class.task10.view.AirlineInfo;

/*
 * Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 *  a) список рейсов для заданного пункта назначения;
 *  b) список рейсов для заданного дня недели;
 *  c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class AirlineListLogic {
	
	private final AirlineList airlineList;
	
	public AirlineListLogic() {
		airlineList = new AirlineList();
	}

	public void addAirline(Airline airline) {
		airlineList.getAirlineList().add(airline);
	}

	public String printAirlinesWithDestination(String destination) throws InvalidValueException {
		List<Airline> list = airlineList.getAirlineList();
		StringBuilder strAirlineList = new StringBuilder();
		
		strAirlineList.append("Список рейсов с пунктом назначения \"" + destination + "\":\n");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDestinationPoint().equalsIgnoreCase(destination)) {
				strAirlineList.append(AirlineInfo.fullDescription(list.get(i)) + "\n");
			}
		}
		
		return strAirlineList.toString();
	}

	public String printAirlinesOnWeekDay(int dayNum) throws InvalidValueException {
		List<Airline> list = airlineList.getAirlineList();
		StringBuilder strAirlineList = new StringBuilder();
		
		strAirlineList.append("Список рейсов в " + AirlineInfo.getWeekDayName(dayNum - 1) + ":\n");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDaysOfWeek()[dayNum - 1]) {
				strAirlineList.append(AirlineInfo.fullDescription(list.get(i)) + "\n");
			}
		}
		
		return strAirlineList.toString();
	}

	public String printAirlinesOnWeekDayByTime(int dayNum, int hour, int minute) throws InvalidValueException {
		List<Airline> list = airlineList.getAirlineList();
		StringBuilder strAirlineList = new StringBuilder();
		
		System.out.println("Список рейсов в " + AirlineInfo.getWeekDayName(dayNum) + "вылетающих после " + hour
				+ ":" + minute + ":\n");
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).getDaysOfWeek()[dayNum - 1]) && ((list.get(i).getDepartureTime()[0] > hour)
					|| ((list.get(i).getDepartureTime()[0] == hour)
							&& (list.get(i).getDepartureTime()[1] > minute)))) {
				strAirlineList.append(AirlineInfo.fullDescription(list.get(i)) + "\n");
			}
		}
		
		return strAirlineList.toString();
	}
}
