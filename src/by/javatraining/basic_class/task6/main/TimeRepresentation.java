package by.javatraining.basic_class.task6.main;

import java.time.LocalTime;

/*
 * Составьте описание класса для представления времени. Предусмотрите возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений.
 * В случае недопустимых значений - поле устанавливать в значение ноль. Создать методы изменения
 * времени на заданное количество часов, минут и секунд.
 */

public class TimeRepresentation {

	private int hour;
	private int minute;
	private int second;

	public enum TimePiece {
		HOUR, MINUTE, SECOND
	}

	public TimeRepresentation() {
		LocalTime localTime = LocalTime.now();

		setHour(localTime.getHour());
		setMinute(localTime.getMinute());
		setSecond(localTime.getSecond());
	}

	private boolean checkIfLess24(int chkNum) {
		return chkNum < 24;
	}

	private boolean checkIfLess60(int chkNum) {
		return chkNum < 60;
	}

	public void setTime(int newHour, int newMinute, int newSecond) {
		setHour(newHour);
		setMinute(newMinute);
		setSecond(newSecond);
	}

	public void setHour(int newHour) {
		hour = (checkIfLess24(newHour) ? newHour : 0);
	}

	public void setMinute(int newMinute) {
		minute = (checkIfLess60(newMinute) ? newMinute : 0);
	}

	public void setSecond(int newSecond) {
		second = (checkIfLess60(newSecond) ? newSecond : 0);
	}

	public void roll(TimePiece tPiece, int chgValue) {
		switch (tPiece) {
		case HOUR:
			hour = (hour + chgValue) % 24;
			if (hour < 0) {
				hour = 24 + hour;
			}
			break;
		case MINUTE:
			minute = (minute + chgValue) % 60;
			if (minute < 0) {
				minute = 60 + minute;
			}
			break;
		case SECOND:
			second = (second + chgValue) % 60;
			if (second < 0) {
				second = 60 + second;
			}
			break;
		default:
			break;
		}
	}

	public void add(TimePiece tPiece, int chgValue) {
		int iOverClock = 0;

		switch (tPiece) {
		case HOUR:
			/*
			 * iOverClock = (iHour + chgValue) / 24; if(iOverClock < 0) iOverClock =
			 * iOverClock - 1;
			 */

			hour = (hour + chgValue) % 24;
			if (hour < 0) {
				hour = 24 + hour;
			}
			break;
		case MINUTE:
			iOverClock = (minute + chgValue) / 60;

			if (iOverClock < 0) {
				iOverClock = iOverClock - 1;
			}

			minute = (minute + chgValue) % 60;
			if (minute < 0) {
				minute = 60 + minute;
			}

			if (iOverClock != 0) {
				add(TimePiece.HOUR, iOverClock);
			}
			break;
		case SECOND:
			iOverClock = (second + chgValue) / 60;

			if (iOverClock < 0) {
				iOverClock = iOverClock - 1;
			}

			second = (second + chgValue) % 60;
			if (second < 0) {
				second = 60 + second;
			}

			if (iOverClock != 0) {
				add(TimePiece.MINUTE, iOverClock);
			}
			break;
		default:
			break;
		}
	}

	public String printTime() {
		return "Текущее значение: " + hour + ":" + minute + ":" + second;
	}
}
