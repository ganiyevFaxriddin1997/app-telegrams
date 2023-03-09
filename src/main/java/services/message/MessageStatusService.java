package services.message;

import dto.response.MessageStatusResponseDto;
import services.BaseService;

import java.util.UUID;

public interface MessageStatusService extends BaseService {

    MessageStatusResponseDto getMessage(UUID userId, UUID postId);
}
