package by.javatraining.aggregation_composition.task5.main;

import by.javatraining.aggregation_composition.task5.entity.TourAgency;
import by.javatraining.aggregation_composition.task5.exception.InvalidValueException;
import by.javatraining.aggregation_composition.task5.exception.NameTakenException;
import by.javatraining.aggregation_composition.task5.logic.TourAgencyLogic;

/*
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической
 * путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для
 * оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 */

public class Main {

	public static void main(String[] args) {
		TourAgencyLogic tourAgencyLogic = new TourAgencyLogic();

		tourAgencyLogic.setTourAgency(new TourAgency("Горячие путевки"));

		System.out.println(tourAgencyLogic.getTourAgency().getName());

		System.out.println();

		try {
			tourAgencyLogic.addClient("гн.Рич");
		} catch (NameTakenException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println();

		try {
			tourAgencyLogic.addTour("круиз на \"Queen Berry\"", "012", "04", 1);
			tourAgencyLogic.addTour("экскурсия \"Великие пирамиды\"", "345", "0", 1);
			tourAgencyLogic.addTour("экскурсия \"Парижские катакомбы\"", "345", "0", 1);
			tourAgencyLogic.addTour("отдых на Канарских островах", "45", "01234", 20);
			tourAgencyLogic.addTour("лечение в пансионе \"Нарачь\"", "23", "234", 30);
		} catch (NameTakenException | InvalidValueException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println();

		tourAgencyLogic.getPrintLogic().formListOfTours(tourAgencyLogic.getTourAgency().getTourList());

		System.out.println();

		try {
			tourAgencyLogic.addReservation(tourAgencyLogic.findClientByFullName("гн.Рич"),
					tourAgencyLogic.findTourByDesyination("отдых на Канарских островах"), 5, 4, 14);
		} catch (NameTakenException | InvalidValueException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}
