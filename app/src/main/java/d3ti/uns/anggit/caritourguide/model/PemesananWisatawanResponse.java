package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class PemesananWisatawanResponse{

	@SerializedName("result")
	private PemesananWisatawanItems result;

	@SerializedName("kode")
	private int kode;

	public void setResult(PemesananWisatawanItems result){
		this.result = result;
	}

	public PemesananWisatawanItems getResult(){
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
			"PemesananWisatawanResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}