package tp3_mongo.tp3_mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        Main mongoRedis = new Main();

        try {
        		mongoRedis.runMongoQueries();
        		mongoRedis.runRedisDummy();
        		mongoRedis.runRedisCounter();
        		mongoRedis.runRedisCache();
        		mongoRedis.runRedisCacheStorage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Function to create objects and storage the information with MongoDB
     */
    public void runMongoQueries() {
        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();

        morphia.map(Person.class).map(Address.class);

        Datastore ds = morphia.createDatastore(mongo, "my_database");
        Person p = new Person();

        p.setName("Tintin");

        Address address = new Address();

        address.setStreet("123 Some street");
        address.setCity("Some city");
        address.setPostCode("123 456");
        address.setCountry("Some country");

        // set address
        p.setAddress(address);

        // Save the POJO
        ds.save(p);

        for (Person e : ds.find(Person.class)) {
            System.err.println(e);
        }
    }

    /**
     * Basic function to test the Redis SET command 
     */
    public void runRedisDummy() {
        Jedis jedis = new Jedis("localhost");

        jedis.set("foo", "bar");

        String value = jedis.get("foo");

        System.err.println(value);
    }

    /**
     * Basic function to test the Redis counter 
     */
    public void runRedisCounter() {
        Jedis jedis = new Jedis("localhost");

        System.out.println(jedis.get("counter"));
        jedis.incr("counter");
        System.out.println(jedis.get("counter"));
    }

    /**
     * @throws InterruptedException
     * Basic function to test the functions INCRT and EXPIRE
     */
    public void runRedisCache() throws InterruptedException {
        String cacheKey = "cachekey";
        Jedis jedis = new Jedis("localhost");

        // adding a new key
        jedis.set(cacheKey, "cached value");

        // setting the TTL in seconds
        jedis.expire(cacheKey, 15);

        // Getting the remaining ttl
        System.out.println("TTL:" + jedis.ttl(cacheKey));
        Thread.sleep(1000);
        System.out.println("TTL:" + jedis.ttl(cacheKey));

        // Getting the cache value
        System.out.println("Cached Value:" + jedis.get(cacheKey));

        // Wait for the TTL finish
        Thread.sleep(15000);

        // trying to get the expired key
        System.out.println("Expired Key:" + jedis.get(cacheKey));
    }

    /**
     * Basic function to test the storage of a SET of non-duplicated values
     */
    public void runRedisCacheStorage() {
        String cacheKey = "languages";
        Jedis jedis = new Jedis("localhost");

        // Adding a set as value
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "C#");
        jedis.sadd(cacheKey, "Python");

        // Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey));

        // Adding new values
        jedis.sadd(cacheKey, "Java");
        jedis.sadd(cacheKey, "Ruby");

        // Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis.smembers(cacheKey));
    }
}