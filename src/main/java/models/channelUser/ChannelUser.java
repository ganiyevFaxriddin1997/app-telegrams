package models.channelUser;

import enums.Role;
import lombok.*;
import models.BaseModel;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChannelUser extends BaseModel {
    private Role role;
    private UUID userId;
    private UUID channelId;
}
