package dto.request;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class GroupUserRequestDto {

    private UUID userId;
    private UUID groupId;
}
