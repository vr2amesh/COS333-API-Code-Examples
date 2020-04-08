from req_lib import ReqLib

'''
This API is pretty straightforward. This is 
the only endpoint that is within the API. It
returns a list of all of the departments within
Princeton University. Each item in the list 
is a dictionary with key "dept" whose value
is the name of the actual department.

This endpoint does not take any parameters.
'''

if __name__ == "__main__":
    req_lib = ReqLib()
    req = req_lib.getJSON(req_lib.configs.DEPARTMENT)
    print(req)