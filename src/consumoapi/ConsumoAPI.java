/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumoapi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Leandro
 */
public class ConsumoAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            
            URL url = new URL("https://reqres.in/api/users/2");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Ocorreu um erro" + responseCode);
                
            } else{
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                
                while(scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }
                
                scanner.close();
                
                System.out.println(informationString);
                System.out.println("\n\n\n");
                
                
                JSONArray s = new JSONArray(informationString.toString());
                JSONObject k = s.getJSONObject(0);
                System.out.println(k.getString("data"));
                
                
            }
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}
