	package by.javatraining.basic_class.task10.entity;

import java.io.Serializable;
import java.util.Arrays;

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

public class Airline implements Serializable {

	private static final long serialVersionUID = -7065296549738696952L;

	public static final byte DEPARTURE_TIME_SIZE = 2;
	public static final byte DAYS_OF_WEEK_SIZE = 7;

	private String destinationPoint;
	private int flightNumber;
	private String aircraftType;
	private int[] departureTime;
	private boolean[] daysOfWeek;

	public Airline() {
		departureTime = new int[DEPARTURE_TIME_SIZE];
		daysOfWeek = new boolean[DAYS_OF_WEEK_SIZE];
	}

	public Airline(String destinationPoint, int flightNumber, String aircraftType, int[] departureTime,
			boolean[] daysOfWeek) throws InvalidValueException {
		this();
		
		setDestinationPoint(destinationPoint);
		setFlightNumber(flightNumber);
		setAircraftType(aircraftType);
		setDepartureTime(departureTime);
		setDaysOfWeek(daysOfWeek);
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public void setDepartureTime(int[] departureTime) throws InvalidValueException {
		if (departureTime.length != DEPARTURE_TIME_SIZE) {
			throw new InvalidValueException("Массив времени должен содержать два значения.");
		}
		if ((departureTime[0] < 0) || (departureTime[0] > 23)) {
			throw new InvalidValueException("Час может принимать значение от 0 до 23.");
		}
		if ((departureTime[1] < 0) || (departureTime[1] > 59)) {
			throw new InvalidValueException("Минута может принимать значение от 0 до 59.");
		}

		for (int i = 0; i < DEPARTURE_TIME_SIZE; i++) {
			this.departureTime[i] = departureTime[i];
		}
	}

	public void setDaysOfWeek(boolean[] daysOfWeek) throws InvalidValueException {
		if (daysOfWeek.length != DAYS_OF_WEEK_SIZE) {
			throw new InvalidValueException("Массив дней недели должен содержать семь значений.");
		}

		for (int i = 0; i < DAYS_OF_WEEK_SIZE; i++) {
			this.daysOfWeek[i] = daysOfWeek[i];
		}
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public int[] getDepartureTime() {
		return departureTime.clone();
	}

	public boolean[] getDaysOfWeek() {
		return daysOfWeek.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aircraftType == null) ? 0 : aircraftType.hashCode());
		result = prime * result + Arrays.hashCode(daysOfWeek);
		result = prime * result + Arrays.hashCode(departureTime);
		result = prime * result + ((destinationPoint == null) ? 0 : destinationPoint.hashCode());
		result = prime * result + flightNumber;
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
		Airline other = (Airline) obj;
		if (aircraftType == null) {
			if (other.aircraftType != null) {
				return false;
			}
		} else if (!aircraftType.equals(other.aircraftType)) {
			return false;
		}
		if (!Arrays.equals(daysOfWeek, other.daysOfWeek)) {
			return false;
		}
		if (!Arrays.equals(departureTime, other.departureTime)) {
			return false;
		}
		if (destinationPoint == null) {
			if (other.destinationPoint != null) {
				return false;
			}
		} else if (!destinationPoint.equals(other.destinationPoint)) {
			return false;
		}
		if (flightNumber != other.flightNumber) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Airline [destinationPoint=" + destinationPoint + ", flightNumber=" + flightNumber + ", aircraftType="
				+ aircraftType + ", departureTime=" + Arrays.toString(departureTime) + ", daysOfWeek="
				+ Arrays.toString(daysOfWeek) + "]";
	}
}
