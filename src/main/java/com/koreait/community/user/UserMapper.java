package com.koreait.community.user;

import com.koreait.community.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserEntity selUser(UserEntity entity);

    int insUser(UserEntity entity);

}
