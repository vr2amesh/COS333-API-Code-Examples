#!/usr/bin/env python3
from configs import COURSE_TERMS
from req_lib import getJSON

if __name__ == "__main__":
    term = getJSON(
        COURSE_TERMS,
        # We want the results as a JSON
        # object, so this is necessary
        fmt="json",
    )

    # This will print the information of the 
    # current term. Each term has the following
    # parameters:

    # code (The id number of the term according to the Registrar)
    # suffix (Formatted version of the term as such: TermYear [e.g. S2020, F2019, F2018, etc.])
    # name (Formatted term as such: [e.g. S19-20, F19-20, F18-19, etc.])
    # cal_name (Formatted term as such: Term Year [e.g. Spring 2020, Fall 2019, Fall 2018, etc.])
    # reg_name (Formatted term as such: Years Term [e.g. 19-20 Spr, 19-20 Fall, 18-19 Fall, etc.])
    # start_date (start date formatted YYYY-MM-DD)
    # end_date (end date formatted YYYY-MM-DD)
    print(term)