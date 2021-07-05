package by.javatraining.basic_class.task9.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Book: ID, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 *  a) список книг заданного автора;
 *  b) список книг, выпущенных заданным издательством;
 *  c) список книг, выпущенных после заданного года.
 */

public class BookList implements Serializable {

	private static final long serialVersionUID = -4214748768505535698L;

	private List<Book> bookList;

	public BookList() {
		bookList = new LinkedList<>();
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookList == null) ? 0 : bookList.hashCode());
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
		BookList other = (BookList) obj;
		if (bookList == null) {
			if (other.bookList != null) {
				return false;
			}
		} else if (!bookList.equals(other.bookList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BookList [bookList=" + bookList + "]";
	}
}
