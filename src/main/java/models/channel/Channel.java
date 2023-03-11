package models.channel;

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
public class Channel extends BaseModel {

    private String photo;
    private String bio;
    private String link;
    private List<Post> posts;
    private String name;
}
