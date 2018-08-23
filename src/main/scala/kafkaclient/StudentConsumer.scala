package kafkaclient

import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object StudentConsumer extends App {

  import org.apache.kafka.clients.consumer._
  import Models._

  import java.util.Properties

  val TOPIC="students0"

  val  props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  // props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "kafkaclient.StudentDeserializer")
  props.put("group.id", "studentconsumers")

  val consumer = new KafkaConsumer[String, Student](props)

  consumer.subscribe(util.Collections.singletonList(TOPIC))

  // while(true){
    val records: ConsumerRecords[String,Student] = consumer.poll(5000)
    for (record<-records.asScala){
      println("ab print kar raha")
     println(record.value())
    }
  // }
}