package tp3_mongo.tp3_mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Id;

public class Person {
    private List<Address> address = new ArrayList<Address>();
    @Id
    private ObjectId id;
    private String name;

    public void setAddress(Address address) {
        this.address.add(address);
    }

    public List<Address> getAdress() {
        return address;
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
}