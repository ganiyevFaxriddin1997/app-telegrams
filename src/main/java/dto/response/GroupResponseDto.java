package dto.response;

import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class GroupResponseDto {

    private List<UUID> postsId;
    private String link;
    private String name;
    private String photo;
    private String bio;
}
