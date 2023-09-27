package com.jingyes.mybatispage;

import com.jingyes.mybatispage.mapper.UserMapper;
import com.jingyes.mybatispage.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlusBaseMapperTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询数据
     */
    @Test
    public void testSelectUser() {
        System.out.println(("----- 开始测试 mybatis-plus 查询数据 ------"));
        //  selectList() 方法的参数为 mybatis-plus 内置的条件封装器 Wrapper，这里不填写表示无任何条件，全量查询
        List<User> userList = userMapper.selectList(null);

        userList.forEach(System.out::println);
    }

    /**
     * 新增一条数据
     */
    @Test
    public void testInsertUser() {
        System.out.println(("----- 开始测试 mybatis-plus 插入数据 ------"));
        User user = User.builder()
                .name("犬小哈教程 www.quanxiaoha.com")
                .age(30)
                .gender(1)
                .build();

        userMapper.insert(user);
    }

    /**
     * 删除数据
     */
    @Test
    public void testDeleteUser() {
        System.out.println(("----- 开始测试 mybatis-plus 删除数据 ------"));
        // 根据主键删除记录
        userMapper.deleteById(1);

        // 根据主键批量删除记录
        userMapper.deleteBatchIds(Arrays.asList(1, 2));
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdateUser() {
        System.out.println(("----- 开始测试 mybatis-plus 更新数据 ------"));
        User user = User.builder()
                .id(1L)
                .name("犬小哈教程 www.quanxiaoha.com")
                .build();

        userMapper.updateById(user);
    }
}