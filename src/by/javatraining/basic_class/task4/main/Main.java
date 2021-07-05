package by.javatraining.basic_class.task4.main;

import java.util.GregorianCalendar;

import by.javatraining.basic_class.task4.entity.Train;
import by.javatraining.basic_class.task4.exception.NonUniqueNumberException;
import by.javatraining.basic_class.task4.logic.ScheduleLogic;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
 * массива по номерам поездов. Добавьте возможность ввода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
 * одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class Main {

	public static void main(String[] args) {
		final ScheduleLogic scheduleLogic = new ScheduleLogic();

		Train newTrain;

		try {
			newTrain = new Train("Вильнюс", 601);
			newTrain.setDepartureDateTime(new GregorianCalendar(2020, 5, 12, 12, 44));
			scheduleLogic.addTrain(newTrain);

			newTrain = new Train("Гродно", 102);
			newTrain.setDepartureDateTime(new GregorianCalendar(2020, 5, 12, 13, 15));
			scheduleLogic.addTrain(newTrain);

			newTrain = new Train("Москва", 406);
			newTrain.setDepartureDateTime(new GregorianCalendar(2020, 5, 12, 9, 0));
			scheduleLogic.addTrain(newTrain);

			newTrain = new Train("Новый-Уренгой", 602);
			newTrain.setDepartureDateTime(new GregorianCalendar(2020, 5, 12, 9, 22));
			scheduleLogic.addTrain(newTrain);

			newTrain = new Train("Гродно", 330);
			newTrain.setDepartureDateTime(new GregorianCalendar(2020, 5, 12, 00, 25));
			scheduleLogic.addTrain(newTrain);

		} catch (NonUniqueNumberException exc) {
			System.out.println(exc.getMessage());
			return;
		}

		System.out.println("Список поездов:");
		System.out.println(scheduleLogic.printTrainList());

		scheduleLogic.sortByNumber();

		System.out.println("Список поездов:");
		System.out.println(scheduleLogic.printTrainList());

		scheduleLogic.sortByDestinationAndDateTime();

		System.out.println("Список поездов:");
		System.out.println(scheduleLogic.printTrainList());

		newTrain = scheduleLogic.findByNumber(406);
		newTrain.setDestinationName("Вильнюс");

		scheduleLogic.sortByDestinationAndDateTime();

		System.out.println("Список поездов:");
		System.out.println(scheduleLogic.printTrainList());
	}
}
