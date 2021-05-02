package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		log.info("-----------");
		log.info(boardMapper.getList());
	}

	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("test 테스트");
		vo.setContent("content 콘텐츠");
		vo.setWriter("writer 라이터");
		
		boardMapper.insert(vo);
		
		log.info("------------------");
		log.info("after insert" +vo.getBno());
		
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("aaatest 테스트");
		vo.setContent("aaacontent 콘텐츠");
		vo.setWriter("aaawriter 라이터");
		
		boardMapper.insertSelectKey(vo);
		log.info("------------------");
		log.info("after insertSelectKey" +vo.getBno());
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(9L);
		log.info(vo);
		
	}
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(1L);
		log.info(count);
	}

	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(9L);
		vo.setTitle("Update Title");
		vo.setContent("update contetn");
		vo.setWriter("user00");
		
		log.info("count:"+ boardMapper.update(vo) );
	}
	
}
