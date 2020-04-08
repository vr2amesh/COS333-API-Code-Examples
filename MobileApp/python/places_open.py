#!/usr/bin/env python3
from req_lib import ReqLib

if __name__ == "__main__":
    req_lib = ReqLib()
    open_places = req_lib.getJSON(
        req_lib.configs.PLACES_OPEN,
        fmt="json",
    )
    print(open_places)
    for place in open_places:
        # This will print out the information
        # of the place. Each place has the 
        # following parameters:

        # name (name of the place)
        # id (unique id number of the place)
        # open (indicates whether or not the place is open. Not a boolean, is a text "yes" or "no")
        print(place)
