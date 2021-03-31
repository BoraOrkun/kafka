import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class ProducerCreator {
    private String broker;
    private int batchSize;
    private int bufferMemory;
    private String keySerializer;
    private String valueSerializer;

    public ProducerCreator() {
    }

    public ProducerCreator(String broker, int batchSize, int bufferMemory, String keySerializer, String valueSerializer) {
        this.broker = broker;
        this.batchSize = batchSize;
        this.bufferMemory = bufferMemory;
        this.keySerializer = keySerializer;
        this.valueSerializer = valueSerializer;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(int bufferMemory) {
        this.bufferMemory = bufferMemory;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public Producer create() {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", this.broker);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", batchSize);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", bufferMemory);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);

        return new KafkaProducer<String, String>(properties);
    }
}
