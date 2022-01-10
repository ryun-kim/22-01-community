package com.koreait.community.board;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BoardService {

    @Autowired
    public BoardMapper mapper;

    @Autowired
    private UserUtils userUtils;

    public int insBoard(BoardEntity entity){
        entity.setIuser(userUtils.getLoginUserPK());
        return mapper.insBoard(entity);
    }

    public List<BoardVO> selBoardList(BoardDTO dto){
        return mapper.selBoardList(dto);
    }

    public BoardVO selBoardDetail(BoardDTO dto){
        BoardVO detail = mapper.selBoardDetail(dto);
        if(!Objects.equals(dto.getLastip(), detail.getLastip())){
            int hitsResult = mapper.addHits(dto);
            if(hitsResult ==1){
                detail.setHits(detail.getHits()+1);
            }
            mapper.updBoard(dto);
        }
        return detail;
    }

    public int delBoard(BoardEntity entity){ // icategory, iboard
        entity.setIuser(userUtils.getLoginUserPK());
        entity.setIsdel(1);
        return mapper.updBoard(entity); // icategory, iboard, iuser, isdel
    }
}
