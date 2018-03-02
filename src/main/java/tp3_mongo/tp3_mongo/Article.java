package tp3_mongo.tp3_mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Id;

public class Article {
    
    @Id
    private ObjectId id;
    private String name;
    private int stars;
    private List<Person> buyers = new ArrayList<Person>();
    
    public List<Person> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Person> buyers) {
        this.buyers = buyers;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}