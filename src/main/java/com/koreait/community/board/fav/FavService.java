package com.koreait.community.board.fav;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardFavEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavService {
    @Autowired
    private FavMapper Mapper;
    @Autowired
    private UserUtils userUtils;

    public int insBoardFav(BoardFavEntity entity){
        entity.setIuser(userUtils.getLoginUserPK());
        return Mapper.insBoardFav(entity);
    }

    public BoardFavEntity selBoardFav(int iboard){
        return Mapper.selBoardFav(createBoardFavEntity(iboard));
    }

    public int delBoardFav(int iboard){
        return Mapper.delBoardFav(createBoardFavEntity(iboard));
    }

    private BoardFavEntity createBoardFavEntity(int iboard){
        BoardFavEntity entity = new BoardFavEntity();
        entity.setIboard(iboard);
        entity.setIuser(userUtils.getLoginUserPK());
        return entity;
    }
}
