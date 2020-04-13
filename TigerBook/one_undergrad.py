from req_lib import getOneUndergrad

if __name__ == "__main__":
    # Please put the netid you need for the
    # parameter
    req = getOneUndergrad(netid="vramesh")
    if req.ok:
        print(req.json())
    else:
        print(req.text)