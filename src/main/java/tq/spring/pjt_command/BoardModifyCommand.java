package tq.spring.pjt_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import tq.spring.pjt_dao.BoardDao;

public class BoardModifyCommand implements BoardCommand{
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
	
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		BoardDao dao=new BoardDao();
		dao.modify(num, title, content);
	}
}
