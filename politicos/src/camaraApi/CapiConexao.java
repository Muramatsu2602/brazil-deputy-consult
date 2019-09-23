
package camaraApi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CapiConexao {
    private static String URL_API = "https://dadosabertos.camara.leg.br/api/v2/deputados";
    private static CapiConexao instance;
    
    private CloseableHttpClient HTTPclient;
    
    CapiConexao(){
        this.HTTPclient = HttpClients.createDefault();
    }
    
    public static CapiConexao getInstance() {
        if(instance == null){
            instance = new CapiConexao();
        }
        return instance;
    }
    
    public String getInfo(String path){
        String responseBody = "";
        try{
            HttpGet HttpGet = new HttpGet("https://dadosabertos.camara.leg.br/api/v2/deputados/"+path);
            
            //ResponseHandler -> serve para manipular a resposta vinda da api, mostrando-nos o resultado de nosso pedido(e não apenas o código dele)
            ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("status error: "+ status);
                    }
                }
            };
            responseBody = this.HTTPclient.execute(HttpGet, responseHandler);
            System.out.println("------------------------------------------------------------");
        }
        catch(IOException e){
            Logger.getLogger(CapiConexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return responseBody;
    }
    public String getInfo(){
        String responseBody = "";
        String path = "?ordem=ASC&ordenarPor=nome";
        try{
            HttpGet HttpGet = new HttpGet(CapiConexao.URL_API+path);
            
            //ResponseHandler -> serve para manipular a resposta vinda da api, mostrando-nos o resultado de nosso pedido(e não apenas o código dele)
            ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("status error: "+ status);
                    }
                }
            };
            responseBody = this.HTTPclient.execute(HttpGet, responseHandler);
            System.out.println("------------------------------------------------------------");
        }
        catch(IOException e){
            Logger.getLogger(CapiConexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return responseBody;
    }
   /*  public String getPartidos(){
    //    String URL_API = "https://dadosabertos.camara.leg.br/api/v2/partidos";
        String responseBody = "";
       // String path = "?ordem=ASC&ordenarPor=sigla";
        try{
            HttpGet HttpGet = new HttpGet("https://dadosabertos.camara.leg.br/api/v2/partidos?ordem=ASC&ordenarPor=sigla");
            
            //ResponseHandler -> serve para manipular a resposta vinda da api, mostrando-nos o resultado de nosso pedido(e não apenas o código dele)
            ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("status error: "+ status);
                    }
                }
            };
            responseBody = this.HTTPclient.execute(HttpGet, responseHandler);
            System.out.println("------------------------------------------------------------");
        }
        catch(IOException e){
            Logger.getLogger(CapiConexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return responseBody;
    }*/
}
