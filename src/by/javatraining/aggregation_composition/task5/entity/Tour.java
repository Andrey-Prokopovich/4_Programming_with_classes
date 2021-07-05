package by.javatraining.aggregation_composition.task5.entity;

import java.io.Serializable;
import java.util.Arrays;

import by.javatraining.aggregation_composition.task5.exception.InvalidValueException;

/*
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической
 * путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для
 * оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 */

public class Tour implements Serializable {

	private static final long serialVersionUID = 3881809631902572668L;

	public static final byte TRANSPORT_OPTIONS_SIZE = 6;
	public static final byte FOOD_OPTIONS_SIZE = 5;

	private String destination;
	private int numberOfDaysLimit;
	private boolean[] transportOptions;
	private boolean[] foodOptions;

	public Tour() {
		transportOptions = new boolean[TRANSPORT_OPTIONS_SIZE];
		foodOptions = new boolean[FOOD_OPTIONS_SIZE];
	}

	public Tour(String destination, String tOptions, String fOptions, int numberOfDaysLimit)
			throws InvalidValueException {
		this();

		setDestination(destination);
		setNumberOfDaysLimit(numberOfDaysLimit);

		if (!tOptions.isEmpty()) {
			for (int i = 0; i < TRANSPORT_OPTIONS_SIZE; i++) {
				if (tOptions.indexOf(String.valueOf(i)) != -1)
					transportOptions[i] = true;
			}
		}

		if (!fOptions.isEmpty()) {
			for (int i = 0; i < FOOD_OPTIONS_SIZE; i++) {
				if (fOptions.indexOf(String.valueOf(i)) != -1)
					foodOptions[i] = true;
			}
		}
	}

	public String getDestination() {
		return destination;
	}

	public int getNumberOfDaysLimit() {
		return numberOfDaysLimit;
	}

	public boolean[] getTransportOptions() {
		return transportOptions.clone();
	}

	public boolean[] getFoodOptions() {
		return foodOptions.clone();
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setNumberOfDaysLimit(int numberOfDaysLimit) throws InvalidValueException {
		if (numberOfDaysLimit < 1) {
			throw new InvalidValueException("Предел количества дней путевки не может быть меньше единицы.");
		}

		this.numberOfDaysLimit = numberOfDaysLimit;
	}

	public void setTransportOptions(boolean[] transportOptions) throws InvalidValueException {
		if (transportOptions.length > TRANSPORT_OPTIONS_SIZE) {
			throw new InvalidValueException("Размер масива вариантов транспорта не может быть больше " + TRANSPORT_OPTIONS_SIZE + ".");
		}

		for (int i = 0; i < transportOptions.length; i++) {
			this.transportOptions[i] = transportOptions[i];
		}
	}

	public void setFoodOptions(boolean[] foodOptions) throws InvalidValueException {
		if (foodOptions.length > FOOD_OPTIONS_SIZE) {
			throw new InvalidValueException("Размер масива вариантов питания не может быть больше " + FOOD_OPTIONS_SIZE + ".");
		}

		for (int i = 0; i < foodOptions.length; i++) {
			this.foodOptions[i] = foodOptions[i];
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + Arrays.hashCode(foodOptions);
		result = prime * result + numberOfDaysLimit;
		result = prime * result + Arrays.hashCode(transportOptions);
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
		Tour other = (Tour) obj;
		if (destination == null) {
			if (other.destination != null) {
				return false;
			}
		} else if (!destination.equals(other.destination)) {
			return false;
		}
		if (!Arrays.equals(foodOptions, other.foodOptions)) {
			return false;
		}
		if (numberOfDaysLimit != other.numberOfDaysLimit) {
			return false;
		}
		if (!Arrays.equals(transportOptions, other.transportOptions)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Tour [destination=" + destination + ", numberOfDaysLimit=" + numberOfDaysLimit + ", transportOptions="
				+ Arrays.toString(transportOptions) + ", foodOptions=" + Arrays.toString(foodOptions) + "]";
	}
}
