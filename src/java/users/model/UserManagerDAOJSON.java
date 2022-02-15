package users.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;

/**
 *
 * @author amoros
 */
public class UserManagerDAOJSON implements IUserDAO {
    
    String path;
    
    public UserManagerDAOJSON (String path) {
        this.path = path;
    }
    
    @Override
    public boolean login (String username, String password) {
        boolean exists = false;
        // Referencia:
        // https://es.stackoverflow.com/questions/140363/leer-json-con-gson-en-java
        JsonParser parser = new JsonParser();
        try {
            // /home/alumne/NetBeansProjects/pt15-intranet-bioweb-pacients-2022/web/WEB-INF/users.json
            Object obj = parser.parse(
                       new FileReader("/home/alumne/NetBeansProjects/pt15-intranet-bioweb-pacients-2022/web/WEB-INF/users.json"));

               JsonObject jsonObject = (JsonObject) obj;
               System.out.println("JSON LEIDO: " + jsonObject);

               JsonArray jsonArray = (JsonArray) jsonObject.get("Usuarios");
            // User u = new User();
//            for (int i = 0; i < jsonArray.size(); i++) {
//                User u = (User) jsonArray.get(i);
//            }
                
           } catch (FileNotFoundException ex) {
               Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {   
             Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            }   
        // TODO.
        return exists;
    }
    
    @Override
    public boolean logout (String username) {
        return false;
    }

    @Override
    public Object getRole(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> listAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}