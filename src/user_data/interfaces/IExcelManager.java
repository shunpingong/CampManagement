package src.user_data.interfaces;

import java.util.ArrayList;

public interface IExcelManager {
    public ArrayList<String> readXL();
    public void updateXL(ArrayList<String> userData);
}
