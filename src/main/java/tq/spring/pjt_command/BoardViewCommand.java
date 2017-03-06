package tq.spring.pjt_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import tq.spring.pjt_dao.BoardDao;
import tq.spring.pjt_dto.BoardDto;

public class BoardViewCommand implements BoardCommand{
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardDao dao=new BoardDao();
		BoardDto dto=dao.view(num);
		
		model.addAttribute("dto", dto);
	}
}
