~~AB5 -> return 5~~

~~AB5,AC2 -> return 5~~

~~AC5,CB3 -> return 8~~

AB5,AC3,CB4 -> return 5 (because 5 < 3 + 4)

Graph constructor has too much logic, need to refactor

Route compares with start and end has happened multiple times, and use primitive equals method, think about wrapping it inside Route so that no need to invoke equals every time

Separator comma is magic char and better extracting it out to become constant




