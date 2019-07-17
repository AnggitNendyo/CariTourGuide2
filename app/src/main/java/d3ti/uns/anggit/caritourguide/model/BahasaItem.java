package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class BahasaItem{

	@SerializedName("id_ambil_bahasa")
	private String idAmbilBahasa;

	@SerializedName("id_tourguide")
	private String idTourguide;

	@SerializedName("nama_bahasa")
	private String namaBahasa;

	public void setIdAmbilBahasa(String idAmbilBahasa){
		this.idAmbilBahasa = idAmbilBahasa;
	}

	public String getIdAmbilBahasa(){
		return idAmbilBahasa;
	}

	public void setIdTourguide(String idTourguide){
		this.idTourguide = idTourguide;
	}

	public String getIdTourguide(){
		return idTourguide;
	}

	public void setNamaBahasa(String namaBahasa){
		this.namaBahasa = namaBahasa;
	}

	public String getNamaBahasa(){
		return namaBahasa;
	}

	@Override
 	public String toString(){
		return 
			"BahasaItem{" + 
			"id_ambil_bahasa = '" + idAmbilBahasa + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			",nama_bahasa = '" + namaBahasa + '\'' + 
			"}";
		}
}