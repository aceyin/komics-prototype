package komics.prototype.entity

import komics.model.Entity
import javax.persistence.Table

/**
 * Created by ace on 2016/10/20.
 */
@Table(name = "user") data class User(override var id: String, var username: String, var password: String) : Entity {
    public constructor() : this(id = "", username = "", password = "")
}