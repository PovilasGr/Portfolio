import  com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DuomenuNuskaitymas {

    public Preke nuskaitytiVienaPreke(String fileName) {
        Preke p = new Preke();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Preke.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8"); // StandardCharsets.UTF_8

            Gson gson = new GsonBuilder().create();
            p = gson.fromJson(reader, Preke.class);
            
            reader.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public ArrayList<Pirkinys> nuskaitytiVisusPirkinius(String fileName) {
        
        ArrayList<Pirkinys> sarasas = new ArrayList();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Pirkiniai.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new GsonBuilder().create();
            //sarasas = gson.fromJson(reader, (new ArrayList<Pirkinys>()).getClass());  // nesuveiks
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
            //sarasas = gson.fromJson(reader, (new HashMap<Integer,Preke>()).getClass()); // nesuveiks
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

    
    
    
    
    
   public ArrayList<Preke> nuskaitytiVisasPrekes(String fileName) {
        
        ArrayList<Preke> sarasas = new ArrayList();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Prekes.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new GsonBuilder().create();
            sarasas = gson.fromJson(reader, new TypeToken<ArrayList<Preke>>(){}.getType()); 
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
   
    // Tinka nuskaityti bet kokio tipo viena irasa
    public Object nuskaitytiViena(String fileName, Type type) {
        Object p = new Object();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Preke.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8"); // StandardCharsets.UTF_8

            Gson gson = new GsonBuilder().create();
            p = gson.fromJson(reader, type);
            
            reader.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    /*
        // arba trumpiau:
        try(Reader reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            Object p = gson.fromJson(reader, type);
            System.out.println(p);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    // Tinka nuskaityti bet kokio tipo masyva
    public ArrayList nuskaitytiVisus(String fileName, Type type) {
        
        ArrayList sarasas = new ArrayList();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Prekes.json");
            Reader  reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new GsonBuilder().create();
            sarasas = gson.fromJson(reader, type); 
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
    
    
    public HashMap<Integer,Object> nuskaitytiVisasHM(String fileName, Type type) {
        
        HashMap<Integer,Object> sarasas = new HashMap();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);  //("./Json_files/Prekes.json");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new GsonBuilder().create();
            sarasas = gson.fromJson(reader, type); 
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
