import ar.edu.unq.eis.DAO.ExposedPetDAO
import ar.edu.unq.eis.DAO.PetDAO


class Pet(var petName:String,
          var ownerDni:Int,
          var notes:String)
     {
    var clinicalHistory: MutableCollection<Visit> = mutableListOf()
         companion object {
             @JvmStatic fun main(args: Array<String>) { }
         }

}