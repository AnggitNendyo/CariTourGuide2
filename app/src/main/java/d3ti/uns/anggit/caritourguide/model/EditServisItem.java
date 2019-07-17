package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class EditServisItem {

	@SerializedName("id_kab")
	private String idKab;

	@SerializedName("bahasa_tourguide")
	private String bahasaTourguide;

	@SerializedName("hari_tourguide")
	private String hariTourguide;

	@SerializedName("servis_tourguide")
	private String servisTourguide;

	@SerializedName("harga_tourguide")
	private String hargaTourguide;

	@SerializedName("topik_tourguide")
	private String topikTourguide;

	@SerializedName("id_tourguide")
	private String idTourguide;

	@SerializedName("deskripsi_tourguide")
	private String deskripsiTourguide;

	public void setIdKab(String idKab){
		this.idKab = idKab;
	}

	public String getIdKab(){
		return idKab;
	}

	public void setBahasaTourguide(String bahasaTourguide){
		this.bahasaTourguide = bahasaTourguide;
	}

	public String getBahasaTourguide(){
		return bahasaTourguide;
	}

	public void setHariTourguide(String hariTourguide){
		this.hariTourguide = hariTourguide;
	}

	public String getHariTourguide(){
		return hariTourguide;
	}

	public void setServisTourguide(String servisTourguide){
		this.servisTourguide = servisTourguide;
	}

	public String getServisTourguide(){
		return servisTourguide;
	}

	public void setHargaTourguide(String hargaTourguide){
		this.hargaTourguide = hargaTourguide;
	}

	public String getHargaTourguide(){
		return hargaTourguide;
	}

	public void setTopikTourguide(String topikTourguide){
		this.topikTourguide = topikTourguide;
	}

	public String getTopikTourguide(){
		return topikTourguide;
	}

	public void setIdTourguide(String idTourguide){
		this.idTourguide = idTourguide;
	}

	public String getIdTourguide(){
		return idTourguide;
	}

	public void setDeskripsiTourguide(String deskripsiTourguide){
		this.deskripsiTourguide = deskripsiTourguide;
	}

	public String getDeskripsiTourguide(){
		return deskripsiTourguide;
	}

	@Override
 	public String toString(){
		return 
			"EditServisItem{" +
			"id_kab = '" + idKab + '\'' + 
			",bahasa_tourguide = '" + bahasaTourguide + '\'' + 
			",hari_tourguide = '" + hariTourguide + '\'' + 
			",servis_tourguide = '" + servisTourguide + '\'' + 
			",harga_tourguide = '" + hargaTourguide + '\'' + 
			",topik_tourguide = '" + topikTourguide + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			",deskripsi_tourguide = '" + deskripsiTourguide + '\'' + 
			"}";
		}
}