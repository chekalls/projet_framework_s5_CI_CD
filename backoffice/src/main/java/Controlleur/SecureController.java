// package Controlleur;

// import mg.miniframework.annotation.*;
// import mg.miniframework.modules.ModelView;
// import mg.miniframework.modules.security.*;
// import mg.miniframework.modules.security.SecurityManager;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;


// @Controller(mapping = "/secure")
// public class SecureController {


//     @GetMapping
//     @UrlMap("/public")
//     @AllowAnonymous
//     public String publicRoute() {
//         return "Cette route est accessible à tous";
//     }


//     @GetMapping
//     @UrlMap("/protected")
//     @Secured
//     public String protectedRoute() {
//         return "Vous êtes authentifié !";
//     }

  
//     @GetMapping
//     @UrlMap("/admin")
//     @RequireRole("ADMIN")
//     public String adminOnly() {
//         return "Bienvenue administrateur !";
//     }

//     @GetMapping
//     @UrlMap("/users")
//     @RequireRole({"USER", "MODERATOR"})
//     public String userOrModerator() {
//         return "Vous avez accès en tant que USER ou MODERATOR";
//     }


//     @GetMapping
//     @UrlMap("/super-admin")
//     @RequireRole(value = {"ADMIN", "SUPER_ADMIN"}, requireAll = true)
//     public String superAdminOnly() {
//         return "Vous êtes super administrateur !";
//     }


//     @GetMapping
//     @UrlMap("/read")
//     @RequirePermission("READ")
//     public String readPermission() {
//         return "Vous avez la permission de lecture";
//     }

//     @PostMapping
//     @UrlMap("/delete")
//     @RequirePermission(value = {"WRITE", "DELETE"}, requireAll = true)
//     public String writeAndDelete() {
//         return "Vous avez les permissions d'écriture et suppression";
//     }

//     @PostMapping
//     @UrlMap("/login")
//     @AllowAnonymous
//     public ModelView login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
//         ModelView mv = new ModelView();
        
//         SecurityManager securityManager = (SecurityManager) request.getServletContext()
//             .getAttribute("securityManager");
        
//         if (securityManager != null) {
//             try {
//                 User user = securityManager.authenticate(username, password, request);
//                 if (user != null) {
//                     mv.setView("login-success.jsp");
//                     mv.setData("user", user);
//                 } else {
//                     mv.setView("login-failed.jsp");
//                     mv.setData("error", "Identifiants incorrects");
//                 }
//             } catch (IOException e) {
//                 mv.setView("login-error.jsp");
//                 mv.setData("error", e.getMessage());
//             }
//         } else {
//             mv.setView("login-error.jsp");
//             mv.setData("error", "SecurityManager non configuré");
//         }
        
//         return mv;
//     }

//     @GetMapping
//     @UrlMap("/logout")
//     public String logout(HttpServletRequest request) {
//         SecurityManager securityManager = (SecurityManager) request.getServletContext()
//             .getAttribute("securityManager");
        
//         if (securityManager != null) {
//             try {
//                 securityManager.logout(request);
//             } catch (IOException e) {
//                 return "Erreur lors de la déconnexion: " + e.getMessage();
//             }
//         }
        
//         return "Vous êtes déconnecté";
//     }

//     @GetMapping
//     @UrlMap("/me")
//     @Secured
//     @JsonUrl
//     public User currentUser(HttpServletRequest request) {
//         SecurityContext context = new SecurityContext(request);
//         return context.getUser();
//     }
// }
