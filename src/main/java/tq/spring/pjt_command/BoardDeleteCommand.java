package tq.spring.pjt_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import tq.spring.pjt_dao.BoardDao;

public class BoardDeleteCommand implements BoardCommand{
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		new BoardDao().delete(num);
		//아이디가 같지 않을 시 삭제 못하도록 할 것
	}
}
