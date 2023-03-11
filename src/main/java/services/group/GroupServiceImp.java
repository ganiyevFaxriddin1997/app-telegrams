package services.group;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.GroupRequestDto;
import dto.response.GroupResponseDto;
import dto.response.UserResponseDto;
import enums.Role;
import models.group.Group;
import models.post.Post;
import models.user.User;
import org.modelmapper.ModelMapper;
import services.post.PostService;
import services.post.PostServiceImp;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupServiceImp implements GroupService {
    static final PostService postService = new PostServiceImp();
    static ModelMapper modelmapper = new ModelMapper();
    static Gson gson;
    static File file;

    @Override
    public boolean create(GroupRequestDto groupRequestDto) {
        if (groupRequestDto == null) return false;
            Group group = new Group();
            modelmapper.map(groupRequestDto, group);
        if (groupRequestDto.getMessages() != null) {
            for (UUID message : groupRequestDto.getMessages()) {
                group.getMessages().add(postService.getEntity(message));
            }
        }
        var groups = getData();
        if (groups == null)
            groups = new ArrayList<>();
        groups.add(group);
        return writeData(groups);
    }

    @Override
    public GroupResponseDto get(UUID id) {
        var list = getList();
        if (list != null) {
            for (GroupResponseDto responseDto : list) {
                if (responseDto.getId().equals(id))
                    return responseDto;
            }
        }
        return null;
    }

    @Override
    public List<GroupResponseDto> getList() {
        var data = getData();
        List<GroupResponseDto> groups = null;
        if (data != null) {
            groups = new ArrayList<>();
            for (Group group : data) {
                var responseDto = modelmapper.map(group, GroupResponseDto.class);
                if (group.getMessages() != null) {
                    for (Post message : group.getMessages()) {
                        responseDto.getMessages().add(message.getId());
                    }
                }
                responseDto.setId(group.getId());
                groups.add(responseDto);
            }
        }
        return groups;
    }

    @Override
    public boolean delete(UUID id) {
        var group = getEntity(id);
        if (group != null) {
            var groups = getData();
            groups.remove(group);
            return writeData(groups);
        }
        return false;
    }

    @Override
    public boolean update(UUID id, GroupRequestDto groupRequestDto) {
        var group = getEntity(id);
        if (group != null && groupRequestDto != null) {
            var groups = getData();
            groups.remove(group);
            modelmapper.map(groupRequestDto, group);
            if (groupRequestDto.getMessages() != null) {
                for (UUID message : groupRequestDto.getMessages()) {
                    group.getMessages().add(postService.getEntity(message));
                }
            }
            groups.add(group);
            return writeData(groups);
        }
        return false;
    }

    @Override
    public List<Group> getData() {
        File file = new File("data/groups.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Group> groups;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<Group>>(){}.getType();
            groups = gson.fromJson(bufferedReader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    @Override
    public boolean writeData(List<Group> data) {
        File file = new File("data/groups.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            var json = gson.toJson(data);
            bufferedWriter.write(json);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public Group getEntity(UUID id) {
        var groups = getData();
        if (groups != null) {
            for (Group group : groups) {
                if (group.getId().equals(id))
                    return group;
            }
        }
        return null;
    }
}