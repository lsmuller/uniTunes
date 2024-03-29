package br.unisinos.unitunes.model;

import java.util.Date;

public class Midia {

	private long id;
	private String name;
	private String description;
	private double price;
	private long author;
	private long category; // 1- Music, 2- Book, 3- Video, 4- Podcast
//	private Image image;
	private int duration;
	private int pages;
	private Date creation;
	private boolean excluded;

	public Midia(long id, String name, String description, double price,
			long author, long category, int duration, int pages,
			Date creation, boolean excluded) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.author = author;
		this.category = category;
		this.duration = duration;
		this.pages = pages;
		this.creation = creation;
		this.excluded = excluded;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
		this.author = author;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isExcluded() {
		return excluded;
	}

	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + ", nome " + name + ", preço " + price + " excluded " + excluded; 
	}
}
