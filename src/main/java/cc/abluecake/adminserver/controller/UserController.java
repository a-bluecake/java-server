package cc.abluecake.adminserver.controller;

import cc.abluecake.adminserver.entity.User;
import cc.abluecake.adminserver.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping()
    public String add(@RequestBody User user){
        return "用户新增成功";
    }
    /**
     * 查询所有用户
     * @return
     */
    @GetMapping()
    public List<User> getAll(){
        return userMapper.selectList(null);
    }
    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id){
        return "查询单个用户成功";
    }
    /**
     * 修改一个用户
     * @param id
     * @param user 此user里面建议不含id，避免目标混乱
     * @return
     */
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody User user){
        return "修改用户成功";
    }

    /**
     * 删除一条用户
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id){
        return "删除用户成功";
    }
    /**
     * 分页查询用户
     * @param current 当前页码（从1开始）
     * @param size 每页的行数
     * @return
     */
    @GetMapping("/{current}/{size}")
    public List<User> getPage(@PathVariable Long current, @PathVariable Long size){
        return userMapper.selectPage(new Page<User>(current, size), null).getRecords();
    }

}
