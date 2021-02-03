import random
import math

NUMPOINTS = 20 # For random test case 1, number of points is 20.

def generate_and_print_points():
	for i in range(NUMPOINTS):
		a = random.randint(-10,10)
		b = random.randint(-10,10)
		print("(" + str(a) + "," + str(b) + ")", end="")
		if (i % 3 == 2):
			print()
		elif (i == NUMPOINTS-1):
			print("")
		else:
			print(", ", end="")

def generate_and_print_LCM():
	# 15x15 matrix of zeroes, https://stackoverflow.com/a/6667288
	LCM = [[0 for x in range(15)] for y in range(15)]
	connectors = ["ANDD   ", "ORR	", "NOTUSED"]

	for i in range(15):
		for j in range(i, 15):
			connector = random.sample(connectors, 1)[0]
			LCM[i][j] = connector
			LCM[j][i] = connector

	for i in range(15):
		for j in range(15):
			print(LCM[i][j] + " ", end="")
		print()

def generate_and_print_PUV():
	# 15x15 matrix of zeroes, https://stackoverflow.com/a/6667288
	PUV = [bool(random.randint(0,1)) for x in range(15)]
	print(PUV)

def generate_and_print_params():
	params = dict()

	# (upper limits cannot be infinity, using 10 instead since points
	# are between -10 and 10, i.e. a 20*20 size possible grid, so 10
	# seemed like a reasonable number)

	params['LENGTH1'] = random.uniform(0,10)			# double, ≥ 0
	params['RADIUS1'] = random.uniform(0,10)			# double, ≥ 0
	params['EPSILON'] = random.uniform(0,math.pi-0.001)		# double, 0 ≤ EPSILON ≤ PI, -0.001 since random.uniform(a,b) is sometimes [a,b], sometimes [a,b)
	params['AREA1'] = random.uniform(0,10)				# double, ≥ 0

	params['Q_PTS'] = random.randint(2, NUMPOINTS)			# int, 2 ≤ Q_PTS ≤ NUMPOINTS
	params['QUADS'] = random.randint(1,3)				# int, 1 ≤ QUADS ≤ 3

	params['DIST'] = random.uniform(0,10)				# double, ≥ 0

	params['N_PTS'] = random.randint(3, NUMPOINTS)			# int, 3 ≤ N_PTS ≤ NUMPOINTS
	params['K_PTS'] = random.randint(1, NUMPOINTS-2)		# int, 1 ≤ K_PTS ≤ NUMPOINTS-2

	upper = math.floor((NUMPOINTS-3)/2) # makes sum ≤ NUMPOINTS-3

	params['A_PTS'] = random.randint(1, upper)			# int, 1 ≤ A_PTS and A_PTS + B_PTS ≤ NUMPOINTS-3
	params['B_PTS'] = random.randint(1, upper)			# int, 1 ≤ B_PTS and A_PTS + B_PTS ≤ NUMPOINTS-3

	params['C_PTS'] = random.randint(1, upper)			# int, 1 ≤ C_PTS and C_PTS + D_PTS ≤ NUMPOINTS-3
	params['D_PTS'] = random.randint(1, upper)			# int, 1 ≤ D_PTS and C_PTS + D_PTS ≤ NUMPOINTS-3

	params['E_PTS'] = random.randint(1, upper)			# int, 1 ≤ E_PTS and E_PTS + F_PTS ≤ NUMPOINTS-3
	params['F_PTS'] = random.randint(1, upper)			# int, 1 ≤ F_PTS and E_PTS + F_PTS ≤ NUMPOINTS-3

	params['G_PTS'] = random.randint(1, NUMPOINTS-2)		# int, 1 ≤ G_PTS ≤ NUMPOINTS-2

	params['LENGTH2'] = random.uniform(0,10)			# double, ≥ 0
	params['RADIUS2'] = random.uniform(0,10)			# double, ≥ 0
	params['AREA2'] = random.uniform(0,10)				# double, ≥ 0

	for (key,val) in params.items():
		print(key + ": " + str(val))

generate_and_print_points()