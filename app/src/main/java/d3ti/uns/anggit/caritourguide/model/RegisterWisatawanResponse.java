package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class RegisterWisatawanResponse{

	@SerializedName("result")
	private RegisterWisatawanItems result;

	@SerializedName("kode")
	private int kode;

	public void setResult(RegisterWisatawanItems result){
		this.result = result;
	}

	public RegisterWisatawanItems getResult(){
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
			"RegisterWisatawanResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}