// author: Ivy Seo 
// stage 1

import java.util.*;
import java.io.*;

public class ClientList implements Serializable {
  private static final long serialVersionUID = 1L;

  private List clients = new LinkedList();
  private static ClientList clientList;

  private ClientList() {
  }

  public static ClientList instance() {
    if (ClientList == null) {
      return (ClientList = new ClientList());
    } 
    else {
      return clientList;
    }
  }

  public boolean addClient(Client client) {
    clinet.add(client);
    return true;
  }

  public Iterator getClients(){
     return clients.iterator();
  }
  
  private void writeObject(java.io.ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(clientList);
    } 
    catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }
  private void readObject(java.io.ObjectInputStream input) {
    try {
      if (clientList != null) {
        return;
      } 
      else {
        input.defaultReadObject();
        if (clientList == null) {
          clientList = (ClientList) input.readObject();
        } 
        else {
          input.readObject();
        }
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
  public String toString() {
    return clients.toString();
  }
}
