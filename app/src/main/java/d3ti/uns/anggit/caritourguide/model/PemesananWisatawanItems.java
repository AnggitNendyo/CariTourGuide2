package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PemesananWisatawanItems {

	@SerializedName("pemesanan")
	private List<PemesananItemW> pemesanan;

	public void setPemesanan(List<PemesananItemW> pemesanan){
		this.pemesanan = pemesanan;
	}

	public List<PemesananItemW> getPemesanan(){
		return pemesanan;
	}

	@Override
 	public String toString(){
		return 
			"PemesananWisatawanItems{" +
			"pemesanan = '" + pemesanan + '\'' + 
			"}";
		}
}