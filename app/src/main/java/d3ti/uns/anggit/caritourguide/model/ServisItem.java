package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class ServisItem{

	@SerializedName("nama_servis")
	private String namaServis;

	@SerializedName("id_ambil_servis")
	private String idAmbilServis;

	@SerializedName("id_tourguide")
	private String idTourguide;

	public void setNamaServis(String namaServis){
		this.namaServis = namaServis;
	}

	public String getNamaServis(){
		return namaServis;
	}

	public void setIdAmbilServis(String idAmbilServis){
		this.idAmbilServis = idAmbilServis;
	}

	public String getIdAmbilServis(){
		return idAmbilServis;
	}

	public void setIdTourguide(String idTourguide){
		this.idTourguide = idTourguide;
	}

	public String getIdTourguide(){
		return idTourguide;
	}

	@Override
 	public String toString(){
		return 
			"ServisItem{" + 
			"nama_servis = '" + namaServis + '\'' + 
			",id_ambil_servis = '" + idAmbilServis + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			"}";
		}
}