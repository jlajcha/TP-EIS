import io.javalin.Context
import org.eclipse.jetty.http.HttpStatus

data class DataClient(val name : String,
                      var surname:String,
                      var address : String ,
                      val email : String,
                      var telephone: String,
                      var dni: Int)

//la idea es que la notas pueda agregar cosas relevantes del bicho
data class DataPet(var petName:String,
                   var ownerDni: Int,
                   var notes:String )

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

    fun addPet(ctx: Context){
        val pet= ctx.body<DataPet>()
            veteApp.createPet(pet.petName,pet.ownerDni,pet.notes)
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
