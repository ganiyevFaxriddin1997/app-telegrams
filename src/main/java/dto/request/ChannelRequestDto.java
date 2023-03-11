package dto.request;

import lombok.*;
import models.post.Post;
import models.user.User;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class ChannelRequestDto {
    private String photo;
    private String bio;
    private String link;
    private List<Post> posts;
    private String name;
    private List<UUID> usersId;


}
