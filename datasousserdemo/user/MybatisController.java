package com.example.datasousserdemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多数据源解决分布式事务测试
 *      Controller
 * @author yys
 */
@RestController
@RequestMapping("/add")
public class MybatisController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private OrderService orderService;

    /**
     * 新增用户并生成订单(解决分布式事务问题)
     * @return
     */
    @RequestMapping("/user")
    public String addUser(String name, Integer age, Double amount, String address) {
        return userService.addUser(name, age, amount, address) ? "success" : "fail";
    }

}