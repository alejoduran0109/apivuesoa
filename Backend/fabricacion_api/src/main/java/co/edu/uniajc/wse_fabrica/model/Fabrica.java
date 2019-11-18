package co.edu.uniajc.wse_fabrica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fabrica_producto")
public class Fabrica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fabrica")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cantidad")
	private int cantidad;

	public Fabrica() {
		super();
	}

	public Fabrica(int id, String nombre, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	

}
