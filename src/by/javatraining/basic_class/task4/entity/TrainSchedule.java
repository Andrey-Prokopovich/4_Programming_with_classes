package by.javatraining.basic_class.task4.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
 * массива по номерам поездов. Добавьте возможность ввода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
 * одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class TrainSchedule implements Serializable {

	private static final long serialVersionUID = 6533403923212444015L;

	private List<Train> scheduledTrains;

	public TrainSchedule() {
		scheduledTrains = new LinkedList<Train>();
	}

	public final List<Train> getTrainSchedule() {
		return scheduledTrains;
	}

	public final void setTrainSchedule(List<Train> scheduledTrains) {
		this.scheduledTrains = scheduledTrains;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scheduledTrains == null) ? 0 : scheduledTrains.hashCode());
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
		TrainSchedule other = (TrainSchedule) obj;
		if (scheduledTrains == null) {
			if (other.scheduledTrains != null) {
				return false;
			}
		} else if (!scheduledTrains.equals(other.scheduledTrains)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TrainSchedule [trainSchedule=" + scheduledTrains + "]";
	}
}