package models.groupUser;

import enums.Role;
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
    private Role role;
    private UUID userId;
    private UUID groupId;
}
