package tq.spring.pjt_controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tq.spring.pjt_command.BoardCommand;
import tq.spring.pjt_command.BoardDeleteCommand;
import tq.spring.pjt_command.BoardListCommand;
import tq.spring.pjt_command.BoardModifyCommand;
import tq.spring.pjt_command.BoardViewCommand;
import tq.spring.pjt_command.BoardWriteCommand;
import tq.spring.pjt_util.jdbcTemp;
import tq.spring.pjt_util.transactionTemp;

@Controller
public class BoardController {
	
	BoardCommand command;
	
	private JdbcTemplate jdbctemp;
	private TransactionTemplate transactiontemp;
	
	//Autowired ������̼��� ��������� �ۼ��Ѵ�. Autowired ������̼��� ��ü�� �޼ҵ���
	//�տ� ��������� �ۼ��ߴٸ� �ش� ��ü�� DI�� �ޱ� ���� setter �޼ҵ带 �ۼ��ؼ� ����� �ʿ䰡 ����.
	
	@Autowired 	
	public void setTemplate(JdbcTemplate jdbctemp){
		this.jdbctemp=jdbctemp;
		jdbcTemp.jdbctemp=this.jdbctemp;
	}
	@Autowired
	public void settransactiontemp(TransactionTemplate transactiontemp){
		this.transactiontemp=transactiontemp;
		transactionTemp.transactiontemp=this.transactiontemp;	
	}
	
	//����Ʈ ������
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list()");
		
		command=new BoardListCommand();
		command.execute(model);
	
		return "list";
	}
	//�� ������
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model){
		System.out.println("view()");
		
		model.addAttribute("request",request);
		command=new BoardViewCommand();
		command.execute(model);
		
		return "view";
	}
	//�ۼ� �������� �̵�
	@RequestMapping("/writeView")
	public String writeView(Model model){
		System.out.println("writeView()");
		
		return "write";
	}
	
	//�ۼ� ������
	@RequestMapping(method=RequestMethod.POST, value="/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command=new BoardWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	//���� �������� �̵�
	@RequestMapping("/modifyView")
	public String modifyView(HttpServletRequest request, Model model){
		System.out.println("modifyView()");
		
		model.addAttribute("request",request);
		command=new BoardViewCommand();
		command.execute(model);
		
		return "modify";
	}
	
	//���� ������	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command=new BoardModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	//���� ������
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command=new BoardDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
