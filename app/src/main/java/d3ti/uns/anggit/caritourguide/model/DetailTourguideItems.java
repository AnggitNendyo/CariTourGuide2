package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class DetailTourguideItems {

	@SerializedName("hari")
	private List<HariItem> hari;

	@SerializedName("topik")
	private List<TopikItem> topik;

	@SerializedName("servis")
	private List<ServisItem> servis;

	@SerializedName("bahasa")
	private List<BahasaItem> bahasa;

	@SerializedName("tourguide")
	private List<TourguideItem> tourguide;

	public void setHari(List<HariItem> hari){
		this.hari = hari;
	}

	public List<HariItem> getHari(){
		return hari;
	}

	public void setTopik(List<TopikItem> topik){
		this.topik = topik;
	}

	public List<TopikItem> getTopik(){
		return topik;
	}

	public void setServis(List<ServisItem> servis){
		this.servis = servis;
	}

	public List<ServisItem> getServis(){
		return servis;
	}

	public void setBahasa(List<BahasaItem> bahasa){
		this.bahasa = bahasa;
	}

	public List<BahasaItem> getBahasa(){
		return bahasa;
	}

	public void setTourguide(List<TourguideItem> tourguide){
		this.tourguide = tourguide;
	}

	public List<TourguideItem> getTourguide(){
		return tourguide;
	}

	@Override
 	public String toString(){
		return 
			"DetailTourguideItems{" +
			"hari = '" + hari + '\'' + 
			",topik = '" + topik + '\'' + 
			",servis = '" + servis + '\'' + 
			",bahasa = '" + bahasa + '\'' + 
			",tourguide = '" + tourguide + '\'' + 
			"}";
		}
}