package kafkaclient
import Models._
import java.util

import org.apache.kafka.common.serialization.Deserializer

class StudentDeserializer extends Deserializer[Student] {

  def close(): Unit = {}
  def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = {}

  def deserialize(topic: String, bytes: Array[Byte]): Student = {

    try{
      val stringRep = bytes.map(_.toChar).foldLeft("")(_+_) //eg "Student(1,Ayush)"
      val arr = stringRep split ","
      val (preId, preName) = (arr(0),arr(1))
      val (id,name) = (preId.drop(8).toInt, preName.init)
      Student(id,name)
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
    
  }

}