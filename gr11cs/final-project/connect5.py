import flet as ft


class Board(ft.UserControl):
    def create_grid(self, size: int):
        column = []
        row = []
        for i in range(size):
            for j in range(size):
                row.append(
                    ft.ElevatedButton(
                        style=ft.ButtonStyle(shape=ft.CircleBorder()),
                        bgcolor=ft.colors.GREEN_100,
                        on_click=self.make_move,
                        data="({}, {})".format(i, j)
                    )
                )
            column.append(
                ft.Row(
                    controls=row
                )
            )
            # using clear() will enpty everything because same reference
            row = []
        return column

    # must be called build
    # Exception: Board.build() method must be implemented and returning either Control or List[Control].
    def build(self):
        return ft.Container(
            content=ft.Column(controls=self.create_grid(10)),
            width=770,
            height=520,
            bgcolor=ft.colors.CYAN_100,
            border_radius=10,
            padding=10
        )

    def make_move(self, e):
        print("clicked")


def main(page: ft.page):
    page.title = "Connect 5"

    def route_change(route):
        page.views.append(
            ft.View(
                "/",
                [
                    ft.Text(
                        "Gomoku (Connect 5)",
                        bgcolor=ft.colors.AMBER_100,
                        size=50,
                        weight=ft.FontWeight.BOLD
                    ),
                    ft.ElevatedButton(
                        "Continue",
                        on_click=lambda _: page.go("/welcome")
                    )
                ]
            )
        )
        if page.route == "/welcome":
            page.views.append(
                ft.View(
                    "/welcome",
                    [
                        ft.Text(
                            "Welcome",
                            bgcolor=ft.colors.AMBER_100,
                            size=50
                        ),
                        ft.TextField(label="Player 1, enter your name:"),
                        ft.ElevatedButton(
                            "Continue",
                            on_click=lambda _: page.go("/mainmenu")
                        )
                    ]
                )
            )
        if page.route == "/mainmenu":
            page.views.append(
                ft.View(
                    "/mainmenu",
                    [
                        ft.Text(
                            "Main Menu",
                            bgcolor=ft.colors.AMBER_100,
                            size=50
                        ),
                        ft.ElevatedButton(
                            "Play with another human", on_click=lambda _: page.go("/humanmenu")),
                        ft.ElevatedButton(
                            "Play with engine",
                            on_click=lambda _: page.go("/board")
                        ),
                    ]
                )
            )
        if page.route == "/humanmenu":
            page.views.append(
                ft.View(
                    "/humanmenu",
                    [
                        ft.Text(
                            "Human Menu",
                            bgcolor=ft.colors.AMBER_100,
                            size=50
                        ),
                        ft.TextField(label="Player 2, enter your name:"),
                        ft.ElevatedButton(
                            "Play!",
                            on_click=lambda _: page.go("/board")
                        )
                    ]
                )
            )
        if page.route == "/board":
            page.views.append(
                ft.View(
                    "/board",
                    [
                        ft.Text(
                            "Board",
                            bgcolor=ft.colors.AMBER_100,
                            size=50
                        ),
                        ft.ElevatedButton(
                            "Back to Main Menu",
                            on_click=lambda _: page.go("/")
                        ),
                        Board()
                    ]
                )
            )

        page.update()

    page.on_route_change = route_change
    page.go(page.route)


ft.app(target=main)