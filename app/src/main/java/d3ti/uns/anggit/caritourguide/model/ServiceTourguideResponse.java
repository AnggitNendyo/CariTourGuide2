package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class ServiceTourguideResponse{

	@SerializedName("result")
	private ServiceTourguideItems result;

	@SerializedName("kode")
	private int kode;

	public void setResult(ServiceTourguideItems result){
		this.result = result;
	}

	public ServiceTourguideItems getResult(){
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
			"ServiceTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}