package kr.green.spring.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.vo.BoardVo;


@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	private BoardDao boardDao;

	@Override
	public void register(BoardVo boardVo) {
			boardDao.insertBoard(boardVo);
	}



	@Override
	public List<BoardVo> getBoards() {
		return boardDao.getBoards();
	}




}
