package mbstucse.alamgir.rediscache.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbstucse.alamgir.rediscache.dto.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private Gender gender;


}
