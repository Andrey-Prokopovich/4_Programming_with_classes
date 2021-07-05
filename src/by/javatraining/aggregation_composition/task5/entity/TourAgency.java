package by.javatraining.aggregation_composition.task5.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической
 * путевки различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для
 * оптимального выбора. Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 */

public class TourAgency implements Serializable {

	private static final long serialVersionUID = 4707823266956456961L;

	private String name;
	private List<Client> clientList;
	private List<Tour> tourList;
	private List<Reservation> reservationList;

	public TourAgency() {
		clientList = new LinkedList<Client>();
		tourList = new LinkedList<Tour>();
		reservationList = new LinkedList<Reservation>();
	}

	public TourAgency(String name) {
		this();

		setName(name);
	}

	public String getName() {
		return name;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public List<Tour> getTourList() {
		return tourList;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public void setTourList(List<Tour> tourList) {
		this.tourList = tourList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientList == null) ? 0 : clientList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reservationList == null) ? 0 : reservationList.hashCode());
		result = prime * result + ((tourList == null) ? 0 : tourList.hashCode());
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
		TourAgency other = (TourAgency) obj;
		if (clientList == null) {
			if (other.clientList != null) {
				return false;
			}
		} else if (!clientList.equals(other.clientList)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (reservationList == null) {
			if (other.reservationList != null) {
				return false;
			}
		} else if (!reservationList.equals(other.reservationList)) {
			return false;
		}
		if (tourList == null) {
			if (other.tourList != null) {
				return false;
			}
		} else if (!tourList.equals(other.tourList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TourAgency [name=" + name + ", clientList=" + clientList + ", tourList=" + tourList
				+ ", reservationList=" + reservationList + "]";
	}
}