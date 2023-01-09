package myorg

import cats.effect.IO
import tyrian.Html.*
import tyrian.*

object SideBarUpdate:
  def update(model: Model): SideBarMsg => (Model, Cmd[IO, Msg]) =
    case SideBarMsg.Installation => (model, Cmd.None)
    case SideBarMsg.Architecture => (model, Cmd.None)
