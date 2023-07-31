import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DuomenuNuskaitymas {

    public ArrayList<Pirkinys> nuskaitytiVisusPirkinius(String fileName) {
        
        ArrayList<Pirkinys> sarasas = new ArrayList();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Pirkiniai.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new GsonBuilder().create();
            sarasas = gson.fromJson(reader, new TypeToken<ArrayList<Pirkinys>>(){}.getType());
            reader.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sarasas;
    }
    
    public HashMap<Integer,Preke> nuskaitytiVisasPrekesHM(String fileName) {
        
        HashMap<Integer,Preke> sarasas = new HashMap();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/PrekesHM.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new GsonBuilder().create();
            sarasas = gson.fromJson(reader, new TypeToken<HashMap<Integer,Preke>>(){}.getType());
            reader.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sarasas;
    }

}
