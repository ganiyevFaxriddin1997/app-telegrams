package services.channel;

import dto.request.ChannelRequestDto;
import dto.response.ChannelResponseDto;
import models.channel.Channel;

import java.util.List;
import java.util.UUID;

public class ChannelServiceImp implements ChannelService{
    @Override
    public boolean create(ChannelRequestDto channelRequestDto) {
        return false;
    }

    @Override
    public ChannelResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<ChannelResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, ChannelRequestDto channelRequestDto) {
        return false;
    }

    @Override
    public List<Channel> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<Channel> data) {
        return false;
    }

    @Override
    public Channel getEntity(UUID id) {
        return null;
    }
}
