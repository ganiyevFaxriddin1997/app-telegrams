package services.channelUser;

import dto.request.ChannelUserRequestDto;
import dto.response.ChannelUserResponseDto;
import models.channelUser.ChannelUser;
import services.BaseService;

import java.util.UUID;

public interface ChannelUserService extends
        BaseService<ChannelUserRequestDto, UUID, ChannelUserResponseDto, ChannelUser> {
}
