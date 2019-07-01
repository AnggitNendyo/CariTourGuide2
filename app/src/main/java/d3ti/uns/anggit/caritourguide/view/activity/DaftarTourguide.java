package d3ti.uns.anggit.caritourguide.view.activity;

public class DaftarTourguide {
    private String nama_tourguide;
    private String email_tourguide;
    private String status_tourguide;
    private int foto_tourguide;
    private String harga_tourguide;
    private String kota_tourguide;
    private String deskripsi_tourguide;

    public DaftarTourguide(String nama_tourguide, String email_tourguide, String status_tourguide, int foto_tourguide, String harga_tourguide, String kota_tourguide, String deskripsi_tourguide) {
        this.nama_tourguide = nama_tourguide;
        this.email_tourguide = email_tourguide;
        this.status_tourguide = status_tourguide;
        this.foto_tourguide = foto_tourguide;
        this.harga_tourguide = harga_tourguide;
        this.kota_tourguide = kota_tourguide;
        this.deskripsi_tourguide = deskripsi_tourguide;
    }

    public String getNama_tourguide() {
        return nama_tourguide;
    }

    public String getStatus_tourguide() {
        return status_tourguide;
    }

    public String getEmail_tourguide() {
        return email_tourguide;
    }

    public int getFoto_tourguide() {
        return foto_tourguide;
    }

    public String getHarga_tourguide() {
        return harga_tourguide;
    }

    public String getKota_tourguide() {
        return kota_tourguide;
    }

    public String getDeskripsi_tourguide() {
        return deskripsi_tourguide;
    }


    public void setNama_tourguide(String nama_tourguide) {
        this.nama_tourguide = nama_tourguide;
    }

    public void setEmail_tourguide(String email_tourguide) {
        this.email_tourguide = email_tourguide;
    }

    public void setStatus_tourguide(String status_tourguide) {
        this.status_tourguide = status_tourguide;
    }

    public void setFoto_tourguide(int foto_tourguide) {
        this.foto_tourguide = foto_tourguide;
    }

    public void setHarga_tourguide(String harga_tourguide) {
        this.harga_tourguide = harga_tourguide;
    }

    public void setKota_tourguide(String kota_tourguide) {
        this.kota_tourguide = kota_tourguide;
    }

    public void setDeskripsi_tourguide(String deskripsi_tourguide) {
        this.deskripsi_tourguide = deskripsi_tourguide;
    }


}