package dto.request;

import lombok.*;
import models.post.Post;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class GroupRequestDto {
    private UUID id;
    private List<UUID> messages;
    private String link;
    private String name;
    private String photo;
    private String bio;
}
