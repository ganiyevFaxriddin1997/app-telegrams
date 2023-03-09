package services.chat;

import dto.request.ChatRequestDto;
import dto.response.ChatResponseDto;
import models.chat.Chat;

import java.util.List;
import java.util.UUID;

public class ChatServiceImp implements ChatService {

    @Override
    public boolean create(ChatRequestDto chatRequestDto) {
        return false;
    }

    @Override
    public ChatResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<ChatResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, ChatRequestDto chatRequestDto) {
        return false;
    }

    @Override
    public List<Chat> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<Chat> data) {
        return false;
    }

    @Override
    public Chat getEntity(UUID id) {
        return null;
    }
}