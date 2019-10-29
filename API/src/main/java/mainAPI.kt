
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.eclipse.jetty.http.HttpStatus.BAD_REQUEST_400
import com.fasterxml.jackson.databind.exc.MismatchedInputException


fun main() {
    val app = Javalin.create()
            .enableCorsForAllOrigins()
            .enableRouteOverview("/routes")
            .exception(MismatchedInputException::class.java) { e, ctx ->
                ctx.status(BAD_REQUEST_400)
                ctx.json(mapOf(
                        "status" to BAD_REQUEST_400,
                        "message" to e.message
                ))
            }
            .start(7000)
    app.get("/") { ctx -> ctx.json(mapOf("message" to " Welcome to MorfApp ~ Online ")) }


    val controller = PersonController()
    app.routes {
        path("login_user") {
            post(controller::loginUser)
        }
    }

    }