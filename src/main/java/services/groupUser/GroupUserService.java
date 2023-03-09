package services.groupUser;

import dto.response.GroupResponseDto;
import services.BaseService;

public interface GroupUserService extends BaseService {
    GroupResponseDto getGroup(String link);
}
