package br.unisinos.unitunes.model;

import java.util.Date;

public class Purchase {

	private long id;
	private long idAcademic;
	private long idMidia;
	private Date datePurchase;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdAcademic() {
		return idAcademic;
	}
	public void setIdAcademic(long idAcademic) {
		this.idAcademic = idAcademic;
	}
	public long getIdMidia() {
		return idMidia;
	}
	public void setIdMidia(long idMidia) {
		this.idMidia = idMidia;
	}
	public Date getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + ", Academico: " + idAcademic + ", Midia " + idMidia + ", data " + datePurchase;
	}
}
