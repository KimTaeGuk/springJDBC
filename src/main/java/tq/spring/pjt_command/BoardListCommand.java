package tq.spring.pjt_command;

import org.springframework.ui.Model;

import tq.spring.pjt_dao.BoardDao;
import tq.spring.pjt_dto.BoardDto;

import java.util.ArrayList;

public class BoardListCommand implements BoardCommand{
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		System.out.println("BoardListCommand()");
		
		BoardDao dao=new BoardDao();
		ArrayList<BoardDto> dto=dao.list();
		
		model.addAttribute("list", dto);
	}
}
