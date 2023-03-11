package dto.request;

import enums.ReadStatus;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class MessageStatusRequestDto {

    private UUID postId;
    private UUID userId;
    private String status;
}
