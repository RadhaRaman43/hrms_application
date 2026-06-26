package com.example.hrms.repository.user_repo;

import com.example.hrms.Modals.user.Menu;

import java.util.List;

public interface MenuRepository {
    // Get all menus for a specific role
    List<Menu> findByRoleRoleIdAndIsActiveTrueOrderByMenuOrder(Long roleId);
}
