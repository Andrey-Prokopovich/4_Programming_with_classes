package by.javatraining.basic_class.task2.main;

import by.javatraining.basic_class.task2.entity.Test2;

/*
 * Создайте класс Test2 с двумя переменными. Добавьте конструктор с входными параметрами.
 * Добавьте конструктор, инициализирующий члены класса по умолчанию.
 * Добавьте Set- и Get- методы для полей экземпляра класса.
 */

public class Main {

	public static void main(String[] args) {
		Test2 cTask2 = new Test2(25, 19);

		System.out.println(cTask2.toString());
	}
}
