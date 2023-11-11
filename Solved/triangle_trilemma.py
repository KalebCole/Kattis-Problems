import math
# use distance formula to get points
# note: do not take the square root in order to be more approximate
def get_sides(points1,points2, points3):
    side1 = abs((points2[1]-points1[1])**2 + (points2[0]-points1[0])**2)
    side2 = abs((points3[1]-points2[1])**2 + (points3[0]-points2[0])**2)
    side3 = abs((points3[1]-points1[1])**2 + (points3[0]-points1[0])**2)
    c = max(side1, side2, side3)
    if c == side1:
        a = side2
        b = side3
    elif c == side2:
        a = side1
        b = side3
    else:
        a = side1
        b = side2
    
    return a, b, c


def isTriangle(points1,points2, points3):
    if (points2[1]-points1[1]) * (points3[0]-points2[0]) == (points3[1]-points2[1]) * (points2[0]-points1[0]):
        return False
    return True



n = int(input())




for i in range(n):
    points = [x for x in input().split(" ")]
    points1 = (float(points[0]), float(points[1]))
    points2 = (float(points[2]), float(points[3]))
    points3 = (float(points[4]), float(points[5]))
    
    # determine if it is a triangle
    if not isTriangle(points1,points2,points3):
        print(f"Case #{i+1}: not a triangle")
        continue
    
    a, b, c = get_sides(points1,points2,points3)
    
    
    # determine angle
    if c == a + b:
        angle = "right"
    elif c < a + b:
        angle = "acute"
    elif c > a + b:
        angle = "obtuse"
    
    
    # determine lengths
    if a == b or b == c or a == c:
        length = "isosceles"
    else:
        length = "scalene"
        
    print(f"Case #{i+1}: {length} {angle} triangle")
    
        
        
