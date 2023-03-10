package models.group;

import lombok.*;
import models.BaseModel;
import models.post.Post;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Group extends BaseModel {
    private List<Post> messages;
    private String link;
    private String name;
    private String photo;
    private String bio;
}
