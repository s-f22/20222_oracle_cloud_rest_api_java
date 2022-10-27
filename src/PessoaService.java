import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PessoaService {

  private HttpClient client = HttpClient.newHttpClient();
  private final String url;

  // O contrutor abaixo esta sendo gerado pela Lombok, inicialiado com a notação de constante acima
  // public PessoaService(String url){
  //   this.url = url;
  // }

  public void listar() {
    try {
      // design pattern: builder
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .build();

      // var == HttpResponse <String>
      var response = client.send(request, BodyHandlers.ofString());
      System.out.println(response.body());

    } catch (Exception e) {
      System.out.println(e.getMessage());

      //Retorna a pilha de metodos na stack de exceptions
      e.printStackTrace();
    }
  }

}
