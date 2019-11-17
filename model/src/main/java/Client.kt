import ar.edu.unq.eis.DAO.ExposedPersonDAO
import ar.edu.unq.eis.DAO.PersonDAO
import com.fasterxml.jackson.annotation.JsonIgnore

class Client (var name:String,
              var lastname: String,
              var address: String,
              var email: String,
              var telephone: String,
              var dni: Int) {
    @JsonIgnore  var pets: MutableCollection<Pet> = mutableListOf()

              companion object {
                @JvmStatic fun main(args: Array<String>) { }
              }

}