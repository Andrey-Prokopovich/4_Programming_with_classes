package by.javatraining.basic_class.task3.main;

import by.javatraining.basic_class.task3.entity.Student;

/*
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы,
 * номер группы, успеваемость (массив из пяти элементов).
 * Создайте массив из десяти элементов такого типа. Добавьте возможность
 * вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Main {

	public static void main(String[] args) {
		final String[] fullNames;
		final String[] groupNums;

		Student[] studentsArray;

		fullNames = new String[] { "Иванов А.А", "Крюкова А.П", "Дудник А.Р", "Медведьев А.В", "Тринкер Б.Д",
				"Васильев М.П", "Данилов П.М", "Колобов Э.И", "Титов Л.Ю", "Герасимов М.Д" };
		groupNums = new String[] { "9009001", "900902", "900903" };
		studentsArray = new Student[10];

		for (int i = 0; i < 10; i++) {
			studentsArray[i] = new Student(fullNames[i], groupNums[i / 4]);
		}

		studentsArray[0].setMarks(new int[] { 10, 9, 10, 9, 10 });
		studentsArray[1].setMarks(new int[] { 5, 7, 8, 9, 4 });
		studentsArray[2].setMarks(new int[] { 10, 10, 10, 9, 8 });
		studentsArray[3].setMarks(new int[] { 8, 9, 8, 9, 8 });
		studentsArray[4].setMarks(new int[] { 10, 10, 10, 10, 10 });
		studentsArray[5].setMarks(new int[] { 8, 8, 7, 7, 8 });
		studentsArray[6].setMarks(new int[] { 10, 9, 5, 9, 10 });
		studentsArray[7].setMarks(new int[] { 4, 4, 4, 4, 4 });
		studentsArray[8].setMarks(new int[] { 9, 4, 5, 5, 4 });
		studentsArray[9].setMarks(new int[] { 8, 8, 10, 9, 8 });

		System.out.println("Студенты с успенваемостью выше 8:");
		for (int i = 0; i < 10; i++) {
			if (studentsArray[i].isNineTen()) {
				System.out.println(studentsArray[i].formStudentInfo());
			}
		}
	}
}
