package kafkaclient

object StudentProducer extends App {
 
 import java.util.Properties
 import Models._

 import org.apache.kafka.clients.producer._

 val  props = new Properties()
 props.put("bootstrap.servers", "localhost:9092")
 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
//  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "kafkaclient.StudentSerializer")

 val producer = new KafkaProducer[String, Student](props)
   
 val TOPIC="test0"
 
 
  val record = new ProducerRecord(TOPIC, "key", Student(1,"Ayush"))
  producer.send(record)
 

 producer.close()
}