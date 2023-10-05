package learn.fan_site.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

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