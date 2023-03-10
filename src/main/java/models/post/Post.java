package models.post;

import lombok.*;
import models.BaseModel;
import models.user.User;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Post extends BaseModel {
    private String text;
    private String photo;
    private User user;
    private List<Post> comments;
    private List<User>views;
    private Date date;
}
