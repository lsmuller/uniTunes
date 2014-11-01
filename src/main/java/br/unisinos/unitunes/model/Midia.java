package br.unisinos.unitunes.model;

import java.awt.Image;
import java.util.Date;

public class Midia {

	private long id;
	
	private double cost;
	
	private int type; // 1- Music, 2- Book, 3-Video, 4- Podcast
	
	private String name;
	
	private String description;
	
	private Image image;
	
	private Date creation;
	
	private String cateogry;
	
	private int duration;
	
	private int pagesCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getCateogry() {
		return cateogry;
	}

	public void setCateogry(String cateogry) {
		this.cateogry = cateogry;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}
	
//	Mídia pode ser free ou paga ( valor > R$ 0,01).
//	Tipos: musica, livro, vídeo ou podcast.
//	Informações: nome, descrição, imagem, preço, nome do(s) autor(es), conteúdo (sendo a própria mídia), data de criação e categoria, 
//	duração em minutos (musica, video e podcast), paginas (livro). 	
}
