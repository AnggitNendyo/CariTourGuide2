package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class LoginWisatawanItems {

	@SerializedName("id_wisatawan")
	private String idWisatawan;

	@SerializedName("nama_wisatawan")
	private String namaWisatawan;

	@SerializedName("password_wisatawan")
	private String passwordWisatawan;

	@SerializedName("umur_wisatawan")
	private String umurWisatawan;

	@SerializedName("email_wisatawan")
	private String emailWisatawan;

	@SerializedName("foto_wisatawan")
	private String fotoWisatawan;

	@SerializedName("alamat_wisatawan")
	private String alamatWisatawan;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("notelp_wisatawan")
	private String notelpWisatawan;

	@SerializedName("paspor_wisatawan")
	private Object pasporWisatawan;

	@SerializedName("ktp_wisatawan")
	private Object ktpWisatawan;

	@SerializedName("status")
	private String status;

	public void setIdWisatawan(String idWisatawan){
		this.idWisatawan = idWisatawan;
	}

	public String getIdWisatawan(){
		return idWisatawan;
	}

	public void setNamaWisatawan(String namaWisatawan){
		this.namaWisatawan = namaWisatawan;
	}

	public String getNamaWisatawan(){
		return namaWisatawan;
	}

	public void setPasswordWisatawan(String passwordWisatawan){
		this.passwordWisatawan = passwordWisatawan;
	}

	public String getPasswordWisatawan(){
		return passwordWisatawan;
	}

	public void setUmurWisatawan(String umurWisatawan){
		this.umurWisatawan = umurWisatawan;
	}

	public String getUmurWisatawan(){
		return umurWisatawan;
	}

	public void setEmailWisatawan(String emailWisatawan){
		this.emailWisatawan = emailWisatawan;
	}

	public String getEmailWisatawan(){
		return emailWisatawan;
	}

	public void setFotoWisatawan(String fotoWisatawan){
		this.fotoWisatawan = fotoWisatawan;
	}

	public String getFotoWisatawan(){
		return fotoWisatawan;
	}

	public void setAlamatWisatawan(String alamatWisatawan){
		this.alamatWisatawan = alamatWisatawan;
	}

	public String getAlamatWisatawan(){
		return alamatWisatawan;
	}

	public void setJenisKelamin(String jenisKelamin){
		this.jenisKelamin = jenisKelamin;
	}

	public String getJenisKelamin(){
		return jenisKelamin;
	}

	public void setNotelpWisatawan(String notelpWisatawan){
		this.notelpWisatawan = notelpWisatawan;
	}

	public String getNotelpWisatawan(){
		return notelpWisatawan;
	}

	public void setPasporWisatawan(Object pasporWisatawan){
		this.pasporWisatawan = pasporWisatawan;
	}

	public Object getPasporWisatawan(){
		return pasporWisatawan;
	}

	public void setKtpWisatawan(Object ktpWisatawan){
		this.ktpWisatawan = ktpWisatawan;
	}

	public Object getKtpWisatawan(){
		return ktpWisatawan;
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
			"LoginWisatawanItems{" +
			"id_wisatawan = '" + idWisatawan + '\'' + 
			",nama_wisatawan = '" + namaWisatawan + '\'' + 
			",password_wisatawan = '" + passwordWisatawan + '\'' + 
			",umur_wisatawan = '" + umurWisatawan + '\'' + 
			",email_wisatawan = '" + emailWisatawan + '\'' + 
			",foto_wisatawan = '" + fotoWisatawan + '\'' + 
			",alamat_wisatawan = '" + alamatWisatawan + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",notelp_wisatawan = '" + notelpWisatawan + '\'' + 
			",paspor_wisatawan = '" + pasporWisatawan + '\'' + 
			",ktp_wisatawan = '" + ktpWisatawan + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}