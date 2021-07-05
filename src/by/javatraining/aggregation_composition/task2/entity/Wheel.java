package by.javatraining.aggregation_composition.task2.entity;

import java.io.Serializable;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class Wheel implements Serializable {

	private static final long serialVersionUID = -7016669952838802617L;

	private boolean busted;

	public Wheel() {
	}

	public Wheel(boolean busted) {
		this.busted = busted;
	}

	public boolean isBusted() {
		return busted;
	}

	public void setBusted(boolean busted) {
		this.busted = busted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (busted ? 1231 : 1237);
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
		Wheel other = (Wheel) obj;
		if (busted != other.busted) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Wheel [busted=" + busted + "]";
	}
}
