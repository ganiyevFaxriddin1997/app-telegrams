package dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class UserRequestDto {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String photo;
    private String bio;
    private String role;
    private String username;
}
