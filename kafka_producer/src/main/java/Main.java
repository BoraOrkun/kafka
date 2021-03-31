import org.apache.kafka.common.serialization.IntegerSerializer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int seconds = 1;
            int check = 0;
            int rand;
            int innerLoop = 1;
            ClassX classX;
            ProducerCreator producerCreator = new ProducerCreator("localhost:9092", 16384,
                    33554432, IntegerSerializer.class.getName(), ClassXSerializer.class.getName());
            MyProducer myProducer = new MyProducer("TutorialTopic");

            @Override
            public void run() {

                while (innerLoop-- > 0) {
                    rand = random.nextInt(100);
                    classX = new ClassX(rand, rand);
                    myProducer.sendMessage(producerCreator.create(), classX);
                    System.out.println("Object " + classX.toString() + " is written");
                }
                innerLoop = 1;
                check++;
                if (check % 10 == 0) {
                    System.out.println("Kalan Zaman:" + seconds--);
                }
                if (seconds == 0) {
                    timer.cancel();
                    timer.purge();
                    return;
                }
            }
        };
        timer.schedule(timerTask, 0, 100); //saniyede 10 kere 1 adet veri basiyor
    }
}
