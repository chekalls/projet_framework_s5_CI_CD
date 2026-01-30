package Controlleur;

import mg.miniframework.modules.security.AuthenticationProvider;
import mg.miniframework.modules.security.RolePermissionLoader;
import mg.miniframework.modules.security.User;

public class SimpleAuthenticationProvider implements AuthenticationProvider {

    private RolePermissionLoader rolePermissionLoader;

    public void setRolePermissionLoader(RolePermissionLoader loader) {
        this.rolePermissionLoader = loader;
    }

    @Override
    public User authenticate(String username, String password) {
        
        if ("admin".equals(username) && "admin123".equals(password)) {
            User user = createUserWithConfiguredRoles(username, "ADMIN");
            return user;
        }
        
        if ("user".equals(username) && "user123".equals(password)) {
            User user = createUserWithConfiguredRoles(username, "USER");
            return user;
        }
        
        if ("moderator".equals(username) && "mod123".equals(password)) {
            User user = createUserWithConfiguredRoles(username, "MODERATOR");
            return user;
        }
        
        if ("editor".equals(username) && "edit123".equals(password)) {
            User user = createUserWithConfiguredRoles(username, "EDITOR");
            return user;
        }
        
        if ("superadmin".equals(username) && "super123".equals(password)) {
            User user = createUserWithConfiguredRoles(username, "SUPER_ADMIN", "ADMIN");
            return user;
        }
        
        return null;
    }

    private User createUserWithConfiguredRoles(String username, String... roleNames) {
        User user;
        
        if (rolePermissionLoader != null) {
            user = rolePermissionLoader.createUserWithRoles(username, roleNames);
        } else {
            user = new User(username);
            for (String roleName : roleNames) {
                user.addRole(roleName);
            }
        }
        
        user.setAuthenticated(true);
        return user;
    }

    @Override
    public User loadUserByUsername(String username) {
        if ("admin".equals(username)) {
            return createUserWithConfiguredRoles(username, "ADMIN");
        }
        
        if ("user".equals(username)) {
            return createUserWithConfiguredRoles(username, "USER");
        }
        return null;
    }
}
