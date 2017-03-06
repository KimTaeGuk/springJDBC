package tq.spring.pjt_dao;

import tq.spring.pjt_dto.BoardDto;
import tq.spring.pjt_util.jdbcTemp;
import tq.spring.pjt_util.transactionTemp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.core.PrioritizedParameterNameDiscoverer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

//인트 배출 jdbctemp.queryForInt(sql, new Object[] {})
//스트링 배출 jdbctemp.queryForString(sql, new Object[] {}, string.calss)
//특정한 객체 반환 (new RowMapper())
//여러개의 객체 반환 .query
//update -> insert, delete, update 등등

public class BoardDao {
	
	DataSource dataSource;
	TransactionTemplate transactiontemp;
	JdbcTemplate jdbctemp;
	String sql=null;
	
	public BoardDao(){
		this.jdbctemp=jdbcTemp.jdbctemp;
		this.transactiontemp=transactionTemp.transactiontemp;
	}
	
	// 리스트 페이지
	public ArrayList<BoardDto> list(){
		System.out.println("BoardDao_List()");
		
		ArrayList<BoardDto> dto=null;
		
		sql="select * from spring_board";
		dto=(ArrayList<BoardDto>) jdbctemp.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		return dto;
	}
	
	//페이지 게시 글 번호 올려주기
	public int boardNum(){
		
		sql="select max(num) from spring_board";
		
		//Int 불러오기
		return jdbctemp.queryForInt(sql)+1;
	}
	
	
	//작성 페이지
	public void write(final String id, final String title, final String content){
		jdbctemp.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				sql="INSERT INTO spring_board(num, id, title, content, date, count) values(?,?,?,?,NOW(),0)";
				PreparedStatement pstmt=con.prepareStatement(sql);
	
				pstmt.setInt(1, boardNum());
				pstmt.setString(2, id);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				
				return pstmt;
			}
		});
	}
	
	//조회수
	public void cntUp(final int num){
		jdbctemp.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				sql="update spring_board set count=count+1 where num=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				return pstmt;
			}
		});
	}
	//뷰 페이지
	public BoardDto view(int num){
		cntUp(num);
		sql="select * from spring_board where num=?";
		
		//new Object[] num 값 집어넣기
		BoardDto dto=jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class),new Object[] {num});
		return dto;
	}
	//수정 페이지
	public void modify(final int num, final String title, final String content){
		jdbctemp.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				sql="update spring_board set title=? , content=? where num=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, num);
				
				return pstmt;
			}
		});
	}
	
	//삭제 페이지
	public void delete(final int num){
		jdbctemp.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				sql="delete from spring_board where num=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				return pstmt;
			}
		});
	}
}
