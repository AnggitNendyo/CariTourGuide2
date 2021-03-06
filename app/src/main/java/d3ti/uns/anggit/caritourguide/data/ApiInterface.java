package d3ti.uns.anggit.caritourguide.data;

import java.util.ArrayList;

import d3ti.uns.anggit.caritourguide.model.BerandaTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.BerandaWisatawanResponse;
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
import d3ti.uns.anggit.caritourguide.model.ReportResponse;
import d3ti.uns.anggit.caritourguide.model.ReviewTourResponse;
import d3ti.uns.anggit.caritourguide.model.SearchTourguideResponse;
import d3ti.uns.anggit.caritourguide.model.ServiceTourguideResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
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

    @GET("tourguide")
    Call<SearchTourguideResponse> getSearchTourguideQuery(@Query("kota") String kota);

    @GET("pemesanan_wisatawan")
    Call<PemesananWisatawanResponse> getPemesananWisatawan(@Query("email") String email);

    @GET("pemesanan_tourguide")
    Call<PemesananTourguideResponse> getPemesananTourguide(@Query("email") String email);

    @GET("beranda_wisatawan")
    Call<BerandaWisatawanResponse> getBerandaWisatawan(@Query("email") String email);

    @GET("beranda_tourguide")
    Call<BerandaTourguideResponse> getBerandaTourguide(@Query("email") String email);

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

    @Multipart
    @POST("profil_tourguide")
    Call<EditProfilTourguideResponse> putProfilTourguide(
            @Part("email") RequestBody email,
            @Part("nama_tourguide") RequestBody namaTourguide,
            @Part("notelp_tourguide") RequestBody noTelpTourguide,
            @Part("alamat_tourguide") RequestBody alamatTourguide,
            @Part("jenis_kelamin") RequestBody jenisKelamin,
            @Part("ktp_tourguide") RequestBody noKtpTourguide,
            @Part("umur_tourguide") RequestBody umurTourguide,
            @Part MultipartBody.Part file,
            @Part("name") RequestBody name
            );

    @Multipart
    @POST("profil_wisatawan")
    Call<EditProfilWisatawanResponse> putProfilWisatawan(
            @Part("email") RequestBody email,
            @Part("nama_wisatawan") RequestBody namaWisatawan,
            @Part("notelp_wisatawan") RequestBody noTelpWisatawan,
            @Part("alamat_wisatawan") RequestBody alamatWisatawan,
            @Part("jenis_kelamin") RequestBody jenisKelamin,
            @Part("umur_wisatawan") RequestBody umurWisatawan,
            @Part("ktp_wisatawan") RequestBody ktpWisatawan,
            @Part("paspor_wisatawan") RequestBody pasporWisatawan,
            @Part MultipartBody.Part file,
            @Part("name") RequestBody name
    );

    @FormUrlEncoded
    @PUT("status_pemesanan")
    Call<EditStatusPemesananResponse> putStatusPemesnan(
        @Field("id_pemesanan") String idPemesanan,
        @Field("status_pemesanan")String statusPemesanan
    );

    @FormUrlEncoded
    @POST("review_tour")
    Call<ReviewTourResponse> postReviewTour(
            @Field("review_tour") String reviewTour,
            @Field("id_pemesanan") String idPemesanan
    );

    @FormUrlEncoded
    @POST("report")
    Call<ReportResponse> postReport(
            @Field("email_wisatawan") String email_wisatawan,
            @Field("deskripsi_report") String deskripsi_report,
            @Field("id_tourguide") String id_tourguide
    );


}