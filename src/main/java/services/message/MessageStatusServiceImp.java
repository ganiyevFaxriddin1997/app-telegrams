package services.message;

import dto.request.MessageStatusRequestDto;
import dto.response.MessageStatusResponseDto;
import models.messageStatus.MessageStatus;

import java.util.List;
import java.util.UUID;

public class MessageStatusServiceImp implements MessageStatusService{
    @Override
    public boolean create(MessageStatusRequestDto messageStatusRequestDto) {
        return false;
    }

    @Override
    public MessageStatusResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<MessageStatusResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, MessageStatusRequestDto messageStatusRequestDto) {
        return false;
    }

    @Override
    public List<MessageStatus> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<MessageStatus> data) {
        return false;
    }

    @Override
    public MessageStatus getEntity(UUID id) {
        return null;
    }

    @Override
    public MessageStatusResponseDto getMessage(UUID userId, UUID postId) {
        return null;
    }
}
