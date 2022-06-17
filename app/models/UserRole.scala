package models

sealed abstract class UserRole(val code: String)

object UserRole {

  def apply(code: String): UserRole = code match {
    case Admin.code  => Admin
    case Member.code => Member
    case _           => throw new IllegalArgumentException(s"not supported role: $code")
  }

  case object Admin extends UserRole("ADMIN")

  case object Member extends UserRole("MEMBER")
}
