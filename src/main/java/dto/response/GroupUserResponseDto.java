package dto.response;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class GroupUserResponseDto {
    private String role;
    private UUID userId;
    private UUID groupId;
}
