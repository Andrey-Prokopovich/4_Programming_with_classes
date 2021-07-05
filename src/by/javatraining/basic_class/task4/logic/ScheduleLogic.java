package by.javatraining.basic_class.task4.logic;

import java.util.Comparator;
import java.util.List;

import by.javatraining.basic_class.task4.entity.Train;
import by.javatraining.basic_class.task4.entity.TrainSchedule;
import by.javatraining.basic_class.task4.exception.NonUniqueNumberException;
import by.javatraining.basic_class.task4.view.TrainInfo;

/*
 * Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов
 * массива по номерам поездов. Добавьте возможность ввода информации о поезде, номер которого введен
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда с
 * одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */

public class ScheduleLogic {

	private final TrainSchedule schedule;

	public ScheduleLogic() {
		schedule = new TrainSchedule();
	}

	public void addTrain(Train train) throws NonUniqueNumberException {
		if (findByNumber(train.getNumber()) != null) {
			throw new NonUniqueNumberException("Поезд с таким номером уже есть в расписании.");
		}

		schedule.getTrainSchedule().add(train);
	}

	public void removeTrain(Train train) {
		schedule.getTrainSchedule().remove(train);
	}

	public Train findByNumber(int targetNumber) {
		List<Train> scheduledTrains = schedule.getTrainSchedule();

		for (int i = 0; i < scheduledTrains.size(); i++) {
			if (scheduledTrains.get(i).getNumber() == targetNumber) {
				return scheduledTrains.get(i);
			}
		}

		return null;
	}

	public void sortByNumber() {
		schedule.getTrainSchedule().sort(new Comparator<Train>() {

			@Override
			public int compare(Train train1, Train train2) {
				return train1.getNumber() - train2.getNumber();
			}

		});
	}

	public void sortByDestinationAndDateTime() {
		schedule.getTrainSchedule().sort(new Comparator<Train>() {

			@Override
			public int compare(Train train1, Train train2) {
				int compareResult = train1.getDestinationName().compareTo(train2.getDestinationName());

				if (compareResult == 0) {
					compareResult = train1.getDepartureDateTime().compareTo(train2.getDepartureDateTime());
				}

				return compareResult;
			}

		});
	}

	public String printTrainList() {
		StringBuilder strTrainList = new StringBuilder();

		for (Train train : schedule.getTrainSchedule()) {
			strTrainList.append(TrainInfo.formTrainInfo(train) + "\n");
		}

		return strTrainList.toString();
	}
}
