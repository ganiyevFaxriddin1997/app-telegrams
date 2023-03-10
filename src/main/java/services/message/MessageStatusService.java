package services.message;

import dto.request.MessageStatusRequestDto;
import dto.response.MessageStatusResponseDto;
import models.messageStatus.MessageStatus;
import services.BaseService;

import java.util.UUID;

public interface MessageStatusService extends
        BaseService<MessageStatusRequestDto, UUID, MessageStatusResponseDto, MessageStatus> {

    MessageStatusResponseDto getMessage(UUID userId, UUID postId);
}
