package services.post;

import dto.request.PostRequestDto;
import dto.response.PostResponseDto;
import models.post.Post;
import services.BaseService;

import java.util.UUID;

public interface PostService extends BaseService<PostRequestDto, UUID, PostResponseDto, Post> {

    PostResponseDto getPost(UUID channelId, UUID userId);
}
