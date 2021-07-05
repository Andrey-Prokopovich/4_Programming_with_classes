package by.javatraining.aggregation_composition.task1.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class Sentence implements Serializable {

	private static final long serialVersionUID = -7588642160127128623L;

	private List<Word> wordList;

	public Sentence() {
		wordList = new LinkedList<Word>();
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wordList == null) ? 0 : wordList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Sentence other = (Sentence) obj;
		if (wordList == null) {
			if (other.wordList != null) {
				return false;
			}
		} else if (!wordList.equals(other.wordList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Sentence [wordList=" + wordList + "]";
	}
}
