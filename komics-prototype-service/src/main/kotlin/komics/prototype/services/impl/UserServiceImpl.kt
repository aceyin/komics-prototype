package komics.prototype.services.impl

import komics.data.jdbc.Db
import komics.model.Entity
import komics.prototype.entity.User
import komics.prototype.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by ace on 2016/10/21.
 */

@Service
open class UserServiceImpl : UserService {

    @Autowired
    private lateinit var db: Db

    override fun login(username: String, password: String): User? {
        val list = db.query(User::class, "query-by-username-and-password", mapOf("username" to username, "password" to password))
        return if (list.isEmpty()) null else list[0]
    }

    @Transactional(readOnly = false)
    override fun register(username: String, password: String): Boolean {
        val count = db.count("check-username-exists", mapOf("username" to username))
        if (count > 0) return false
        db.insert(User(Entity.IdGen.next(), username, password))
        return true
    }

}