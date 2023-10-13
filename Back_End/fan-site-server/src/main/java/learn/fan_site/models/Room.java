package learn.fan_site.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @NotBlank(message = "Room color required.")
    private String roomColor;

    @NotBlank(message = "Room style required.")
    private String roomStyle;

    @NotBlank(message = "Room type required.")
    private String roomType;

    @URL(message = "Valid room image URL required.")
    @NotBlank(message = "Room image URL required.")
    private String imageUrl;
}