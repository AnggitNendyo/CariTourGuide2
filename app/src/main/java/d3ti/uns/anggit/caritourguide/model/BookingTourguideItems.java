package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class BookingTourguideItems {

	@SerializedName("tanggal_pemesanan")
	private String tanggalPemesanan;

	@SerializedName("id_wisatawan")
	private String idWisatawan;

	@SerializedName("lokasi_temu")
	private String lokasiTemu;

	@SerializedName("jam_pemesanan")
	private String jamPemesanan;

	@SerializedName("id_tourguide")
	private String idTourguide;

	@SerializedName("status")
	private String status;

	public void setTanggalPemesanan(String tanggalPemesanan){
		this.tanggalPemesanan = tanggalPemesanan;
	}

	public String getTanggalPemesanan(){
		return tanggalPemesanan;
	}

	public void setIdWisatawan(String idWisatawan){
		this.idWisatawan = idWisatawan;
	}

	public String getIdWisatawan(){
		return idWisatawan;
	}

	public void setLokasiTemu(String lokasiTemu){
		this.lokasiTemu = lokasiTemu;
	}

	public String getLokasiTemu(){
		return lokasiTemu;
	}

	public void setJamPemesanan(String jamPemesanan){
		this.jamPemesanan = jamPemesanan;
	}

	public String getJamPemesanan(){
		return jamPemesanan;
	}

	public void setIdTourguide(String idTourguide){
		this.idTourguide = idTourguide;
	}

	public String getIdTourguide(){
		return idTourguide;
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
			"BookingTourguideItems{" +
			"tanggal_pemesanan = '" + tanggalPemesanan + '\'' + 
			",id_wisatawan = '" + idWisatawan + '\'' + 
			",lokasi_temu = '" + lokasiTemu + '\'' + 
			",jam_pemesanan = '" + jamPemesanan + '\'' + 
			",id_tourguide = '" + idTourguide + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}