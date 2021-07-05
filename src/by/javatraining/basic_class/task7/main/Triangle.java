package by.javatraining.basic_class.task7.main;

import java.io.Serializable;
import java.util.Arrays;

/*
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
 * вычисления площади, периметра и точки пересечения медиан.
 */

public class Triangle implements Serializable {

	private static final long serialVersionUID = -2887811798226919825L;

	private int[] pointA;
	private int[] pointB;
	private int[] pointC;

	{
		pointA = new int[2];
		pointB = new int[2];
		pointC = new int[2];
	}

	public Triangle() {
		this(0, 5, 4, 12, 9, 11);
	}

	public Triangle(int x0, int y0, int x1, int y1, int x2, int y2) {
		setPointA(0, x0);
		setPointA(1, y0);

		setPointB(0, x1);
		setPointB(1, y1);

		setPointC(0, x2);
		setPointC(1, y2);
	}

	public int getPointA(int index) {
		return pointA[index];
	}

	public int getPointB(int index) {
		return pointB[index];
	}

	public int getPointC(int index) {
		return pointC[index];
	}

	public void setPointA(int index, int value) {
		pointA[index] = value;
	}

	public void setPointB(int index, int value) {
		pointB[index] = value;
	}

	public void setPointC(int index, int value) {
		pointC[index] = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(pointA);
		result = prime * result + Arrays.hashCode(pointB);
		result = prime * result + Arrays.hashCode(pointC);
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
		Triangle other = (Triangle) obj;
		if (!Arrays.equals(pointA, other.pointA)) {
			return false;
		}
		if (!Arrays.equals(pointB, other.pointB)) {
			return false;
		}
		if (!Arrays.equals(pointC, other.pointC)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Triangle [pointA=" + Arrays.toString(pointA) + ", pointB=" + Arrays.toString(pointB) + ", pointC="
				+ Arrays.toString(pointC) + "]";
	}
}
