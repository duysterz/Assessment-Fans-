package learn.fan_site.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private int roomId;
    private String roomColor;
    private String roomStyle;
    private String roomType;
}
