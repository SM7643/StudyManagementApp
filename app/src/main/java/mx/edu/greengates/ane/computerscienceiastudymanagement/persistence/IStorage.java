import java.io.IOException;

public interface IStorage {
    public void updateManagementData(StudyManagement management) throws IOException;
    public StudyManagement getManagementData() throws IOException;
}
