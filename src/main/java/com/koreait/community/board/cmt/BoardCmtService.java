package com.koreait.community.board.cmt;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardCmtEntity;
import com.koreait.community.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCmtService {

    @Autowired private UserUtils userUtils;
    @Autowired private BoardCmtMapper mapper;

    public int insBoardCmt(BoardCmtEntity entity) { //iboard, ctnt
        entity.setIuser(userUtils.getLoginUserPK()); // iboard, iuser, ctnt
        mapper.insBoardCmt(entity); //icmt, iboard, ctnt, iuser
        return entity.getIcmt();
    }

    public List<BoardCmtVo> selBoardCmtList(int iboard){
        BoardCmtEntity entity = new BoardCmtEntity();
        entity.setIboard(iboard);
        return mapper.selBoardCmtList(entity);

    }

    public int delBoardCmt(int icmt){
        BoardCmtEntity entity = new BoardCmtEntity();
        entity.setIcmt(icmt);
        entity.setIuser(userUtils.getLoginUserPK());
        return mapper.delBoardCmt(entity);

    }
}