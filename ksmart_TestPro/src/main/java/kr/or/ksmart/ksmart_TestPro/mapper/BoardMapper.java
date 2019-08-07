package kr.or.ksmart.ksmart_TestPro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_TestPro.vo.Board;

@Mapper
public interface BoardMapper {
	public int addBoard(Board board);
	public List<Board> boardList(Map<String, Object> map);
	public int boardListCount();
}
