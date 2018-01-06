package cn.com.can.web;

import cn.com.can.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    static Map<Integer, User> Users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>(Users.values());
        return users;
    }

    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute User user) {
        Users.put(user.getId(), user);
        return Users.size() + "";
    }

    //paramType = "path": 从Swagger2文本框中获取值赋值给参数id
    @ApiOperation(value = "根据id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/getUse/{id}", method = RequestMethod.GET)
    public User getUse(@PathVariable Integer id) {
        return Users.get(id);
    }

    @ApiOperation(value = "根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Integer id, @ModelAttribute User user) {
        User us = Users.get(id);
        us.setName(user.getName());
        us.setAge(user.getAge());
        Users.put(id, us);
        return "success";
    }

    @ApiOperation(value = "根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        Users.remove(id);
        return "success";
    }

}
