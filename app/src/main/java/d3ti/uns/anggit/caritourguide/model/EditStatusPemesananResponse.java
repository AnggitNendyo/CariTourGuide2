package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class EditStatusPemesananResponse{

	@SerializedName("result")
	private EditStatusPemesananItem result;

	@SerializedName("kode")
	private int kode;

	public void setResult(EditStatusPemesananItem result){
		this.result = result;
	}

	public EditStatusPemesananItem getResult(){
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
			"EditStatusPemesananResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}