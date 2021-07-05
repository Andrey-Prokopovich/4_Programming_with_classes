package by.javatraining.aggregation_composition.task1.logic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.javatraining.aggregation_composition.task1.entity.Sentence;
import by.javatraining.aggregation_composition.task1.entity.Word;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class SentenceLogic {

	public static final String WORDS_DIVISION_PATTERN = "[a-zа-яё0-9][^a-zа-яё0-9\\-]+([a-zа-яё0-9]|\\z)";

	private Sentence sentence;

	public SentenceLogic() {
	}

	public void setSentence(Sentence sentence) {
		if (sentence == null) {
			this.sentence = new Sentence();
		} else {
			this.sentence = sentence;
		}
	}

	public Sentence getSentence() {
		return sentence;
	}

	public void makeSentance(String source) {
		List<Word> wordList;
		Pattern wordDivision;
		Matcher wordMatcher;

		wordList = sentence.getWordList();
		wordDivision = Pattern.compile(WORDS_DIVISION_PATTERN, Pattern.CASE_INSENSITIVE);
		wordMatcher = wordDivision.matcher(source);

		int wordStart = 0;
		int wordEnd = 0;
		while (wordMatcher.find()) {
			wordEnd = wordMatcher.start() + 1;

			Word newWord = new Word(source.substring(wordStart, wordEnd).trim(), false);
			wordList.add(newWord);

			wordStart = wordMatcher.end() - (wordMatcher.end() == source.length() ? 0 : 1);

			String punctSub = source.substring(wordEnd, wordStart).trim();
			if ((punctSub.contains("—")) | (punctSub.contains("-"))) {
				newWord = new Word(punctSub, false);
			} else {
				newWord = new Word(punctSub, true);
			}
			wordList.add(newWord);
		}
	}
}
