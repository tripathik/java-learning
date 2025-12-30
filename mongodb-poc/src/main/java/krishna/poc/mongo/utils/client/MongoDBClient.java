package krishna.poc.mongo.utils.client;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public final class MongoDBClient {

    private static final MongoClient CLIENT;
    private static final MongoDatabase DATABASE;

    static {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(
                        PojoCodecProvider.builder()
                                .automatic(true)
                                .build()
                )
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(
                        new com.mongodb.ConnectionString("mongodb://localhost:27017/intelliguru")
                )
                .codecRegistry(pojoCodecRegistry)
                .build();

        CLIENT = MongoClients.create(settings);
        DATABASE = CLIENT.getDatabase("intelliguru");
    }

    private MongoDBClient() {}

    public static MongoDatabase getDatabase() {
        return DATABASE;
    }
}

