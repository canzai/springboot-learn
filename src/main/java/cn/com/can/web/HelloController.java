package cn.com.can.web;

import cn.com.can.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Controller:修饰class  用来穿件处理http请求的对象
 * @RestController：原来在@Controller中返回json需要@ResonseBody结合使用才可以。
 * @RequestMapping ：配置url映射
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/errorJson")
    public String errorJson() throws MyException {
        throw new MyException("获取json出现异常");
    }
}
