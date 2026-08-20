package cc.abluecake.adminserver.controller;

import cc.abluecake.adminserver.common.Result;
import cc.abluecake.adminserver.entity.User;
import cc.abluecake.adminserver.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody User user){
        return Result.success(userService.save(user));
    }
    /**
     * 查询所有用户
     * @return
     */
    @GetMapping()
    public Result getAll(){
        return Result.success(userService.list());
    }
    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getOne(@PathVariable Long id){
        return Result.success(userService.getById(id));// getOne方法可以自定义条件查询
    }
    /**
     * 修改一个用户
     * @param id
     * @param user 使用此user里面的id，直接传入的id作为冗余设计
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody User user){
        return Result.success(userService.updateById(user));
    }
    /**
     * 删除一条用户
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    public Result delete(@PathVariable Long id){
        return Result.success(userService.removeById(id));
    }
    /**
     * 分页查询用户
     * @param pageNum 当前页码（从1开始）
     * @param pageSize 每页的行数
     * @param name 查询条件
     * @return
     */
    @GetMapping("/page")
    public Result getPage(@RequestParam(defaultValue = "1" ) Integer pageNum, @RequestParam(defaultValue = "10" ) Integer pageSize, @RequestParam(defaultValue = "" ) String name){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if(!"".equals(name) && name!=null){
            queryWrapper.eq(User::getName,name);
        }
        return Result.success(userService.page(new Page<User>(pageNum,pageSize),queryWrapper));
    }
}
