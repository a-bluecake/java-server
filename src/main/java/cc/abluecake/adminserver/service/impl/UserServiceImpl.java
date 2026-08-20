package cc.abluecake.adminserver.service.impl;

import cc.abluecake.adminserver.entity.User;
import cc.abluecake.adminserver.mapper.UserMapper;
import cc.abluecake.adminserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
