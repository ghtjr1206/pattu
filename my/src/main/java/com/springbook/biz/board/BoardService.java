package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD 기능의 메소드 구현
	
	// 글등록
	public int insertBoard(BoardVO vo);
	// 글수정
	public void updateBoard(BoardVO vo);
	// 글삭제
	public void deleteBoard(BoardVO vo);
	// 글상세 조회
	public BoardVO getBoard(BoardVO vo);
	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo);
}
