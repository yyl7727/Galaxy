package com.zxy.galaxy.Config.Shiro;

import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Mapper.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    RoleMapper roleMapper;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        //根据用户id获取用户角色
        List<String> roleIds = userRoleMapper.selectRolesByUserName(user.getUuid());
        List<String> roles = roleMapper.selectRolesByRoleIds(roleIds);
        //根据用户角色获取角色对应权限
        List<String> permissions = rolePermissionMapper.selectPermsByRoles(roleIds);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userMapper.findUserByUsername(userName);
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), super.getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        return info;
    }
}
