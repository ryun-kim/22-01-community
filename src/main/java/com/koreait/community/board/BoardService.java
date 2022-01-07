package com.koreait.community.board;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    public BoardMapper mapper;

    @Autowired
    private UserUtils userUtils;

    public List<BoardVO> selBoardList(BoardDTO dto){
        return mapper.selBoardList(dto);
    }

    public int insBoard(BoardEntity entity){
        entity.setIuser(userUtils.getLoginUserPK());
        return mapper.insBoard(entity);
    }
}
