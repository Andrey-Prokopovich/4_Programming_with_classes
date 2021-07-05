package by.javatraining.aggregation_composition.task1.logic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.javatraining.aggregation_composition.task1.entity.Sentence;
import by.javatraining.aggregation_composition.task1.entity.Text;
import by.javatraining.aggregation_composition.task1.view.TextPrint;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class TextLogic {

	public static final String SENTENCE_END_HEADER_PATTERN = "[.!?]\\s[A-ZА-Я]";
	public static final String SENTENCE_END_TEXT_PATTERN = "[.!?](\\s[A-ZА-Я]|\\z)";

	private final Text text;
	private final SentenceLogic sentenceLogic;

	public TextLogic() {
		text = new Text();
		sentenceLogic = new SentenceLogic();
	}

	public void setHeader(String newHeader) {
		List<Sentence> header;
		Pattern sentenceEnd;
		Matcher matcher;
		
		header = text.getHeader();
		sentenceEnd = Pattern.compile(SENTENCE_END_HEADER_PATTERN);
		matcher = sentenceEnd.matcher(newHeader);
		
		if (!header.isEmpty()) {
			header.clear();
		}

		int sentStart = 0;
		int sentEnd = 0;
		while (matcher.find()) {
			sentEnd = matcher.start() + 1;

			sentenceLogic.setSentence(null);
			sentenceLogic.makeSentance(newHeader.substring(sentStart, sentEnd).trim());
			header.add(sentenceLogic.getSentence());

			sentStart = matcher.end() - 1;
		}

		sentenceLogic.setSentence(null);
		sentenceLogic.makeSentance(newHeader.substring(sentStart).trim());
		header.add(sentenceLogic.getSentence());
	}

	public void addToText(String addition, int position) {
		int addPosition;
		List<Sentence> sentenceList;
		Pattern SentenceEnd;
		Matcher matcher;
		
		addPosition = position;
		sentenceList = text.getText();
		SentenceEnd = Pattern.compile(SENTENCE_END_TEXT_PATTERN);
		matcher = SentenceEnd.matcher(addition);

		int sentStart = 0;
		int sentEnd = 0;
		while (matcher.find()) {
			sentEnd = matcher.start() + 1;

			sentenceLogic.setSentence(null);
			sentenceLogic.makeSentance(addition.substring(sentStart, sentEnd).trim());
			
			if (addPosition < 0) {
				sentenceList.add(sentenceLogic.getSentence());
			} else {
				sentenceList.add(addPosition, sentenceLogic.getSentence());
				addPosition++;
			}

			sentStart = matcher.end() - 1;
		}
	}
	
	public String printHeader() {
		return TextPrint.getHeaderString(text.getHeader());
	}
	
	public String printText() {
		return TextPrint.getHeaderString(text.getText());
	}
}
