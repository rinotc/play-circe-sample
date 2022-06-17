package infra

import models.{User, UserId, UserRepository}
import scala.collection.mutable

object MemoryUserRepository extends UserRepository {

  private val users: mutable.ArrayBuffer[User] = mutable.ArrayBuffer.empty[User]

  override def list(): Seq[User] = users.toSeq

  override def find(id: UserId): Option[User] = {
    users.find(u => u.id == id)
  }

  override def insert(user: User): Unit = {
    users += user
  }

  override def update(user: User): Unit = {
    delete(user.id)
    insert(user)
  }

  override def delete(id: UserId): Unit = {
    users.remove(users.view.indexWhere(_.id == id))
  }
}
