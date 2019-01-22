package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVo;

public interface BoardDao {
	public void insertBoard(@Param("boardVo")BoardVo boardVo);
	List<BoardVo> getBoards();
}
