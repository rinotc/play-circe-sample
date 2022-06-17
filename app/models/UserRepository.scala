package models

trait UserRepository {

  def list(): Seq[User]

  def find(id: UserId): Option[User]

  def insert(user: User): Unit

  def update(user: User): Unit

  def delete(id: UserId): Unit
}
