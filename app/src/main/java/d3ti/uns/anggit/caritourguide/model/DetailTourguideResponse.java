package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class DetailTourguideResponse{

	@SerializedName("result")
	private DetailTourguideItems result;

	@SerializedName("kode")
	private int kode;

	public void setResult(DetailTourguideItems result){
		this.result = result;
	}

	public DetailTourguideItems getResult(){
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
			"DetailTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}