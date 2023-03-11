package services.group;

import dto.request.GroupRequestDto;
import dto.response.GroupResponseDto;
import models.group.Group;
import services.BaseService;

import java.util.UUID;

public interface GroupService extends BaseService<GroupRequestDto, UUID, GroupResponseDto, Group> {



}
