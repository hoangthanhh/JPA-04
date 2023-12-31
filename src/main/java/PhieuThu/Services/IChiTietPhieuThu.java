package PhieuThu.Services;

import PhieuThu.Models.ChiTietPhieuThu;
import PhieuThu.Models.PhieuThu;

import java.util.List;

public interface IChiTietPhieuThu {
//    public ChiTietPhieuThu themChiTietPhieuThu(ChiTietPhieuThu chiTietPhieuThu);
    public String themChiTietPhieuThu(List<ChiTietPhieuThu> lstchiTietPhieuThu,int idPhieuThu);
}
