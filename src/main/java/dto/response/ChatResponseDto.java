package dto.response;

import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class ChatResponseDto {

    private UUID user1Id;
    private UUID user2Id;
    private List<UUID> postsId;

}
