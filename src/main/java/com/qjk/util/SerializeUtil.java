package com.qjk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.qjk.data.User;

public class SerializeUtil {
	  public static byte[] serialize(Object object) {
          ObjectOutputStream oos = null;
           ByteArrayOutputStream baos = null;
           try {
                // 序列化
               baos = new ByteArrayOutputStream();
               oos = new ObjectOutputStream(baos);
               oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return bytes;
          } catch (Exception e) {

          }finally{
        	  if(oos != null){
        		  try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	  }
        	  
        	  if(baos != null){
        		  try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	  }
        	  
          }
           return null;
    }

     public static Object unserialize( byte[] bytes) {
          ByteArrayInputStream bais = null;
          ObjectInputStream ois = null;
           try {
                // 反序列化
               bais = new ByteArrayInputStream(bytes);
               	ois=  new ObjectInputStream(bais);
                return ois.readObject();
          } catch (Exception e) {

          }finally{
        	  if(ois != null){
        		  try {
        			  ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	  }
        	  
        	  if(bais != null){
        		  try {
        			  bais.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	  }
        	  
          }
           return null;
    }
     
     public static void main(String[] args) {
		User user = new User();
		user.setNick("大家好");
		user.setPhone("13051701098");
		user.setEmail("qiejinkai@126.com");
		byte[]buf = serialize(user);
		System.out.println(new String(buf));
		
		User user2 = (User)unserialize(buf);
		System.out.println(user2.getNick());
	}
}
