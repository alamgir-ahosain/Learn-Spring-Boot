package mbstucse.alamgir.rediscache.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import mbstucse.alamgir.rediscache.dto.Gender;

@Data
@AllArgsConstructor
public class StudentRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotNull
    private Gender gender;

}
