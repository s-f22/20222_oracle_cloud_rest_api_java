import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PessoaService {

  private HttpClient client = HttpClient.newHttpClient();
  private final String url;

  // O construtor abaixo esta sendo gerado pela Lombok, inicializado com a notação
  // de constante acima
  // public PessoaService(String url){
  // this.url = url;
  // }

  public void listar() {
    try {
      // design pattern: builder
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .build();

      // var == HttpResponse <String>
      var response = client.send(request, BodyHandlers.ofString());

      JSONObject raiz = new JSONObject(response.body());
      System.out.println(raiz);
      JSONArray items = raiz.getJSONArray("items");
      // System.out.println(items);
      JSONObject primeiro =  items.getJSONObject(0);
      System.out.println(primeiro);
      //System.out.println(response.body());
      String nome = primeiro.getString("nome");
      System.out.println(nome);

    } catch (Exception e) {
      System.out.println(e.getMessage());

      //Retorna a pilha de metodos na stack de exceptions
      e.printStackTrace();
    }
  }

}
