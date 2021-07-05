package by.javatraining.basic_class.task1.main;

import java.io.Serializable;

/*
 * Создайте класс Test1 с двумя переменными.
 * Добавьте метод вывода на экран и методы изменения этих переменных.
 * Добавьте метод, который находит сумму значений этих переменных, и метод,
 * который находит наибольшее значение из этих двух переменных.
 */

public class Test1 implements Serializable {

	private static final long serialVersionUID = 1202626883050829911L;

	private int variableOne;
	private int variableTwo;

	public Test1() {
	}

	public final int getVariableOne() {
		return variableOne;
	}

	public final int getVariableTwo() {
		return variableTwo;
	}

	public final void setVariableOne(int variableOne) {
		this.variableOne = variableOne;
	}

	public final void setVariableTwo(int variableTwo) {
		this.variableTwo = variableTwo;
	}

	public int sumVariables() {
		return variableOne + variableTwo;
	}

	public int findGreaterVariable() {
		return Math.max(variableOne, variableTwo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + variableOne;
		result = prime * result + variableTwo;
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
		Test1 other = (Test1) obj;
		if (variableOne != other.variableOne) {
			return false;
		}
		if (variableTwo != other.variableTwo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Test1 [variableOne=" + variableOne + ", variableTwo=" + variableTwo + "]";
	}
}
