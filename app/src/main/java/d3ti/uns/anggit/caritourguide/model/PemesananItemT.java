package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class PemesananItemT {

	public String getReviewTourT() {
		return reviewTourT;
	}

	public void setReviewTourT(String reviewTourT) {
		this.reviewTourT = reviewTourT;
	}

	@SerializedName("review_tour")
	private String reviewTourT;

	@SerializedName("nama")
	private String nama;

	@SerializedName("harga_tourguide")
	private String hargaTourguide;

	@SerializedName("status_pemesanan")
	private String statusPemesanan;

	@SerializedName("id_pemesanan")
	private String idPemesanan;

	@SerializedName("tanggal_pemesanan")
	private String tanggalPemesanan;

	@SerializedName("lokasi_temu")
	private String lokasiTemu;

	@SerializedName("password_wisatawan")
	private String passwordWisatawan;

	@SerializedName("alamat_wisatawan")
	private String alamatWisatawan;

	@SerializedName("jam_pemesanan")
	private String jamPemesanan;

	@SerializedName("id_wisatawan")
	private String idWisatawan;

	@SerializedName("nama_wisatawan")
	private String namaWisatawan;

	@SerializedName("umur_wisatawan")
	private String umurWisatawan;

	@SerializedName("email_wisatawan")
	private String emailWisatawan;

	@SerializedName("foto_wisatawan")
	private String fotoWisatawan;

	@SerializedName("id_tourguide")
	private String idTourguide;

	@SerializedName("jenis_kelamin")
	private String jenisKelamin;

	@SerializedName("notelp_wisatawan")
	private String notelpWisatawan;

	@SerializedName("paspor_wisatawan")
	private Object pasporWisatawan;

	@SerializedName("ktp_wisatawan")
	private Object ktpWisatawan;

	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getHargaTourguide() {
		return hargaTourguide;
	}
	public void setHargaTourguide(String hargaTourguide) {
		this.hargaTourguide = hargaTourguide;
	}

	public void setStatusPemesanan(String statusPemesanan){
		this.statusPemesanan = statusPemesanan;
	}

	public String getStatusPemesanan(){
		return statusPemesanan;
	}

	public void setIdPemesanan(String idPemesanan){
		this.idPemesanan = idPemesanan;
	}

	public String getIdPemesanan(){
		return idPemesanan;
	}

	public void setTanggalPemesanan(String tanggalPemesanan){
		this.tanggalPemesanan = tanggalPemesanan;
	}

	public String getTanggalPemesanan(){
		return tanggalPemesanan;
	}

	public void setLokasiTemu(String lokasiTemu){
		this.lokasiTemu = lokasiTemu;
	}

	public String getLokasiTemu(){
		return lokasiTemu;
	}

	public void setPasswordWisatawan(String passwordWisatawan){
		this.passwordWisatawan = passwordWisatawan;
	}

	public String getPasswordWisatawan(){
		return passwordWisatawan;
	}

	public void setAlamatWisatawan(String alamatWisatawan){
		this.alamatWisatawan = alamatWisatawan;
	}

	public String getAlamatWisatawan(){
		return alamatWisatawan;
	}

	public void setJamPemesanan(String jamPemesanan){
		this.jamPemesanan = jamPemesanan;
	}

	public String getJamPemesanan(){
		return jamPemesanan;
	}

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

	@Override
 	public String toString(){
		return 
			"PemesananItemT{" +
			"status_pemesanan = '" + statusPemesanan + '\'' + 
			",id_pemesanan = '" + idPemesanan + '\'' + 
			",tanggal_pemesanan = '" + tanggalPemesanan + '\'' + 
			",lokasi_temu = '" + lokasiTemu + '\'' + 
			",password_wisatawan = '" + passwordWisatawan + '\'' + 
			",alamat_wisatawan = '" + alamatWisatawan + '\'' + 
			",jam_pemesanan = '" + jamPemesanan + '\'' + 
			",id_wisatawan = '" + idWisatawan + '\'' + 
			",nama_wisatawan = '" + namaWisatawan + '\'' + 
			",umur_wisatawan = '" + umurWisatawan + '\'' + 
			",email_wisatawan = '" + emailWisatawan + '\'' + 
			",foto_wisatawan = '" + fotoWisatawan + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			",jenis_kelamin = '" + jenisKelamin + '\'' + 
			",notelp_wisatawan = '" + notelpWisatawan + '\'' + 
			",paspor_wisatawan = '" + pasporWisatawan + '\'' + 
			",ktp_wisatawan = '" + ktpWisatawan + '\'' + 
			"}";
		}
}