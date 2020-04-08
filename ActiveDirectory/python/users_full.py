from req_lib import ReqLib

'''
This endpoint returns information about
a user within the Princeton community.
This endpoint returns the full information
about a particular user. It returns far more
information than the endpoint in the file
users.py.
The only parameter that the endpoint requires
is the user's netid. The parameter's name is:

uid

The return value has the following information
about the user:

displayname (Full name of the user)
universityid (PUID number)
mail (user's email address)
pustatus (is the user a graduate, undergraduate, or faculty?)
department (which department the user belongs to)
eduPersonPrimaryAffiliation (whether the user is a student or faculty)
streetAddress (office number and location if it is a faculty member)
telephoneNumber (phone number if it is a faculty member)
title (name of position at Princeton if it is a faculty member)

eduPersonAffiliation (an array that shows all types of affiliation with 
the university. For example, faculty, employee, and student)

departmentNumber (number of the department in which the user belongs)

memberOf (all groups on campus that the user is a part of. For example,
Computer Science FacStaff, DuoEnabledAutomatically, or 
Office365ExchangeStandardEnabled, etc.)
'''
if __name__ == "__main__":
    req_lib = ReqLib()

    req = req_lib.getJSON(
        req_lib.configs.USERS_FULL,
        uid="rdondero",
    )
    print(req)