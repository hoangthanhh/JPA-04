package PhieuThu.Controller;

import PhieuThu.Models.ChiTietPhieuThu;
import PhieuThu.Models.NguyenLieu;
import PhieuThu.Services.ChiTietPhieuThuServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ChiTietPhieuThuController {
    @Autowired
    private ChiTietPhieuThuServices chiTietPhieuThuServices;

    @RequestMapping(value = "themdanhsachchitietphieu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String themChiTietPhieuThu(@RequestBody List<ChiTietPhieuThu> list, @RequestParam int idPhieuThu) {
        return chiTietPhieuThuServices.themChiTietPhieuThu(list, idPhieuThu);
    }

}
