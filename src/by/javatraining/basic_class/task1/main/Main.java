package by.javatraining.basic_class.task1.main;

/*
 * Создайте класс Test1 с двумя переменными.
 * Добавьте метод вывода на экран и методы изменения этих переменных.
 * Добавьте метод, который находит сумму значений этих переменных, и метод,
 * который находит наибольшее значение из этих двух переменных.
 */

public class Main {

	public static void main(String[] args) {
		Test1 cTask1 = new Test1();

		System.out.println("Задайте две целочисленные переменные.");

		cTask1.setVariableOne(UserInput.inputInt(1 + "-е число:"));
		cTask1.setVariableTwo(UserInput.inputInt(2 + "-е число:"));

		System.out.println(cTask1.toString());
		System.out.println("Самма: " + cTask1.sumVariables());
		System.out.println("Наибольшее значение: " + cTask1.findGreaterVariable());
	}
}
