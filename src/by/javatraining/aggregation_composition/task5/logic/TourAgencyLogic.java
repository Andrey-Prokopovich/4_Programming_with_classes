package by.javatraining.aggregation_composition.task5.logic;

import java.util.List;

import by.javatraining.aggregation_composition.task5.entity.Client;
import by.javatraining.aggregation_composition.task5.entity.Reservation;
import by.javatraining.aggregation_composition.task5.entity.Tour;
import by.javatraining.aggregation_composition.task5.entity.TourAgency;
import by.javatraining.aggregation_composition.task5.exception.InvalidValueException;
import by.javatraining.aggregation_composition.task5.exception.NameTakenException;

public class TourAgencyLogic {

	private final PrintLogic printLogic;

	private TourAgency tourAgency;

	public TourAgencyLogic() {
		printLogic = new PrintLogic();
	}

	public void setTourAgency(TourAgency tourAgency) {
		if (tourAgency == null) {
			this.tourAgency = new TourAgency();
		} else {
			this.tourAgency = tourAgency;
		}
	}

	public TourAgency getTourAgency() {
		return tourAgency;
	}

	public PrintLogic getPrintLogic() {
		return printLogic;
	}

	public Client findClientByFullName(String fullName) {
		for (Client client : tourAgency.getClientList()) {
			if (client.getFullName().equals(fullName)) {
				return client;
			}
		}

		return null;
	}

	public Tour findTourByDesyination(String destination) {
		for (Tour tour : tourAgency.getTourList()) {
			if (tour.getDestination().equals(destination)) {
				return tour;
			}
		}

		return null;
	}

	public Reservation findReservationByClientAndTour(Client client, Tour tour) {
		for (Reservation reservation : tourAgency.getReservationList()) {
			if (reservation.getWhoReserved().equals(client) && reservation.getTourReserved().equals(tour)) {
				return reservation;
			}
		}

		return null;
	}

	private void insertClient(Client client) {
		List<Client> clientList;
		int listSize;

		clientList = tourAgency.getClientList();
		listSize = clientList.size();

		for (int i = 0; i < listSize; i++) {
			if (clientList.get(i).getFullName().equals(client.getFullName())) {
				clientList.add(i, client);
				return;
			}
		}

		clientList.add(client);
	}

	private void insertTour(Tour tour) {
		List<Tour> tourList;
		int listSize;

		tourList = tourAgency.getTourList();
		listSize = tourList.size();

		for (int i = 0; i < listSize; i++) {
			if (tourList.get(i).getDestination().equals(tour.getDestination())) {
				tourList.add(i, tour);
				return;
			}
		}

		tourList.add(tour);
	}

	public void addClient(String fullName) throws NameTakenException {
		if (findClientByFullName(fullName) != null) {
			throw new NameTakenException("Клиент \"" + fullName + "\" уже существует.");
		} else {
			insertClient(new Client(fullName));
		}
	}

	public void addTour(String destination, String tOptions, String fOptions, int numberOfDaysLimit)
			throws NameTakenException, InvalidValueException {
		if (findTourByDesyination(destination) != null) {
			throw new NameTakenException("Путевка местом назначения \"" + destination + "\" уже существует.");
		} else {
			Tour newTour = new Tour(destination, tOptions, fOptions, numberOfDaysLimit);
			insertTour(newTour);
		}
	}

	public void addReservation(Client whoReserved, Tour tourReserved, int transport, int food, int numberOfDays)
			throws NameTakenException, InvalidValueException {
		if (findReservationByClientAndTour(whoReserved, tourReserved) != null) {
			throw new NameTakenException("Путевка \"" + tourReserved.getDestination() + "\" клиентом "
					+ whoReserved.getFullName() + " уже забронирована.");
		} else {
			Reservation newreservation = new Reservation(whoReserved, tourReserved, transport, food, numberOfDays);
			tourAgency.getReservationList().add(newreservation);

			System.out.println(newreservation.toString());
		}
	}

	public void removeClientByName(String fullName) {
		Client forRemoval;

		forRemoval = findClientByFullName(fullName);

		if (forRemoval != null) {
			removeReservationsByClient(forRemoval);
			tourAgency.getClientList().remove(forRemoval);
		}
	}

	public void removeTourByDestination(String destination) {
		Tour forRemoval;

		forRemoval = findTourByDesyination(destination);

		if (forRemoval != null) {
			removeReservationsByTour(forRemoval);
			tourAgency.getTourList().remove(forRemoval);
		}
	}

	public void removeReservationsByClient(Client client) {
		if (client == null) {
			return;
		}

		List<Reservation> reservationList = tourAgency.getReservationList();

		for (Reservation reservation : reservationList) {
			if (reservation.getWhoReserved().equals(client)) {
				reservationList.remove(reservation);
			}
		}
	}

	public void removeReservationsByTour(Tour tour) {
		if (tour == null) {
			return;
		}

		List<Reservation> reservationList = tourAgency.getReservationList();

		for (Reservation reservation : reservationList) {
			if (reservation.getTourReserved().equals(tour)) {
				reservationList.remove(reservation);
			}
		}
	}

	public void removeTourReservation(Client client, Tour tour) {
		Reservation forRemoval;

		forRemoval = findReservationByClientAndTour(client, tour);

		if (forRemoval != null) {
			tourAgency.getReservationList().remove(forRemoval);
		}
	}

	public void removeAllCustomers() {
		List<Client> clientList = tourAgency.getClientList();

		if (clientList.isEmpty()) {
			return;
		}

		clientList.clear();
		removeAllTourReservations();
	}

	public void removeAllTours() {
		List<Tour> tourList = tourAgency.getTourList();

		if (tourList.isEmpty()) {
			return;
		}

		tourList.clear();
		removeAllTourReservations();
	}

	public void removeAllTourReservations() {
		List<Reservation> reservationList = tourAgency.getReservationList();

		if (reservationList.isEmpty()) {
			return;
		}

		reservationList.clear();
	}
}
