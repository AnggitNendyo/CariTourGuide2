package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class EditProfilTourguideResponse{

	@SerializedName("result")
	private EditProfilTourguideItem result;

	@SerializedName("kode")
	private int kode;

	public void setResult(EditProfilTourguideItem result){
		this.result = result;
	}

	public EditProfilTourguideItem getResult(){
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
			"EditProfilTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}