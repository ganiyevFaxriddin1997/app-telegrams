package services.groupUser;

import dto.request.GroupUserRequestDto;
import dto.response.GroupResponseDto;
import dto.response.GroupUserResponseDto;
import models.groupUser.GroupUser;
import services.group.GroupService;

import java.util.List;
import java.util.UUID;

public class GroupUserServiceImp implements GroupUserService {

    @Override
    public boolean create(GroupUserRequestDto groupUserRequestDto) {
        if (groupUserRequestDto != null) {

        }
        return false;
    }

    @Override
    public GroupUserResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<GroupUserResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, GroupUserRequestDto groupUserRequestDto) {
        return false;
    }

    @Override
    public List<GroupUser> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<GroupUser> data) {
        return false;
    }

    @Override
    public GroupUser getEntity(UUID id) {
        return null;
    }

    @Override
    public GroupResponseDto getGroup(String link) {
        return null;
    }
}
