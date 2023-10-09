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

/*
@NotNull - Used to ensure that the annotated element is not null.
@Size - Specifies the size or length constraints for a string, collection, or array.
For example, @Size(min = 2, max = 50) specifies that the annotated string, collection, or array must have a size between 2 and 50 (inclusive).
@Min and @Max - Specifies the minimum and maximum values for a numeric element.
For example, @Min(18) ensures that the annotated numeric element is greater than or equal to 18.
@Pattern - Used to specify a regular expression pattern that the annotated string must match.
For example, @Pattern(regexp = "[a-zA-Z0-9]+") specifies that the annotated string must consist of alphanumeric characters.
@Email - Ensures that the annotated string is a valid email address.
@Future and @Past - Used to validate that a date is in the future or in the past, respectively.
@AssertTrue and @AssertFalse - Used to ensure that the annotated element is true or false, respectively.
@NotEmpty - Ensures that a collection or array is not null and not empty.
*/