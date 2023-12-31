package PhieuThu.Services;
import PhieuThu.Models.PhieuThu;
import java.util.List;

public interface IPhieuThu {
    public String themPhieuThu(PhieuThu phieuThu);
    public void xoaPhieuThu(int phieuThuId);
    public List<PhieuThu> layPhieuThuTheoTG(int thang);
}
