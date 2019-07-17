package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class EditStatusPemesananItem {

	@SerializedName("status_pemesanan")
	private String statusPemesanan;

	public void setStatusPemesanan(String statusPemesanan){
		this.statusPemesanan = statusPemesanan;
	}

	public String getStatusPemesanan(){
		return statusPemesanan;
	}

	@Override
 	public String toString(){
		return 
			"EditStatusPemesananItem{" +
			"status_pemesanan = '" + statusPemesanan + '\'' + 
			"}";
		}
}