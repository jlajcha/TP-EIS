
class Pet(val code: Int,
          var petName:String,
          var notes:String)
     {
    var clinicalHistory: MutableCollection<Visit> = mutableListOf()
         companion object {
             @JvmStatic fun main(args: Array<String>) { }
         }

}