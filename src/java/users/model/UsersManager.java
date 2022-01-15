package users.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Modulo de autenticación de usuarios provisional.
 * @author tarda
 */
public class UsersManager {
    
    private Map<String,User> users;
    
    public UsersManager() {
        users = new HashMap<>();
        users.put("dawbio2",
            new User("dawbio2","admin",Role.ADMIN));
        users.put("prof",
            new User("prof","admin",Role.ADMIN));
        users.put("dawbio1",
            new User("dawbio1","alumne",Role.USER));
        users.put("daw2",
            new User("daw2","alumne",Role.USER));
        users.put("dam2",
            new User("dam2","alumne",Role.USER));
        users.put("asix2",
            new User("asix2","alumne",Role.USER));
    }
    
    public boolean isValidUser(String username, String password) {
        // Existe nombre de usuario ?
        boolean exists = users.containsKey(username);
        User dbUser;
        String pwForm = "";
        // Contraseña correcta ? 
        if(exists) {
            dbUser = users.get(username);
            pwForm = dbUser.getPassword();
        }
        return exists && password.equals(pwForm);
    }
    
    public String getRole(String username) {
        // Existe nombre de usuario ?
        boolean exists = users.containsKey(username);
        // Contraseña correcta ? 
        User dbUser = users.get(username);
        Role role = dbUser.getRole();
        return role.toString();
    }
}
