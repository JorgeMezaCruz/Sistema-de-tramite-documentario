package model;

public class Expediente {
	private int cod_exp;
	private String fecha_registro,fecha_emision,nom_organismo,apoderado_organismo,contacto_tlf,contacto_email,descripcion_exp,situacion_exp;
	
	public int getCod_exp() {
		return cod_exp;
	}
	public void setCod_exp(int cod_exp) {
		this.cod_exp = cod_exp;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	public String getNom_organismo() {
		return nom_organismo;
	}
	public void setNom_organismo(String nom_organismo) {
		this.nom_organismo = nom_organismo;
	}
	public String getApoderado_organismo() {
		return apoderado_organismo;
	}
	public void setApoderado_organismo(String apoderado_organismo) {
		this.apoderado_organismo = apoderado_organismo;
	}
	public String getContacto_tlf() {
		return contacto_tlf;
	}
	public void setContacto_tlf(String contacto_tlf) {
		this.contacto_tlf = contacto_tlf;
	}
	public String getContacto_email() {
		return contacto_email;
	}
	public void setContacto_email(String contacto_email) {
		this.contacto_email = contacto_email;
	}
	public String getDescripcion_exp() {
		return descripcion_exp;
	}
	public void setDescripcion_exp(String descripcion_exp) {
		this.descripcion_exp = descripcion_exp;
	}
	public String getSituacion_exp() {
		return situacion_exp;
	}
	public void setSituacion_exp(String situacion_exp) {
		this.situacion_exp = situacion_exp;
	}
	public void setDescripcion_exp(String string, Object setSituacion_exp) {
		// TODO Auto-generated method stub
		
	}

}
