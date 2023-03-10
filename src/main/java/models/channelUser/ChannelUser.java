package models.channelUser;

import lombok.*;
import models.BaseModel;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChannelUser extends BaseModel {
    private UUID userId;
    private UUID channelId;
}
