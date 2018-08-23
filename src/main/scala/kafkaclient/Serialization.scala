package kafkaclient
import Models._
import java.util

import org.apache.kafka.common.serialization.{Serializer,Deserializer}

class StudentSerializer extends Serializer[Student] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def serialize(topic: String, stud: Student): Array[Byte] = {

    try {
      stud.toString.getBytes
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

  override def close(): Unit = {}

}

// class StudentDeserializer extends Deserializer[Student] {

// }