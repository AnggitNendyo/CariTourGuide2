package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class TourguideItem{

	@SerializedName("umur_tourguide")
	private String umurTourguide;

	@SerializedName("id_kab")
	private String idKab;

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga_tourguide")
	private String hargaTourguide;

	@SerializedName("foto_tourguide")
	private String fotoTourguide;

	@SerializedName("nama_tourguide")
	private String namaTourguide;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("deskripsi_tourguide")
	private String deskripsiTourguide;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setUmurTourguide(String umurTourguide){
		this.umurTourguide = umurTourguide;
	}

	public String getUmurTourguide(){
		return umurTourguide;
	}

	public void setIdKab(String idKab){
		this.idKab = idKab;
	}

	public String getIdKab(){
		return idKab;
	}

	public void setHargaTourguide(String hargaTourguide){
		this.hargaTourguide = hargaTourguide;
	}

	public String getHargaTourguide(){
		return hargaTourguide;
	}

	public void setFotoTourguide(String fotoTourguide){
		this.fotoTourguide = fotoTourguide;
	}

	public String getFotoTourguide(){
		return fotoTourguide;
	}

	public void setNamaTourguide(String namaTourguide){
		this.namaTourguide = namaTourguide;
	}

	public String getNamaTourguide(){
		return namaTourguide;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
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
			"TourguideItem{" + 
			"umur_tourguide = '" + umurTourguide + '\'' + 
			",id_kab = '" + idKab + '\'' + 
			",harga_tourguide = '" + hargaTourguide + '\'' + 
			",foto_tourguide = '" + fotoTourguide + '\'' + 
			",nama_tourguide = '" + namaTourguide + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",deskripsi_tourguide = '" + deskripsiTourguide + '\'' + 
			"}";
		}
}