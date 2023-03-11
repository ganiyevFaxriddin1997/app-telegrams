package dto.request;

import enums.Role;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class GroupUserRequestDto {
    private String role;
    private UUID userId;
    private UUID groupId;
}
