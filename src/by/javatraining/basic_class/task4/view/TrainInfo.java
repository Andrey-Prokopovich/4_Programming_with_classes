package by.javatraining.basic_class.task4.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import by.javatraining.basic_class.task4.entity.Train;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
 * массива по номерам поездов. Добавьте возможность ввода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
 * одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class TrainInfo {

	private static final DateFormat dFormat = new SimpleDateFormat("d MMM 'в' HH:mm");

	public static String formTrainInfo(Train train) {
		return "Поезд № " + train.getNumber() + ", пункт назначения - " + train.getDestinationName() + ", оправляется "
				+ dFormat.format(train.getDepartureDateTime().getTime()) + ".";
	}
}
