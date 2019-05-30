package d3ti.uns.anggit.caritourguide.model;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return
                "RegisterResponse{" +
                        "status = '" + status +
                        "}";
    }
}