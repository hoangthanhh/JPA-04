package PhieuThu.Controller;

import PhieuThu.Models.NguyenLieu;
import PhieuThu.Services.NguyenLieuServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class NguyenLieuController {
    @Autowired
    NguyenLieuServices nguyenLieuServices;

    @RequestMapping(value = "them1nguyenlieu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public NguyenLieu themNguyenLieu(@RequestBody  String nguyenLieu) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        NguyenLieu nL = gson.fromJson(nguyenLieu,NguyenLieu.class);
        return nguyenLieuServices.themNguyenLieu(nL);
    }
}
