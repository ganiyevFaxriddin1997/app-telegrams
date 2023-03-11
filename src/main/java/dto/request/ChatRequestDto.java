package dto.request;

import lombok.*;
import models.post.Post;
import models.user.User;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class ChatRequestDto {

    private UUID user1Id;
    private UUID user2Id;
    private List<UUID> postsId;
}
