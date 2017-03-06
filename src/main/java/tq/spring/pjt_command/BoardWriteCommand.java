package tq.spring.pjt_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import tq.spring.pjt_dao.BoardDao;

public class BoardWriteCommand implements BoardCommand{
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		System.out.println("BoardWirteCommand");
		
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		BoardDao dao=new BoardDao();
		
		dao.write(id, title, content);
	}
}
