package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class EditProfilTourguideItem {

	@SerializedName("notelp_tourguide")
	private String notelpTourguide;

	@SerializedName("umur_tourguide")
	private String umurTourguide;

	@SerializedName("ktp_tourguide")
	private String ktpTourguide;

	@SerializedName("nama_tourguide")
	private String namaTourguide;

	@SerializedName("alamat_tourguide")
	private String alamatTourguide;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	public void setNotelpTourguide(String notelpTourguide){
		this.notelpTourguide = notelpTourguide;
	}

	public String getNotelpTourguide(){
		return notelpTourguide;
	}

	public void setUmurTourguide(String umurTourguide){
		this.umurTourguide = umurTourguide;
	}

	public String getUmurTourguide(){
		return umurTourguide;
	}

	public void setKtpTourguide(String ktpTourguide){
		this.ktpTourguide = ktpTourguide;
	}

	public String getKtpTourguide(){
		return ktpTourguide;
	}

	public void setNamaTourguide(String namaTourguide){
		this.namaTourguide = namaTourguide;
	}

	public String getNamaTourguide(){
		return namaTourguide;
	}

	public void setAlamatTourguide(String alamatTourguide){
		this.alamatTourguide = alamatTourguide;
	}

	public String getAlamatTourguide(){
		return alamatTourguide;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	@Override
 	public String toString(){
		return 
			"EditProfilTourguideItem{" +
			"notelp_tourguide = '" + notelpTourguide + '\'' + 
			",umur_tourguide = '" + umurTourguide + '\'' + 
			",ktp_tourguide = '" + ktpTourguide + '\'' + 
			",nama_tourguide = '" + namaTourguide + '\'' + 
			",alamat_tourguide = '" + alamatTourguide + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			"}";
		}
}