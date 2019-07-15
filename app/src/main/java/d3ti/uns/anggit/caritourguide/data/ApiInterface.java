package d3ti.uns.anggit.caritourguide.data;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

import d3ti.uns.anggit.caritourguide.model.BookingTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.EditProfilTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.EditProfilWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.EditServisResponse;
import d3ti.uns.anggit.caritourguide.model.EditStatusPemesananResponse;
import d3ti.uns.anggit.caritourguide.model.KotaResponse;
import d3ti.uns.anggit.caritourguide.model.LoginTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.LoginWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.PemesananTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.PemesananWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ProfilWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.RegisterWisatawanResponse;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ServiceTourguideResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
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

    @FormUrlEncoded
    @POST("pemesanan_wisatawan")
    Call<BookingTourguideResponse> bookingWisatawan(
            @Field("tanggal_pemesanan") String tanggal_pemesanan,
            @Field("jam_pemesanan") String jam_pemesanan,
            @Field("lokasi_temu") String lokasi_temu,
            @Field("email_wisatawan") String email_wisatawan,
            @Field("id_tourguide") String id_tourguide
    );

    @GET("profil_wisatawan")
    Call<ProfilWisatawanResponse> getProfilWisatawan(@Query("email") String email);

    @GET("profil_tourguide")
    Call<ProfilTourguideResponse> getProfilTourguide(@Query("email") String email);

    @GET("servis_tourguide")
    Call<ServiceTourguideResponse> getServiceTourguide(@Query("email") String id);

    @GET("tourguide")
    Call<SearchTourguideResponse> getSearchTourguide();

    @GET("pemesanan_wisatawan")
    Call<PemesananWisatawanResponse> getPemesananWisatawan(@Query("email") String email);

    @GET("pemesanan_tourguide")
    Call<PemesananTourguideResponse> getPemesananTourguide(@Query("email") String email);

    @GET("kota")
    Call<KotaResponse> getKota();

    @FormUrlEncoded
    @PUT("servis_tourguide")
    Call<EditServisResponse> putServis(
            @Field("email") String email,
            @Field("servis[]") ArrayList<String> servis,
            @Field("topik[]") ArrayList<String> topik,
            @Field("bahasa[]") ArrayList<String> bahasa,
            @Field("hari[]") ArrayList<String> hari,
            @Field("kota") String kota,
            @Field("harga") String harga,
            @Field("deskripsi") String deskripsi
    );

    @FormUrlEncoded
    @PUT("profil_tourguide")
    Call<EditProfilTourguideResponse> putProfilTourguide(
            @Field("email") String email,
            @Field("nama_tourguide") String namaTourguide,
            @Field("notelp_tourguide") String noTelpTourguide,
            @Field("alamat_tourguide") String alamatTourguide,
            @Field("jenis_kelamin") String jenisKelamin,
            @Field("ktp_tourguide") String noKtpTourguide,
            @Field("umur_tourguide") String umurTourguide
            );

    @FormUrlEncoded
    @PUT("profil_wisatawan")
    Call<EditProfilWisatawanResponse> putProfilWisatawan(
            @Field("email") String email,
            @Field("nama_wisatawan") String namaWisatawan,
            @Field("notelp_wisatawan") String noTelpWisatawan,
            @Field("alamat_wisatawan") String alamatWisatawan,
            @Field("jenis_kelamin") String jenisKelamin,
            @Field("umur_wisatawan") String umurWisatawan,
            @Field("ktp_wisatawan") String ktpWisatawan,
            @Field("paspor_wisatawan") String pasporWisatawan
    );

    @FormUrlEncoded
    @PUT("status_pemesanan")
    Call<EditStatusPemesananResponse> putStatusPemesnan(
        @Field("id_pemesanan") String idPemesanan,
        @Field("status_pemesanan")String statusPemesanan
    );


}