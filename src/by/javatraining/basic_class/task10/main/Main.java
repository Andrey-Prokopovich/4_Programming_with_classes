package by.javatraining.basic_class.task10.main;

import by.javatraining.basic_class.task10.entity.Airline;
import by.javatraining.basic_class.task10.exception.InvalidValueException;
import by.javatraining.basic_class.task10.logic.AirlineListLogic;

/*
 * Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 *  a) список рейсов для заданного пункта назначения;
 *  b) список рейсов для заданного дня недели;
 *  c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

public class Main {

	public static void main(String[] args) {
		AirlineListLogic logic = new AirlineListLogic();

		try {
			logic.addAirline(new Airline("Токио", 75896, "ТУ-144", new int[] { 14, 00 },
					new boolean[] { false, false, true, false, true, true, true }));
			logic.addAirline(new Airline("Москва", 13876, "ТУ-144", new int[] { 9, 30 },
					new boolean[] { false, false, true, false, true, true, true }));
			logic.addAirline(new Airline("Лондон", 75896, "Боинг 737", new int[] { 12, 10 },
					new boolean[] { false, true, false, true, true, false, true }));
			logic.addAirline(new Airline("Нью Йорк", 12476, "Боинг 747", new int[] { 00, 30 },
					new boolean[] { true, false, true, false, true, false, true }));
			logic.addAirline(new Airline("Вашингтон", 75896, "ДС-10", new int[] { 23, 00 },
					new boolean[] { true, false, false, true, true, true, false }));
			logic.addAirline(new Airline("Токио", 13236, "ДС-10", new int[] { 17, 45 },
					new boolean[] { true, true, true, false, false, false, false }));
			logic.addAirline(new Airline("Москва", 43774, "ТУ-144", new int[] { 11, 40 },
					new boolean[] { true, true, true, true, true, false, false }));
			
			logic.printAirlinesWithDestination("Токио");

			System.out.println();

			logic.printAirlinesOnWeekDay(3);

			System.out.println();

			logic.printAirlinesOnWeekDayByTime(3, 13, 45);
		} catch (InvalidValueException exc) {
			System.out.println(exc.getMessage());
			return;
		}
	}
}
