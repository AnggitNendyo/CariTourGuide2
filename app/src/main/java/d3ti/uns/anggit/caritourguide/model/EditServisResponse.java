package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class EditServisResponse{

	@SerializedName("result")
	private EditServisItem result;

	@SerializedName("kode")
	private int kode;

	public void setResult(EditServisItem result){
		this.result = result;
	}

	public EditServisItem getResult(){
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
			"EditServisResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}