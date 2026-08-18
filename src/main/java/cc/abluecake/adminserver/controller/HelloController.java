package cc.abluecake.adminserver.controller;

import cc.abluecake.adminserver.entity.User;
import org.springframework.web.bind.annotation.*;

// 该类用作练习接口创建
@RestController
public class HelloController {
    /**
     * Get接口，使用?传参
     */
    @GetMapping("/hello")
    public String hello1(@RequestParam String name) {
        return "Hello " + name;
    }
    /**
     * Get接口，使用路径传参
     */
    @GetMapping("/hello/{name}")
    public String hello2(@PathVariable String name) {
        return "Hello " + name;
    }
    /**
     * Post接口，使用json请求体传参
     */
    @PostMapping("/hello")
    public String hello3(@RequestBody User user) {
        return "Hello " + user.getName();
    }
}

