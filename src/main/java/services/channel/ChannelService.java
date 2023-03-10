package services.channel;

import dto.request.ChannelRequestDto;
import dto.response.ChannelResponseDto;
import models.channel.Channel;
import services.BaseService;

import java.util.UUID;

public interface ChannelService extends
        BaseService<ChannelRequestDto, UUID, ChannelResponseDto, Channel> {
}
