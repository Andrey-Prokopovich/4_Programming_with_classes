package by.javatraining.basic_class.task2.entity;

import java.io.Serializable;
import java.util.Random;

/*
 * Создайте класс Test2 с двумя переменными. Добавьте конструктор с входными параметрами.
 * Добавьте конструктор, инициализирующий члены класса по умолчанию.
 * Добавьте Set- и Get- методы для полей экземпляра класса.
 */

public class Test2 implements Serializable {

	private static final long serialVersionUID = 2065595380667399232L;

	private int variableOne;
	private int variableTwo;

	public Test2() {
		Random rng = new Random();

		setVariableOne(rng.nextInt(31));
		setVariableTwo(rng.nextInt(31));
	}

	public Test2(int Value1, int Value2) {
		setVariableOne(Value1);
		setVariableTwo(Value2);
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
		Test2 other = (Test2) obj;
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
		return "Test2 [variableOne=" + variableOne + ", variableTwo=" + variableTwo + "]";
	}
}
