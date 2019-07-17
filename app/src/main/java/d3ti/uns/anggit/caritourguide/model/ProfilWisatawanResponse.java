package d3ti.uns.anggit.caritourguide.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ProfilWisatawanResponse{

	@SerializedName("result")
	private List<ProfilWisatawanItems> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<ProfilWisatawanItems> result){
		this.result = result;
	}

	public List<ProfilWisatawanItems> getResult(){
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
			"ProfilWisatawanResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}