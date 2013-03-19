import pdb

def bin(data, key, row, col, direction):
	#pdb.set_trace()
	print row, col
	if row==len(data) or col < 0: return False
	#rMid = (rHigh - rLow) / 2 + rLow
	#cMid = (cHigh - cLow) / 2 + cLow
	
	#if data[row][col] == key: return True
	
	# binary search
	if direction == "down":
		low = row
		high = len(data)-1
		
		while(high-low > 1):
			mid = (high - low) / 2 + low
			if data[mid][col] == key: return True
			if data[mid][col] < key: low = mid + 1
			high = mid - 1
		if data[low][col] == key or data[high][col] == key: return True
		if data[low][col] > key:
			return bin(data, key, high, col-1, "left")
		else:
			return bin(data, key, low, col-1, "left")
		
	else:
		low = 0
		high = col
		
		while(high-low > 1):
			mid = (high - low) / 2 + low
			if data[row][mid] == key: return True
			if data[row][mid] < key: low = mid + 1
			high = mid - 1
		if data[row][low] == key or data[row][high] == key: return True
		if data[row][low] > key:
			return bin(data, key, row + 1, low, "down")
		else:
			return bin(data, key, row + 1, high, "down")
		
		
def callBin(data, key):
	if not(len(data)): return False
	elif not(len(data[0])): return False # zero lengths

	if key < data[0][0] or key > data[len(data)-1][len(data[0])-1]:
		return False # bigger than the biggest or smaller than the smallest
		
	return bin(data, key, 0, len(data[0])-1, "down")

def pdata(data):
	for r in data:
		for c in r:
			print '%5s' % c,
		print
	
f=open("smalltest.txt")
data=[]
for i in f:
	data.append(map(lambda x: int(x), i.strip().split("  ")))
f.close()
while(True):	
	inp = input("::")
#pdb.set_trace()
	print (callBin(data, int(inp)))
	print
