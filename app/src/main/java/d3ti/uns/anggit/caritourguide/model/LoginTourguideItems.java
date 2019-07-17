package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class LoginTourguideItems {

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

	@SerializedName("notelp_tourguide")
	private String notelpTourguide;

	@SerializedName("id_kab")
	private Object idKab;

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

	@SerializedName("status")
	private String status;

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

	public void setNotelpTourguide(String notelpTourguide){
		this.notelpTourguide = notelpTourguide;
	}

	public String getNotelpTourguide(){
		return notelpTourguide;
	}

	public void setIdKab(Object idKab){
		this.idKab = idKab;
	}

	public Object getIdKab(){
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

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"LoginTourguideItems{" +
			"umur_tourguide = '" + umurTourguide + '\'' + 
			",status_tourguide = '" + statusTourguide + '\'' + 
			",email_tourguide = '" + emailTourguide + '\'' + 
			",harga_tourguide = '" + hargaTourguide + '\'' + 
			",foto_tourguide = '" + fotoTourguide + '\'' + 
			",nama_tourguide = '" + namaTourguide + '\'' + 
			",password_tourguide = '" + passwordTourguide + '\'' + 
			",notelp_tourguide = '" + notelpTourguide + '\'' + 
			",id_kab = '" + idKab + '\'' + 
			",ktp_tourguide = '" + ktpTourguide + '\'' + 
			",sertifikat_tourguide = '" + sertifikatTourguide + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",deskripsi_tourguide = '" + deskripsiTourguide + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}