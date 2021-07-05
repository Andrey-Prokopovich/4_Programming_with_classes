package by.javatraining.basic_class.task7.main;

/*
 * Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
 * вычисления площади, периметра и точки пересечения медиан.
 */

public class Logic {

	private double[] sides;
	private boolean isSidesSet;

	public Logic() {
		sides = new double[3];
		isSidesSet = false;
	}
	
	public Logic(Triangle triangle) {
		this();
		
		isSidesSet = false;
		calcAllSidesLength(triangle);
	}

	public boolean isSidesSet() {
		return isSidesSet;
	}

	private double calcSideLength(int sumX1X2, int sumY1Y2) {
		return Math.pow(sumY1Y2, 2) + Math.pow(sumX1X2, 2);
	}

	private void calcAllSidesLength(Triangle triangle) {
		sides[0] = calcSideLength(triangle.getPointB(0) + triangle.getPointA(0), triangle.getPointB(1) + triangle.getPointA(1));
		sides[1] = calcSideLength(triangle.getPointC(0) + triangle.getPointB(0), triangle.getPointC(1) + triangle.getPointB(1));
		sides[2] = calcSideLength(triangle.getPointC(0) + triangle.getPointA(0), triangle.getPointC(1) + triangle.getPointA(1));

		isSidesSet = true;
	}

	public int findDifferentSide() {
		if (sides[0] == sides[1]) {
			return 2;
		}
		if (sides[1] == sides[2]) {
			return 0;
		}
		if (sides[0] == sides[2]) {
			return 1;
		}

		return 13;
	}

	public boolean isAllSidesEqual() {
		return (sides[0] == sides[1]) && (sides[1] == sides[2]);
	}

	public double calcPerimeter() {
		return sides[0] + sides[1] + sides[2];
	}

	public double calcAreaByHeronMathod() {
		double p = 0.5 * (sides[0] + sides[1] + sides[2]);

		return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
	}

	private double calcHeight2SidesEqual(int iEqSide, int iDifSide) {
		return Math.sqrt(Math.pow(sides[iEqSide], 2) - (Math.pow(sides[iDifSide], 2) / 4));
	}

	public double calcArea2SidesEqual(boolean useHeight) {
		int iDifSide = findDifferentSide();
		int iEqSide = iDifSide + (iDifSide > 0 ? (-1) : 1);

		if (iDifSide == 13) {
			System.out.println("No equal sides!");
		}

		if (!useHeight) {
			return (Math.sqrt(3) / 4) * Math.pow(sides[iEqSide], 2);
		} else {
			return 0.5 * sides[0] * calcHeight2SidesEqual(iEqSide, iDifSide);
		}
	}

	private double calcHeightAllSidesEqual() {
		return Math.sqrt(3) / 2 * sides[0];
	}

	public double calcAreaAllSidesEqual(boolean useHeight) {
		if (!isAllSidesEqual()) {
			System.out.println("Not all sides are equal!");
		}

		if (!useHeight) {
			return (Math.sqrt(3) / 4) * Math.pow(sides[0], 2);
		} else {
			return 0.5 * sides[0] * calcHeightAllSidesEqual();
		}
	}
}
