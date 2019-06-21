package d3ti.uns.anggit.caritourguide.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.LoginTourguideResponse;
import d3ti.uns.anggit.caritourguide.view.activity.MainActivityTourguide;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginTourguideFragment extends Fragment implements View.OnClickListener {
    Button btnLoginTourguide;
    ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);
    private EditText etEmailTourguide;
    private EditText etPasswordTourguide;
    private View view;

    public LoginTourguideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_tourguide, container, false);
        initView();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_tourguide:
                String email = etEmailTourguide.getText().toString();
                String password = etPasswordTourguide.getText().toString();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {

                    Toast.makeText(getActivity(), "Email / Password Masih Kosong !", Toast.LENGTH_SHORT).show();

                } else {
                    apiInterface.loginTourGuide(email, password).enqueue(new Callback<LoginTourguideResponse>() {
                        @Override
                        public void onResponse(Call<LoginTourguideResponse> call, Response<LoginTourguideResponse> response) {
                            try {
                                if (response.isSuccessful()) {
                                    String respon = response.body().getResult().get(0).getStatus();

                                    if (TextUtils.isEmpty(respon)) {
                                        Toast.makeText(getActivity(), "Kesalahan Server !", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (TextUtils.equals(respon, "Login Berhasil")) {
                                            Toast.makeText(getActivity(), "Login Berhasil !", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getActivity(), MainActivityTourguide.class);
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
                        public void onFailure(Call<LoginTourguideResponse> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }
                break;
        }
    }

    private void initView() {
        etEmailTourguide = view.findViewById(R.id.et_email_tourguide);
        etPasswordTourguide = view.findViewById(R.id.et_password_tourguide);
        btnLoginTourguide = view.findViewById(R.id.btn_login_tourguide);
        btnLoginTourguide.setOnClickListener(this);
    }
}

