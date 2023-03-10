package dto.request;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostRequestDto {
    private String text;
    private String photo;
    private UUID userId;
    private List<UUID> comments;
    private List<UUID>views;
    private Date date;
}
