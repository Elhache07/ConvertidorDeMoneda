package Api;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {
    public Tasas buscarTasa(String divisaOrigen,String divisaDestino,double valor){
        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/722b7c5ead3d4902fd29a506/latest/" + divisaOrigen+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson=new Gson();
            Tasas tasas=gson.fromJson(response.body(),Tasas.class);

            Double tasaCoversion= tasas.conversion_rates().get(divisaDestino);

            if (tasaCoversion == null) {
                throw new RuntimeException("No se encontro la tasa para "+divisaDestino);

            }
            double resultado=valor*tasaCoversion;
            System.out.println("El valor "+valor+" ["+divisaOrigen+"] corresponde al valor final de =>>> "+resultado+" ["+divisaDestino+"]");
            return new Tasas(tasas.conversion_rates());

        } catch (Exception e) {
            throw new RuntimeException("No encontre Tasas");
        }


    }

}
