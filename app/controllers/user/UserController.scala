package controllers.user

import io.circe.syntax.EncoderOps
import models.{ProjectHistory, User, UserId, UserRepository, UserRole}
import play.api.libs.circe.Circe
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject.Inject

class UserController @Inject() (cc: ControllerComponents, userRepository: UserRepository)
    extends AbstractController(cc)
    with Circe {

  def alive(): Action[AnyContent] = Action {
    Ok("ALIVE")
  }

  def listUsers(): Action[AnyContent] = Action {
    val users = userRepository.list()
    Ok(users.map(u => UserResponse(u).json).asJson)
  }

  def deleteUser(id: Int): Action[AnyContent] = Action {
    val userId = UserId(id)
    userRepository.delete(userId)
    NoContent
  }

  def addUser(): Action[AddUserRequest] = Action(circe.json[AddUserRequest]) { implicit request =>
    val newUser = User.create(
      name = request.body.name,
      role = UserRole(request.body.role),
      projectHistories = request.body.projectHistories.map { p =>
        ProjectHistory(
          projectName = p.projectName,
          startDate = p.startDate,
          endDate = p.endDate
        )
      }
    )

    userRepository.insert(newUser)
    Ok(UserResponse(newUser).json)
  }
}
