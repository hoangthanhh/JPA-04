package PhieuThu.repository;

import PhieuThu.Models.ChiTietPhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuThuRepo extends JpaRepository<ChiTietPhieuThu,Integer> {
}
