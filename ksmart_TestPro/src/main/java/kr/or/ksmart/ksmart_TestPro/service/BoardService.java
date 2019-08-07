package kr.or.ksmart.ksmart_TestPro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.ksmart_TestPro.mapper.BoardMapper;
import kr.or.ksmart.ksmart_TestPro.vo.Board;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public int addBoard(Board board) {
		return boardMapper.addBoard(board);
	}
	
	// 헤더에서 게시판 글쓰기 클릭하면 실행되는 메소드
	public Map<String, Object> boardList(int currentPage) {
		
		final int ROW_PER_PAGE = 10;
		// 페이지를 구성할 행의 갯수
		
		int startPageNum = 1;
		// 보여줄 시작 페이지
		
		int lastPageNum = ROW_PER_PAGE;
		// 보여줄 페이지 번호의 갯수 초기화
		
		// 6번째일 때 2,3,4,5,[6],7,8,9,10,11
		// 7번째일 때 3,4,5,6,[7],8,9,10,11,12
		// 즉, 6이나 7이 가운데에 올 수 있게 한다.
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage - ((lastPageNum/2)-1);
			lastPageNum += (startPageNum-1);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		
		map.put("startRow", startRow);
		map.put("RowPerPage", ROW_PER_PAGE);
		
		double boardCount = boardMapper.boardListCount();
		
		int lastPage = (int)(Math.ceil(boardCount)/ROW_PER_PAGE);
		
		if(currentPage >= (lastPage-4)) {
			lastPageNum = lastPage;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", boardMapper.boardList(map));
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}
	
	// 게시판에서 검색어 입력 후 검색하기 버튼 누르면 실행되는 메소드
	public List<Board> boardList(String sk, String sv) {
		int startPage = 0;
		// 시작 페이지
		
		final int row_per_Page = 10;
		// 한 페이지에 보여줄 최대 페이지 수
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startPage", startPage);
		map.put("perPage", row_per_Page);
		map.put("sk", sk);
		map.put("sv", sv);
		
		return boardMapper.boardList(map);
	}
}
