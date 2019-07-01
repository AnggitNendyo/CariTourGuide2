package d3ti.uns.anggit.caritourguide.data;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static d3ti.uns.anggit.caritourguide.BuildConfig.BASE_URL;

public class ApiService {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL+"caritourguide/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}