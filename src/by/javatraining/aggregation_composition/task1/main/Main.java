package by.javatraining.aggregation_composition.task1.main;

import by.javatraining.aggregation_composition.task1.logic.TextLogic;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class Main {

	public static void main(String[] args) {
		final String testHeader = "Регулярные выражения. Определение.";
		final String testText = "Регулярные выражения — тема, которую программисты, даже опытные, зачастую откладывают на потом. "
				+ "Однако большинству Java-разработчиков рано или поздно придётся столкнуться с обработкой текстовой информации. "
				+ "Чаще всего — с операциями поиска в тексте и редактированием. "
				+ "Без регулярных выражений продуктивный и компактный программный код, связанный с обработкой текстов, попросту немыслим.";

		TextLogic cTask1 = new TextLogic();

		cTask1.setHeader(testHeader);
		cTask1.addToText(testText, -1);

		System.out.println(cTask1.printHeader());
		System.out.println(cTask1.printText());
	}
}
