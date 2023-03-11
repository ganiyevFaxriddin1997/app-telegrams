package services.groupUser;

import dto.request.GroupUserRequestDto;
import dto.response.GroupResponseDto;
import dto.response.GroupUserResponseDto;
import models.groupUser.GroupUser;
import services.BaseService;

import java.util.UUID;

public interface GroupUserService extends
        BaseService<GroupUserRequestDto, UUID, GroupUserResponseDto, GroupUser> {

}
