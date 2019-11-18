
class Pet(var petName:String,
          var notes:String)
     {
    var clinicalHistory: MutableCollection<Visit> = mutableListOf()
         companion object {
             @JvmStatic fun main(args: Array<String>) { }
         }

}