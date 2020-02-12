#!/bin/sh
function Pause() {
    read -p "$*"
} # ...


MainMenu() {

    while [ "$CHOICE" != "START" ]; do
        clear
        echo "================================================================="
        echo "| Oracle All Inclusive Tool |"
        echo "| Main Menu - Select Desired Operation(s): |"
        echo "| <CTRL-Z Anytime to Enter Interactive CMD Prompt> |"
        echo "-----------------------------------------------------------------"
        echo " $IS_SELECTEDM M) View Manual"
        echo " "
        echo " $IS_SELECTED1 1) Select all products that are Headphones and ordery them by LIKE"
        echo " $IS_SELECTED2 2) Select all users who have placed an order by EXISTS"
        echo " $IS_SELECTED3 3) Get avg price of products from BrandonMart by AGGREGATE"
        echo " $IS_SELECTED4 4) Get all purchases of a user by JOIN"
        echo " $IS_SELECTED4 5) Get all products from a store excluding Headphones by MINUS"
        echo " "
        echo " $IS_SELECTEDX X) Force/Stop/Kill Oracle DB"
        echo " "
        echo " $IS_SELECTEDE E) End/Exit"
        echo "Choose: "
        read CHOICE
        if [ "$CHOICE" == "0" ]; then
            echo "Nothing Here"
        elif [ "$CHOICE" == "1" ]; then
            echo "select * from product where productname like 'Wireless%' order by productprice asc;" | sqlplus.exe taimoor/taimoor
            Pause
        elif [ "$CHOICE" == "2" ]; then
            echo "select ecusername from buyer where exists (select * from checkout where buyer.ecusername = checkout.customer);" | sqlplus.exe taimoor/taimoor
            Pause
        elif [ "$CHOICE" == "3" ]; then
            echo "select avg(productprice) from product where ofstore = 'BrandonMart';" | sqlplus.exe taimoor/taimoor
            Pause
        elif [ "$CHOICE" == "4" ]; then
            echo "select ecusername, purchaseitem from buyer, checkout where buyer.ecusername = checkout.customer and purchaseitem = checkout.purchaseitem;" | sqlplus.exe taimoor/taimoor
            Pause
        elif [ "$CHOICE" == "5" ]; then
            echo "select * from product where ofstore = 'BrandonMart' minus (select * from product where productname = 'Headphones');" | sqlplus.exe taimoor/taimoor
            Pause

        elif [ "$CHOICE" == "E" ]; then
            exit
        fi
    done
}

#--COMMENTS BLOCK--
# Main Program
#--COMMENTS BLOCK--
ProgramStart() {
    StartMessage
    while [ 1 ]; do
        MainMenu

    done
}

ProgramStart