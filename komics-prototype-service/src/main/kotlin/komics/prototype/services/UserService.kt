package komics.prototype.services

import komics.prototype.entity.User

/**
 * Created by ace on 2016/10/21.
 */
interface UserService {

    fun login(username: String, password: String): User?
    fun register(username: String, password: String): Boolean
}