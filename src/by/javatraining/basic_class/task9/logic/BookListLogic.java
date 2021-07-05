package by.javatraining.basic_class.task9.logic;

import java.util.List;

import by.javatraining.basic_class.task8.exception.InvalidValueException;
import by.javatraining.basic_class.task9.entity.Book;
import by.javatraining.basic_class.task9.entity.BookList;
import by.javatraining.basic_class.task9.view.BookInfo;

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

public class BookListLogic {

	public final byte SORT_ID = 0;
	public final byte SORT_TITLE = 1;
	public final byte SORT_AUTHOR = 2;
	public final byte SORT_PRICE = 3;

	private final BookList bookList;
	private final BookIdComparator idComparator;
	private final BookTitleComparator titleComparator;
	private final BookAuthorComparator authorComparator;
	private final BookPriceComparator priceComparator;

	private byte sortMode;

	public BookListLogic() {
		sortMode = SORT_ID;

		bookList = new BookList();
		idComparator = new BookIdComparator();
		titleComparator = new BookTitleComparator();
		authorComparator = new BookAuthorComparator();
		priceComparator = new BookPriceComparator();
	}

	public void addBook(Book book) {
		List<Book> list = bookList.getBookList();

		int compareString;
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			switch (sortMode) {
			case SORT_ID:
				if (list.get(i).getId() > book.getId()) {
					list.add(i, book);

					return;
				}
				break;
			case SORT_TITLE:
				compareString = list.get(i).getTitle().compareToIgnoreCase(book.getTitle());

				if (compareString > 0) {
					list.add(i, book);

					return;
				}
				break;
			case SORT_AUTHOR:
				compareString = list.get(i).getAuthor().compareToIgnoreCase(book.getAuthor());

				if (compareString > 0) {
					list.add(i, book);

					return;
				}
				break;
			case SORT_PRICE:
				if (list.get(i).getPrice() > book.getPrice()) {
					list.add(i, book);

					return;
				}
				break;
			}
		}

		list.add(book);
	}

	public void setSortMode(byte bMode) throws InvalidValueException {
		if (sortMode == bMode) {
			return;
		}

		switch (bMode) {
		case SORT_ID: {
			sortId();
			break;
		}
		case SORT_TITLE: {
			sortTitle();
			break;
		}
		case SORT_AUTHOR: {
			sortAuthor();
			break;
		}
		case SORT_PRICE: {
			sortPrice();
			break;
		}
		default: {
			throw new InvalidValueException("Неизвестное значение режима сортировки.");
		}
		}

		sortMode = bMode;
	}

	public void sortId() {
		bookList.getBookList().sort(idComparator);
	}

	public void sortTitle() {
		bookList.getBookList().sort(titleComparator);
	}

	public void sortAuthor() {
		bookList.getBookList().sort(authorComparator);
	}

	public void sortPrice() {
		bookList.getBookList().sort(priceComparator);
	}

	public String printBooksBySort() {
		List<Book> list = bookList.getBookList();
		StringBuilder strBookList = new StringBuilder();

		strBookList.append("Список книг (все):\n");
		for (int i = 0; i < list.size(); i++) {
			strBookList.append(BookInfo.formBookInfo(list.get(i)) + "\n");
		}

		return strBookList.toString();
	}

	public String printBooksByAuthor(String author) {
		List<Book> list = bookList.getBookList();
		StringBuilder strBookList = new StringBuilder();

		strBookList.append("Список книг за авторством " + author + ":\n");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAuthor().equalsIgnoreCase(author)) {
				strBookList.append(BookInfo.formBookInfo(list.get(i)) + "\n");
			}
		}

		return strBookList.toString();
	}

	public String printBooksByPublisher(String publisher) {
		List<Book> list = bookList.getBookList();
		StringBuilder strBookList = new StringBuilder();

		strBookList.append("Список книг изданных " + publisher + ":\n");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPublisher().equalsIgnoreCase(publisher)) {
				strBookList.append(BookInfo.formBookInfo(list.get(i)) + "\n");
			}
		}

		return strBookList.toString();
	}

	public String printBooksByYearPublished(int year) {
		List<Book> list = bookList.getBookList();
		StringBuilder strBookList = new StringBuilder();

		strBookList.append("Список книг изданных после " + String.valueOf(year) + " года:\n");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getYearPublished() > year) {
				strBookList.append(BookInfo.formBookInfo(list.get(i)) + "\n");
			}
		}

		return strBookList.toString();
	}
}
