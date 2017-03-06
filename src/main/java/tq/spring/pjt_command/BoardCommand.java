package tq.spring.pjt_command;

import org.springframework.ui.Model;

public interface BoardCommand {
	
	//모델(model)이란? 
	//컨트롤러에 의해 비지니스 로직이 수행되고 나면 대체로 사용자에게 반환되어 브라우저에 표시될 정보가 만들어진다.
	//이런 정보를 모델(model)이라 한다. 이 정보를 보통 JSP에 해당하는 뷰로 보낸다.
	void execute(Model model);
}
