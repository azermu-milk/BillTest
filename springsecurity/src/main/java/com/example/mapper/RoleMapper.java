package com.example.mapper;

import com.example.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by Administrator on 2020/3/6.
 */
@Repository
public interface RoleMapper {
    List<Role> getRoleByUid(int id);

    void setRole(int role, int uid);
}
