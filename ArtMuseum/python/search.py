from configs import SEARCH
from req_lib import getJSON

'''
One can use this search endpoint in
order to search for objects according 
to their type among other things. 
The parameters are as follows:

q: query string
type: object type (this can be
artobjects, makers, packages, or all)

'''

if __name__ == "__main__":
    req = getJSON(SEARCH, q="blue", type="artobjects")
    print(req)