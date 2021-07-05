package by.javatraining.aggregation_composition.task2.logic;

import by.javatraining.aggregation_composition.task2.entity.Car;
import by.javatraining.aggregation_composition.task2.entity.Engine;
import by.javatraining.aggregation_composition.task2.entity.Wheel;
import by.javatraining.aggregation_composition.task2.exception.BustedTireException;
import by.javatraining.aggregation_composition.task2.exception.EmptyTankException;
import by.javatraining.aggregation_composition.task2.exception.EngineNotStartedException;
import by.javatraining.aggregation_composition.task2.exception.InvalidValueException;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class CarLogic {

	private final Car car;

	public CarLogic() {
		car = new Car();
	}
	
	public void setCarModel(String carModel) {
		car.setModel(carModel);
	}
	
	public void replaceTires() {
		Wheel[] wheels = car.getWheels();

		for (int i = 0; i < wheels.length; i++) {
			if (wheels[i].isBusted()) {
				wheels[i].setBusted(false);
			}
		}
	}

	public void refillTank() throws InvalidValueException {
		Engine engine = car.getEngine();
		
		if (engine.getFuelLevel() < Engine.TANK_FULL) {
			engine.setFuelLevel(Engine.TANK_FULL);
		}
	}

	public void startEngine() {
		Engine engine = car.getEngine();
		
		if (!engine.isStarted()) {
			engine.setStarted(true);
		}
	}

	public void stopEngine() {
		Engine engine = car.getEngine();
		
		if (engine.isStarted()) {
			engine.setStarted(false);
		}
	}
	
	public boolean checkIfTiresBusted() {
		Wheel[] wheels = car.getWheels();

		for (int i = 0; i < wheels.length; i++) {
			if (wheels[i].isBusted()) {
				return true;
			}
		}

		return false;
	}
	
	public boolean checkIfTankEmpty() {
		Engine engine = car.getEngine();
		
		return engine.getFuelLevel() == Engine.TANK_EMPTY;
	}
	
	public boolean checkIfEngineNotStarted() {
		Engine engine = car.getEngine();
		
		return engine.isStarted();
	}

	public void drive() throws BustedTireException, EmptyTankException, EngineNotStartedException {
		if (checkIfTiresBusted()) {
			throw new BustedTireException("Нужно заменить колесо(-са).");
		}
		if (checkIfTankEmpty()) {
			throw new EmptyTankException("Нужно заправиться.");
		}
		if (checkIfEngineNotStarted()) {
			throw new EngineNotStartedException("Нужно завести двигатель.");
		}
	}

	public String printCarMark() {
		return car.getModel();
	}
}
