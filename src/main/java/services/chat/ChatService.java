package services.chat;

import dto.request.ChatRequestDto;
import dto.response.ChatResponseDto;
import models.chat.Chat;
import services.BaseService;

import java.util.UUID;

public interface ChatService extends
        BaseService<ChatRequestDto, UUID, ChatResponseDto, Chat> {
}
