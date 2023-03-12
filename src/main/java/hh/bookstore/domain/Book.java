package hh.bookstore.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int release_year;
	private String isbn;
	private Double price;
	@ManyToOne
    @JoinColumn ( name = "categoryid")
    private Category category;
	// @JsonIgnoreProperties - one way to avoid infinite loop during JSON serialization/deserialization with bidirectional relationships
    @JsonIgnoreProperties ("jsonbooks") 
	
	
	public Book(String title, String author, int release_year, String isbn, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.release_year = release_year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.release_year = 0;
		this.isbn = null;
		this.price = null;
		this.category = null;
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", release year=" + release_year + ", isbn" + isbn + ", price " + price + " department =" + this.getCategory() + "]";
        else
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", release year=" + release_year + ", isbn" + isbn + ", price " + price + "]";
	}
	
}
