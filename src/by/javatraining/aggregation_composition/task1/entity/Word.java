package by.javatraining.aggregation_composition.task1.entity;

import java.io.Serializable;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class Word implements Serializable {

	private static final long serialVersionUID = -7166762965808513913L;

	private String word;
	private boolean isPunctuation;

	public Word() {
	}

	public Word(String newWord, boolean punctuation) {
		word = newWord;
		isPunctuation = punctuation;
	}

	public String getWord() {
		return word;
	}

	public boolean isPunctuation() {
		return isPunctuation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isPunctuation ? 1231 : 1237);
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		Word other = (Word) obj;
		if (isPunctuation != other.isPunctuation) {
			return false;
		}
		if (word == null) {
			if (other.word != null) {
				return false;
			}
		} else if (!word.equals(other.word)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", isPunctuation=" + isPunctuation + "]";
	}
}
