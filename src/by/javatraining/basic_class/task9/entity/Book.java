package by.javatraining.basic_class.task9.entity;

import java.io.Serializable;

import by.javatraining.basic_class.task8.exception.InvalidValueException;

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

public class Book implements Serializable {

	private static final long serialVersionUID = -2895131035948966610L;

	private long id;
	private String title;
	private String author;
	private String publisher;
	private int yearPublished;
	private int pageCount;
	private double price;
	private byte bindType;

	public Book() {
	}

	public Book(int id, String title, String author, String publisher, int yearPublished, int pageCount,
			double price, byte bindType) throws InvalidValueException {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setYearPublished(yearPublished);
		setPageCount(pageCount);
		setPrice(price);
		setBindType(bindType);
	}

	public void setId(long id) throws InvalidValueException {
		if (id < 0) {
			throw new InvalidValueException("ID не может быть отрицательным.");
		}

		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setYearPublished(int yearPublished) throws InvalidValueException {
		if (yearPublished < 0) {
			throw new InvalidValueException("Год издания не может быть отрицательным.");
		}

		this.yearPublished = yearPublished;
	}

	public void setPageCount(int pageCount) throws InvalidValueException {
		if (pageCount < 0) {
			throw new InvalidValueException("Количество не может быть отрицательным.");
		}

		this.pageCount = pageCount;
	}

	public void setPrice(double price) throws InvalidValueException {
		if (price < 0) {
			throw new InvalidValueException("Цена не может быть отрицательной.");
		}

		this.price = price;
	}

	public void setBindType(byte bindType) throws InvalidValueException {
		if ((bindType < 0) || (bindType > 4)) {
			throw new InvalidValueException("Тип переплета может принимать значения от 0 до 4.");
		}

		this.bindType = bindType;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public int getPageCount() {
		return pageCount;
	}

	public double getPrice() {
		return price;
	}

	public byte getBindType() {
		return bindType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + bindType;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + pageCount;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + yearPublished;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bindType != other.bindType)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (yearPublished != other.yearPublished)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", yearPublished=" + yearPublished + ", pageCount=" + pageCount + ", price=" + price + ", bindType="
				+ bindType + "]";
	}
}
