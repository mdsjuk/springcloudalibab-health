package com.uber.engsec.dp.schema

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}

import redis.clients.jedis.Jedis

/**
 * @author:wxb
 * @description:
 * @date:16:592020/9/18
 */
object Redisutils{

  def re_input(): Jedis ={
    val jr=new Jedis()
    try {
      val jr = new Jedis("127.0.0.1", 6379);
      jr.auth("740616");
      jr
    }catch {
      case ex: Exception => {
        ex.printStackTrace() // 打印到标准err
        System.err.println("exception===>: ...")  // 打印到标准err
        jr} }
      finally {
      jr.close()
    }}


  def serialize(obj: Any): Array[Byte] = {
    var objectOut: ObjectOutputStream = null
    var byteArrayOut: ByteArrayOutputStream = null
    byteArrayOut = new ByteArrayOutputStream()
    objectOut = new ObjectOutputStream(byteArrayOut)
    objectOut.writeObject(obj)
    objectOut.flush()
    var byt = byteArrayOut.toByteArray
    byteArrayOut.close()
    objectOut.close()
    return byt
  }

  //反序列化
  def unserizlize_Database(byteArray: Array[Byte]): Database = {
    var objectInput: ObjectInputStream = null
    var byteArrayInput: ByteArrayInputStream = null
    val byteInput = new ByteArrayInputStream(byteArray)
    objectInput = new ObjectInputStream(byteInput)
    val obj = objectInput.readObject()
    obj.asInstanceOf[Database]
  }
  def unserizlize_Databases(byteArray: Array[Byte]): Databases = {
    var objectInput: ObjectInputStream = null
    var byteArrayInput: ByteArrayInputStream = null
    val byteInput = new ByteArrayInputStream(byteArray)
    objectInput = new ObjectInputStream(byteInput)
    val obj = objectInput.readObject()
    obj.asInstanceOf[Databases]
  }


  def get_Databases(key: String):Databases={
    val  jr=Redisutils.re_input()
    val dbs_s=Redisutils.unserizlize_Databases(jr.get(key.getBytes()))
    return dbs_s
  }
  def get_Database(key: String):Database={
    val  jr=Redisutils.re_input()
    val dbs_s=Redisutils.unserizlize_Database(jr.get(key.getBytes()))
    return dbs_s
  }
}
