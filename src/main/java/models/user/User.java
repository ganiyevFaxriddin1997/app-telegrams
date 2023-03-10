package models.user;

import enums.Role;
import lombok.*;
import models.BaseModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User extends BaseModel {
    private String name;
    private String lastName;
    private String Password;
    private String phoneNumber;
    private String username;
    private Role role;
    private String photo;
    private String bio;
}
