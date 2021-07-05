package by.javatraining.aggregation_composition.task1.view;

import java.util.List;

import by.javatraining.aggregation_composition.task1.entity.Sentence;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class TextPrint {

	public static String getHeaderString(List<Sentence> header) {
		StringBuilder headerBuilder = new StringBuilder();

		for (int i = 0; i < header.size(); i++) {
			headerBuilder.append((i > 0 ? " " : "") + SentencePrint.getWordListString(header.get(i).getWordList()));
		}

		return headerBuilder.toString();
	}

	public static String getTextString(List<Sentence> text) {
		StringBuilder textBuilder = new StringBuilder();

		for (int i = 0; i < text.size(); i++) {
			textBuilder.append((i > 0 ? " " : "") + SentencePrint.getWordListString(text.get(i).getWordList()));
		}

		return textBuilder.toString();
	}
}
