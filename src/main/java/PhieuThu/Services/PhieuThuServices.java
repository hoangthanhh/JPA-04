package PhieuThu.Services;

import PhieuThu.Models.ChiTietPhieuThu;
import PhieuThu.Models.NguyenLieu;
import PhieuThu.Models.PhieuThu;
import PhieuThu.repository.ChiTietPhieuThuRepo;
import PhieuThu.repository.NguyenLieuRepo;
import PhieuThu.repository.PhieuThuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuThuServices implements IPhieuThu {
    @Autowired
    private PhieuThuRepo phieuThuRepo;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    private ChiTietPhieuThuRepo chiTietPhieuThuRepo;

    @Override
    public String themPhieuThu(PhieuThu phieuThu) {
        phieuThuRepo.save(phieuThu);

//      Cập nhật số lượng kho và ThanhTien cho từng Chi Tiết Phiếu Thu
        for (ChiTietPhieuThu chiTietPhieuThu : phieuThu.getChiTietPhieuThus()) {
            NguyenLieu nguyenLieu = nguyenLieuRepo.findById(chiTietPhieuThu.getNguyenLieu().getNguyenLieuId()).get();

            // Kiểm tra số lượng kho
            if (nguyenLieu.getSoLuongKho() >= chiTietPhieuThu.getSoLuongBan()) {
                // Cập nhật số lượng kho
                nguyenLieu.setSoLuongKho(nguyenLieu.getSoLuongKho() - chiTietPhieuThu.getSoLuongBan());
                nguyenLieuRepo.save(nguyenLieu);
                chiTietPhieuThu.setPhieuThu(phieuThu);

                // Cập nhật trường ThanhTien của Phiếu Thu
                phieuThu.setThanhTien(phieuThu.getThanhTien() + chiTietPhieuThu.getSoLuongBan() * nguyenLieu.getGiaBan());

                // Lưu Chi Tiết Phiếu Thu
                chiTietPhieuThuRepo.save(chiTietPhieuThu);
            } else {
                // Xử lý trường hợp không đủ số lượng kho
                return "phieu thu ko thoa man";
            }
        }
        return "them thanh cong";
    }

    @Override
    public void xoaPhieuThu(int phieuThuId) {
        chiTietPhieuThuRepo.findAll().forEach(x -> {
            PhieuThu phieuThu = x.getPhieuThu();
            if (phieuThu != null && phieuThu.getPhieuThuId() == phieuThuId) {
                chiTietPhieuThuRepo.delete(x);
            }
        });
        phieuThuRepo.deleteById(phieuThuId);
    }

    @Override
    public List<PhieuThu> layPhieuThuTheoTG(int thang) {
        List<PhieuThu> list = phieuThuRepo.layPhieuThuTheoThang(thang);
        return list;
    }
}
