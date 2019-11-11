import org.junit.Test

class veteAppTest {
    @Test
    fun tryModelExposedIntegration(){

        VeteApp.createClient(32000001, "Pepe", "Argento", "S", "@","444-4444")
    }
}