package com.guoguo.knowledge.service.user;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PageUtil;
import com.guoguo.knowledge.dao.user.UserDao;
import com.guoguo.knowledge.entity.user.User;
import com.guoguo.knowledge.constant.user.UserConstant;
import com.guoguo.knowledge.common.DataJson;
import com.guoguo.knowledge.common.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 按id查询用户
     *
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    /**
     * 按id删除用户
     *
     * @param userList
     * @return
     */
    public ResultJson deleteUserByIds(List<User> userList) {
        int rows = userDao.deleteUserByIds(userList);
        if (rows > 0) {
            return ResultJson.yes(UserConstant.YES);
        }
        return ResultJson.no(UserConstant.NO);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    public ResultJson saveUser(User user) {
        if (ObjectUtil.isNotNull(user.getId())) {
            // 修改用户
            int rows = userDao.updateUserById(user);
            if (rows > 0) {
                return ResultJson.yes(UserConstant.YES);
            }
        } else {
            // 添加用户
            int rows = userDao.addUser(user);
            if (rows > 0) {
                return ResultJson.yes(UserConstant.YES);
            }
        }
        return ResultJson.no(UserConstant.NO);
    }

    /**
     * 分页查询用户
     *
     * @param user
     * @return
     */
    public DataJson getUserList(User user) {
        // 查询分页页数
        int[] ints = PageUtil.transToStartEnd(user.getPage() - 1, user.getLimit());
        user.setPage(ints[0]);
        user.setLimit(ints[1]);
        List<User> list = userDao.getUserList(user);
        // 查询总页数
        Integer totalCount = userDao.getUserListCount(user);
        int totalPage = PageUtil.totalPage(totalCount, user.getLimit());

        return DataJson.list(totalPage, list);
    }
}
