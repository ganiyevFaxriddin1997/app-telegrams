package models.messageStatus;

import enums.ReadStatus;
import lombok.*;
import models.BaseModel;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MessageStatus extends BaseModel {
    private UUID postId;
    private UUID userId;
    private ReadStatus status;
}
