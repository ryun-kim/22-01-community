package com.koreait.community.board;

import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVO> selBoardList(BoardDTO dto);

    BoardVO selBoardDetail(BoardDTO dto);

    int insBoard(BoardEntity entity);

    int addHits(BoardDTO dto);

    int updBoard(BoardEntity entity);
}
