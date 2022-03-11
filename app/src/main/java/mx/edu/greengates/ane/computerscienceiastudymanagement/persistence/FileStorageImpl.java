import java.io.*;

public class FileStorageImpl implements IStorage {


    private static File MANAGEMENT_DATA = new File(
            System.getProperty("user.home"),
            "management.txt"
    );

    @Override
    public void updateManagementData(StudyManagement management) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(MANAGEMENT_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(management);
            objectOutputStream.close();

        } catch (IOException e){
            throw new IOException("Unable to access Game Data.");
        }
    }

    @Override
    public StudyManagement getManagementData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(MANAGEMENT_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try{
            StudyManagement management = (StudyManagement) objectInputStream.readObject();
            objectInputStream.close();
            return management;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            throw new IOException("File not Found");
        }
    }
}



