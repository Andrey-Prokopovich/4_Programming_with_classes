package by.javatraining.aggregation_composition.task2.entity;

import java.io.Serializable;

import by.javatraining.aggregation_composition.task2.exception.InvalidValueException;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class Engine implements Serializable {

	private static final long serialVersionUID = 1487584507427039474L;

	public static final int TANK_EMPTY = 0;
	public static final int TANK_FULL = 100;

	private boolean isStarted;
	private int fuelLevel;

	public Engine() {
		isStarted = false;
		fuelLevel = 0;
	}

	public Engine(int fuelLevel) throws InvalidValueException {
		setFuelLevel(fuelLevel);
	}

	public boolean isStarted() {
		return isStarted;
	}

	public int getFuelLevel() {
		return fuelLevel;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public void setFuelLevel(int fuelLevel) throws InvalidValueException {
		if (fuelLevel < TANK_EMPTY) {
			throw new InvalidValueException("Уровень топлива не может быть отрицательным.");
		}
		if (fuelLevel > TANK_FULL) {
			throw new InvalidValueException("Уровень топлива не может быть больше " + TANK_FULL + ".");
		}

		this.fuelLevel = fuelLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fuelLevel;
		result = prime * result + (isStarted ? 1231 : 1237);
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
		Engine other = (Engine) obj;
		if (fuelLevel != other.fuelLevel) {
			return false;
		}
		if (isStarted != other.isStarted) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Engine [isStarted=" + isStarted + ", fuelLevel=" + fuelLevel + "]";
	}
}
