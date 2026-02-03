package csembstu.alamgir.crud.request;

import csembstu.alamgir.crud.dto.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotNull
    private Gender gender;

}
