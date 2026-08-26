package cc.abluecake.adminserver.controller;

import cc.abluecake.adminserver.common.Result;
import cc.abluecake.adminserver.entity.User;
import cc.abluecake.adminserver.service.UserService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
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
    @SaCheckPermission("user.add")
    public Result add(@RequestBody User user){
        return Result.success(userService.save(user));
    }
    /**
     * 查询所有用户
     * @return
     */
    @GetMapping()
    @SaCheckPermission("user.get")
    public Result getAll(){
        return Result.success(userService.list());
    }
    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @SaCheckPermission("user.get")
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
    @SaCheckPermission("user.update")
    public Result update(@PathVariable Long id, @RequestBody User user){
        return Result.success(userService.updateById(user));
    }
    /**
     * 删除一条用户
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    @SaCheckPermission("user.delete")
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
    @SaCheckPermission("user.get")
    public Result getPage(@RequestParam(defaultValue = "1" ) Integer pageNum, @RequestParam(defaultValue = "10" ) Integer pageSize, @RequestParam(defaultValue = "" ) String name){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if(!"".equals(name) && name!=null){
            queryWrapper.eq(User::getName,name);
        }
        return Result.success(userService.page(new Page<User>(pageNum,pageSize),queryWrapper));
    }

    //Sa-Token管理接口
    // 测试登录
    @RequestMapping("doLogin")
    public Result doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("a-bluecake".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return Result.success();

        }
        return Result.error("登录失败");
    }
    // 查询登录状态
    @RequestMapping("isLogin")
    public Result isLogin() {
        return Result.success("当前会话是否登录：" + StpUtil.isLogin());
    }
    // 前后端分离登录接口
    @RequestMapping("getLoginInfo")
    public Result getLoginInfo(String username, String password) {
        if("a-bluecake".equals(username) && "123456".equals(password)) {
            // 第1步，先登录上
            StpUtil.login(10001);
            // 第2步，获取 Token  相关参数
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            // 第3步，返回给前端
            return Result.success(tokenInfo);
        }
        return Result.error("登录失败");
    }

}
