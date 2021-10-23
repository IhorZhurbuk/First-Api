
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Metrics.start();
        GitHubClient client = new GitHubClient();
        client.getMostStarRepo("2020-04-04", "2021-04-05");
        Metrics.stop();
        Metrics.print();
    }
}
