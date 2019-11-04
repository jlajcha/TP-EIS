import io.javalin.Context
import org.eclipse.jetty.http.HttpStatus

data class DataClient(val name : String,
                      var surname:String,
                      var address : String ,
                      val email : String,
                      var telephone: String,
                      var dni: Int)

class ClientController {
    val veteApp = VeteApp

    fun addClient(ctx: Context) {
        println("hola")
        val client = ctx.body<DataClient>()

        veteApp.createClient(client.dni,
                             client.name,
                             client.surname,
                             client.address,
                             client.email,
                             client.telephone)
        ctx.status(HttpStatus.CREATED_201)
    }
}
//en postman el post en la ruta localhost:7000/add_client con el siguiente jason en el body .   
/*{

    "name": "Clark",
    "surname":"Kent",
    "address": "Calle falsa 123",
    "email":"superman@mail.com",
    "telephone":"12221212",
    "dni":"355572834"
}*/
