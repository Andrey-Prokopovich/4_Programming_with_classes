package by.javatraining.aggregation_composition.task5.logic;

import java.util.List;

import by.javatraining.aggregation_composition.task5.entity.Reservation;
import by.javatraining.aggregation_composition.task5.entity.Tour;

public class PrintLogic {

	public PrintLogic() {
	}

	public String getTransportStringValue(int type) {
		switch (type) {
		case 0:
			return "самостоятельно";
		case 1:
			return "такси";
		case 2:
			return "автобус";
		case 3:
			return "поезд";
		case 4:
			return "корабль";
		case 5:
			return "самолет";
		default:
			return "Неизвестное значение параметра type.";
		}
	}

	public String getFoodStringValue(int type) {
		switch (type) {
		case 0:
			return "Без питания";
		case 1:
			return "Завтраки";
		case 2:
			return "Полупансион";
		case 3:
			return "Полный пансион";
		case 4:
			return "Все включено";
		default:
			return "Неизвестное значение параметра type.";
		}
	}

	public String getDaysString(int number) {
		if (number < 2) {
			return "день";
		}

		if (number < 5) {
			return "дня";
		}

		return "дней";
	}

	public String formListOfTransportOptions(Tour tour) {
		StringBuilder namesLine = new StringBuilder();

		for (int i = 0; i < Tour.TRANSPORT_OPTIONS_SIZE; i++) {
			if (tour.getTransportOptions()[i]) {
				namesLine.append((namesLine.length() != 0 ? ", " : "") + getTransportStringValue(i));
			}
		}

		return namesLine.toString();
	}

	public String formListOfFoodOptions(Tour tour) {
		StringBuilder namesLine = new StringBuilder();

		for (int i = 0; i < Tour.FOOD_OPTIONS_SIZE; i++) {
			if (tour.getFoodOptions()[i]) {
				namesLine.append((namesLine.length() != 0 ? ", " : "") + getDaysString(i));
			}
		}

		return namesLine.toString();
	}
	
	public String formListOfTours(List<Tour> tourList) {
		StringBuilder strList = new StringBuilder();
		
		strList.append("Список доступных путевок:\n");

		for (Tour tour : tourList) {
			strList.append(formTourInfo(tour) + "\n");
		}
		
		return strList.toString();
	}

	public String formTourInfo(Tour tour) {
		return "Путевка в " + tour.getDestination() + " длительностью до " + tour.getNumberOfDaysLimit() + " "
				+ getDaysString(tour.getNumberOfDaysLimit()) + "." + " Варианты транспорта: "
				+ formListOfTransportOptions(tour) + "." + " Варианты питания: " + formListOfFoodOptions(tour) + ".";
	}

	public String formReservationInfo(Reservation reservation) {
		return "Зарезервировано " + reservation.getWhoReserved().getFullName() + " - путевка в "
				+ reservation.getTourReserved().getDestination() + " на " + reservation.getNumberOfDays() + " "
				+ getDaysString(reservation.getNumberOfDays()) + ", транспорт - "
				+ getTransportStringValue(reservation.getTransport()) + ", питание - "
				+ getDaysString(reservation.getFood()) + ".";
	}
}
