package es.florida.aev5;

public class Llibre {
	private int identificador;
	private String titol;
	private String autor;
	private int anyNaixement;
	private int anyPublicacio;
	private String editorial;
	private int nombrePagines;
	
	public Llibre( String titol, String autor,int anyNaixement ,int anyPublicacio, String editorial,
			int nombrePagines) {
		super();
		this.titol = titol;
		this.autor = autor;
		this.anyNaixement = anyNaixement;
		this.anyPublicacio = anyPublicacio;
		this.editorial = editorial;
		this.nombrePagines = nombrePagines;
	}
	
	public Llibre() {
		
	}
	
	
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnyNaixement() {
		return anyNaixement;
	}
	public void setAnyNaixement(int anyNaixement) {
		this.anyNaixement = anyNaixement;
	}
	public int getAnyPublicacio() {
		return anyPublicacio;
	}
	public void setAnyPublicacio(int anyPublicacio) {
		this.anyPublicacio = anyPublicacio;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getNombrePagines() {
		return nombrePagines;
	}
	public void setNombrePagines(int nombrePagines) {
		this.nombrePagines = nombrePagines;
	}
}
