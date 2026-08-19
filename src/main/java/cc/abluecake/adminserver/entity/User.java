package cc.abluecake.adminserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;// 实体类不推荐使用基本类型，推荐使用包装类，当没有传值时默认赋null，用作区分
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("`user`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
