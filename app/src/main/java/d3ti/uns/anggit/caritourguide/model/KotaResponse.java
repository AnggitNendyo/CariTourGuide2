package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class KotaResponse{

	@SerializedName("result")
	private List<KotaItem> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<KotaItem> result){
		this.result = result;
	}

	public List<KotaItem> getResult(){
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
			"KotaResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}