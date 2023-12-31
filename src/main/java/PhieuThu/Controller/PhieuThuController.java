package PhieuThu.Controller;

import PhieuThu.Models.PhieuThu;
import PhieuThu.Services.PhieuThuServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PhieuThuController {
    @Autowired
    private PhieuThuServices phieuThuServices;

    @RequestMapping(value = "themphieuthu", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String themPhieuThu(@RequestBody String phieuThu) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        PhieuThu pt = gson.fromJson(phieuThu, PhieuThu.class);
        return phieuThuServices.themPhieuThu(pt);
    }

    @RequestMapping(value = "xoaphieuthu", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void xoaPhieuThu(@RequestParam int phieuThuId) {
        phieuThuServices.xoaPhieuThu(phieuThuId);
    }

    @RequestMapping(value = "layphieuthutheothoigian", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhieuThu> layPhieuThuTheoTG(@RequestParam int thang) {
        return phieuThuServices.layPhieuThuTheoTG(thang);
    }
}
