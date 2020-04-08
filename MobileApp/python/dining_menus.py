#!/usr/bin/env python3
from req_lib import ReqLib
import datetime

'''
Parameters: locationID, menuID
'''
if __name__ == "__main__":
    req_lib = ReqLib()
    # Get today's date
    today = datetime.datetime.today()
    year = str(today.year)

    # Pad the number with zeros so that 
    # there are always exactly two digits
    month = str(today.month).zfill(2)
    day = str(today.day).zfill(2)

    possible_meals = ["Breakfast", "Lunch", "Dinner"]

    # Let's choose Lunch
    meal = possible_meals[1]

    menu = req_lib.getJSON(
        req_lib.configs.DINING_MENU, 
        locationID=2, 
        menuID= year + "-" + month + "-" + day + "-" + meal,
    )
    print(menu)

    for t in menu:
        for menu_item in menu[t]:
            # prints each food item included in this menu
            # Each food has the following parameters:
            
            # id
            # name
            # description
            # link (url to menu item on Princeton website)
            # icons (vegan, vegetarian, etc.)
            print(menu_item)
