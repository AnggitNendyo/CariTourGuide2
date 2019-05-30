package d3ti.uns.anggit.caritourguide.data;

import d3ti.uns.anggit.caritourguide.RegisterFragment;
import d3ti.uns.anggit.caritourguide.model.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("AKfycbxAxyh6-N5IM3nBFERG0_3dLUq_D02QVI5wzbiCmf7qgVNOznw/exec")
    Call<RegisterResponse> register(
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password
    );
}