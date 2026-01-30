package Controlleur;

import java.util.Map;

import mg.miniframework.annotation.Authorized;
import mg.miniframework.annotation.Controller;
import mg.miniframework.annotation.FormParam;
import mg.miniframework.annotation.GetMapping;
import mg.miniframework.annotation.JsonUrl;
import mg.miniframework.annotation.PostMapping;
import mg.miniframework.annotation.RequireRole;
import mg.miniframework.annotation.Secured;
import mg.miniframework.annotation.SessionVariables;
import mg.miniframework.annotation.UrlMap;
import mg.miniframework.modules.ModelView;
import mg.miniframework.modules.security.Role;

@Controller
public class TestSecurityController {

    private SimpleAuthenticationProvider authProvider;

    @GetMapping
    @UrlMap(value = "/login")
    public ModelView loginPage() {
        ModelView modelView = new ModelView();
        modelView.setView("login.jsp");
        return modelView;
    }

    @PostMapping
    @JsonUrl
    @UrlMap(value = "/login")
    public ModelView login(@FormParam(name = "email", required = false) String email,
            @FormParam(name = "password", required = false) String password,
            @SessionVariables Map<String, Object> sessionVariables) {
        ModelView modelView = new ModelView();
        modelView.setData("password", email);
        modelView.setData("email", password);

        sessionVariables.put("user_connected", "blablabla");

        Role role = new Role();
        role.setName("ADMIN");

        Role[] roles = new Role[] {
                role
        };

        sessionVariables.put("user_role", roles);
        return modelView;
    }

    @GetMapping
    @UrlMap(value = "/authorized")
    @Secured
    public ModelView testAuthorized() {
        ModelView modelView = new ModelView();
        modelView.setView("authorized.jsp");
        return modelView;
    }

    @GetMapping
    @UrlMap(value = "/role")
    @RequireRole(value = { "ADMIN" })
    public ModelView testRole() {
        ModelView modelView = new ModelView();
        modelView.setView("role.jsp");
        return modelView;
    }
}