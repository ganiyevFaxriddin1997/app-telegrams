package services.post;

import dto.response.PostResponseDto;
import services.BaseService;

import java.util.UUID;

public interface PostService extends BaseService {

    PostResponseDto getPost(UUID channelId, UUID userId);
}
