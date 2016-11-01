package komics.prototype.restapi

import komics.prototype.form.RegisterForm
import komics.prototype.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.wso2.msf4j.template.MustacheTemplateEngine
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Request
import javax.ws.rs.core.Response

/**
 * Created by ace on 2016/10/21.
 */

@Component
@Path("/user")
class UserApi {

    @Autowired
    private lateinit var usersvc: UserService

    @POST
    @Path("login")
    fun login(username: String, password: String, req: Request) {

    }

    /**
     * 进入注册表单
     */
    @GET
    @Path("register")
    @Produces(MediaType.TEXT_HTML)
    fun registerPage(): Response {
        val map = mapOf("name" to "aaa")
        val html = MustacheTemplateEngine.instance().render("register.mustache", map)
        return Response.ok().type(MediaType.TEXT_HTML).entity(html).build()
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun doRegister(@Valid form: RegisterForm): Response {
        val success = usersvc.register(form.username, form.password)
        return Response.ok().entity(form).build()
    }
}