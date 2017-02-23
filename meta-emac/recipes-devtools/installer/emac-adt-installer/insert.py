import os
import sys

#reads the first argument passed to the script, which is which kit to insert into the targetFile
arch = sys.argv[1]

#reads the second argument, which is how many kits already exist
n = int(sys.argv[2])


#target file if the file to be modified
targetFile = "profiles.xml"

#based on the argument, the text that will be inserted into targetFile is determined
if arch == 'arm':
	template = "armtemplate.txt"
else:
	template = "x86template.txt"

#the script will search the file for this comment
identifier = '</data>'

#opens and reads the file, then splits it into two at the location of the identifier
f = open(targetFile, "r")
groups = f.read().split(identifier)
f.close()

split1stHalf = identifier.join(groups[:n]) + identifier
split2ndHalf = identifier.join(groups[n:])

#read the file that contains the text to be inserted
f = open(template, "r")
insertedText = f.read()
f.close()

#puts it all together: first half of the old code, the new code that was inserted, a new identifier comment for future use, and the last part of the old code
final = split1stHalf + insertedText + split2ndHalf

#write this output to the original file
f = open(targetFile, "w")
f.write(final)
f.close()
	


