package by.javatraining.basic_class.task3.entity;

import java.io.Serializable;
import java.util.Arrays;

/*
 * Создайте класс с именем Student, содержащий поля: фамилия и инициалы,
 * номер группы, успеваемость (массив из пяти элементов).
 * Создайте массив из десяти элементов такого типа. Добавьте возможность
 * вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Student implements Serializable {

	private static final long serialVersionUID = -6046148262469837295L;

	private final int marksArraySize = 5;

	private String fullName;
	private String groupNum;
	private int[] marks;

	public Student() {
		marks = new int[marksArraySize];
	}

	public Student(String fullName, String groupNum) {
		this();

		setFullName(fullName);
		setGroupNum(groupNum);
	}

	public Student(String fullName, String groupNum, int[] marks) {
		this(fullName, groupNum);

		setMarks(marks);
	}

	public final void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public final void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

	public final void setMarks(int[] newMarks) {
		if (newMarks.length > marksArraySize) {
			System.out.println("Передано больше 5-ти отметок." + "\nЛишние отметки сохранены не будут.\n");
		}

		for (int i = 0; (i < newMarks.length) && (i < marksArraySize); i++) {
			marks[i] = newMarks[i];
		}
	}

	public final String getFullName() {
		return fullName;
	}

	public final String getGroupNum() {
		return groupNum;
	}

	public final int[] getMarks() {
		return marks.clone();
	}

	public boolean isNineTen() {
		for (int i = 0; i < marksArraySize; i++) {
			if ((marks[i] != 9) && (marks[i] != 10)) {
				return false;
			}
		}

		return true;
	}

	public String formStudentInfo() {
		return "ФИО: " + getFullName() + "\nНомер группы: " + getGroupNum() + "\nУспеваемость: "
				+ Arrays.toString(getMarks());
	}
}
