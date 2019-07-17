package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class TopikItem{

	@SerializedName("nama_topik")
	private String namaTopik;

	@SerializedName("id_ambil_topik")
	private String idAmbilTopik;

	@SerializedName("id_tourguide")
	private String idTourguide;

	public void setNamaTopik(String namaTopik){
		this.namaTopik = namaTopik;
	}

	public String getNamaTopik(){
		return namaTopik;
	}

	public void setIdAmbilTopik(String idAmbilTopik){
		this.idAmbilTopik = idAmbilTopik;
	}

	public String getIdAmbilTopik(){
		return idAmbilTopik;
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
			"TopikItem{" + 
			"nama_topik = '" + namaTopik + '\'' + 
			",id_ambil_topik = '" + idAmbilTopik + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			"}";
		}
}