package ar.edu.unlam.tallerweb1.modelo;

public class Producto {

	public int codigo;
	public String nombre;
	public String farmacia;
	public String laboratorio;
	public String accion;
	public float precio;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFarmacia() {
		return farmacia;
	}
	public void setFarmacia(String farmacia) {
		this.farmacia = farmacia;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
