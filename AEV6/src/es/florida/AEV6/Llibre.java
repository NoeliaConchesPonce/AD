package es.florida.AEV6;

public class Llibre {
	private int id;
	private String titol;
	private String autor;
	private int any_naixement;
	private int any_publicacio;
	private String editorial;
	private int nombre_pagines;
	
	/*
	 * Metode: toString
	 * Descripcie: : mostra els datos de l'objecte llibre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	
	@Override
	public String toString() {
		return "Llibre [id=" + id + ", titol=" + titol + ", autor=" + autor + ", any_naixement=" + any_naixement
				+ ", any_publicacio=" + any_publicacio + ", editorial=" + editorial + ", nombre_pagines="
				+ nombre_pagines + "]";
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public int getId() {
		return id;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public String getTitol() {
		return titol;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setTitol(String titol) {
		this.titol = titol;
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public String getAutor() {
		return autor;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public int getAny_naixement() {
		return any_naixement;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setAny_naixement(int any_naixement) {
		this.any_naixement = any_naixement;
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public int getAny_publicacio() {
		return any_publicacio;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setAny_publicacio(int any_publicacio) {
		this.any_publicacio = any_publicacio;
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public String getEditorial() {
		return editorial;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	/*
	 * Metode: getters
	 * Descripcie: : extrau el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public int getNombre_pagines() {
		return nombre_pagines;
	}
	/*
	 * Metode: setters
	 * Descripcie: : modifica el parametre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public void setNombre_pagines(int nombre_pagines) {
		this.nombre_pagines = nombre_pagines;
	}
	/*
	 * Metode: Llibre
	 * Descripcie: : constructor de la classe llibre
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public Llibre(int id, String titol, String autor, int any_naixement, int any_publicacio, String editorial,
			int nombre_pagines) {
		super();
		this.id = id;
		this.titol = titol;
		this.autor = autor;
		this.any_naixement = any_naixement;
		this.any_publicacio = any_publicacio;
		this.editorial = editorial;
		this.nombre_pagines = nombre_pagines;
	}
	/*
	 * Metode: Llibre
	 * Descripcie: constructor buit
	 * Parametre d'entrada: no
	 * Parametre d'eixida: no
	 * 
	 * */
	public Llibre() {
		super();
		// TODO Auto-generated constructor stub
	}
}

	
	