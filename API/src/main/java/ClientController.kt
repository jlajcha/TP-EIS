import com.fasterxml.jackson.annotation.JsonIgnore
import io.javalin.Context
import io.javalin.NotFoundResponse
import org.eclipse.jetty.http.HttpStatus
import Client
//hacer el jar para esta mierda

data class LittleUser(var id : String, var password : String)
data class PseudoUser(val id : String, val name : String, var password : String, var address : String , var longitude : Double, var latitude : Double , val email : String)
//aca este object tiene que ser tipo Client
data class DataClient(@JsonIgnore val client : Client){
    val dni = client.dni
    val name = client.id
    var address = client.address
    val email = client.email
//    var pets = mutableListOf<PetData>()
    }

//hay que agregar la VeteApp
class ClientController {
    val veteApp = VeteApp


    fun addClient(ctx: Context) {
        val client = ctx.body<PseudoUser>()
        val dni = client.dni
        try {
            validate(dni)
        } catch (e: Error) {
            throw NotFoundResponse(e.message as String)
        }

        val name = client.name
        val address = client.address
        val email = client.email
        val newUser = veteApp.createClient(dni, name, address, email)
        ctx.status(HttpStatus.CREATED_201)
        ctx.json(addDataUser(newUser))
    }

    private fun validate(id: String) {
        if (!isCorrectId(id)) {
            throw Exception("El nombre de usuario ya esta en uso")
        }
    }

    private fun isCorrectId(id: String): //aca tiene que ver en la base que no se haya usarl el dni Boolean = !users.containsKey(id)


    //fun addDataUser(client: Client): DataClient {
        //ver como se llama esto con la persistencia.
        // val dataUser = DataUser(client)
        // users.put(dataUser.id, dataUser)
        //return dataUser
    }

}