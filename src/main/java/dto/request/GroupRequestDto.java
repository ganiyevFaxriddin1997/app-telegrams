package dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.post.Post;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupRequestDto {
    private List<UUID> messages;
    private String link;
    private String name;
    private String photo;
    private String bio;
}
