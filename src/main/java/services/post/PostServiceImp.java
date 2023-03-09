package services.post;

import dto.request.PostRequestDto;
import dto.response.PostResponseDto;
import models.post.Post;

import java.util.List;
import java.util.UUID;

public class PostServiceImp implements PostService {

    @Override
    public boolean create(PostRequestDto postRequestDto) {
        return false;
    }

    @Override
    public PostResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<PostResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, PostRequestDto postRequestDto) {
        return false;
    }

    @Override
    public List<Post> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<Post> data) {
        return false;
    }

    @Override
    public Post getEntity(UUID id) {
        return null;
    }

    @Override
    public PostResponseDto getPost(UUID channelId, UUID userId) {
        return null;
    }
}