package dto.response;

import enums.ReadStatus;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MessageStatusResponseDto {
    private UUID id;
    private UUID postId;
    private UUID userId;
    private String readStatus;
}
