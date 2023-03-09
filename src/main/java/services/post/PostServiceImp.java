package services.post;

import dto.response.PostResponseDto;

import java.util.List;
import java.util.UUID;

public class PostServiceImp implements PostService{
    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public Object get(Object id) {
        return null;
    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean update(Object id, Object o) {
        return false;
    }

    @Override
    public List getData() {
        return null;
    }

    @Override
    public boolean writeData(List data) {
        return false;
    }

    @Override
    public Object getEntity(Object id) {
        return null;
    }

    @Override
    public PostResponseDto getPost(UUID channelId, UUID userId) {
        return null;
    }
}
