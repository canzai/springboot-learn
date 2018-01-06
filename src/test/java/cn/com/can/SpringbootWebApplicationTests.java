package cn.com.can;

import cn.com.can.domain.Person;
import cn.com.can.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebApplicationTests {

	@Autowired
	private Student student;

	@Autowired
	private Person person;
	@Test
	public void contextLoads() {
//		System.out.println("测试多环境配置：" + student.getName() + "" + student.getAge());
		System.out.println("测试多环境配置：" + person.getName() + "" + person.getAge());
	}

}
