package d3ti.uns.anggit.caritourguide.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.HashMap;
import d3ti.uns.anggit.caritourguide.view.activity.HomeActivity;
import d3ti.uns.anggit.caritourguide.view.activity.MainActivity;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME="LOGIN";
    private static final String LOGIN="IS_LOGIN";
    public static final String NAME="nama_wisatawan";
    public static final String EMAIL="email_wisatawan";
    public static final String ID_WISATAWAN="id_wisatawan";




    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences= context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }

    public void createSession(String nama, String email, String id){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAME, nama);
        editor.putString(EMAIL, email);
        editor.putString(ID_WISATAWAN, id);
        editor.apply();
    }

    public boolean isLogin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }
    public void cekLogin(){
        if(!this.isLogin()){
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String > user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(ID_WISATAWAN, sharedPreferences.getString(ID_WISATAWAN, null));
        return user;
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
        ((MainActivity) context).finish();
    }
}
