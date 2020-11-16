package com.zxy.galaxy.Config.Shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 自定义域
     * @return
     */
    @Bean
    public MyRealm myRealm(HashedCredentialsMatcher credentialsMatcher) {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    /**
     * shiro过滤器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        Map<String, String> resourcesMap = new LinkedHashMap<>();
        resourcesMap.put("/login","anon");
        resourcesMap.put("/subLogin","anon");
        resourcesMap.put("/css/**","anon");
        resourcesMap.put("/js/**","anon");
        resourcesMap.put("/images/**","anon");
        resourcesMap.put("/logout","logout");
        resourcesMap.put("/admin", "roles[admin]");//拥有admin角色才能够访问
        resourcesMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(resourcesMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 密码匹配器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }
}
