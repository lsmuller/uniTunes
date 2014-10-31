package br.unisinos.unitunes.model;

import java.awt.Image;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Midia {

	@Getter
	@Setter
	private long id;
	
	@Getter
	@Setter
	private double cost;
	
	@Getter
	@Setter
	private int type; // 1- Music, 2- Book, 3-Video, 4- Podcast
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private Image image;
	
	@Getter
	@Setter
	private Date creation;
	
	
	@Getter
	@Setter
	private String cateogry;
	
	@Getter
	@Setter
	private int duration;
	
	@Getter
	@Setter
	private int pagesCount;
	
//	Mídia pode ser free ou paga ( valor > R$ 0,01).
//	Tipos: musica, livro, vídeo ou podcast.
//	Informações: nome, descrição, imagem, preço, nome do(s) autor(es), conteúdo (sendo a própria mídia), data de criação e categoria, 
//	duração em minutos (musica, video e podcast), paginas (livro). 

	
	
}
