package by.javatraining.basic_class.task5.main;

/*
 * Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать
 * свое значение на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика
 * значениями по умолчанию и призвольными значениями. Счетчик имеет методы увеличения и
 * уменьшения состояния, и метод позволяющий получить его текущее состояние.
 * Напиать код, демонстрирующий все возможность класса.
 */

public class DexCounter {

	private final int minValue;
	private final int maxValue;

	private int dexValue;

	public DexCounter() {
		this(100, 90, 110);
	}

	public DexCounter(int newDexV) {
		this(newDexV, newDexV - 10, newDexV + 10);
	}

	public DexCounter(int newDexV, int newMinV, int newMaxV) {
		dexValue = newDexV;
		minValue = newMinV;
		maxValue = newMaxV;
	}

	public boolean increase() {
		if (dexValue + 1 <= maxValue) {
			dexValue++;

			return true;
		} else {
			return false;
		}
	}

	public boolean decrease() {
		if (dexValue - 1 >= minValue) {
			dexValue--;

			return true;
		} else {
			return false;
		}
	}

	public int getDexValue() {
		return dexValue;
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public String printValues() {
		return "Текущее значение: " + getDexValue() + "\nДиапазон значений: от " + getMinValue() + " до "
				+ getMaxValue();
	}
}
