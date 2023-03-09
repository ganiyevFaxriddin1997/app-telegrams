package services.group;

import dto.request.GroupRequestDto;
import dto.response.GroupResponseDto;
import models.group.Group;

import java.util.List;
import java.util.UUID;

public class GroupServiceImp implements GroupService {

    @Override
    public boolean create(GroupRequestDto groupRequestDto) {
        return false;
    }

    @Override
    public GroupResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<GroupResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, GroupRequestDto groupRequestDto) {
        return false;
    }

    @Override
    public List<Group> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<Group> data) {
        return false;
    }

    @Override
    public Group getEntity(UUID id) {
        return null;
    }
}