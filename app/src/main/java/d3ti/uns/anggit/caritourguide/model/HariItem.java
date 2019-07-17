package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class HariItem{

	@SerializedName("id_ambil_hari")
	private String idAmbilHari;

	@SerializedName("nama_hari")
	private String namaHari;

	@SerializedName("id_tourguide")
	private String idTourguide;

	public void setIdAmbilHari(String idAmbilHari){
		this.idAmbilHari = idAmbilHari;
	}

	public String getIdAmbilHari(){
		return idAmbilHari;
	}

	public void setNamaHari(String namaHari){
		this.namaHari = namaHari;
	}

	public String getNamaHari(){
		return namaHari;
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
			"HariItem{" + 
			"id_ambil_hari = '" + idAmbilHari + '\'' + 
			",nama_hari = '" + namaHari + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			"}";
		}
}