package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;

public class KotaItem {

	@SerializedName("id_kab")
	private String idKab;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_jenis")
	private String idJenis;

	public void setIdKab(String idKab){
		this.idKab = idKab;
	}

	public String getIdKab(){
		return idKab;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdJenis(String idJenis){
		this.idJenis = idJenis;
	}

	public String getIdJenis(){
		return idJenis;
	}

	@Override
 	public String toString(){
		return 
			"KotaItem{" +
			"id_kab = '" + idKab + '\'' + 
			",nama = '" + nama + '\'' + 
			",id_jenis = '" + idJenis + '\'' + 
			"}";
		}
}