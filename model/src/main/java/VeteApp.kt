import java.lang.Exception

object VeteApp {

    fun createClient(dni:String, name:String,surname:String, address:String, email:String, telephone:String): Client {

        //if(!registeredUsers.containsKey(dni)){
          val newClient: Client = Client(name, surname,address, email, telephone, dni)
          //  this.registeredUsers.put(newClient.id,newClient)
            return newClient
        //}
       // else {throw Exception("Ya se encuentra registrado el usuario de ID: $dni")
        //}
    }
}