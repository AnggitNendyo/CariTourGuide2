package d3ti.uns.anggit.caritourguide.data;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.60.196.70/caritourguide/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}