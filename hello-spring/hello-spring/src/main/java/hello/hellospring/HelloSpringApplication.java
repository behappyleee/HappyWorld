package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
// Spring Boot
/*
*	스프링 부트는 웹브라우저에서 --> 내장 톰캣 서버 -->
*	스프링은 model.addAttirubte하여 값을 넘겨줌
*	HelloController 에서 return hello를 해줌 (hello.html template 안에 hello.html을 찾음)
*	Thymeleaft 템플릿 엔진 처리를 해 줌
*	컨트롤러에서 리턴 값으로 문자를 반환하면 View Resolver가 화면을 찾아서 처리
*	resources templates / + ViewName + .html
*
*
*
* */