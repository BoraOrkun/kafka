import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class ClassXDeserializer implements Deserializer {

    @Override
    public Object deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        ClassX classX = null;
        try {
            classX = mapper.readValue(s, ClassX.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classX;
    }
}
