package d3ti.uns.anggit.caritourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.model.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

    View view;
    private TextView tvNamaWisatawan;
    private EditText etNamaWisatawan;
    private TextView tvEmailWisatawan;
    private EditText etEmailWisatawan;
    private TextView tvPasswordWisatawan;
    private EditText etPasswordWisatawan;
    private TextView tvUlangiPasswordWisatawan;
    private EditText etUlangiPasswordWisatawan;
    private Button btnRegisterWisatawan;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        tvNamaWisatawan = (TextView) view.findViewById(R.id.tv_nama_wisatawan);
        etNamaWisatawan = (EditText) view.findViewById(R.id.et_nama_wisatawan);
        tvEmailWisatawan = (TextView) view.findViewById(R.id.tv_email_wisatawan);
        etEmailWisatawan = (EditText) view.findViewById(R.id.et_email_wisatawan);
        tvPasswordWisatawan = (TextView) view.findViewById(R.id.tv_password_wisatawan);
        etPasswordWisatawan = (EditText) view.findViewById(R.id.et_password_wisatawan);
        tvUlangiPasswordWisatawan = (TextView) view.findViewById(R.id.tv_ulangi_password_wisatawan);
        etUlangiPasswordWisatawan = (EditText) view.findViewById(R.id.et_ulangi_password_wisatawan);
        btnRegisterWisatawan = (Button) view.findViewById(R.id.btn_register_wisatawan);

        btnRegisterWisatawan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Call<RegisterResponse> call = apiInterface.register(etNamaWisatawan.getText().toString(), etEmailWisatawan.getText().toString(), etPasswordWisatawan.getText().toString());
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus().equals("sukses")){
                        Toast.makeText(getActivity(), "Sukses Input data", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}