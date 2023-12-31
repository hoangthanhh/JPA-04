package PhieuThu.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "loainguyenlieu")
public class LoaiNguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaiNguyenLieuId;
    @Column(name = "tenloai")
    @Size(max = 20, message = "Ten loai khong duoc qua 20 ky tu")
    private String tenLoai;
    @Column(name = "moTa")
    private String moTa;
    @OneToMany(mappedBy = "loaiNguyenLieu")
    @JsonIgnoreProperties(value = "loaiNguyenLieu")
    private Set<NguyenLieu> nguyenLieus;

    public int getLoaiNguyenLieuId() {
        return loaiNguyenLieuId;
    }

    public void setLoaiNguyenLieuId(int loaiNguyenLieuId) {
        this.loaiNguyenLieuId = loaiNguyenLieuId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Set<NguyenLieu> getNguyenLieus() {
        return nguyenLieus;
    }

    public void setNguyenLieus(Set<NguyenLieu> nguyenLieus) {
        this.nguyenLieus = nguyenLieus;
    }
}
