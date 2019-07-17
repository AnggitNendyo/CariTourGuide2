package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class LoginWisatawanResponse{

	@SerializedName("result")
	private List<LoginWisatawanItems> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<LoginWisatawanItems> result){
		this.result = result;
	}

	public List<LoginWisatawanItems> getResult(){
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
			"LoginWisatawanResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}