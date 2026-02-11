package mbstucse.alamgir.n_mongodb.dto.request;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotNull(message = "Id is required")
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email format")
    private String email;


    public Integer getId() {return id; }
    public void setId(Integer id) {    this.id = id; }
    public String getName() {   return name;  }
    public void setName(String name) {   this.name = name;}
    public Integer getAge() {    return age; }
    public void setAge(Integer age) {    this.age = age;  }
    public String getEmail() {     return email; }
    public void setEmail(String email) {     this.email = email; }
}
