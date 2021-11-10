package hu.uni.miskolc.teszteles2021;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import hu.uni.miskolc.testeles.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles2021.dao.AutoDao;
import hu.uni.miskolc.teszteles2021.exception.RendszamNemMegfelelo;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static com.mongodb.client.model.Filters.eq;


import java.util.ArrayList;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AutoDaoMongo implements AutoDao{

    private MongoCollection<AutoPojo> collection;

    public AutoDaoMongo(String uri, String database, String collection){
        ConnectionString connection = new ConnectionString(uri);
        CodecRegistry pojoCodeRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodeRegistry);
        MongoClientSettings clientSettings =  MongoClientSettings.builder().applyConnectionString(connection).
                codecRegistry(codecRegistry).build();

        MongoClient client = MongoClients.create(clientSettings);
        MongoDatabase db = client.getDatabase(database);
        this.collection = db.getCollection(collection, AutoPojo.class);
    }

    @Override
    public ArrayList readAllAutos() {
        return collection.find().map(AutoPojoCoverter::pojoToAutoConvert).into(new ArrayList());
    }

    @Override
    public Auto readAutoById(String rendszam) throws AutoNemTalalhato {
       return collection.find(eq("_id", rendszam)).map(AutoPojoCoverter::pojoToAutoConvert).first();

    }

    @Override
    public void createAuto(Auto auto) throws RendszamNemMegfelelo {
        collection.insertOne(AutoPojoCoverter.autoPojoConvert(auto));
    }

    @Override
    public void updateAuto(Auto auto) {

    }

    @Override
    public void deleteAuto(Auto auto) {

    }

    @Override
    public void deleteAutoById(String rendszam) {

    }
}
