package by.javatraining.basic_class.task9.view;

import by.javatraining.basic_class.task9.entity.Book;

public class BookInfo {

	public static String getBindTypeString(Book book) {
		switch (book.getBindType()) {
		case 0:
			return "мягкий";
		case 1:
			return "жёсткий";
		case 2:
			return "обрезной";
		case 3:
			return "с кантом";
		case 4:
			return "интегральный";
		default:
			return "неизвестный тип.";
		}
	}

	public static String formBookInfo(Book book) {
		return String.valueOf(book.getId()) + " \"" + book.getTitle() + "\" за авторством " + book.getAuthor()
				+ " издана " + book.getPublisher() + " в " + String.valueOf(book.getYearPublished()) + "г. "
				+ "Количество страниц: " + String.valueOf(book.getPageCount()) + ", переплет: "
				+ getBindTypeString(book) + ", цена: " + String.valueOf(book.getPrice()) + ".";
	}
}
