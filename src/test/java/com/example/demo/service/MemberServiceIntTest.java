package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hello.domain.User;
import com.example.demo.hello.repository.UserRepository;
import com.example.demo.hello.service.UserService;


@SpringBootTest
@Transactional
class MemberServiceIntTest {
	
	@Autowired UserService service;
	@Autowired UserRepository repository;
	
	@Test
	void 회원가입() {
		//given 
		User user = new User();
		user.setId("Test");
		user.setName("테스터");
		user.setPassword("1234");
		
		//when
		String saveId = service.join(user);
		
		//then
		User findMember = service.findOne(saveId).get();
		assertThat(user.getName()).isEqualTo(findMember.getName());
		
	}
	
	@Test
	 public void 중복_회원_예외() throws Exception {
		 //Given
		 User user1 = new User();
		 user1.setName("spring");
		 User user2 = new User();
		 user2.setName("spring");
		 
	     //When
		 service.join(user1);
		 IllegalStateException e = assertThrows(IllegalStateException.class,
		 () -> service.join(user2));//예외가 발생해야 한다.
		 assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
		
	
	@Test
	void 회원찾기() {
		
	}
	

}
