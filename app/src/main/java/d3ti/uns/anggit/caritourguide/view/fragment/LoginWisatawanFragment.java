package d3ti.uns.anggit.caritourguide.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.SessionManager;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.LoginWisatawanResponse;
import d3ti.uns.anggit.caritourguide.view.activity.MainActivity;
import d3ti.uns.anggit.caritourguide.view.activity.RegisterWisatawanActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginWisatawanFragment extends Fragment implements View.OnClickListener {
    //SessionManager sessionManager;
    Button btnLoginWisatawan;
    Button btnRegisterWisatawan;
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    private EditText etEmailWisatawan;
    private EditText etPasswordWisatawan;
    private View view;
    private SharedPrefManager sharedPrefManager;

    public LoginWisatawanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //sessionManager = new SessionManager(getActivity());

        view = inflater.inflate(R.layout.fragment_login_wisatawan, container, false);
        initView();
        sharedPrefManager = new SharedPrefManager(getContext());
        return view;
    }

    private void initView() {
        etEmailWisatawan = view.findViewById(R.id.et_email_wisatawan);
        etPasswordWisatawan = view.findViewById(R.id.et_password_wisatawan);
        btnLoginWisatawan = view.findViewById(R.id.btn_login_wisatawan);
        btnLoginWisatawan.setOnClickListener(this);
        btnRegisterWisatawan = view.findViewById(R.id.btn_register_wisatawan);
        btnRegisterWisatawan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_wisatawan:
                final String email = etEmailWisatawan.getText().toString();
                String password = etPasswordWisatawan.getText().toString();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "Email / Password Masih Kosong !", Toast.LENGTH_SHORT).show();
                } else {
                    apiInterface.loginWisatawan(email, password).enqueue(new Callback<LoginWisatawanResponse>() {
                        @Override
                        public void onResponse(Call<LoginWisatawanResponse> call, Response<LoginWisatawanResponse> response) {
                            try {
                                if (response.isSuccessful()) {
                                    String respon = response.body().getResult().get(0).getStatus();
                                    if (TextUtils.isEmpty(respon)) {
                                        Toast.makeText(getActivity(), "Kesalahan Server !", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (TextUtils.equals(respon, "Login Berhasil")) {
                                            sharedPrefManager.saveSPString(sharedPrefManager.SP_EMAIL,email);
                                            sharedPrefManager.saveSPString(sharedPrefManager.SP_NAMA_USER,response.body().getResult().get(0).getNamaWisatawan());
                                            sharedPrefManager.saveSPBoolean(sharedPrefManager.SP_SUDAH_LOGIN,true);
                                            sharedPrefManager.saveSPString(sharedPrefManager.SP_KET_LOGIN,"wisatawan");

                                            Toast.makeText(getActivity(), "Login Berhasil !", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getActivity(), MainActivity.class);
                                            getActivity().startActivity(intent);
                                        } else {
                                            Toast.makeText(getActivity(), "Login Gagal !", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onFailure(Call<LoginWisatawanResponse> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }
                break;

            case R.id.btn_register_wisatawan:
                Intent intent = new Intent(getActivity(), RegisterWisatawanActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}
