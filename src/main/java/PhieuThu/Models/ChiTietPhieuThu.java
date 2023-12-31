package PhieuThu.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "chitietphieuthu")
public class ChiTietPhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chiTietPhieuThuId;
    @Column(name = "soluongban")
    @Min(value = 1, message = "So luong ban can lon hon 0")
    private int soLuongBan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phieuThuId")
    @JsonIgnoreProperties(value = "chiTietPhieuThus")
    private PhieuThu phieuThu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguyenLieuId")
    @JsonIgnoreProperties(value = "chiTietPhieuThus")
    private NguyenLieu nguyenLieu;

    public int getChiTietPhieuThuId() {
        return chiTietPhieuThuId;
    }

    public void setChiTietPhieuThuId(int chiTietPhieuThuId) {
        this.chiTietPhieuThuId = chiTietPhieuThuId;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public PhieuThu getPhieuThu() {
        return phieuThu;
    }

    public void setPhieuThu(PhieuThu phieuThu) {
        this.phieuThu = phieuThu;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}
