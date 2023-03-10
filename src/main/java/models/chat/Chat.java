package models.chat;

import lombok.*;
import models.BaseModel;
import models.post.Post;
import models.user.User;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Chat extends BaseModel {
    private User user1;
    private User user2;
    private List<Post> messages;
}
