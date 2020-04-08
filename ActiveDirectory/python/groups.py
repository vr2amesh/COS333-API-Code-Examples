from req_lib import ReqLib 
import datetime

'''
This endpoint returns all users that belong
to a particular group on campus. By using
the endpoint in the file users_full.py,
you can see which groups a particular user
is a part of. The correct name of the group
will be necessary when using this endpoint.
The only parameter of this endpoint is the 
following:

name (name of the group)

In this example, we will return everyone in
the current year's undergraduate class.
'''
if __name__ == "__main__":
    req_lib = ReqLib()
    today = datetime.datetime.today()
    year = str(today.year)

    req = req_lib.getJSON(
        req_lib.configs.GROUPS,
        name="Undergraduate Class of " + year,
    )
    print(req)