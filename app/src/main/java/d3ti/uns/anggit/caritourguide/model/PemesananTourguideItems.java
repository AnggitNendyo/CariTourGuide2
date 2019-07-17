package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PemesananTourguideItems {

	@SerializedName("pemesanan")
	private List<PemesananItemT> pemesanan;

	public void setPemesanan(List<PemesananItemT> pemesanan){
		this.pemesanan = pemesanan;
	}

	public List<PemesananItemT> getPemesanan(){
		return pemesanan;
	}

	@Override
 	public String toString(){
		return 
			"PemesananTourguideItems{" +
			"pemesanan = '" + pemesanan + '\'' + 
			"}";
		}
}