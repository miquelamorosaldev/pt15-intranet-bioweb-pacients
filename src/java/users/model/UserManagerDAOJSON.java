package users.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.ParseException;
import users.model.IUserDAO;


/**
 *
 * @author alumne
 */
public class UserManagerDAOJSON implements IUserDAO {
    
    @Override
    public boolean login (String username, String password) {
        // Referencia:
        // https://es.stackoverflow.com/questions/140363/leer-json-con-gson-en-java
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(
                       new FileReader("usuarios.json"));

               JsonObject jsonObject = (JsonObject) obj;
               System.out.println("JSON LEIDO: " + jsonObject);

               JsonArray array = (JsonArray) jsonObject.get("Usuarios");
               System.out.println("");
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {   
             Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            }   
        // TODO.
        return false;
    }
    
    @Override
    public boolean logout (String username) {
        return false;
    }

    @Override
    public Object getRole(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}