package d3ti.uns.anggit.caritourguide.data.helper;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_CTG_APP = "spCTGApp";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    public static final String SP_NAMA_USER = "spNamaUser";
    public static final String SP_KET_LOGIN = "spKetLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_CTG_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
        spEditor.apply();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpEmailUser() {
        return sp.getString(SP_EMAIL, "");
    }

    public String getSpNamaUser() { return sp.getString(SP_NAMA_USER, ""); }

    public String getSpKetLogin() { return sp.getString(SP_KET_LOGIN, ""); }

    public boolean getSPSudahLogin() {
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
