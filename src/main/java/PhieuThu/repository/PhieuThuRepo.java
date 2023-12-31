package PhieuThu.repository;

import PhieuThu.Models.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuThuRepo extends JpaRepository<PhieuThu,Integer> {
    @Query(value = "select * from phieuthu where month(ngay_lap) = :month", nativeQuery = true)
    List<PhieuThu> layPhieuThuTheoThang(@Param("month") int month);
}
