package by.javatraining.aggregation_composition.task5.entity;

import java.io.Serializable;

import by.javatraining.aggregation_composition.task5.exception.InvalidValueException;

/*
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической
 * путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для
 * оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 */

public class Reservation implements Serializable {

	private static final long serialVersionUID = 7374905521952094766L;

	private Client whoReserved;
	private Tour tourReserved;
	private int transport;
	private int food;
	private int numberOfDays;

	public Reservation() {
	}

	public Reservation(Client whoReserved, Tour tourReserved, int transport, int food, int numberOfDays)
			throws InvalidValueException {
		setWhoReserved(whoReserved);
		setTourReserved(tourReserved);
		setTransport(transport);
		setFood(food);
		setNumberOfDays(numberOfDays);
	}

	public Client getWhoReserved() {
		return whoReserved;
	}

	public Tour getTourReserved() {
		return tourReserved;
	}

	public int getTransport() {
		return transport;
	}

	public int getFood() {
		return food;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setWhoReserved(Client whoReserved) throws InvalidValueException {
		if (whoReserved == null) {
			throw new InvalidValueException("Ссылка на клиента оформившего бронирование не может быть null.");
		}
		
		this.whoReserved = whoReserved;
	}

	public void setTourReserved(Tour tourReserved) throws InvalidValueException {
		if (tourReserved == null) {
			throw new InvalidValueException("Ссылка на забронированую путевку не может быть null.");
		}
		
		this.tourReserved = tourReserved;
	}

	public void setTransport(int transport) throws InvalidValueException {
		if (transport < 0) {
			throw new InvalidValueException("Выбранный тип транспорта не может быть отрицателтьным.");
		}
		if (transport > Tour.TRANSPORT_OPTIONS_SIZE) {
			throw new InvalidValueException("Выбранный тип транспорта не может быть больше " + Tour.TRANSPORT_OPTIONS_SIZE +".");
		}
		
		this.transport = transport;
	}

	public void setFood(int food) throws InvalidValueException {
		if (food < 0) {
			throw new InvalidValueException("Выбранный тип питания не может быть отрицателтьным.");
		}
		if (food > Tour.FOOD_OPTIONS_SIZE) {
			throw new InvalidValueException("Выбранный тип питания не может быть больше " + Tour.FOOD_OPTIONS_SIZE +".");
		}
		
		this.food = food;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + food;
		result = prime * result + numberOfDays;
		result = prime * result + ((tourReserved == null) ? 0 : tourReserved.hashCode());
		result = prime * result + transport;
		result = prime * result + ((whoReserved == null) ? 0 : whoReserved.hashCode());
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
		Reservation other = (Reservation) obj;
		if (food != other.food) {
			return false;
		}
		if (numberOfDays != other.numberOfDays) {
			return false;
		}
		if (tourReserved == null) {
			if (other.tourReserved != null) {
				return false;
			}
		} else if (!tourReserved.equals(other.tourReserved)) {
			return false;
		}
		if (transport != other.transport) {
			return false;
		}
		if (whoReserved == null) {
			if (other.whoReserved != null) {
				return false;
			}
		} else if (!whoReserved.equals(other.whoReserved)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [whoReserved=" + whoReserved + ", tourReserved=" + tourReserved + ", transport=" + transport
				+ ", food=" + food + ", numberOfDays=" + numberOfDays + "]";
	}
}
