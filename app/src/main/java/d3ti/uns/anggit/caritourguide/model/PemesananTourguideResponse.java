package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class PemesananTourguideResponse{

	@SerializedName("result")
	private PemesananTourguideItems result;

	@SerializedName("kode")
	private int kode;

	public void setResult(PemesananTourguideItems result){
		this.result = result;
	}

	public PemesananTourguideItems getResult(){
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
			"PemesananTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}