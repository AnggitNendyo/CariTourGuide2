package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class RegisterWisatawanItems {

	@SerializedName("nama_wisatawan")
	private String namaWisatawan;

	@SerializedName("password_wisatawan")
	private String passwordWisatawan;

	@SerializedName("email_wisatawan")
	private String emailWisatawan;

	@SerializedName("status")
	private String status;

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

	public void setEmailWisatawan(String emailWisatawan){
		this.emailWisatawan = emailWisatawan;
	}

	public String getEmailWisatawan(){
		return emailWisatawan;
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
			"RegisterWisatawanItems{" +
			"nama_wisatawan = '" + namaWisatawan + '\'' + 
			",password_wisatawan = '" + passwordWisatawan + '\'' + 
			",email_wisatawan = '" + emailWisatawan + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}