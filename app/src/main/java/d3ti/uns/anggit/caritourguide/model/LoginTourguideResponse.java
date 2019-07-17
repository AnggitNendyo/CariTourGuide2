package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LoginTourguideResponse{

	@SerializedName("result")
	private List<LoginTourguideItems> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<LoginTourguideItems> result){
		this.result = result;
	}

	public List<LoginTourguideItems> getResult(){
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
			"LoginTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}