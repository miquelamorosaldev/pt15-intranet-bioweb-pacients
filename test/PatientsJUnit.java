/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import patients.IPatientsDAO;
import patients.Patient;
import patients.PatientsMemoryDAO;

/**
 *
 * @author alumne
 */
public class PatientsJUnit {
    
    IPatientsDAO daoPatients;
    
    public PatientsJUnit() {
        daoPatients = new PatientsMemoryDAO();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testListDefaultPatients() {
        int expectedNumPatients = 3;
        String expectedNameFirstPatient = "Flavio";
        List<Patient> resultList = daoPatients.listAllPatients();
        assertEquals(expectedNumPatients, resultList.size());
        assertEquals(expectedNameFirstPatient, resultList.get(0).getName());
    }
}
