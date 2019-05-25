package mflix;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.SslSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    String welcomeMessage =
        ""
            + "\n"
            + " __          __  _                            _          __  __ ______ _ _      \n"
            + " \\ \\        / / | |                          | |        |  \\/  |  ____| (_)     \n"
            + "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___   | \\  / | |__  | |___  __\n"
            + "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |\\/| |  __| | | \\ \\/ /\n"
            + "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |  | | |    | | |>  < \n"
            + "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_|  |_|_|    |_|_/_/\\_\\\n"
            + "                                                                                \n"
            + "                                                                                \n"
            + "     ^\n"
            + "   /'|'\\\n"
            + "  / \\|/ \\\n"
            + "  | \\|/ |\n"
            + "   \\ | /\n"
            + "    \\|/\n"
            + "     |\n"
            + "                       \n";
    System.out.println(welcomeMessage);

    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString("mongodb+srv://m220student:m220password@mflix-rl49j.mongodb.net/test?retryWrites=true")).build();
    MongoClient mongoClient = MongoClients.create(settings);
    SslSettings sslSettings = settings.getSslSettings();
    ReadPreference readPreference = settings.getReadPreference();
    ReadConcern readConcern = settings.getReadConcern();
    WriteConcern writeConcern = settings.getWriteConcern();
    System.out.println(sslSettings.isInvalidHostNameAllowed());
    System.out.println(sslSettings.isEnabled());
    System.out.println(readPreference.toString());
    System.out.println(readConcern.asDocument().toString());
    System.out.println(writeConcern.asDocument().toString());
  }
}
