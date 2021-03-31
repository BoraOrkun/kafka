import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyProducer {
    private String topicName;

    public MyProducer() {
    }

    public MyProducer(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public boolean sendMessage (Producer producer) {
        producer.send(new ProducerRecord(topicName, "test_bora", "test_bora"));
        producer.close();
        return true;
    }

    public boolean sendMessage (Producer producer, ClassX classX) {

        /*ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(classX);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        producer.send(new ProducerRecord(topicName, json));*/
        producer.send(new ProducerRecord(topicName, classX.getKey(), classX));
        producer.close();
        return true;
    }

    public boolean sendMessage (Producer producer, ClassY classY) {
        producer.send(new ProducerRecord(topicName, classY.getKey(), classY.getValue()));
        producer.close();
        return true;
    }

    public boolean sendMessage (Producer producer, ClassZ classZ) {
        producer.send(new ProducerRecord(topicName, classZ.getKey(), classZ.getValue()));
        producer.close();
        return true;
    }

    public boolean sendMessage (Producer producer, ClassT classT) {
        producer.send(new ProducerRecord(topicName, classT.getKey(), classT.getValue()));
        producer.close();
        return true;
    }
}
