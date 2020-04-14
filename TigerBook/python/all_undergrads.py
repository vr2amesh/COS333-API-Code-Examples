from req_lib import getAllUndergrads

if __name__ == "__main__":
    req = getAllUndergrads()
    if req.ok:
        print(req.json())
    else:
        print(req.text)