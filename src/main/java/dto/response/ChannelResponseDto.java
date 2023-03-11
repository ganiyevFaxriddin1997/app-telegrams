package dto.response;

import lombok.*;
import models.post.Post;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class ChannelResponseDto {

    private String photo;
    private String bio;
    private String link;
    private List<Post> posts;
    private String name;
    private List<UUID> usersId;
}
