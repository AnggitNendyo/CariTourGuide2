package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;


public class ProfilTourguideItems {

	@SerializedName("umur_tourguide")
	private String umurTourguide;

	@SerializedName("status_tourguide")
	private String statusTourguide;

	@SerializedName("email_tourguide")
	private String emailTourguide;

	@SerializedName("harga_tourguide")
	private String hargaTourguide;

	@SerializedName("foto_tourguide")
	private String fotoTourguide;

	@SerializedName("nama_tourguide")
	private String namaTourguide;

	@SerializedName("password_tourguide")
	private String passwordTourguide;

	@SerializedName("alamat_tourguide")
	private String alamatTourguide;

	@SerializedName("notelp_tourguide")
	private String notelpTourguide;

	@SerializedName("id_kab")
	private String idKab;

	@SerializedName("ktp_tourguide")
	private String ktpTourguide;

	@SerializedName("sertifikat_tourguide")
	private String sertifikatTourguide;

	@SerializedName("id_tourguide")
	private String idTourguide;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("deskripsi_tourguide")
	private String deskripsiTourguide;

	public void setUmurTourguide(String umurTourguide){
		this.umurTourguide = umurTourguide;
	}

	public String getUmurTourguide(){
		return umurTourguide;
	}

	public void setStatusTourguide(String statusTourguide){
		this.statusTourguide = statusTourguide;
	}

	public String getStatusTourguide(){
		return statusTourguide;
	}

	public void setEmailTourguide(String emailTourguide){
		this.emailTourguide = emailTourguide;
	}

	public String getEmailTourguide(){
		return emailTourguide;
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

	public void setPasswordTourguide(String passwordTourguide){
		this.passwordTourguide = passwordTourguide;
	}

	public String getPasswordTourguide(){
		return passwordTourguide;
	}

	public void setAlamatTourguide(String alamatTourguide){
		this.alamatTourguide = alamatTourguide;
	}

	public String getAlamatTourguide(){
		return alamatTourguide;
	}

	public void setNotelpTourguide(String notelpTourguide){
		this.notelpTourguide = notelpTourguide;
	}

	public String getNotelpTourguide(){
		return notelpTourguide;
	}

	public void setIdKab(String idKab){
		this.idKab = idKab;
	}

	public String getIdKab(){
		return idKab;
	}

	public void setKtpTourguide(String ktpTourguide){
		this.ktpTourguide = ktpTourguide;
	}

	public String getKtpTourguide(){
		return ktpTourguide;
	}

	public void setSertifikatTourguide(String sertifikatTourguide){
		this.sertifikatTourguide = sertifikatTourguide;
	}

	public String getSertifikatTourguide(){
		return sertifikatTourguide;
	}

	public void setIdTourguide(String idTourguide){
		this.idTourguide = idTourguide;
	}

	public String getIdTourguide(){
		return idTourguide;
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
			"ProfilTourguideItems{" +
			"umur_tourguide = '" + umurTourguide + '\'' + 
			",status_tourguide = '" + statusTourguide + '\'' + 
			",email_tourguide = '" + emailTourguide + '\'' + 
			",harga_tourguide = '" + hargaTourguide + '\'' + 
			",foto_tourguide = '" + fotoTourguide + '\'' + 
			",nama_tourguide = '" + namaTourguide + '\'' + 
			",password_tourguide = '" + passwordTourguide + '\'' + 
			",alamat_tourguide = '" + alamatTourguide + '\'' + 
			",notelp_tourguide = '" + notelpTourguide + '\'' + 
			",id_kab = '" + idKab + '\'' + 
			",ktp_tourguide = '" + ktpTourguide + '\'' + 
			",sertifikat_tourguide = '" + sertifikatTourguide + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",deskripsi_tourguide = '" + deskripsiTourguide + '\'' + 
			"}";
		}
}