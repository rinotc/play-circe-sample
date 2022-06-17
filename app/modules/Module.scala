package modules

import com.google.inject.AbstractModule
import infra.MemoryUserRepository
import models.UserRepository

class Module extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[UserRepository]).toInstance(MemoryUserRepository)
  }
}
