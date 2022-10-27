import java.io.FileInputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();

        properties.load(new FileInputStream("src/App.properties"));

        //System.out.println(properties.getProperty("URL"));
        //System.out.println(properties.getProperty("senha"));
        
        String URL = properties.getProperty("URL");
        PessoaService service = new PessoaService(URL);
        service.listar();
    }
}
