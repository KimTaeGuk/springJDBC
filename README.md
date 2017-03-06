#### 보안이란?
- **크리덴셜 기반 인증** : 우리가 웹에서 사용하는 대부분의 인증방식입니다. 즉 권한을 부여받는데 1차례의 인증과정이 필요하며 대개 사용자명과 비밀번호를 입력받아 입력한 비밀번호가 저장된 비밀번호화 일치하는지 확인합니다. (일반적으로 스프링 시큐리티에서는 **아이디를 프린시플(principle)**, **비밀번호를 크리덴셜(credential)**이라고 부르기도 합니다.)

- **이중 인증** : 한 번에 2가지 방식으로 인증을 받는 것을 말합니다. 예를 들어 금융, 은행 웹 어플리케이션을 이용해 온라인 거래를 하실 때에는 로그인과 보안 인증서, 2가지 방법으로 인증을 받곤 합니다. 별 것 아닌 것 같지만 Authentication이 하나 추가됨으로서 프로그래밍 적으로 변화해야할 부분은 상당히 광범위해집니다.

- **물리 인증** : 이 부분은 웹을영역을 벗어난 것이지만 가장 효과적인 보안 수단 중에 하나입니다. 예를 들어 컴퓨터를 킬 때 지문을 인식받는다거나 키를 삽입해야하는 것들 말입니다.
