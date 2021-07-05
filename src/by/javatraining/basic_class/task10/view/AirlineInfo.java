package by.javatraining.basic_class.task10.view;

import by.javatraining.basic_class.task10.entity.Airline;
import by.javatraining.basic_class.task10.exception.InvalidValueException;

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

public class AirlineInfo {
	
	public static String getDepartureTimeString(int[] departureTime) throws InvalidValueException {
		if (departureTime.length != Airline.DEPARTURE_TIME_SIZE) {
			throw new InvalidValueException("Массив времени должен содержать два значения.");
		}
		
		return departureTime[0] + ":" + (departureTime[1] < 10 ? "0" : "") + departureTime[1];
	}

	public static String getWeekDayName(int dayNum) {
		switch (dayNum) {
		case 0:
			return "понедельник";
		case 1:
			return "вторник";
		case 2:
			return "среда";
		case 3:
			return "четверг";
		case 4:
			return "пятница";
		case 5:
			return "суббота";
		case 6:
			return "воскресенье";
		default:
			return "неизвестный день недели";
		}
	}
	
	public static String getDaysOfWeekString(boolean[] daysOfWeek) throws InvalidValueException {
		if (daysOfWeek.length != Airline.DAYS_OF_WEEK_SIZE) {
			throw new InvalidValueException("Массив дней недели должен содержать семь значений.");
		}
		
		StringBuilder daysLine = new StringBuilder();

		for (int i = 0; i < Airline.DAYS_OF_WEEK_SIZE; i++) {
			if (daysOfWeek[i]) {
				daysLine.append((daysLine.length() != 0 ? ", " : "") + getWeekDayName(i));
			}
		}

		return daysLine.toString();
	}
	
	public static String fullDescription(Airline airline) throws InvalidValueException {
		return "Пункт назначения: " + airline.getDestinationPoint() + ", номер рейса: " + airline.getFlightNumber() + ", тип самолета: "
				+airline.getAircraftType() + ", время вылета: " + getDepartureTimeString(airline.getDepartureTime()) + ", дни недели: "
				+ getDaysOfWeekString(airline.getDaysOfWeek());
	}
}
