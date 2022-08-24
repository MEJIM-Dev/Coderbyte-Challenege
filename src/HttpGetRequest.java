import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetRequest {
    public static void HttpGetRequest() throws URISyntaxException, IOException, InterruptedException{
        URI uri= new URI("https://coderbyte.com/api/challenges/json/rest-get-simple");
        HttpRequest conn = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpClient req = HttpClient.newBuilder().build();
        HttpResponse<String> res = req.send(conn,HttpResponse.BodyHandlers.ofString());

        String hobbies = res.body()
                .split("hobbies")[1]
                .replace("}","")
                .split("]")[0]
                .replace("[","")
                .replace(":","")
                .replace("\"","")
                .replace(",",", ");

        String myChalTok = "ghv78zxnaf1:";
        myChalTok+=hobbies;

        char[] ans = myChalTok.toCharArray();
        String finalAns ="";

        for(int i=ans.length-1;i>=0;i--){
            finalAns+=ans[i];
        }
        System.out.println(
                finalAns
        );
    }
}
