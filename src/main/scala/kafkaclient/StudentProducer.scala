package kafkaclient

object StudentProducer extends App {
 
 import java.util.Properties
 import Models._

 import org.apache.kafka.clients.producer._

 val  props = new Properties()
 props.put("bootstrap.servers", "localhost:9092")
 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

 val producer = new KafkaProducer[String, String](props)
   
 val TOPIC="test0"
 
 for(i<- 1 to 50){
  val record = new ProducerRecord(TOPIC, "key", Student(i,"student " + i.toString).toString)
  producer.send(record)
 }

 producer.close()
}