package PhieuThu.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nguyenLieuId;
    @Column(name = "tennguyenlieu")
    @Size(max = 20, message = "Ten nguyen lieu khong duoc qua 20 ky tu")
    private String tenNguyenLieu;
    @Column(name = "giaban")
    @Min(value = 0, message = "Gia ban toi thieu bang 0")
    private int giaBan;
    @Column(name = "donvitinh")
    @Size(max = 10, message = "Don vi tinh khong duoc qua 10 ky tu")
    private String donViTinh;
    @Column(name = "soluongkho")
    @Min(value = 0, message = "So luong kho toi thieu bang 0")
    private int soLuongKho;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loaiNguyenLieuId")
    private LoaiNguyenLieu loaiNguyenLieu;

//    @OneToMany(mappedBy = "nguyenLieu")
//    @JsonIgnoreProperties(value = "nguyenLieu")
//    private Set<ChiTietPhieuThu> chiTietPhieuThus;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuongKho() {
        return soLuongKho;
    }

    public void setSoLuongKho(int soLuongKho) {
        this.soLuongKho = soLuongKho;
    }

    public LoaiNguyenLieu getLoaiNguyenLieu() {
        return loaiNguyenLieu;
    }

    public void setLoaiNguyenLieu(LoaiNguyenLieu loaiNguyenLieu) {
        this.loaiNguyenLieu = loaiNguyenLieu;
    }

//    public Set<ChiTietPhieuThu> getChiTietPhieuThus() {
//        return chiTietPhieuThus;
//    }
//
//    public void setChiTietPhieuThus(Set<ChiTietPhieuThu> chiTietPhieuThus) {
//        this.chiTietPhieuThus = chiTietPhieuThus;
//    }
}
