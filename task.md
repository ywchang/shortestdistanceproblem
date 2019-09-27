~~AB5 -> return 5~~

~~AB5,AC2 -> return 5~~

~~AC5,CB3 -> return 8~~

~~AB5,AC3,CB4 -> return 5 (because 5 < 3 + 4)~~

Graph constructor has too much logic, need to refactor

Route compares with start and end has happened multiple times, and use primitive equals method, think about wrapping it inside Route so that no need to invoke equals every time

Separator comma is magic char and better extracting it out to become constant

What if graph has a loop, like AC2,CA2,AB5, the current impl will bounce between A and C and enter dead loop

What if there is no route available between A and B, like AC2,BC2 then returning 0 does not make sense, should throw out an exception




