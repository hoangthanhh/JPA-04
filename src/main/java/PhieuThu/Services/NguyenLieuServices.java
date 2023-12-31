package PhieuThu.Services;

import PhieuThu.Models.LoaiNguyenLieu;
import PhieuThu.Models.NguyenLieu;
import PhieuThu.repository.LoaiNguyenLieuRepo;
import PhieuThu.repository.NguyenLieuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NguyenLieuServices implements  INguyenLieu{
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;

    @Autowired
    private LoaiNguyenLieuRepo loaiNguyenLieuRepo;

    @Override
    public NguyenLieu themNguyenLieu(NguyenLieu nguyenLieu) {
        Optional<LoaiNguyenLieu> loaiNguyenLieu = loaiNguyenLieuRepo.findById(nguyenLieu.getLoaiNguyenLieu().getLoaiNguyenLieuId());
        if (loaiNguyenLieu.isEmpty()) {
            return null;
        }
        nguyenLieuRepo.save(nguyenLieu);
        return nguyenLieu;
    }
}
