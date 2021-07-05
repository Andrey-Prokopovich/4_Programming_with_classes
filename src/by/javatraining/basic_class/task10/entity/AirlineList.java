package by.javatraining.basic_class.task10.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

public class AirlineList implements Serializable {

	private static final long serialVersionUID = -5841473126686146065L;

	private List<Airline> airlineList;

	public AirlineList() {
		airlineList = new LinkedList<Airline>();
	}

	public List<Airline> getAirlineList() {
		return airlineList;
	}

	public void setAirlineList(List<Airline> airlineList) {
		this.airlineList = airlineList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineList == null) ? 0 : airlineList.hashCode());
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
		AirlineList other = (AirlineList) obj;
		if (airlineList == null) {
			if (other.airlineList != null) {
				return false;
			}
		} else if (!airlineList.equals(other.airlineList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AirlineList [airlineList=" + airlineList + "]";
	}
}
