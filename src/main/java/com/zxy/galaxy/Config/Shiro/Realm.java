package com.zxy.galaxy.Config.Shiro;

import com.zxy.galaxy.Common.Util.JwtUtils;
import com.zxy.galaxy.Entity.User;
import com.zxy.galaxy.Service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Realm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Token token = (Token) authenticationToken;
        String username = jwtUtils.getClamiByToken(token.getPrincipal().toString()).getSubject();
        User user = userService.findUserByUsername(username);
        if(user == null) {
            throw new UnknownAccountException("账户不存在");
        }else if(user.getStatus() == -1){
            throw new LockedAccountException("账户已失效");
        }
        Profile profile = new Profile();
        BeanUtils.copyProperties(user, profile);
        return new SimpleAuthenticationInfo(profile, token.getCredentials(), getName());
    }
}
