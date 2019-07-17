package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class SearchTourguideResponse{

	@SerializedName("result")
	private List<SearchTourguideItems> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<SearchTourguideItems> result){
		this.result = result;
	}

	public List<SearchTourguideItems> getResult(){
		return result;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}

	@Override
 	public String toString(){
		return 
			"SearchTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}