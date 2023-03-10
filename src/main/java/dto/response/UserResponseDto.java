package dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponseDto {
    private UUID id;
    private String name;
    private String lastName;
    private String Password;
    private String phoneNumber;
    private String username;
    private String role;
    private String photo;
    private String bio;}
