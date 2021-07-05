package by.javatraining.aggregation_composition.task2.entity;

import java.io.Serializable;
import java.util.Arrays;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class Car implements Serializable {

	private static final long serialVersionUID = -8252578180735720426L;

	private static final byte AMOUNT_OF_WHEELS = 4;

	private String model;
	private Engine engine;
	private Wheel[] wheels;

	public Car() {
		wheels = new Wheel[AMOUNT_OF_WHEELS];
		engine = new Engine();

		for (int i = 0; i < wheels.length; i++) {
			wheels[i] = new Wheel();
		}
	}

	public Car(String model) {
		this();

		setModel(model);
	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	public Wheel[] getWheels() {
		return wheels;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setWheels(Wheel[] wheels) {
		this.wheels = wheels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + Arrays.hashCode(wheels);
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
		Car other = (Car) obj;
		if (engine == null) {
			if (other.engine != null) {
				return false;
			}
		} else if (!engine.equals(other.engine)) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (!Arrays.equals(wheels, other.wheels)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", engine=" + engine + ", wheels=" + Arrays.toString(wheels) + "]";
	}
}
