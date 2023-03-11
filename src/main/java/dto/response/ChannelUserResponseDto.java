package dto.response;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor@NoArgsConstructor@Getter@Setter@Builder
public class ChannelUserResponseDto {

    private UUID userId;
    private UUID channelId;
}
