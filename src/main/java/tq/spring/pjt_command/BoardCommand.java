package tq.spring.pjt_command;

import org.springframework.ui.Model;

public interface BoardCommand {
	
	//��(model)�̶�? 
	//��Ʈ�ѷ��� ���� �����Ͻ� ������ ����ǰ� ���� ��ü�� ����ڿ��� ��ȯ�Ǿ� �������� ǥ�õ� ������ ���������.
	//�̷� ������ ��(model)�̶� �Ѵ�. �� ������ ���� JSP�� �ش��ϴ� ��� ������.
	void execute(Model model);
}
