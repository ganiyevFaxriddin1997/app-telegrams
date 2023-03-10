package models.groupUser;

import lombok.*;
import models.BaseModel;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GroupUser extends BaseModel {
    private UUID userId;
    private UUID groupId;
}
