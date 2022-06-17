package models

class User(
    val id: UserId,
    val name: String,
    val role: UserRole,
    val projectHistories: Seq[ProjectHistory]
) {}

object User {

  private var _id = 0

  private def generateId: Int = {
    _id = _id + 1
    _id
  }

  def create(
      name: String,
      role: UserRole,
      projectHistories: Seq[ProjectHistory]
  ): User = {
    new User(
      id = UserId(generateId),
      name = name,
      role = role,
      projectHistories = projectHistories
    )
  }
}
