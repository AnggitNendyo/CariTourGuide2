package d3ti.uns.anggit.caritourguide.model;


import com.google.gson.annotations.SerializedName;


public class BookingTourguideResponse{

	@SerializedName("result")
	private BookingTourguideItems result;

	@SerializedName("kode")
	private int kode;

	public void setResult(BookingTourguideItems result){
		this.result = result;
	}

	public BookingTourguideItems getResult(){
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
			"BookingTourguideResponse{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}