package dto.request;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class ChannelUserRequestDto {
    private String role;
    private UUID userId;
    private UUID channelId;
}
