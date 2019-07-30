package d3ti.uns.anggit.caritourguide.view.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import d3ti.uns.anggit.caritourguide.R;
import d3ti.uns.anggit.caritourguide.data.ApiInterface;
import d3ti.uns.anggit.caritourguide.data.ApiService;
import d3ti.uns.anggit.caritourguide.data.helper.SharedPrefManager;
import d3ti.uns.anggit.caritourguide.model.BookingTourguideResponse;
import d3ti.uns.anggit.caritourguide.view.fragment.PemesananWisatawanFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingTourguideActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ID_TOURGUIDE = "id_tourguide";
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText et_tgl_tour, et_waktu_tour, et_lokasi_temu;
    Button btn_booking_tourguide, btn_batal_booking;
    String id_tourguide;
    private SharedPrefManager sharedPrefManager;

    private ApiInterface apiInterface = ApiService.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_tourguide);

        sharedPrefManager = new SharedPrefManager(this);

        id_tourguide = getIntent().getExtras().getString(ID_TOURGUIDE);
        et_tgl_tour = (EditText) findViewById(R.id.et_tgl_tour);
        et_waktu_tour = (EditText) findViewById(R.id.et_waktu_tour);
        et_lokasi_temu = (EditText) findViewById(R.id.et_lokasi_temu);
        btn_booking_tourguide = (Button) findViewById(R.id.btn_booking_tourguide);
        btn_batal_booking = findViewById(R.id.btn_batal_booking);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        et_lokasi_temu.setOnClickListener(this);
        et_tgl_tour.setOnClickListener(this);
        et_waktu_tour.setOnClickListener(this);
        btn_booking_tourguide.setOnClickListener(this);

        initView();
    }

    private void initView() {
        et_lokasi_temu = (EditText) findViewById(R.id.et_lokasi_temu);
        et_tgl_tour = (EditText) findViewById(R.id.et_tgl_tour);
        et_waktu_tour = (EditText) findViewById(R.id.et_waktu_tour);
        btn_booking_tourguide = (Button) findViewById(R.id.btn_booking_tourguide);
        btn_booking_tourguide.setOnClickListener(this);
        btn_batal_booking = findViewById(R.id.btn_batal_booking);
        btn_batal_booking.setOnClickListener(this);
    }

    private void updateLabel() {
        String myFormat ="yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        et_tgl_tour.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_tgl_tour:
                new DatePickerDialog(BookingTourguideActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.et_waktu_tour:
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BookingTourguideActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        et_waktu_tour.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//24 jam
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                break;
            case R.id.btn_booking_tourguide:
                String tanggal_tour = et_tgl_tour.getText().toString();
                String waktu_tour = et_waktu_tour.getText().toString();
                String lokasi_temu = et_lokasi_temu.getText().toString();

                if (TextUtils.isEmpty(tanggal_tour) && TextUtils.isEmpty(waktu_tour) && TextUtils.isEmpty(lokasi_temu)) {
                    Toast.makeText(this, "Isian Masih Kosong !", Toast.LENGTH_SHORT).show();
                } else {
                    apiInterface.bookingWisatawan(tanggal_tour, waktu_tour, lokasi_temu, sharedPrefManager.getSpEmailUser(), id_tourguide).enqueue(new Callback<BookingTourguideResponse>() {
                        @Override
                        public void onResponse(Call<BookingTourguideResponse> call, Response<BookingTourguideResponse> response) {
                            try {
                                if (response.isSuccessful()) {
                                    String respon = response.body().getResult().getStatus();

                                    if (TextUtils.isEmpty(respon)) {
                                        Toast.makeText(getApplicationContext(), "Kesalahan Server !", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (TextUtils.equals(respon, "Pemesanan Berhasil")) {
                                            Toast.makeText(getApplicationContext(), "Pemesanan Berhasil !", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), PemesananWisatawanFragment.class);
                                            finish();
                                            getApplicationContext().startActivity(intent);
                                        } else if (TextUtils.equals(respon, "Pesanan Telah Dibuat !")) {
                                            Toast.makeText(getApplicationContext(), "Pesanan Telah Dibuat !", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Pemesanan Gagal !", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<BookingTourguideResponse> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }
                break;

            case R.id.btn_batal_booking:
                finish();
                break;

        }
    }
}




