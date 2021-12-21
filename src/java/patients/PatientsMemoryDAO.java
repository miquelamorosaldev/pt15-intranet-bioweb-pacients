/*
 * We used this Java Patters to design this class:
 * DAO 
 * https://www.oscarblancarteblog.com/2018/12/10/data-access-object-dao-pattern/
 * Singleton 
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#lazy-initialization
 */
package patients;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne
 */
public class PatientsMemoryDAO implements IPatientsDAO{
    
    private static List<Patient> patients;

    public PatientsMemoryDAO() {
        if (patients == null) {
            patients = new ArrayList<>();
            patients.add(
                new Patient("Flavio","Larrea Ayala","gen-man","A",'+',165,80));
            patients.add(
                new Patient("Débora","Aramburu Galvez","gen-wom","O",'+',170,70));
            patients.add(
                new Patient("Albano","Danilo Pla Gallo","gen-oth","AB",'-',180,71));
            patients.add(
                new Patient("Dorothy","Vaughan","gen-wom","B",'+',172,75));
            patients.add(
                new Patient("Mary","Jackson","gen-wom","A",'+',164,60));
            patients.add(
                new Patient("George","Mendel","gen-man","AB",'+',160,60));
        }
    }
    
    
    @Override
    public List<Patient> listAllPatients() {
        return patients;
    }

    @Override
    public boolean addPatient(Patient patient) {
        // NOTA: Pending to validate Patient if exist or not.
        return patients.add(patient);
    }
    
    public List<Patient> listWomanPatients() {
        // List which will contain woman patients only. 
        List<Patient> womanPatients = new ArrayList<>();
        // gen-wom, gen-man, or gen-oth.
        for (Patient patient : patients) {
            if (patient.getGender().equals("gen-wom")) {
                womanPatients.add(patient);
            }
        }
        return womanPatients;
    }
    
}
