
package users.model;

/**
 *
 * @author mamorosal
 */
public interface IUserDAO {
    
    /**
     * Detects if the username and the password are in the users database.
     * @param username
     * @param password
     * @return true if the username and password exists
     */
    public boolean login (String username, String password);
    
    /**
     * Log out the user session.
     * @param username
     * @return true if the user has been logged out.
     */
    public boolean logout (String username);
}