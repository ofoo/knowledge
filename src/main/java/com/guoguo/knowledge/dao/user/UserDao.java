package com.guoguo.knowledge.dao.user;

import com.guoguo.knowledge.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @param user
     * @return
     */
    List<User> getUserList(User user);

    /**
     * 按id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(@Param("id") Long id);

    /**
     * 按id删除用户
     *
     * @param userList
     * @return
     */
    int deleteUserByIds(List<User> userList);

    /**
     * 根据id修改用户
     *
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 查询用户总数
     *
     * @param user
     * @return
     */
    Integer getUserListCount(User user);
}
