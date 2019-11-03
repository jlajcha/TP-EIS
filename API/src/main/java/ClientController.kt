import com.fasterxml.jackson.annotation.JsonIgnore
import io.javalin.Context
import io.javalin.NotFoundResponse
import org.eclipse.jetty.http.HttpStatus
import Client

//hacer el jar para esta mierda

data class DataClient(val name : String,
                      var surname:String,
                      var address : String ,
                      val email : String,
                      var telephone: String,
                      var dni: String,
                      var pets:MutableCollection<Pet>)
//aca este object tiene que ser tipo Client

//hay que agregar la VeteApp
class ClientController {
    val veteApp = VeteApp

    fun addClient(ctx: Context) {
        val client = ctx.body<DataClient>()
        val dni = client.dni
  //      try {
    //        validate(dni)
      //  } catch (e: Error) {
        //    throw NotFoundResponse(e.message as String)
        //}

        val newUser = veteApp.createClient(client.dni, client.name,client.surname, client.address, client.email, client.telephone)
        ctx.status(HttpStatus.CREATED_201)
        ctx.json(addDataUser(newUser))
    }

//    private fun validate(id: String) {
   //     if (!isCorrectId(id)) {
     //       throw Exception("El nombre de usuario ya esta en uso")
        }


//7    private fun isCorrectId(id: String):
// aca tiene que ver en la base que no se haya usarl el dni Boolean = !users.containsKey(id)


    //fun addDataUser(client: Client): DataClient {
        //ver como se llama esto con la persistencia.
        // val dataUser = DataUser(client)
        // users.put(dataUser.id, dataUser)
        //return dataUser
    //}


    fun addDataUser(client : Client) : DataClient{
        val pets:MutableCollection<Pet> = mutableListOf<Pet>()
        val dataUser = DataClient(client.name,client.surnanme,client.address,client.email,client.telephone,client.dni, pets)
       // users.put(dataUser.id, dataUser)
        return dataUser
    }
