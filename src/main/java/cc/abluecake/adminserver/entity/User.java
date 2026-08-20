package cc.abluecake.adminserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName("`user`")
@Data
@NoArgsConstructor
@AllArgsConstructor
// 实体类不推荐使用基本类型，推荐使用包装类，当没有传值时默认赋null，用作区分
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy‑MM‑dd HH:mm:ss")
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy‑MM‑dd HH:mm:ss")
    private LocalDateTime updateTime;
}
