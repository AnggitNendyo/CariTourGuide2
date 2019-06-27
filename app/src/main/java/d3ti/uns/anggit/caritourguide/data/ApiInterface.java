package d3ti.uns.anggit.caritourguide.data;

import d3ti.uns.anggit.caritourguide.model.LoginTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.LoginWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.RegisterWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ServiceTourguideResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login_tourguide")
    Call<LoginTourguideResponse> loginTourGuide(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login_wisatawan")
    Call<LoginWisatawanResponse> loginWisatawan(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register_wisatawan")
    Call<RegisterWisatawanResponse> registerWisatawan(
            @Field("email") String email,
            @Field("password") String password,
            @Field("nama") String nama
    );

    @GET("profil_wisatawan")
    Call<ProfilWisatawanResponse> getProfilWisatawan();

    @GET("profil_tourguide")
    Call<ProfilTourguideResponse> getProfilTourguide();

    @GET("servis_tourguide")
    Call<ServiceTourguideResponse> getServiceTourguide(@Query("id") String id);

    @GET("tourguide")
    Call<SearchTourguideResponse> getSearchTourguide();


}