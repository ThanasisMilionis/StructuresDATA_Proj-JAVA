# StructuresDATA_Proj-JAVA


Write a program that will read from a .txt file a sequence of consecutive
transactions of the form:
{
buy 50 price 25
buy 40 price 22
buy 30 price 33
sell 110 price 30
buy 25 price 35
sell 30 price 40
}
...
and it will print the total profit or loss just after the last sale.
The above file depicts the transactions in the order they occur, ie at
example this was first 3 buys, then a sell, then a buy and then a sell again.
Note that we do not count in profit any shares that are left over that we do not own
sell (these will be taken into account in future sales).
