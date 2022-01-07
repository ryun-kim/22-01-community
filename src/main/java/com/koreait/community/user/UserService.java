package com.koreait.community.user;

import com.koreait.community.UserUtils;
import com.koreait.community.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserUtils userUtils;


    public int idChk(String uid){
        UserEntity entity = new UserEntity();
        entity.setUid(uid);

        UserEntity result = mapper.selUser(entity);

        return result == null ? 1 : 0; //아이디가 있으면 리턴 1, 없으면 리턴 0
    }

    public int join(UserEntity entity){
        UserEntity copyEntity = new UserEntity();
        try{//회원가입 후 바로 로그인
            //copyEntity = (UserEntity) BeanUtils.cloneBean(entity);
            BeanUtils.copyProperties(entity, copyEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        String hashedPw = BCrypt.hashpw(copyEntity.getUpw(),BCrypt.gensalt());
        copyEntity.setUpw(hashedPw);
        return mapper.insUser(copyEntity);
        /*
        String originPw = entity.getUpw();
        String hashPw = BCrypt.hashpw(originPw, BCrypt.gensalt());
        entity.setUpw(hashPw);
        int result = mapper.insUser(entity);
        entity.setUpw(originPw);
        return result;
         */
    }

    public int login(UserEntity entity){
        UserEntity login = null;
        try{
            login =mapper.selUser(entity);
        }catch (Exception e){
            e.printStackTrace();
            return 0; //알수없는 에러 발생
        }
        if(login == null){
            return 2; //아이디 없음
        }else if(!BCrypt.checkpw(entity.getUpw(), login.getUpw())){
            return 3; // 비밀번호 틀림
        }
        login.setUpw(null);
        login.setMdt(null);     //세션에 넣을때 메모리상 퍼포먼스를 위해
        login.setRdt(null);
        userUtils.setLoginUser(login);
        return 1; // 로그인 성공
    }
}
