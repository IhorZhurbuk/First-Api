import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;



public class GitHubClient {

    public void getMostStarRepo(String since, String until) throws IOException {


        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder url = new URIBuilder()
                .setScheme("https")
                .setHost("api.github.com")
                .setPath("/search/repositories")
                .addParameter("q", "stars:>1000")
                .setParameter("q", "created:" + since + ".." + until)
                .addParameter("sort", "stars")
                .addParameter("order", "desc")
                .addParameter("per_page", "10");

        HttpGet httpGet = new HttpGet(url.toString());
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String jsonString = EntityUtils.toString(response.getEntity());


        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray items = jsonObject.getJSONArray("items");

        for (Object itr : items) {
            JSONObject itemJsonObject = (JSONObject) itr;

            String name = (String) itemJsonObject.get("full_name");
            System.out.println(name);
            int stars = (Integer) itemJsonObject.get("stargazers_count");
            System.out.println(stars);
            String description = (String) itemJsonObject.get("description");
            System.out.println(description);
            System.out.println("-----------------------------");

        }
    }
}
