package com.mystore.dataProvider;

import com.mystore.utility.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataProvidersLib {

    ExcelLibrary ELObj = new ExcelLibrary();

    @DataProvider(name = "credentials")
    public Object[][] getEmailData(){

        int totalRows = ELObj.getRowCount("Credentials");
        int totalColumns = ELObj.getColumnCount("Credentials");
        int actualRows = totalRows - 1;
        Object[][] data = new Object[actualRows][totalColumns];

        for(int i=0; i< actualRows; i++)
        {
            for(int j=0; j<totalColumns; j++){
                data[i][j]= ELObj.getCellData("Credentials", j, i+2);
            }
        }

        return data;

    }
}
