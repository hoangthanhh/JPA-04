package PhieuThu.Services;

import PhieuThu.Models.ChiTietPhieuThu;
import PhieuThu.Models.NguyenLieu;
import PhieuThu.Models.PhieuThu;
import PhieuThu.repository.ChiTietPhieuThuRepo;
import PhieuThu.repository.NguyenLieuRepo;
import PhieuThu.repository.PhieuThuRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ChiTietPhieuThuServices implements IChiTietPhieuThu {
    @Autowired
    ChiTietPhieuThuRepo chiTietPhieuThuRepo;
    @Autowired
    NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    PhieuThuRepo phieuThuRepo;

    @Override
    public String themChiTietPhieuThu(List<ChiTietPhieuThu> lstchiTietPhieuThu, int idPhieuThu) {

        PhieuThu phieuThu = phieuThuRepo.findById(idPhieuThu).orElseThrow(() ->new EntityNotFoundException("Khong tim thay phieu thu voi ID:" + idPhieuThu));

        int thanhTien = phieuThu.getThanhTien();
        for (ChiTietPhieuThu chiTiet: lstchiTietPhieuThu) {
            if(idPhieuThu == chiTiet.getPhieuThu().getPhieuThuId()){
                NguyenLieu nguyenLieu = nguyenLieuRepo.findById(chiTiet.getNguyenLieu().getNguyenLieuId()).get();
                nguyenLieu.setSoLuongKho(nguyenLieu.getSoLuongKho() - chiTiet.getSoLuongBan());

                thanhTien += chiTiet.getSoLuongBan() * nguyenLieu.getGiaBan();


                nguyenLieuRepo.save(nguyenLieu);
                chiTietPhieuThuRepo.save(chiTiet);

            }else{
                return "Chi tiet nay khong thoa man";
            }

            phieuThu.setThanhTien(thanhTien);
            phieuThuRepo.save(phieuThu);
        }
        return "them thanh cong";
    }
}
