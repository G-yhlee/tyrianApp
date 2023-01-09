package myorg

import cats.effect.IO
import tyrian.Html.*
import tyrian.*

import scala.scalajs.js.annotation.*

@JSExportTopLevel("TyrianApp")
object Tyrianapp extends TyrianApp[Msg, Model]:

  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (Model(0, Tab.Installation), Cmd.None)

  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) = (msg: Msg) =>
    msg match
      case sideBarMsg: SideBarMsg => SideBarUpdate.update(model)(sideBarMsg)
      case mainMsg: MainMsg =>
        mainMsg match
          case MainMsg.Increment =>
            (model.copy(value = model.value + 1), Cmd.None)
          case MainMsg.Decrement =>
            (model.copy(value = model.value - 1), Cmd.None)

  def view(model: Model): Html[Msg] =
    div(
      SideBarView.view(model),
      button(onClick(MainMsg.Decrement))("-"),
      div(model.toString),
      button(onClick(MainMsg.Increment))("+")
    )

  def subscriptions(model: Model): Sub[IO, Msg] =
    Sub.None

final case class Model(
    value: Int,
    tab: Tab
)

sealed trait Msg

enum MainMsg extends Msg:
  case Increment, Decrement

enum SideBarMsg extends Msg:
  case Installation, Architecture

enum Tab:
  case Installation, Architecture
