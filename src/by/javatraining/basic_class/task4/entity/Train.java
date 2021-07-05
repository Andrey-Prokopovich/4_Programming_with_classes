package by.javatraining.basic_class.task4.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
 * массива по номерам поездов. Добавьте возможность ввода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
 * одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class Train implements Serializable {

	private static final long serialVersionUID = -1151341181622479574L;

	private String destinationName;
	private int number;
	private Calendar departureDateTime;

	public Train() {
		departureDateTime = new GregorianCalendar(2021, Calendar.JANUARY, 1);
	}

	public Train(String destinationName, int number) {
		this();

		setDestinationName(destinationName);
		setNumber(number);
	}

	public String getDestinationName() {
		return destinationName;
	}

	public int getNumber() {
		return number;
	}

	public Calendar getDepartureDateTime() {
		return (Calendar) departureDateTime.clone();
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDepartureDateTime(Calendar departureDateTime) {
		this.departureDateTime.set(Calendar.DAY_OF_MONTH, departureDateTime.get(Calendar.DAY_OF_MONTH));
		this.departureDateTime.set(Calendar.MONTH, departureDateTime.get(Calendar.MONTH));
		this.departureDateTime.set(Calendar.YEAR, departureDateTime.get(Calendar.YEAR));

		this.departureDateTime.set(Calendar.HOUR_OF_DAY, departureDateTime.get(Calendar.HOUR_OF_DAY));
		this.departureDateTime.set(Calendar.MINUTE, departureDateTime.get(Calendar.MINUTE));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDateTime == null) ? 0 : departureDateTime.hashCode());
		result = prime * result + ((destinationName == null) ? 0 : destinationName.hashCode());
		result = prime * result + number;
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
		Train other = (Train) obj;
		if (departureDateTime == null) {
			if (other.departureDateTime != null) {
				return false;
			}
		} else if (!departureDateTime.equals(other.departureDateTime)) {
			return false;
		}
		if (destinationName == null) {
			if (other.destinationName != null) {
				return false;
			}
		} else if (!destinationName.equals(other.destinationName)) {
			return false;
		}
		if (number != other.number) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Train [destinationName=" + destinationName + ", number=" + number + ", departureTime="
				+ departureDateTime + "]";
	}
}
