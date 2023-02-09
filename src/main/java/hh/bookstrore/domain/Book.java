package hh.bookstrore.domain;

public class Book {

	private String title;
	private String author;
	private Integer release_year;
	private String isbn;
	private Double price;
	
	public Book(String title, String author, Integer release_year, String isbn, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.release_year = release_year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.release_year = null;
		this.isbn = null;
		this.price = null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", release_year=" + release_year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}
	
	
}
