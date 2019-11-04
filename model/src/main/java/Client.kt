import ar.edu.unq.eis.DAO.ExposedPersonDAO
import ar.edu.unq.eis.DAO.PersonDAO

class Client (var name:String,
              var lastname: String,
              var address: String,
              var email: String,
              var telephone: String,
              var dni: Int) {

              var pets: MutableCollection<Pet> = mutableListOf()

              companion object {
                @JvmStatic fun main(args: Array<String>) { }
              }

}