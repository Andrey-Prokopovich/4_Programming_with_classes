package by.javatraining.aggregation_composition.task1.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать объект класса Текст, использую классы Предложение, Слово. Методы: дополнить текст,
 * вывести на консоль текст, заголовок текста.
 */

public class Text implements Serializable {

	private static final long serialVersionUID = 3370633111487374717L;

	private List<Sentence> header;
	private List<Sentence> text;

	public Text() {
		header = new LinkedList<Sentence>();
		text = new LinkedList<Sentence>();
	}

	public List<Sentence> getHeader() {
		return header;
	}

	public List<Sentence> getText() {
		return text;
	}

	public void setHeader(List<Sentence> header) {
		this.header = header;
	}

	public void setText(List<Sentence> text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Text other = (Text) obj;
		if (header == null) {
			if (other.header != null) {
				return false;
			}
		} else if (!header.equals(other.header)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Text [header=" + header + ", text=" + text + "]";
	}
}
