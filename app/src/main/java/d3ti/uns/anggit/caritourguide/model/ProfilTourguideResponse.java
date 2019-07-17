package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ProfilTourguideResponse{

	@SerializedName("result")
	private List<ProfilTourguideItems> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<ProfilTourguideItems> result){
		this.result = result;
	}

	public List<ProfilTourguideItems> getResult(){
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
			"ProfilTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}