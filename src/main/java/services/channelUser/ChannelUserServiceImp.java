package services.channelUser;

import dto.request.ChannelUserRequestDto;
import dto.response.ChannelUserResponseDto;
import models.channelUser.ChannelUser;

import java.util.List;
import java.util.UUID;

public class ChannelUserServiceImp implements ChannelUserService {

    @Override
    public boolean create(ChannelUserRequestDto channelUserRequestDto) {
        return false;
    }

    @Override
    public ChannelUserResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<ChannelUserResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, ChannelUserRequestDto channelUserRequestDto) {
        return false;
    }

    @Override
    public List<ChannelUser> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<ChannelUser> data) {
        return false;
    }

    @Override
    public ChannelUser getEntity(UUID id) {
        return null;
    }
}