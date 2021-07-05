package by.javatraining.aggregation_composition.task2.main;

import by.javatraining.aggregation_composition.task2.exception.BustedTireException;
import by.javatraining.aggregation_composition.task2.exception.EmptyTankException;
import by.javatraining.aggregation_composition.task2.exception.EngineNotStartedException;
import by.javatraining.aggregation_composition.task2.exception.InvalidValueException;
import by.javatraining.aggregation_composition.task2.logic.CarLogic;

/*
 * Создать объект класса Автомобиль, использую классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 */

public class Main {

	public static void main(String[] args) {
		CarLogic carLogic = new CarLogic();

		carLogic.setCarModel("Audi A8");
		System.out.println(carLogic.printCarMark());

		try {
			carLogic.drive();
		} catch (BustedTireException | EmptyTankException | EngineNotStartedException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println();

		carLogic.replaceTires();
		System.out.println("Замена колес завершена.");

		try {
			carLogic.refillTank();
		} catch (InvalidValueException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Бак заправлен");

		carLogic.startEngine();
		System.out.println("Двигатель запущен.");
		System.out.println();

		try {
			carLogic.drive();
		} catch (BustedTireException | EmptyTankException | EngineNotStartedException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Едем.");
	}
}
