package com.koreait.community.board;

import com.koreait.community.model.BoardDto;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardPrevNextVo;
import com.koreait.community.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVo> selBoardList(BoardDto dto);

    BoardVo selBoard(BoardDto dto);

    BoardPrevNextVo selPrevNext(BoardVo vo);

    int insBoard(BoardEntity entity);

    int addHits(BoardEntity dto);

    int updBoard(BoardEntity entity);
}
