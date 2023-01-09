package myorg

import tyrian.Html.*
import tyrian.*

object SideBarView:

  def view(model: Model): Html[Msg] =
    div(
      div(id := "hello")(
        "Hello"
      )
    )
