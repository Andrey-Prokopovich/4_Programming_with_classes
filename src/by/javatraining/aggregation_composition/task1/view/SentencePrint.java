package by.javatraining.aggregation_composition.task1.view;

import java.util.List;

import by.javatraining.aggregation_composition.task1.entity.Word;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class SentencePrint {

	public static String getWordListString(List<Word> wordList) {
		StringBuilder strWordList = new StringBuilder();

		for (int i = 0; i < wordList.size(); i++) {
			strWordList.append(((i > 0) && (!wordList.get(i).isPunctuation()) ? " " : "") + wordList.get(i).getWord());
		}

		return strWordList.toString();
	}
}
