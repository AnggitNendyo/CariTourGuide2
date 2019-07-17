package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class EditProfilWisatawanItem {

	@SerializedName("nama_wisatawan")
	private String namaWisatawan;

	@SerializedName("umur_wisatawan")
	private String umurWisatawan;

	@SerializedName("alamat_wisatawan")
	private String alamatWisatawan;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("notelp_wisatawan")
	private String notelpWisatawan;

	@SerializedName("paspor_wisatawan")
	private String pasporWisatawan;

	@SerializedName("ktp_wisatawan")
	private String ktpWisatawan;

	public void setNamaWisatawan(String namaWisatawan){
		this.namaWisatawan = namaWisatawan;
	}

	public String getNamaWisatawan(){
		return namaWisatawan;
	}

	public void setUmurWisatawan(String umurWisatawan){
		this.umurWisatawan = umurWisatawan;
	}

	public String getUmurWisatawan(){
		return umurWisatawan;
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

	public void setPasporWisatawan(String pasporWisatawan){
		this.pasporWisatawan = pasporWisatawan;
	}

	public String getPasporWisatawan(){
		return pasporWisatawan;
	}

	public void setKtpWisatawan(String ktpWisatawan){
		this.ktpWisatawan = ktpWisatawan;
	}

	public String getKtpWisatawan(){
		return ktpWisatawan;
	}

	@Override
 	public String toString(){
		return 
			"EditProfilWisatawanItem{" +
			"nama_wisatawan = '" + namaWisatawan + '\'' + 
			",umur_wisatawan = '" + umurWisatawan + '\'' + 
			",alamat_wisatawan = '" + alamatWisatawan + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",notelp_wisatawan = '" + notelpWisatawan + '\'' + 
			",paspor_wisatawan = '" + pasporWisatawan + '\'' + 
			",ktp_wisatawan = '" + ktpWisatawan + '\'' + 
			"}";
		}
}