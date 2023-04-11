import sys

generic_conf_filename = sys.argv[1]

def to_padname(num:str):
    num = hex(int(str(num),16) - 0x4844A000)
    return num

with open(generic_conf_filename, "r") as conf:
    for line in conf:
        if not line[:2] == "/*":
            line = line.strip()
            if line: 
                linesplit = line.split("\t")
                print("{{{0}, {1}, {2}}}, /* {3} {4} */".format(
                    to_padname(linesplit[0]),
                    linesplit[1],
                    linesplit[2],
                    linesplit[4],
                    linesplit[3],
                ))