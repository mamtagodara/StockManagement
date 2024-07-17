import os

def generateFile(start=2,end=38,step=2):
    expected = []
    for i in range(star,end,step):
        filename= f"page {i}n{i+1}
        expected.append(filename)
    return expected

def missing(directory, expected):

    missing = []
    files= set(os.listdir(directory))

    for file in files:
        if file not in expected:   
        missing.add(file)

def main():


    

