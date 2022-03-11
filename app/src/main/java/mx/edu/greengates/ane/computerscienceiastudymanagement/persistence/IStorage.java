package mx.edu.greengates.ane.computerscienceiastudymanagement.persistence;

import java.io.IOException;

import mx.edu.greengates.ane.computerscienceiastudymanagement.model.StudyManagement;

public interface IStorage {
    public void updateManagementData(StudyManagement management) throws IOException;
    public StudyManagement getManagementData() throws IOException;
}
