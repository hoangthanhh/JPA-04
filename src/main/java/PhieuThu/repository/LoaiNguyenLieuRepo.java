package PhieuThu.repository;

import PhieuThu.Models.LoaiNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiNguyenLieuRepo extends JpaRepository<LoaiNguyenLieu,Integer> {
}
