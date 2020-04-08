from req_lib import ReqLib

'''
This endpoint returns information about
a user within the Princeton community.
This endpoint provides
a bit less information than does the 
endpoint in the file users.py.
The only parameter that the endpoint requires
is the user's netid. The parameter's name is:

uid

The return value has the following information
about the user:

displayname (Full name of the user)
universityid (PUID number)
mail (user's email address)
'''
if __name__ == "__main__":
    req_lib = ReqLib()

    req = req_lib.getJSON(
        req_lib.configs.USERS_BASIC,
        uid="rdondero",
    )
    print(req)