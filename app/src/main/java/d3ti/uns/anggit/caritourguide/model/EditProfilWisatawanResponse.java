package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class EditProfilWisatawanResponse{

	@SerializedName("result")
	private EditProfilWisatawanItem result;

	@SerializedName("kode")
	private int kode;

	public void setResult(EditProfilWisatawanItem result){
		this.result = result;
	}

	public EditProfilWisatawanItem getResult(){
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
			"EditProfilWisatawanResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}