package mbstucse.alamgir.n_mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User {

    @Id
    private Integer id;   // MongoDB _id

    private String name;
    private Integer age;
    private String email;

    public Integer getId() {  return id;  }
    public void setId(Integer id) {this.id = id;}
    public String getName() {   return name;}
    public void setName(String name) {     this.name = name; }
    public Integer getAge() {    return age;}
    public void setAge(Integer age) {    this.age = age;}
    public String getEmail() {  return email;  }
    public void setEmail(String email) {   this.email = email;}
}
